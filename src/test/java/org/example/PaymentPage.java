package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage {
    final WebDriver driver;
    final WebDriverWait wait;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    //Локатор для iframe оплаты
    final By payFrame = By.xpath("//iframe[@class='bepaid-iframe']");

    //Локатор для суммы в описании оплаты
    final By payFrameDescriptionCost = By.cssSelector("div.pay-description__cost span");

    //Локатор для суммы на кнопке "Оплатить"
    final By payFrameButton = By.cssSelector("div.card-page__card button");

    //Локатор для номера телефона в описании оплаты
    final By payFrameDescriptionPhone = By.cssSelector("div.pay-description__text span");

    //Локатор для плейсхолдера в поле ввода номера карты
    final By numberCardPlaсeholder = By.cssSelector("input[formcontrolname=creditCard] + label");

    //Локатор для плейсхолдера в поле ввода срока действия карты
    final By expirationDatePlaceholder = By.cssSelector("input[formcontrolname=expirationDate] + label");

    //Локатор для плейсхолдера в поле ввода CVC
    final By cvcPlaceholder = By.cssSelector("input[formcontrolname=cvc] + label");

    //Локатор для плейсхолдера в поле ввода имени держателя карты
    final By cardHolderPlaceholder = By.cssSelector("input[formcontrolname=holder] + label");

    //Локатор для иконок платежных систем
    final By payFrameIcons = By.cssSelector("div.cards-brands img");

    //Метод для переключения фокуса на окно оплаты
    public void switchToPayFrame(){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(payFrame));
    }

    //Метод возвращает текст суммы в описании оплаты
    public String getDisplayedCost() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(payFrameDescriptionCost)).getText();
    }

    //Метод возвращает текст кнопки "Оплатить"
    public String getDisplayedButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(payFrameButton)).getText();
    }
    //Метод возвращает текст номера телефона в описании оплаты
    public String getDisplayedPhone() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(payFrameDescriptionPhone)).getText();
    }

    //Метод возвращает текст плейсхолдера поля "Номер карты"
    public String getPayNumberCardPlaceholderText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(numberCardPlaсeholder)).getText();
    }

    //Метод возвращает текст плейсхолдера поля "Срок действия"
    public String getPayExpirationDatePlaceholderText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(expirationDatePlaceholder)).getText();
    }

    //Метод возвращает текст плейсхолдера поля "cvc"
    public String getPayCvcPlaceholderText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cvcPlaceholder)).getText();
    }

    //Метод возвращает текст плейсхолдера поля "Имя держателя"
    public String getPayСardHolderPlaceholderText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardHolderPlaceholder)).getText();
    }

    //Метод для отображения иконок платежных систем
    public boolean isPayFrameIconsDisplayed(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(payFrameIcons)).isDisplayed();
    }
}



