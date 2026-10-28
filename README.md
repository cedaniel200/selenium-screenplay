# Selenium + Cucumber + Screenplay — Demo Saucedemo

![Java](https://img.shields.io/badge/Java-17-blue)
![Selenium](https://img.shields.io/badge/Selenium-4.33.0-green)
![Cucumber](https://img.shields.io/badge/Cucumber-8.0.4-brightgreen)
![Gradle](https://img.shields.io/badge/Gradle-9.8.2-darkgreen)
![Screenplay](https://img.shields.io/badge/Screenplay-pattern-blue)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)

Proyecto de ejemplo para mostrar una implementación sencilla del patrón Screenplay con Selenium y
Cucumber, sin Serenity. La automatización es independiente de la aplicación: los escenarios Gherkin
delegan en actores, tareas y preguntas.

## Qué incluye

- **4 escenarios** en dos features: autenticación y compra.
- **Screenplay propio**: `Actor`, `Action`, `Question`, `Actors` y páginas de UI.
- **Selenium 4** con Chrome o Firefox; los drivers los resuelve Selenium Manager.
- **Cucumber 8 sobre JUnit Platform** y ejecución headless por defecto.
- **Informe HTML** en `target/cucumber-reports/index.html`.
- **Sin credenciales locales**: saucedemo publica sus usuarios de demo.

## Requisitos

- **JDK 17**.
- **Gradle**: no hace falta instalarlo; el wrapper va incluido.
- **Chrome o Firefox** instalado.
- **Acceso a internet** la primera vez, para que Selenium Manager descargue el driver.

## Cómo se ejecuta

```sh
./gradlew test
```

Para ver el navegador:

```sh
./gradlew test -Dheadless=false
```

Para usar Firefox:

```sh
./gradlew test -Dwebdriver.driver=firefox
```

El informe queda en:

```text
target/cucumber-reports/index.html
```

## Estructura

```text
src/main/java/com/cedaniel200
├── automation/screenplay
│   ├── actions/Action.java          # contrato de una acción
│   ├── sop/Actor.java               # actor que ejecuta tareas
│   ├── sop/Actors.java              # registro de actores
│   ├── Question.java                # contrato de una pregunta
│   └── utils                          # driver y esperas
└── saucedemo
    ├── model                         # User y Customer
    ├── pages                         # page objects con @FindBy
    ├── questions                     # validaciones del negocio
    └── tasks                         # login, carrito y checkout

src/test
├── java/.../runners/CucumberTestSuite.java
├── java/.../stepdefinitions/
└── resources/features/
```

## Screenplay con Cucumber

| Concepto | Dónde vive | Ejemplo |
|---|---|---|
| Escenario | `features` | «Completar el checkout» |
| Paso | `stepdefinitions` | `Cesar completa el checkout con sus datos` |
| Actor | `screenplay/sop` | `theActorCalled("Cesar")` |
| Tarea | `saucedemo/tasks` | `Authenticate.with(user)` |
| Pregunta | `saucedemo/questions` | `new OrderConfirmed()` |
| Página | `saucedemo/pages` | `CheckoutPage` |

El paso le pide al actor que ejecute tareas. Las tareas usan las páginas; las preguntas validan el
resultado. El feature no conoce selectores ni detalles de Selenium.

## Ten en cuenta

- **Saucedemo es un sitio público de práctica.** No hay datos reales ni credenciales privadas.
- **Los tests dependen de la red.** Si saucedemo no responde, fallan por el sitio, no por el código.
- **No hay drivers versionados.** Selenium Manager descarga el driver adecuado para el navegador
  instalado.
- **El informe HTML usa Jackson**, que Cucumber 8 necesita para los formatters HTML y JSON.

## Licencia

[MIT](LICENSE) © Cesar Daniel
