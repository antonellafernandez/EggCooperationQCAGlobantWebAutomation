package utils.baseTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.HomePage;
import utils.MyDriver;

public class BaseTest {
    private MyDriver driver;
    
    // Hacer SIEMPRE una acción antes de que se ejecute un método
    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser", "url"})
    public void beforeMethod(String browser, String url) {
        driver = new MyDriver(browser);
        driver.getDriver().manage().window().maximize(); // Comienza con la ventana maximizada
        navigateTo(url);
    }
    
    // Navegar
    public void navigateTo(String url) {
        driver.getDriver().get(url);
    }
    
    // Cargar la primera página
    public HomePage loadFirstPage() {
        return new HomePage(driver.getDriver());
    }
    
    // Cerrar el driver
    @AfterMethod()
    public void afterMethod() {
        driver.getDriver().close();
    }
}