package Test;

import Base.BaseTest;
import Help.HelpMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class Searchbar_WrongProduct extends BaseTest {
    public HelpMethod helpMethod;

    @Test
    public void wrongProductSearch(){
        helpMethod = new HelpMethod(driver);
        String expectedResult = "Modă, casă & beauty | Primark";
        helpMethod.validareHomepage(expectedResult);

        helpMethod.handleCookie();
        WebElement searchBar = driver.findElement(By.xpath("//div[@class='SearchPanelDesktop-toolbar MuiBox-root css-0']/div[2]"));
        searchBar.click();

        //first we search for a product
        WebElement fillinSearchBar = driver.findElement(By.id("search-field"));
        fillinSearchBar.sendKeys("masina de spalat");
        fillinSearchBar.sendKeys(Keys.ENTER);

        helpMethod.handlePopup();

        //then we delete the first value and add a new value in the search field
        WebElement searchBar2 = driver.findElement(By.xpath("//div[@aria-label='Căutare']"));
        searchBar2.click();
        WebElement deleteFirstSearch = driver.findElement(By.xpath("//div[@role='search']/div/div[2]/button"));
        deleteFirstSearch.click();

        helpMethod.handlePopup();

        WebElement searchbar3 = driver.findElement(By.id("search-field"));
        searchbar3.sendKeys("Pahar verde");
        searchbar3.sendKeys(Keys.ENTER);

        //assert to see that the product we are looking for does not exist on this website
        helpMethod.assertWrongSearch();


    }


}
