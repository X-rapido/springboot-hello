# springboot-hello
一个非常简单的helloworld项目，方便以后在其他项目上调用演示而已。

## build.gradle
```groovy
plugins {
	id 'org.springframework.boot' version '2.2.0.RELEASE'
	id 'io.spring.dependency-management' version '1.0.8.RELEASE'
	id 'java'
}

group = 'com.example'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '1.8'

configurations {
	compileOnly {
		extendsFrom annotationProcessor
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-web'
	compileOnly 'org.projectlombok:lombok'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation('org.springframework.boot:spring-boot-starter-test') {
		exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
	}
}

test {
	useJUnitPlatform()
}
```

## IndexController
```java
@RestController
public class IndexController {

    @RequestMapping("/hello")
    public String hello() {
        return "嗨，你好😊。";
    }

    /**
     * 测试慢执行
     */
    @RequestMapping("/hello/cycle")
    public String helloCycle(String stop) throws InterruptedException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < 10000; i++) {
            TimeUnit.MILLISECONDS.sleep(10);
            System.out.println(i + " 嗨，你好 " + LocalDateTime.now().format(dtf));
        }
        return "hello cycle over";
    }

    /**
     * 测试异常
     */
    @RequestMapping("/division")
    public String division() {
        System.out.println(1 / 0);
        return "division over";
    }
}
```