import config.ConfigSetup;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.StepsForSearchForFlights;

import static elements.ElemOfAddProductToBasketCase.buttonFiltersCssSelector;
import static steps.StepsForAddProductToBasket.clickButton;
import static steps.StepsForCityChange.getCurrentUrl;
import static validator.ValidationOfElements.checkText;

public class SearchForFlights extends StepsForSearchForFlights implements ConfigSetup {

    @Test
    @DisplayName("Поиск авиабилетов")
    @Description("Поиск авиабилетов")
    public void searchTickets() {
        clickButton(buttonFiltersCssSelector);

        chooseFilters(filterTripsSelector, filterFlightsSelector);

        String expectedUrl = "https://vmeste.wildberries.ru/avia";
        checkText(expectedUrl, getCurrentUrl());

        String from = "Домодедово";
        enterCity(fieldFromForInput, from);

        String where = "Пулково";
        enterCity(fieldWhereForInput, where);

        enterDateInField();

        choosePassengers();

        clickSearchTickets();

        checkResultsOfSearch();
    }
}