# spring vs spring boot

## Spring의 특징

1. DI (Dependency Injection)
spring 프레임워크에 의존성을 주입하면서 객체 간 결합을 느슨하게 하여 코드의 재사용성 증가 및, 단위 테스트 용이
2. IoC (Inversion of Control)
의존성 주입의 한 형태로, 객체의 생성 및 생명 주기를 제어하는 책임을 개발자가 아닌 프레임워크에 위임한는 것을 말한다. 개발자는 객체의 구체적인 구현에 의존하지 않고 객체의 인터페이스에만 의존할 수 있다. 이는 코드의 재사용성과 유지보수성을 향상 시킬 수 있다.

Spring은 IoC를 구현하는 다양한 방법을 제공하는게 가장 일반적인 방법은 컨테이너에 객체를 등록하고 컨테이너에서 객체를 주입하는 방법이다. 컨테이너는 객체의 생명주기를 관리하고, 개발자는 객체의 인터페이스에만 의존할 수 있다.
3. AOP (Aspect Oriented Programming)
횡단 관심사를 처리하는데 사용됨. 횡단 관심사는 애플리케이션의 주요 기능과 관련이 없는 로깅, 보안 및 트랜잭션 등이 횡단 관심사이다. AOP는 횡단 관심사를 애플리케이션 코드에서 분리하고 프록시 오브젝트를 사용하여 애플리케이션 코드에 추가하는 데 사용 됨.

## Spring boot의 특징

1. Embed Tomcat을 사용하여 따로 tomcat을 설치하지 않고 jar로 간편하게 배포할 수 있다.
2. starter를 통한 dependency 자동화
spring framework는 각각의 dependency의 호환 버전을 일일이 맞추어야 했고, 하나의 버전을 올리면 다른 dependency에 영향을 미쳐 버전 관리에 어려움이 있었지만 starter가 대부분의 dependency를 관리해주어 편리하다.
3. EnableAutoConfiguration
사전에 정의한 라이브러리들을 Bean에 등록하여 준다.

## 결론

spring과 spring boot는 모두 java를 기반으로 한 웹 애플리케이션 프레임워크지만 spring boot는 spring을 사용하기 쉽게 만드는 몇가지 기능을 제공한다는 특징이 있다.