package elements;

import org.openqa.selenium.By;

public class ElemOfAddProductToBasketCase {

    public static By buttonFiltersCssSelector = By.cssSelector(".j-menu-burger-btn");
    public static By filterAppliances = By.linkText("Бытовая техника");
    public static By homeAppliances = By.xpath("//span[contains(text(), 'Техника для дома')]");
    public static By vacuumAndSteamCleaners = By.linkText("Пылесосы и пароочистители");
    public static By homeLinkPath = By.xpath("//a[@href='/']/span[@itemprop='name']");
    public static By appliancesLinkPath = By.xpath("//a[@href='/catalog/bytovaya-tehnika']/span[@itemprop='name']");
    public static By homeAppliancesLinkPath = By.xpath("//a[@href='/catalog/elektronika/tehnika-dlya-doma']/span[@itemprop='name']");
    public static By vacuumCleanersLinkPath = By.xpath("//span[@itemprop='name'][text()='Пылесосы и пароочистители']");
    public static By buttonAddToBasketSelector = By.cssSelector("a.product-card__add-basket");
    public static By buttonBasket = By.cssSelector("div.navbar-pc__item.j-item-basket");
    public static By nameOfProductInBasket = By.cssSelector(".good-info__good-name");
    public static By brandOfProductInBasket = By.cssSelector(".good-info__good-brand");
    public static By priceOfProductInBasket = By.cssSelector(".list-item__price-new");
    public static By brandOfProductFromList = By.cssSelector(".product-card__brand");
    public static By nameOfProductFromList = By.cssSelector(".product-card__name");
    public static By priceOfProductFromList = By.cssSelector(".price__lower-price");
    public static By totalSum = By.cssSelector("p.b-top__total span[data-jsv]");
    public static String countOfProductsInBasket = "span.navbar-pc__notify";
    public static By listOfProductsPrices = By.cssSelector("div.accordion__list-item div.list-item__price-new");
    public static By buttonToOrderName = By.cssSelector("[name='ConfirmOrderByRegisteredUser']");
    public static By catalogTitleElement = By.xpath("//h1[@class='catalog-title']");
}