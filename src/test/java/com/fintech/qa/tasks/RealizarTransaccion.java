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