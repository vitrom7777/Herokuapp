package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.availableExamples.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FormAuthTest extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getFormAuthenfication();

    }

    @Test
    public void loginPositiveTest() {
        new LoginPage(driver).enterUserData("tomsmith", "SuperSecretPassword!")
                .clickOnLoginButton()
                .verifyUserNameOnPageText("Secure Area");

    }


}

