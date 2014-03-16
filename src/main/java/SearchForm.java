import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        driver.findElement(By.id("q")).sendKeys(text);
        return this;

    }
    public void getFirstHref() {
        WebElement li = driver.findElement(By.id("js_result_1"));
//        li.
    }
    public String getSuggests() {
        return new WebDriverWait(driver,5).
                until(ExpectedConditions.
                        presenceOfElementLocated(By.className("go-suggests__item"))).getText();
    }
}
