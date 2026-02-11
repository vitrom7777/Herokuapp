package com.herokuapp.utils;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MyListener implements WebDriverListener {

    Logger logger = LoggerFactory.getLogger(MyListener.class);

    private final WebDriver driver;
    // Статический счетчик шагов
    private static final AtomicInteger stepCount = new AtomicInteger(1);

    public MyListener(WebDriver driver) {
        this.driver = driver;
    }
    // Вспомогательный метод для форматирования шага
    private String stepInfo() {
        return "Step #" + stepCount.getAndIncrement() + " | ";
    }
    public static void resetStepCount() {
        stepCount.set(1);}

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        logger.error("The test has a problem !!!");
        logger.error("=========================================");
        logger.error("Method --> {}", method.getName());
        logger.error("=========================================");
        //logger.error("Target exception --> {}", e.getTargetException());
        logger.error("❌ Error in step #{}: {}", stepCount.get(), e.getTargetException().getMessage());
        logger.error("*****************************************");
        int i = new Random().nextInt(1000);
        String link = "screenshots/screen_" + i + ".png";
        logger.error("Screen with error --> " + link);
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp, new File(link));
        } catch (IOException ex) {
            logger.error(" Failed to save screenshot ", ex);
        }
    }

//    @Override
//    public void afterGet(WebDriver driver, String url) {
//        logger.info("We opened the site {}", url);
//    }

//    @Override
//    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
//        logger.info("We enter {} to element{}", keysToSend, element);
//        logger.info("==================================================");
//    }

//    @Override
//    public void afterGetText(WebElement element, String result) {
//        logger.info(" {} contains {}",element,result);
//        logger.info("==================================================");
//    }

    @Override
    public void afterPerform(WebDriver driver, Collection<Sequence> actions) {
        logger.info(" {}", actions);
        logger.info("==================================================");
    }

//    @Override
//    public void afterClick(WebElement element) {
//        logger.info("We clicked on {}", element);
//        logger.info("==================================================");
//    }

    ///   new
    @Override
    public void afterGet(WebDriver driver, String url) {
        logger.info("__________________________________________________________");
        logger.info("{}🌐 We opened the site {}", stepInfo(), url);
    }
    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        logger.info("{}⌨️ We enter : [{}] to element {}", stepInfo(), keysToSend, element);
        logger.info("----------------------------------------------------------");
    }
    @Override
    public void afterClick(WebElement element) {
        logger.info("{}🖱️ We clicked on: {}", stepInfo(), element);
        logger.info("----------------------------------------------------------");
    }
    @Override
    public void afterGetText(WebElement element, String result) {
        logger.info("{}📖 Contains: [{}]", stepInfo(), result);
        logger.info("----------------------------------------------------------");
    }

}
