plugins {
    id("com.android.application") version "8.1.0" apply false
    id("com.android.library") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

val newBuildDir: Directory = 
    rootProject.layout.buildDirectory.dir("../build").get()

rootProject.buildDir = newBuildDir

subprojects {
    val newSubprojectBuildDir: Directory = 
        rootProject.layout.buildDirectory.dir(project.name).get()
    project.buildDir = newSubprojectBuildDir
}

subprojects {
    project.evaluationDependsOn(":app")
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
