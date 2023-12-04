package praktikum.test;

import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import praktikum.ru.api.pojo.CreateUserModelRq;
import praktikum.ru.api.steps.CreateUser;
import praktikum.ru.po.BaseMethodPO;
import praktikum.ru.po.LogInPagePO;
import praktikum.ru.po.PersonalAccountPO;
import praktikum.ru.po.StartPagePO;

import static praktikum.ru.api.steps.DeleteUser.deleteUser;
import static utils.GlobalVariables.*;


@RunWith(Parameterized.class)
public class LogInTest {

    CreateUser create = new CreateUser();
    String accessToken;
    String url;
    String email;
    String password;
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


    @Before
    @DisplayName("Создаёт пользователя, получает token")
    public void getToken(){
        var request = CreateUserModelRq.newUser();
        email= request.getEmail() ;
        password = request.getPassword();
        accessToken = create.getTokenNewUser(request);

    }


    @DisplayName("Удаляет пользователя")
    @After
    public void turnOff(){

        deleteUser(accessToken);
    }

}
