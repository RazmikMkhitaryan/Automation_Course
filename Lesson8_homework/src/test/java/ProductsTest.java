import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTest {
    public int pagesCount = 1;
    public int productsCount;

    /**
     * This test is checking all products count
     */
    @Test(priority = 2)
    public void AllProductsTest() {
        CreatePage createPage = new CreatePage();
        createPage.openCreatePage();
        createPage.goToProducts();
        AllProductsPage allProductsPage = new AllProductsPage();
        allProductsPage.scrollToElement();
      //  assertTrue(allProductsPage.isElelemtVisible(), "Scroll does not work");

        productsCount = allProductsPage.allPageProducts();
        allProductsPage.goToNextPage();
        productsCount = productsCount + allProductsPage.allPageProducts();
        allProductsPage.scrollToElement();
        allProductsPage.goToNextPage();
        productsCount = productsCount + allProductsPage.allPageProducts();
        allProductsPage.scrollToElement();
        allProductsPage.goToNextPage();
        productsCount = productsCount + allProductsPage.allPageProducts();

        assertEquals(productsCount, 73, "some elements are missing");

    }


    /**
     * This test is checking pages count correctness
     */
    @Test(priority = 1)
    public void allPagesTest(){
        AllProductsPage allProductsPage = new AllProductsPage();
        allProductsPage.openAllProducts();
        allProductsPage.scrollToElement();
        pagesCount = allProductsPage.goToNextPage(pagesCount);
        allProductsPage.scrollToElement();
        pagesCount = pagesCount + allProductsPage.goToNextPage(pagesCount);
        allProductsPage.scrollToElement();
        pagesCount = pagesCount + allProductsPage.goToNextPage(pagesCount);

        assertEquals(pagesCount, allProductsPage.numberOfPage(), "Pages count is not true");

    }

}
