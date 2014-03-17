import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by vanik on 15.03.14.
 */
public class SearchForm {
    private WebDriver driver;
//    private WebElement searchForm;

    public SearchForm(WebDriver driver) {
        this.driver = driver;
    }
    public SearchForm enterText(String text) {
        this.getSearchInput().sendKeys(text);
        return this;
    }
    public void Submit() {
        driver.findElement(By.id("q")).submit();
    }
    public SearchForm suggestsAreReady() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("go-suggests__item")));
        return this;
    }
    public String getSuggests()  {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.className("go-suggests__items"))).getText();
    }

    public WebElement getMistypeAuto() {
        return new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(By.className("mistype__auto"))).findElement(By.tagName("a"));
    }
    public WebElement getSearchInput() {
        return driver.findElement(By.id("q"));
    }
    public WebElement getTopMenuImgs() {
        return new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(By.id("tbl-img"))).findElement(By.tagName("a"));
    }
    public WebElement getImgById() {
        return new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(By.id("it_2")));
    }
}
