import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.OrderFirstPage;
import pages.OrderSecondPage;

import static org.junit.Assert.assertTrue;

public class Samokat {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    private void Test(String name, String lastName, String address, String phone, String metro, String data, String term, String color, String comment) {
        wait = new WebDriverWait(driver, 3);

        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPage = new MainPage(driver);
        OrderFirstPage orderFirstPage = new OrderFirstPage(driver, wait);
        OrderSecondPage orderSecondPage = new OrderSecondPage(driver, wait);

        mainPage.clickOrder();

        orderFirstPage.fillName(name);
        orderFirstPage.fillLastName(lastName);
        orderFirstPage.fillMetro(metro);
        orderFirstPage.fillAddress(address);
        orderFirstPage.fillPhone(phone);
        orderFirstPage.clickNext();
        orderSecondPage.data(data);
        orderSecondPage.term(term);
        orderSecondPage.color(color);
        orderSecondPage.comment(comment);
        orderSecondPage.clickOrder();
        String text = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[1]")).getText();
        assertTrue(text.contains("Хотите оформить заказ?"));
    }

    @Test
    public void FirstChromeTest() {
        driver = new ChromeDriver();

        this.Test("Вася", "Васячкин", "Ленина 1", "+79999999999", "first", "first", "first", "first", "Домофон не работает");
    }

    @Test
    public void SecondChromeTest() {
        driver = new ChromeDriver();

        this.Test("Толя", "Мамедов", "Ленина 2", "+79999999990", "second", "second", "second", "first", "Домофон работает");
    }

    @Test
    public void FirstFirefoxTest() {
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/Applications/Firefox.app/Contents/MacOS/firefox");
        driver = new FirefoxDriver(options);

        this.Test("Ваня", "Ленин", "Ленина 3", "+79999999998", "third", "third", "third", "second", "-");
    }

    @Test
    public void SecondFirefoxTest() {
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/Applications/Firefox.app/Contents/MacOS/firefox");
        driver = new FirefoxDriver(options);

        this.Test("Маша", "Ласточкина", "Ленина 4", "+79999999997", "fourth", "fourth", "second", "second", "21");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
