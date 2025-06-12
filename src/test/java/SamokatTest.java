import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
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

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class SamokatTest {
    private final String name;
    private final String lastName;
    private final String address;
    private final String phone;
    private final String metro;
    private final String data;
    private final String term;
    private final String color;
    private final String comment;

    private WebDriver driver;
    private WebDriverWait wait;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Маша", "Ласточкина", "Ленина 4", "+79999999997", "fourth", "fourth", "second", "second", "21"},
                {"Ваня", "Ленин", "Ленина 3", "+79999999998", "third", "third", "third", "second", "-"}
        });
    }

    public SamokatTest(String name, String lastName, String address, String phone, String metro, String data, String term, String color, String comment) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.metro = metro;
        this.data = data;
        this.term = term;
        this.color = color;
        this.comment = comment;
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    private void test(String name, String lastName, String address, String phone, String metro, String data, String term, String color, String comment) {
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
    public void chromeTest() {
        driver = new ChromeDriver();

        this.test(this.name, this.lastName, this.address, this.phone, this.metro, this.data, this.term, this.color, this.comment);
    }

    @Test
    public void firefoxTest() {
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/Applications/Firefox.app/Contents/MacOS/firefox");
        driver = new FirefoxDriver(options);

        this.test(this.name, this.lastName, this.address, this.phone, this.metro, this.data, this.term, this.color, this.comment);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
