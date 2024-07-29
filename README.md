## Spring Framework

이 repository는 스프링을 입문하면서 다룬 내용을 담고 있습니다.  
아주 기본적인 내용인 스프링 MVC 부터 AOP까지 처음 접할 때 알아야 할 기본적인 내용들을 공부하였습니다.

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