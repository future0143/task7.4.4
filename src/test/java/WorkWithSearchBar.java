import config.ConfigSetup;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.StepsForWorkWithSearchBar;

import static steps.StepsForAddProductToBasket.clickButton;
import static steps.StepsForCityChange.inputCityInSearchLine;
import static validator.ValidationOfElements.checkFieldIsEmpty;
import static validator.ValidationOfElements.checkText;

public class WorkWithSearchBar extends StepsForWorkWithSearchBar implements ConfigSetup {

    @Test
    @DisplayName("Работа с поисковой строкой")
    @Description("Работа с поисковой строкой")
    public void workWithSearchBar() {
        String keys = "iphone 13";
        inputCityInSearchLine(searchLineSelector, keys);

        checkText(keys, findTextOfElement(pathNameOfCatalog));

        String expectedTextOfSorterFilter = "По популярности";
        checkText(expectedTextOfSorterFilter, findTextOfElement(filterOfSorter));

        checkText(keys, findTextOfElement(firstFilter));

        int indexOfGoods = 0;
        String brandOfFirstProduct = findBrandOfFirstProduct(indexOfGoods);
        checkText("Apple", brandOfFirstProduct);

        clickButton(buttonSearchBarClear);

        checkFieldIsEmpty(searchLineSelector);
    }
}