import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.MoveAction;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Created by vanik on 15.03.14.
 */
public class simpleTest {
    private WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
//        this.driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        this.driver = new ChromeDriver();
        driver.get("http://go.mail.ru");
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Thread.sleep(2000);
        System.out.println("BeforeMethod");
    }
//    @Test
//    public void testSuggestsBmstu() {
//        System.out.println("firstTest");
//        String result =  new MainPage(driver).getSearchForm().enterText("bmstu").getSuggests();
//        System.out.println(result);
//        Assert.assertTrue(result.contains("bmstu.ru"));
//    }
//    @Test
//    public void testSuggestsFacebook() throws InterruptedException {
//        String result  = new MainPage(driver).getSearchForm().enterText("f").getSuggests();
//        Thread.sleep(200);
//        Assert.assertTrue(result.contains("facebook"));
//    }
    @Test
    public void testSeggestsMoscowUfaTickets() throws InterruptedException {
        String result = new MainPage(driver).getSearchForm().enterText("москва уфа").getSuggests();
        System.out.println(result);
        Thread.sleep(200);
        Assert.assertTrue(result.contains("билет"));
    }
//
//    @Test
//    public void testSuggestsBmstuWithRussianInputs() {
//        System.out.println("secondTest");
//        String result = new MainPage(driver).getSearchForm().enterText("иьыегюкг").getSuggests();
//        Assert.assertTrue(result.contains("bmstu.ru"));
//    }
//    @Test
//    public void tesImgIsNotHidden() {
//        System.out.println("HideImg");
//        Assert.assertEquals(new MainPage(driver).getHideImgButton().getText(), "Убрать фото");
//    }
//    @Test
//    public void testImgIsHidden() throws InterruptedException {
//        Thread.sleep(1000);
//        WebElement btn = new MainPage(driver).getHideImgButton();
//        btn.click();
//        Thread.sleep(2000);
//        Assert.assertEquals(new MainPage(driver).getHideImgButton().getText(), "Показать фото");
//    }
//    @Test
//    public void testShowPreviousImg() throws InterruptedException {
//        String currentImgSrc = new MainPage(driver).getImg().getAttribute("src");
//        Actions act =  new Actions(driver);
//        act.moveToElement(new MainPage(driver).getImg()).perform();
//        WebElement btn = new MainPage(driver).getToLeftButton();
//        btn.click();
//        Thread.sleep(2000);
//        Assert.assertNotEquals(currentImgSrc, new MainPage(driver).getImg().getAttribute("src"));
//    }
//    @Test
//    public void testSecondResultOfTheKillers() {
//        new MainPage(driver).getSearchForm().enterText("the killers").Submit();
//        String href  = new MainPage(driver).getResultHrefOfElementByNumber(2).getText();
//        Assert.assertEquals(href, "thekillersmusic.com");
//    }
//
//    @Test
//    public void testThirdResultOfTheKillers() {
//        new MainPage(driver).getSearchForm().enterText("the killers").Submit();
//        String href  = new MainPage(driver).getResultHrefOfElementByNumber(3).getText();
//        Assert.assertEquals(href, "ru.wikipedia.org/wiki/The_Killers");
//    }
//
//    @Test
//    public void testMistypeAutoExists() {
//        new MainPage(driver).getSearchForm().enterText("мосвка").Submit();
//        String mistype = new MainPage(driver).getSearchForm().getMistypeAuto().getText();
//        Assert.assertEquals(mistype, "мосвка");
//    }
//    @Test
//    public void testMistypeFixed() {
//        new MainPage(driver).getSearchForm().enterText("мосвка").Submit();
//        String inputText = new MainPage(driver).getResultTitleOfElementByNumber(2).getText();
//        Assert.assertTrue(inputText.contains("Москва"));
//    }
//    @Test
//    public void testHoveredImageIsMaximized() {
//        new MainPage(driver).getSearchForm().enterText("Москва").Submit();
//        new MainPage(driver).getSearchForm().getTopMenuImgs().click();
//        Actions act = new Actions(driver);
//        act.moveToElement(new MainPage(driver).getSearchForm().getImgById()).perform();
//        Assert.assertTrue(new MainPage(driver).getSearchForm().getImgById().getAttribute("class").contains("popup-showed"));
//    }
    @AfterMethod
    public void tearDown() {
        System.out.println("tearDown");
        driver.close();
    }


}
