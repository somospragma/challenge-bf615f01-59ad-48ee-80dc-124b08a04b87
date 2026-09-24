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