import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
//    public void enterText(String text) {
//        searchForm.sendKeys("vk");
//    }

}
