package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderSecondPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // локатор поля «Когда привезти самокат»
    private By data = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div/input");
    // локатор поля «Для первой даты из списка»
    private By firstData = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[2]");
    // локатор поля «Для второй даты из списка»
    private By secondData = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[4]");
    // локатор поля «Для третьей даты из списка»
    private By thirdData = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[6]");
    // локатор поля «Для четвертой даты из списка»
    private By fourthData = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[7]");
    // локатор поля «Срок аренды»
    private By term = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]");
    // локатор поля «Для первого варианта срока аренды из списка»
    private By firstTerm = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]");
    // локатор поля «Для второго варианта срока аренды из списка»
    private By secondTerm = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[2]");
    // локатор поля «Для третьего варианта срока аренды из списка»
    private By thirdTerm = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[4]");
    // локатор поля «Для четвертого варианта срока аренды из списка»
    private By fourthTerm = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[5]");
    // локатор поля «Цвет самоката»
    private By color = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/div");
    // локатор поля «Для первого цвета из списка»
    private By firstColor = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/div");
    // локатор поля «Для второго цвета из списка»
    private By secondColor = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/div");
    // локатор поля «Комментарий для курьера»
    private By comment = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");
    // локатор кнопки «Заказать»
    private By orderButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");
    public OrderSecondPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void data(String data) {
        driver.findElement(this.data).click();
        switch (data) {
            case "first":
                wait.until(ExpectedConditions.elementToBeClickable(firstData));
                driver.findElement(firstData).click();
                break;
            case "second":
                wait.until(ExpectedConditions.elementToBeClickable(secondData));
                driver.findElement(secondData).click();
                break;
            case "third":
                wait.until(ExpectedConditions.elementToBeClickable(thirdData));
                driver.findElement(thirdData).click();
                break;
            case "fourth":
                wait.until(ExpectedConditions.elementToBeClickable(fourthData));
                driver.findElement(fourthData).click();
                break;
        }
    }

    public void term(String term) {
        driver.findElement(this.term).click();
        switch (term) {
            case "first":
                wait.until(ExpectedConditions.elementToBeClickable(firstTerm));
                driver.findElement(firstTerm).click();
                break;
            case "second":
                wait.until(ExpectedConditions.elementToBeClickable(secondTerm));
                driver.findElement(secondTerm).click();
                break;
            case "third":
                wait.until(ExpectedConditions.elementToBeClickable(thirdTerm));
                driver.findElement(thirdTerm).click();
                break;
            case "fourth":
                wait.until(ExpectedConditions.elementToBeClickable(fourthTerm));
                driver.findElement(fourthTerm).click();
                break;
        }
    }

    public void color(String color) {
        driver.findElement(this.color).click();
        switch (color) {
            case "first":
                wait.until(ExpectedConditions.elementToBeClickable(firstColor));
                driver.findElement(firstColor).click();
                break;
            case "second":
                wait.until(ExpectedConditions.elementToBeClickable(secondColor));
                driver.findElement(secondColor).click();
                break;
        }
    }

    public void comment(String text) {
        driver.findElement(this.comment).sendKeys(text);
    }

    public void clickOrder() {
        driver.findElement(this.orderButton).click();
    }
}