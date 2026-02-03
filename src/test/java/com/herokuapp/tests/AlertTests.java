package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.availableExamples.AlertsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlertTests extends TestBase {
    AlertsPage alerts;

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getJavaScriptAlerts();
        alerts = new AlertsPage(driver);
    }

    @Test
    public void waitAlertTest() {
        alerts.verifyAlertWithTimer();
    }

    @Test
    public void alertWithSelectResult(){  // Abbrechen
        alerts.clickOnJsConfirm("Cancel")
                .verifyResult("Cancel");
    }

    @Test
    public void sendMessageToAlert(){
        alerts.clickOnJsPromptButton()
                .sendMessageToAlert("Hi!")
                .verifyMessage("Hi!");
    }
}
