# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Implementación de Técnicas de Caja Negra en Pruebas de Software**.

| | |
|---|---|
| Tema | Técnicas de Generación de Casos de Pruebas - Caja Negra |
| Nivel | advanced-l2 |
| Chapter | Calidad de Software |
| Especialidad | Automatizador |
| Stack | Java / Serenity BDD con Cucumber |
| Patron arquitectonico | Page Object Model con Screenplay para mantenibilidad y reutilización de componentes de prueba |
| Tiempo estimado | 4 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz con el runner y el plugin de reportes`
- `src/test/resources/features con los .feature en Gherkin`
- `src/test/java/.../runners con el runner`
- `src/test/java/.../pages o /tasks con Page Objects o Screenplay`
- `src/test/java/.../steps con los step definitions`
- `serenity.conf o config del entorno`

Trampas conocidas:

- Sin parent POM que gestione versiones, TODA dependencia lleva su `<version>` completa de tres segmentos.
- El groupId de Serenity es `net.serenity-bdd`, NO `org.serenity-bdd`. Con el groupId equivocado el artefacto no existe y el build muere resolviendo dependencias.
- Coordenadas exactas de lo mas usado: Selenium `org.seleniumhq.selenium:selenium-java`, Rest Assured `io.rest-assured:rest-assured`, Karate `com.intuit.karate:karate-junit5`, Cucumber `io.cucumber:cucumber-java`.
- JUnit 5 se declara con `junit-jupiter` (agregador) y necesita `maven-surefire-plugin` reciente para ejecutarse.
- Serenity y Cucumber tienen que ser de lineas compatibles entre si; mezclarlas rompe el runner.

Dependencias:

- net.serenity-bdd:serenity-core 4.0.48
- net.serenity-bdd:serenity-cucumber 4.0.48
- io.cucumber:cucumber-java 7.15.0
- io.cucumber:cucumber-junit 7.15.0
- org.junit.jupiter:junit-jupiter 5.10.0
- org.seleniumhq.selenium:selenium-java 4.16.1
- org.apache.maven.plugins:maven-surefire-plugin 3.2.5
- net.serenity-bdd:serenity-maven-plugin 4.0.48
- com.opencsv:opencsv 5.7.1
- com.fasterxml.jackson.core:jackson-databind 2.16.1

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean test-compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean test-compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Exploración de Técnicas de Caja Negra**: Descripción detallada de una técnica de caja negra seleccionada, incluyendo sus ventajas y desventajas.
- **Fase 2 — Aplicación de la Técnica Seleccionada**: Documentación de los casos de prueba generados utilizando la técnica de caja negra seleccionada.
- **Fase 3 — Evaluación y Mejora Continua**: Reporte de evaluación de la técnica de caja negra aplicada, incluyendo propuestas de mejora.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Lo que falta y tenes que completar

### 1. Referencias colgando (3)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/test/java/com/fintech/qa/tasks/RealizarTransaccion.java` — `com.fintech.qa.ui.TransaccionPage`
      El import com.fintech.qa.ui.TransaccionPage usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `src/test/java/com/fintech/qa/questions/VerificarSaldo.java` — `com.fintech.qa.ui.SaldoPage`
      El import com.fintech.qa.ui.SaldoPage usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `src/test/java/com/fintech/qa/steps/CajaNegraSteps.java` — `RealizarTransaccion.conValor`
      Se invoca `conValor` sobre `RealizarTransaccion`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (12)

- `pom.xml`
- `src/test/resources/features/caja_negra_tecnicas.feature`
- `src/test/java/com/fintech/qa/runners/RunCucumberTest.java`
- `src/test/java/com/fintech/qa/steps/CajaNegraSteps.java`
- `src/test/java/com/fintech/qa/tasks/RealizarTransaccion.java`
- `src/test/java/com/fintech/qa/questions/VerificarSaldo.java`
- `src/test/java/com/fintech/qa/exceptions/ValidacionException.java`
- `src/test/resources/data/valores_limite.csv`
- `src/test/resources/data/particiones_equivalencia.csv`
- `src/test/resources/data/tabla_decision.json`
- `src/test/java/com/fintech/qa/ValidacionCajaNegraTest.java`
- `README.md`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/test/java/com/fintech/qa`
- `src/test/java/com/fintech/qa/features`
- `src/test/java/com/fintech/qa/runners`
- `src/test/java/com/fintech/qa/steps`
- `src/test/java/com/fintech/qa/tasks`
- `src/test/java/com/fintech/qa/questions`
- `src/test/java/com/fintech/qa/exceptions`
- `src/test/resources/features`
- `src/test/resources/data`
- `target/site/serenity`

## Verificacion

```bash
mvn clean test-compile
```

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **Page Object Model con Screenplay para mantenibilidad y reutilización de componentes de prueba**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Calidad de Software, Especialidad Automatizador, Tecnología Testing, Advanced
- Brecha que el reto ataca: Implementa al menos una (1) técnica de caja negra como: Partición de Equivalencia, Análisis de Valores Límite, Pruebas de Transición de Estado y Tablas de Decisión o de caja blanca incluyendo: Cobertura de Sentencia, de Rama, de Condición y de Camino para aumentar la cobertura de ejecucion de escenarios y casos de prueba.
- Mision: Candidato con experiencia avanzada en automatización de pruebas.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
