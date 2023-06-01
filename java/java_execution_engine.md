# 🚀 Java 실행 엔진

> #### 📃 Java 컴파일 챕터 작은 목차
> - [자바 컴파일 과정](./java_compile_sequence.md)
> - [자바 클래스 로더](./java_class_loader.md)
> - [자바 실행 엔진](./java_execution_engine.md) - 현재 포스트

## 📍 0. 들어가기 전에

- `java 컴파일러`가 **소스 코드**를 **바이트 코드**로 컴파일 한다.
- 클래스 로더에 의해 메모리에 적재된 바이트 코드는 **JVM 실행 엔진**을 통해 실행된다.
- 이 때, 실행 엔진이 각 명령을 실행하기위해 운영체제가 이해 할 수 있는 기계어로 변환하는데, 다음 두 가지 방식이 사용된다.
  1. **인터프리터(Interpreter)**
  2. **JIT(Just In Time)** 컴파일러
  
## 🔍 1. 인터프리터 Interpreter

- 인터프리터는 런타임 시에 JVM 메모리에 올라온 바이트코드를 **한 문장씩 실행**하는데 바이트코드도 기계어가 아니기 때문에 매번 **변환-실행 과정**을 거친다.
- 이 때문에 C 언어 처럼 미리 기계어로 컴파일 되고 실행하는 언어에 비해 **실행 속도가 느려지게된다**.
- 다음과 같은 코드가 있다면 `value++;`실행문을 10만 번 읽고 **매번 번역 하는 셈**이다.

```
int value = 0;
while (value < 100_000) {
    value++; // 10만 번 value++; 실행문을 변환하고 실행한다.
}
```

## 🔍 2. JIT 컴파일러 Just In Time Compiler

- 앞서 설명한 인터프리터는 바이트코드를 실행하기 위해 이미 실행했던 실행문도 다시 읽고 번역하는 과정을 거치기 때문에 **프로그램 실행 속도를 저하시킬 수 있다는 치명적인 단점**을 가지게 된다.
- 이러한 문제점을 보완하기 위해 고안된 것이 바로 `JIT 컴파일러`다.
- 바이트코드 중 빈번하게 접근하는 영역에 대해 런타임중 기계어로 컴파일 하고 컴파일 된 명령문을 캐싱해 같은 부분이 호출되면 캐싱된 데이터로 실행 한다.
- 이 때, JIT 컴파일 과정은 **별도의 스레드**에서 진행된다.

> #### 🧐 Q. JIT 컴파일러는 메소드 호출 시 마다 컴파일 하나요?
> - **A1.** 기본적으로 **메소드의 첫 호출 시점에는 컴파일 하지 않는다**. JIT 컴파일 과정은 메모리와 시간을 소비하고 JVM이 실행되는 시점에 많은 수의 메서드호출이 이루어지는데 이런 메서드 모두를 바로 컴파일해서 캐싱한다면 성능 저하가 발생 할 수 있다.
> - **A2.** JVM은 미리 정의된 `컴파일 임계값`을 가지는데 바이트코드의 특정 영역에 대한 호출 횟수가 `컴파일 임계값`을 넘길때 JIT 컴파일을 진행한다.

---

### 📚 References

- [IBM JIT Compiler](https://www.ibm.com/docs/en/sdk-java-technology/8?topic=reference-jit-compiler)
- [Azul CommandLine Options](https://docs.azul.com/prime/Command-Line-Options)
- [JVM - 실행 엔진(Execution Engine)](https://junhyunny.github.io/information/java/jvm-execution-engine/)
- [JIT(Just In Time) 컴파일러](https://beststar-1.tistory.com/3)
- [자바 JIT 컴파일러](https://velog.io/@youngerjesus/%EC%9E%90%EB%B0%94-JIT-%EC%BB%B4%ED%8C%8C%EC%9D%BC%EB%9F%AC#4-%EC%9E%90%EB%B0%94%EC%99%80-jit-%EC%BB%B4%ED%8C%8C%EC%9D%BC%EB%9F%AC-%EB%B2%84%EC%A0%84)
