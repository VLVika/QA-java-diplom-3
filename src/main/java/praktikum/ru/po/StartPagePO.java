package praktikum.ru.po;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.GlobalVariables.WAIT_FIVE;

public class StartPagePO {

    // поле драйвера
    private WebDriver driver;

//url главной страницы

    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

// кнопка войти в аккаунт
    private static final By BUTTON_LOGIN = By.xpath(".//button[text()='Войти в аккаунт']");

// краторная булка
    private static final By CRAT_BUN = By.xpath(".//img[@alt = 'Флюоресцентная булка R2-D3']");

    //конструктор класса
    public StartPagePO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открывает главную страницу")
    public void openStartPage()  {
        new WebDriverWait(driver, WAIT_FIVE)
                .until(ExpectedConditions.presenceOfElementLocated(CRAT_BUN));
    }

    @Step("Получает токен пользователя с UI")
    public String getToken(){
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        String accessToken = localStorage.getItem("accessToken");
        return accessToken;
    }




}
