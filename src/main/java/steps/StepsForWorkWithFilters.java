package steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import elements.ElemOfWorkWithFiltersCase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static steps.StepsForAddProductToBasket.clickButton;
import static util.WorkWithDataOfElements.convertTextPriceToNumber;
import static util.WorkWithDataOfElements.getListOfTextsFromListOfElements;
import static validator.ValidationOfElements.checkListsForSimilarity;
import static validator.ValidationOfElements.checkText;

public class StepsForWorkWithFilters extends ElemOfWorkWithFiltersCase {

    @Step(value = "Применить несколько фильтров")
    public static List<String> applyFilters(String minPrice, String maxPrice) {
        List<String> listOfFilters = new ArrayList<>();

        clickButton(buttonAllFiltersSelector);

        $(minPriceFilterName).setValue(minPrice);
        $(maxPriceFilterName).setValue(maxPrice);
        listOfFilters.add("от " + minPrice + " до " + maxPrice);

        applyOneFilter(deliveryTimeSelector, listOfFilters);

        applyOneFilter(brandFilterSelector, listOfFilters);

        applyOneFilter(screenDiagonalSelector, listOfFilters);

        clickButton(buttonToShowResults);

        return listOfFilters;
    }

    private static void applyOneFilter(By xpath, List<String> listOfFilters) {
        SelenideElement deliveryTime = $(xpath);
        deliveryTime.click();
        listOfFilters.add(deliveryTime.getText().replaceAll("\\d+$", ""));
    }

    @Step(value = "Проверить, что кол-во товара на страница = количеству товара на странице")
    public static void checkCountOfProducts() {
        int countOfProducts = convertTextPriceToNumber($(countOfProductsElementName).getText());
        $$(listProductsAfterFiltersSelector).shouldHave(CollectionCondition.size(countOfProducts));
    }

    @Step(value = "Проверить, что открылась страница с ноутбуками ")
    public static void checkTitleOfPage(String expectedTitle) {
        String text = $(catalogTitle).getText();
        checkText(expectedTitle, text);
    }

    @Step(value = "Проверить, что выбранные фильтры отображаются на странице")
    public static void checkSelectedFiltersOnPage(List<String> listOfFiltersTextExpected) {
        ElementsCollection listOfFiltersActual = $$(tagNameOfFiltersList);

        List<String> listOfFiltersTextActual = getListOfTextsFromListOfElements(listOfFiltersActual);

        checkListsForSimilarity(listOfFiltersTextActual, listOfFiltersTextExpected);
    }
}