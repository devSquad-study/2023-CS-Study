# 🎈CountdownLatch vs CyclicBarrier

`CountdownLatch`와 `Cyclicbarrier`은 쓰레드를 관리해주는 클래스입니다.

## CountdownLatch

`CountdownLatch`는 어떤 쓰레드가 다른 쓰레드에서 작업이 완료될 때까지 기다릴 수 있도록 해주는 클래스이다.

## CountDownLatch 작동 원리

CountDownLatch는 다음과 같이 생성할 수 있다. 

인자로 Latch의 숫자를 전달한다.

``` java
CountDownLatch countDownLatch = new CountDownLatch(5);
```

다음과 같이 `countDown()`을 호출하면 Latch의 숫자가 1개씩 감소합니다.
``` java
countDownLatch.countDown();
```

`await()`은 Latch의 숫자가 0이 될 때까지 기다리는 코드입니다.
``` java
countDownLatch.await();
```

## CyclicBarrier
`CountdownLatch`와 비슷하지만 다른 점은 다른 쓰레드가 전부 대기 상태가 되었을 때 모든 스레드의 대기 상태가 해제가 되고 재사용이 가능해진다.


# 면접 질문
- `Countdownlatch`와 `Cyclicbarrier`의 차이점은 무엇인가요?

# 🛠레퍼런스
- [간서치의 IT세상](https://younghwannam.blogspot.com/2019/12/java-countdownlatch-cyclicbarrier-phaser.html)
- [codechacha.com](https://codechacha.com/ko/java-countdownlatch/)
