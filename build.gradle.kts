plugins {
    id("java")
    id("net.minecrell.plugin-yml.bukkit") version "0.5.1"
}

group = "com.diogo"
version = "1.0"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    compileOnly("org.spigotmc:spigot:1.8.8-R0.1-SNAPSHOT")
    compileOnly("org.projectlombok:lombok:1.18.30")
    compileOnly(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation("org.jetbrains:annotations:23.0.0")

    annotationProcessor("org.projectlombok:lombok:1.18.30")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    sourceCompatibility = "17"
    targetCompatibility = "17"
}

tasks.withType<Jar> {
    destinationDirectory = File("/home/diogo/Área de Trabalho/Servidor/plugins/")
}

bukkit {
    name = "parkour"
    prefix = "parkour"
    version = "${project.version}"
    main = "com.diogo.parkour.ParkourPlugin"
    commands {
        register("parkour")
    }
}