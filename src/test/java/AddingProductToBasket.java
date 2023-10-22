import config.ConfigSetup;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.StepsForAddProductToBasket;

import java.util.ArrayList;

import static validator.ValidationOfElements.checkElementIsEnabled;
import static validator.ValidationOfElements.checkTextOfElement;


public class AddingProductToBasket extends StepsForAddProductToBasket implements ConfigSetup {

    @Test
    @DisplayName("Добавление товара в корзину")
    @Description("Добавление товара в корзину")
    public void addProductToBasket() {
        clickButton(buttonFiltersCssSelector);

        chooseFilters(filterAppliances, homeAppliances, vacuumAndSteamCleaners);

        String expectedTitle = "Пылесосы и пароочистители";
        checkTextOfElement(catalogTitleElement, expectedTitle);

        checkPathOfFilters();

        int indexOfProduct = 0;
        ArrayList<String> dataAboutProduct = addFirstProductToBasket(indexOfProduct);

        int expectedCount = 1;
        checkCountOfProductsInBasket(expectedCount);

        clickButton(buttonBasket);

        checkDataOfProduct(dataAboutProduct);

        checkTotalSum();

        checkElementIsEnabled(buttonToOrderName);
    }
}