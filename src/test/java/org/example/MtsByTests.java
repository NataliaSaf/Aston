package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MtsByTests {

    private WebDriver driver;
    private MtsPage mtsPage;
    private PaymentPage paymentPage;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by");

        mtsPage = new MtsPage(driver);
        paymentPage = new PaymentPage(driver);


        mtsPage.acceptCookie();
    }

    @Test
    @DisplayName("Проверка названия блока")
    public void testCheckBlockTitle(){
        String actualBlockTitle = mtsPage.getBlockTitle();
        String expectedBlockTitle = "Онлайн пополнение без комиссии";
        assertEquals(expectedBlockTitle, actualBlockTitle, "Название блока не совпадает");
    }

    @Test
    @DisplayName("Проверка наличия логотипов платежных систем")
    public void testPaymentSystemLogos(){
        assertTrue(mtsPage.isVisaLogoDisplayed(), "Логотип Visa не найден");
        assertTrue(mtsPage.isMastercardLogoDisplayed(), "Логотип MasterCard не найден");
        assertTrue(mtsPage.isBelcartLogoDisplayed(), "Логотип Белкарт не найден");
    }

    @Test
    @DisplayName("Проверка работы ссылки 'Подробнее о сервисе'")
    public void testMoreServiceLink(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By moreServiceLink = By.xpath("//a[text()='Подробнее о сервисе']");
        WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(moreServiceLink));
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        linkElement.click();

        String currentUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, currentUrl, "URL после нажатия на ссылку не соответствует ожидаемому URL");
    }

    @Test
    @DisplayName("Проверка плейсхолдеров формы оплаты 'Услуги связи'")
    public void testCheckConnectionPlaceholders(){
        mtsPage.openDropdown();
        mtsPage.selectServiceOption("Услуги связи");

        assertEquals("Номер телефона", mtsPage.getConnectionPhonePlaceholderText(), "Плейсхолдер не верен");
        assertEquals("Сумма", mtsPage.getConnectionSumPlaceholderText(), "Плейсхолдер не верен");
        assertEquals("E-mail для отправки чека", mtsPage.getConnectionEmailPlaceholderText(), "Плейсхолдер не верен");
    }

    @Test
    @DisplayName("Проверка плейсхолдеров формы оплаты 'Домашний интернет'")
    public void testCheckInternetPlaceholders(){
        mtsPage.openDropdown();
        mtsPage.selectServiceOption("Домашний интернет");

        assertEquals("Номер абонента", mtsPage.getInternetPhonePlaceholderText(), "Плейсхолдер не верен");
        assertEquals("Сумма", mtsPage.getInternetSumPlaceholderText(), "Плейсхолдер не верен");
        assertEquals("E-mail для отправки чека", mtsPage.getInternetEmailPlaceholderText(), "Плейсхолдер не верен");
    }

    @Test
    @DisplayName("Проверка плейсхолдеров формы оплаты 'Рассрочка'")
    public void testCheckInstalmentPlaceholders(){
        mtsPage.openDropdown();
        mtsPage.selectServiceOption("Рассрочка");

        assertEquals("Номер счета на 44", mtsPage.getInstallmentNumberPlaceholderText(), "Плейсхолдер не верен");
        assertEquals("Сумма", mtsPage.getInstallmentSumPlaceholderText(), "Плейсхолдер не верен");
        assertEquals("E-mail для отправки чека", mtsPage.getInstallmentEmailPlaceholderText(), "Плейсхолдер не верен");
    }

    @Test
    @DisplayName("Проверка плейсхолдеров формы оплаты 'Задолженность'")
    public void testCheckArrearsPlaceholders(){
        mtsPage.openDropdown();
        mtsPage.selectServiceOption("Задолженность");

        assertEquals("Номер счета на 2073", mtsPage.getArrearsNumberPlaceholderText(), "Плейсхолдер не верен");
        assertEquals("Сумма", mtsPage.getArrearsSumPlaceholderText(), "Плейсхолдер не верен");
        assertEquals("E-mail для отправки чека", mtsPage.getArrearsEmailPlaceholderText(), "Плейсхолдер не верен");
    }

    @Test
    @DisplayName("Проверка корректности отображения информации в окне оплаты")
    public void testPaymentForm() {
        String phoneNumber = "297777777";
        String summa = "50.00";
        String email = "test@mail.ru";

        fillAndContinuePayForm(phoneNumber, summa, email);

        paymentPage.switchToPayFrame();

        assertEquals(formatSumma(summa), paymentPage.getDisplayedCost(), "Сумма отображается неверно");
        assertEquals(formatPhoneNumber(phoneNumber), paymentPage.getDisplayedPhone(), "Номер телефона отображается неверно");
        assertTrue(paymentPage.getDisplayedButton().contains(summa), "Сумма на кнопке 'Оплатить' отображается неверно");

        assertEquals("Номер карты", paymentPage.getPayNumberCardPlaceholderText(), "Плейсхолдер не верен");
        assertEquals("Срок действия", paymentPage.getPayExpirationDatePlaceholderText(), "Плейсхолдер не верен");
        assertEquals("CVC", paymentPage.getPayCvcPlaceholderText(), "Плейсхолдер не верен");
        assertEquals("Имя держателя (как на карте)", paymentPage.getPayСardHolderPlaceholderText(), "Плейсхолдер не верен");

        assertTrue(paymentPage.isPayFrameIconsDisplayed(), "Иконки платежных систем не найдены");

    }

    @AfterEach
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }

    }

    //Метод для заполнения полей формы оплаты и нажатия на кнопку "Продолжить"
    public void fillAndContinuePayForm(String phoneNumber, String summa, String email){
        mtsPage.fillPaymentForm(phoneNumber, summa, email );
        mtsPage.clickContinueButton();
    }
    //Формат отображения номера телефона в окне подтверждения оплаты
    private String formatPhoneNumber(String phoneNumber){
        return "Оплата: Услуги связи Номер:375" + phoneNumber;
    }

    //Формат отображения суммы в окне подтверждения оплаты
    private String formatSumma(String summa){
        if (!summa.contains(".")) {
            summa += ".00";
        }
        return summa + " BYN";
    }
}
