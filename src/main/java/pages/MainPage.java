package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By cookieButton = By.xpath(".//button[@id='rcc-confirm-button']");
    private By topOrderButton = By.xpath(".//div[contains(@class, 'Header_Nav')]/button[text()='Заказать']");
    private By bottomOrderButton = By.xpath(".//div[contains(@class, 'Home_FinishButton')]/button[text()='Заказать']");

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickQuestion(String question) {
        WebElement item = driver.findElement(By.xpath("//div[text()='" + question + "']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", item);
        item.click();
    }

    public WebElement getAnswerElement(String answer) {
        return driver.findElement(By.xpath("//p[text()='" + answer +"']"));
    }

    public void clickTopOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(topOrderButton));
        driver.findElement(topOrderButton).click();
    }

    public void clickBottomOrder() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(bottomOrderButton));
        wait.until(ExpectedConditions.elementToBeClickable(bottomOrderButton));
        driver.findElement(bottomOrderButton).click();
    }

    public void clickCookie() {
        driver.findElement(cookieButton).click();
    }
}