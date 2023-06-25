## N + 1 문제란?
`정의` : N+1 문제란, ORM(Object-Relational Mapping)을 사용하는 애플리케이션에서 관계형 데이터베이스와의 데이터 조회 작업에서 발생할 수 있는 성능 문제  

N+1 문제는 한 번의 초기 쿼리 실행으로 가져온 데이터를 사용하는 도중 추가로 N번의 쿼리를 실행해야 하는 상황을 말한다. 
이로 인해 데이터베이스와의 불필요한 네트워크 통신이 발생하며, 성능 저하와 불필요한 데이터베이스 부하를 초래할 수 있습니다.

### Author-Book Entity 시나리오
- 작가와 책 Entity 생성
- 작가는 책을 여러개 작성할 수 있다
- 하나의 하나의 작가에 종속된다

```
@Entity
public class Author {
    // ...
    
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<Book> books;
    
    // ...
}

@Entity
public class Book {
    // ...
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;
    
    // ...
}
```

### Mock 데이터 생성 및 테스트
```
// Mock 데이터 생성
Author author = new Author("John Smith");
Book book1 = new Book("Book 1", author);
Book book2 = new Book("Book 2", author);
List<Book> books = Arrays.asList(book1, book2);

// 저장
authorRepository.save(author);
bookRepository.saveAll(books);

// 조회
Author retrievedAuthor = authorRepository.findById(author.getId()).orElse(null);

// 결과 출력
System.out.println(retrievedAuthor.getName()); // John Smith
System.out.println(retrievedAuthor.getBooks().size()); // 2
```

### SQL log 확인
```
// 초기 쿼리 (Author 조회)
SELECT * FROM author WHERE id = 1;

// 추가 쿼리 (Books 조회)
SELECT * FROM book WHERE author_id = 1;
SELECT * FROM book WHERE author_id = 1;
```
- id가 1인 작가를 찾는 쿼리문을 호출했는데, 작가가 보유한 책 만큼 책을 호출하는 쿼리문이 출력된 걸 확인할 수 있다

### FetchType을 LAZY로 변경
```
public class Author {
    // ...
    
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Book> books;
    
    // ...
}
```

### SQL log 확인
```
// 초기 쿼리 (Author 조회)
SELECT * FROM author WHERE id = 1;

// 추가 쿼리 (Books 조회)
SELECT * FROM book WHERE author_id = 1;
SELECT * FROM book WHERE author_id = 1;
```
- 똑같은 결과..😥

### FetchType.EAGER vs FetchType.LAZY
- FetchType.EAGER의 경우 순서는 다음과 같다
    1. JPQL에서 만든 SQL을 통해 데이터를 조회
    2. 이후 JPA에서 Fetch 전략을 가지고 해당 데이터의 연관 관계인 하위 엔티티들을 추가 조회
    3. 2번 과정으로 N + 1 문제 발생

- FetchType.LAZY의 경우 순서는 다음과 같다
    1. JPQL에서 만든 SQL을 통해 데이터를 조회
    2. JPA에서 Fetch 전략을 가지지만, 지연 로딩이기 때문에 추가 조회는 하지 않음
    3. 하지만, 하위 엔티티를 가지고 작업하게 되면 추가 조회가 발생하기 때문에 결국 N + 1 문제 발생

### N + 1 발생 원인은..?
JpaRepository에 정의한 인터페이스 메서드를 실행하면 JPA는 메서드 이름을 분석해서 JPQL을 생성하여 실행하게 된다. JPQL은 SQL을 추상화한 객체지향 쿼리 언어로서 특정 SQL에 종속되지 않고 엔티티 객체와 필드 이름을 가지고 쿼리를 한다.   
그렇기 때문에 JPQL은 findAll()이란 메소드를 수행하였을 때 해당 엔티티를 조회하는 `select * from Author` 쿼리만 실행하게 되는것이다.   
JPQL 입장에서는 연관관계 데이터를 무시하고 해당 엔티티 기준으로 쿼리를 조회하기 때문이다.   
그렇기 때문에 연관된 엔티티 데이터가 필요한 경우, FetchType으로 지정한 시점에 조회를 별도로 호출하게 된다.

### 해결 방법
### Fetch join
```
// Fetch join을 사용한 코드
@Entity
public class Author {
    // ...

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private List<Book> books;

    // ...
}

// Fetch join을 적용한 조회
@EntityGraph(attributePaths = "books")
Optional<Author> retrievedAuthor = authorRepository.findByIdWithBooks(author.getId());

// 결과 출력
System.out.println(retrievedAuthor.get().getName()); // John Smith
System.out.println(retrievedAuthor.get().getBooks().size()); // 2
```

