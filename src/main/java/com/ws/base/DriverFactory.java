package com.ws.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    public WebDriver driver;
    public static ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();

    /**
     * this method is used to initialize the thread-local driver on the basis of given browser
     * @param browser
     * @return WebDriver
     */
    public WebDriver init_driver(String browser) {
        System.out.println("browser used : " + browser);
        if(browser.trim().equalsIgnoreCase("chrome")) {
            localDriver.set(new ChromeDriver());
        }
        else if(browser.trim().equalsIgnoreCase("firefox")) {
            localDriver.set(new FirefoxDriver());
        }
        else if(browser.trim().equalsIgnoreCase("edge")) {
            localDriver.set(new EdgeDriver());
        }
        else
        {
            System.out.println("invalid browser reference : " + browser);
        }
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return getDriver();
    }

    /**
     * this method is used to get the driver with thread-local
     * @return WebDriver
     */
    public static synchronized WebDriver getDriver() {
        return localDriver.get();
    }


    



}
