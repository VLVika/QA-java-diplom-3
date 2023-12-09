package praktikum.test;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import praktikum.ru.basemethod.CreateDeleteUser;
import praktikum.ru.po.LogInPagePO;
import praktikum.ru.po.PersonalAccountPO;
import praktikum.ru.po.StartPagePO;

import static praktikum.ru.po.PersonalAccountPO.BUTTON_PERS_AC;

@DisplayName("Выход из ЛК")
public class LogOutTest extends CreateDeleteUser {


    @Rule
    public DriverRule driverRule = new DriverRule();


    @DisplayName("Выход из аккаунта по кнопке «Выйти» в личном кабинете")
    @Test
    public void goToPersonalAccount() {

        LogInPagePO logInPage = new LogInPagePO(driverRule.getDriver());
        logInPage.openLoginPage();
        logInPage.logInUser(email, password);

        StartPagePO startPage = new StartPagePO(driverRule.driver);
        startPage.checkGoToStartPage();
        startPage.clickOnButton(BUTTON_PERS_AC);

        PersonalAccountPO perslAccount = new PersonalAccountPO(driverRule.driver);
        perslAccount.checkGoToPersonalAcc();
        perslAccount.clickOnButtonLogOut();

        logInPage.checkOpenPage();


    }


}
