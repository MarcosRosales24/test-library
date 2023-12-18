plugins {
    kotlin("jvm") version "1.9.21"
    `maven-publish`
    signing
}

group = "com.test"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()

}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = "test-library"
            from(components["java"])

        }
    }
    repositories {
        maven {
            url = uri("https://github.com/MarcosRosales24/test-library.git")
            credentials {
                username = "Marcos"
                password = System.getenv("MAVEN_SECRET")
            }
        }
    }
}

allprojects {
    group = "com.test"
    kotlin {
        jvmToolchain(18)
    }

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
