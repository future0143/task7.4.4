import config.ConfigSetup;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.StepsForWorkWithFilters;

import java.util.List;

import static elements.ElemOfAddProductToBasketCase.buttonFiltersCssSelector;
import static steps.StepsForAddProductToBasket.chooseFilters;
import static steps.StepsForAddProductToBasket.clickButton;
import static validator.ValidationOfElements.checkElementIsVisible;


public class WorkWithFilters extends StepsForWorkWithFilters implements ConfigSetup {

    @Test
    @DisplayName("Работа с фильтрами")
    @Description("Работа с фильтрами")
    public void workWithFilters() {
        clickButton(buttonFiltersCssSelector);

        chooseFilters(filterElectronicsSelector, filterLaptopsAndPC, filterLaptops);

        String expectedTitle = "Ноутбуки и ультрабуки";
        checkTitleOfPage(expectedTitle);

        String minPrice = "100 000";
        String maxPrice = "149 000";
        List<String> listOfFilters = applyFilters(minPrice, maxPrice);

        checkElementIsVisible(listOfSelectedFilters);

        checkCountOfProducts();

        checkSelectedFiltersOnPage(listOfFilters);

        checkElementIsVisible(buttonToResetFilters);
    }
}