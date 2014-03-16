import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by vanik on 15.03.14.
 */
public class MainPage {
    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public SearchForm getSearchForm() {
        return new SearchForm(driver);
    }
//    public ImgButton getImgButton() {
//        return new ImgButton(driver);
//    }
    public WebElement getHideImgButton() {
        return new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(By.id("wallpapers__toggle")));
    }
    public WebElement getToLeftButton() {
        return new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(By.id("wallpapers__prev")));
    }
    public WebElement getImg() {
        return new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.className("wallpapers__preload")));
    }
//    public void enterText(String text) {
//        searchForm.sendKeys("vk");
//    }

}
