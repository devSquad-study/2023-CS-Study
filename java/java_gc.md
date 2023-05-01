# Garbage Collection(GC) 🦹‍♂️
> 자바 애플리케이션에서 사용하지 않는 메모리를 자동으로 수거하는 기능
>
> GC는 JVM의 백그라운드에서 자동적으로 메모리 관리를 수행하는 JVM의 기능이다.

C/C++와 같은 언어에서 메모리 할당 및 할당 해제는 수동 프로세스이다.
<br> 그러나, Java에서 메모리 할당 해제 프로세스는 Garbage Collection에 의해 자동으로 처리된다.

### JVM 메모리 영역
JVM의 메모리는 크게 클래스 영역, 자바 스택, 힙, 네이티브 메소드 스택 의 4가지 영역으로 이루어져있다.

GC는 JVM의 메모리 영역 중 **Heap** 메모리에서 이루어진다.
<br>(Java에서 새로운 객체가 할당될 때, Heap 메모리 영역에 할당되기 때문)


이 Heap 영역은 세 영역으로 나누어진다. 
- **New/Young 영역** : 생성된지 얼마 안된 객체를 저장, 시간이 지남에 따라 우선순위가 낮아지면 Old 영역으로 옮겨진다.
- **Old 영역** : 생성된지 오래된 객체를 저장
- **Perm 영역** : Class, Method 등의 코드가 저장되는 영역, JVM에 의해 사용된다.

### JVM이 메모리를 관리하는 방식
#### [ Minor GC ]
> New/Young 영역의 GC를 Minor GC라고 부르며, 이에 사용되는 알고리즘을 Copy&Scavenge 라고 칭함

이 영역은 Eden/Survivor 이라는 두 영역으로 나뉘어진다.
- Eden : 
	- 자바 객체가 생성되자마자 저장되는 곳
	- Minor GC가 발생할 때, Survivor 영역으로 이동하게 된다.
- Survivor :
	- Survivor1 과 Survivor2로 나누어짐
	- Minor GC가 발생하면 
		- Eden과 Survivor1에 활성 객체를 Survivor2로 복사한다.
		- 활성이 아닌 객체는 Survivor1에 남아있게 되고, Survivor1과 Eden 영역을 클리어한다.
		- 다음번에 Minor GC가 발생하면, 같은 원리로 Eden과 Survivor2영역에서 활성 객체를 Survivor1으로 이동시킴. 이런 방식을 반복하며 수행
	- Survivor 영역에서 오래된 객체 Old 영역으로 옮김


속도가 매우 빠르고, 작은 크기의 메모리를 콜렉팅하는데에 효과적

자주 일어나기 때문에 시간이 짧은 알고리즘이 적합

#### [ Full GC ]
> Old 영역의 GC를 Full GC라고 부르며, 이에 사용되는 알고리즘을 Mark & Compact라고 칭함

객체들의 참조를 확인하면서 참조가 연결되지 않은 객체를 표시
이 작업이 끝나면 사용되지 않는 객체를 모두 표시하고 이 표시된 객체들을 삭제함

Full GC는 속도가 매우 느리며, Full GC가 일어나는 도중에는 순간적으로 자바 애플리케이션이 멈춰버리기 때문에 Full GC가 일어나는 정도와 시간은 어플리케이션의 성능과 안정성에 아주 큰 영향을 미친다.



## GC의 역할

1. 메모리 할당
2. 사용 중인 메모리 인식
3. 사용하지 않는 메모리 인식



## GC가 중요한 이유

GC중 Minor GC의 경우 보통 0.5 이내에 끝나기 때문에 큰 문제가 되지 않지만, Full GC의 경우 자바 애플리케이션이 멈춰버리기 때문에 문제가 될 수 있다.

멈추는 동안 사용자의 요청이 Queue에 들어있다가, 순간적으로 요청이 한꺼번에 들어오기 땜누에 과부하에 의해 여러 장애를 만들 수 있다.

따라서 원활한 서비스를 위해서 GC가 어떻게 일어나게 하느냐가 시스템의 안정성과 성능에 큰 변수로 작용한다.



## 다양한 GC의 알고리즘

## [ Default Collector ]
> 전통적인 GC의 방식
> 
> Minor GC로 Scanvenge를 Full GC로 Mark&Compact 알고리즘을 사용한다.


## [ Parallel GC ]
자바는 멀티 스레드 환경을 지원하지만, 하나의 CPU에서는 동시에 하나의 스레드 밖에 수행할 수 없어서 예전에는 하나의 CPU에서만 GC를 수행하였지만 후에 하나의 CPU에서 동시에 여러 개의 스레드를 실행할 수 있는 하이퍼스레딩 기술이나 여러개의 CPU를 동시에 장착한 하드웨어의 보급으로 하나의 하드웨어에서 동시에 여러 개의 스레드를 수행할 수 있게 되었다.

Parallel GC에는 크게 두 가지 종류의 옵션을 가지고 있는데, Low-pause 방식과 Throughput 방식이 있다.

### Low-pause 방식
> GC가 일어날 때 애플리케이션이 멈추는 현상을 최소화하는데 역점을 두었다.

### Throughput 방식
> Minor GC가 발생하였을 때 되도록이면 신속하게 수행하도록 throughput에 중점을 두었다.

## [ Concurrent GC ]
Full GC 즉, Old 영역을 GC하는데 시간이 길고 애플리케이션이 순간적으로 멈춰버리므로, 애플리케이션이 멈추는 현상을 최소화 하는 GC 방식이다.

Full GC에 소요되는 작업을 애플리케이션을 멈추고 진행하는 것이 아니라, 일부는 애플리케이션이 돌아가는 단계에서 수행하고 최소한의 작업만을 애플리케이션이 멈췄을 때 수행하는 방식이다.

## [ Incremental GC(Train GC) ]
> Full GC에서 의해서 애플리케이션이 멈추는 시간을 줄이기 위함
>
> Minor GC가 일어날 때마다 Old 영역을 조금씩 GC 해서 Full GC가 발생하는 횟수나 시간을 줄이는 방식

Incremental GC는 많은 자원을 소모하고 Minor GC를 자주 일으켜서, 그리고 Incremental GC를 사용한다고 Full GC가 없어지거나 그 횟수가 획기적으로 줄어드는 것이 아니다. 오히려 느려지는 경우가 많으므로 반드시 테스트를 거치고 사용해야한다.



* * *

### ❓ 관련 질문
Q1. 

Q2. 

Q3. 


### 📖 참고 자료
[명품자바에센셜](http://www.yes24.com/Product/Goods/63041975)

[GC(Garbage Collector) 종류 및 내부 원리](https://dongwooklee96.github.io/post/2021/04/04/gcgarbage-collector-%EC%A2%85%EB%A5%98-%EB%B0%8F-%EB%82%B4%EB%B6%80-%EC%9B%90%EB%A6%AC.html)
