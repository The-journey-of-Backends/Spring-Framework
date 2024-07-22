## Spring Framework

이 repository는 스프링을 입문하면서 다룬 내용을 담고 있습니다.  
아주 기본적인 내용인 스프링 MVC 부터 AOP까지 처음 접할 때 알아야 할 기본적인 내용들을 공부하였습니다.

## 🖥️ Spring의 Package 구조
스프링 프로젝트를 만들 때 패키지 구조는 프로젝트의 유지보수성과 확장상을 크게 좌우할 수 있습니다.  
일반적으로 다음과 같은 패키지 구조를 권장합니다.

### 기본 패키지 구조
```java
com.example.project
├── config
├── controller
├── service
├── repository
├── model
├── dto
└── exception

```
각각의 파일들은다음과 같은 설정을 포함합니다.
- config : 스프링의 설정 클래스를 포함합니다. 예를 들어, 데이터베이스 설정, 스프링 보안 설정, CORS 설정 등이 여기에 포함될 수 있습니다. 예: AppConfig.java, WebSecurityConfig.java
- controller : 웹 요청을 처리하는 컨트롤러 클래스를 포함합니다. REST API의 엔드포인트를 정의하는 클래스가 이 패키지에 위치합니다.
예: UserController.java, ProductController.java
- service : 비즈니스 로직을 포함하는 서비스 클래스를 포함합니다. 컨트롤러에서 호출되어 비즈니스 로직을 처리합니다.
예: UserService.java, ProductService.java
- repository : 데이터베이스 접근을 담당하는 리포지토리 인터페이스를 포함합니다. 일반적으로 JPA, MyBatis, 또는 Spring Data MongoDB와 같은 ORM 프레임워크와 함께 사용됩니다.
예: UserRepository.java, ProductRepository.java
- model : 도메인 모델 클래스를 포함합니다. 일반적으로 데이터베이스 엔티티 또는 비즈니스 객체가 여기에 위치합니다.
예: User.java, Product.java
- dto : 데이터 전송 객체를 포함합니다. 주로 컨트롤러와 서비스 간의 데이터 전달을 위한 객체를 정의합니다.
예: UserDTO.java, ProductDTO.java
- exception: 커스텀 예외 클래스와 예외 핸들러를 포함합니다. 예외 처리 로직을 중앙 집중화할 수 있습니다.
예: UserNotFoundException.java, GlobalExceptionHandler.java

추가 고려 사항
- security : 보안 관련 설정과 클래스를 포함할 수 있습니다. 예를 들어, 인증과 권한 부여를 처리하는 클래스들이 여기에 포함될 수 있습니다.
예: JwtAuthenticationFilter.java, CustomUserDetailsService.java
- utils : 유틸리티 클래스와 헬퍼 메소드를 포함합니다. 공통적으로 사용되는 유틸리티 코드가 여기에 위치할 수 있습니다.
예: DateUtils.java, StringUtils.java
- event : 도메인 이벤트와 이벤트 핸들러를 포함할 수 있습니다.
예: UserCreatedEvent.java, UserEventListener.java
- integration : 외부 시스템과의 통합을 위한 클래스를 포함합니다. 예를 들어, 메시지 큐, 외부 API와의 통신 등이 여기에 포함됩니다.
예: EmailService.java, PaymentGatewayIntegration.java

### 소규모와 대규모의 기준
소규모 프로젝트 일때는 패키지 구조를 단순화하여 유지보수를 쉽게 할 수 있습니다. 
예를 들어, controller, service, repository, model 패키지만으로 구성할 수 있습니다. 그러나 대규모 프로젝트일떄는  
모듈화 및 도메인 중심의 구조를 적용하여 각 도메인별로 패키지를 나누는 것이 좋습니다. 예를 들어, user, product, order와  
같은 도메인 별 패키지를 구성할 수 있습니다.
```java
com.example.project
├── user
│   ├── controller
│   ├── service
│   ├── repository
│   ├── model
│   └── dto
├── product
│   ├── controller
│   ├── service
│   ├── repository
│   ├── model
│   └── dto
└── common
    ├── exception
    ├── config
    ├── utils
    └── security

```