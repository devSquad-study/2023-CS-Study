# POJO란 무엇인가?

POJO(Plain Old Java Object)는 직역하면 간단한 오래된 자바 오브젝트을 뜻합니다. 즉, 다른 환경에 종속되지 않고, 필요에 따라 재사용이 가능한 자바 오브젝트를 뜻합니다.

스프링에 탄생하기 전에 자바 엔트프라이즈 시장은 EJB(Enterprise Java Bea)이 독점하소 있었습니다.

EJB는 엔터프라이즈 개발을 단순화하기 위해 Sun 사에서 만들어낸 JAVA 스펙입니다.

아래는 EJB을 통해 짠 코드입니다

```jsx
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class OrdersService implements SessionBean {

    private SessionContext ctx;

    public Orders placeOrder(String menuName) {
        Orders orders = new Orders(menuName);
        orders.init()
        return orders;
    }

    @Override
    public void setSessionContext(SessionContext ctx) throws EJBException {
        this.ctx = ctx;
    }

    @Override
    public void ejbRemove() throws EJBException {

    }

    @Override
    public void ejbActivate() throws EJBException {

    }

    @Override
    public void ejbPassivate() throws EJBException {

    }
}
```

코드를 살펴보면, 변수부터, 예외처리, 상속까지 EJB에 의존적인 것을 볼수 있습니다.

당시 마틴 파울러는 이런한 **문제점을 의식하고, 복잡하고 제한적인 기술보다 자바의 단순 오브젝트를 이용해 비즈니스 로직을 구현하는 편이 낫다**고 생각하여 `POJO` 를 만들었다.

## POJO의 규칙

> **특정 규약에 종속되지 않는다.**
>

> **특정 환경에 종속되지 않는다.**
>

> **객체 지향적 원리에 충실해야 한다.**
>

# PSA(Portable Service Abstraction)

PAS는 직역하면 휴대용 서비스 추상화라는 의미를 가진다.

서비스 추상화란 특정 서비스가 추상화되어있다는 것은 서비스의 내용을 모르더라고 해당 서비스를 이용할 수 있다는 것을 의마한다.

PAS은 Portable 서비스 추상화이다. 그럼 휴대용은 어떤 의미가 있을까?

직역을 해서 휴대용이지 Portable은 가지고 다닐수 있도록 가볍고 작다는 의미를 가졌다. 즉, 교체가 쉽다 라는 말도 될 수 있다.

즉, 비즈니스 로직의 수정없이 언제든지 변경할 수 있는 것을 의미한다.

예를 들어, MySQL Driver를 사용하다가 Oracle Driver로 변경하여도 비즈니스 로직은 아무 영향을 받지 않고 실행이 됩니다.

## PSA은 왜 사용할까?

서비스를 추상화함으로써 개발자가 실제 구현부를 알지 못하더라고 해당 기능을 사용할 수 있게된다. 즉, 추상화 계층인 인터페이스 API의 정보를 활용해 해당 서비스의 모든 기능을 이용하면 된다.

또한  PSA는 해당 추상화 계층을 구현하는 또 다른 서비스로 언제든지 교체할 수 있게 해준다.

# IOC(Inversion Of Control)

Spring과 EJB은 개발자가 복잡하고 실수하기 쉬운 로우 레벨의 기술에 많이 신경쓰지 않고도, 애플리케이션의 핵심인 사용자의 요구사향, 즉 비즈니스 로직을 빠르고 효과적으로 구현하게 하는 목표로 했습니다.

그러나 EJB는 **메서드나 객체의 호출 작업** 등에 대한 제어를 코드에 침투적으로 반영했고, Spring은 제어와 비지니스 로직을 분리할 수 있게 했다는 차이가 있습니다

IOC는 해석하면 제어의 역전을 뜻한다.

제어는 개발자가 직접 관리를 하는데 이것을 프레임워크에서 객체의 생성과 관리를 하는 것을 의미한다.

개발자가 직접 객체를 생성하고 관리하는 코드는 아래와 같이 작성을 합니다

```jsx
public class A {
	
		private B b;
		
		public A(){
				b = new B();
		}
}
```

위 코드를 보고 “A객체는 B객체에 의존하고 있어” 라고 말할 수 있습니다.

```jsx
public class A {

		@Autowired
		private B b;

}
```

Spring 에서 위와 같은 코드로 위존의 역전이 일어납니다.

# AOP

관점 지향 프로그래밍이란 객채 지향 프로그램밍의 단점을 보완하기 위해 나온 패러다임이다.

객체지향의 가장 큰 장점은 프로그램을 모듈화를 시켜 이를 재활용함으로써 코드의 중복을 줄이고, 재사용성을 높이는 것이었다.

하지만 프로그램이 커짐으로서 모듈 안에서 중복되는 코드가 생기게 되었습니다.

이런한 것은 횡단 관심사(Crosscutting-Concerns) 라고 합니다.

횡단 관심사들은 모듈들을 횡단하면서 존재하게 됩니다.

AOP의 목적은 횡단 관심사를 모듈화하는 방법을 제시하는 것입니다.

# 레퍼런스

- [[Spring] POJO 프로그래밍과 스프링 프레임워크의 탄생(망나니 개발자)](https://mangkyu.tistory.com/281)

- [[TI/SPRING] IOC, DI 정의/ 장점(디벨로폴리)](https://isoomni.tistory.com/entry/TISPRING-IOC-DI-%EC%A0%95%EC%9D%98-%EC%9E%A5%EC%A0%90)
- [[Spring DI/IoC] IoC? DI? 그게 뭔데?(ohzzi.log)](https://velog.io/@ohzzi/Spring-DIIoC-IoC-DI-%EA%B7%B8%EA%B2%8C-%EB%AD%94%EB%8D%B0)

- [**[Spring Boot] Spring PSA(ch4njun)**](https://ch4njun.tistory.com/270)

- [**Aspect Oriented Programming(관점지향프로그래밍) 소개(DEEPLAY)**](https://3months.tistory.com/74)