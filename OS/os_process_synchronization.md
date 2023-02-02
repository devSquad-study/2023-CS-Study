> [해당 포스팅](https://hello-judy-world.tistory.com/193)에서도 내용을 확인할 수 있습니다.

### [ 데이터 접근 ]

데이터가 저장되어 있는 위치로부터 데이터를 읽어와서 연산한 뒤, 연산한 결과를 이전에 저장되어있던 그 위치에 다시 저장한다.

데이터를 읽기만 하면 문제가 없는데, 데이터를 연산하고 수정하게 되면 누가 먼저 읽어 갔는지에 따라 결과가 달라질 수 있다.

이때 발생할 수 있는게 **Synchronization(동기화)** 문제이다.

*추상적인 예시*
<div align='center'>
    <img src="img/os_synchronization_data_access.png" width="550px">
</div>

<br>

## 🤼‍♂️  Process Synchronization

> 공유 데이터(shared data)의 동시 접근(concurrent access)은 데이터의 불일치 문제(inconsistency)를 발생시킬 수 있다.

> 따라서 일관성(consistency) 유지를 위해서는 협력 프로세스(cooperating process) 간의 **실행 순서**(orderly execution)를 정해주는 메커니즘이 필요하다.

<br>

### ✔️  race condition (경쟁 상태)

> 여러 프로세스/스레드가 동시에 같은 데이터를 조작할 때 타이밍이나 접근 순서에 따라 결과가 달라질 수 있는 상황

> 이것을 막기 위해서는 concurrent processs는 동기화(synchronize)되어야 한다.

- Storage-Box를 공유하는 Execution-Box가 여러 개 있는 경우 <u>race condition</u> 가능성 있다.
    - Count++ 연산이 실행되는 동안 연산 이전 데이터를 읽어간 Count-- 에서 연산을 마치고 저장하면 Count-- 연산만 적용된다.

<div align='center'>
    <img src="img/os_synchronization_race_condition.png" width="550px">
</div>

### [ OS에서 race condition 발생 ]

### 1) kernel 수행 중 인터럽트 발생 시

> ex) Initial counter = 10

커널모드 running 중 Count++ 하고 있었다.

(1번)에 CPU 레지스터로 데이터를 읽어온 상황에서 (2번)인터럽트가 들어오면 인터럽트 처리루틴이 수행되며 Count--를 하고 반영한다.

그리고 다시 (3번)이 실행되는데 이미 1번에서 읽어오는 작업은 끝났기 때문에 Count++후 저장한다.  

<div align='center'>
    <img src="img/os_synchronization_race_condition1.png" width="550px">
</div>

🙋‍♀️  **Expected** : Counter = 10

💁‍♀️  **Unexpected** : Counter = 11

-> 그래서 running 중에 작업이 끝날 때까지는 disable interrupt 상태로 해서 현재 작업이 끝나기 전까지는 인터럽트가 실행되지 않도록 한다.

### 2) Process가 system call을 하여 kernel mode로 수행 중인데 context switch가 일어나는 경우

-*이때 U는 유저모드, K는 커널모드*

<div align='center'>
    <img src="img/os_synchronization_race_condition2.png" width="550px">
</div>

-> 커널 모드에서 수행 중일 때는 CPU를 preempt하지 않는다. 커널 모드에서 유저 모드로 돌아갈 때 preempt한다.

(CPU 할당 시간에 편차가 생길 수 있다.)

### 3) Multiprocessor에서 shared memory 내의 kernel data

<div align='center'>
    <img src="img/os_synchronization_race_condition3.png" width="550px">
</div>

**(방법1)**

한 번에 하나의 CPU만이 커널에 들어갈 수 있도록 하고, 하나의 커널을 lock으로 막고, 커널을 빠져나올 때 unlock. (커널 전체를 lock하기 때문에 비효율적)

**(방법2)** 

커널 내부에 있는 각 공유 데이터에 접근할 때마다 그 데이터에 대한 lock/unlock

<br>

### ✔️  synchronization (동기화)

여러 프로세스/스레드를 동시에 실행해도 공유 데이터의 일관성을 유지하는 것
 
<br>

### ✔️  critical section (임계 영역)

공유 데이터의 일관성을 보장하기 위해 하나의 프로세스/스레드만 진입해서 실행 가능한 영역

### [ 프로세스 일반적인 구조 ]

```
do {
    entry section       // 공유 데이터에 접근하기 이전에 lock을 건다 - acquire lock
    	critical section    // 공유 데이터를 접근하는 코드
    exit section        // 끝나면 unlock(다른 프로세스가 critical-section에 들어갈 수 있게) - release lock
    	remainder section
} while(1);
```

- `Problem` : 하나의 프로세스가 <u>critical section</u>에 있을 때 다른 모든 프로세스는 critical section에 들어갈 수 없어야 한다.

<div align='center'>
    <img src="img/os_synchronization_critical_section.png" width="550px">
</div>

### [ critical section problem 해결책이 되기 위한 조건 ]

아래 조건이 모두 만족해야한다.

- **mutual exclusion** (`상호 배제`)
    - 한 번에 하나의 프로세스/스레드가 critical section에서 실행할 수 있다.
- **progress** (`진행`)
    - 아무도 critical section에 있지 않으면 들어가고자 하는 프로세스가 있으면 critical section에 들어가게 해주어야 한다.
- **bounded waiting** (`한정된 대기`)
    - 하나의 프로세스/스레드가 critical section에 들어가기 위해서 무한정 기다리는 상황이 되면 안된다.
    - 다른 프로세스들의 기아(Starvation)을 막기 위해서

<br>
---

## 💡 Solution