package validator;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class ValidationOfElements {

    public static void checkText(String expectedText, String actualText) {
        Assertions.assertEquals(expectedText, actualText);
    }

    public static void checkFieldIsEmpty(By path) {
        $(path).shouldBe(Condition.empty);
    }

    public static void checkListsForSimilarity(List<String> listOfFiltersExpected, List<String> listOfFiltersActual) {
        Assertions.assertFalse(Collections.disjoint(listOfFiltersActual, listOfFiltersExpected));
    }

    public static void checkTextOfElement(By selector, String expectedText) {
        $(selector).shouldHave(Condition.text(expectedText));
    }

    public static void checkElementIsEnabled(By selector) {
        $(selector).shouldBe(Condition.enabled);
    }

    public static void checkElementIsVisible(By selector) {
        $(selector).shouldBe(Condition.visible);
    }

}