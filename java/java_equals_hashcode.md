> [해당 포스팅](https://devfancy.github.io/equals-and-hashcode/)에서도 확인할 수 있습니다. (작성자: 팬시)

# equals와 hashCode 관계

## java.lang 패키지

* `java.lang` 패키지는 자바프로그래밍에서 가장 기본이 되는 클래스를 포함하고 있다.

* 그렇기 때문에 `java.lang` 패키지의 클래스들은 **import문 없이도 사용**할 수 있게 되어 있다.

    * java.lang 패키지에 포함되는 클래스 : Object, String, StringBuffer, StringBuilder, Math, Wrapper

* `java.lang` 패키지의 여러 클래스들 중에서 자주 사용되는 `Object` 클래스와 관련 메서드에 대해 학습해보자.

## Object 클래스

* `Object` 클래스는 **모든 클래스의 최고 조상**이기 때문에 Object 클래스의 멤버들은 모든 클래스에서 바로 사용 가능하다.

* `Object` 클래스는 멤버변수는 없고 오직 11개의 메서드만 가지고 있다. 이 메서드들은 모든 인스턴스가 가져야 할 기본적인 것들이며, 이 중에서 중요한 몇 가지만 살펴보자.

  (11개 메서드에 대해 확인하고 싶으면, "자바의 정석" p.450을 참고하자)

## equals(Object obj)

* equals()는 매개변수로 객체의 **참조변수**를 받아서 비교하여 그 결과를 **boolean 값**으로 알려주는 역할을 한다.

* 아래의 코드는 Object 클래스에 정의되어 있는 equals의 실제 내용이다.

```java
public boolean equals(Object obj){
        return(this == obj);
}
```

* 두 객체의 같고 다름을 **참조변수의 값**으로 판단한다. 그렇기 때문에 서로 다른 두 객체를 `equals` 메서드로 비교하면 항상 **false**를 결과로 얻게 된다.

  `equals` 메서드는 주소값으로 비교하기 때문에, 멤버변수의 값이 서로 같을지라도 참조변수의 값(주소값)이 다르면 false일 수 밖에 없다.

* Object 클래스로부터 상속받은 equals 메서드는 결국 두개의 참조변수가 같은 객체를 참조하고 있는지, 즉 **두 참조변수에 저장된 값(주소값)이 같은지를 판단**하는 기능밖에 할 수 없다는 것을 알 수 있다.

  `equals` 메서드로 인스턴스가 가지고 있는 value 값을 비교하도록 할 수 있는 방법은 **equals 메서드를 오버라이딩하여 주소가 아닌 객체에 저장된 내용을 비교하도록 변경**하면 된다.

```java
class Person {
    long id;
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Person) {
            return id == ((Person) obj.id); // obj가 Object 타입이므로 id 값을 참조하기 위해서는 Person 타입으로 형변환이 필요하다.
        } else
            return false; // 타입이 Person이 아니면 값을 비교할 필요도 없다.
    }
    
    Person(long id) {
        this.id = id;
    }
}

class EqualsEx {
  public static void main(String[] args) {
      Person p1 = new Person(12345L);
      Person p2 = new Person(12345L);
      
      if(p1 == p2)
          System.out.println("p1과 p2는 같은 사람입니다.");
      else 
          System.out.printf("p1과 p2는 다른 사람입니다."); // 첫번째 결과
      
      if(p1.equals(p2)) 
          System.out.println("p1과 p2는 같은 사람입니다."); // 두번째 결과
      else 
          System.out.printf("p1과 p2는 다른 사람입니다.");
  }
}
```

* `equals` 메서드가 Person 인스턴스의 주소값이 아닌 **멤버변수 id의 값을 비교하도록 하기 위해 `equals` 메서드를 다음과 같이 오버라이딩**했다.

  이렇게 함으로써 서로 다른 인스턴스일지라도 같은 id(주민등록번호)를 가지고 있다면, equals 메서드로 비교했을 때, true로 결과를 얻게 할 수 있다.

* `String` 클래스 역시 Obejct 클래스의 equals 메서드를 그대로 사용하는 것이 아니라 이처럼 **오버라이딩을 통해서 String 인스턴스가 갖는 문자열 값을 비교**하도록 되어있다.

  그렇기 때문에 **같은 내용의 문자열**을 갖는 두 String 인스턴스에 equals 메서드를 사용하면 **항상 true 값**을 얻을 수 있다.

## hashCode()

* hashCode 메서드는 `해싱(hashing)기법`에 사용되는 '해시함수(hash function)'을 구현한 것이다.

  해싱은 데이터관리기법 중 하나인데 **다량의 데이터를 저장하고 검색하는데 유용하다**.

* 해시함수는 찾고자 하는 값을 입력하면, 그 값이 저장된 위치를 알려주는 해시코드(hashcode)를 반환한다.

  일반적으로 해시코드가 같은 두 객체가 존재하는 것은 가능하지만, Object 클래스에 정의된 `hashCode` 메서드는 **객체의 주소값을 int 값으로 해시코드를 만들어 반환**하기 때문에 `32 bit JVM`에서는 **서로 다른 두 객체는 결코 같은 해시코드를 가질 수 없었다.**

  하지만 `64 bit JVM`에서는 8 byte 주소값으로 해시코드(4 byte)를 만들 수 있기 때문에 **해시코드가 중복될 수 있다.**

* 앞서 살펴본 것과 같이 **클래스의 `인스턴스 변수 값`으로 객체의 같고 다름을 판단해야 하는 경우**라면 equals 메서드 뿐 만 아니라 **`hashCode` 메서드도 적절히 오버라이딩해야 한다.**

  같은 객체라면 hashCode 메서드를 호출했을 때의 결과값인 해시코드도 같아야 하기 때문이다.

```java
class HashCodeEx {
  public static void main(String[] args) { 
      String str1 = new String("hello");
      String str2 = new String("hello");

      System.out.println(str1.hashCode()); // 12345
      System.out.println(str2.hashCode()); // 12345
  }
}
```

* `String` 클래스는 **문자열의 내용이 같으면, 동일한 해시코드를 반환**하도록 `hashCode` 메서드가 오버라이딩되어 있기 때문에, 문자열 내용이 같은 str1과 str2에 대해 `hashCode()`를 호출하면 항상 동일한 해시코드값을 얻는다.

  반면에 `Object` 클래스의 `hashCode` 메서드처럼 **객체의 주소값으로 해시코드를 생성**하기 때문에 모든 객체에 대해 항상 다른 해시코드값을 반환할 것을 보장한다.

> 참고: `해싱기법`을 사용하는 **HashMap이나 HashSet과 같은 클래스에 저장할 객체라면 반드시 `hashCode` 메서드를 오버라이딩 해야한다.** - 자바의 정석 11장. 컬렉션 프레임웍 -

## equals와 hashCode를 같이 재정의 해야하는 이유

### equals만 재정의할 경우

우선 예제로 사용될 Product 클래스를 살펴보자.

```java
public class Product {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    // intellij Generate 기능 사용
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }
}
```

* Product 클래스에는 equals만 재정의했다.

```java
public static void main(String[] args){
    Product product1 = new Product("아메리카노");
    Product product2 = new Product("아메리카노");
    
    // true 출력
    System.out.println(product1.equals(product2));
}
```

* equals를 재정의했기 때문에 Product 객체의 name이 같은 product1, product2 객체는 **논리적으로 같은 객채로 판단**된다.

* 이제 아래 main 메서드의 출력 결과를 예측해보자.

```java
public static void main(String[] args) {
    List<Product> products = new ArrayList<>();
        products.add(new Product("아메리카노"));
        products.add(new Product("아메리카노"));

    System.out.println(products.size());
}
```

* Product 객체를 2개 `List<Product> products`에 넣어줬으니 출력 결과는 당연히 2일 것이다.

* 그렇다면 이번엔 Collection에 중복되지 않는 Product 객체만 넣으라는 요구사항이 추가되었다고 가정해보자.

* 요구사항을 반영하기 위해 List에서 중복 값을 허용하지 않는 Set으로 로직을 바꿨다.

```java
public static void main(String[] args) {
    Set<Product> products = new HashSet<>();
        products.add(new Product("아메리카노"));
        products.add(new Product("아메리카노"));

    System.out.println(products.size());
}
```

* 추가된 두 Product 객체의 이름이 같아서 논리적으로 같은 객체라 판단하고 HashSet의 size가 1이 나올거라 예상했지만, **예상과 다르게 2가 출력된다.**

* hashCode를 equals와 함께 재정의하지 않으면 코드가 예상과 다르게 동작하는 위와 같은 문제를 일으킨다.

* 정확히 말하면 **hash 값을 사용하는 Collection(HashSet, HashMap, HashTable)을 사용할 때 문제가 발생한다.**

### 문제가 발생하는 이유

* hash 값을 사용하는 Collction(HashMap, HashSet)은 객체가 논리적으로 같은지 비교할 때 아래 그림과 같은 과정을 거친다.

![](/java/img/java_hashCode-equals.png)

* **[1] hashCode 메서드의 리턴 값이 우선 일치하고 [2] equals 메서드의 리턴 값이 true**여야 논리적으로 `같은 객체`라고 판단한다.

* 앞서 봤던 main 메서드의 HashSet에 Product 객체를 추가할 때도 위와 같은 과정으로 중복 여부를 판단하고 HashSet에 추가됐다.

  다만 Product 클래스에는 hashCode 메서드가 재정의 되어있지 않아서 Object 클래스의 hashCode 메서드가 사용되었다.

  Object 클래스의 hashCode 메서드는 **`객체의 고유한 주소 값`을 int 값으로 변환**하기 때문에 **객체마다 다른 값을 리턴한다.**

  두 개의 Product 객체는 equals로 비교도 하기 전에 서로 다른 hashCode 메서드의 리턴 값으로 인해 다른 객체로 판단된 것이다.

### 해결방안: hashCode 오버라이딩

* 앞서 살펴봤던 문제를 해결하기 위해 Product 클래스에 hashCode 메서드를 아래와 같이 재정의했다.

```java
public class Product {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    // intellij Generate 기능 사용
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
      Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
```

* intellij 의 Generate 기능을 사용했더니 Objects.hash 메서드를 호출하는 로직으로 hashCode 메서드가 재정의 됐다.

  Objects.hash 메서드는 hashCode 메서드를 재정의하기 위해 **간편히 사용할 수 있는 메서드이지만 속도가 느리다.**

  인자를 담기 위한 배열이 만들어지고 인자 중 기본 타입이 있다면 **박싱과 언박싱도 거쳐야 하기 때문**이다.

* 성능에 아주 민감하지 않은 대부분의 프로그램은 간편하게 Objects.hash 메서드를 사용해서 hashCode 메서드를 재정의해도 문제 없다.

  민감한 경우에는 직접 재정의해주는 게 좋다. (관련 정보 - [Guide to hashCode() in Java](https://www.baeldung.com/java-hashcode))

### 무조건 재정의해야 할까?

* 'hash 값을 사용하는 Collection을 사용하지 않는다면, equals와 hashCode를 같이 재정의(오버라이딩)하지 않아도 되는건가?' 라고 생각할 수 있다.

* 사용자정의 클래스를 작성할 때 equals 메서드를 오버라이딩해야 한다면, hashCode()도 클래스의 작성의도에 맞게 재정의하는 것이 원칙이지만, 요구사항에 따라 할지 말지 결정하면 된다.

  (만약 Collection을 사용한다면 재정의 해주는게 맞다고 생각한다)

## Reference

* [자바의 정석](https://product.kyobobook.co.kr/detail/S000001550352) - 9장. java.lang 패키지와 유용한 클래스 / 11장. 컬렉션 프레임웍

* [Java 공식문서: HashMap](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)

* [Tecoble: equals와 hashCode는 왜 같이 재정의해야 할까?](https://tecoble.techcourse.co.kr/post/2020-07-29-equals-and-hashCode/)