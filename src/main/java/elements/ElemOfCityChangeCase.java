package elements;

import org.openqa.selenium.By;

public class ElemOfCityChangeCase {

    public static By cssSelectorForCity = By.cssSelector(".j-geocity-wrap");
    public static By searchCityLine = By.cssSelector("input.ymaps-2-1-79-searchbox-input__input");
    public static By listOfAddress = By.cssSelector(".address-item.j-poo-option");
    public static By addressOfElement = By.cssSelector(".address-item__name-text");
    public static By infoAboutPickUpPoint = By.className("details-self");
    public static By addressOnInfoPoint = By.className("details-self__name-text");
    public static By buttonChoosePoint = By.cssSelector("button[data-link*='onPooSelect']");
}