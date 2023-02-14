# TCP/IP 4계층 모델

#### Layer 3 - 전송 계층 : 송신자와 수신자를 연결하는 통신 서비스, 데이터 전달 담당

## 1. TCP / UDP 란?

전송계층에서 사용하는 프로토콜

패킷을 한 컴퓨터에서 다른 컴퓨터로 전달해주는 IP 프로토콜 기반으로 구현되어 있음
</br>

### [ TCP ( Transmission Control Protocol ) ]

![](/Network/img/tcp_explanation.png){: width="400"}

- 데이터 경계를 구분하지 않음 : 바이트 스트림(byte-stream) 서비스
- 연결 지향 프로토콜(수신여부 확인O) -> 신뢰도 높지만 속도가 느림
- 1:1 통신
- <b>가상회선 패킷 교환방식</b>을 사용 : 패킷 사이 순서 보장
- HTTP, Email, File transfer

#### 가상회선 패킷 교환 방식

- 각 패킷에는 가상회선 식별자가 포함
- 모든 패킷을 전송하면 가상회선이 해제되고 패킷들은 전송된 <b>순서대로</b> 도착하는 방식
</br>

###  [ UDP ( User Datagram Protocol ) ]

![](/Network/img/udp_explanation.png){: width="400"}

- 데이터 경계를 구분함 : 데이터그램(datagram) 서비스
- 비 연결 지향 프로토콜(수신여부 확인X) -> 신뢰도 낮지만 속도가 빠름
- 1:1 or 1:N or N:N 통신
- 단순히 데이터만 주는 <b>데이터그램 패킷 교환 방식</b> 사용 : 순서 보장 X
- DNS, Broadcasting

#### 데이터그램 패킷 교환 방식

- 각 패킷이 독립적으로 이동하며 최적의 경로를 선택
- 하나의 메시지에서 분할된 여러 패킷은 서로 다른 경로로 전송될 수 있음
- <b>도착순서가 다를 수</b>있는 방식


##### 패킷 교환 방식 비교 사진

![](/Network/img/datagram_virtualcircuits.png){: width="400"}

##### 데이터경계 구분 비교 사진

![](/Network/img/data_demarcation.jpg){: width="400"}


## 2. TCP의 연결 및 해제 과정

#### 포트(PORT) 상태 정보
- <b>CLOSED</b> : 포트가 닫힌 상태
- <b>LISTEN</b> : 포트가 열린 상태로 연결 요청 대기 중
- <b>SYN_RCV</b> : 요청을 받고 상대방의 응답을 기다리는 중
- <b>ESTABLISHED</b> : 포트 연결 상태

#### 플래그 정보
- TCP Header에는 CONTROL BIT(플래그 비트, 6bit)가 존재하며, 각각의 bit는 "URG-ACK-PSH-RST-SYN-FIN"의 의미를 가짐
- <b>SYN(Synchronize Sequence Number/000010)</b> : 연결 설정. Sequence Number를 랜덤으로 설정하여 세션을 연결하는 데 사용하며, 초기에 Sequence Number를 전송
- <b>ACK(Acknowledgement/010000)</b> : 응답 확인. 패킷을 받았다는 것을 의미
- <b>FIN(Finish/000001)</b> : 연결 해제. 세션 연결을 종료시킬 때 사용되며, 더 이상 전송할 데이터가 없음


###  [ TCP 연결 성립 과정 : 3-웨이 핸드 셰이크 ]

![](/Network/img/tcp_3_way_handshake.png)

1. <b>SYN 단계</b> : 클라이언트는 서버에 클라이언트 ISN을 담아 SYN을 보냄
- ISN : 새로운 TCP 연결의 첫 번째 패킷에 할당된 임의의 시퀀스 번호, 장치마다 다를 수 있음

2. <b>SYN + ACK 단계</b> : 서버는 클라이언트의 SYN을 수신하고 ISN을 보내며 승인번호로 클라이언트의 ISN+1을 보냄

