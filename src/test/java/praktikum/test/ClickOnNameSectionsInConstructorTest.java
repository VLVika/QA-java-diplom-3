package praktikum.test;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import praktikum.ru.po.StartPagePO;

import static praktikum.ru.po.StartPagePO.*;

@DisplayName("Конструктор")
@RunWith(Parameterized.class)
public class ClickOnNameSectionsInConstructorTest {

    By button;
    By bunsButton;

    public ClickOnNameSectionsInConstructorTest(By button, By bunsButton) {
        this.button = button;
        this.bunsButton = bunsButton;
    }

    @Parameterized.Parameters(name = "{index}: В Конструкторе переходим в раздел {0}, затем в раздел {1}")
    public static Object[][] getTestsData() {
        return new Object[][]{
                {BUTTON_SAUCES, BUTTON_BUNS},
                {BUTTON_FILLING, BUTTON_BUNS},
        };
    }


    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    public void clickOnNameSectionsInConstructorTest() {
        StartPagePO startPage = new StartPagePO(driverRule.getDriver());
        startPage.openStartPage();
        startPage.checkGoToStartPage();
        startPage.clickOnButton(button);
        startPage.checkSuccessfulTransitionToSection(button);
        startPage.clickOnButton(bunsButton);
        startPage.checkSuccessfulTransitionToSection(bunsButton);

    }

}
