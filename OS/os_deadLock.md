> [해당 포스팅](https://hello-judy-world.tistory.com/190)에서도 내용을 확인할 수 있습니다.

> written by [judy](https://github.com/ParkJungYoon)

<u>락(lock)</u>은 동기화를 보장하는 툴(tool)이다.

락을 사용하여 동기화를 수행하다 보면 필연적으로 <u>데드락(Deadlock)</u>이라는 부작용이 생길 수 있다.

데드락 상태가 되면 더 이상 프로세스나 스레드가 진행하지 못하기 때문에 이를 잘 파악하는 것은 중요하다.

또한 데드락 개념은 DB에서 **'분산 서버 동시성 이슈 해결 방안'**으로 비관적인 락을 사용할 때 등장하기도 한다.

> **비관적인 락** : 동시에 연산이 실행되지 않도록 Lock(잠금)을 걸어서 다른 연산이 끼어들지 못하도록 한다. 단점으로는 성능이 느려지고, 데드락 상태에 걸릴 수 있다.

## 🚗  교착상태 (Deadlock)

> (두 개 이상의) 일련의 프로세스 혹은 스레드들이 **서로가 가진 자원(resource)을 기다리며 block된 상태**

> `자원(resource)` : 하드웨어, 소프트웨어 등을 포함하는 개념
ex. I/O device, CPU cycle, memory space, semaphore 등

<div align='center'>
    <img src="img/deadlock.png" width="550px">
</div>

그림에서 숫자가 자원이고 자동차가 프로세스다.

각각의 자동차가 모두 두 개의 자원을 확보하여 지나가려고 한다.

이때, 모두 한 가지의 자원을 선점하는데에는 성공했지만 그 이후 차량은 다른 차량이 가지고 있어 지나갈 수 없는 교착상태에 빠지게 되었다.

이 상황은 그 이후에 아무것도 진행할 수 없어 상당히 좋지 않다.

<br>

### ✔️ Point 1 : Deadlock 발생의 4가지 조건

아래 조건이 모두 성립해야 <u>데드락이 발생</u>한다.

### 1) Mutual exclusion (상호 배제)

- 매 순간 하나의 프로세스만이 자원을 사용할 수 있음
- 즉, 자원을 **공유해서 사용할 수 없다.**

### 2) No preemption (비선점)

- 프로세스는 자원을 스스로 내어놓을 뿐 강제로 <u>빼앗기지 않음</u>
- 즉, 자원 반환(release)은 오직 그 리소스를 취득한 프로세스만 할 수 있다.

### 3) Hold and wait (점유 대기)

- 자원을 가진 프로세스가 다른 자원을 기다릴 때 <u>보유 자원을 놓지 않고 계속 가지고 있음</u>
- 즉, 프로세스가 이미 하나 이상의 자원을 취득한(hold) 상태에서 다른 프로세스가 사용하고 있는 자원을 추가로 기다린다.(wait)

### 4) Circular wait (순환 대기)

- 자원을 기다리는 프로세스 간에 **사이클**이 형성되어야 함
- 즉, 프로세스들이 **순환(circular) 형태**로 서로의 리소스를 기다린다.

<br>

### ✔️  Point 2 : OS의 Deadlock 처리 방법

가장 먼저 소개된 방법이 Deadlock에 대한 강한 처리 방법이다.

### 1) Deadlock Prevention (예방)

- 자원 할당 시 Deadlock의 4가지 필요 조건 중 **어느 하나가 만족되지 않도록 하는 것**
- **시스템 레벨에서** 설계를 통해 데드락이 발생할 조건 하나를 없애는 방법

**[ Mutual exclusion (`상호 배제`) ]**

- 공유해서는 안되는 자원의 경우 반드시 성립해야 함

**[ No preemption (`비선점`) ]**

- process가 어떤 자원을 기다려야 하는 경우 이미 보유한 자원이 선점됨 (다른 프로세스가 선점 가능하도록 함)
- 모든 필요한 자원을 얻을 수 있을 때 그 프로세스는 다시 시작됨
- state를 쉽게 save하고 restore할 수 있는 지원에서 주로 사용 (CPU, memory)

**[ Hold and wait (점유 대기) ]**

- 프로세스가 자원을 요청할 때 다른 어떤 자원도 가지고 있지 않아야 함
- `방법1` | 프로세스 시작 시 모든 필요한 자원을 할당받게 하는 방법 (모든 것을 Hold하고 시작)
    - `<단점>` 단계마다 필요한 자원이 다를 텐데 지금 사용하지 않을 자원까지 hold하고 있으면 자원 효율이 떨어지고, 자원을 모두 확보되지 못한 경우 계속 wait하는 상황이 될 수 있다.
- `방법2` | 자원이 필요할 경우 보유 자원을 모두 놓고 다시 요청 
    - 즉, 자원을 전혀 가지지 않은 상태에서만 자원을 요청할 수 있도록 제약조건을 줌

**[ Circular wait (`순환 대기`) ]** : 가장 많이 사용 

- 모든 자원 유형에 할당 **순서를 정하여 정해진 순서**(오름차순)대로만 자원 할당
- 예를 들어 순서가 3인 자원 Ri를 보유 중인 프로세스가 순서 1인 자원 Rj을 할당받기 위해서는 우선 Ri를 release해야 한다. (사이클이 생길 우려가 없어짐)

👉 **Utilization 저하, throughput 감소, starvation 문제**

### 2) Deadlock Avoidance (회피)

- **실행 환경에서** 자원 요청에 대한 부가적인 정보를 이용해서 Deadlock의 가능성이 없는 경우에만 자원을 할당
    - **부가적인 정보** : 현재 사용 가능한 자원, 이미 할당된 자원, 앞으로 있을 자원 요청이나 반환 등
- 시스템 state가 원래 state로 돌아올 수 있는 경우에만 자원 할당

**[ Banker algorithm (은행원 알고리즘) ]**

- 은행에서 모든 고객의 요구가 충족되도록 현금을 할당하는데서 유래
- 자원 요청을 허락해 줬을 때 데드락이 발생할 가능성이 있으면 자원을 할당해도 안전할 때까지 계속 요청을 거절하는 알고리즘

### 3) Deadlock Detection and recovery (탐지 & 회복)

- Deadlock 발생은 허용하되 그에 대한 <u>detection 루틴을 두어 Deadlock 발견 시 recover</u>

**[ 복구 전략 ]**

1. 프로세스를 종료한다. (데드락에 빠진 프로세스 모두 강제 종료)(작업 중인 자료를 잃을 수 있어 risk가 큼)
2. 자원의 일시적인 선점을 허용한다. 
 

### 4) Deadlock Ignorance (무시)

- Deadlock을 시스템이 <u>책임지지 않음</u>
- UNIX를 포함한 대부분의 OS가 채택

<br>

### ✔️  기아 상태 (Starvation)

> 특정 프로세스보다 우선순위가 낮아 원하는 자원을 계속 할당받지 못하는 상태이다. 주로 priority scheduling에서 일어난다.

<br>

### ✔️  프로그래밍 레벨에서 데드락 (with Java)

#### 🤷‍♀️ 자바에서 교착상태(Deadlock) 예시

```java
public class Main {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
 
        // lock1을 먼저 선점
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("[t1] get lock1");
                synchronized (lock2) {
                    System.out.println("[t1] get lock2");
                }
            }
        });
 
        /*
          lock2를 먼저 선점
          방법1: lock1 선점 후 lock2를 선점하도록 순서를 변경 -> 사이클이 생기지 않아 데드락 발생 X
          방법2: 중첩해서 lock을 취득하려고 하기 때문에 hold and wait 상태 | 코드를 분리해서 hold and wait가 되지 않도록 함
         */
        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("[t2] get lock2");
                synchronized (lock1) {
                    System.out.println("[t2] get lock1");
                }
            }
        });
 
        t1.start();
        t2.start();
    }
}
```

#### 💁‍♀️💡 `방법1` : Circular wait

> 모든 자원 유형에 할당 순서를 정하여 정해진 순서(오름차순)대로만 자원 할당

스레드 t2도 t1처럼 lock1을 선점한 다음 lock2를 선점하도록 **순서를 변경**한다.

그러면 사이클이 생기지 않아 데드락을 예방할 수 있다.

#### 💁‍♀️💡 `방법2` : Hold and wait

> 자원이 필요할 경우 보유 자원을 모두 놓고 다시 요청

문제 상황을 보면 스레드1의 경우 lock1을 취득한 다음 lock2를 선점하려고 한다.

즉, 중첩해서 lock을 선점하려고 하기 때문에 `hold and wait` 상태이다.

그래서 중첩하지 않고 따로따로 사용할 수 있도록 코드를 구현할 수 있다.

### 🔅 결론 🔅

> 👱‍♂️ **`형`** : 농구공 🏀 줄래?

> 👦 **`동생`** : 축구공 ⚽️ 주면 줄게

---

### 📢 같이 공부하면 좋을 면접 질문

- 데드락이 무엇인가요?
- 데드락 발생조건 4가지를 설명해 주세요.
- 데드락의 해결방법에 대해서 설명해 주세요.

---

### 📌 Reference  

- [유튜브 쉬운 코드, "데드락(교착상태)은 프로그램에 치명적이죠 T^T 언제 발생하고 어떻게 해결하는지 살펴봅시다~! 간단한 자바 예제도 있어요~!!"](https://youtu.be/ESXCSNGFVto)
- [이화여대, 반효경 교수님, 운영체제](http://www.kocw.net/home/cview.do?cid=3646706b4347ef09)