/* plugins {
        id 'org.springframework.boot' version '2.4.3'
        id 'io.spring.dependency-management' version '1.0.11.RELEASE'
        id 'java'
// id 'war'
        }

        group = 'com.crud'
        version = '0.0.1-SNAPSHOT'
        sourceCompatibility = '11'

        repositories {
        mavenCentral()
        }

        dependencies {
        implementation 'org.springframework.boot:spring-boot-starter-web'
        implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
        testImplementation 'org.springframework.boot:spring-boot-starter-test'
        implementation 'org.springframework.boot:spring-boot-starter-validation'
// runtimeOnly 'mysql:mysql-connector-java'
        runtimeOnly 'org.postgresql:postgresql'
        compileOnly 'org.projectlombok:lombok:1.18.16'
        annotationProcessor 'org.projectlombok:lombok:1.18.16'
        testImplementation ('org.springframework.boot:spring-boot-starter-test') {
        exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
        }
        testCompileOnly 'org.projectlombok:lombok:1.18.16'
        testAnnotationProcessor 'org.projectlombok:lombok:1.18.16'
        implementation group: 'org.springframework.data', name: 'spring-data-jpa', version: '2.4.3'

// providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat'
        }

        test {
        useJUnitPlatform()
        }
*/