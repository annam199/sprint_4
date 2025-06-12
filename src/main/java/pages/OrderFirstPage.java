package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderFirstPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // локатор поля «Имя»
    private By name = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    // локатор поля «Фамилия»
    private By lastname = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    // локатор поля «Адрес: куда привести самокат»
    private By address = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    // локатор поля «Станция метро»
    private By metro = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[1]/input");
    // локатор поля «Для первой станции метро из списка»
    private By firstStation = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[1]");
    // локатор поля «Для второй станции метро из списка»
    private By secondStation = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[2]");
    // локатор поля «Телефон: на него позвонит курьер»
    private By phone = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    // локатор кнопки «Далее»
    private By next = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");

    public OrderFirstPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public void fillName(String text) {
        driver.findElement(this.name).sendKeys(text);
    }

    public void fillLastName(String text) {
        driver.findElement(this.lastname).sendKeys(text);
    }

    public void fillAddress(String text) {
        driver.findElement(this.address).sendKeys(text);
    }

    public void fillMetro(String station) {
        driver.findElement(this.metro).click();
        switch (station) {
            case "first":
                wait.until(ExpectedConditions.elementToBeClickable(firstStation));
                break;
            case "second":
                wait.until(ExpectedConditions.elementToBeClickable(secondStation));
                break;
        }
        driver.findElement(firstStation).click();
    }

    public void fillPhone(String text) {
        driver.findElement(this.phone).sendKeys(text);
    }

    public void clickNext() {
        driver.findElement(this.next).click();
    }
}