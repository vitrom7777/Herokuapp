package com.herokuapp.core;

import com.herokuapp.utils.MyListener;
import com.herokuapp.utils.MyTestWatcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(MyTestWatcher.class)
public class TestBase {

    protected WebDriver driver;
    protected ApplicationManger app = new ApplicationManger
        (System.getProperty("browser","chrome"));  // default browser

    @BeforeEach
    public void init() {
        driver = app.start();
        MyListener.resetStepCount();
    }


    @AfterEach
    public void tearDown() {
       app.stop();
    }

}