3. <b>ACK 단계</b> : 클라이언트는 서버의 ISN +1 한 값인 승인번호를 담아 ACK를 서버에 보냄


### [ TCP 연결 해제 과정 : 4-웨이 핸드 셰이크 ]

![](/Network/img/tcp_4_way_handshake.png)


1. 클라이언트가 연결을 닫으려고 할 때 <b>FIN</b>으로 설정된 세그먼트 보냄, 클라이언트는 FIN_WAIT_1 상태로 들어가고 서버의 응답 기다림

2. 서버: 클라이언트로 <b> ACK승인 세그먼트 </b> 보냄, <b>CLOSE_WAIT</b> 상태 / 클라이언트 : FIN받기 위해 <b>FIN_WAIT_2</b> 상태

3. 서버: ACK를 보내고 일정 시간 후 클라이언트에 <b>FIN</b>이라는 세그먼트 보냄

4. 클라이언트: <b>TIME_WAIT</b> 상태, 서버로 해지 준비가 되었다는 <b>ACK</b>보냄 / 서버: CLOSED상태가 됨, 이후 클라이언트는 어느 정도의 시간을 대기한 후 연결이 닫히고 모든 자원의 연결이 해제됨

#### TIME_WAIT

소켓이 바로 소멸되지 않고 일정 시간 유지되는 상태

지연 패킷, 두 장치간 접속 오류 등 의도치 않은 에러로 인해 연결이 데드락으로 빠지는 문제점을 방지하는데 쓰임

## ❓ 관련 질문
#### Q1. 만약 Server에서 FIN 플래그를 전송하기 전에 전송한 패킷이 Routing 지연이나 패킷 유실로 인한 재전송 등으로 인해 FIN 패킷보다 늦게 도착하는 상황이 발생하면 어떻게 될까?
A. 이러한 현상에 대비하여 Client는 Server로부터 FIN 플래그를 수신하더라도 
일정시간(Default: 240sec)동안 세션을 남겨 놓고 잉여 패킷을 기다리는 과정을 거친다. (TIME_WAIT 과정)

#### Q2. TCP의 연결 성립 과정과 연결 해제 과정의 단계수가 차이 나는 이유는?
A. Client가 데이터 전송을 마쳤다고 해도 Server는 아직 보낼 데이터가 남아있을 수 있기 때문에 
일단 FIN에 대한 ACK만 보내고, 데이터를 모두 전송한 후 자신도 FIN메세지를 보내기 때문이다.

#### Q3. 초기 Sequence Number인 ISN을 0부터 시작하지 않고 난수를 생성해서 설정하는 이유는?
A. Connection을 맺을 때 사용하는 포트(Port)는 유한 범위 내에서 사용하고 시간이 지남에 따라 재사용된다.
따라서 두 통신 호스트가 과거에 사용된 포트 번호 쌍을 사용하는 가능성이 존재한다.
Server측에서는 패킷의 SYN을 보고 패킷을 구분하게 되는데 난수가 아닌 순차적인 Number가 전송된다면
이전의 Connection으로부터 오는 패킷으로 인식할 수 있다. 이런 문제의 발생 가능성을 낮추기 위해 ISN을 난수로 설정한다.


## 📖 참고 자료

[TCP와 3-Way, 4-Way Handshake란? (개념/ 동작 방식)](https://jeongkyun-it.tistory.com/180)

[Packet Switching, 패킷 교환 방식에 대해서](https://wonit.tistory.com/553)

[3 Way-Handshake](https://hyemsinabro.tistory.com/m/157)

[TCP/UDP와 3 -Way Handshake & 4 -Way Handshake](https://velog.io/@averycode/%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-TCPUDP%EC%99%80-3-Way-Handshake4-Way-Handshake)

[[네트워크] TCP/UDP 간단 정리](https://rural-mouse.tistory.com/35)

[TCP 와 UDP 차이를 자세히 알아보자](https://velog.io/@hidaehyunlee/TCP-%EC%99%80-UDP-%EC%9D%98-%EC%B0%A8%EC%9D%B4)
 
 
 
