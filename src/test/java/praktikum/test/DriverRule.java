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
    private final String browser = getProp("browser");
    private final String chromeDriver =  getProp("chromeDriver");
    private final String chromeBinary = getProp("chromeBinary");
    private final String yandexDriver = getProp("yandexDriver");
    private final String yandexBinary = getProp("yandexBinary");



    @Override
        protected void before() throws IOException {

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
                    .usingDriverExecutable(new File(System.getProperty("webdriver.yandex.driver", yandexDriver)))
                    .build();
            ChromeOptions options = new ChromeOptions()
                    .setBinary(System.getProperty("webdriver.yandex.binary", yandexBinary));

            driver = new ChromeDriver();


        }

    @Override
    protected void after() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    }
