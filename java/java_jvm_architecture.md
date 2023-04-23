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

## JVM 구조

![](/java/img/java_jvm_architecture.png)

### 클래스 로더

### 메모리

### 실행 엔진



## Reference

* [자바 가상 머신(JVM)의 동작 방식](https://coding-factory.tistory.com/828)

* [[Java] JVM Architecture란?](https://yeon-kr.tistory.com/112)

* [Understanding JVM Architecture](https://medium.com/platform-engineer/understanding-jvm-architecture-22c0ddf09722)
