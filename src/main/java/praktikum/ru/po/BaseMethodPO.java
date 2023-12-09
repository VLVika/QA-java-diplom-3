package praktikum.ru.po;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.GlobalVariables.WAIT_FIVE;

@Data
@AllArgsConstructor @NoArgsConstructor
public class BaseMethodPO {

    // поле драйвера
    protected WebDriver driver;

    //Метод открытия страницы
    @Step("Открывает страницу {url}")
    public void openPage(String url, By expectedElement)  {
        driver.get(url);
        new WebDriverWait(driver, WAIT_FIVE)
                .until(ExpectedConditions.presenceOfElementLocated(expectedElement));

    }

    //Метод нажатия на кнопку
    @Step("Нажимает кнопку {button}")
    public void clickOnButton(By button){
        driver.findElement(button).click();
    }
}
