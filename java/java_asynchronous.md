# 자바의 비동기 처리

## 동기와 비동기

동기 (sync) : A라는 작업이 끝나는 동시에 B라는 작업을 시작한다

비동기 (async) : A라는 작업의 완료 여부와 상관없이 B라는 작업을 시작한다.

비동기 방식은 작업들이 서로의 작업 시작 및 종료 시간에 영향을 받지 않고, 별도의 작업 시작/종료 시간을 가진다.

모든 비동기 방식은 멀티 스레드에서 작동한다.

![java_asynchronous_01](/java/img/java_asynchronous_01.png)

위 코드는 동기 코드이다. 작업1과 작업2는 서로 연관이 없고 작업2가 더 빨리 끝나지만 동기이므로 작업1이 끝난 후 작업2가 시작되게 된다.

![java_asynchronous_02](/java/img/java_asynchronous_02.png)

위 코드는 비동기로 바꾼 코드이다. 이 경우 실행 시간이 긴 작업1을 다른 스레드에게 맡기고, 메인 스레드는 밑으로 내려가 작업2를 시작한다.

## 자바에서 비동기를 처리하는 방법

## 1. Callback

다른 주체에게 맡긴 작업이 끝나면 다른 주체 쪽에서 본 주체가 전해 준 콜백 함수를 실행하는 방법

### CompletionHandler

비동기 I/O 작업의 결과를 처리하기 위한 목적으로 만들어 졌으며, 콜백 객체를 만드는데 사용된다. completed() 메소드를 오버라이드해서 콜백을 구현하고, failed() 메소드를 오버라이드해 작업이 실패했을 때의 처리를 구현한다.

![java_asynchronous_03](/java/img/java_asynchronous_03.png)

작업3 시작 → 작업1 시작 → 작업2 시작 (작업1이 성공하고 completed()메서드 실행) → 작업3 종료 

→ 작업 2 종료

### 함수형 인터페이스

![java_asynchronous_04](/java/img/java_asynchronous_04.png)

작업1을 마친 귀 callback으로 받아온 함수형 인터페이스를 싱행하는 메소드를 호출한다.

execute()의 인자로 execute()의 작업이 모두 끝난 뒤 실행 될 콜백을 작성했다.

## 2. Future

다른 주체에게 작업을 맡긴 상태에서 본 주체 쪽에서 작업이 끝났는지 직접 확인

![java_asynchronous_05](/java/img/java_asynchronous_05.png)

확인하는 방법은 두 가지로 하나는 isDone()이나 isCanceled() 메소드로 블로킹 없이 작업을 완료했는지의 여부만 확인하는 방법이고, 다른 하나는 get()으로 작업이 완료될 때까지 블로킹된 상태로 대기하는 방법이다.

오래 걸리는 작업을 다른 주체에게 맡겨 두고 get()을 호출하기 전까지 이 쪽에서 할 일을 하다가, 작업을 마치면 get()을 호출해 작업의 결과를 받아오는 식으로 사용한다.

![java_asynchronous_06](/java/img/java_asynchronous_06.png)

실행결과

### CompletableFuture

Future는 다른 주체의 결과를 얻으려면 잠시라도 블로킹 상태에 들어갈 수 밖에 없는 한계가 있어 등잔한게 CompletableFuture이다.

![java_asynchronous_07](/java/img/java_asynchronous_07.png)

작업3 시작 -> 작업1 시작 -> 작업1 종료 -> 작업1 결과물: hash -> 작업2 시작 -> 작업3 종료 -> 작업2 종료

스레드 생성 후 작업1을 supplyAsync()를 통해 호출하고, 작업2를 작업1이 끝난 직후 블로킹 없이 시작할 수 있도록 thenAccept()를 통해 호출하고 있다.
그 밑에는 main스레드에서 작업3을 불러 시작하는 것도 볼 수 있다. 이렇게 CompletableFuture를 사용하면 이전 작업의 결과를 get()을 사용해 블로킹으로 가져올 필요 없이, then()함수를 통해 논블로킹을 유지하며 바로 사용할 수 있다.
