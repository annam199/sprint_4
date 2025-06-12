package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    private By orderButton = By.xpath("/html/body/div/div/div/div[1]/div[2]/button[1]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrder() {
        driver.findElement(orderButton).click();
    }
}