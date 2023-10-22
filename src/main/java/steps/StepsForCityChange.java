package steps;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import elements.ElemOfAddProductToBasketCase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static elements.ElemOfCityChangeCase.addressOfElement;
import static elements.ElemOfCityChangeCase.listOfAddress;

public class StepsForCityChange extends ElemOfAddProductToBasketCase {

    @Step(value = "В поисковую строку ввести текст")
    public static void inputCityInSearchLine(By path, String textForInput) {
        $(path).sendKeys(textForInput);
        $(path).sendKeys(Keys.ENTER);
    }

    @Step(value = "Выбрать первый адрес из списка адресов")
    public static String chooseFirstAddressFromList(String cityForInput) {
        SelenideElement firstAddressElement = $$((listOfAddress)).get(0).shouldHave(text(cityForInput));
        String firstAddress = firstAddressElement.$(addressOfElement).getText();
        firstAddressElement.click();

        return firstAddress;
    }

    @Step(value = "Получение текущего url")
    public static String getCurrentUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }
}