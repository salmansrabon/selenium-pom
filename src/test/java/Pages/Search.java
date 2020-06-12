package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Search {
    WebDriver driver;
    @FindBy(linkText = "Search Account")
    WebElement linkSearchAccount;
    @FindBy(id="txtMobileNo")
    WebElement txtMobileNo;
    @FindBy(id="statusId")
    WebElement listStatusId;
    @FindBy(id="search")
    WebElement btnSearch;
    public Search(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void SearchByMobile() throws InterruptedException {
        Thread.sleep(2000);
        txtMobileNo.sendKeys("0150");
        Thread.sleep(2000);
        Select ac_status=new Select(listStatusId);
        ac_status.selectByIndex(1);
        Thread.sleep(2000);
        btnSearch.click();
    }
}
