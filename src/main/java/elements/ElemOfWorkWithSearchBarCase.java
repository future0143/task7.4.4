package elements;

import org.openqa.selenium.By;

public class ElemOfWorkWithSearchBarCase {

    public static By searchLineSelector = By.id("searchInput");
    public static By pathNameOfCatalog = By.xpath("//*[@id=\"catalog\"]/div/div[1]/div/h1");
    public static By filterOfSorter = By.cssSelector(".dropdown-filter__btn--sorter");
    public static By firstFilter = By.cssSelector(".dropdown-filter__btn--burger");
    public static By listOfGoodsInProductCardSelector = By.className("product-card");
    public static By brandOfProduct = By.cssSelector(".product-card__brand");
    public static By buttonSearchBarClear = By.cssSelector(".search-catalog__btn--clear");
}