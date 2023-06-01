# 🚀 Java 클래스 로더

> #### 📃 Java 컴파일 챕터 작은 목차
> - [자바 컴파일 과정](./java_compile_sequence.md)
> - [자바 클래스 로더](./java_class_loader.md) - 현재 포스트
> - [자바 실행 엔진](./java_execution_engine.md)

## 📍 0. 들어가기 전에

Java는 **컴파일 시점이 아닌 런타임 시점에 클래스를 로드하고 링크 하는 동적 로딩 방식**을 사용한다.  
이 때 각 클래스를 동적으로 로드하는 역할을 `클래스 로더`가 담당한다.  
**동적 로딩**은 `로딩` - `링크` - `초기화` 과정을 거쳐 명령을 실행한다.

- ### 로딩
  - 바이트코드를 메서드 영역에 적재한다.
  - JVM은 메서드 영역에 읽어온 바이트 코드들의 정보를 저장한다.
    - 로드된 클래스와 그 부모 클래스 정보.
    - 클래스 파일과 Class, Interface, Enum 관련 여부.
    - 변수나 메서드 정보.
- ### 링크
  - 검증
    - 읽어온 클래스가 자바 및 JVM 명세에 명시된 대로 잘 구성됐는지 검사한다.
  - 준비
    - 클래스가 필요로 하는 메모리를 할당하고 정의된 클래스, 인터페이스, 필드, 메서드를 나타내는 데이터 구조를 준비한다.
  - 분석
    - 심볼릭 메모리 레퍼런스를 메서드 영역 내 실제 레퍼런스로 바꾼다.
- ### 초기화
  - 클래스 변수들을 적절한 값으로 초기화 한다. -> 정적 필드를 설정된 값으로 초기화 한다.

## 🔍 1. 종류

### 1.1 부트스트랩 클래스 로더 Bootstrap Class Loader

클래스 로더 계층 구조 상 최상위 계층 클래스 로더.  
자바 클래스를 로드 할 수 있는 자바 자체의 클래스 로더와 Object 클래스를 로드한다.

- #### ~ Java 8
  - `/jre/lib/rt.jar` 와 기타 핵심 라이브러리 등 JDK 내부 클래스를 로드한다.
- #### Java 9 ~
  - `/rt.jar` 가 `/lib` 내에 모듈화 되어 포함되어 자바 자체의 클래스 로더만 로드한다.

### 1.2 확장 클래스 로더 Extension Class Loader -> Java 9 부터 Platform Class Loader 로 변경

부트스트랩 클래스 로더의 자식 클래스 로더로 확장 자바 클래스를 로드한다.

> 기본적으로 `${JAVA_HOME}/jre/lib/ext` 내 클래스들을 로드하고, `java.ext.dirs`환경변수를 통해 로드 할 디렉토리를 설정 할 수 있다.

- #### ~ Java 8
  - `URLClassLoader`를 상속받고 설정된(혹은 기본) 디렉토리 내 모든 클래스를 로드한다.
- #### Java 9 ~
  - `PlatformClassLoader`로 변경되었고 `URLClassLoader`가 아닌 `BulletinClassLoader`를 상속받아 Inner Static 클래스로 구현되어있다.

### 1.3 시스템 클래스 로더 System Class Loader

사용자가 지정한 ${CLASSPATH}의 클래스를 로드한다.

### 1.4 사용자 정의 클래스 로더 User-Defined Class Loader

클래스 로더 중 최하위 계층으로, 애플리케이션 레벨에서 사용자가 직접 정의하고 생성한 클래스 로더.

## 💡 2. 동작 방식

새로운 클래스를 로드할 경우 다음과 같은 절차를 따른다.

- 메서드 영역에 클래스가 적재돼있는지 확인한다. 있다면 그대로 사용한다.
- 메서드 영역에서 찾을 수 없을 경우 `시스템 클래스 로더`에 요청하고 `시스템 클래스 로더`는 `확장 클래스 로더`에 요청을 넘긴다.
- `확장 클래스 로더`는 `부트스트랩 클래스 로더`에 요청을 넘기고 `부트스트랩 클래스 로더`는 `부트스트랩 경로(/jre/lib)`에 해당 클래스가 존재하는지 확인한다.
- 클래스가 없다면 다시 `확장 클래스 로더`로 요청을 넘기고 확장 클래스 로더는 확장 경로(/jre/lib/ext)에서 찾아본다.
- `확장 클래스 로더`에서도 찾을 수 없다면 `시스템 클래스 로더`에서 시스템 경로에서 찾는다. 이 때 찾을 수 없다면 `ClassNotFoundException`을 발생시킨다.

> ### 클래스 로더 동작 확인
> - #### 실행
>   - 다음과 같이 어떤 클래스 로더가 로드했는지 알 수 있다.
>   - `zulu-17`을 기준으로 작성했다.
>     ```
>     System.out.println(Object.class.getClassLoader() + " loads Object.class");
>     System.out.println(SQLData.class.getClassLoader() + " loads SQLData.class");
>     System.out.println(Main.class.getClassLoader() + " loads Main.class");
>     ```
> - #### 결과
>   - `null` 은 `부트스트랩 클래스 로더`.
>     ```
>     null loads Object.class
>     jdk.internal.loader.ClassLoaders$PlatformClassLoader@5305068a loads SQLData.class
>     jdk.internal.loader.ClassLoaders$AppClassLoader@251a69d7 loads Main.class
>     ```

