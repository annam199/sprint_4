package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderSecondPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // локатор поля «Когда привезти самокат»
    private By dataInput = By.xpath(".//input[contains(@placeholder, '* Когда привезти самокат')]");
    // локатор поля «Для первой даты из списка»
    private By monday = By.xpath("//div[contains(@class, 'react-datepicker__week')]/div[contains(@class,'react-datepicker__day')][1]");
    // локатор поля «Для второй даты из списка»
    private By tuesday = By.xpath("//div[contains(@class, 'react-datepicker__week')]/div[contains(@class,'react-datepicker__day')][2]");
    // локатор поля «Срок аренды»
    private By term = By.xpath(".//div[text()='* Срок аренды']");
    // локатор поля «Для первого варианта срока аренды из списка»
    private By dayTerm = By.xpath("//div[text()='сутки']");
    // локатор поля «Для второго варианта срока аренды из списка»
    private By twoDaysTerm = By.xpath("//div[text()='двое суток']");
    // локатор поля «Для первого цвета из списка»
    private By blackColorLabel = By.xpath("//label[text()='чёрный жемчуг']");
    // локатор поля «Для второго цвета из списка»
    private By greyColorLabel = By.xpath("//label[text()='серая безысходность']");
    // локатор поля «Комментарий для курьера»
    private By commentInput = By.xpath(".//input[contains(@placeholder, 'Комментарий для курьера')]");
    // локатор кнопки «Заказать»
    private By orderButton = By.xpath("//div[contains(@class, 'Order_Buttons')]/button[text()='Заказать']");
    // кнопка подтверждения заказа
    private By finishOrderButton = By.xpath("//button[text()='Да']");
    // текст в модальном окне при успешном подтверждении заказа
    private By orderComplete = By.xpath("//div[text()='Заказ оформлен']");

    public OrderSecondPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getOrderComplete() {
        return driver.findElement(orderComplete);
    }

    public void finishOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(finishOrderButton));
        driver.findElement(finishOrderButton).click();
    }

    public void data(String data) {
        driver.findElement(this.dataInput).click();
        switch (data) {
            case "first":
                wait.until(ExpectedConditions.elementToBeClickable(monday));
                driver.findElement(monday).click();
                break;
            case "second":
                wait.until(ExpectedConditions.elementToBeClickable(tuesday));
                driver.findElement(tuesday).click();
                break;
        }
    }

    public void term(String term) {
        driver.findElement(this.term).click();
        switch (term) {
            case "first":
                wait.until(ExpectedConditions.elementToBeClickable(dayTerm));
                driver.findElement(dayTerm).click();
                break;
            case "second":
                wait.until(ExpectedConditions.elementToBeClickable(twoDaysTerm));
                driver.findElement(twoDaysTerm).click();
                break;
        }
    }

    public void color(String color) {
        switch (color) {
            case "first":
                wait.until(ExpectedConditions.elementToBeClickable(blackColorLabel));
                driver.findElement(blackColorLabel).click();
                break;
            case "second":
                wait.until(ExpectedConditions.elementToBeClickable(greyColorLabel));
                driver.findElement(greyColorLabel).click();
                break;
        }
    }

    public void comment(String text) {
        driver.findElement(this.commentInput).sendKeys(text);
    }

    public void clickOrder() {
        driver.findElement(this.orderButton).click();
    }
}