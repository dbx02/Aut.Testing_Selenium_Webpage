package Test;

import Base.BaseTest;
import Help.HelpMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SearchBar extends BaseTest {
    public HelpMethod helpMethod;
    @Test

    public void fillSearchBar(){
        helpMethod = new HelpMethod(driver);
        String expectedResult = "Modă, casă & beauty | Primark";
        helpMethod.validareHomepage(expectedResult);

        helpMethod.handleCookie();
        WebElement searchBar = driver.findElement(By.xpath("//div[@class='SearchPanelDesktop-toolbar MuiBox-root css-0']/div[2]"));
        searchBar.click();

        //search for a product
        WebElement fillinSearchBar = driver.findElement(By.id("search-field"));
        fillinSearchBar.sendKeys("pantaloni scurti");
        fillinSearchBar.sendKeys(Keys.ENTER);

        helpMethod.handlePopup();

        //assert for the result is displayed
        helpMethod.assertExpectedSearch();



    }

}
