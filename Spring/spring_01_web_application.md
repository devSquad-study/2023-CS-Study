# 웹 어플리케이션 이해 🌎
> **웹 어플리케이션(Web Application)** : 인터넷이나 인트라넷을 통해 웹 브라우저에서 이용할 수 있는 응용 프로그램 

## 모든 것이 HTTP
<div align='center'>
    <img src="img/spring_web_application_01.png" width="500px"/>
</div>

과거 초기의 웹 어플리케이션은 클라이언트-서버 컴퓨팅 환경에서의 각 응용 소프트웨어마다 UI를 가지고 있었으며, 사용자 PC마다 따로 설치했어야 했다.

현재는 **HTTP** 라는 통일된 프로토콜을 사용하지만, 과거에는 회사마다 독자적인 통신 프로토콜을 사용했었기 때문이다.

대개 독자적인 규격을 가지는 것은 회사입장에서 매우 큰 이득이지만, Web에서 만큼은 매우 큰 비용을 초래하여 생산성이 떨어진다는 문제가 발생한다.
<br> HTTP 프로토콜의 정립으로 인해 웹 어플리케이션을 제공하는 기업의 유지 비용이 줄었다.

## 웹 서버(Web Server)
<div align='center'>
    <img src="img/spring_web_application_02.png" width="500px"/>
</div>

- HTTP 기반 동작
- **정적** 리소스 (정적 HTML, CSS, JS, 이미지, 영상) 제공

## 웹 어플리케이션 서버 (Web Application Server)
<div align='center'>
    <img src="img/spring_web_application_03.png" width="500px"/>
</div>

- HTTP 기반 동작
- 웹 서버 기능 포함 (정적 리소스 제공)
- 프로그램 코드를 실행하여 **어플리케이션 로직** 수행
    - ⇒ 동적 HTML, HTTP API, 서블릿, JSP, 스프링 MVC
- ex) 톰캣(Tomcat)


=> `WAS`가 어플리케이션 코드를 실행하는 데에 있어서 더 특화되어 있다.

## 웹 시스템 구성
<div align='center'>
    <img src="img/spring_web_application_04.png" width="500px"/>
</div>

- WAS가 웹 서버의 기능도 다 할 수 있지만, 너무 많은 역할을 담당할 시 서버 과부하
- WAS 장애 시 오류화면도 노출 불가능

<div align='center'>
    <img src="img/spring_web_application_05.png" width="500px"/>
</div>

- 웹 서버는 정적 리소스 처리,
- WAS는 애플리케이션 로직같은 동적인 처리 ⇒ 효율적인 리소스 관리
- WAS, DB 장애 시 웹 서버가 오류 화면 제공 가능




### 참고자료
[스프링 MVC 1편 - 백엔드 웹 개발 핵심 기술](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-mvc-1/dashboard)

[[React] React에 대해 : 서론, 소개(Class Based Component, Hooks)](https://nitro04.blogspot.com/2020/01/web-web-application-web-site.html)
