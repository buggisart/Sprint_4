import PageObject.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import static org.junit.Assert.assertEquals;

public class ImportantQuestionsTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.get("https://qa-scooter.praktikum-services.ru/");
    }
    @Test
    public void checkHowMuchItCostsAnswerCorrect() {
        MainPage mainPage = new MainPage(driver);
        String actualTextOfTheAnswer = mainPage.checkHowMuchItCostsAnswer();
        String expectedAnswer = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        assertEquals(expectedAnswer, actualTextOfTheAnswer);
    }
    @Test
    public void checkPossibilityToRentFewScootersAnswerCorrect() {
        MainPage mainPage = new MainPage(driver);
        String actualTextOfTheAnswer = mainPage.checkPossibilityToRentFewScootersAnswer();
        String expectedAnswer =
                "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        assertEquals(expectedAnswer, actualTextOfTheAnswer);
    }
    @Test
    public void checkHowRentTimeCountsAnswerCorrect() {
        MainPage mainPage = new MainPage(driver);
        String actualTextOfTheAnswer = mainPage.checkHowRentTimeCountsAnswer();
        String expectedAnswer =
                "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        assertEquals(expectedAnswer, actualTextOfTheAnswer);
    }
    @Test
    public void checkPossibilityToRentTodayAnswerCorrect() {
        MainPage mainPage = new MainPage(driver);
        String actualTextOfTheAnswer = mainPage.checkPossibilityToRentTodayAnswer();
        String expectedAnswer = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        assertEquals(expectedAnswer, actualTextOfTheAnswer);
    }
    @Test
    public void checkPossibilityToExtendTheRentAnswerCorrect() {
        MainPage mainPage = new MainPage(driver);
        String actualTextOfTheAnswer = mainPage.checkPossibilityToExtendTheRentAnswer();
        String expectedAnswer =
                "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        assertEquals(expectedAnswer, actualTextOfTheAnswer);
    }
    @Test
    public void checkIfChargerIncludeAnswerCorrect() {
        MainPage mainPage = new MainPage(driver);
        String actualTextOfTheAnswer = mainPage.checkIfChargerIncludeAnswer();
        String expectedAnswer =
                "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        assertEquals(expectedAnswer, actualTextOfTheAnswer);
    }
    @Test
    public void checkPossibilityToCancelTheOrderAnswerCorrect() {
        MainPage mainPage = new MainPage(driver);
        String actualTextOfTheAnswer = mainPage.checkPossibilityToCancelTheOrderAnswer();
        String expectedAnswer =
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        assertEquals(expectedAnswer, actualTextOfTheAnswer);
    }
    @Test
    public void checkPossibilityToOrderOutsideOfMKADAnswerCorrect() {
        MainPage mainPage = new MainPage(driver);
        String actualTextOfTheAnswer = mainPage.checkPossibilityToOrderOutsideOfMKADAnswer();
        String expectedAnswer =
                "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        assertEquals(expectedAnswer, actualTextOfTheAnswer);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
