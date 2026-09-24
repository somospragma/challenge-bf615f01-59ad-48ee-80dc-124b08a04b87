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