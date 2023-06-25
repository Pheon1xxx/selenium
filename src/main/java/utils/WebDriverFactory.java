package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

public class WebDriverFactory {

        public enum Browsers {
        CHROME {
            public WebDriver create(){
                return new ChromeDriver();
            }
        },
        IE {
            public WebDriver create(){
                return new InternetExplorerDriver();
            }
        },
        FIREFOX {
            public WebDriver create() {
                return new FirefoxDriver();
            }
        };

        public WebDriver create(){
            return null;
        }
    }


}

