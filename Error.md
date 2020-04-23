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





















