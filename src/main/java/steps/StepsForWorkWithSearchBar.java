package steps;

import elements.ElemOfWorkWithSearchBarCase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class StepsForWorkWithSearchBar extends ElemOfWorkWithSearchBarCase {

    @Step(value = "Поиск текста на странице")
    public static String findTextOfElement(By path) {
        return $(path).getText();
    }

    @Step(value = "Поиск наименования бренда первого товара из найденного списка товаров")
    public static String findBrandOfFirstProduct(int indexOfProduct) {
        return $$(listOfGoodsInProductCardSelector).get(indexOfProduct).$(brandOfProduct).getText();
    }
}