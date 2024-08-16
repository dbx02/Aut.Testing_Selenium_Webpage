package Test;

import Base.BaseTest;
import Help.HelpMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ShoppingList_Dropdown extends BaseTest {
    public HelpMethod helpMethod;

    @Test
    public void selectDropdown(){
        helpMethod = new HelpMethod(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        String expectedResult = "Modă, casă & beauty | Primark";
        helpMethod.validareHomepage(expectedResult);

        helpMethod.handleCookie();

        //First we add a product in shopping list
        WebElement searchBar = driver.findElement(By.xpath("//div[@class='SearchPanelDesktop-toolbar MuiBox-root css-0']/div[2]"));
        searchBar.click();

        WebElement fillinSearchBar = driver.findElement(By.id("search-field"));
        fillinSearchBar.sendKeys("bluza");
        fillinSearchBar.sendKeys(Keys.ENTER);

        helpMethod.handlePopup();
        helpMethod.scrollIntoViewAddList();

        List<WebElement> addtoListElement = driver.findElements(By.xpath("//div[@id='products-grid']//div"));
        addtoListElement.get(1).click();
        WebElement addtoList = driver.findElement(By.xpath("//div[@id='sales-panel-wrapper-header']/div/button"));
        addtoList.click();

        helpMethod.handlePopup();

//      //then we open the  shopping list
        WebElement openShoppingList = driver.findElement(By.xpath("//div[@id='account-toolbar']/a[1]"));
        openShoppingList.click();

        helpMethod.handlePopup();
        //then we choose the third item from dropdown
        helpMethod.scrollDown();

        WebElement chooseDropdown = driver.findElement(By.xpath("//div[@class='MuiBox-root css-rwiky4']/div"));
        chooseDropdown.click();

        WebElement thirdItem = driver.findElement(By.xpath("//ul[@id='mui-40']//li[2]"));
        thirdItem.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        helpMethod.handlePopup();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        helpMethod.assertChooseItem();

    }





}
