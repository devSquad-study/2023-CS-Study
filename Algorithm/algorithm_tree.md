> 작성자 : 팬시 / [출처](https://fancy96.github.io/DataStructure-Tree/)

> 이 글의 코드와 정보들은 책을 공부하며 정리한 내용을 토대로 작성하였습니다.

## 트리

* `트리`는 0개 이상의 다른 노드에 대한 레퍼런스가 들어 있는 노드(데이터 원소)로 구성된다.

* 트리를 그림으로 표현하면 아래와 같다.

<img src = "img/algorithm_tree-1.png" width="500px"/>

* 연결 리스트에서와 마찬가지로 `노드`는 구조체 또는 클래스로 표현되며, 트리는 포인터 또는 레퍼런스만 있다면 어떤 언어로든 구현할 수 있다.

* 객체지향 언어에서는 보통 노드의 공통적인 부분을 하나의 클래스로 정의하고, 노드에 들어가는 데이터를 위해 서브클래스를 만들어서 사용한다.

* 실제 코딩을 할 때는 children은 비공개(private)로 선언하고 그 배열을 건드리기 위한 메서드만 공개하는 방법을 써야 할 것이다.

* 정수가 저장되는 클래스를 메서드와 생성자를 모두 제대로 갖춘 **자바**로 만든다면 다음과 같은 식의 코드를 쓰면 된다.

```java
public abstract class Node {
    private Node[] children;
    
  public Node( Node[] children) {
      this.children = children;
  }
  
  public int getNumChildren() {
      return children.length;
  }
  
  public Node getChildren(int index) {
      return children[index];
  }
}

public class IntNode extends Node {
    private int value;
    
    public IntNode (Node [] children, int value) {
        super(children);
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
```

* 다음은 [그림 6-1]을 참고해서 트리와 관련된 용어들을 몇 가지 정리했다.

<img src = "img/algorithm_tree-2.png" width="500px"/>

* 부모(Parent) : 다른 노드를 가리키는 노드는 그 노드의 부모가 된다. 루트를 제외한 모든 노드에는 부모가 하나씩 있다.

    * [그림 6-1]에서 B는 D, E, F의 부모 노드가 된다.

* 자식(Child) : 루트를 제외한 모든 노드는 그 노드를 가리키는 노드의 자식이 된다.

    * [그림 6-1]에서 D, E, F는 B의 자식 노드가 된다.

* 자손(Descendant) : 특정 노드로부터 자식 노드로 이어지는 경로를 따라 도달할 수 있는 모든 노드는 그 특정 노드의 자손이다.

    * [그림 6-1]에서 D, E, F, H, I, J, K는 모두 B의 자손이다.

* 조상(Ancestor) : 어떤 노드를 자손으로 삼고 있는 노드는 모두 그 노드의 조상이다.

    * 예를 들어 A, B, D는 모두 I의 조상이다.

* 잎(Leaves) : 자식이 없는 노드를 잎이라고 부른다. G, H, I, K는 모두 잎이다.


## 이진 트리

* 실전에서는 면접관이 **트리**라고 하면 보통 `이진 트리(binary tree)`라는 트리의 한 종류를 일컫는 경우가 많다.

* 이진 트리는 한 노드에 **자식이 최대 2개**까지만 있을 수 있으며, 그 두 자식은 각각 왼쪽 자식(left subtree)과 오른쪽 자식(right subtree)이라고 부른다.

* [그림 6-2]에 이진 트리의 예가 나와있다.

<img src = "img/algorithm_tree-3.png" width="500px"/>

* 이진 트리를 간단하게 구현하면 다음과 같다. 편의상 한 클래스에 모든 것을 집어넣었다.

```java
public class Node {
    private Node left;
    private Node right;
    private int value;
    
    public Node(Node left, Node right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
    
    public Node getLeft() {
        return left;
    }
    public Node getRight() {
        return right;
    }
    public Node getValue() {
        return value;
    }
}
```

* 어떤 원소에 왼쪽 또는 오른쪽 자식이 없으면 left or right에 NULL 레퍼런스를 집어넣는다.

## 이진 트리 속성

* 교재마다 시작 레벨을 다르게 하는 경우가 많은데, 여기서는 시작 레벨을 `1`로 가정한다고 치자.

<img src = "img/algorithm_tree-4.png" width="500px"/>

* [1] 이진 트리의 레벨 i번째의 최대 노드 갯수는 **$2^{i-1}$** 이다. (단, i >=1 인 경우) 예를 들어 레벨이 3인 경우, 레벨 3의 최대 노드 갯수는 $2^{3-1} = 4$이다.

* [2] 높이 k인 이진 트리의 최대 노드 갯수는 **$2^{k} -1$** 이다. (단, k >=1 인 경우) 예를 들어 높이가 3인 경우, 전체 노드의 최대 갯수는 $2^{3} - 1 = 7$이다.

## 이진 검색 트리

* 트리를 써서, **정렬된**, 또는 **순서가 정해진 자료를 저장**하는 경우를 흔하게 볼 수 있다.

* 그중에서도 트리에 데이터를 저장할 때 가장 흔하게 쓰이는 것은 `이진 검색 트리`(BST, Binary Search Tree)이다.

* BST에서는 노드의 왼쪽 자식의 값이 **반드시 자신의 값 이하**이며, 오른쪽 자신의 값은 **반드시 자신의 값 이상**이다.

* 즉, BST의 데이터는 값으로 정렬된다.

<img src = "img/algorithm_tree-5.png" width="500px"/>

* Key = {5, 3, 1, 4, 10, 7, 12}로 주어진다면, 아래와 같이 [그림 6-3]으로 나타낼 수 있다.

<img src = "img/algorithm_tree-6.png" width="500px"/>

* 이진 검색 트리의 장점 가운데 하나로 **룩업 연산**(lookup, 트리에 있는 특정 노드의 위치를 알아내는 연산)을 빠르고 간단하게 처리할 수 있다는 점을 들 수 있다.

* 이런 장점은 **자료를 저장**할 때 그 위력을 발휘한다.

* BST에서 룩업을 수행하는 알고리즘을 간략하게 적어 보면 다음과 같다.

```markdown
루트 노드에서 시작
현재 노드가 널이 아닌 동안 반복
    현재 노드의 값이 찾고자 하는 값이면
        현재 노드 리턴
    현재 노드의 값이 찾고자 하는 값보다 작으면
        오른쪽 자식을 현재 노드로 설정
    현재 노드의 값이 찾고자 하는 값보다 크면
        왼쪽 자식을 현재 노드로 설정
반복문 끝
```


##  Reference

* [프로그래밍 면접 이렇게 준비한다: p.152 - p.162](http://www.yes24.com/Product/Goods/75187284)

* [Fundamentals of data structures in C, 2nd edition - Trees](https://www.amazon.com/Fundamentals-Data-Structures-Ellis-Horowitz/dp/0929306406)
