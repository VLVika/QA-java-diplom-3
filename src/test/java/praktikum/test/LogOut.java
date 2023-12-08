package praktikum.test;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import praktikum.ru.po.LogInPagePO;
import praktikum.ru.po.PersonalAccountPO;
import praktikum.ru.po.StartPagePO;

import static utils.GlobalVariables.BUTTON_PERS_AC;

public class LogOut extends CreateDeleteUser{


    @Rule
    public DriverRule driverRule = new DriverRule();


    @DisplayName("Выход из аккаунта по кнопке «Выйти» в личном кабинете")
    @Test
    public void goToPersonalAccount() {

        LogInPagePO logInPagePO = new LogInPagePO(driverRule.getDriver());
        logInPagePO.openLoginPage();
        logInPagePO.logInUser(email, password);

        StartPagePO startPagePO = new StartPagePO(driverRule.driver);
        startPagePO.checkGoToStartPage();
        startPagePO.clickOnButton(BUTTON_PERS_AC);

        PersonalAccountPO perslAccPO = new PersonalAccountPO(driverRule.driver);
        perslAccPO.checkGoToPersonalAcc();
        perslAccPO.clickOnButtonLogOut();

        logInPagePO.checkOpenPage();


    }


}
