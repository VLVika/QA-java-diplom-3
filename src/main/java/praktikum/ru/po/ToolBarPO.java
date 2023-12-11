package praktikum.ru.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ToolBarPO extends BaseMethodPO {


    //кн логотипа сайти Стелла Бургерс
    public static final By LOGO_STELLA_BURGERS = By.xpath(".//div[@class = 'AppHeader_header__logo__2D0X2']");

    //кн Конструктор
    public static final By BUTTON_DESIGNER = By.xpath(".//p[text() = 'Конструктор']");

    public ToolBarPO(WebDriver driver) {
        this.driver = driver;
    }
}
