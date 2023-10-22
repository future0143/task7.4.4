package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import elements.ElemOfSearchForFlightsCase;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class StepsForSearchForFlights extends ElemOfSearchForFlightsCase {

    @Step(value = "Выбрать фильтры")
    public static void chooseFilters(By firstFilter, By secondFilter) {
        $(firstFilter).scrollIntoView(true).hover();

        $(secondFilter).click();
    }


    @Step(value = "Ввести в поля откуда/куда наименование города")
    public static void enterCity(By xpath, String text) {
        $(xpath).sendKeys(text);

        $(By.xpath("//div[contains(@label, '" + text + "')]")).click();
    }

    @Step(value = "Ввести в поле \"Дата\" - указать дату")
    public static void enterDateInField() {
        LocalDate nowDate = LocalDate.now();
        LocalDate dateForInput = nowDate.plusDays(2);
        String dateForInputString = dateForInput.toString();

        $(fieldDateThere).click();
        ElementsCollection dateElements = $(dateContainerSelector).$$(attributeForDates);

        for (WebElement dateElement : dateElements) {
            if (dateElement.getAttribute("title").equals(dateForInputString)) {
                dateElement.click();
            }
        }
    }

    @Step(value = "Выбрать два взрослых пассажира")
    public static void choosePassengers() {
        $(buttonPassengers).click();
        $$(buttonCounter).get(1).click();
    }

    @Step(value = "Нажать \"Найти билеты\"")
    public static void clickSearchTickets() {
        $(buttonSearchTickets).click();

        $(listOfTicketsSelector).shouldBe(Condition.visible);
    }

    @Step(value = "Проверить результаты поиска билетов")
    public static void checkResultsOfSearch() {
        String expectedText = "Мы не нашли билеты по вашему запросу";

        ElementsCollection listOfTickets = $$(listOfTicketsSelector);

        if (listOfTickets.size() == 0) {
            $(fieldWithTextNoTickets).shouldHave(Condition.text(expectedText));
        } else {
            Assertions.assertFalse(listOfTickets.isEmpty());
        }
    }
}