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

## 클래스 로더

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

* `Runtime Data Area`는 JVM 프로그램이 실행이 될 때 OS로부터 할당받은 메모리의 영역이다.

* 정확히 말하자면, JVM 안의 `Runtime Data Area`이라는 영역에 할당을 한다는 의미이다.

### 메서드 영역


### 힙 영역



### 스택 영역



### PC 레지스터



### 네이티브 메서드 스택



## 실행 엔진



## Reference

* [자바 가상 머신(JVM)의 동작 방식](https://coding-factory.tistory.com/828)

* [[Java] JVM Architecture란?](https://yeon-kr.tistory.com/112)

* [Understanding JVM Architecture](https://medium.com/platform-engineer/understanding-jvm-architecture-22c0ddf09722)
