package com.grid.demo.testsuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jay
 */
public class SauceLabsDemo {

    public WebDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "selenium-build-2ELEY");
        sauceOptions.put("name", "Title Page");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://oauth-eithtprimesep22-8fad1:77234de7-0833-4061-bba3-05b36b3b3e7e@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        driver = new RemoteWebDriver(url, browserOptions);
    }

    @Test
    public void sauceLabTest() throws InterruptedException {
        driver.get("https://demo.nopcommerce.com/");
        System.out.println("title of page is: " + driver.getTitle());
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
