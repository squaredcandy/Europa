plugins {
    kotlin("jvm") version "1.4.20"
    maven
}

group = "com.squaredcandy"
version = "0.1.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}
