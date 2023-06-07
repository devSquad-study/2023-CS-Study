# ApplicationContext
> 스프링 컨테이너
>
> ApplicationContext는 BeanFactory 인터페이스의 하위 인터페이스

Spring에서는 빈의 생성과 관계설정 같은 제어를 담당하는 IoC(Inversion of Control) 컨테이너인 빈 팩토리(Bean Factory)가 존재한다. 하지만 실제로는 빈의 생성과 관계설정 외에 추가적인 기능이 필요한데, 이러한 이유로 Spring에서는 빈 팩토리를 상속받아 확장한 애플리케이션 컨텍스트(Application Context)를 주로 사용한다.

애플리케이션 컨텍스트는 별도의 설정 정보를 참고하고 IoC를 적용하여 빈의 생성, 관계설정 등의 제어 작업을 총괄한다. 애플리케이션 컨텍스트에는 직접 오브젝트를 생성하고 관계를 맺어주는 코드가 없고, 그런 생성 정보와 연관관계 정보에 대한 설정을 읽어 처리한다. 예를 들어 @Configuration과 같은 어노테이션이 대표적인 IoC의 설정정보이다.

### BeanFactory
스프링 컨테이너의 최상위 인터페이스
스프링 빈을 관리하고 조회하는 역할

ApplicationContext는 BeanFactory + 부가 기능(국제화 기능, 환경 변수 관련 처리, 애플리케이션 이벤트, 리소스 조회)을 가진다.

### 여러 구현체의 ApplicationContext
구현체가 여러가지 존재할 수 있다.
<br> XML, 자바 클래스 모두 가능

가능한 이유는 빈 등록을 BeanDefinition으로 추상화해서 생성 하기 때문이다. XML로 하든, 자바로 하든 BeanDefinition이 생성된다.

### Bean 저장소
스프링 컨테이너 내부에는 빈 저장소가 존재한다. 빈 저장소는 key로 빈 이름을 가지고 있으며, value로 실제 빈 객체를 가지고 있다.

스프링 컨테이너는 기본적으로 빈을 싱글톤으로 관리해준다. 따라서 싱글톤 컨테이너라고 불리기도 한다. 

스프링 컨테이너가 빈을 싱글톤으로 관리해주면서 기존 싱글턴 패턴의 문제점(싱글톤 패턴 구현을 위한 코드가 추가되어야함, 구체 클래스에 의존, 유연성이 떨어짐 etc)은 없어지고, 싱글톤의 장점(매번 인스턴스를 생성할 필요없이 단 하나만 생성해서 비용을 줄일 수 있다.)만 가져갈 수 있다.

## 자바 설정 클래스로 스프링 컨테이너 생성하기
```
@Configuration
public class AppConfig {

    @Bean
    public StationService stationService() {
        return new StationServiceImpl(stationRepository());
    }
    
    @Bean
    public StationRepository stationRepository() {
        return new MemoryStationRepository();
    }
    
    @Bean
    // ...
```

1. `new AnnotationConfigApplicationContext()`를 통해 자바 기반 스프링 컨테이너를 만들어 준다. 
2. 비어있는 빈 저장소가 생긴다. 
3. 이때 만들어 둔 자바 설정 클래스를 파라미터로 넘겨줘서 생성한다. 
4. 자바 설정 클래스 내부의 @Bean 어노테이션이 붙은 메서드들을 실행하면서 빈 저장소에 실제 빈을 등록한다.

```
ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

StationService stationService = applicationContext.getBean("stationService", StationService.class);
```

사용할 땐, 빈 등록 메서드 이름을 통해 객체를 가져올 수 있다.



### 참고 자료
[[Spring] 스프링 컨테이너(ApplicationContext)](https://velog.io/@max9106/Spring-ApplicationContext)
