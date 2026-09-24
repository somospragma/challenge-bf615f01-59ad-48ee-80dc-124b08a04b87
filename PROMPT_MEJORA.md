# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/test/java/com/fintech/qa/tasks/RealizarTransaccion.java` — `com.fintech.qa.ui.TransaccionPage`: El import com.fintech.qa.ui.TransaccionPage usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `src/test/java/com/fintech/qa/questions/VerificarSaldo.java` — `com.fintech.qa.ui.SaldoPage`: El import com.fintech.qa.ui.SaldoPage usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `src/test/java/com/fintech/qa/steps/CajaNegraSteps.java` — `RealizarTransaccion.conValor`: Se invoca `conValor` sobre `RealizarTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean test-compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Calidad de Software, Especialidad Automatizador, Tecnología Testing, Advanced

### Brecha de conocimiento
Implementa al menos una (1) técnica de caja negra como: Partición de Equivalencia, Análisis de Valores Límite, Pruebas de Transición de Estado y Tablas de Decisión o de caja blanca incluyendo: Cobertura de Sentencia, de Rama, de Condición y de Camino para aumentar la cobertura de ejecucion de escenarios y casos de prueba.

### Misión / candidato
Candidato con experiencia avanzada en automatización de pruebas.

### Reto
- Tema: Técnicas de Generación de Casos de Pruebas - Caja Negra
- Seniority: advanced-l2
- Tipo: theoretical
- Título: Implementación de Técnicas de Caja Negra en Pruebas de Software
- Tiempo estimado: 4 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Exploración de Técnicas de Caja Negra — objetivo: Comprender y seleccionar una técnica de caja negra adecuada para el contexto. — entregable (NO resolver): Descripción detallada de una técnica de caja negra seleccionada, incluyendo sus ventajas y desventajas.
- Fase 2: Aplicación de la Técnica Seleccionada — objetivo: Aplicar la técnica de caja negra seleccionada para generar casos de prueba. — entregable (NO resolver): Documentación de los casos de prueba generados utilizando la técnica de caja negra seleccionada.
- Fase 3: Evaluación y Mejora Continua — objetivo: Evaluar la efectividad de la técnica de caja negra aplicada y proponer mejoras. — entregable (NO resolver): Reporte de evaluación de la técnica de caja negra aplicada, incluyendo propuestas de mejora.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.fintech.qa</groupId>
    <artifactId>fintech-qa-automation</artifactId>
    <version>1.0.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <serenity.version>4.0.48</serenity.version>
        <cucumber.version>7.15.0</cucumber.version>
        <junit.version>5.10.0</junit.version>
        <selenium.version>4.16.1</selenium.version>
    </properties>

    <dependencies>
        <!-- Serenity BDD -->
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-core</artifactId>
            <version>${serenity.version}</version>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-cucumber</artifactId>
            <version>${serenity.version}</version>
        </dependency>

        <!-- Cucumber -->
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>${cucumber.version}</version>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>

        <!-- JUnit 5 -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>

        <!-- Selenium -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>${selenium.version}</version>
        </dependency>

        <!-- OpenCSV for CSV data handling -->
        <dependency>
            <groupId>com.opencsv</groupId>
            <artifactId>opencsv</artifactId>
            <version>5.7.1</version>
        </dependency>

        <!-- Jackson for JSON data handling -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.16.1</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.2.5</version>
                <configuration>
                    <testFailureIgnore>false</testFailureIgnore>
                    <includes>
                        <include>**/RunCucumberTest.java</include>
                    </includes>
                </configuration>
            </plugin>
            <plugin>
                <groupId>net.serenity-bdd</groupId>
                <artifactId>serenity-maven-plugin</artifactId>
                <version>${serenity.version}</version>
                <executions>
                    <execution>
                        <id>serenity-reports</id>
                        <phase>post-integration-test</phase>
                        <goals>
                            <goal>aggregate</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

    <reporting>
        <plugins>
            <plugin>
                <groupId>net.serenity-bdd</groupId>
                <artifactId>serenity-maven-plugin</artifactId>
                <version>${serenity.version}</version>
            </plugin>
        </plugins>
    </reporting>
</project>

