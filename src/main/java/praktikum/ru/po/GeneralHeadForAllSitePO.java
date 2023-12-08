package praktikum.ru.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Data
@AllArgsConstructor @NoArgsConstructor
public class GeneralHeadForAllSitePO {

    // поле драйвера
    private WebDriver driver;

    //кн логотипа сайти Стелла Бургерс
    private static By LOGO_STELLA_BURGERS = By.xpath(".//div[@class = 'AppHeader_header__logo__2D0X2']");

    //кн Конструктор
    private static By BUTTON_DESIGNER = By.xpath(".//p[text() = 'Конструктор']");
}
