package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class InputHandler {
    public static String MakerUserId;
    public static String CheckerUserId;
    public static String Password;
    public static String URL;
    public static String DistributorWallet;
    public static String AgentWallet;
    public static String CustomerWallet;
    public static String MerchantWallet;
    public static String Amount;
    public static String Description;
    public static String PUSHURL;

    public static void ReadConfigFile() throws IOException {
        Properties prop=new Properties();
        FileInputStream ip= new FileInputStream("src\\test\\resources\\config.properties");
        prop.load(ip);
        MakerUserId= prop.getProperty("MakerUserId");
        CheckerUserId=prop.getProperty("CheckerUserId");
        Password=prop.getProperty("Password");
        URL=prop.getProperty("URL");
        DistributorWallet=prop.getProperty("DistributorWallet");
        AgentWallet=prop.getProperty("AgentWallet");
        CustomerWallet=prop.getProperty("CustomerWallet");
        MerchantWallet=prop.getProperty("MerchantWallet");
        Amount=prop.getProperty("Amount");
        Description=prop.getProperty("Description");
        PUSHURL=prop.getProperty("PUSHURL");



    }
}
