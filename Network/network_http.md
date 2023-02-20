> [해당 포스팅](https://hello-judy-world.tistory.com/186)에서도 내용을 확인할 수 있습니다.

> written by [judy](https://github.com/ParkJungYoon)

# HTTP 진화 과정 (HTTP/1.0부터 HTTP/3까지) 

기본적으로 HTTP는 전송 계층 위에 있는 애플리케이션 계층으로서 웹 서비스 통신에 사용된다. 이런 웹은 어떻게 시작되었을까.

### [ World Wide Web의 발명 ]

HTTP는 World Wide Web에 내재된 프로토콜이다. 팀 버너스리가 1989년부터 1991년에 발명하였고 초기에 Mesh라고 불리다가 1990년에 구현 과정에서 **World Wide Web(WWW)** 으로 이름을 바꿨다. 

> `World Wide Web(WWW)` : HTTP라는 프로토콜을 이용해 HTML 파일을 주고받을 수 있는 공간

<br>

## 🥚 HTTP/0.9

> 원-라인 프로토콜

HTTP/0.9는 정말 단순한 서버-클라이언트 구조를 따른다.

- **요청**: 단일 라인으로 구성
- **리소스 경로**: `GET` 메서드만 가능

```
<!-- HTTP request -->
GET /mypage.html
 
<!-- HTTP response -->
<html>
Simple HTML Page
</html>
```

### [ 특징 ]

- HTTP 헤더 없음 -> 즉, HTML 파일만 전송 가능
- 상태 혹은 오류 코드 없음

<br>

## 🥚 HTTP/1.0

> 확장성 만들기, 기존 HTTP 기능을 확장함

HTTP /0.9가 굉장히 제한적이었으므로, 확장성을 높이기 위한 여러 개발자들의 시도가 빠르게 이루어졌고 이에 HTTP /1.0이 등장했다.

### [ 특징 ]

- **버전 정보**가 각 요청에 포함된다.
- 요청 메서드가 GET, HEAD, POST 세 가지로 확장되었다.
- 상태 코드가 각 응답의 시작 부분에 포함되어, 브라우저가 해당 요청에 대한 성공,실패를 알 수 있었고 동작할 수 있었다.
- HTTP 헤더 개념이 등장했다. 이는 서버, 브라우저의 메타데이터 전송을 허용하며 프로토콜을 유연, 확장 가능하게 만들었다.
- 새로운 HTTP 헤더의 등장(Content-Type 덕분에)으로 HTML 파일 이외의 다른 파일도 전송할 수 있게 되었다.

```
<!-- HTTP request -->
GET /mypage.html HTTP/1.0
User-Agent: NCSA_Mosaic/2.0 (Windows 3.1)
 
<!-- HTTP response -->
200 OK
Date: Tue, 15 Nov 1994 08:12:31 GMT
Server: CERN/3.0 libwww/2.17
Content-Type: text/html
<HTML>
A page with an image
  <IMG SRC="/myimage.gif">
</HTML>
```

<br>

## 🐣 HTTP/1.1

> 표준화된 HTTP (표준 프로토콜)

HTTP/1.1은 모호함을 명확하게 하고 많은 개선 사항들을 도입했다.

### [ 특징 ]

### 1. 연결 재사용

HTTP/1.0에서는 기본적으로 한 연결당 하나의 요청을 처리하고 요청에 따른 응답이 수신되면 TCP 연결을 바로 종료했다.

웹 페이지가 복잡해지면서 한 페이지에서 여러 번 HTTP 요청이 발생했을 때 매번 새로 TCP handshake 과정을 거쳐야 해서 속도가 느려졌다. (RTT 증가)

> `RTT`: 패킷이 목적지에 도달하고 나서 다시 출발지로 돌아오기까지 걸리는 시간이며 패킷 왕복 시간

* TCP 가상 회선 방식은 신뢰성을 보장하지만 속도가 느리다는 단점이 있다.

그래서 기본적으로 한 번 수립한 <u>연결을 재사용</u>하게 설정했다.
 
<div align='center'>
    <img src="img/http1.0_http1.1.png" width="550px">
</div>

### [ Keep-Alive Header ]

이때 연결을 유지하는 시간이 길어지면 서버에 부하가 생기기 때문에 연결을 유지하는 시간을 제한한다.

(HTTP/1.0에서도 있었지만 표준화가 되어 있지 않았고, HTTP/1.1부터 표준화가 되어 기본 옵션으로 설정되었다.)

### 2. 파이프라이닝(Pipelining)

기존에는 여러 요청을 보낼 때 한 요청과 응답을 끝내고 다음 요청을 보냈다면 파이프라이닝 기법은 첫번째 요청에 대한 응답이 완전히 전송되기 이전에 두번째 요청 전송을 보낼 수 있도록 하여, 커뮤니케이션 레이턴시를 낮췄다.

여러 요청을 한 번에 보낼 수 있어 지연을 개선시켰다.

<div align='center'>
    <img src="./img/pipelining.png" width="550px">
</div>

### 3. 캐시 제어 메커니즘이 도입
> 요청과 응답에 대한 메타 정보를 담는다.

HTTP로 통신을 할 때 Client는 네트워크를 거치는 시간을 소비하고, Server는 요청을 처리하는데 걸리는 시간 혹은 부하를 소비한다. 

이 과정에서 Client가 이전에 받은 데이터와 새로 요청한 데이터가 같다면 이전과 같이 한 번 더 과정을 거치는 것은 낭비일 수 있다.

이러한 낭비를 줄이기 위한 해결책으로 사용할 수 있는 방법이 HTTP에서 제공하는 **Cache-Control**이다. 적절하게 Cache-Control을 사용함으로써, 상황에 따라 Server는 부하를 줄일 수 있고, Client는 네트워크를 거치는 시간을 아낄 수 있다.

때에 따라 서버나 클라이언트에게 HTTP 캐시를 위해 명시된 지시자를 제공할 필요가 있다. Cache-Control 헤더를 이 목적으로 사용한다.﻿


### 4. 청크 전송 인코딩
> HTML을 분할해 전송하는 방법이다.

### 5. 호스트 헤더(Host Header)
>  동일 IP에 여러 도메인을 호스트 할 수 있게 해준다.

HTTP 1.1은 가상 호스팅(Virtual Hosting)이 가능해졌기 때문에 하나의 IP 주소에 여러 개의 도메인을 적용시킬 수 있다.

```
<!-- HTTP request -->
GET /en-US/docs/Glossary/Simple_header HTTP/1.1
Host: developer.mozilla.org
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:50.0) Gecko/20100101 Firefox/50.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
Accept-Language: en-US,en;q=0.5
Accept-Encoding: gzip, deflate, br
Referer: https://developer.mozilla.org/en-US/docs/Glossary/Simple_header
 
<!-- HTTP response -->
200 OK
Connection: Keep-Alive
Content-Encoding: gzip
Content-Type: text/html; charset=utf-8
Date: Wed, 20 Jul 2016 10:55:30 GMT
Etag: "547fa7e369ef56031dd3bff2ace9fc0832eb251a"
Keep-Alive: timeout=5, max=1000
Last-Modified: Tue, 19 Jul 2016 00:59:33 GMT
Server: Apache
Transfer-Encoding: chunked
Vary: Cookie, Accept-Encoding
 
(content)
 
<!-- HTTP request -->
GET /static/img/header-background.png HTTP/1.1
Host: developer.mozilla.org
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:50.0) Gecko/20100101 Firefox/50.0
Accept: */*
Accept-Language: en-US,en;q=0.5
Accept-Encoding: gzip, deflate, br
Referer: https://developer.mozilla.org/en-US/docs/Glossary/Simple_header
 
<!-- HTTP response -->
200 OK
Age: 9578461
Cache-Control: public, max-age=315360000
Connection: keep-alive
Content-Length: 3077
Content-Type: image/png
Date: Thu, 31 Mar 2016 13:34:46 GMT
Last-Modified: Wed, 21 Oct 2015 18:27:50 GMT
Server: Apache
 
(image content of 3077 bytes)
```

계속 되는 확장 속에...
<details>
<summary>더보기</summary>

## ✔️ HTTPS

> HTTP의 보안 강화
 
### HTTP의 단점

- 기존 HTTP 평문 텍스트, 즉 암호화되지 않은 텍스트를 전송하는 프로토콜로, 중간자 공격에 취약하다.
- ✔️ 이런 보안 문제를 해결해주는 프로토콜이 **'HTTPS'**

### HTTPS 특징

- HTTPS는 소켓 통신에서 일반 텍스트를 이용하는 대신에, 신뢰할 수 있음을 인증서를 사용하고, 통신 내용은 SSL 또는 TLS라는 프로토콜로 **세션 데이터를 암호화**했다.
    - TLS 프로토콜은 SSL 프로토콜에서 발전한 것이다. (하지만 넷스케이프가 SSL 통제권을 IETF로 넘기면서 바뀐 것임으로 거의 같다.)
    - 두 프로토콜의 주요 목표는 기밀성, 데이터 무결성, ID 및 디지털 인증서를 사용한 인증을 제공하는 것이다.

### HTTPS 원리

- <u>**공개키(비대칭키) 알고리즘 방식**</u>
- 암호화, 복호화시킬 수 있는 서로 다른 키(공개키, 개인키)를 이용한 암호화 방법
    - 공개키: 모두에게 공개. 공캐키 저장소에 등록
    - 개인키(비공개키) : 개인에게만 공개. 클라이언트-서버 구조에서는 서버가 가지고 있는 비공개키
    - 클라이언트 -> 서버
        - 사용자의 데이터를 공개키로 암호화 (공개키를 얻은 인증된 사용자)
        - 서버로 전송 (데이터를 가로채도 개인키가 없으므로 복호화할 수 없음)
        - 서버의 개인키를 통해 복호화하여 요청 처리

## ✔️ RESTful

기존의 웹은 주로 클라이언트의 요청에 따라서 서버가 완성된 HTML 파일을 제공하는 것이 기본이었다.

이때 서버와 서버 간의 통신에서 데이터만 주고 받는 API가 필요했고 이것에 대한 표준을 만든 것이 REST이다.

HTTP 기반의 웹의 장점을 최대한 활용한 아키텍처가 REST(Representational State Transfer)이고 <u>HTTP URI를 통해 자원을 표시</u>하고 <u>HTTP Method를 통해 자원에 대한 처리</u>를 표현했다.

HTTP를 사용하기 때문에 HTTP의 특성을 그대로 반영합니다. 또한 별도의 인프라 구축이 필요없다.

(이때쯤 XML이나 JSON같은 데이터 포맷 등장, 웹 브라우저에서도 비동기로 서버에 요청을 보낼 수 있는 기술인 AJAX(Asynchronous JavaScript and XML)가 보편화 -> REST 구조 각광)

## + HTTP 메소드의 멱등성

HTTP 메서드 중 POST를 제외하고는 모두 멱등성이 보장되어야 한다.

서버의 상태는 **멱등성이 유지되어야 하는경우 같은 행위를 여러 번 반복하더라도 같은 효과를 가져야 한다.**

멱등성이 성립하지 않으면, 같은 행위를 여러 번 반복하는 경우 요청마다 다른 효과가 발생된다.

즉, 이는 응답이 다를 수는 있지만, 요청이 의도한 효과를 발휘할 때 멱등성이 유지됨을 의미한다. (여러 번 요청을 보내더라도 요청에 의한 서버의 상태는 항상 같음.)

</details>

<br>

## 🐣 HTTP/2

> 더 나은 성능을 위한 프로토콜 <br>
> **HTTP over SPDY**

### [ HTTP HOL(Head Of Line) Blocking ]

> **HOL(Head-of-Line) Blocking**: 컴퓨터 네트워킹에서 패킷 대기열이 존재 할 때, 앞선(Head) 패킷이 지연될 때 발생하는 성능 저하 현상

HTTP /1.1이 굉장히 유연하고 확장성이 좋지만, TCP/IP 프로토콜을 기반으로 하면서 **하나의 연결 내에서 하나의 요청을 처리하도록 설계되었기 때문에 순차적으로 처리되어야 했다.** 이를 해결하기 위해 **파이프라이닝 기법**이 도입되었지만 응답은 **FIFO(First In, First Out)** 로 전송되어야하기 때문에 서버로 먼저 온 요청의 응답이 지연되면, 뒤이은 다음 요청들의 응답도 덩달아 지연됐다. 

### ✔️ SPDY

이와 같은 문제점(지연)들로 인해 구글에서 2010년 전반기에 SPDY (Speedy의 약자) 프로토콜을 구현하여 공개했다. 

🚩 `목표`: 웹 페이지 로드 대기 시간을 줄이자.

<div align='center'>
    <img src="img/http_spdy.png" width="550px">
</div>

### [ 특징 ]

- HTTP/2는 SPDY라는 프로토콜 기반으로 동작한다.
- 그리고 SPDY는 항상 **TLS**(Transport Layer Security) 위에서 동작 **(즉, HTTPS 필수)**

### 1. 이진(binary) 프로토콜

- HTTP/1.1은 **텍스트** 기반 프로토콜로 아스키코드로 작성, 읽기는 편하지만 데이터가 커진다.
- HTTP/2는 데이터를 **바이너리**로 변환해서 전송하기 때문에 파싱이 더 빠르고, 오류 발생 가능성이 낮다.

<div align='center'>
    <img src="./img/binary_protocol.png" width="550px">
</div>

### 2. 응답 다중화(Multiplexing)

- HTTP /1.1은 TCP **하나의 연결 내에서 하나의 요청**을 처리할 수 있었고 요청에 대한 응답이 **순차적으로 처리**되어야 했다. 그래서 HOLB와 같은 문제점이 발생했다.
- HTTP/2는 multiplexing으로 위의 문제를 해결했다.
- HTTP/2는 하나의 TCP 연결에 여러 개의 요청을 처리할 수 있는데 이것은 **스트림(stream), 메세지(message), 프레임(frame)** 이라는 단위로 세분화했기 때문이다.

<div align='center'>
    <img src="./img/multiplexing.png" width="550px">
</div>

- **Stream**: 구성된 연결 내에서 전달되는 바이트의 양방향 흐름, TCP 연결에서 여러 개 스트림 존재 가능
- **Message**: 논리적 요청 또는 응답 메시지에 매핑되는 프레임의 전체 시퀀스이다.
- **Frame**: HTTP/2에서 통신의 최소 단위. 각 <u>최소 단위</u>에는 하나의 프레임 헤더가 포함된다. 이 프레임 헤더는 최소한으로 프레임이 속하는 스트림을 식별한다. HEADERS Type Frame, DATA Type Frame이 존재한다.

<div align='center'>
    <img src="./img/multiplexing2.png" width="550px">
</div>

위의 이미지 처럼, **하나의 TCP 커넥션**에서 여러 병렬 스트림(3개)이 존재 할 수 있다. stream이 뒤섞여서 전송 될 경우, stream number를 이용해 수신측에서 재조합된다.

### 3. HTTP 헤더 데이터 압축 (HTTP Header Data Compression)

이전 Header의 내용과 중복되는 필드를 재전송 하지 않도록 하여, 불필요한 **오버헤드를 제거**하면서, 연속된 요청 사이의 매우 유사한 내용으로 존재하는 **헤더들을 압축**시킨다.

이때 변경된 부분만 다시 보내는 **허프만 코딩(Huffman Coding)** 기법을 사용하는 **HPACK**이라는 Header 압축방식을 이용한다.

> `Huffman Coding` 방식: <u>데이터 문자의 빈도</u>에 따라서 <u>다른 길이의 부호를 사용</u>하는 알고리즘

### 4. Server Push

클라이언트의 요청을 예상하여 클라이언트 캐쉬에 클라이언트가 요청할 것 같은 데이터(리소스)를 미리 넣어두는 **서버 푸쉬** 기술이 등장했다.

예를 들어 HTML에는 css나 js 파일이 포함되어 있는데 기존에는 HTML과 css 모두 요청해야 받을 수 있었다면 HTTP/2에서는 HTML을 요청하고 응답할 때 서버가 css 파일도 푸시하여 먼저 줄 수 있다.

<br>

## 🐥 HTTP/3

> HTTP over QUIC

HTTP/3가  발표되었다. RFC 9114

HTTP/3는 어떤 문제점을 해결하기 위해 등장했을까. 그것은 바로 HTTP/2까지 여전히 데이터 전송 계층을 TCP 위에서 동작하기 때문에 그로 인한 문제가 계속 진행되고 있기 때문이다.

**TCP는 연결 지향형 프로토콜**로 신뢰성을 지향하기 때문에 데이터 손실이 발생하면 재전송을 수행한다. 그리고 패킷을 순서대로 처리해야하기 때문에 재전송 과정에서 병목 현상이 발생한다.

그리고 TCP 자체에서 **흐름제어 및 혼잡제어**를 제공한다.

- 흐름제어
    - 데이터를 송신하는 곳과 수신하는 곳의 <u>데이터 처리 속도를 조절</u>하여 수신자의 버퍼 오버플로우를 방지하는 것
    - 송신하는 곳에서 감당이 안되게 많은 데이터를 빠르게 보내 수신하는 곳에서 문제가 일어나는 것을 막는다.
- 혼잡제어
    - 네트워크 내의 패킷 수가 넘치게 증가하지 않도록 방지하는 것
    - <u>정보의 소통량이 과다하면 패킷을 조금만 전송하여</u> 혼잡 붕괴 현상이 일어나는 것을 막는다. (속도를 제어한다. 천천히 속도를 올린다.)

그런데 이것은 인터넷 환경이 좋을 때 오히려 지연을 야기하게 된다.

그래서!! 두둥!

### ✔️ QUIC

- HTTP/3는 QUIC라는 프로토콜 기반으로 동작한다.
- **QUIC**은 UDP를 기반으로 한다. 구글에서 2013년에 TCP의 신뢰성 보장을 위해 제공되는 기능을 UDP에서 직접 구현해서 성능을 개선한 프로토콜이다.
- 즉, UDP 자체는 신뢰성을 보장하지 않지만, 추가적인 정의를 통해 신뢰성을 보장받을 수 있다.

```
 UDP + 패킷 재전송, 혼잡 제어, 흐름 제어 기능 등 (직접 구현) = QUIC
```

드디어 HTTP/3에서 TCP에서 벗어나 UDP 기반의 프로토콜을 사용함으로써 기존의 문제점을 해결할 수 있었다.

<div align='center'>
    <img src="img/http3.png" width="550px">
</div>

- **최초 연결(1-RTT)**: 연결에 필요한 정보를 한 번에 보냄.
- **다음 연결(0-RTT)**: 한 번 성공한 연결을 캐싱하고 다음 연결 때 캐싱된 정보를 사용함.
- 연결 내 스트림이 완전히 **독립적**으로 동작 -> 하나가 실패해도 다른 스트림에 영향X
- IP 기반이 아니라 연결 별 고유 **UUID(Connection ID)를 이용해 각 연결들을 식별**한다.
    - 그래서 TCP 기반에선 Wi-Fi에서 셀룰러 환경으로 이동하면 IP주소가 변경되어 연결을 재수립해야하지만
    - QUIC에서는 ID 기반이기 때문에 연결이 그대로 유지된다.
---

### 📢 같이 공부하면 좋을 면접 질문

1. TCP와 HTTP에 대해서 설명하고, 두 가지를 아는 대로 비교해보세요.
    - OSI 7계층 및 TCP/IP 모델 설명
    - TCP 특징 (UDP와 구분 지어)
    - Keep-Alive header에 대해서 (HTTP 1.1)
    - HTTP 버전별로 다른 transport layer의 프로토콜 언급 (1.1과 2.0까지는 TCP, 3.0에서 UDP)
2. TCP vs UDP
    - TCP는 연결 지향형 프로토콜, 가상 회선을 만들어 신뢰성을 보장
    - UDP는 비연결성 프로토콜, 신뢰성을 보장하지 않는다.
    - 하지만 UDP도 신뢰성을 UDP자체에서 보장하지 않는 것 뿐이지, 개발자가 직접 신뢰성을 보장하도록 할 수 있다. 그래서 **HTTP/3은 QUIC이라는 프로토콜을 기반**으로 하는데, QUIC은 UDP를 기반으로 합니다. 즉, UDP 자체는 신뢰성을 보장하지 않지만, 추가적인 정의를 통해 신뢰성을 보장받을 수 있습니다.
3. HTTP/2를 설명하고 장점 두 가지를 설명하세요.

---

### 📌 Reference  

- 사진 출처 : [코드 연구소](https://code-lab1.tistory.com/196)
- 사진 출처2 : [네이버 D2](https://d2.naver.com/helloworld/140351)
- 사진 출처3 : [web.dev](https://web.dev/performance-http2/)
- [MDN HTTP 진화](https://developer.mozilla.org/ko/docs/Web/HTTP/Basics_of_HTTP/Evolution_of_HTTP)
- [[요즘IT] 웹 개발자라면 알고 있어야 할 HTTP의 진화 과정](https://yozm.wishket.com/magazine/detail/1686/)
- [Introduction to HTTP/2](https://web.dev/performance-http2/)