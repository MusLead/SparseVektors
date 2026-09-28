# SparseVektors

A Java exercise project that represents a sparse vector with a singly linked list. Each stored node contains an index and a nonzero `double` value, so the implementation does not need a node for every zero entry. The repository includes a small console demonstration and a JUnit test suite; the tests are the main way to check the implementation.

## Requirements

- JDK 17 (the GitHub Actions build uses Java 17)
- No separate Gradle installation: the repository includes the Gradle 8.10 wrapper

On macOS, if JDK 17 was installed with Homebrew, select it for the current terminal session:

```bash
export JAVA_HOME="$(brew --prefix openjdk@17)/libexec/openjdk.jdk/Contents/Home"
export PATH="$JAVA_HOME/bin:$PATH"
java -version
```

## Get the project

```bash
git clone https://github.com/MusLead/SparseVektors.git
cd SparseVektors
```

Run the following commands from the repository root (the directory containing `build.gradle` and `gradlew`). On Windows, substitute `gradlew.bat` for `./gradlew`.

## Test the implementation

```bash
./gradlew test
```

This runs the JUnit Jupiter tests in `src/test/java/de/hsfd/algods/CheckSparseVector.java`. They cover inserting and reading values, ignoring zero values, removing elements, equality, vector addition, invalid indices, size limits, and linked-list navigation. Gradle writes an HTML report to `build/reports/tests/test/index.html`.

To run just this test class:

```bash
./gradlew test --tests de.hsfd.algods.CheckSparseVector
```

To compile and run the tests together as part of the full build:

```bash
./gradlew build
```

## Run the console example

`Main.java` creates two vectors and prints the results of adding, removing, and looking up elements. It is a demonstration, not the complete test suite.

```bash
./gradlew classes
java -cp build/classes/java/main de.hsfd.algods.Main
```

There is currently no Gradle `run` task because `build.gradle` applies the Java plugin but does not configure the Application plugin.

## Project structure

| Path | Purpose |
| --- | --- |
| `src/main/java/de/hsfd/algods/SparseVector.java` | Sparse vector and linked-list implementation |
| `src/main/java/de/hsfd/algods/Main.java` | Console demonstration |
| `src/test/java/de/hsfd/algods/CheckSparseVector.java` | JUnit tests |
| `build.gradle` | Java and JUnit build configuration |
| `gradle/wrapper/gradle-wrapper.properties` | Gradle wrapper version |

## Contributing

Add focused JUnit tests to `CheckSparseVector.java` when changing the implementation. Run `./gradlew test` before submitting a pull request. The linked list is intended to keep entries in ascending index order.

## Evaluation Testat 1 WS24/25

> Timo Geier "Ich hatte an ein paar Stellen euch Punkte abziehen müssen, weil ihr die nicht erklären oder erst nach ein paar Tipps erklären konntet (bspw. Additionsfälle von SparseVektoren). Auch hatten in eurer Implementierung Punkte gefehlt (Addition zweier Werte in Vektor ergibt 0 und Knoten wird entfernt hatte gefehlt), die wir gewertet haben, wo aber auf Nachfrage ihr das noch erklären konntet. Auch manche Tests, die wir sehen wollten, waren nicht vollständig implementiert wie wir das gerne haben wollten."

1. We could not give an explanation correctly.
2. Missing implementation: addition of two elements that results in zero.
3. We could not explain or demonstrate a meaningful, manageable set of tests.