- Author 엔티티에서 books 필드에 Fetch join을 적용하여 작가와 연관된 책을 한 번에 가져옵니다.
- authorRepository.findByIdWithBooks() 메서드는 Fetch join이 적용된 쿼리를 실행하여 작가와 연관된 책의 정보를 함께 가져옵니다.

**단점**
- Fetch join은 필요한 모든 연관 엔티티를 한 번에 가져오기 때문에 데이터의 양이 많을 경우 성능 저하가 발생할 수 있습니다. 
- Fetch join은 JPA 구현체에 의존하기 때문에 이식성이 떨어질 수 있습니다.

### EntityGraph
```
// EntityGraph를 사용한 코드
@Entity
public class Author {
    // ...
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private List<Book> books;

    // ...
}

// EntityGraph를 적용한 조회
EntityGraph<Author> entityGraph = entityManager.createEntityGraph(Author.class);
entityGraph.addAttributeNodes("books");

Map<String, Object> properties = new HashMap<>();
properties.put("javax.persistence.fetchgraph", entityGraph);

Author retrievedAuthor = entityManager.find(Author.class, author.getId(), properties);

// 결과 출력
System.out.println(retrievedAuthor.getName()); // John Smith
System.out.println(retrievedAuthor.getBooks().size()); // 2
```

- Author 엔티티에서 books 필드에 EntityGraph를 적용하여 작가와 연관된 책을 한 번에 가져오는 방식입니다. 
- EntityGraph를 사용하여 작가 엔티티 조회 시 즉시 필요한 연관 엔티티를 로드할 수 있습니다.

**단점**
- EntityGraph는 NamedEntityGraph를 정의하고 사용해야 하므로 추가 작업이 필요합니다. 
- EntityGraph는 동적인 쿼리 생성이 제한적일 수 있습니다.

### BatchSize
```
// BatchSize를 사용한 코드
@Entity
public class Author {
    // ...

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    @BatchSize(size = 10)
    private List<Book> books;

    // ...
}

// BatchSize를 적용한 조회
Author retrievedAuthor = authorRepository.findById(author.getId()).orElse(null);
Hibernate.initialize(retrievedAuthor.getBooks());

// 결과 출력
System.out.println(retrievedAuthor.getName()); // John Smith
System.out.println(retrievedAuthor.getBooks().size()); // 2
```

- Author 엔티티에서 books 필드에 BatchSize를 적용하여 일괄 로딩을 수행하는 방식입니다. 
- @BatchSize 어노테이션을 사용하여 한 번의 쿼리로 지정된 개수의 연관 엔티티를 로드합니다.

**단점**
- BatchSize는 일괄 로딩을 수행하지만, 연관 엔티티가 많은 경우 여전히 N+1 문제가 발생할 수 있습니다. 
- 성능을 향상시키기 위해 적절한 BatchSize 값을 설정해야 합니다.

### QueryBuilder
```
// QueryBuilder를 사용한 코드
CriteriaBuilder cb = entityManager.getCriteriaBuilder();
CriteriaQuery<Author> query = cb.createQuery(Author.class);
Root<Author> root = query.from(Author.class);
root.fetch("books", JoinType.LEFT);
query.select(root).where(cb.equal(root.get("id"), author.getId()));

Author retrievedAuthor = entityManager.createQuery(query).getSingleResult();

// 결과 출력
System.out.println(retrievedAuthor.getName()); // John Smith
System.out.println(retrievedAuthor.getBooks().size()); // 2
```

- Criteria API를 사용하여 작가와 연관된 책을 함께 조회하는 방식입니다. 
- QueryBuilder를 통해 작가와 연관된 책의 정보를 로드하고, 한 번의 쿼리로 결과를 가져옵니다.

**단점**
- QueryBuilder를 사용하면 복잡한 쿼리 작성이 필요하고, JPA의 객체 지향적인 특성을 잃을 수 있습니다.
- 유지보수가 어려울 수 있습니다.

---

📢 면접 질문들
- 💡 FetchType.EAGER와 FetchType.LAZY의 차이점은 무엇인가요?
    - FetchType.EAGER는 연관 엔티티를 즉시 로딩하는 것을 의미하며, FetchType.LAZY는 연관 엔티티를 필요한 시점에 지연 로딩하는 것을 의미합니다
- 💡 N+1 문제를 해결하기 위한 방법 중 하나인 Fetch join에 대해 설명해주세요
    - Fetch join은 JPA에서 제공하는 기능으로, 한 번의 쿼리로 연관 엔티티를 함께 로딩하는 방식입니다. Fetch join을 사용하면 추가적인 쿼리 호출 없이 필요한 데이터를 한 번에 가져올 수 있어 N+1 문제를 해결할 수 있습니다

---
📌 Reference
- [Incheol's TECH BLOG](https://incheol-jung.gitbook.io/docs/q-and-a/spring/n%252B1)
- [coco3o](https://dev-coco.tistory.com/165)
