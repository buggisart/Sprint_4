package PageObject.OrderPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalData {
    private final WebDriver driver;

    public PersonalData(WebDriver driver) {
        this.driver = driver;
    }

    // поле ввода "Имя"
    private static final By FIELD_NAME =
            By.xpath(".//input[@placeholder='* Имя']");
    // поле ввода "Фамилия"
    private static final By FIELND_SURNAME =
            By.xpath(".//input[@placeholder='* Фамилия']");
    // поле ввода "Адрес"
    private static final By FIELD_ADRESS =
            By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // поле "Метро"
    private static final By FIELD_METRO_STATION =
            By.xpath(".//input[@placeholder='* Станция метро']");
    // поле ввода "Телефон"
    private static final By FIELD_PHONE =
            By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // конпка "Далее"
    public static final By BUTTON_NEXT =
            By.xpath(".//div[@class ='Order_NextButton__1_rCA']/button");
    // любая станция метро из выпадающего списка метро
    private static final By ANY_METRO_STATION = By.xpath(".//div[@class='select-search__select']/*");

    public void chooseMetroStation() {
        driver.findElement(FIELD_METRO_STATION).click();
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(ANY_METRO_STATION));
        driver.findElement(ANY_METRO_STATION).click();


    }

    public void fillPersonalDataFields(String name, String surname, String address, String phone) {
        driver.findElement(FIELD_NAME).sendKeys(name);
        driver.findElement(FIELND_SURNAME).sendKeys(surname);
        driver.findElement(FIELD_ADRESS).sendKeys(address);
        chooseMetroStation();
        driver.findElement(FIELD_PHONE).sendKeys(phone);
    }
    public void pressTheButtonNext() {
        driver.findElement(BUTTON_NEXT).click();
    }

}
