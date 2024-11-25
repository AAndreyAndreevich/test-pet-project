package seleniumTests.xyzBank.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private static final SelenideElement homeButton = $x("//button[@class='btn home']");
    private static final SelenideElement customerLoginButton = $x("//button[@ng-click='customer()']");
    private static final SelenideElement bankManagerLoginButton = $x("//button[@ng-click='manager()']");

    public MainPage() {
        Selenide.open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    public void homeClick() {
        homeButton.click();
    }

    public void customerLogin() {
        customerLoginButton.click();
    }

    public void bankManagerLogin() {
        bankManagerLoginButton.click();
    }
}
