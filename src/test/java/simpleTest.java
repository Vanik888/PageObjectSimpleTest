import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


/**
 * Created by vanik on 15.03.14.
 */
public class simpleTest {
    private WebDriver driver;

    @BeforeMethod
    @Parameters({"browser", "hub", "url"})
    public void setUp(String browser, String hub, String url) throws MalformedURLException {
        if (browser.toLowerCase().equals("chrome"))
            this.driver = new RemoteWebDriver(new URL(hub), DesiredCapabilities.chrome());
        else if (browser.toLowerCase().equals("firefox"))
            this.driver = new RemoteWebDriver(new URL(hub), DesiredCapabilities.firefox());
        else
            throw new NotImplementedException();
        this.driver.manage().window().maximize();
        this.driver.get(url);
        this.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }
    @Test
    public void testSuggestsBmstu() {
        String result =  new MainPage(driver).getSearchForm().enterText("bmstu").suggestsAreReady().getSuggests();
        Assert.assertTrue(result.contains("bmstu.ru"));
    }
    @Test
    public void testSuggestsFacebook() {
        String result  = new MainPage(driver).getSearchForm().enterText("f").suggestsAreReady().getSuggests();
        Assert.assertTrue(result.contains("facebook"));
    }
    @Test
    public void testSeggestsMoscowUfaTickets() {
        String result = new MainPage(driver).getSearchForm().enterText("москва уфа").suggestsAreReady().getSuggests();
        Assert.assertTrue(result.contains("билет"));
    }

    @Test
    public void testSuggestsBmstuWithRussianInputs() {
        String result = new MainPage(driver).getSearchForm().enterText("иьыегюкг").suggestsAreReady().getSuggests();
        Assert.assertTrue(result.contains("bmstu.ru"));
    }

    @Test
    public void tesImgIsNotHidden() {
        Assert.assertTrue(new MainPage(driver).imgIsNotHidden());
    }


    @Test
    public void testImgIsHidden(){
        WebElement btn = new MainPage(driver).getHideImgButton();
        btn.click();
        Assert.assertTrue(new MainPage(driver).imgIsHidden());
    }
    @Test
    public void testShowPreviousImg() {
        String currentImgSrc = new MainPage(driver).getImg().getAttribute("src");
        Actions act =  new Actions(driver);
        act.moveToElement(new MainPage(driver).getImg()).perform();
        WebElement btn = new MainPage(driver).getToLeftButton();
        btn.click();
        Assert.assertNotEquals(currentImgSrc, new MainPage(driver).firstImgIsNotVisible().getImg().getAttribute("src"));
    }
    @Test
    public void testSecondResultOfTheKillers() {
        new MainPage(driver).getSearchForm().enterText("the killers").Submit();
        String href  = new MainPage(driver).getResultHrefOfElementByNumber(2).getText();
        Assert.assertEquals(href, "thekillersmusic.com");
    }

    @Test
    public void testThirdResultOfTheKillers() {
        new MainPage(driver).getSearchForm().enterText("the killers").Submit();
        String href  = new MainPage(driver).getResultHrefOfElementByNumber(3).getText();
        Assert.assertEquals(href, "ru.wikipedia.org/wiki/The_Killers");
    }

    @Test
    public void testMistypeAutoExists() {
        new MainPage(driver).getSearchForm().enterText("мосвка").Submit();
        String mistype = new MainPage(driver).getSearchForm().getMistypeAuto().getText();
        Assert.assertEquals(mistype, "мосвка");
    }
    @Test
    public void testMistypeFixed() {
        new MainPage(driver).getSearchForm().enterText("мосвка").Submit();
        String inputText = new MainPage(driver).getResultTitleOfElementByNumber(2).getText();
        Assert.assertTrue(inputText.contains("Москва"));
    }
    @Test
    public void testHoveredImageIsMaximized() {
        new MainPage(driver).getSearchForm().enterText("Москва").Submit();
        new MainPage(driver).getSearchForm().getTopMenuImgs().click();
        Actions act = new Actions(driver);
        act.moveToElement(new MainPage(driver).getSearchForm().getImgById()).perform();
        Assert.assertTrue(new MainPage(driver).getSearchForm().getImgById().getAttribute("class").contains("popup-showed"));
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
