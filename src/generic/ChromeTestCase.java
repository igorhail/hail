package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class ChromeTestCase {

    static WebDriver driver;
    private static ChromeOptions options;

    public static WebDriver getDriver(){
        return driver;
    }

    @BeforeClass
    public void before() {
        options = new ChromeOptions();
        options.addArguments("chrome.switches", "--disable-extensions");
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

//    @BeforeTest
//    public void start() {
//        try{
//            driver = new ChromeDriver();
//        } catch (Exception ex){
//            System.out.println(ex);
//        }
//    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }

//    @AfterClass(alwaysRun = true)
//    public void after() {
//        chromeFunctionality.closeChrome();
//    }
//
//    protected void pause(long milis){
//        try {
//            Thread.sleep(milis);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

}