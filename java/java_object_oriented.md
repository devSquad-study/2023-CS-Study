## 객체 지향 프로그래밍(Object-Oriented Programming, OOP)
- `정의` : 프로그래밍에서 필요한 데이터를 추상화시켜, **상태와 행위를 가진 객체**로 만들고, 객체들의 유기적인 결합과 협력으로 파악하고자 하는 컴퓨터 프로그래밍의 패러다임을 의미

### 객체 지향 프로그래밍의 장점
- 프로그램을 유연하고 변경이 용이하게 만들 수 있다  
    - ex) 컴퓨터 부품 변경 시, 나머지 부품을 건들지 않고도 변경 가능한 예

- 인간 친화적이고 직관적인 코드 작성에 용이하다

## 객체(Object)
- `정의` : 객체 지향 프로그래밍의 가장 기본적인 단위이자 시작점

```
class Phone {
    //속성 정의
    String name;
    String color;
    int gram;
    boolean is5G;

    //기능 정의
    void start() {
        System.out.println("전원을 켭니다");
    }

    void takePicture() {
        System.out.println("사진을 찍습니다.");
    }

    void makeCall() {
        System.out.println("전화를 겁니다.)"
    }
}
```

객체 지향 프로그래밍에서는 예제에서와 같은 객체를 추상화시켜 속성(state)과 기능(behavior)로 분류하여 각각 변수(variable)와 함수(function)으로 정의합니다.

### 객체 지향 프로그래밍의 4가지 특성
객체 지향 프로그래밍을 통해 소프트웨어를 개발하면 코드를 재사용함으로써 반복적인 코드 최소화, 유연하고 변경에 용이한 프로그램 개발이 가능하다  

이러한 설계는 객체 지향 프로그래밍의 4가지 특징에 기인한다

### [ 추상화(Abstraction) ]
- `정의` : 객체의 공통적인 속성과 기능을 추출하여 정의하는 것
- `예시` : 서울 지하철 노선도

<div align='center'>
    <img src="img/java_route_map.png" width="500px">
</div>

중요한 부분을 강조하기 위해 불필요한 사항들은 제거하고 **공통적인 부분만을 추출하여 간단하게 표현** 하였다  

<div align='center'>
    <img src="img/java_phone.png" width="500px">
</div>

위 사진 속 예시를 보면, `Galaxy`와 `Iphone` 모두 `휴대폰` 이며 **사진 찍기와 전화 걸기를 할 수 있다는 공통점**을 가진다  

이는 자바 문법 요소를 이용하여 표현하면, `Galaxy`와 `Iphone`은 상위 클래스(super-class)인 `Phone`을 상속하는 하위 클래스(sub-class)이며 상위 클래스가 지닌 `휴대폰의 기능`을 공통적으로 지니고 있다  

객체 지향 설계에 있어 인터페이스란, 특정 객체의 역할만을 정의하여 객체들 간 관계를 유연하게 연결하는 역할을 담당한다  

```
public interface Phone {
    public abstract void start()
    void takePicture();
    void makeCall();
}
```
`Galaxy`와 `Iphone`의 공통적인 기능들을 모아둔 `Phone` 인터페이스이다  

`Phone` 인터페이스는 `Galaxy`와 `Iphone`이 공통적으로 수행해야하는 핵심적인 기능들만 규정하였다  

보다 실질적인 구현은 `Phone` 인터페이스를 구현하는 `Galaxy`와 `Iphone` 객체에서 이루어진다  

```
public class Galaxy implements Phone {
    @Override
    public void takePicture() {
        System.out.println("갤럭시 사진을 찍습니다");
    }

    @Override
    public void makeCall() {
        System.out.println("갤럭시로 전화를 겁니다");
    }
}

public class Iphone implements Phone {
    @Override
    public void takePicture() {
        System.out.println("아이폰으로 사진을 찍습니다");
    }

    @Override
    public void makeCall() {
        System.out.println("아이폰으로 전화를 겁니다");
    }
}
```

위 예제에서도 알 수 있다싶이, `Phone` 인터페이스를 구현하는 `Galaxy` 클래스와 `Iphone` 클래스에서 각각의 클래스 맥락에 맞게 인터페이스에서 정의한 역할을 구현하고 있다  

이를 객체 지향 프로그래밍에서는 **역할과 구현의 분리** 라고 한다

### [ 상속(Inheritance) ]
- `정의` : 기존의 클래스를 재활용하여 새로운 클래스를 작성하는 자바 문법 요소







