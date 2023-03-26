package PageObject.OrderPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RentData {

    private final WebDriver driver;

    public RentData(WebDriver driver) {
        this.driver = driver;
    }
    // кнопка "Заказать"
    private static final By CREATE_ORDER_BUTTON =
            By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text() = 'Заказать']");
    // поле ввода "* Когда привезти самокат"
    private static final By DATE_OF_THE_ORDER_FIELD =
            By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // поле "* Срок аренды"
    private static final By DURATION_OF_RENT_FIELD = By.className("Dropdown-placeholder");
    // элемент "Сутки" из выпадающего списка Срока аренды
    private static final By ONE_DAY_RENT = By.xpath(".//div[text() = 'сутки']");
    // чекбокс "чёрный жемчуг"
    private static final By COLOR_BLACK_CHECKBOX = By.xpath(".//label[text() = 'чёрный жемчуг']");
    // полле ввода "Комментарий для курьера"
    private static final By COMMENT_FIELD = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // кнопка следующего месяца из выпадаюшего календаря
    private static final By NEXT_MONTH_BUTTON = By.xpath(".//button[text() = 'Next Month']");
    // любой день следующего месяца из выпадаюшего календаря
    private static final By ANY_DAY_NEXT_MONTH = By.xpath(".//div[@class='react-datepicker__week']/*");
    // кнопка подтверждения заказа "Да" в всплывающем окне
    private static final By YES_BUTTON =
            By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    public void chooseRentDurationForOneDay() {
        driver.findElement(DURATION_OF_RENT_FIELD).click();
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(ONE_DAY_RENT));
        driver.findElement(ONE_DAY_RENT).click();
    }
    public void chooseTheDateOfRent() {
        driver.findElement(DATE_OF_THE_ORDER_FIELD).click();
        WebElement buttonOfNextMonth = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(NEXT_MONTH_BUTTON));
        buttonOfNextMonth.click();
        WebElement buttonOfTheDay = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(ANY_DAY_NEXT_MONTH));
        buttonOfTheDay.click();
    }
    public void fillTheRentDataFields(String comment) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(DATE_OF_THE_ORDER_FIELD));
        chooseTheDateOfRent();
        chooseRentDurationForOneDay();
        driver.findElement(COLOR_BLACK_CHECKBOX).click();
        driver.findElement(COMMENT_FIELD).sendKeys(comment);
    }
    public void pressCreateOrderButton() {
        driver.findElement(CREATE_ORDER_BUTTON).click();
    }
    public void pressYesButtonToConfirmTheOrder() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(YES_BUTTON));
        element.click();
    }

}
