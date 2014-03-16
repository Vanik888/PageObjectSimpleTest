import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.MoveAction;
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
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Thread.sleep(2000);
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
        Assert.assertEquals(new MainPage(driver).getHideImgButton().getText(), "Убрать фото");

    }
    @Test
    public void testImgIsHidden() throws InterruptedException {
        Thread.sleep(1000);
        WebElement btn = new MainPage(driver).getHideImgButton();
        btn.click();
        Thread.sleep(2000);
        Assert.assertEquals(new MainPage(driver).getHideImgButton().getText(), "Показать фото");
    }
    @Test
    public void testShowPreviousImg() throws InterruptedException {
        String currentImgSrc = new MainPage(driver).getImg().getAttribute("src");
        Actions act =  new Actions(driver);
        act.moveToElement(new MainPage(driver).getImg()).perform();
        WebElement btn = new MainPage(driver).getToLeftButton();
        btn.click();
        Thread.sleep(2000);
        Assert.assertNotEquals(currentImgSrc, new MainPage(driver).getImg().getAttribute("src"));
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("tearDown");
        driver.close();
    }


}
