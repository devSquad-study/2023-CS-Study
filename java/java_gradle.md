> [해당 포스팅](https://hello-judy-world.tistory.com/214)에서도 내용을 확인할 수 있습니다.

> written by [judy](https://github.com/ParkJungYoon)


<div align='center'>
    <img src="img/java_gradle_1.png" width="500px">
</div>

자바 프로젝트를 진행하면서 빌드 도구를 많이 접해볼 것이다.

최근에 프로젝트 세팅을 하면서 Gradle, 이 친구 설정을 많이 변경하고 사용했다.

그런데 말입니다.. 빌드 도구는 여러 가지 있단 말이됴?

그리고 Gradle을 사용하면서 왜 사용하는지, 어떻게 사용하는지 알고는 있나요?!

지금부터 알아보자!! 출~ 발~

<br>

## 🐘 Java Build Tool

> `(소프트웨어 개발에서)` 소스 코드를 실행 가능한 애플리케이션으로 만들어주는 도구
 
1. 소스코드의 빌드 과정을 자동으로 처리해주는 도구
2. 외부 소스 코드 (외부 라이브러리) 자동 추가, 관리

- `종류`: APACHE ANT, Maven, Gradle

<br>

### [ Ant(앤트) ]

- 설정을 위해 <u>XML</u> 스크립트를 사용한다.
- 이클립스 IDE에 기본 탑재되어 있고, 간단하고 사용하기 쉽다.
- 복잡한 처리를 하려 하면 빌드 스크립트가 장황해져 관리가 어렵다.
- 외부 라이브러리를 관리하는 구조가 없다.

2000년대 초반에 사용했지만, 최근엔 주로 레거시 시스템에서만 사용한다.

### [ Maven(메이븐) ]

- 설정을 위해 <u>XML</u> 스크립트를 기반으로 하며, pom.xml 파일로 의존성을 관리한다.
- <u>외부 라이브러리를 관리</u>할 수 있다.
- 장황한 빌드 스크립트 문제를 해결했다.
- Life Cycle(라이프 사이클) 개념이 도입되어 <u>빌드 순서를 정의</u>할 수 있다.
- XML 자체의 한계가 있다.

Maven은 Ant 이후에 나온 빌드 도구이다. Ant와 크게 달라진 점은 자동으로 외부 라이브러리를 관리하는 기능이 생긴 점이다.

### [ Gradle(그래들) ]

- 설정을 위해 **Groovy(그루비)** 문법을 사용한다.
- 외부 라이브러리를 관리할 수 있다.
- 유연하게 빌드 스크립트를 작성할 수 있다.
- 성능이 뛰어나다. (`캐싱`이 잘된다.)

Gradle은 가장 최근(2012년)에 나온 빌드 도구이다. 기존 빌드 도구와 가장 큰 차이점은 **Groovy 문법**을 사용하는 것이다.

기존 XML 기반 스크립트 작성에 비해 관리가 편해졌다.

`Build.gradle`에 스크립트를 작성하여 사용한다.

<br>

> 🐰 : 오.. 이런 차이가 있구나. 그래서 Gradle 왜 써야 하는데!? 더 줘!! 더 자세하게 말해봐!!

> 🤖 : 간결한 스크립트 작성, 캐싱으로 빠른 빌드 속도, 멀티 모듈 빌드!!!

> 🐰 : 오.. 결론부터.. 좋다. 이 속도. 두괄식 같고 자소서 같고 막 그래(?)

<br>

## ✔️ Gradle을 사용하는 이유 (장점)

### 1\) 간결한 스크립트 작성

위에서 공부한 내용에 따르면 Ant와 Maven은 XML 문법을 사용했다.

Maven의 pom.xml의 기본 코드 형태를 보자.

어우.. 저 태크. 여는 태크, 닫는 태크. 아주 작성할 것이 많다.

그렇기 때문에 복잡한 빌드 스크립트 작성이 어렵고, 가독성이 떨어진다!

- `pom.xml`

```xml
<project ... 생략 ...>
 
    <modelVersion>4.0.0</modelVersion>
    <groupId>그룹 ID</groupId>
    <artifactId>아티팩트 ID</artifactId>
    <version>버전</version>
    <packaging>jar</packaging>
    <name>이름</name>
 
    <properties>
        ...
        속성 정보
        ...
    </properties>
 
    <dependencies>
        ... 
        의존 라이브러리 정보 
        ...
    </dependencies>
 
</project>
```
 
반면 Gradle의 Groovy 문법은?

편 - 안 -

```groovy
plugins {
	id 'java'
	id 'org.springframework.boot' version '2.7.11'
	id 'io.spring.dependency-management' version '1.0.15.RELEASE'
}
 
group = 'hello'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '11'
 
configurations {
	compileOnly {
		extendsFrom annotationProcessor
	}
}
 
repositories {
	mavenCentral()
}
 
dependencies {
	...
}
 
tasks.named('test') {
	useJUnitPlatform()
}
```

<br>

### 2\) 빠른 빌드 속도

### - 점진적 빌드

작업의 입출력을 추적하고, 변경된 파일만 처리하여 작업한다.

즉, 이미 빌드된 파일을 모두 빌드하는 것이 아니라 변경된 내용만 빌드하는 것이다.

### - 캐싱

빌드 속도도 개발 생산성에 중요한 역할을 한다.

Gradle은 캐싱을 하기 때문에 다른 빌드 도구보다 **속도가 빠르다**.

[Gradle 공식 문서](https://gradle.org/maven-vs-gradle/)에서 자기 PR을 하고 있다. 성능을 냅다 비교해 준다.

이 성능 비교에 따르면 Gradle은 거의 모든 시나리오에서 최소 2배 더 빠른 성능을 제공하고, 빌드 캐시를 사용하는 대규모 빌드의 경우 100배 더 빠르다고 한다.

> 🐰 : 제법 멋진 코끼리였어.

<br>

<div align='center'>
    <img src="img/java_gradle_2.png" width="500px">
    <p>출처: gradle.org, [Gradle vs Maven Comparison]</p>
</div>

### - 데몬(Daemon) 프로세스

서비스 요청에 응답하기 위해서 메모리 상에 빌드 결과물을 보관하는 오래 지속되는 프로세스이다.

그래서 한 번 빌드된 프로젝트는 다음 빌드 시 시간이 단축된다.

<br>

### 3\) 멀티 프로젝트 빌드

대규모 프로젝트에서는 **멀티 모듈 프로젝트**로 구성하게 된다. (속닥속닥. 지금 프로젝트도 멀티 모듈로 진행하고 있다.)

멀티 모듈에 대해서 궁금하다면 아래 글을 읽어보자!

> 🤖 : 갑자기?

> 🐰 : 코끼리도 자기 PR 하는데.. 나도 좀 해보자.

> 🖇️ 관련 포스팅 : [멀티 모듈, 그게 뭔데? 그거 어떻게 하는건데? 🧐](https://hello-judy-world.tistory.com/204)

여러 모듈을 개발하며 간단하게 각각의 모듈을 빌드할 수 있다.

아래 명령어로!

```
$ ./gradlew :moduleName:build
```

> 🐰 : 오.. 그렇구나. 그럼 이제 마지막! 어떻게 써~?

> 🤖 : 어유. 저 호기심 토끼. 따라와

<br>

## ✔️ Gradle 사용

기본으로 생성했을 때 Gradle 프로젝트 구조이다.

```
├── build.gradle
├── .gradle
├── gradle 
│     └── wrapper 
│           ├── gradle-wrapper.jar 
│           └── gradle-wrapper.properties
├── gradlew 
├── gradlew.bat 
├── settings.gradle
```

### [ .gradle ]

Gradle이 사용하는 폴더로 작업(task)으로 생성된 파일이 저장된다.

<br>

### [ gradle ]

> [관련 공식 문서](https://docs.gradle.org/current/userguide/gradle_wrapper.html)
 
**gradle-wrapper**와 관련된 폴더이다.

gradle-wrapper 실행 명령으로도 task 실행이 가능하다.

이것을 사용하면 새로운 환경에서도 gradle을 설치하지 않고 빌드가 가능하다. 그렇게 되면 각 개발자의 로컬 환경에 영향을 받지 않고 사용할 수 있다.

Java나 Gradle 설치할 필요 없이 바로 프로젝트를 실행할 수 있다.

### [ gradlew, gradlew.bat ]

gradle-wrapper **실행 명령**이다.

`gradlew`는 macOS, Linux용이고, `gradlew.bat`는 윈도우 실행 명령이다.

gradle 설치하지 않아도 빌드할 수 있다. 즉, 환경에 종속되지 않는다.

```
$ ./gradlew [Task명]
$ gradlew [Task명]
```

<br>

### [ settings.gradle ]

프로젝트에 대한 설정 정보를 작성하는 파일이다.

멀티 모듈 프로젝트에서 하위 모듈을 추가하는 경우에 이 파일에 명시해주어야 한다.

아래는 현재 내가 진행하고 있는 프로젝트의 파일이다.

```
rootProject.name = 'server-1th'
include 'Module-API'
include 'Module-Domain'
```

<br>

### [ build.gradle ]
프로젝트하면서 가장 많이 접할 파일이다.

프로젝트에 필요한 의존성과 빌드 처리 내용을 작성하는 파일이다.

### - 플러그인

프로젝트에서 사용하는 Gradle 플러그인을 추가한다.

```
plugins {
    id 'java'
}
```

### - 저장소

`build.gradle`은 외부 라이브러리에 대한 기술이 있다.

필요한 라이브러리를 자동으로 다운로드하고 통합한다.

저장소는 각종 프로그램이 저장되는 위치이다.

`mavenCentral()`, `jcenter()` 2개의 저장소가 있다.

```
repositories {
	mavenCentral()
    // jcenter()
}
```

### - 의존성 주입

```
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	implementation 'org.springframework.boot:spring-boot-starter-validation'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.springframework.boot:spring-boot-devtools'
	compileOnly 'org.projectlombok:lombok'
	runtimeOnly 'com.h2database:h2'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
}
```

- `implementation`: 내부 의존성을 런타임에서만 보이는 구현 의존성
- `compileOnly`: compile에만 필요하고, runtime에는 필요 없는 라이브러리
- `runtimeOnly`: runtime에만 필요하고, compile에는 필요없는 라이브러리
- `annotationProcessor`: 어노테이션 기반 라이브러리를 컴파일러가 인식하도록 함 (lombok, queryDSL)
- `testImplementation`: 테스트에 사용하는 라이브러리

<br>

자바 빌드 도구에 대해서 알아봤다.

어떤 빌드 도구를 활용하는지에 따라 개발 생산성에 큰 차이가 발생한다.

따라서 어떠한 도구, 기술을 사용할 때 이유를 알고 사용하는 개발자가 되도록 하자.

<br>

---

### 📌 Reference

- [[요즘 IT] 자바 빌드 도구 'Gradle'의 특징과 사용 팁](https://yozm.wishket.com/magazine/detail/1700/)
- [Gradle 기본 다지기 1편](https://velog.io/@sa1341/Gradle-%EA%B8%B0%EB%B3%B8-%EB%8B%A4%EC%A7%80%EA%B8%B0-1%ED%8E%B8)
- [gradle.org, [Gradle vs Maven Comparison]](https://gradle.org/maven-vs-gradle/)