package Pages;

import Utility.InputHandler;
import Utility.Util;
import Utility.WebServiceClient;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.sql.SQLException;

public class BankCashOut {
    WebDriver driver;
    @FindBy(linkText = "Bank Cash Out")
    WebElement linkBankCashOut;
    @FindBy(id = "withdrawApprove")
    WebElement linkApprove;
    @FindBy(id="wallet")
    WebElement txtWallet;
    @FindBy(id="name")
    WebElement txtName;
    @FindBy(id="amount")
    WebElement txtAmount;
    @FindBy(id="description")
    WebElement txtDescription;
    @FindBy(id="updateComment")
    WebElement txtUpdateComment;
    @FindBy(id="withdraw")
    WebElement btnCashOut;
    @FindBy(id="confirm")
    WebElement btnConfirm;
    @FindBy(id="approveButton")
    WebElement btnApproveButton;
    @FindBy(id="btnSendCode")
    WebElement btnSendCode;
    @FindBy(id="otpCode")
    WebElement txtConfirmOTP;
    @FindBy(id="confirmOtp")
    WebElement btnConfirmOTP;
    public BankCashOut(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void CashOutRequestByMaker(String wallet,String amount,String description) throws InterruptedException, IOException {
        linkBankCashOut.click();
        Thread.sleep(2000);
        txtWallet.sendKeys(wallet);
        Thread.sleep(2000);
        txtAmount.sendKeys(amount);
        Thread.sleep(2000);
        txtDescription.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        txtDescription.sendKeys(description);
        Thread.sleep(2000);
        btnCashOut.click();
        Thread.sleep(2000);
        btnConfirm.click();
        Thread.sleep(2000);
    }
    public void CashOutApproveByChecker() throws InterruptedException {
        Thread.sleep(2000);
        linkApprove.click();
        Thread.sleep(2000);
        txtUpdateComment.sendKeys("Bank Cash-Out");
        Thread.sleep(1000);
        btnApproveButton.click();
        Thread.sleep(1000);
    }
    public void CashOutRequestByOTP(String wallet,String amount,String description) throws InterruptedException, SQLException, ClassNotFoundException {
        linkBankCashOut.click();
        Thread.sleep(2000);
        txtWallet.sendKeys(wallet);
        Thread.sleep(2000);
        txtAmount.sendKeys(amount);
        Thread.sleep(2000);
        txtDescription.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        txtDescription.sendKeys(description);
        Thread.sleep(2000);
        btnCashOut.click();
        Thread.sleep(2000);
        btnConfirm.click();
        Thread.sleep(2000);
        btnSendCode.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        String otp= Util.readOTP(InputHandler.DistributorWallet);
        Thread.sleep(1000);
        txtConfirmOTP.click();
        Thread.sleep(1000);
        txtConfirmOTP.sendKeys( otp );
        Thread.sleep(1000);
        btnConfirmOTP.click();
    }
}
