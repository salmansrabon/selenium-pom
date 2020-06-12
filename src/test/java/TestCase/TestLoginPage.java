package TestCase;

import Pages.*;
import Utility.InputHandler;
import Utility.Util;
import Utility.WebServiceClient;
import helper.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class TestLoginPage extends BasePage {
    UserLogin objlogin;
    Search objSearch;
    BankCashIn objBankCashIn;
    BankCashOut objBankCashOut;
    DistributorReg objDistReg;
    AgentReg objAgentReg;
    MerchantReg objMerchantReg;
    WalletStatement objWalletStatement;
    MerchantOpeningBalance objMerchantBal;


    @Test(priority=0,enabled = true, description="User Login")
    public void doLogin() throws InterruptedException {
        driver.get(InputHandler.URL);
        objlogin=new UserLogin(driver);
        objlogin.doUserLogin(InputHandler.MakerUserId,InputHandler.Password);
//        String title= driver.getTitle();
//        Assert.assertTrue(title.contains("Search"));
        Util.attachScreenShot(driver);

    }
    @Test(priority = 1,enabled = true,description="User Search",groups="statement",alwaysRun = true)
    public void doSearch() throws InterruptedException {
        objSearch=new Search(driver);
        objSearch.SearchByMobile();
        Thread.sleep(3000);
        String Result=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/h2")).getText();
        Assert.assertTrue(Result.contains("Result"));
        Util.attachScreenShot(driver);
    }
    @Test(priority = 2,enabled = true,description = "Distributor Wallet Statement",groups = "statement",alwaysRun = true)
    public void ViewDistWalletStatement() throws InterruptedException {
        //doLogin();
        objWalletStatement =new WalletStatement(driver);
        objWalletStatement.viewDistributorWalletStatement();
        //objlogin.doLogout();
    }
    @Test(priority = 3,enabled = true,description = "Agent Wallet Statement")
    public void ViewAgentWalletStatement() throws InterruptedException {
        //doLogin();
        objWalletStatement =new WalletStatement(driver);
        objWalletStatement.viewAgentWalletStatement();
        //objlogin.doLogout();
    }
    @Test(priority = 4,enabled = true,description = "Customer Wallet Statement",groups = "statement",alwaysRun = true)
    public void ViewCustomerWalletStatement() throws InterruptedException {
        //doLogin();
        objWalletStatement =new WalletStatement(driver);
        objWalletStatement.viewCustomerWalletStatement();
        //objlogin.doLogout();
    }
    @Test(priority = 5,enabled = true,description = "Merchant Wallet Statement",groups = "statement",alwaysRun = true)
    public void ViewMerchantWalletStatement() throws InterruptedException {
        //doLogin();
        objWalletStatement =new WalletStatement(driver);
        objWalletStatement.viewMerchantWalletStatement();
        //objlogin.doLogout();
    }
    @Test(priority = 6,enabled = true,description = "SR Statement")
    public void ViewSRStatement() throws InterruptedException {
        objWalletStatement =new WalletStatement(driver);
        objWalletStatement.viewSRWalletStatement();
        //objlogin.doLogout();
    }
    @Test(priority = 7,enabled = true,description = "Merchant Opening Balance",alwaysRun = true)
    public void MerchantOpeningBalance() throws InterruptedException {
        //doLogin();
        //objlogin=new UserLogin(driver);
        //objlogin.doUserLogin(InputHandler.MakerUserId,InputHandler.Password);
        objMerchantBal =new MerchantOpeningBalance(driver);
        objMerchantBal.getMerchantOpeningBalance();
        Util.attachScreenShot(driver);
    }
    @Test(priority = 8,enabled = true,description="Bank Cash-In request by maker",alwaysRun = true)
    public void CashInRequestByMaker() throws InterruptedException {
        Thread.sleep(1000);
        objBankCashIn =new BankCashIn(driver);
        objBankCashIn.CashInRequestByMaker(InputHandler.DistributorWallet,InputHandler.Amount,InputHandler.Description);
        Thread.sleep(3000);
        String Request=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div")).getText();
        Assert.assertTrue(Request.contains("successful"));
        Util.attachScreenShot(driver);
        Thread.sleep(1000);
        objlogin.doLogout();
        Thread.sleep(1000);

    }
    @Test(priority = 9,enabled = true,description="Bank Cash-In approve by checker",alwaysRun = true)
    public void CashInApproveByChecker() throws InterruptedException {
        Thread.sleep(1000);
        objlogin=new UserLogin(driver);
        objlogin.doUserLogin(InputHandler.CheckerUserId,InputHandler.Password);
        Thread.sleep(3000);
        objBankCashIn.CashinApproveByChecker();
        Thread.sleep(3000);
        String Status=driver.findElement(By.xpath("//*[@id=\"statusMessage\"]")).getText();
        Assert.assertTrue(Status.contains("approved"));
        Util.attachScreenShot(driver);
        Thread.sleep(1000);
        objlogin.doLogout();
        Thread.sleep(1000);

    }
    @Test(priority = 10,enabled = true,description = "Bank Cash-Out request by Maker",alwaysRun = true)
    public void CashOutRequestByMaker() throws InterruptedException, IOException {
        Thread.sleep(1000);
        //driver.get( InputHandler.URL );
        objlogin=new UserLogin(driver);
        objlogin.doUserLogin(InputHandler.MakerUserId,InputHandler.Password);
        Thread.sleep(2000);
        objBankCashOut =new BankCashOut(driver);
        objBankCashOut.CashOutRequestByMaker(InputHandler.AgentWallet,InputHandler.Amount,InputHandler.Description);
        Thread.sleep(2000);
        String URL=InputHandler.PUSHURL+"mobile="+Util.getMobileNumber( InputHandler.AgentWallet )+"&text=2468";
        WebServiceClient.DownloadString( URL );
        Thread.sleep(1000);
        String Request=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div")).getText();
        Assert.assertTrue(Request.contains("successful"));
        Util.attachScreenShot(driver);
        Thread.sleep(1000);
        objlogin.doLogout();
        Thread.sleep(1000);
    }
    @Test(priority = 11,enabled = true,description = "Distributor Cash-Out request using OTP",alwaysRun = true)
    public void CashOutRequestByOTP() throws InterruptedException, IOException, SQLException, ClassNotFoundException {
        //driver.get( InputHandler.URL );
        objlogin=new UserLogin(driver);
        objlogin.doUserLogin(InputHandler.MakerUserId,InputHandler.Password);
        Thread.sleep(2000);

        objBankCashOut =new BankCashOut(driver);
        objBankCashOut.CashOutRequestByOTP(InputHandler.DistributorWallet,InputHandler.Amount,InputHandler.Description);
        Thread.sleep(2000);
        String Request=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div")).getText();
        Assert.assertTrue(Request.contains("successful"));
        Util.attachScreenShot(driver);
        Thread.sleep(1000);
        objlogin.doLogout();
        Thread.sleep(1000);
    }
    @Test(priority = 11,enabled = true,description = "Bank Cash-Out approve by Checker",alwaysRun = true)
    public void CashOutApproveByChecker() throws InterruptedException {
        //driver.get(InputHandler.URL);
        objlogin=new UserLogin(driver);
        objlogin.doUserLogin(InputHandler.CheckerUserId,InputHandler.Password);
        Thread.sleep(2000);
        objBankCashOut=new BankCashOut( driver );
        objBankCashOut.CashOutApproveByChecker();
        Thread.sleep(3000);
        String Status=driver.findElement(By.xpath("//*[@id=\"statusMessage\"]")).getText();
        Assert.assertTrue(Status.contains("approved"));
        Util.attachScreenShot(driver);
        Thread.sleep(1000);
        objlogin.doLogout();
        Thread.sleep(1000);
    }
    @Test(priority = 12,enabled = true,description = "Distributor Registration by Maker",alwaysRun = true)
    public void DistributorRegistration() throws IOException, InterruptedException {
        //doLogin();
        objlogin=new UserLogin(driver);
        objlogin.doUserLogin(InputHandler.MakerUserId,InputHandler.Password);
        objDistReg=new DistributorReg(driver);
        Thread.sleep(1000);
        objDistReg.distReg();
        Util.attachScreenShot(driver);
        Thread.sleep(2000);
        objlogin.doLogout();

    }
    @Test(priority = 13,enabled = true,description = "Distributor Activation by Checker",alwaysRun = true)
    public void DistRegApproveByChecker() throws Exception {
//        doLogin();
//        Thread.sleep(2000);
//        objlogin.doLogout();
        objlogin=new UserLogin(driver);
        objDistReg=new DistributorReg(driver);
        objlogin.doUserLogin(InputHandler.CheckerUserId,InputHandler.Password);
        Thread.sleep(2000);
        objDistReg.distRegApprove();
        Thread.sleep(2000);
        String res=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div")).getText();
        Assert.assertTrue(res.contains("activated"));
        Util.attachScreenShot(driver);
        Thread.sleep(2000);
        objlogin.doLogout();
    }
    @Test(priority = 14,enabled = true,description = "Agent Registration by Maker",alwaysRun = true)
    public void AgentRegistration() throws InterruptedException, IOException {
        //doLogin();
        objlogin=new UserLogin(driver);
        objlogin.doUserLogin(InputHandler.MakerUserId,InputHandler.Password);
        objAgentReg=new AgentReg(driver);
        Thread.sleep(1000);
        objAgentReg.agentReg();
        Util.attachScreenShot(driver);
        Thread.sleep(2000);
        objlogin.doLogout();
    }
    @Test(priority = 15,enabled = true,description = "Agent Activation by Checker",alwaysRun = true)
    public void AgentRegApproveByChecker() throws Exception {
//        doLogin();
//        Thread.sleep(2000);
//        objlogin.doLogout();
        objlogin=new UserLogin(driver);
        objAgentReg=new AgentReg(driver);
        objlogin.doUserLogin(InputHandler.CheckerUserId,InputHandler.Password);
        Thread.sleep(2000);
        objAgentReg.agentRegApprove();
        Thread.sleep(2000);
        String res=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div")).getText();
        Assert.assertTrue(res.contains("activated"));
        Util.attachScreenShot(driver);
        Thread.sleep(2000);
        objlogin.doLogout();
    }
    @Test(priority = 16,enabled = true,description = "Merchant Registration by Maker",alwaysRun = true)
    public void MerchantRegistration() throws InterruptedException, IOException {
        //doLogin();
        objlogin=new UserLogin(driver);
        objlogin.doUserLogin(InputHandler.MakerUserId,InputHandler.Password);
        objMerchantReg=new MerchantReg(driver);
        Thread.sleep(1000);
        objMerchantReg.merchantReg();
        Util.attachScreenShot(driver);
        Thread.sleep(2000);
        objlogin.doLogout();
    }
    @Test(priority = 17,enabled = true,description = "Merchant Activation by Checker",alwaysRun = true)
    public void MerchantRegApproveByChecker() throws Exception {
//        doLogin();
//        Thread.sleep(2000);
//        objlogin.doLogout();
        objlogin=new UserLogin(driver);
        objMerchantReg=new MerchantReg(driver);
        objlogin.doUserLogin(InputHandler.CheckerUserId,InputHandler.Password);
        Thread.sleep(2000);
        objMerchantReg.merchantRegApprove();
        Thread.sleep(2000);
        String res=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div[2]/div")).getText();
        Assert.assertTrue(res.contains("activated"));
        Util.attachScreenShot(driver);
        Thread.sleep(2000);
        objlogin.doLogout();
    }


    @AfterTest
    public void Logout() throws InterruptedException {
        driver.quit();

    }

}
