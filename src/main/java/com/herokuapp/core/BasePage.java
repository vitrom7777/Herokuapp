package com.herokuapp.core;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    public static SoftAssertions softly;
    public static Actions actions;
    public static JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        softly = new SoftAssertions();
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;

    }

    public void click(WebElement element) {
        getWait(5).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.click();
            element.sendKeys(text);
        }
    }

    public boolean isAlertPresent(int time) {
        Alert alert = getWait(time)
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert().accept();
            return true;
        }
    }

    public WebDriverWait getWait(int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time));
    }

    public boolean isContainsText(String text, WebElement element) {
        return element.getText().contains(text);
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {

        return getWait(time).until(ExpectedConditions
                .textToBePresentInElement(element, text));
    }

    public void verifyLinks(String url) {
        try {
            URL linkUrl = new URL(url);
            //create URL connection and get response code < 400 gut
            HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();
            int statusCode = connection.getResponseCode();
            if (statusCode >= 400) {
                // System.out.println(url+"-->"+connection.getResponseMessage()+"is a BROKEN URL");
                softly.fail(url + "-->" + connection.getResponseMessage() + " is a BROKEN URL");
            } else {
                // System.out.println(url+"-->" +connection.getResponseMessage());
                softly.assertThat(statusCode).isLessThan(400);
            }
        } catch (IOException e) {
            // System.out.println(url + "-->" + "ERROR occurred");
            softly.fail(url + "-->" + "ERROR occurred");
        }


    }
}
