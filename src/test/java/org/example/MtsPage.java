package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MtsPage {
    final WebDriver driver;
    final WebDriverWait wait;

    public MtsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Локатор для кнопки принятия cookie
    final By cookieAcceptButton = By.id("cookie-agree");

    //Локатор для заголовка блока
    final By blockTitle = By.cssSelector(".pay__wrapper h2");

    //Локаторы для логотипов платежных систем
    final By logoContainer = By.cssSelector(".pay__partners ul");
    final By visaLogo = By.cssSelector("img[alt='Visa']");
    final By masterCardLogo = By.cssSelector("img[alt='MasterCard']");
    final By belCartLogo = By.cssSelector("img[alt='Белкарт']");

    //Локаторы для формы "Услуги связи"
    final By phoneInput = By.cssSelector("#connection-phone");
    final By sumInput = By.cssSelector("#connection-sum");
    final By emailInput = By.cssSelector("#connection-email");
    final By continueButton = By.cssSelector("#pay-connection .button__default");

    //Метод для нажатие на кнопку принятия cookie
    public void acceptCookie() {
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton));
            cookieButton.click();
        } catch (Exception e) {
            System.out.println("Всплывающее окно cookie не появилось или уже было закрыто");
        }
    }

    //Метод возвращает название блока
    public String getBlockTitle() {
        WebElement blockTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle));
        return blockTitleElement.getText().replaceAll("\n|\r\n", " ");
    }

    //Методы для логотипов платежных систем
    public boolean isVisaLogoDisplayed(){
        WebElement logosElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoContainer));
        return logosElement.findElement(visaLogo) != null;
    }

    public boolean isMastercardLogoDisplayed(){
        WebElement logosElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoContainer));
        return logosElement.findElement(masterCardLogo) != null;
    }

    public boolean isBelcartLogoDisplayed(){
        WebElement logosElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoContainer));
        return logosElement.findElement(belCartLogo) != null;
    }

    //Метод для заполнения полей формы "Услуги связи"
    public void fillPaymentForm(String phone, String sum, String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput)).sendKeys(phone);
        wait.until(ExpectedConditions.visibilityOfElementLocated(sumInput)).sendKeys(sum);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
    }

    //Метод для нажатия на кнопку "Продолжить"
    public void clickContinueButton(){
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }
}