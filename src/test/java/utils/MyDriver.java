package utils;
// Recordar! Click derecho al proyecto 
// y Build with Dependencies para instalar las dependencias.
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyDriver {
    private WebDriver driver;
    
    public MyDriver(String browser) {
        if ("firefox".equals(browser)) {
            driver = new FirefoxDriver();
        } else {
            String path = System.getProperty("user.dir");
            System.out.println(path);
            System.setProperty("webdriver.chrome.driver",path+"\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}