// === ARCHIVO: src/test/resources/features/caja_negra_tecnicas.feature ===
Feature: Técnicas de caja negra en pruebas de software fintech

  Scenario: Partición de Equivalencia
    Given que el usuario ha ingresado un valor dentro del rango de partición de equivalencia
    When el usuario realiza una transacción
    Then se espera que la transacción sea procesada correctamente

  Scenario: Análisis de Valores Límite
    Given que el usuario ha ingresado un valor en el límite inferior del rango
    When el usuario realiza una transacción
    Then se espera que la transacción sea procesada correctamente

  Scenario: Tablas de Decisión
    Given que el usuario ha ingresado valores que satisfacen una regla de la tabla de decisión
    When el usuario realiza una transacción
    Then se espera que la transacción sea procesada según la regla correspondiente

// === ARCHIVO: src/test/java/com/fintech/qa/runners/RunCucumberTest.java ===
package com.fintech.qa.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.fintech.qa.steps",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        }
)
public class RunCucumberTest {
    // Constructor vacío para cumplir con las convenciones de JUnit
    public RunCucumberTest() {
        // Inicialización vacía
    }
}

// === ARCHIVO: src/test/java/com/fintech/qa/steps/CajaNegraSteps.java ===
package com.fintech.qa.steps;

import com.fintech.qa.tasks.RealizarTransaccion;
import com.fintech.qa.questions.VerificarSaldo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static net.serenitybdd.screenplay.GivenWhenThen.then;

public class CajaNegraSteps {

    @Steps
    RealizarTransaccion realizarTransaccion;
    @Steps
    VerificarSaldo verificarSaldo;

    private Actor actor;
    private WebDriver driver;

    public CajaNegraSteps() {
        this.driver = new ChromeDriver();
        this.actor = Actor.named("usuario").whoCan(BrowseTheWeb.with(driver));
    }

    @Given("que el usuario ha ingresado un valor dentro del rango de partición de equivalencia")
    public void ingresarValorParticionEquivalencia() {
        realizarTransaccion.conValor("100");
    }

    @When("el usuario realiza una transacción")
    public void realizarTransaccion() {
        actor.attemptsTo(realizarTransaccion);
    }

    @Then("se espera que la transacción sea procesada correctamente")
    public void verificarTransaccionCorrecta() {
        then(actor).should(Ensure.that(verificarSaldo).answeredBy(actor).isEqualTo("100"));
    }

    @Given("que el usuario ha ingresado un valor en el límite inferior del rango")
    public void ingresarValorLimiteInferior() {
        realizarTransaccion.conValor("0");
    }

    @Given("que el usuario ha ingresado valores que satisfacen una regla de la tabla de decisión")
    public void ingresarValoresTablaDecision() {
        realizarTransaccion.conValor("50");
    }
}

// === ARCHIVO: src/test/java/com/fintech/qa/tasks/RealizarTransaccion.java ===
package com.fintech.qa.tasks;

import com.fintech.qa.ui.TransaccionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RealizarTransaccion implements Task {
    private final String monto;
    private final String cuentaOrigen;
    private final String cuentaDestino;
    private final String tipoTransaccion;

    public RealizarTransaccion(String monto, String cuentaOrigen, String cuentaDestino, String tipoTransaccion) {
        this.monto = monto;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.tipoTransaccion = tipoTransaccion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(TransaccionPage.BOTON_REALIZAR_TRANSACCION, isVisible()).forNoMoreThan(10).seconds(),
            Click.on(TransaccionPage.BOTON_REALIZAR_TRANSACCION),
            Enter.theValue(monto).into(TransaccionPage.CAMPO_MONTO),
            Enter.theValue(cuentaOrigen).into(TransaccionPage.CAMPO_CUENTA_ORIGEN),
            Enter.theValue(cuentaDestino).into(TransaccionPage.CAMPO_CUENTA_DESTINO),
            SelectFromOptions.byVisibleText(tipoTransaccion).from(TransaccionPage.SELECCION_TIPO_TRANSACCION),
            Click.on(TransaccionPage.BOTON_CONFIRMAR_TRANSACCION)
        );
    }

    public static RealizarTransaccion de(String monto, String cuentaOrigen, String cuentaDestino, String tipoTransaccion) {
        return new RealizarTransaccion(monto, cuentaOrigen, cuentaDestino, tipoTransaccion);
    }
}

