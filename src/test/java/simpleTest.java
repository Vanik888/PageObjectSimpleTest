import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by vanik on 15.03.14.
 */
public class simpleTest {
    private WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        this.driver = new FirefoxDriver();
        driver.get("http://go.mail.ru");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        System.out.println("BeforeMethod");
    }

    @Test
    public void testSuggests() {
        System.out.println("firstTest");
        String result =  new MainPage(driver).getSearchForm().enterText("bmstu").getSuggests();
        System.out.println(result);
        Assert.assertTrue(result.contains("bmstu.ru"));
    }
    @Test
    public void testSuggestsWithRussianInputs() {
        System.out.println("secondTest");
        String result = new MainPage(driver).getSearchForm().enterText("иьыегюкг").getSuggests();
        Assert.assertTrue(result.contains("bmstu.ru"));
    }
    @Test
    public void tesImgIsNotHidden() {
        System.out.println("HideImg");
        Assert.assertEquals(new MainPage(driver).getImgButton().getText(), "Убрать фото");

    }
    @Test
    public void testImgIsHidden() throws InterruptedException {
        WebElement btn = new MainPage(driver).getImgButton();
        btn.click();
        Thread.sleep(2000);
        Assert.assertEquals(new MainPage(driver).getImgButton().getText(), "Показать фото");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("tearDown");
        driver.close();
    }


}
