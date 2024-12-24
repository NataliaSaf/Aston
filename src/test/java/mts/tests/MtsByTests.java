package mts.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsByTests {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static MtsPage mtsPage;
    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by");
        mtsPage = new MtsPage(driver);
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
        By moreServiceLink = By.xpath("//a[text()='Подробнее о сервисе']");
        WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(moreServiceLink));
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        linkElement.click();

        String currentUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, currentUrl, "URL после нажатия на ссылку не соответствует ожидаемому URL");
    }

    @Test
    @DisplayName("Проверка работы кнопки 'Продолжить'")
    public void testPaymentForm(){
        String phoneNumber = "297777777";
        String amount = "50";
        String email1 = "test@mail.ru";

        mtsPage.fillPaymentForm(phoneNumber, amount,email1);
        mtsPage.clickContinueButton();
    }

    @AfterEach
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
