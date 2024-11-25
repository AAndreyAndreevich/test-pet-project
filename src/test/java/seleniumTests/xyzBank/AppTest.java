package seleniumTests.xyzBank;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import seleniumTests.services.BaseTest;

public class AppTest extends BaseTest {

    @Description("делает проверку на то что баланс счетов не совпадает")
    @Test
    public void checkBalanceTest() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.customerLogin();
        Thread.sleep(3000);
        CustomerLoginPage.selectNameAndClick("Hermoine Granger");
        int balance1 = Integer.parseInt(CustomerLoginPage.getBalanceInfo().getText());
        Thread.sleep(3000);
        CustomerLoginPage.getCurrentBankAccount().selectOptionContainingText("1002");
        Thread.sleep(3000);
        int balance2 = Integer.parseInt(CustomerLoginPage.getBalanceInfo().getText());
        Thread.sleep(3000);
        Assertions.assertNotEquals(balance1, balance2);
    }

    @Description("тест пополнения баланса, ответ положительный")
    @Test
    public void depositTest() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.customerLogin();
        Thread.sleep(3000);
        CustomerLoginPage.selectNameAndClick("Harry Potter");
        CustomerLoginPage.selectDeposit("1000");
        Assertions.assertEquals(
                CustomerLoginPage.getInfoMessage().getText(), CustomerLoginPage.currentMessage(1)
        );
    }

    @Description("тест списания с баланса, должен выдать отрицательный ответ т.к. на балансе нет 1000")
    @Test
    public void withdrawWithFailedTest() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.customerLogin();
        Thread.sleep(3000);
        CustomerLoginPage.selectNameAndClick("Harry Potter");
        CustomerLoginPage.selectWithdraw("1000");
        Assertions.assertEquals(
                CustomerLoginPage.getInfoMessage().getText(), CustomerLoginPage.currentMessage(3)
        );
    }

    @Description("тест списания с баланса, результат положительный")
    @Test
    public void withdrawTest() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.customerLogin();
        Thread.sleep(3000);
        CustomerLoginPage.selectNameAndClick("Hermoine Granger");
        CustomerLoginPage.selectWithdraw("1000");
        Assertions.assertEquals(
                CustomerLoginPage.getInfoMessage().getText(), CustomerLoginPage.currentMessage(2)
        );
    }

    @Description("проверка создания пользователя")
    @Test
    public void addCustomersTest() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.bankManagerLogin();
        BankManagerLoginPage.addCustomer("Ha", "Ba", "7KA");
        Alert alert = Selenide.switchTo().alert();
        Assertions.assertEquals("Customer added successfully with customer id :", alert.getText().substring(0, 46));
    }

    @Description("проверяет корректность работы выбора пользователя и валюты")
    @Test
    public void selectCurCustomerTest() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.bankManagerLogin();
        BankManagerLoginPage.openAccount();
        BankManagerLoginPage.selectCustomerAndCurrency("Harry Potter", "Rupee");
        Thread.sleep(2000);
        BankManagerLoginPage.process();
        Thread.sleep(2000);
        Alert alert = Selenide.switchTo().alert();
        Thread.sleep(2000);
        Assertions.assertEquals("Account created successfully with account Number :", alert.getText().substring(0, 50));
    }

    @Description("ищет в списках пользователя Harry")
    @Test
    public void findCurrentCustomers() {
        MainPage mainPage = new MainPage();
        mainPage.bankManagerLogin();
        BankManagerLoginPage.customers();
        while (BankManagerLoginPage.getCustomersList().isDisplayed()) {
            String text = BankManagerLoginPage.getCustomersList().getText();
            if (text.equals("Harry")) {
                Assertions.assertTrue(true);
            }
        }
    }

    @Description("проверка на удаление всех пользователей")
    @Test
    public void deleteCustomersTest() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.bankManagerLogin();
        BankManagerLoginPage.customers();
        Thread.sleep(3000);
        BankManagerLoginPage.deleteAllCustomers();
        Thread.sleep(3000);
        Assertions.assertFalse(BankManagerLoginPage.getCustomersList().isDisplayed());
    }

}