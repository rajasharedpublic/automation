package com.crossover.e2e;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;


public class irctcbook extends TestCase {
    private WebDriver driver;
    private Properties properties = new Properties();


    public void setUp() throws Exception {
        
        properties.load(new FileReader(new File("src/test/resources/test.properties")));
        //Dont Change below line. Set this value in test.properties file incase you need to change it..
        System.setProperty("webdriver.chrome.driver",properties.getProperty("webdriver.chrome.driver") );
        driver = new ChromeDriver();
    }

    public void tearDown() throws Exception {
        driver.quit();
    }

    /*
     * Please focus on completing the task
     * 
     */
    @Test
    public void testSendEmail() throws Exception {

        //driver.get("https://www.irctc.co.in");

        driver.get("https://www.irctc.co.in/nget/train-search");

        //driver.switchTo().alert().dismiss();

        driver.manage().window().setSize(new Dimension(1440, 900));

        String login_window = "//*[@id='exampleModalLabel' and contains(text(), 'Login')]";

        //driver.findElement(By.xpath(login_window)).click();

        WebDriverWait wait = new WebDriverWait(driver, 180);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login_window)));

        driver.findElement(By.id("loginText")).isDisplayed();

        if (driver.findElement(By.id("loginText")).isDisplayed()) {

            driver.findElement(By.id("userId")).sendKeys("raj22067");


            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login_window)));

            //*[@id=""]

            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']//input[@type='password' and @name='password']")));


            String captcha = "//*[@class='loginError' and contains(text(),'Please Enter Valid Captcha')]";

            String sign_in_btn = "//*[@type='submit' and contains(text(), 'SIGN IN')]";

            driver.findElement(By.id("pwd")).sendKeys("rja589");

            //driver.findElement(By.xpath(sign_in_btn)).isDisplayed()

            driver.findElement(By.xpath(sign_in_btn)).click();

            int size = driver.findElements(By.xpath(captcha)).size();

            do {



                //Adhoc
               /* (driver.findElement(By.xpath(sign_in_btn)).isDisplayed())
                {
                    driver.findElement(By.xpath(sign_in_btn)).click();

                    if (size < 0) {


                    }
                }*/

               // driver.findElement(By.xpath(sign_in_btn)).click();


                if(driver.findElements(By.xpath(captcha)).size()>0) {
                    driver.findElement(By.xpath(sign_in_btn)).click();
                }




            }while (size > 0);

            String Login_Successful_Home_Page = "//*[contains(text(),'Select Favourite Journey List')]";

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Login_Successful_Home_Page)));

          //  NEW DELHI - NDLS

            String from = "//input[@type= 'text' and @placeholder='From*']"; //NEW DELHI - NDLS

            driver.findElement(By.xpath(from)).sendKeys("NEW DELHI - NDLS");

            String To = "//input[@type= 'text' and @placeholder='To*']";  //BHAGALPUR - BGP

            driver.findElement(By.xpath(To)).sendKeys("BHAGALPUR - BGP");

            String journey_Date = "//input[@type= 'text' and @placeholder='Journey Date(dd-mm-yyyy)*']";  // 14-05-2019

            driver.findElement(By.xpath(journey_Date)).clear();

            String date = properties.getProperty("date");

            //driver.findElement(By.xpath(journey_Date)).clear();

            String date_css = "#divMain p-calendar > span > div > table > tbody > tr:nth-child(3) > td:nth-child(2) > a";

            //driver.findElement(By.xpath(journey_Date)).sendKeys();

            driver.findElement(By.cssSelector(date_css)).click();

            //driver.findElement(By.xpath(journey_Date)).sendKeys(Keys.RETURN);

            String FindTrains = "//button[@label='Find Trains' and @type= 'submit']";  //Click

            driver.findElement(By.xpath(FindTrains)).click();

            // Train Landing Page

            String Train_Landing_Page = "(//button[@type='submit' and contains(text(),'Modify Search')])[1]";

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Train_Landing_Page)));

            //p-dropdown//label/text() . ////*[@id="divMain"]/div/app-train-list/div/div[5]/div/div[2]/div[1]/div[2]/div[2]/div/div[3]/div/div[2]/p-dropdown/div
            String quota_drp = "(//p-dropdown/div)[5]";

            driver.findElement(By.xpath(quota_drp)).click();

            //p-dropdown/div//li[5]/span[contains(text(),'TATKAL')]
            String quota_tatkal = "//p-dropdown/div//li[5]/span[contains(text(),'TATKAL')]";

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(quota_tatkal)));

            driver.findElement(By.xpath(quota_tatkal)).click();


            //Select quota_drp_select = new Select(driver.findElement(By.xpath(quota_drp)));

            //quota_drp_select.selectByVisibleText("TATKAL");

            String train_name= properties.getProperty("train_name");

            String select_train= "//span[@class='trainName' and contains(text(),'"+train_name+"')]";

            //Select Class
            //AC 3 Tier (3A)
            //Sleeper (SL)



            String check_availability = "//span[@class='trainName' and contains(text(),'"+train_name+"')]/../../../../..//*[@id='check-availability']";

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(check_availability)));

            driver.findElement(By.xpath(check_availability)).click();

            //span[@class='trainName' and contains(text(),'ANVT')]/../../../../..

            // //span[@class='trainName' and contains(text(),'ANVT')]/../../../../*[@id='check-availability']




            System.out.println("Landing Sign in Page");


        }


        //Check for Home Page

        // Locator
        //*[@id="loginText"]

        //*[@id="pwd"]

        // capcha
        //*[@id="nlpAnswer"]

        //Please Enter Valid Captcha

        //*[@class="loginError" and contains(text(),'Please Enter Valid Captcha')]






    }
}
