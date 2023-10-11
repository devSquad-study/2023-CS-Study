## JVM

* `자바 가상 머신`이라고 불리는 JVM은 자바 프로그램을 실행하고, 다른 언어로 작성된 것도 자바 byte code로 컴파일하여 실행할 수 있도록 만들어주는 소프트웨어이다.

* 자바 코드를 컴파일하여 .class 바이트 코드로 만들면 이 코드가 자바 가상 머신 환경에서 실행된다.

## JVM의 작동 방식

![](/java/img/java_jvm.png)

* [1] 자바로 개발된 프로그램을 실행하면 JVM은 OS로부터 메모리를 할당한다.

* [2] 자바 컴파일러(javac)가 자바 소스코드(.java)를 자바 바이트코드(.class)로 컴파일 한다.

* [3] Class Loader를 통해 JVM Runtime Data Area로 로딩한다.

* [4] Runtime Data Area로 로딩된 .class들은 Execution Engine을 통해 해석한다.

* [5] 해석된 바이트 코드는 Runtime Data Area의 각 영역에 배치되어 수행하며 이 과정에서 Execution Engine에 의해 GC의 작동과 스레드 동기화가 이루어진다.

> JVM 구조

![](/java/img/java_jvm_architecture.png)

## 클래스 로더 시스템

* 기본적으로 자바 프로그램들은 클래스들로 이루어져 있다. IDE에서 프로그래머가 작성한 코드를 컴파일하면, JVM이 읽을 수 있는 .class 파일이 된다.

* 클래스 로더는 이렇게 **생성된 클래스 파일들을 엮어서 JVM이 OS로부터 할당받은 메모리 영역인 `Runtime Data Area`로 적재하는 역할**을 한다.

* 클래스 파일들은 Runtime이 될 때, **load(적재), links(연결), initialize(초기화)** 의 과정을 거치게 된다.

### 적재(Loading)

* 클래스 로더의 주요한 일은 컴파일된 클래스를 메모리에 적재한다.

* Loading의 작업은 보통 static main() 메서드로부터 시작된다. 이미 로딩된 클래스는 unload 될 수 없다.

### 연결(Linking)

* 로드된 클래스나 인터페이스를 검증하고 준비하는 과정이다.

* 링크는 아래의 3가지의 단계로 실행된다.

* 3단계 : 검증(Verification) -> 준비(Preparation) -> 실행(Resolution)

    * 검증 : 컴파일러가 변환된 바이트 코드가 바이너리 코드로 잘 변환을 했는지, 확인하는 과정이다.

    * 준비 : JVM에 의한 데이터 구조나 Static 저장 공간을 위해서 메모리를 할당하는 과정이다.

    * 실행 : Symbolic reference가 direct reference로 대체된다. 즉, 실제 객체의 주소를 참조하게 된다.

### 초기화(Initialize)

* 클래스나 인터페이스의 초기화 로직이 실행된다.

* 이는 링크 단계에서 기본 값으로 초기화된 Static 변수들을 프로그래머가 입력한 값으로 정의해준다.

## 메모리

* `런타임 데이터 영역`는 JVM 프로그램이 실행이 될 때 OS로부터 할당받은 메모리의 영역이다.

* 정확히 말하자면, `런타임 데이터 영역`은 JVM의 메모리 영역으로 **자바 애플리케이션을 실행할 때 사용되는 데이터들을 적재**하는 영역이다.

![](/java/img/java_jvm_architecture_runtime_data_area.png)

모든 스레드가 공유해서 사용(GC의 대상)

* 힙 영역(Heap Area)

* 메서드 영역(Method Area)

스레드마다 하나씩 생성

* 스택 영역(Stack Area)

* PC 레지스터(PC Register)

* 네이티브 메서드 스택(Native Method Stack)

### 메서드 영역

* `메서드 영역`은 JVM이 시작될 때 생성되는 공간으로 **바이트 코드(.class)** 를 처음 메모리 공간에 올릴 때 **초기화되는 대상을 저장**하기 위한 메모리 공간이다.

* JVM이 동작하고 클래스가 로드될 때 적재되서 **프로그램이 종료될 때까지 저장**된다.

* 클래스 수준의 정보(클래스 이름, 부모 클래스 이름, 메서드, 변수)를 저장한다.

* 다른 Thread 사이에서 공유되는 자원이다.

> Method 영역에 저장하는 데이터

1. Type 정보(Class, Interface, Enum)

2. 메서드와 변수

3. FQCN(Fully Qualified Clss Name)

> `FQCN` 는 object, 함수, 변수의 계층적 구조를 모두 포함하여 표현하는 것을 말한다.

```java
package devfancy.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// 일반적인 사용법
@SpringBootApplication
public class GidhubApplication {
  public static void main(String[] args) {
    // FQCN 사용 O
    org.springframework.boot.SpringApplication.run(GidhubApplication.class, args);

    // FQCN 사용 X
    SpringApplication.run(GidhubApplication.class, args);
    
    // 자바로 표현
    // FQCN 사용 O
    String fancy = new String();
    
    // 일반적인 사용법(FQCN 사용 X)
    java.lang.String fancy = new java.lang.String();
  }
}

```

