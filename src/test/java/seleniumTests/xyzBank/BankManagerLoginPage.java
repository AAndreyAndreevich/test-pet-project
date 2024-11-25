package seleniumTests.xyzBank;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BankManagerLoginPage {

    private static final SelenideElement addCustomerBttn = $x("//button[@ng-click='addCust()']");
    private static final SelenideElement openAccountBttn = $x("//button[@ng-click='openAccount()']");
    private static final SelenideElement customersBttn = $x("//button[@ng-click='showCust()']");
    private static final SelenideElement customersList = $x("//tr[@ng-repeat]//td");
    private static final SelenideElement deleteBttn = $x("//button[@ng-click='deleteCust(cust)']");
    private static final SelenideElement fName = $x("//div[@class='form-group']//input[@ng-model='fName']");
    private static final SelenideElement lName = $x("//div[@class='form-group']//input[@ng-model='lName']");
    private static final SelenideElement postCd = $x("//div[@class='form-group']//input[@ng-model='postCd']");
    private static final SelenideElement confirmAddCustomerBttn = $x("//button[@type='submit']");
    private static final SelenideElement selectCustomer = $x("//*[@id=\"userSelect\"]");
    private static final SelenideElement selectCurrency = $x("//*[@id=\"currency\"]");
    private static final SelenideElement processBttn = $x("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");

    /**
     * удаляет всех пользователей
     */
    public static void deleteAllCustomers() {
        while (deleteBttn.isDisplayed()) {
            deleteBttn.click();
        }
    }

    /**
     * создает нового пользователя
     * @param name имя
     * @param lastName фамилия
     * @param postCode код
     */
    public static void addCustomer(String name, String lastName, String postCode) throws InterruptedException {
        addCustomerBttn.click();
        Thread.sleep(3000);
        fName.setValue(name);
        lName.setValue(lastName);
        postCd.setValue(postCode);
        confirmAddCustomerBttn.click();
    }

    /**
     * открывает счет конкретному пользователю на выбранную валюту
     * @param name имя
     * @param currency валюта
     */
    public static void selectCustomerAndCurrency(String name, String currency) {
        selectCustomer.selectOptionContainingText(name);
        selectCurrency.selectOptionContainingText(currency);
    }

    public static void openAccount() {
        openAccountBttn.click();
    }

    public static void customers() {
        customersBttn.click();
    }

    public static void process() {
        processBttn.click();
    }

    public static SelenideElement getCustomersList() {
        return customersList;
    }
}
