package elements;

import org.openqa.selenium.By;

public class ElemOfWorkWithFiltersCase {

    public static By filterElectronicsSelector = By.linkText("Электроника");
    public static By filterLaptopsAndPC = By.xpath("//span[contains(text(), 'Ноутбуки и компьютеры')]");
    public static By filterLaptops = By.linkText("Ноутбуки");
    public static By buttonAllFiltersSelector = By.cssSelector(".dropdown-filter__btn--all");
    public static By minPriceFilterName = By.name("startN");
    public static By maxPriceFilterName = By.name("endN");
    public static By deliveryTimeSelector = By.xpath("//*[contains(text(), 'до 3 дней')]");
    public static By brandFilterSelector = By.xpath("//span[contains(text(), 'Apple')]");
    public static By screenDiagonalSelector = By.xpath("//span[contains(text(), '13.3\"')]");
    public static By buttonToShowResults = By.cssSelector(".filters-desktop__btn-main");
    public static By listOfSelectedFilters = By.cssSelector(".your-choice__list");
    public static By buttonToResetFilters = By.xpath("//button[text()='Сбросить все']");
    public static By tagNameOfFiltersList = By.tagName("li");
    public static By listProductsAfterFiltersSelector = By.className("product-card");
    public static By countOfProductsElementName = By.className("goods-count");
    public static By catalogTitle = By.xpath("//h1[@class='catalog-title']");
}