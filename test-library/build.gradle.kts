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
        create<MavenPublication>("mavenKotlin") {
            from(components["java"])

            groupId = group.toString()
            artifactId = "test-library"
            version = version.toString()

            pom {
                name.set("test-library")
                description.set("library to test")
                url.set("https://github.com/MarcosRosales24/test-library")

//                licenses {
//                    license {
//                        name.set("The Apache Software License, Version 2.0")
//                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
//                    }
//                }
            }
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