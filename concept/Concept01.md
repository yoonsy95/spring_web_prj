## Part01. 01 개발준비

#### spring 구조

<img src="C:\Users\yegyo\AppData\Roaming\Typora\typora-user-images\image-20200422174624978.png" alt="image-20200422174624978" style="zoom:80%;" />



#



#### Lombok lib

- `getter/setter`, `toString`  자동 생성
- 이클립스 에디터 내에서 사용되므로 별도로 설치해야 함



#



#### `Spring Legacy Project`: `java` 설정(`java configuration`)

1. `web.xml` 및 `spring` 관련 파일 삭제

   - `web.xml`
   - `servlet-context.xml`, `root-context.xml` => `spring folder`

2. `pom.xml` 수정 및 스프링 버전 변경

   ```xml
   <!-- add plugin -->
   <plugin>
       <groupId>org.apache.maven.plugins</groupId>
       <artifactId>maven-war-plugin</artifactId>
       <version>3.2.0</version>
       <configuration>
           <failOnMissingWebXml>false</failOnMissingWebXml>
       </configuration>
   </plugin>
   ```

   ```xml
   <!-- modify properties -->
   <java-version>1.8</java-version>
   <org.springframework-version>5.0.7.RELEASE</org.springframework-version>
   ```

   

3. 자바 설정 관련 패키지 설정

   ```xml
   <!-- modify maven-compiler-plugin -->
   <configuration>
   	<source>1.8</source>
       <target>1.8</target>
       ...
   </configuration>
   ```



4. `Maven` -> `Update Project`



#



#### `@Configuration`

- `java` 설정시 `xml`파일이 아닌 직접 설정 파일을 작성해야 함
- `@Configuration`은 해당 클래스의 인스터스를 이용해서 설정파일을 대신함

#

#### `web.xml`을 대신하는 클래스 생성

- `AbstractAnnotationConfigDispatcherServletInitializer`를 상속받는 `WebConfig` 생성

  ```java
  @Override
  protected Class<?>[] getRootConfigClasses() {
      return new Class[] {RootConfig.class};
  }
  // 삭제한 root-context를 대신하는 클래스 지정 => RootConfig.class
  ```
  

#

## Part01. 02 스프링 특징과 의존성 주입

> #### 살펴볼 내용
  - `java` 관련 프레임워크들이 추구했던 목표
  - 스프링 프레임워크가 살아남은 이유
  - 의존성 주입
> #### 학습 목표
  - 스프링 프레임워크를 이용한 의존성 주입에 대한 이해와 테스트
  - 스프링에서 `xml`을 이용하는 객체 관리 방법
  - 스프링의 테스트 환경 구축

#

#### 스프링 프레임워크 역사

**프레임워크**

- 뼈대나 근간을 이루는 코드들의 묶음

- 프로그램 기본 흐름이나 구조 정하고 팀원들이 자신의 코드를 추가하는 방식으로 개발 진행됨
- 장점
  - 필요한 구조를 이미 만들었기에 필요한 부분을 조립하는 형태로 개발 가능
  - 품질 보장, 개발 시간 단축

- 특정 기능 위주로 간단한 `jar` 파일 들을 이요애서 모든 개발이 가능하도록 구성됨 => 경량 프레임워크

#

**스프링**

- 자바 클래스와 인터페이스 이용하기에 진입장볍이 낮음
- 복잡한 프레임워크 가볍기에 빠르게 엔터프라이즈급의 시스템 작성 가능
- 근본적으로 `OOP` 구조를 뒷받침하고 구조를 설계하기에 어느 한 분야가 아닌, 전체를 설계하는 용도로 사용됨 => 의존성 주입
- 다른 프레임워크들과 통합을 지원하기에 최소한의 수정 가능함
- 코드가 간단해지고, 업데이트가 빠름

#

**스프링 변화**

- `spring 2.5`: `annotation` 도입으로 편리한 설정과 개발 가능
- `spring 3.0`: `java class`만으로 설정 파일 대신 가능
- `spring 4.0`: `REST` 방식의 컨트롤러 지원 // 모바일과 웹 환경
- `spring 5.0`: `reactor`를 이용한 `reactive` 스타일의 개발 환경 지원

#

##### 스프링 주요 특징

1. `POJO(Plain Old Java Object)` 기반의 구성

   - 스프링은 객체 간의 관계를 구성할 수 있기에 별도의 API 등을 필요로 하지 않음

   - 일반적인 자바 코드를 이용해 객체 구성할 수 있음

     => 개발자에게 일반적인 형태이기에 생산성 유리, 테스트 작업에 있어 유연함

