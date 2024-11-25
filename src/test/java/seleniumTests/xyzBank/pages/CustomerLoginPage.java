package seleniumTests.xyzBank.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CustomerLoginPage {

    private static final SelenideElement choseName = $x("//select[@name='userSelect']");
    private static final SelenideElement loginBttn = $x("/html/body/div/div/div[2]/div/form/button");
    private static final SelenideElement depositBttn = $x("//button[@ng-class='btnClass2']");
    private static final SelenideElement withdrawBttn = $x("//button[@ng-class='btnClass3']");
    private static final SelenideElement amount = $x("//input[@type='number']");
    private static final SelenideElement confirmOperation = $x("//button[@type='submit']");
    private static final SelenideElement infoMessage = $x("//span[@class='error ng-binding']");
    private static final SelenideElement currentBankAccount = $x("//select[@ng-hide='noAccount']");
    private static final SelenideElement accountNumberInfo = $x("//div[@ng-hide='noAccount'][1]//strong[@class][1]");
    private static final SelenideElement balanceInfo = $x("//div[@ng-hide='noAccount'][1]//strong[@class][2]");
    private static final SelenideElement currencyInfo = $x("//div[@ng-hide='noAccount'][1]//strong[@class][3]");

    public static void selectNameAndClick(String name) {
        choseName.selectOptionContainingText(name);
        loginBttn.click();
    }

    public static void selectDeposit(String deposit) {
        depositBttn.click();
        amount.setValue(deposit);
        confirmOperation.click();
    }

    public static void selectWithdraw(String withdraw) {
        withdrawBttn.click();
        amount.setValue(withdraw);
        confirmOperation.click();
    }

    public static String currentMessage(int i) {
        return switch (i) {
            case 1 -> "Deposit Successful";
            case 2 -> "Transaction successful";
            case 3 -> "Transaction Failed. You can not withdraw amount more than the balance.";
            default -> null;
        };
    }

    public static SelenideElement getInfoMessage() {
        return infoMessage;
    }

    public static SelenideElement getCurrentBankAccount() {
        return currentBankAccount;
    }
    public static SelenideElement getAccountNumberInfo() {
        return accountNumberInfo;
    }
    public static SelenideElement getBalanceInfo() {
        return balanceInfo;
    }
    public static SelenideElement getCurrencyInfo() {
        return currencyInfo;
    }
}