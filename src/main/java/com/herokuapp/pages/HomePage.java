package com.herokuapp.pages;


import com.herokuapp.core.BasePage;
import com.herokuapp.pages.availableExamples.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='/login']")
    WebElement login;

    public LoginPage getFormAuthenfication() {
        click(login);
        return new LoginPage(driver);
    }

    @FindBy(css = "a[href='/javascript_alerts']")
    WebElement script_alerts;

    public AlertsPage getJavaScriptAlerts() {
        click(script_alerts);
        return new AlertsPage(driver);
    }

    @FindBy(css = "a[href='/dropdown']")
    WebElement dropdown;

    public DropdownPage getDropdown() {
        click(dropdown);
        return new DropdownPage(driver);
    }

    @FindBy(css = "a[href='/frames']")
    WebElement nestedFrames;


    public FramesPage getFrames() {
        click(nestedFrames);
        return new FramesPage(driver);
    }

    @FindBy(css = "a[href='/horizontal_slider']")
    WebElement slider;

    public SliderPage getHorizontalSlider() {
        click(slider);
        return new SliderPage(driver);
    }


    @FindBy(css = "a[href='/drag_and_drop']")
    WebElement dragAndDrop;

    public DragAndDropPage getDragAndDropPage() {
        click(dragAndDrop);
        return new DragAndDropPage(driver);
    }

    @FindBy(css = "a[href='/context_menu']")
    WebElement contextMenu;

    public ContextMenuPage getContextMenu() {
        click(contextMenu);
        return new ContextMenuPage(driver);
    }
    @FindBy(css = "a[href='/upload']")
    WebElement uploadMenu;
    public UploadPage getUpload() {
        click(uploadMenu);
        return new UploadPage(driver);
    }
}
