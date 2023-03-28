package PageObject;

import PageObject.OrderPage.PersonalData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // кнопка "заказать" вверху страницы
    private static final By CREATE_ORDER_BUTTON_TOP =
            By.xpath(".//div[@class = 'Header_Nav__AGCXC']/button[@class = 'Button_Button__ra12g']");
    // кнопка "заказать" внизу страницы
    private static final By CREATE_ORDER_BUTTON_BOTTOM =
            By.xpath(".//div[@class='Home_FinishButton__1_cWm']/Button");
    // вопрос "Сколько это стоит? И как оплатить?"
    private static final By HOW_MUCH_IT_COSTS_QUESTION = By.id("accordion__heading-0");
    // ответ на "Сколько это стоит? И как оплатить?"
    private static final By HOW_MUCH_IT_COSTS_ANSWER = By.xpath(".//div[@id='accordion__panel-0']");
    // вопрос "Хочу сразу несколько самокатов! Так можно?"
    private static final By WANT_A_FEW_SCOOTERS_QUESTION =
            By.id("accordion__heading-1");
    // ответ на "Хочу сразу несколько самокатов! Так можно?"
    private static final By WANT_A_FEW_SCOOTERS_ANSWER =
            By.xpath(".//div[@id = 'accordion__panel-1']/p");
    // вопрос "Как рассчитывается время аренды?"
    private static final By HOW_RENT_TIME_COUNTS_QUESTION =
            By.id("accordion__heading-2");
    // ответ на "Как рассчитывается время аренды?"
    private static final By HOW_RENT_TIME_COUNTS_ANSWER =
            By.xpath(".//div[@id = 'accordion__panel-2']/p");
    // вопрос "Можно ли заказать самокат прямо на сегодня?"
    private static final By IS_IT_POSSIBLE_TO_RENT_TODAY_QUESTION =
            By.id("accordion__heading-3");
    // ответ на "Можно ли заказать самокат прямо на сегодня?"
    private static final By IS_IT_POSSIBLE_TO_RENT_TODAY_ANSWER =
            By.xpath(".//div[@id = 'accordion__panel-3']/p");
    // вопрос "Можно ли продлить заказ или вернуть самокат раньше?"
    private static final By IS_IT_POSSIBLE_TO_EXTEND_THE_RENT_QUESTION =
            By.id("accordion__heading-4");
    // ответ на "Можно ли продлить заказ или вернуть самокат раньше?"
    private static final By IS_IT_POSSIBLE_TO_EXTEND_THE_RENT_ANSWER =
            By.xpath(".//div[@id = 'accordion__panel-4']/p");
    // вопрос "Вы привозите зарядку вместе с самокатом?"
    private static final By IS_CHARGER_INCLUDE_QUESTION =
            By.id("accordion__heading-5");
    // ответ на "Вы привозите зарядку вместе с самокатом?"
    private static final By IS_CHARGER_INCLUDE_ANSWER =
            By.xpath(".//div[@id = 'accordion__panel-5']/p");
    // вопрос "Можно ли отменить заказ?"
    private static final By IS_IT_POSSIBLE_TO_CANCEL_THE_ORDER_QUESTION =
            By.id("accordion__heading-6");
    // ответ на "Можно ли отменить заказ?"
    private static final By IS_IT_POSSIBLE_TO_CANCEL_THE_ORDER_ANSWER =
            By.xpath(".//div[@id = 'accordion__panel-6']/p");
    // вопрос "Я живу за МКАДом, привезёте?"
    private static final By IS_IT_POSSIBLE_TO_ORDER_OUTSIDE_OF_MKAD_QUESTION =
            By.id("accordion__heading-7");
    // ответ на "Я живу за МКАДом, привезёте?"
    private static final By IS_IT_POSSIBLE_TO_ORDER_OUTSIDE_OF_MKAD_ANSWER =
            By.xpath(".//div[@id = 'accordion__panel-7']/p");
    public String checkHowMuchItCostsAnswer() {
        WebElement element = driver.findElement(HOW_MUCH_IT_COSTS_QUESTION);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        WebElement elementWait = new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.visibilityOfElementLocated(HOW_MUCH_IT_COSTS_ANSWER));
        return elementWait.getText();
    }
    public String checkPossibilityToRentFewScootersAnswer() {
        WebElement element = driver.findElement(WANT_A_FEW_SCOOTERS_QUESTION);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        WebElement elementWait = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(WANT_A_FEW_SCOOTERS_ANSWER));
        return elementWait.getText();
    }
    public String checkHowRentTimeCountsAnswer() {
        WebElement element = driver.findElement(HOW_RENT_TIME_COUNTS_QUESTION);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        WebElement elementWait = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(HOW_RENT_TIME_COUNTS_ANSWER));
        return elementWait.getText();
    }
    public String checkPossibilityToRentTodayAnswer() {
        WebElement element = driver.findElement(IS_IT_POSSIBLE_TO_RENT_TODAY_QUESTION);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        WebElement elementWait = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(IS_IT_POSSIBLE_TO_RENT_TODAY_ANSWER));
        return elementWait.getText();
    }
    public String checkPossibilityToExtendTheRentAnswer() {
        WebElement element = driver.findElement(IS_IT_POSSIBLE_TO_EXTEND_THE_RENT_QUESTION);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        WebElement elementWait = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(IS_IT_POSSIBLE_TO_EXTEND_THE_RENT_ANSWER));
        return elementWait.getText();
    }
    public String checkIfChargerIncludeAnswer() {
        WebElement element = driver.findElement(IS_CHARGER_INCLUDE_QUESTION);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        WebElement elementWait = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(IS_CHARGER_INCLUDE_ANSWER));
        return elementWait.getText();
    }
    public String checkPossibilityToCancelTheOrderAnswer() {
        WebElement element = driver.findElement(IS_IT_POSSIBLE_TO_CANCEL_THE_ORDER_QUESTION);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        WebElement elementWait = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(IS_IT_POSSIBLE_TO_CANCEL_THE_ORDER_ANSWER));
        return elementWait.getText();
    }
    public String checkPossibilityToOrderOutsideOfMKADAnswer() {
        WebElement element = driver.findElement(IS_IT_POSSIBLE_TO_ORDER_OUTSIDE_OF_MKAD_QUESTION);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        WebElement elementWait = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(IS_IT_POSSIBLE_TO_ORDER_OUTSIDE_OF_MKAD_ANSWER));
        return elementWait.getText();
    }
    public void pressTheButtonCreateOrderTop() {
        driver.findElement(CREATE_ORDER_BUTTON_TOP).click();
        WebElement elementWait = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(PersonalData.BUTTON_NEXT));
    }

    public void pressTheButtonCreateOrderBottom() {
        WebElement element = driver.findElement(IS_IT_POSSIBLE_TO_CANCEL_THE_ORDER_QUESTION);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(CREATE_ORDER_BUTTON_BOTTOM).click();
        WebElement elementWait = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(PersonalData.BUTTON_NEXT));
    }
}
