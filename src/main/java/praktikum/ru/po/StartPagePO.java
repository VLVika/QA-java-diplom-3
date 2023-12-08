package praktikum.ru.po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.GlobalVariables.*;

public class StartPagePO {

    // поле драйвера
    private WebDriver driver;


    // краторная булка
    private static final By CRAT_BUN = By.xpath(".//img[@alt = 'Флюоресцентная булка R2-D3']");

    //кн Соусы в конструкторе
    private static final By BUTTON_SAUCES = By.xpath(".//span[text()='Соусы']");

    //кн Соусы в конструкторе
    private static final By BUTTON_FILLING = By.xpath(".//span[text()='Начинки']");

    //кн Соусы в конструкторе
    private static final By BUTTON_BUNS = By.xpath(".//span[text()='Булки']");

    //конструктор класса
    public StartPagePO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверяет что произошел переход на главную страницу")
    public void checkGoToStartPage()  {
        new WebDriverWait(driver, WAIT_FIVE)
                .until(ExpectedConditions.presenceOfElementLocated(CRAT_BUN));
    }

    @Step("Открывает стартовую страницу")
    public void openStartPage(){
        driver.get(START_PAGE_URL);
        checkGoToStartPage();
    }

    @Step("Нажимает на кнопку")
    public void clickOnButton(By button){
        driver.findElement(button).click();
    }


    @Step("Получает токен пользователя с UI")
    public String getToken(){
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        String accessToken = localStorage.getItem("accessToken");
        return accessToken;
    }




}
