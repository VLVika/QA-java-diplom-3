package praktikum.ru.po;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.GlobalVariables.*;

public class StartPagePO extends BaseMethodPO{

    public static final String START_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    // краторная булка
    private static final By CRAT_BUN = By.xpath(".//img[@alt = 'Флюоресцентная булка R2-D3']");

    //кн Соусы в конструкторе
    public static final By BUTTON_SAUCES = By.xpath(".//span[text()='Соусы']");

    //кн Соусы в конструкторе
    public static final By BUTTON_FILLING = By.xpath(".//span[text()='Начинки']");

    //кн Соусы в конструкторе
    public static final By BUTTON_BUNS = By.xpath(".//span[text()='Булки']");

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

    @Step("Получает токен пользователя с UI")
    public String getToken(){
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        String accessToken = localStorage.getItem("accessToken");
        return accessToken;
    }

    @Step("Проверяет, что успешно перешли на требуемый заголовок")
    public void checkSuccessfulTransitionToSection(By button){
        String parentClass = driver.findElement(button).findElement(By.xpath("./..")).getAttribute("class");
        Assert.assertTrue("Ошибка!! Не перешли на требуемый раздел в Конструкторе",parentClass.contains("current"));
    }




}
