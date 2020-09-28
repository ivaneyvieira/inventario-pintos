import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  // Apply the Kotlin JVM plugin to add support for Kotlin.
  id("org.jetbrains.kotlin.jvm") version "1.4.10"
  id("org.jetbrains.kotlin.kapt") version "1.4.10"
  id("io.ebean") version "12.4.1"
}

repositories {
  jcenter()
  mavenLocal()
  mavenCentral()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
  jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
  jvmTarget = "1.8"
}

ebean {
  debugLevel = 1
}

dependencies {
  //Ebean
  implementation("io.ebean:ebean:12.3.6")
  implementation("io.ebean:ebean-querybean:12.3.6")
  implementation("io.ebean.tools:finder-generator:12.1.1")
  testImplementation("io.ebean:ebean-agent:12.3.6")
  kapt("io.ebean:kotlin-querybean-generator:12.3.7")
  testImplementation("io.ebean:ebean-test:12.3.6")
  //Database
  implementation("mysql:mysql-connector-java:5.1.48")
  implementation("org.xerial:sqlite-jdbc:3.21.0.1")
  implementation("org.sql2o:sql2o:1.5.4")
  implementation("com.zaxxer:HikariCP:3.4.1")
  implementation("org.imgscalr:imgscalr-lib:4.2")
  //Util
  implementation("khttp:khttp:1.0.0")
  //Kotlin
  implementation("org.jetbrains.kotlin:kotlin-bom")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  testImplementation("org.jetbrains.kotlin:kotlin-test")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

