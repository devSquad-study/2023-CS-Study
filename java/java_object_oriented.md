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
    String model;
    String color;
    int size;
    boolean isRecordingSupportive;

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

위 그림 속 예시를 보면, `Galaxy`와 `IPhone` 모두 `휴대폰` 이며 **그림 찍기와 전화 걸기를 할 수 있다는 공통점**을 가진다  

이는 자바 문법 요소를 이용하여 표현하면, `Galaxy`와 `IPhone`은 상위 클래스(super-class)인 `Phone`을 상속하는 하위 클래스(sub-class)이며 상위 클래스가 지닌 `휴대폰의 기능`을 공통적으로 지니고 있다  

객체 지향 설계에 있어 인터페이스란, 특정 객체의 역할만을 정의하여 객체들 간 관계를 유연하게 연결하는 역할을 담당한다  

```
public interface Phone {
    public abstract void start()
    void takePicture();
    void makeCall();
}
```
`Galaxy`와 `IPhone`의 공통적인 기능들을 모아둔 `Phone` 인터페이스이다  

`Phone` 인터페이스는 `Galaxy`와 `IPhone`이 공통적으로 수행해야하는 핵심적인 기능들만 규정하였다  

보다 실질적인 구현은 `Phone` 인터페이스를 구현하는 `Galaxy`와 `IPhone` 객체에서 이루어진다  

```
public class Galaxy implements Phone {
    @Override
    public void takePicture() {
        System.out.println("갤럭시로 사진을 찍습니다");
    }

    @Override
    public void makeCall() {
        System.out.println("갤럭시로 전화를 겁니다");
    }
}

public class IPhone implements Phone {
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

위 예제에서도 알 수 있다싶이, `Phone` 인터페이스를 구현하는 `Galaxy` 클래스와 `IPhone` 클래스에서 각각의 클래스 맥락에 맞게 인터페이스에서 정의한 역할을 구현하고 있다  

이를 객체 지향 프로그래밍에서는 **역할과 구현의 분리** 라고 한다

### [ 상속(Inheritance) ]
- `정의` : 기존의 클래스를 재활용하여 새로운 클래스를 작성하는 자바 문법 요소

앞의 예제를 변형하여 상속의 맥락에서 생각해보자
<div align='center'>
    <img src="img/java_galaxy_iphone.png" width="500px">
</div>

위 그림을 보면 갤럭시와 아이폰의 기능이 명시되어 있으며 빨간색으로 표시된 속성과 기능들은 갤럭시와 아이폰의 공통적인 기능이고, 초록색으로 표시된 부분들은 그렇지 않은 부분이다  

이를 코드로 표현해보면 다음과 같다

```
public class Galaxy {

    String model;
    String color;
    int size;
    
    //Galaxy 클래스 고유한 속성
    boolean isRecordingSupportive; 

    void takePicture() {
        System.out.println("사진을 찍습니다");
    }

    void makeCall() {
        System.out.println("전화를 겁니다");
    }

    //Galaxy 클래스 고유의 기능
    void samsungPay() {
        System.out.println("삼성 페이로 지불합니다");
    }
}

public class IPhone {
    
    String model;
    String color;
    int size;

    //IPhone 클래스 고유한 속성
    boolean isICloudSupportive;

    void takePicture() {
        System.out.println("사진을 찍습니다");
    }

    void makeCall() {
        System.out.println("전화를 겁니다");
    }

    //IPhone 클래스 고유의 기능
    void applePay() {
        System.out.println("애플 페이로 지불합니다");
    }
}
```

위 코드 예제를 보면, 속성(model, color, size)과 기능(takePicture(), makeCall())이 동일함에도 불구하고 반복적으로 구현되고 있음을 확인가능하다  

 또한 하나의 코드에서 변경 사항이 발생하면, 해당 변경 사항을 다른 클래스에도 일일히 수정해주어야 하는 번거러움이 존재한다  

 아래 그림과 코드는 추상화와 상속을 활용하여 재정의한 모습이다
<div align='center'>
    <img src="img/java_galaxy_IPhone_2.png" width="500px">
</div>

```
//추상화를 통한 상위클래스 정의
public class Phone { 
    String model;
    String color;
    int size;

    void takePicture() {
        System.out.println("사진을 찍습니다");
    }

    void makeCall() {
        System.out.println("전화를 겁니다");
    }
}

public class Galaxy extends Phone {

    boolean isRecordingSupportive;

    void samsungPay() {
        System.out.println("삼성 페이로 지불합니다");
    }
}

public class IPhone extends Phone {

    boolean isICloudSupportive;

    //메서드 오버라이딩 -> 기능 재정의
    @Override
    void takePicture() {
        System.out.println("아이폰으로 사진을 찍습니다");
    }


    void applePay() {
        System.out.println("애플 페이로 지불합니다");
    }
}

public class Main {
    public static void main(String[] args) {

        //객체 생성
        Phone phone = new Phone();
        IPhone IPhone = new IPhone();

        //phone 객체 속성 정의
        phone.model = "갤럭시S20";
        phone.color = "하늘색";

        System.out.println("나의 휴대폰은 " + phone.color + " " + phone.model + "입니다.");

        //객체들의 기능 실행
        phone.takePicture();
        IPhone.takePicture();
        IPhone.makeCall();
    }
}

```

**출력값**
> 나의 휴대폰은 하늘색 갤럭시S20입니다.  
사진을 찍습니다  
아이폰으로 사진을 찍습니다  
아이폰으로 전화를 겁니다

위 코드 예제를 보면, `Galaxy`와 `IPhone` 클래스의 공통적인 속성 및 기능들을 추출(추상화) 하여 `Phone` 클래스(상위 클래스)에 정의하였고, `extends` 키워드를 통해 상위 클래스의 기능들을 하위 클래스로 확장하여 반복적인 코드를 제거하였다  

또한, 코드 변경이 있을 시, 상위 클래스의 코드만 변경하면 이를 상속하는 하위 클래스들도 변경 사항이 반영된다  

`IPhone` 클래스에서 확인할 수 있듯이, 오버라이딩 기능을 사용하여 메소드 내용을 재정의 할 수도 있다  

이를 통하여 알 수 있는 점은, 인터페이스를 통한 구현과 클래스들 간의 상속 모두 상위-하위 클래스 관계를 전제하여 공통 속성 및 기능을 공유하지만, 상속의 경우 오버라이딩을 사용하여 메서드를 재정의 가능한 반면, 인터페이스를 이용한 구현은 인터페이스 내 정의된 추상 메서드 내용이 하위 클래스에서 정의되어야 한다 

결론적으로, 상속 관계가 인터페이스를 사용한 구현에 비해 추상화 정도가 낮다








