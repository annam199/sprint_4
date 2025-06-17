package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderFirstPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // локатор поля «Имя»
    private By nameInput = By.xpath(".//input[contains(@placeholder, '* Имя')]");
    // локатор поля «Фамилия»
    private By lastNameInput = By.xpath(".//input[contains(@placeholder, '* Фамилия')]");
    // локатор поля «Адрес: куда привести самокат»
    private By addressInput = By.xpath(".//input[contains(@placeholder, '* Адрес: куда привезти заказ')]");
    // локатор поля «Станция метро»
    private By metroInput = By.xpath(".//input[contains(@placeholder, '* Станция метро')]");
    // локатор поля «Для первой станции станции метро из списка»
    private By firstStationInList = By.xpath(".//li[@data-value='1']");
    // локатор поля «Для второй станции метро из списка»
    private By secondStationInList = By.xpath(".//li[@data-value='2']");
    // локатор поля «Телефон: на него позвонит курьер»
    private By phoneInput = By.xpath(".//input[contains(@placeholder, '* Телефон: на него позвонит курьер')]");
    // локатор кнопки «Далее»
    private By nextButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");

    public OrderFirstPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public void fillName(String text) {
        driver.findElement(this.nameInput).sendKeys(text);
    }

    public void fillLastName(String text) {
        driver.findElement(this.lastNameInput).sendKeys(text);
    }

    public void fillAddress(String text) {
        driver.findElement(this.addressInput).sendKeys(text);
    }

    public void fillMetro(String station) {
        driver.findElement(this.metroInput).click();
        switch (station) {
            case "first":
                wait.until(ExpectedConditions.elementToBeClickable(firstStationInList));
                break;
            case "second":
                wait.until(ExpectedConditions.elementToBeClickable(secondStationInList));
                break;
        }
        driver.findElement(firstStationInList).click();
    }

    public void fillPhone(String text) {
        driver.findElement(this.phoneInput).sendKeys(text);
    }

    public void clickNext() {
        driver.findElement(this.nextButton).click();
    }
}