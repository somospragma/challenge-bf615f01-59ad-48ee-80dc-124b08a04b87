# Implementación de Técnicas de Caja Negra en Pruebas de Software

En el contexto de una empresa de desarrollo de software fintech, se requiere mejorar la calidad de las pruebas de software mediante la aplicación de técnicas de caja negra. El objetivo es identificar y cubrir adecuadamente los casos de prueba para asegurar que el software se comporta correctamente bajo diferentes condiciones. Los actores involucrados son el equipo de desarrollo, el equipo de QA y los clientes finales. La propiedad operativa clave es la cobertura de pruebas, con un umbral del 90% para las pruebas de caja negra. La razón de negocio es reducir el número de bugs en producción y mejorar la satisfacción del cliente.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Técnicas de Generación de Casos de Pruebas - Caja Negra |
| **Nivel** | advanced-l2 |
| **Tipo** | theoretical |
| **Tiempo estimado** | 4 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Exploración de Técnicas de Caja Negra

**Objetivo:** Comprender y seleccionar una técnica de caja negra adecuada para el contexto.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Investiga y describe al menos una técnica de caja negra (Partición de Equivalencia, Análisis de Valores Límite, Pruebas de Transición de Estado o Tablas de Decisión).
- Identifica las ventajas y desventajas de cada técnica en el contexto de pruebas de software fintech.

**Entregable:** Descripción detallada de una técnica de caja negra seleccionada, incluyendo sus ventajas y desventajas.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo cada técnica puede ser aplicada en diferentes escenarios de prueba.
- Piensa en cómo la selección de una técnica puede impactar en la cobertura de pruebas y en la eficiencia del proceso de QA.

</details>

### Fase 2: Aplicación de la Técnica Seleccionada

**Objetivo:** Aplicar la técnica de caja negra seleccionada para generar casos de prueba.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Aplica la técnica de caja negra seleccionada para identificar y generar casos de prueba para un módulo específico del software.
- Documenta los casos de prueba generados y describe cómo la técnica ayuda a cubrir diferentes escenarios de prueba.

**Entregable:** Documentación de los casos de prueba generados utilizando la técnica de caja negra seleccionada.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo la técnica puede ayudar a identificar edge cases y cubrir escenarios que podrían ser olvidados con otras técnicas.
- Piensa en cómo la documentación de los casos de prueba puede ser utilizada por el equipo de desarrollo y QA.

</details>

### Fase 3: Evaluación y Mejora Continua

**Objetivo:** Evaluar la efectividad de la técnica de caja negra aplicada y proponer mejoras.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Evalúa la efectividad de la técnica de caja negra aplicada en términos de cobertura de pruebas y detección de bugs.
- Propone mejoras para la aplicación de la técnica en futuros proyectos.

**Entregable:** Reporte de evaluación de la técnica de caja negra aplicada, incluyendo propuestas de mejora.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo la técnica puede ser combinada con otras técnicas de prueba para mejorar la cobertura.
- Piensa en cómo la retroalimentación del equipo de desarrollo y QA puede ser utilizada para mejorar la aplicación de la técnica.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es la técnica de caja negra seleccionada y cómo se aplica en el contexto de pruebas de software?
- **paraQueSirve**: ¿Para qué sirve la técnica de caja negra seleccionada en el proceso de QA?
- **comoSeUsa**: ¿Cómo se usa la técnica de caja negra seleccionada para generar casos de prueba?
- **erroresComunes**: ¿Cuáles son los errores comunes al aplicar la técnica de caja negra seleccionada?
- **queDecisionesImplica**: ¿Qué decisiones implica la aplicación de la técnica de caja negra seleccionada en el proceso de QA?

## Criterios de Evaluacion

- Descripción detallada de una técnica de caja negra seleccionada.
- Documentación de casos de prueba generados utilizando la técnica de caja negra.
- Reporte de evaluación de la técnica de caja negra aplicada, incluyendo propuestas de mejora.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean test-compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
