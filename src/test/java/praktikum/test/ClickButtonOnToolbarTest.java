package praktikum.test;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import praktikum.ru.basemethod.CreateDeleteUser;
import praktikum.ru.po.BaseMethodPO;
import praktikum.ru.po.LogInPagePO;
import praktikum.ru.po.PersonalAccountPO;
import praktikum.ru.po.StartPagePO;

import static utils.GlobalVariables.*;


@DisplayName("Кнопки ToolBar")
@RunWith(Parameterized.class)
public class ClickButtonOnToolbarTest extends CreateDeleteUser {

    By button;

    public ClickButtonOnToolbarTest(By button){
        this.button=button;
    }

    @Parameterized.Parameters
    public static Object[][] getTestsData(){
        return new Object[][] {
                {LOGO_STELLA_BURGERS},
                {BUTTON_DESIGNER},
        };
    }


    @Rule
    public DriverRule driverRule = new DriverRule();


    @DisplayName("Переход по клику на «Конструктор» и на логотип Stellar Burgers")
    @Test
    public void clickButtonDesignerOrLogStellarBurgers(){

        LogInPagePO logInPage = new LogInPagePO(driverRule.getDriver());
        logInPage.openLoginPage();
        logInPage.logInUser(email,password);

        StartPagePO startPage = new StartPagePO(driverRule.driver);
        startPage.checkGoToStartPage();
        startPage.clickOnButton(BUTTON_PERS_AC);

        PersonalAccountPO persAccountPage = new PersonalAccountPO(driverRule.driver);
        persAccountPage.checkGoToPersonalAcc();

        BaseMethodPO mainToolbar = new BaseMethodPO(driverRule.driver);
        mainToolbar.clickOnButton(button);

        startPage.checkGoToStartPage();
    }


}
