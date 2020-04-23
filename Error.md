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

- 에러 있었음

  `@Configuration`->`@ContextConfiguration`











