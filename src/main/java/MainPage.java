import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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

    public WebElement getHideImgButton() {
        return new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.id("wallpapers__toggle")));
    }

    public WebElement getToLeftButton() {
        return new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.id("wallpapers__prev")));
    }

    public WebElement getImg() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.className("wallpapers__preload")));
    }

    public List<WebElement> getResultList() {
        return new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("result__li")));
    }

    public WebElement getResultHrefOfElementByNumber(int num) {
        return getResultList().get(num-1).findElement(By.className("block-info")).findElement(By.tagName("a"));
    }

    public WebElement getResultTitleOfElementByNumber(int num) {
        return getResultList().get(num-1).findElement(By.className("result__title")).findElement(By.tagName("a"));
    }

    public Boolean imgIsHidden() {
        return new WebDriverWait(driver,10).until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("wallpapers__toggle")), "Показать фото"));
    }

    public Boolean imgIsNotHidden() {
        return new WebDriverWait(driver,10).until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("wallpapers__toggle")), "Убрать фото"));
    }

    public MainPage firstImgIsNotVisible() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.className("wallpapers__preload-first")));
        return this;
    }
}
