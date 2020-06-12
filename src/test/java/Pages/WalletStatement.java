package Pages;

import Utility.InputHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WalletStatement {
    WebDriver driver;
    @FindBy(linkText = "Wallet Statement")
    WebElement linkWalletStatement;
    @FindBy(linkText = "SR Statement")
    WebElement linkSRStatement;
    @FindBy(id = "selectedMonthDuration")
    WebElement listDateRange;
    @FindBy(id="wallet")
    WebElement txtWallet;
    @FindBy(id="fromDate")
    WebElement txtFromDate;
    @FindBy(id="toDate")
    WebElement txtToDate;
    @FindBy(id="search")
    WebElement btnViewStatement;
    @FindBy(name="viewOrgStatement")
    WebElement btnViewSRStatement;

    public WalletStatement(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void viewDistributorWalletStatement() throws InterruptedException {
        Thread.sleep(2000);
        linkWalletStatement.click();
        Thread.sleep(1000);
        txtWallet.sendKeys(InputHandler.DistributorWallet);
        Thread.sleep(1000);
        txtFromDate.click();
        driver.findElement(By.linkText("1")).click();
        Thread.sleep(1000);
        txtToDate.click();
        String todate=new SimpleDateFormat("dd-MM-yyyy").format(new Date()).substring(0,2);
        driver.findElement(By.linkText(todate)).click();
        Thread.sleep(1000);
        btnViewStatement.click();
        Thread.sleep(2000);

    }
    public void viewAgentWalletStatement() throws InterruptedException {
        Thread.sleep(2000);
        linkWalletStatement.click();
        Thread.sleep(1000);
        txtWallet.sendKeys(InputHandler.AgentWallet);
        Thread.sleep(1000);
        txtFromDate.click();
        driver.findElement(By.linkText("1")).click();
        Thread.sleep(1000);
        txtToDate.click();
        String todate=new SimpleDateFormat("dd-MM-yyyy").format(new Date()).substring(0,2);
        driver.findElement(By.linkText(todate)).click();
        Thread.sleep(1000);
        btnViewStatement.click();
        Thread.sleep(2000);
    }
    public void viewCustomerWalletStatement() throws InterruptedException {
        Thread.sleep(2000);
        linkWalletStatement.click();
        Thread.sleep(1000);
        txtWallet.sendKeys(InputHandler.CustomerWallet);
        Thread.sleep(1000);
        txtFromDate.click();
        driver.findElement(By.linkText("1")).click();
        Thread.sleep(1000);
        txtToDate.click();
        String todate=new SimpleDateFormat("dd-MM-yyyy").format(new Date()).substring(0,2);
        driver.findElement(By.linkText(todate)).click();
        Thread.sleep(1000);
        btnViewStatement.click();
        Thread.sleep(2000);
    }
    public void viewMerchantWalletStatement() throws InterruptedException {
        Thread.sleep(2000);
        linkWalletStatement.click();
        Thread.sleep(1000);
        txtWallet.sendKeys(InputHandler.MerchantWallet);
        Thread.sleep(1000);
        txtFromDate.click();
        driver.findElement(By.linkText("1")).click();
        Thread.sleep(1000);
        txtToDate.click();
        String todate=new SimpleDateFormat("dd-MM-yyyy").format(new Date()).substring(0,2);
        driver.findElement(By.linkText(todate)).click();
        Thread.sleep(1000);
        btnViewStatement.click();
        Thread.sleep(2000);
    }
    public void viewSRWalletStatement() throws InterruptedException {
        Thread.sleep(2000);
        linkSRStatement.click();
        Thread.sleep(1000);
        txtWallet.sendKeys("015802569214");
        Thread.sleep(1000);
        Select dateRange=new Select(listDateRange);
        dateRange.selectByIndex(1);
        Thread.sleep(1000);
        btnViewSRStatement.click();
        Thread.sleep(2000);
    }
}