2. 의존성 주입(`DI: Dependency Injection`)을 통한 객체 간의 관계 구성

   - 객체 A는 B가 필요하다는 신호만 보냄

   - B는 외부에서 객체를 주입함

     => B에 변화가 있더라도 A는 변하지 않음

   - `ApplicationContext`

     - 필요한 객체 생성하고 주입하는 역할
     - `Bean`이라는 이름으로 객체들을 관리
     - `Bean`과 `Bean` 사이의 의존관계를 처리하는 방식 => `xml`, `annotation`, `java configuration`

3. `AOP(Aspect Oriented Programming)` 지원

   - 반복적인 코드를 줄이고 핵심 비즈니스 로직에만 집중할 수 있는 방법 제공

   - 횡단 관심사(`cross-concern`)

     - 비즈니스 로직은 아니지만 반드시 처리가 필요한 부분
     - 보안, 로그, 트랜잭션 등

   - 횡단 관심사를 모듈로 분리

     => 핵심 비즈니스 로직에만 집중할 수 있음, 다른 프로젝트 수행시 코드 수정 최소화 가능, 유지보수가 수월한 코드를 구성할 수 있음

4. 편리한 MVC 구조

5. WAS의 종속적이지 않은 개발 환경

6. 트랜잭션의 지원

   - 트랜잭션의 관리를 `annotation`이나 `xml`로 설정하기에 매번 상황에 맞는 코드 작성할 필요 없도록 설계되었음

#

#### 스프링이 동작하면서 생기는 일

![image-20200423190157226](C:\Users\yegyo\AppData\Roaming\Typora\typora-user-images\image-20200423190157226.png)



1. 스프링 프레임워크가 시작되면 `context`라는 메모리 영역을 만듦

   스프링에서는 `ApplicationContext`라는 이름의 객체가 생성됨

2. `root-context.xml` 파일은 객체를 생성하고 관리해야하는 객체들에 대한 설정이 포함되어 있음

3. `root-context.xml`에 설정되어 있는 `<context:component:scan>` 태그의 내용을 통하여 `'lab.spring.sample'` 패키지를 스캔함

4. 해당 패키지의 클래스들 중 `@Component`라는 어노테이션이 존재하는 클래스의 인스턴스를 생성함

5. `Restaurant`객체에는 `Chef`객체가 필요하다는 `@Autowired` 어노테이션이 설정되어있어 스프링은 `Chef` 객체의 레퍼런스를 `Restaurant` 객체에 주입함

#

##### Annotation

1. `Lombok` 관련

   - 컴파일 시 흔하게 작성하는 작성하는 코드들을 생성해주는 기능

   - `@Setter`: `Setter` 메소드 생성, 3가지 속성 부여 가능

     - `value`

       접근 제한 속성 의미

       기본 값 => `lombok.AccessLevel.PUBLIC`

     - `onMethod`

       `setter` 메소드 생성 시 메소드에 추가할 어노테이션 지정

       jdk 버전에 따라 작성 차이 있음

     - `onParam`

       `setter` 메소드의 파라미터에 어노테이션 사용할 경우

   - `@Data`

     - 세부적인 설정이 필요없는 경우 주로 사용
     - `@ToString`,`@Getter/Setter`,`@EqualAndHashCode`,`@RequiredArgsConstructor`

   - `@Log4j`

     - 로그 객체 생성

     - `@Log4j`가 존재하지 않을 경우 `@Log` 사용 가능

     - `Spring Legacy Project` 기본 생성됨

       ```java
       // in JAVA
       public class LogExample {
           private static final java.util.logging.Logger log = 
               java.util.logging.Logger.getLogger(LogExample.class.getName());
       }
       
       // in spring
       @Log4j // @Log
       public class LogExample {
           
       }
       ```

   - `@AllArgsConstructor`

     - 인스턴스 변수로 선언된 모든 것을 파라미터로 받는 생성자 생성

   - `@RequiredArgsConstructor`

     - `@Notnull`이나 `final`이 붙은 인스턴스 변수에 대한 생성자 생성

