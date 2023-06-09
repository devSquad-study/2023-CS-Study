# View resolver

view resolver은 controller에서 요청하는 뷰를 찾아서 Dispatcher Servlet 반환한다

![출처: [https://hudi.blog/implementing-annotation-based-mvc-framework/](https://hudi.blog/implementing-annotation-based-mvc-framework/)](img/spring_mvc_viewresolver.png)

출처: [https://hudi.blog/implementing-annotation-based-mvc-framework/](https://hudi.blog/implementing-annotation-based-mvc-framework/)

위의 그림은 Spring mvc가 어떻게 운행하는지 보여주는 그림이다.

## 동작 순서

1. `Dispatcher Servlet`이 클라이언트에게 HTTP요청을 받음
2. `Dispatcher Servlet`에서 핸들러 매핑을 통해 해당 HTTP을 실행할 컨트롤러를 찾음
3. 컨트롤러를 실행할 핸들러 어댑터를 핸들러 어댑터 목록에서 찾음
4. 찾은 핸들러 어댑터를 통해 컨트롤러에 접근함
5. 컨트롤러를 실행함
6. 핸들러 어댑터를 컨트롤러에서 반환한 ModelAndView을 Dispatcher Servlet에 전달함
7. ModelAndView 를 viewResolver로 통해 논리적 이름을 물리 이름으로 변화하여 렌더링 역할을 담당하는 View을 DispatcherServlet에 반환함
8. View을 렌더링한 후 클라이언트에게 전달함

## 서블릿의 종류

### InternalResourceViewResolver

기본적으로 설정된 뷰리졸버이다. JSP는 webapp/WEB-INF 밑에 작동이 된다. 그래서 jsp 파일의 경로를 설정해주어야 한다.

- `spring.mvc.view.prefix` : 파일의 경로의 설정하는 것
- `spring.mvc.view.suffix`: 파일의 접미사를 설정하는 것

### BeanNameViewResolver

뷰 리졸버 체인에서 유용하게 쓰이는 리졸버이다.

View 타입 중에서 같은 이름을 가진 빈을 고른다.

이 구현체는 재정의하거나 교체할 필요가 없다.

### ContentNegotiatingViewResolver

View 타입의 빈이 실제로 존재하는 경우에만 추가된다 이 구현체는 compoiste 리졸버로, 다른 구현테들에 위임해서 클라이언트가 전송된 ‘Accept’ HTTP 헤더와 일치하는 항목을 찾는다.

### ThymeleafViewResolver

Thymeleaf 템플릿을 사용하면 위와 같은 ViewResolver가 추가 된다. 이 구현체는 뷰 이름에 prefix와  suffix를 감싼 뒤 리소스를 찾는다

- `spring.thymeleaf.prefix` : 파일의 경로의 설정하는 접두사 (기본값은 classpath:/templates/)
- `spring.thymeleaf.suffix`: 파일의 접미사를 설정하는 것 (기본값은 .html)

같은 이름으로 빈을 정의하면 ThymeleafViewResolver을 재정의 할 수 있다.

### FreeMarkerViewResolver

FreeMarker를 사용하면 위와 같은 ViewResolver가 추가된다. 이 구현체는 뷰 이름에 prefix와 suffix를 붙인 뒤 로더 경로에서 리소스를 찾는다

- `Spring.freemarker.templateLoaderPath` : FreeMarker의 경로를 나타냄(기본값은 classpath:/templates/)
- `Spring.freemarker.prefix`: 파일 경로의 접두사
- `Spring,freemarker.suffix`: 파일의 접미사를 설정하는 것(기본값은 .ftlh)

같은 이름으로 빈을 정의하면 FreeMarkerViewResolver을 재정의 할 수 있다

### GroovyMarkupViewResolver

Groovy 템플릿을 사용하면 위와 같은 GrovyMarkupViewResolver가 추가된다. 이 구현체는 뷰 이름에 prefix와 suffix 붙인 뒤 로더 경로에서 리소스를 찾는다.

- `Spring.groovy.prefix`: 파일 경로의 접두사(기본값은 classpath:/templates/)
- `Spring,groovy.suffix`: 파일의 접미사를 설정하는 것(기본값은 .tpl)

같은 이름으로 빈을 정의하면 GroovyMarkupViewResolver를 재정의 할 수 있다.

### MustacheViewResolver

Mustache를 사용하면 위와 같은 MustacheViewResolver가 추가된다. 이 구현체는 뷰 이름에 prefix와 suffix를 감싼 뒤 리소스를 찾는다.

- `Spring.mustache.prefix`: 파일 경로의 접두사(기본값은 classpath:/templates/)
- `Spring,mustache.suffix`: 파일의 접미사를 설정하는 것(기본값은 .mustache)

같은 이름으로 빈을 정의하면 MustacheViewResolver를 재정의 할 수 있다.

# 레퍼런스
- [한글로 번연된 Spring 문서](https://godekdls.github.io/Spring%20Boot/howto.spring-mvc/#1248-customize-viewresolvers)
- [스프링 문서](https://docs.spring.io/spring-boot/docs/2.5.2/reference/htmlsingle/#features.developing-web-applications.embedded-container.jsp-limitations)