// === ARCHIVO: src/test/java/com/fintech/qa/questions/VerificarSaldo.java ===
package com.fintech.qa.questions;

import com.fintech.qa.ui.SaldoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;

public class VerificarSaldo implements Question<String> {
    private final String cuenta;

    public VerificarSaldo(String cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    @Step("{0} verifica el saldo de la cuenta {1}")
    public String answeredBy(Actor actor) {
        return Text.of(SaldoPage.SALDO_CUENTA.of(cuenta)).viewedBy(actor).asString();
    }

    public static VerificarSaldo deLaCuenta(String cuenta) {
        return new VerificarSaldo(cuenta);
    }
}

// === ARCHIVO: src/test/java/com/fintech/qa/exceptions/ValidacionException.java ===
package com.fintech.qa.exceptions;

public class ValidacionException extends RuntimeException {
    public ValidacionException(String message) {
        super(message);
    }

    public ValidacionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidacionException(Throwable cause) {
        super(cause);
    }

    protected ValidacionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

// === ARCHIVO: src/test/resources/data/valores_limite.csv ===
id,valor,es_valido
1,1,true
2,100,true
3,101,false
4,-1,false
5,50,true
6,150,false
7,0,true
8,200,false
9,75,true
10,125,true

// === ARCHIVO: src/test/resources/data/particiones_equivalencia.csv ===
id,valor,particion
1,1,valido
2,100,valido
3,101,invalido
4,-1,invalido
5,50,valido
6,150,invalido
7,0,valido
8,200,invalido
9,75,valido
10,125,valido

// === ARCHIVO: src/test/resources/data/tabla_decision.json ===
[
  {
    "id": 1,
    "condiciones": [
      {"nombre": "es_mayor_de_edad", "valor": true},
      {"nombre": "tiene_ingresos", "valor": true}
    ],
    "resultado": "aprobado"
  },
  {
    "id": 2,
    "condiciones": [
      {"nombre": "es_mayor_de_edad", "valor": false},
      {"nombre": "tiene_ingresos", "valor": true}
    ],
    "resultado": "rechazado"
  },
  {
    "id": 3,
    "condiciones": [
      {"nombre": "es_mayor_de_edad", "valor": true},
      {"nombre": "tiene_ingresos", "valor": false}
    ],
    "resultado": "rechazado"
  },
  {
    "id": 4,
    "condiciones": [
      {"nombre": "es_mayor_de_edad", "valor": false},
      {"nombre": "tiene_ingresos", "valor": false}
    ],
    "resultado": "rechazado"
  }
]

// === ARCHIVO: src/test/java/com/fintech/qa/ValidacionCajaNegraTest.java ===
package com.fintech.qa;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@ExtendWith(SerenityJUnit5Extension.class)
public class ValidacionCajaNegraTest {

    @Test
    public void particionDeEquivalencia() {
        // Simulamos la ejecución de un escenario de Partición de Equivalencia
        Assertions.assertTrue(true);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data/valores_limite.csv", numLinesToSkip = 1)
    public void analisisDeValoresLimite(String input, String expected) {
        // Simulamos la ejecución de un escenario de Análisis de Valores Límite
        Assertions.assertEquals(expected, input);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data/tabla_decision.json", numLinesToSkip = 1)
    public void tablaDeDecision(String input, String expected) {
        // Simulamos la ejecución de un escenario de Tabla de Decisión
        Assertions.assertEquals(expected, input);
    }
}

// === ARCHIVO: README.md ===
# Proyecto de Automatización de Pruebas QA

## Estructura del Proyecto
- `src/test/java/com/fintech/qa/`: Contiene las clases de prueba unitaria y de integración.
- `src/test/resources/features/`: Contiene los archivos.feature de Gherkin.
- `src/test/resources/data/`: Contiene los archivos CSV y JSON con datos de prueba.

## Ejecución de Pruebas
Para ejecutar las pruebas, utiliza el siguiente comando:
```bash
mvn clean test
```
Este comando compilará el proyecto y ejecutará todas las pruebas unitarias y de integración.

## Reportes
Los reportes de las pruebas se generarán en la carpeta `target/site/serenity/`. Puedes acceder a ellos para revisar los detalles de la ejecución de las pruebas.
```
