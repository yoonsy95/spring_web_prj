## Part01

#### pom.xml 빨간 경고

- `C:\Users\yegyo\.m2`의 `repository` 삭제 -> `eclipse` 재실행

#

#### `Multiple annotations found at this line:`
`- schema_reference.4: Failed to read schema document 'https://maven.apache.org/maven-v4_0_0.xsd', because 1) could not find the document; 2) the document could not be read; 3) the root element 
 of the document is not <xsd:schema>.`

`- cvc-elt.1: Cannot find the declaration of element 'project'.`

- ..? 해당 오류 부분을 다른 pom.xml을 부분을 붙여넣으니 잘 됨

#

#### 서버 실행시 `invalid loc header(bad signature)`

- 위 절차 실행 후 `Maven` -> `Update Project`

#

#### lombok 사용시 `The import lombok cannot be resolved`

```xml
<dependency> 
    <groupId>org.projectlombok</groupId> 
    <artifactId>lombok</artifactId> 
    <version>1.18.12</version>
    <scope>provided</scope> 
</dependency>
```

- pom.xml에 위 내용 추가 후 `Maven` -> `Update Project`

#

#### 테스트 시 `Class<SpringJUnit4ClassRunner> cannot be resolved to a type`

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-test</artifactId>
    <version>5.0.7.RELEASE</version>
</dependency>
```

- spring의 다른 `dependency`들과 버전이 같아야 함

#

#### `Caused by: java.lang.IllegalStateException: SpringJUnit4ClassRunner requires JUnit 4.12 or higher.`

- junit 버전 12이상으로 업그레이드

#

#### `Caused by: java.lang.IllegalStateException: Neither GenericXmlContextLoader nor AnnotationConfigContextLoader was able to load an ApplicationContext from [MergedContextConfiguration@5622fdf testClass = SampleTests, locations = '{}', classes = '{}', contextInitializerClasses = '[]', activeProfiles = '{}', propertySourceLocations = '{}', propertySourceProperties = '{}', contextCustomizers = set[[empty]], contextLoader = 'org.springframework.test.context.support.DelegatingSmartContextLoader', parent = [null]].`

- 오타 있었음

  `@Configuration`->`@ContextConfiguration`

#

#### `Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'lab.spring.sample.Restaurant' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {}`

- 오류 못찾겠음..

- 아니 간단한 예제인데 어디서 연결안됬다고 뜬거지ㅠㅠㅠ

- `xml`로 결과보고 `java`로 바꾼건데 어디서...!!

- `setter/getter`, `toString`까지 생성된 것 확인

- ...연결이 안된건가 그럼??

- `@ContextConfiguration(classes= {RootConfig.class})` 

  이걸로 연결된거 아닌가..?

- 으어아아아아ㅏㅏㅏ

- 나중에 다시 볼 것!!

#

#### SQL Developer 사용자 등록시 `The Network Adapter could not establish the connection`

- oracle 싹 지우고 11gR2부터 다시 설치
- [Deinstall Oracle](https://rainflys.tistory.com/202)

#

#### TimeMapperTest.java 실행시 오류

#### JUnit 

#### `org.springframework.jdbc.UncategorizedSQLException: Error attempting to get column 'SYSDATE' from result set.  Cause: java.sql.SQLException: 지원되지 않는 문자 집합(클래스 경로에 orai18n.jar 추가): KO16MSWIN949`

; uncategorized SQLException; SQL state [99999]; error code [17056]; 지원되지 않는 문자 집합(클래스 경로에 orai18n.jar 추가): KO16MSWIN949; nested exception is java.sql.SQLException: 지원되지 않는 문자 집합(클래스 경로에 orai18n.jar 추가): KO16MSWIN949

#### Console

`INFO : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from class path resource [org/springframework/jdbc/support/sql-error-codes.xml]
INFO : org.springframework.jdbc.support.SQLErrorCodesFactory - SQLErrorCodes loaded: [DB2, Derby, H2, HDB, HSQL, Informix, MS-SQL, MySQL, Oracle, PostgreSQL, Sybase]`

- orai18n.jar 추가로 등록

``` xml
<!-- https://mvnrepository.com/artifact/cn.easyproject/orai18n -->
<dependency>
    <groupId>cn.easyproject</groupId>
    <artifactId>orai18n</artifactId>
    <version>12.1.0.2.0</version>
</dependency>
```

#

## Part02

