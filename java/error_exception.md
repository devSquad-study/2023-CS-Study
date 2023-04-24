# Error와 Exception

## Error
Error는 컴퓨터 시스템의 동작 동증 예기치 않았던 이상 상태가 발생하여 수행 중인 프로그램이 영향을 받을 경우입니다.
시스템 레벨에서 발생하여, 개발자가 어떻게 조치할 수 없는 수준을 의미합니다.

## Exception
Exception은 컴퓨터 시스템의 동작 도중 예기치 않았던 이상 상태가 발생하여 수행 중인 프로그램이 영향을 받는 경우입니다. 개발자가 구현한 로직에서 발생하며 개발자가 예측하여 방지할 수 잇기에 상황에 맞게 예외처리(Exception Handle)를 해야 합니다

Error의 몇 가지를 설명하겠습니다.
- StackOverflowError: 호출의 깊이가 깊어지거나 재귀가 지속되어 stack overflow 발생 시 던져지는 오류
- OutOfMemoryError: JVM이 할당된 메모리의 부족으로 더이상 객체를 할당할 수 없을 때 던져지는 오류

### Exception의 종류
에외는 Checked Exception, Unchecked Exception으로 두 개의 종류로 나누어집니다.
- Checked Exception: 예외처리가 필수이며, 처리하지 않으면 컴파일이 되지 않습니다.
- Unchecked Exception: 컴파일 때 체크되지 않고, runtime에 발생한다.

## Exception handler(예외 처리)
Java에서 모든 예외가 발생함녀 ~Exception 객체를 생성합니다.
- 직접 `try ~ catch`를 이용해서 예외를 처리하는 방식
- throws Exception을 이용해서 발생한 예외의 책임을 호출
  하는 쪽이 책임지도록 하는 방식
- Exception 전환으로 throws Exception와 try ~ catch문을 활용하여 적절한 Exception으로 전환해서 넘기는 방법