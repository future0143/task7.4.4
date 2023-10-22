package elements;

import org.openqa.selenium.By;

public class ElemOfSearchForFlightsCase {

    public static By filterTripsSelector = By.linkText("Путешествия");
    public static By filterFlightsSelector = By.linkText("Авиабилеты");
    public static By fieldFromForInput = By.id("rc_select_0");
    public static By fieldWhereForInput = By.id("rc_select_1");
    public static By fieldDateThere = By.cssSelector("div.ant-picker.selector-form-date input[name='dateFrom']");
    public static By dateContainerSelector = By.className("ant-picker-panels");
    public static By attributeForDates = By.cssSelector("td[title]");
    public static By buttonPassengers = By.cssSelector("div.ant-dropdown-trigger");
    public static By buttonCounter = By.cssSelector("svg[class*='_button-module__icon']");
    public static By buttonSearchTickets = By.cssSelector("button[class*='_button-module__button'][class*='_selector-form-module__button']");
    public static By listOfTicketsSelector = By.cssSelector("div[class*='_tickets-module__tickets']");
    public static By fieldWithTextNoTickets = By.cssSelector("h1[class*='_heading-module__heading']");
}