2. `Spring` 관련

   - `@Component`
     - 해당 클래스가 스프링에서 객체로 만들어서 관리하는 대상임을 명시함
     - `@ComponentScan`을 통해 해당 패키지에서  `@Component`가 존재하는 클래스들을 객체로 생성해서 빈으로 관리함
   - `@Autowired`
     - 특정 객체에 의존적, 자신에게 해당 타입의 빈을 주입해주라는 표시

   

3. `test` 관련

   - `@RunWith`

     - 테스트 시 필요한 클래스 지정
     - `spring`은 `SpringJUnit4ClassRunner` 클래스가 대상

   - **`@ContextConfiguration`**

     - 스프링이 실행되면서 어떤 설정 정보를 읽어 들여야 하는지 명시

     - `xml`설정 파일 명시하는 `locations` 속성과,

       `@Configuration`이 적용된 클래스를 명시하는 `classes` 속성이 있음

   - `@Test`

     - `junit`에서 해당 메소드가 `jUnit`상에서 단위 테스트 대상인지 알려줌

#

#### 스프링 4.3 이후 단일 생성자의 묵시적 자동 주입

1. 생성자 주입
   - 
2. `Setter` 주입
   - `setter` 메소드나 `Lombok`사용하여 생성 -> `@Autowired`와 같은 어노테이션으로 필요한 객체 주입

#

## 스프링과 Oracle DataBase 연동

- SQL Developer 사용자 등록시 `the network adapter could not establish the connection` 에러나서 지우고 다시 깔기로 함
- [Deinstall Oracle](https://rainflys.tistory.com/202)

#

#### 오라클 설치

- [Download 11gR2](https://www.oracle.com/database/technologies/112010-win64soft.html) 
- [Install 11gR2](https://recollectionis.tistory.com/160)

#

#### sql developer 설치

- [Download SQL Developer](https://www.oracle.com/tools/downloads/sqldev-downloads.html) 
- [Install SQL Developer](https://copycoding.tistory.com/209)

#

#### 커넥션 풀(`Connection Pool`)

- 여러 사용자를 동시에 처리해야 하는 경우 데이터베이스 연결 위해 사용

- `Java`에서는 `DataSource` 인터페이스를 통해 사용함

- 미리 연결을 맺어주고 반환하는 구조로 성능 향상 도움 됨

- 예제 구조

  ![image-20200425070541873](C:\Users\yegyo\AppData\Roaming\Typora\typora-user-images\image-20200425070541873.png)

#

## MyBatis와 스프링 연동

#### MyBatis

- SQL mapping framework

- 장점

  - 기존 SQL 그대로 활용할 수 있으며 진입장벽이 낮음
  - 자동으로 `Connection close()` 가능
  - Mybatis 내부적으로 `PreparedStatement` 처리
  - `#{prop}`와 같이 속성을 지정하면 내부적으로 자동 처리
  - 리턴 타입 지정 시 자동으로 객체 생성 및 `ResultSet` 처리

- 관련 라이브러리

  - `spring-jdbc/spring-tx`

    스프링에서 데이터베이스 처리와 트랜잭션 처리

    ```xml
    <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.4.6</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis-spring</artifactId>
        <version>1.3.2</version>
    </dependency>
    ```

  - `mybatis/mybatis-spring`

    MyBatis와 Spring 연동용 라이브러리

    ```xml
    <!-- 스프링에서 데이터베이스 처리와 트랜잭션 처리 -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-tx</artifactId>
        <version>${org.springframework-version}</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>${org.springframework-version}</version>
    </dependency>
    ```

    

- `SQLSessionFactory`

  - 내부적으로 `SQLSession` 생성
  - `SQLSession`을 통해 `Connection` 생성하거나 원하는 SQL 전달하고 결과 리턴받는 구조로 작성됨

#

#### 스프링과 연동 처리

#####  `MyBatis`의 `Mapper`

- `SQLSessionFactory`를 이용하는 것보다 SQL 처리 설정 분리하고 자동으로 처리되는 방식이 더 편함

- `MyBatis-Spring` 이용 시 xml과 인터페이스 + 어노테이션 형태로 작성 가능

- SQL이 길어질 경우 XML 이용 => `MapperInterface`와 동시 사용

  - XML 파일은 `MapperInterface`와 같은 이름을 사용 할 것

  - 위치

    - `MapperInterface`와 같은 폴더 내
    - `src/main/resources`에 XML 폴더 생성

  - 메소드 선언 => 인터페이스

    SQL 처리 => XML

  - id와 메소드 이름 같아야 서로 인식됨

#

#### log4jdbc-log4j2 설정











