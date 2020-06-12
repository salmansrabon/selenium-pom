package Utility;

import Utility.InputHandler;
import io.qameta.allure.Attachment;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static void main(String args[]) throws IOException, SQLException, ClassNotFoundException {
        //String otp= Util.readOTP("015802569215");
        //System.out.print( otp );
        String todate=new SimpleDateFormat("dd-MM-yyyy").format(new Date()).substring(0,2);
        System.out.println(todate);

    }
    @Attachment(value = "ScreenShot", type = "image/png")
    public static byte[] attachScreenShot(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
    public static String generateRandomMobileNumber(){
        String operatorCode = "01503";
        String phoneNumber = operatorCode + RandomStringUtils.randomNumeric(6);
        return phoneNumber;
    }
    public static String generateMerchantShortCode(){
        String prefix = "TM";
        String shortcode = prefix + RandomStringUtils.randomNumeric(3);
        return shortcode;
    }
    public static String getMobileNumber(String wallet)
    {
        String mobileno = wallet.substring(0, wallet.length() - 1);
        return mobileno;
    }
    public static String readOTP(String wallet) throws ClassNotFoundException, SQLException {
        String otp = "";
        try
        {

            // create our mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://192.168.168.17:3306/profino_tb3";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "salman", "f5Lqe4@!!");

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM profino_tb3.`sc_txn_otp` s WHERE s.`wallet`="+wallet+" ORDER BY id DESC LIMIT 1;";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                otp = rs.getString("otp_value");

                // print the results
                System.out.print( otp );
                return otp;
                //System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
            }

            st.close();

        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return otp;

    }

}
