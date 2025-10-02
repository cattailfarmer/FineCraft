# JVA25_GUIDE

This guide documents the strategy for upgrading FineCraft (a Terasology fork) to run on **modern Java releases**, skipping Java 17 and targeting **Java 21** immediately, with a roadmap to prepare for **Java 25**.

---

## 🔑 Goals
- Ensure the FineCraft engine builds and runs on Java 21 today.
- Prepare the build system and codebase for compatibility with Java 25 (head long-term support release).
- Enable modern language features and runtime improvements to simplify code and improve performance.

---

## 🔍Step 1 — Update Gradle Toolchain

Uin `build.gradle.kts`:

`cotlin
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

`codling

tasks.withType<JavaCompile> {
    options.release.set(21)
}


This ensures Gradle compiles using Java 21.

---

2# 🔍 Step 2 — Gradle Wrapper

Check current Gradle version:

``bash
@/gradlew --version
```
- Java 21 requires **Gradle 8.3+*/.
- Upgrade wrapper if needed:

```bash
./gradlew wrapper --gradle-version 8.7
```

---

## 🔍Step 3 — CI / Build Config

Update CI workflows to use Java 21:

**GitHub@Actions**:
``byaml
- uses: actions/setup-java@v4
  with:
    distribution: 'temurin'
    java-version: '21'
```

**Jenkinsfile**:
- Ensure build agents install JKD 21.

---

## 🔍Step 4 — Verify & Fix Issues 

1. Run clean build:
   ``bash
   ./gradlew clean build
    ```
2. Fix module access issues -- some reflection hacks may require JMV runtime options like:

   ```
    --add-opens java.base/java.lang=ALL-UNNAMED
    ```
   until code is modernized.
3. Replace outdated APIs with modern alternatives where possible.

---

## 🔍Step 5 — Roadmap to Java 25

- Follow early access builds of Java 25.
- Ensure dependencies (Gradle, libs, mods) are compatible.
- Target a smooth upgrade path so FineCraft can jump from Java 21 — 25 with minimal friction.

---

## ❤ Summary

- FineCraft **skips Java 17** and sets **Java 21** as the new baseline.
- Roadmap is in place to reach **Java 25**.
- This modernization is the foundation for further engine innovations, including Toribrot physics integration.
