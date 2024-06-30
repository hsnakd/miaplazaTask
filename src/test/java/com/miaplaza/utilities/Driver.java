package com.miaplaza.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Driver {



    /*
    Creating a private constructor, so we are closing
    access to the object of this class from outside the class
     */
    private Driver(){}

    /*
    We make WebDriver private, because we want to close access from outside the class.
    We make it static because we will use it in a static method.
     */
    //private static WebDriver driver; // value is null by default

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /*
    Create a re-usable utility method which will return same driver instance when we call it
     */
    public static WebDriver getDriver(){

        if (driverPool.get() == null){

            /*
            We read our browserType from configuration.properties.
            This way, we can control which browser is opened from outside our code, from configuration.properties.
             */
            String browserType;
/**            browserType = ConfigurationReader.getProperty("browser");         */

                if (System.getProperty("BROWSER") == null) {
                    browserType = ConfigurationReader.getProperty("browser");
                } else {
                    browserType = System.getProperty("BROWSER");
                }
                System.out.println("Browser Type : " + browserType);

            /*
                Depending on the browserType that will be return from configuration.properties file
                switch statement will determine the case, and open the matching browser
            */

            switch (browserType.toLowerCase()){
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--lang=en-GB");
                    chromeOptions.addArguments("--disable-notifications");
                    chromeOptions.addArguments("--disable-extensions");
                    chromeOptions.addArguments("--ignore-certificate-errors");

                    driverPool.set(new ChromeDriver(chromeOptions));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;


                case "chrome-locale":
                    chromeOptions = new ChromeOptions();
                    Map<String, Object> prefs = new HashMap<>();
                    chromeOptions.addArguments("--disable-notifications");
                    prefs.put("intl.accept_languages", "en-GB");
                    chromeOptions.setExperimentalOption("prefs", prefs);
                    driverPool.set(new ChromeDriver(chromeOptions));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;


                case "chrome-incognito":

                    chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--incognito");  // ChromeOptions for starting chrome in incognito mode
                    chromeOptions.addArguments("--disable-notifications");
                    chromeOptions.addArguments("--lang=en-GB");

                    chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                    chromeOptions.merge(chromeOptions);
                    driverPool.set(new ChromeDriver(chromeOptions));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;


                case "firefox":

                    driverPool.set(new FirefoxDriver());

                    FirefoxOptions optionsFirefox = new FirefoxOptions();
                    FirefoxProfile firefoxProfile = new FirefoxProfile();
                    optionsFirefox.setProfile(firefoxProfile);
                    firefoxProfile.setPreference("intl.accept_languages", "en-GB");

                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

                case "firefox-private":
                    optionsFirefox = new FirefoxOptions();
                    optionsFirefox.addArguments("-private");  // FirefoxOptions for starting firefox in incognito mode
                    DesiredCapabilities capabilitiesFirefox = new DesiredCapabilities();
                    capabilitiesFirefox.setCapability(FirefoxOptions.FIREFOX_OPTIONS, optionsFirefox);
                    optionsFirefox.merge(capabilitiesFirefox);
                    driverPool.set(new FirefoxDriver(optionsFirefox));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;



                case "safari":
                    if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your operating system does not support the SAFARI browser");
                    }
                    driverPool.set(new SafariDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;





            }

        }


        return driverPool.get();

    }

    /*
    This method will make sure our driver value is always null after using quit() method
     */
    public static void closeDriver(){
        if (driverPool.get() != null){
            driverPool.get().quit(); // this line will terminate the existing session. the value will not even be null
            driverPool.remove();
        }
    }

}