## 🚧 3. 클래스 로더 3원칙

### 3.1 위임 원칙

- 클래스 로더는 리소스를 찾을 때 상위 클래스 로더로 요청을 위임한다.

### 3.2 가시 범위 원칙

- 하위 클래스 로더는 상위 클래스 로더가 로드한 클래스를 알 수 있지만 상위 클래스 로더는 하위 클래스 로더가 로드한 클래스를 알 수 없다.
- 상위 클래스 로더에서 로드한 클래스를 하위 클래스 로더가 사용할 수 있다.

### 3.3 유일성 원칙

- 하위 클래스 로더는 상위 클래스 로더가 로드한 클래스를 다시 로드하면 안된다.
- 위임 원칙으로 고유한 클래스 로딩을 보장 할 수 있다.

## 📝 4. 동적 로딩

### 4.1 로드타임 동적 로딩

```
public Class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello world!!!");
    }
}
```

위처럼 `hello world!!!`를 출력 하는 코드를 컴파일 과정 이후 실행 했을 때 클래스 로더는 `Object` 클래스와 `HelloWorld` 클래스를 읽고 로딩하기 위해 필요한 `String`, `System` 클래스를 로딩한다. 여기서 모든 클래스는 `HelloWorld` 클래스가 실행 되기 전 **로드타임에 동적으로 로드** 된다.

### 4.2 런타임 동적 로딩

객체지향 다형성 원리를 이용해 런타임 동적 로딩을 알아보자. 우선 다음과 같이 `Main`, `Car`, `SportsCar` 클래스코드를 이용해 세개의 파일을 만들고 실행 해보자.

```
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Car car = new SportsCar();
        car.move();
    }
}

---

public interface Car {

    void move();
}

---

public class SportsCar implements Car {

    @Override
    public void move() {
        System.out.println("Sports car move!!!");
    }
}
```

정상적으로 실행되었다면 프로젝트의 실행파일 경로에 바이트 코드 결과물이 생성되고 다음과 같이 실행된다.

```
Hello world!
Sports car move!!!
```

이 때 클래스 로딩 로그를 확인해보려면 터미널을 열고 다음 명령어를 입력해보면 된다.

```
java classpath ${바이트코드 경로} -verbose:class ${메인클래스 명}
// ex) java classpath ./out/production/hello-world verbose:class Main
```

로그를 출력해보면 다음과 같이 어마어마하게 많은 클래스들이 로드타임에 로드되고 나서야 프로그램이 실행되고 실행되는 런타임에 `SportsCar` 클래스가 로드되는것을 확인할 수 있다.

```
// 명령어 입력
neo@Neos-MacBook-Air hello-world % java -classpath ./out/production/hello-world -verbose:class Main

... 중략 ...

// Car 클래스 로드.
[0.029s][info][class,load] Car source: file:/Users/neo/workspace/java/hello-world/out/production/hello-world/

... 중략 ...

Hello world!

// 이 지점에서 SportsCar 클래스가 로드 됨.
[0.029s][info][class,load] SportsCar source: file:/Users/neo/workspace/java/hello-world/out/production/hello-world/
Sports car move!!!
[0.029s][info][class,load] java.lang.Shutdown source: shared objects file
[0.029s][info][class,load] java.lang.Shutdown$Lock source: shared objects file
neo@Neos-MacBook-Air hello-world %
```

> #### 🧐 Q. 왜 `SportsCar` 클래스는 런타임 중간에 로드되는걸까?
> **A.** 앞서 배웠던 객체지향 원리중 다형성 원리를 생각해보자. 상위 클래스(인터페이스)인 `Car`는 구체화된 클래스로 객체를 전달 받아야 한다. 그런데 프로그램이 실행되며 실행문이 해석되기 전까지 JVM은 `Car`에 `SportsCar`가 올지 `Sedan`이 올지 알 수 없다. 즉, **로드타임에 어떤 클래스를 로딩할지 결정 할 수 없다**. 따라서 이 때 `SportsCar` 클래스는 런타임 중에 로딩된다.

## 👀 5. 동적로딩의 장점과 단점

### 5.1 장점

- 런타임 전 까지 메모리 낭비를 막을 수 있다.
  - 사실 런타임 전까지, 해당 클래스가 사용되는 시점까지 정보를 알 수 없다.

### 5.2 단점
- 런타임에러를 조기에 발견하기 어렵다.
  - 실행문이 실행되는 시점까지 가서야 발견할 수 있다.
- 동적로딩에도 시간비용이 발생하기때문에 성능저하로 이어질 수 있다.

---

### 📚 References

- [[Java] JVM의 클래스 로더란?](https://steady-coding.tistory.com/593)
- [자바의 클래스로더 알아보기](https://leeyh0216.github.io/posts/java_class_loader)
- [[JAVA] ☕ 클래스는 언제 메모리에 로딩 & 초기화 되는가 ❓](https://inpa.tistory.com/entry/JAVA-%E2%98%95-%ED%81%B4%EB%9E%98%EC%8A%A4%EB%8A%94-%EC%96%B8%EC%A0%9C-%EB%A9%94%EB%AA%A8%EB%A6%AC%EC%97%90-%EB%A1%9C%EB%94%A9-%EC%B4%88%EA%B8%B0%ED%99%94-%EB%90%98%EB%8A%94%EA%B0%80-%E2%9D%93)
- [자바의 클래스로더 알아보기](https://leeyh0216.github.io/posts/java_class_loader/)