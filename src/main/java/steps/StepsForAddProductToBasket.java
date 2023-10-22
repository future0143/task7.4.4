package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import elements.ElemOfAddProductToBasketCase;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static elements.ElemOfWorkWithSearchBarCase.listOfGoodsInProductCardSelector;
import static util.WorkWithDataOfElements.convertTextPriceToNumber;
import static util.WorkWithDataOfElements.getTotalPriceFromListOfWebElements;
import static validator.ValidationOfElements.checkTextOfElement;

public class StepsForAddProductToBasket extends ElemOfAddProductToBasketCase {

    @Step(value = "Нажатие на кнопку")
    public static void clickButton(By selector) {
        $(selector).click();
    }

    @Step(value = "Выбрать фильтры")
    public static void chooseFilters(By firstFilter, By secondFilter, By thirdFilter) {
        $(firstFilter).hover();

        $(secondFilter).hover().click();

        $(thirdFilter).click();
    }

    @Step(value = "Проверить путь фильтра: \"Главная\" - \"Бытовая техника\" - \"Техника для дома\" - \"Пылесосы и пароочистители\"\n")
    public static void checkPathOfFilters() {
        checkTextOfElement(homeLinkPath, "Главная");
        checkTextOfElement(appliancesLinkPath, "Бытовая техника");
        checkTextOfElement(homeAppliancesLinkPath, "Техника для дома");
        checkTextOfElement(vacuumCleanersLinkPath, "Пылесосы и пароочистители");
    }

    @Step(value = "Навести курсор на первый товар из списка и добавить его в корзину")
    public static ArrayList<String> addFirstProductToBasket(int indexOfProduct) {
        $$(listOfGoodsInProductCardSelector).get(indexOfProduct).hover();

        ArrayList<String> dataAboutProduct = getDataAboutProduct();

        $(buttonAddToBasketSelector).click();

        return dataAboutProduct;
    }

    public static ArrayList<String> getDataAboutProduct() {
        String expectedProductName = $(nameOfProductFromList).getText();

        String expectedProductBrand = $(brandOfProductFromList).getText();

        String expectedProductPrice = $(priceOfProductFromList).getText();

        ArrayList<String> dataAboutProduct = new ArrayList<>();
        dataAboutProduct.add(expectedProductName);
        dataAboutProduct.add(expectedProductBrand);
        dataAboutProduct.add(expectedProductPrice);

        return dataAboutProduct;
    }

    @Step(value = "Проверить количество товаров в корзине")
    public static void checkCountOfProductsInBasket(int expectedCount) {
        $(countOfProductsInBasket).shouldHave(Condition.text(String.valueOf(expectedCount)));
    }

    @Step(value = "Проверить, что текст и цена товара соответствует цене и названию товара из предыдущих шагов")
    public static void checkDataOfProduct(ArrayList<String> dataAboutProduct) {
        String expectedProductName = dataAboutProduct.get(0).substring(2);
        String expectedProductBrand = dataAboutProduct.get(1);
        String expectedProductPrice = dataAboutProduct.get(2).trim();

        $(nameOfProductInBasket).shouldHave(Condition.text(expectedProductName));

        $(brandOfProductInBasket).shouldHave(Condition.text(expectedProductBrand));

        $(priceOfProductInBasket).shouldHave(Condition.text(expectedProductPrice));
    }

    @Step(value = "Проверить что \"Итого\" = сумме товара")
    public static void checkTotalSum() {
        ElementsCollection elements = $$(listOfProductsPrices);
        int totalPriceFromListOfWebElements = getTotalPriceFromListOfWebElements(elements);

        String actualSum = String.valueOf(convertTextPriceToNumber($(totalSum).getText()));

        Assertions.assertEquals(String.valueOf(totalPriceFromListOfWebElements), actualSum);
    }
}