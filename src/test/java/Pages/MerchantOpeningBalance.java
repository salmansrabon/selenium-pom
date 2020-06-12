package Pages;

import Utility.InputHandler;
import Utility.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MerchantOpeningBalance {
    WebDriver driver;
    @FindBy(linkText = "Merchant Opening Balance")
    WebElement linkMerchantBalance;
    @FindBy(id="searchDate")
    WebElement txtDate;
    @FindBy(id="userWallet")
    WebElement txtUserWallet;
    @FindBy(id="search")
    WebElement btnSubmit;
    public MerchantOpeningBalance(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void getMerchantOpeningBalance() throws InterruptedException {
        Thread.sleep(2000);
        linkMerchantBalance.click();
        Thread.sleep(1000);
        txtDate.click();
        String date=new SimpleDateFormat("dd-MM-yyyy").format(new Date()).substring(0,2);
        driver.findElement(By.linkText(date)).click();
        Thread.sleep(1000);
        txtUserWallet.sendKeys(InputHandler.MerchantWallet);
        Thread.sleep(2000);
        btnSubmit.click();
        Thread.sleep(2000);
        btnSubmit.click();
        Thread.sleep(2000);
        String res=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div[1]/h2")).getText();
        Assert.assertTrue(res.contains("Result"));

    }
}
