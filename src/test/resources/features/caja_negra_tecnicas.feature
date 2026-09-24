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