## Spring Framework

이 repository는 스프링을 입문하면서 다룬 내용을 담고 있습니다.  
아주 기본적인 내용인 스프링 MVC 부터 AOP까지 처음 접할 때 알아야 할 기본적인 내용들을 공부하였습니다.

이 레포의 최종 목표는 공식문서를 통해 REST 서비스 빌드를 구현하는 것이 최종 목표입니다.

## 🖥️ Spring의 Package 구조
스프링 프로젝트를 만들 때 패키지 구조는 프로젝트의 유지보수성과 확장상을 크게 좌우할 수 있습니다.  
일반적으로 다음과 같은 패키지 구조를 권장합니다.

스프링 부트 프로젝트의 기본 패키지 구조
```java
Copycom.example.project
├── config
├── controller
├── service
├── repository
├── model
├── dto
└── exception
```
각 패키지의 역할

- config: 스프링 설정 클래스 (예: AppConfig.java, WebSecurityConfig.java)
- controller: 웹 요청 처리 클래스 (예: UserController.java)
- service: 비즈니스 로직 클래스 (예: UserService.java)
- repository: 데이터베이스 접근 인터페이스 (예: UserRepository.java)
- model: 도메인 모델 클래스 (예: User.java)
- dto: 데이터 전송 객체 (예: UserDTO.java)
- exception: 커스텀 예외 및 예외 핸들러 (예: UserNotFoundException.java)

추가 고려 사항
- security: 보안 관련 클래스
- utils: 유틸리티 클래스
- event: 도메인 이벤트 및 핸들러
- integration: 외부 시스템 통합 클래스

## Spring을 사용하여 REST 서비스 빌드
REST는 웹에서 웹 서비스를 구축하기 위한 사실상 표준으로 빠르게 자리 잡았습니다. REST 서비스는 구축하기 쉽고 사용하기 쉽기 때문입니다.  
REST가 마이크로서비스의 세계에 어떻게 들어맞는지에 대한 훨씬 더 큰 논의가 있을 수 있습니다. 그러나 이 레포에서는 RESTful 서비스 구축에 대해서  
간략하게 살펴보도록 하겠습니다.

왜 REST인가? REST는 웹의 교리를 수용하는데, 여기에는 아키텍처, 이점, 그리고 그 밖의 모든 것이 포함됩니다.  
핵심 프로토콜인 HTTP는 다음과 같은 여러 기능을 제공합니다.
- 적합한 작업(GET, POST, PUT, DELTE, 및 기타)
- 캐싱
- 리디렉션 및 전달
- 보안(암호화 및 인증)

이것들은 모두 회복성 있는 서비스를 구축할 때 중요한 요소입니다.  그러나 그게 전부는 아닙니다. 웹은 수많은 작은 사양으로 구성되어 있습니다.  
이 아키텍처는 "표준 전쟁"에 빠지지 않고 쉽게 진화할 수 있게 해줍니다.

개발자는 다양한 사양을 구현하는 타사 툴킷을 활용하여 클라이언트와 서버 기술을 즉시 손쉽게 활용할 수 있습니다.  
REST API는 HTTP를 기반으로 다음을 구축하는 수단을 제공합니다. 

- 이전 버전과 호환되는 API
- 진화 가능한 API
- 확장 가능한 서비스
- 보안 가능한 서비스
- 무상태 서비스에서 유상태 서비스로의 스펙트럼

REST는 아무리 널리 퍼져 있다 하더라도 그 자체로 표준은 아니지만, 웹 규모 시스템을 구축하는 데 도움이 되는 아키텍처에 대한 접근 방식, 스타일, 제약 세트입니다 .  
이 레포는 REST의 스택리스 기능을 활용하면서 Spring 포트폴리오를 사용하여 RESTful 서비스를 구축합니다.