### Part1

#### pom.xml 빨간 경고

- `C:\Users\yegyo\.m2`의 `repository` 삭제 -> `eclipse` 재실행

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

