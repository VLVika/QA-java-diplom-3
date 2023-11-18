package praktikum.test;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static utils.GetProperties.getProp;

public class DriverRule extends ExternalResource {

    WebDriver driver;
    String browser = getProp("browser");
    String chromeDriver =  getProp("chromeDriver");
    String chromeBinary = getProp("chromeBinary");
    String yandexDriver = getProp("yandexDriver");
    String yandexBinary = getProp("yandexBinary");

    public DriverRule() throws IOException {
    }


    @Override
        protected void before() throws Throwable {

            if ("chrome".equals(browser))
                setUpChrome();

            else if ("yandex".equals(browser))
                setUpYandex();
            else
                setUpChrome();

            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        }

        private void setUpChrome() {
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            ChromeDriverService service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(chromeDriver))
                    .build();


            ChromeOptions options = new ChromeOptions()
                    .setBinary(chromeBinary);

            driver = new ChromeDriver(service, options);
        }

        public void setUpYandex() {
            ChromeDriverService service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(yandexDriver))
                    .build();
            ChromeOptions options = new ChromeOptions()
                    .setBinary(yandexBinary);

            driver = new ChromeDriver(service, options);
        }

    @Override
    protected void after() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    }
