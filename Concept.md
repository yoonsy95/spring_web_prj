## Part01. 01 개발준비

### spring 구조

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
  



## Part01. 02 스프링 특징과 의존성 주입

