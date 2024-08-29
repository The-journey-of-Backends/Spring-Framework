## Spring Framework

이 repository는 스프링을 입문하면서 다룬 내용을 담고 있습니다.  
아주 기본적인 내용인 스프링 MVC 부터 AOP까지 처음 접할 때 알아야 할 기본적인 내용들을 공부하였습니다.

다음 내용부터는 제가 본 영상을 학습하면서 작성한 개념과 코드가 어떻게 동작하는지를 정리한 문서입니다.

## 이번 강의를 통해 무엇을 배웠는가?
이번 강의는 스프링 기술 그 자체에 매몰되기보다는, 스링을 실무에서 어떻게 사용해야 하는지 초점을 맞춘거 같습니다.  
덕분에 스프링이라는 프레임워크를 전반적으로 어떻게 사용해야 하는지의 흐름을 파악할 수 있었습니다.

## 스프링을 사용하면서 중요하다고 생각하는 기술
1. thymeleaf
2. MVC
3. Bean
4. DI
5. JPA
6. AOP

이번 강의해서 배운 내용을 기술들을 어떤 형식으로 작성해야 되고 어떤 형식으로 동작을 하는지 간략하게 정리해보도록 하겠습니다.

## Thymeleaf에 대해서
타입리프(Thymeleaf)는 웹 및 독립 실행형 환경 모두를 위한 Java 템플릿 엔진입니다. Thymeleaf로 작성된 HTML 템플릿은  
애플리케이션을 통한 실행이 아니더라도 브라우저에서 열었을 때 HTML 내용을 그대로 확인이 가능하며 네츄럴 템플릿(Natural Templates)이라고 불립니다.

Thymleaf를 사용할 땐 다음과 같은 설정을 추가적으로 작성해줘야 합니다.  
thymeleaf 뷰 템플릿을 사용하기 위해서는 ThymeleafViewResolver를 등록해야 합니다. 아래 라이브러리를 추가하면 Spring이 위 작업을 자동화 해줍니다.

**Gradle** - build.gradle

```sql
implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
```

**Maven** - pom.xml

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

위 설정을 추가 후 빌드하면 application.properties에 아래 코드가 자동으로 추가됩니다. 디폴트 설정을 원하지 않는다면 직접 수정해도 됩니다.

조금더 Thymleaf에 대해서 알고 싶으시다면 다음 링크를 참고해주세요  
(Thymleaf) https://yuchan-log.notion.site/Thymeleaf-11439d5015e442e0a816650f6acf557e?pvs=4