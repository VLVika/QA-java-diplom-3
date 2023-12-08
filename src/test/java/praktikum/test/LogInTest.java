package praktikum.test;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import praktikum.ru.po.BaseMethodPO;
import praktikum.ru.po.LogInPagePO;
import praktikum.ru.po.PersonalAccountPO;
import praktikum.ru.po.StartPagePO;

import static utils.GlobalVariables.*;

@DisplayName("Проверка логина по разным кнопкам")
@RunWith(Parameterized.class)
public class LogInTest extends CreateDeleteUser{

    String url;
    By button;
    By elementPage;


    public LogInTest(String url, By button, By elementPage){
        this.url = url;
        this.button = button;
        this.elementPage = elementPage;
    }



    @Parameters
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
    public void switchFromDifferentButton() throws InterruptedException {
        BaseMethodPO baseMethodPO = new BaseMethodPO(driverRule.getDriver());
        baseMethodPO.openPage(url, button);
        baseMethodPO.clickOnButton(elementPage);

        LogInPagePO logInPagePO = new LogInPagePO(driverRule.driver);
        logInPagePO.checkOpenPage();
        logInPagePO.logInUser(email, password);

        StartPagePO startPagePO = new StartPagePO(driverRule.driver);
        startPagePO.checkGoToStartPage();
        startPagePO.clickOnButton(BUTTON_PERS_AC);

        PersonalAccountPO persAccMO = new PersonalAccountPO(driverRule.driver);
        persAccMO.checkGoToPersonalAcc();

        Assert.assertEquals("Ошибка! Не получилось залогиниться по кнопке --->" + button, email, persAccMO.getTextFromFieldEmail());
    }



}
