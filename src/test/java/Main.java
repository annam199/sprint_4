import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Main {
    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    private void test() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        WebElement accordion = driver.findElement(By.className("accordion"));

        for(WebElement item : accordion.findElements(By.className("accordion__item"))) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", item);
            item.click();
            item.findElement(By.className("accordion__panel")).isDisplayed();
        }
    }

    @Test
    public void chromeTest() {
        driver = new ChromeDriver();

        this.test();
    }

    @Test
    public void firefoxTest() {
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/Applications/Firefox.app/Contents/MacOS/firefox");
        driver = new FirefoxDriver(options);

        this.test();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
