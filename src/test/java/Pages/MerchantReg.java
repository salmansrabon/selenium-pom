package Pages;

import Utility.InputHandler;
import Utility.Util;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MerchantReg {
    WebDriver driver;
    @FindBy(linkText = "A/C Registration")
    WebElement linkMerchantReg;
    @FindBy(id="bankName")
    WebElement listBankName;
    @FindBy(id="userType")
    WebElement listUserType;
    @FindBy(id="fullName")
    WebElement txtFullName;
    @FindBy(id="mobilePhone")
    WebElement txtMobileNumber;
    @FindBy(id="merchantShortName")
    WebElement txtShortCode;
    @FindBy(id="merchantCategory")
    WebElement listMerchantCategory;
    @FindBy(id="telcoMerchantCategory")
    WebElement listTelcoMerchantCategory;

    @FindBy(id="rate")
    WebElement txtRate;
    @FindBy(id="minRate")
    WebElement txtMinRate;
    @FindBy(id="maxRate")
    WebElement txtMaxRate;
    @FindBy(id="commissionFromCustomer")
    WebElement rbCommissionFromCustomer;
    @FindBy(id="isActive")
    WebElement chkIsActive;
    @FindBy(id="isTrusted")
    WebElement chkIsTrusted;

    @FindBy(id="NI")
    WebElement rbNID;
    @FindBy(id="fileIdNumber")
    WebElement txtFileIdNumber;
    @FindBy(id="fileUrl")
    WebElement txtFileURL;
    @FindBy(id="photographUrl")
    WebElement txtPhotoGraphURL;

    @FindBy(id="register")
    WebElement btnRegister;
    @FindBy(id="confirm")
    WebElement btnConfirm;

    @FindBy(id="txtMobileNo")
    WebElement txtMobileNo;
    @FindBy(id="search")
    WebElement btnSearch;
    @FindBy(xpath="//*[@id=\"userList\"]")
    WebElement txtMerchantWallet;
    @FindBy(xpath="/html/body/div[2]/div/div[2]/div/div/div[2]/form/div/a[2]")
    WebElement btnActive;
    @FindBy(id="updateComment")
    WebElement txtComment;
    @FindBy(id="saveButton")
    WebElement btnSubmitComment;

    public MerchantReg(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void merchantReg() throws InterruptedException {
        Thread.sleep(2000);
        linkMerchantReg.click();
        Thread.sleep(2000);
        Select userType=new Select(listUserType);
        userType.selectByVisibleText("Payment Partner");
        Thread.sleep(1000);
        txtFullName.sendKeys("Test Merchant");
        Thread.sleep(1000);
        txtMobileNumber.sendKeys(Util.generateRandomMobileNumber());
        Thread.sleep(1000);
        txtShortCode.sendKeys(Util.generateMerchantShortCode());
        Thread.sleep(1000);
        Select category=new Select(listMerchantCategory);
        category.selectByVisibleText("General");
        Thread.sleep(1000);
        Select telcocategory=new Select(listTelcoMerchantCategory);
        telcocategory.selectByVisibleText("GENERAL");
        Thread.sleep(1000);
        txtRate.sendKeys("1");
        Thread.sleep(1000);
        txtMinRate.sendKeys("4");
        Thread.sleep(1000);
        txtMaxRate.sendKeys("30");
        Thread.sleep(1000);
        rbCommissionFromCustomer.click();
        Thread.sleep(1000);
        chkIsActive.click();
        chkIsTrusted.click();
        Thread.sleep(1000);
        rbNID.click();
        Thread.sleep(1000);
        txtFileIdNumber.sendKeys("1502212470");
        Thread.sleep(1000);
        txtFileURL.sendKeys(System.getProperty("user.dir")+"\\src\\test\\resources\\humanface.jpg");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        txtPhotoGraphURL.sendKeys(System.getProperty("user.dir")+"\\src\\test\\resources\\humanface.jpg");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        btnRegister.click();
        Thread.sleep(2000);
        btnConfirm.click();
        Thread.sleep(1000);
    }
    public void merchantRegApprove() throws Exception {
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/ul/li[4]/a")).click();
        Thread.sleep(5000);
        String wallet=txtMerchantWallet.getText();
        addDescription("Merchant wallet: "+wallet);
        driver.get(""+ InputHandler.URL+"/accountSearch/editCustomer/"+wallet+"");
        Thread.sleep(5000);
        btnActive.click();
        Thread.sleep(1000);
        txtComment.sendKeys("Ok");
        Thread.sleep(1000);
        btnSubmitComment.click();
        Thread.sleep(2000);

    }
    public void addDescription(String data) throws Exception
    {
        try{
            Allure.addDescription(data);
        }
        catch(Exception e)
        {
            System.out.print(e.toString());
        }

    }
}
