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

    //Локатор для выпадающего меню
    final By dropdownButton = By.cssSelector(".select__header");

    //Локаторы для полей формы "Услуги связи"
    final By phoneInput = By.cssSelector("#connection-phone");
    final By sumInput = By.cssSelector("#connection-sum");
    final By emailInput = By.cssSelector("#connection-email");
    final By continueButton = By.cssSelector("#pay-connection .button__default");

    //Локаторы для плейсхолдеров полей варианта "Услуги связи"
    final By phoneConnectionPlaceholder = By.cssSelector("section.pay input#connection-phone");
    final By sumConnectionPlaceholder = By.cssSelector("section.pay input#connection-sum");
    final By emailConnectionPlaceholder = By.cssSelector("section.pay input#connection-email");

    //Локатор для плейсхолдеров полей варианта "Домашний интернет"
    final By internetPhonePlaceholder = By.cssSelector("section.pay input#internet-phone");
    final By internetSumPlaceholder = By.cssSelector("section.pay input#internet-sum");
    final By internetEmailPlaceholder = By.cssSelector("section.pay input#internet-email");

    //Локатор для плейсхолдеров полей варианта "Рассрочка"
    final By installmentNumberPlaceholder = By.cssSelector("section.pay input#score-instalment");
    final By installmentSumPlaceholder = By.cssSelector("section.pay input#instalment-sum");
    final By installmentEmailPlaceholder = By.cssSelector("section.pay input#instalment-email");

    //Локатор для плейсхолдеров полей варианта "Задолженность"
    final By arrearsNumberPlaceholder = By.cssSelector("section.pay input#score-arrears");
    final By arrearsSumPlaceholder = By.cssSelector("section.pay input#arrears-sum");
    final By arrearsEmailPlaceholder = By.cssSelector("section.pay input#arrears-email");

    //Метод для кнопки принятия cookie
    public void acceptCookie() {
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton));
            cookieButton.click();
        } catch (Exception e) {
            System.out.println("Всплывающее окно cookie не появилось");
        }
    }

    //Метод возвращает название блока
    public String getBlockTitle() {
        WebElement blockTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle));
        return blockTitleElement.getText().replaceAll("\n|\r\n", " ");
    }

    //Методы для логотипов платежных систем
    public boolean isVisaLogoDisplayed() {
        WebElement logosElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoContainer));
        return logosElement.findElement(visaLogo) != null;
    }

    public boolean isMastercardLogoDisplayed() {
        WebElement logosElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoContainer));
        return logosElement.findElement(masterCardLogo) != null;
    }

    public boolean isBelcartLogoDisplayed() {
        WebElement logosElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoContainer));
        return logosElement.findElement(belCartLogo) != null;
    }

    //Метод для открытия выпадающего меню
    public void openDropdown(){
        wait.until(ExpectedConditions.elementToBeClickable(dropdownButton)).click();
    }

    //Метод выбора варианта оплаты услуг
    public void selectServiceOption(String optionText){
        By optionLocator = By.xpath("//p[text()='" + optionText + "']");
        wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();
    }

    //Методы для возврата текста плейсхолдеров
    public String getConnectionPhonePlaceholderText(){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneConnectionPlaceholder)).getAttribute("placeholder");
    }

    public String getConnectionSumPlaceholderText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sumConnectionPlaceholder)).getAttribute("placeholder");
    }

    public String getConnectionEmailPlaceholderText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailConnectionPlaceholder)).getAttribute("placeholder");
    }

    public String getInternetPhonePlaceholderText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(internetPhonePlaceholder)).getAttribute("placeholder");
    }

    public String getInternetSumPlaceholderText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(internetSumPlaceholder)).getAttribute("placeholder");
    }

    public String getInternetEmailPlaceholderText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(internetEmailPlaceholder)).getAttribute("placeholder");
    }

    public String getInstallmentNumberPlaceholderText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(installmentNumberPlaceholder)).getAttribute("placeholder");
    }

    public String getInstallmentSumPlaceholderText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(installmentSumPlaceholder)).getAttribute("placeholder");
    }

    public String getInstallmentEmailPlaceholderText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(installmentEmailPlaceholder)).getAttribute("placeholder");
    }

    public String getArrearsNumberPlaceholderText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(arrearsNumberPlaceholder)).getAttribute("placeholder");
    }

    public String getArrearsSumPlaceholderText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(arrearsSumPlaceholder)).getAttribute("placeholder");
    }

    public String getArrearsEmailPlaceholderText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(arrearsEmailPlaceholder)).getAttribute("placeholder");
    }

    //Метод для заполнения полей формы "Услуги связи"
    public void fillPaymentForm(String phone, String sum, String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput)).sendKeys(phone);
        wait.until(ExpectedConditions.visibilityOfElementLocated(sumInput)).sendKeys(sum);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
    }

    //Метод для нажатия на кнопку "Продолжить"
    public void clickContinueButton() {

        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }
}




