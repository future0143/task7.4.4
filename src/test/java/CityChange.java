import config.ConfigSetup;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.StepsForCityChange;

import static elements.ElemOfCityChangeCase.*;
import static steps.StepsForAddProductToBasket.clickButton;
import static validator.ValidationOfElements.*;


public class CityChange extends StepsForCityChange implements ConfigSetup {

    @Test
    @DisplayName("Смена города")
    @Description("Смена города")
    public void changeCity() {
        String urlHomePage = getCurrentUrl();
        clickButton(cssSelectorForCity);

        String cityForInput = "Санкт-Петербург";
        inputCityInSearchLine(searchCityLine, cityForInput);

        String firstAddress = chooseFirstAddressFromList(cityForInput);

        checkElementIsVisible(infoAboutPickUpPoint);

        checkTextOfElement(addressOnInfoPoint, firstAddress);

        clickButton(buttonChoosePoint);

        String currentUrlAfterChoosing = getCurrentUrl();
        checkText(urlHomePage, currentUrlAfterChoosing);

        checkTextOfElement(cssSelectorForCity, firstAddress);
    }
}