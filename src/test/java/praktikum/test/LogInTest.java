package praktikum.test;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import praktikum.ru.basemethod.CreateDeleteUser;
import praktikum.ru.po.BaseMethodPO;
import praktikum.ru.po.LogInPagePO;
import praktikum.ru.po.PersonalAccountPO;
import praktikum.ru.po.StartPagePO;

import static praktikum.ru.po.RegPagePO.BUTTON_REG;
import static praktikum.ru.po.RegPagePO.REG_PAGE_URL;
import static praktikum.ru.po.StartPagePO.START_PAGE_URL;
import static utils.GlobalVariables.*;

@DisplayName("Проверка логина по разным кнопкам")
@RunWith(Parameterized.class)
public class LogInTest extends CreateDeleteUser {

    String url;
    By button;
    By elementPage;


    public LogInTest(String url, By button, By elementPage){
        this.url = url;
        this.button = button;
        this.elementPage = elementPage;
    }



    @Parameters(name = "{index}: Логинится через кн Вход со страницы {1}")
    public static Object[][] getTestsData(){
        return new Object[][] {
                {START_PAGE_URL, BUTTON_PERS_AC, BUTTON_PERS_AC},
                {START_PAGE_URL, BUTTON_LOGIN_ACC, BUTTON_LOGIN_ACC},
                {REG_PAGE_URL, BUTTON_REG, BUTTON_LOGIN_ON_REG_PAGE},

        };
    }


    @Rule
    public DriverRule driverRule = new DriverRule();


    @DisplayName("Проверяет вход в приложение через {elementPage}")
    @Test
    public void switchFromDifferentButton() {
        BaseMethodPO rightPageNow = new BaseMethodPO(driverRule.getDriver());
        rightPageNow.openPage(url, button);
        rightPageNow.clickOnButton(elementPage);

        LogInPagePO logInPage = new LogInPagePO(driverRule.driver);
        logInPage.checkOpenPage();
        logInPage.logInUser(email, password);

        StartPagePO startPage = new StartPagePO(driverRule.driver);
        startPage.checkGoToStartPage();
        startPage.clickOnButton(BUTTON_PERS_AC);

        PersonalAccountPO persAccount = new PersonalAccountPO(driverRule.driver);
        persAccount.checkGoToPersonalAcc();

        Assert.assertEquals("Ошибка! Не получилось залогиниться по кнопке --->" + button, email, persAccount.getTextFromFieldEmail());
    }



}
