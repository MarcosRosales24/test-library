plugins {
    kotlin("jvm") version "1.9.21"
}

group = "com.test"
version = "1.0.1-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}


dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.0")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("org.seleniumhq.selenium:selenium-java:4.16.1")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(18)
}