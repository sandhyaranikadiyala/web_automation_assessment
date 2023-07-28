package com.atmecs.assessment.driver;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.atmecs.assessment.constants.ConfigPropertiesKeys;
import com.atmecs.assessment.constants.FilePathConstants;
import com.atmecs.assessment.enums.BrowserType;
import com.atmecs.assessment.utils.PropertyParser;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
    PropertyParser propertyParser;

    /**
     * This method initializes and return a Web Driver instance
     *
     * @return @{@link WebDriver} instance
     */
    public WebDriver getWebDriver() {
        return initWebDriver();
    }

    private WebDriver initWebDriver() {
        propertyParser = new PropertyParser(FilePathConstants.CONFIG_FILE_PATH);
        WebDriver webDriver = null;
        String browserName = propertyParser.getPropertyValue(ConfigPropertiesKeys.BROWSER_NAME_KEY);

        switch (BrowserType.valueOf(browserName)) {
            case chrome:
                webDriver = getChromeDriver();
                break;
            case firefox:
                webDriver = getFirefoxDriver();
                break;
            case safari:
                webDriver = getSafariDriver();
                break;
            case edge:
                webDriver = getEdgeDriver();
                break;
            case ie:
                webDriver = getIEDriver();
                break;
        }

        return webDriver;
    }

    private WebDriver getChromeDriver() {
        WebDriver chromeDriver;
        WebDriverManager.chromedriver().setup();

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", FilePathConstants.DOWNLOADS_FOLDER_PATH);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        chromeDriver = new ChromeDriver(options);

        return chromeDriver;
    }

    private WebDriver getFirefoxDriver() {
        WebDriver firefoxDriver;

        WebDriverManager.firefoxdriver().setup();
        firefoxDriver = new FirefoxDriver();

        return firefoxDriver;
    }

    private WebDriver getIEDriver() {
        WebDriver IEDriver;

        WebDriverManager.iedriver().setup();
        IEDriver = new InternetExplorerDriver();

        return IEDriver;
    }

    private WebDriver getEdgeDriver() {
        WebDriver edgeDriver;

        WebDriverManager.edgedriver().setup();
        edgeDriver = new EdgeDriver();

        return edgeDriver;
    }

    private WebDriver getSafariDriver() {
        WebDriver safariDriver;

        WebDriverManager.safaridriver().setup();
        safariDriver = new SafariDriver();

        return safariDriver;
    }
}
