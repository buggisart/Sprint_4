import PageObject.MainPage;
import PageObject.OrderPage.PersonalData;
import PageObject.OrderPage.RentData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class    CreateOrderTest {

    private WebDriver driver;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private String comment;
    // т.к. нет четких требований, что за окно должно появиться после успешного заказа, я проверил в другом браузере
    // во всплывающем окне должна быть фраза "Заказ оформлен"
    private By potentialWindowWithSuccessMessage = By.xpath(".//*[contains(text(), 'Заказ оформлен')]");

    private MainPage mainPage;
    private PersonalData personalData;
    private RentData rentData;


    public CreateOrderTest(String name, String surname, String address, String phone, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.comment = comment;
    }
    @Parameterized.Parameters
    public static Object[][] setData() {
        return new Object[][] {
                {"Иван", "Иванов", "Ленина 1, кв. 24", "+79112763899", "Комментарий"},
                {"Сидор", "Сидоров", "Пушкина 89, кв. 75", "+79112234900", "Тест"}
        };
    }
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage = new MainPage(driver);
        personalData = new PersonalData(driver);
        rentData = new RentData(driver);
    }
    //сценарий с верхней кнопкой заказа
    @Test
    public void createOrderWithTopOrderButtonSuccess() {
        mainPage.pressTheButtonCreateOrderTop();
        personalData.fillPersonalDataFields(name, surname, address, phone);
        personalData.pressTheButtonNext();
        rentData.fillTheRentDataFields(comment);
        rentData.pressCreateOrderButton();
        rentData.pressYesButtonToConfirmTheOrder();
        /*тут мы не дождемся окна с сообщением об успехе, т.к. там баг, и дальнейшая проверка Assert не пройдет и не выдаст ошибку
        но я решил оставить ожидание, как в настоящем тесте, проверяющим полный позитивный флоу, где мы все-таки ждем это окно */
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(potentialWindowWithSuccessMessage));
        String expectedMessageOfSuccess = "Заказ оформлен";
        String actualTextOfSuccessfulOrder = driver.findElement(potentialWindowWithSuccessMessage).getText();
        MatcherAssert.assertThat("Должно было появиться всплывающее окно с сообщением, содержащим фразу 'Заказ оформлен'",
                actualTextOfSuccessfulOrder, containsString(expectedMessageOfSuccess));
    }

    //сценарий с нижней кнопкой заказа
    @Test
    public void createOrderWithBottomOrderButtonSuccess() {
        mainPage.pressTheButtonCreateOrderBottom();
        personalData.fillPersonalDataFields(name, surname, address, phone);
        personalData.pressTheButtonNext();
        rentData.fillTheRentDataFields(comment);
        rentData.pressCreateOrderButton();
        rentData.pressYesButtonToConfirmTheOrder();
        /*тут мы не дождемся окна с сообщением об успехе, т.к. там баг, и дальнейшая проверка Assert не пройдет и не выдаст ошибку
        но я решил оставить ожидание, как в настоящем тесте, проверяющим полный позитивный флоу, где мы все-таки ждем это окно */
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(potentialWindowWithSuccessMessage));
        String expectedMessageOfSuccess = "Заказ оформлен";
        String actualTextOfSuccessfulOrder = driver.findElement(potentialWindowWithSuccessMessage).getText();
        MatcherAssert.assertThat("Должно было появиться всплывающее окно с сообщением, содержащим фразу 'Заказ оформлен'",
                actualTextOfSuccessfulOrder, containsString(expectedMessageOfSuccess));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