### 힙 영역

1. new 키워드로 생성된 객체와 배열이 생성되는 영역이다.
2. 주기적으로 GC가 제거하는 영역이다.

![](/java/img/java_jvm_architecture_heap_area.png)

* Heap Area는 **효율적인 GC**를 위해 위와 같이 크게 3가지의 영역으로 나뉘게 된다.

* [1] `Young Generation` : 영역은 자바 객체가 생성되자마자 저장되고, 생긴지 얼마 안되는 객체가 저장되는 공간이다.

  Heap 영역에 객체가 생성되면 최초로 Eden 영역에 할당된다. 그리고 이 영역에 데이터가 어느정도 쌓이게 되면 참조정도에 따라 Servivor의 빈 공간으로 이동되거나 회수된다.

  Young Generation 영역이 차게 되면 참조 정도에 따라 Tenured Generation(Old) 영역으로 이동되거나 회수된다.

  Young Generation과 Tenured Generation 에서의 GC를 `Minor GC` 라고 한다.

* [2] `Tenured Generation` : Old 영역에 있는 모든 객체들을 검사하여 참조되지 않는 객체들을 한꺼번에 삭제하는 GC가 실행된다.

  시간이 오래 걸리는 작업이고, 이때 GC를 실행하는 스레드를 제외한 모든 스레드는 작업을 멈추게 된다. 이를 `Stop-the-Wolrd`라 부른다.

  그리고 이렇게 `Stop-the-World`가 발생하고 Old영역의 메모리를 회수하는 GC를 `Major GC`라고 한다.

### 스택 영역

* 지역변수, 파라미터, 리턴 값, 연산에 사용되는 임시 값 등이 생성되는 영역이다.

### PC 레지스터

* Thread가 생성될 때마다 생성되는 영역으로 프로그램 카운터, 즉 현재 스레드가 실행되는 부분의 주소와 명령을 저장하고 있는 영역이다.

### 네이티브 메서드 스택

1. **자바 이외의 언어(C, C++, 어셈블리 등)로 작성된 네이티브 코드**를 실행할 때 사용되는 메모리 영역으로 **일반적인 C 스택**을 사용한다.
2.  보통 **C/C++ 등의 코드를 수행하기 위한 스택**을 말하며 (JNI) 자바 컴파일러에 의해 변환된 자바 바이트 코드를 읽고 해석하는 역할을 하는 것이 `자바 인터프리터`(interpreter)이다.

## 실행 엔진

* 클래스 로더에 의해 JVM으로 로드된 .class 파일(바이트코드)들은 Runtime Data Areas의 Method Area에 배치되는데, 

  배치된 이후에 JVM은 Method Area의 바이트 코드를 실행 엔진(Execution Engine)에 제공하여, 정의된 내용대로 바이트 코드를 실행시킨다.

  이때, 로드된 바이트코드를 실행하는 런타임 모듈이 `실행 엔진(Execution Engine)`이다. 실행 엔진은 바이트코드를 명령어 단위로 읽어서 실행한다.

## 가비지 컬렉터

![](/java/img/java_jvm_architecture_garbage_collector.png)

* 자바 가상 머신은 가비지 컬렉터(garbage collector)를 이용하여 더는 사용하지 않는 메모리를 자동으로 회수해 준다.

  따라서 개발자가 따로 메모리를 관리하지 않아도 되므로, 더욱 손쉽게 프로그래밍을 할 수 있도록 도와준다.

  Heap 메모리 영역에 생성(적재)된 객체들 중에 참조되지 않은 객체들을 탐색 후 제거하는 역할을 하며 

  해당 역할을 하는 시간은 정확히 언제인지를 알 수 없다. 

  GC역할을 수행하는 스레드를 제외한 나머지 모든 스레드들은 일시정지상태가 된다.

* 간단히 말하면, **더이상 참조되지 않는 객체를 정리**한다는 의미다.

## 정리

* JVM 구조에 대한 개념은 굉장히 어려운 개념이자 내용이 광범위하므로 해당 포스팅에서는 Rough하게 다뤘다.

* 추후에 시간이 남는다면, JVM에 대해 깊게 다뤄서 정리할 예정이다. 

## 예상 질문

* JVM 개념과 역할에 대해 설명해 주세요.

* JVM의 작동 방식에 대해 설명해 주세요.

## Reference

* [자바 가상 머신(JVM)의 동작 방식](https://coding-factory.tistory.com/828)

* [JVM 구조](https://goodgid.github.io/Java-JVM/)

* [[Java] JVM Architecture란?](https://yeon-kr.tistory.com/112)

* [Understanding JVM Architecture](https://medium.com/platform-engineer/understanding-jvm-architecture-22c0ddf09722)
