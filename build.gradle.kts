import org.jetbrains.gradle.ext.JavaLanguageVersion

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.withType<java.compile.JavaCompile> {
    options.release.set(21)
}
