import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by vanik on 15.03.14.
 */
public class simpleTest {
    private WebDriver driver = new FirefoxDriver();
    @BeforeMethod
    public void setUp() {
        MainPage mainPage = new MainPage(driver);
        System.out.println("hello world");
        driver.get("http://go.mail.ru");
    }
    @Test
    public void test() {
        System.out.println("hy");
    }
}
