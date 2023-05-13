plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    val grpcKotlinVersion = "1.3.0"
    val grpcVersion = "1.54.0"
    val protobufVersion = "3.22.2"
    implementation("io.grpc:grpc-netty:1.42.1")
    implementation("io.grpc:grpc-kotlin-stub:$grpcKotlinVersion")
    implementation("io.grpc:grpc-protobuf:$grpcVersion")
    implementation("com.google.protobuf:protobuf-kotlin:$protobufVersion")
    implementation("io.grpc:grpc-stub:1.54.0")
    implementation("io.grpc:grpc-okhttp:1.54.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    // https://mvnrepository.com/artifact/org.ktorm/ktorm-core
    implementation("org.ktorm:ktorm-core:3.6.0")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}