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
        create<MavenPublication>("mavenJava") {
            from(components["kotlin"])
            groupId = "com.test"
            artifactId = "test-library"
            version = "1.0.0"
        }
    }


    repositories {
        maven {
            url = uri("https://github.com/MarcosRossales24/test-library.git")
            credentials {
                username = "Marcos"
                password = System.getenv("MAVEN_SECRET")
            }
        }
    }
}

signing {
    sign(publishing.publications["mavenJava"])
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