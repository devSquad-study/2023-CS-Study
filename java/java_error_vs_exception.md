오류와 예외가 무엇인지 자세히 알아보기 전, 이들이 상속하는 클래스들의 계층구조를 아래 사진으로 먼저 파악해보자

<div align='center'>
    <img src="img/java_error_exception_relationship.png" width="600px">
</div>

### [ Throwable ]

예외와 관련된 최상위 클래스는 `Throwable`이다.  
하지만 대부분 직접적으로 이 클래스를 사용하기보다는 이를 상속받은 `Exception`이나 `Error`가 주로 사용된다.  
또한, Error는 예외 처리의 대상으로 보지 않기에 제외하면 나머지 `Exception` 클래스와 그 하위 클래스가 주요 처리 대상이다.  

> Instances of two subclasses, Error and Exception, are conventionally used to indicate that exceptional situations have occurred.  
-Oracle-

Throwable 클래스에 대한 Oracle의 공식문서를 읽어보면 **이 클래스의 객체에 오류나 예외에 대한 메시지를 담는다**는 이야기가 나옵니다.  

> ...The recording of this causal information is referred to as the chained exception facility, as the cause can, itself, have a cause, and so on, leading to a "chain" of exceptions, each caused by another.  
-Oracle-

또한, 예외가 연결될 때(chained exception) 연결된 예외의 정보들을 기록하기도 한다고 합니다.  
이 Throwable 객체가 지닌 정보와 할 수 있는 행위는 `getMessage()`와 `printStackTrace()`라는 메소드로 구현되어 있으며 Throwable 클래스를 상속하는 Error와 Exception에서 두 메서드를 사용가능하다.

**getMessage()** : 발생한 예외에 대한 구체적인 메시지를 반환하므로 간단히 예외에 관한 내용을 확인할 때 좋다.

**printStackTrace()** : 예외에 대한 자세한 디버깅을 위해 주로 사용되는 메서드이다.

### [ Exception ]

`Exception`은 다시 `RuntimeException` 계열과 그 외의 `Exception` 계열로 나뉜다.  
이 두 계열의 차이는 컴파일 시점에 예외 상황에 대한 대비 코드(try ~ catch)가 있는지를 체크하는지 여부에 있으며 각각 `unchecked exception`과 `checked exception`으로 불린다.  

`RuntimeException`의 하위 클래스들은 모두 `unchecked exception`으로 예외에 대한 처리 코드가 없어도 컴파일 오류가 발생하지 않는다.  
물론 대비 코드를 작성하지 않은 상태에서 예외가 발생하면 프로그램은 비정상 종료된다.  
하지만, 나머지 `checked exception`의 경우 예외에 대한 처리 코드가 없을 경우 커마일 오류가 발생하므로 반드시 작성해 주어야 한다.  

`checked exception`이나 `unchecked exception` 모두 일단 발생하면 해당 예외에 대한 처리 코드가 있어야 프로그램의 비정상 종료를 막을 수 있다.


## 오류(Error) vs 예외(Exception)

### [ 오류(Error) ]
메모리가 부족하거나 메서드끼리 호출을 무한 반복하는 것처럼 일단 발생하면 복구하거나 되돌릴 수 없는 심각한 상황이다. 이는 개발자가 **미리 예측하여 방지할 수 없으며**, 처리방법은 오류를 발생하는 요인을 찾아서 없애는 디버깅 뿐이다. 즉, 프로그램을 잘 짜는 것만이 대안이다.

<div align='center'>
    <img src="img/java_error_relationship.png" width="500px">
</div>

- **StackOverflowError** : 호출의 깊이가 깊어지거나 재귀가 지속되어 stack overflow 발생 시 던져지는 오류입니다. 재귀를 사용할 때에 조심하거나 가시적인 loop를 사용하는 간접적인 예방이 가능합니다.  

- **OutOfMemoryError** : JVM이 할당된 메모리의 부족으로 더 이상 객체를 할당할 수 없을 때 던져지는 오류입니다. Garbage Collector에 의해 추가적인 메모리가 확보되지 못하는 상황이기도 합니다. 새는 메모리를 차단하거나 heap의 크기를 늘려주면서 이를 방지할 수 있습니다.


### [ 예외(Exception) ]
오류와 비교하면 심각도가 낮으며 프로그램의 정상적인 흐름을 방해하는 상황이다. 개발자가 구현한 로직에서 발생한 실수 혹은 사용자의 영향에 의해 발생한다. 예를 들면 파일을 읽으려고 하는데 해당하는 파일이 없거나 네트워크 프로그램이 동작 중 네트워크 연결이 끊기는 상황들이다. 이러한 상황들은 **개발자가 미리 예측하여 방지할 수 있기** 때문에 상황에 맞는 `예외 처리(Exception Handle)`를 해야 한다.  

<div align='center'>
    <img src="img/java_exception_relationship.png" width="500px">
</div>

- **NullPointerException** : 객체가 필요한 경우인데 응용프로그램이 null을 사용하려고 시도할 경우 던져지는/던질 수 있는 예외입니다.  

- **IllegalArgumentException** : 메서드가 허가되지 않거나 부적절한 argument를 받았을 경우 던져지는/던질 수 있는 예외입니다.  

이 때 **던질 수 있는**이란, 개발자가 임의로 예외를 던질 수 있음을 의미합니다.







