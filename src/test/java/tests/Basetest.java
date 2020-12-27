package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class Basetest {

    //keeping the driver class as protected because it can be accessed in the child classes
        protected  WebDriver driver;


    @BeforeTest
    public void setupDriver() throws MalformedURLException {


/*        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nshibaha\\Docker\\chromedriver_win32\\chromedriver.exe");
        this.driver =new ChromeDriver();*/

     /*   ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--verbose");
        chromeOptions.addArguments("--whitelisted-ips=''");
        chromeOptions.addArguments("--proxy-server=localhost:4444");*/

        //Browser input required
        //host url input required


        //below two we are declaring incase user is not providing any value

        String host ="localhost";
        DesiredCapabilities dc =  DesiredCapabilities.firefox();


        if(System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc = DesiredCapabilities.firefox();

        }

        else{
            dc = DesiredCapabilities.chrome();
        }
        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }


        String completeUrl = "http://" + host + ":4444/wd/hub";

        this.driver = new RemoteWebDriver(new URL(completeUrl),dc);
    }



    @AfterTest
    public void quitBrowser()
    {
        this.driver.quit();
    }

}
