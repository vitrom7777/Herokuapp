package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.availableExamples.MultipleWindowsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WindowTest extends TestBase {
    MultipleWindowsPage windowspage;

    @BeforeEach
    public void precondition() {
     //   new HomePage(driver).getJavaScriptAlerts();
       windowspage = new MultipleWindowsPage(driver);
    }
    @Test
    public void newTabTest(){
        windowspage.clickHereButton()
                .clickHereButton2()
       //new MultipleWindowsPage(driver).clickHereButton()
                .switchToNewTab(1)
               .verifyNewTabTitle("New Window");
               // .verifyNewTabTitle("Opening a new window");
    }
}

