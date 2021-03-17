import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class InstockTest {

    private static final String PRODUCT_LABEL = "test_label";

    private ProductStock stock;
    private Product testProduct;
    private Product[] products;

    @Before
    public void setUp() {
        this.stock = new Instock();
        this.testProduct = new Product(PRODUCT_LABEL, 10, 1);
    }

    @Test
    public void testAddShouldSaveProduct() {
        stock.add(testProduct);
        assertTrue(stock.contains(testProduct));
    }

    @Test
    public void testContains() {
        assertFalse(stock.contains(testProduct));
        stock.add(testProduct);
        assertTrue(stock.contains(testProduct));
    }

    @Test
    public void testCountShouldReturnOneForSingleProduct() {
        stock.add(testProduct);
        assertEquals(1, stock.getCount());
    }

    @Test
    public void testCountShouldReturnTenForTenProducts() {
        int expectedProductCount = 10;
        addProductsToStock(expectedProductCount);
        assertEquals(expectedProductCount, stock.getCount());
    }

    @Test
    public void testCountShouldReturnZeroWhenEmpty() {
        assertEquals(0, stock.getCount());
    }

    @Test
    public void testFindByIndexShouldReturnCorrectElementWhenOnlyOne() {
        stock.add(testProduct);
        assertProductsAreEqual(testProduct, stock.find(0));
    }

    @Test
    public void testFindByIndexShouldReturnCorrectElementWhenTenProductsAreAdded() {
        addProductsToStock(10);
        assertProductsAreEqual(products[products.length - 1], stock.find(products.length - 1));
    }

    @Test
    public void testFindByIndexShouldReturnCorrectElementWhenTenProductsAreAddedAndWeTakeProductInTheMiddle() {
        addProductsToStock(10);
        assertProductsAreEqual(products[(products.length - 1) / 2], stock.find((products.length - 1) / 2));
    }

    @Test
    public void testFindByIndexShouldReturnCorrectProductsWhenAllIndexesAreFetched() {
        addProductsToStock(10);
        for (int i = 0; i < 10; i++) {
            assertProductsAreEqual(products[i], stock.find(i));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByIndexWhenEmpty() {
        this.stock.find(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByNegativeIndex() {
        this.stock.find(-1);
    }

    @Test
    public void testChangeQuantityShouldSetNewValue() {
        int newQuantity = testProduct.getQuantity() + 10;
        stock.add(testProduct);
        stock.changeQuantity(testProduct.getLabel(), newQuantity);
        assertEquals(newQuantity, testProduct.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityWithEmptyStock() {
        stock.changeQuantity(testProduct.getLabel(), 100);
    }

    @Test
    public void testFindByLabelShouldReturnTheSameProduct() {
        stock.add(testProduct);
        Product actual = stock.findByLabel(testProduct.getLabel());
        assertProductsAreEqual(testProduct, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelShouldFailWithFakeLabel() {
        addProductsToStock(10);
        stock.findByLabel("None-Existing-Label");
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnCorrectElements() {
        addProductsToStock(10);

        List<Product> expected = Arrays.stream(products)
                .sorted(Comparator.comparing(Product::getLabel))
                .limit(5)
                .collect(Collectors.toList());

        Iterable<Product> iter = stock.findFirstByAlphabeticalOrder(expected.size());

        assertNotNull(iter);

        List<Product> actual = new ArrayList<>();

        iter.forEach(actual::add);

        assertEquals(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            assertProductsAreEqual(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyListWhenCountIsGreaterThanProductsStored() {
        addProductsToStock(10);
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(11);
        assertNotNull(iterable);
        AtomicInteger counter = new AtomicInteger();
        iterable.forEach(p -> counter.incrementAndGet());
        assertEquals(0, counter.get());
    }

    @Test
    public void testFindAllInPriceRangeShouldReturnCorrectPriceRange() {
        addProductsToStock(10);

        Iterable<Product> iterable = stock.findAllInRange(13, 17);

        assertNotNull(iterable);

        List<Product> actual = new ArrayList<>();

        iterable.forEach(actual::add);

        assertEquals(4, actual.size());

        assertTrue(actual.stream().noneMatch(p -> p.getPrice() <= 13 || p.getPrice() > 17));
    }

    @Test
    public void testFindAllInPriceRangeShouldReturnCorrectPriceRangeAndOrderedDescending() {
        addProductsToStock(10);

        List<Product> expected = Arrays.stream(products)
                .filter(p -> p.getPrice() > 13 && p.getPrice() <= 17)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());

        Iterable<Product> iterable = stock.findAllInRange(13, 17);

        assertNotNull(iterable);

        List<Product> actual = new ArrayList<>();

        iterable.forEach(actual::add);

        assertEquals(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            assertProductsAreEqual(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void testFindAllInPriceRangeShouldReturnEmptyCollectionWhenNoProductsInRange() {
        addProductsToStock(10);

        Iterable<Product> iterable = stock.findAllInRange(19, 100);

        assertNotNull(iterable);

        List<Product> actual = new ArrayList<>();

        iterable.forEach(actual::add);

        assertTrue(actual.isEmpty());
    }

    @Test
    public void testFindAllByPriceShouldReturnOnlyProductsWithTheSamePrice() {
        addProductsToStock(5);

        for (int i = 0; i < products.length; i++) {
            products[i].setPrice(100);
        }

        Iterable<Product> iterable = stock.findAllByPrice(100);

        assertNotNull(iterable);

        List<Product> actual = getListFromIterable(iterable);

        assertEquals(5, actual.size());

        assertTrue(actual.stream().noneMatch(p -> p.getPrice() != 100));
    }

    @Test
    public void testFindAllByPriceShouldReturnEmptyCollectionWhenNoneMatch() {
        addProductsToStock(5);

        Iterable<Product> iterable = stock.findAllByPrice(100);

        assertNotNull(iterable);

        List<Product> actual = getListFromIterable(iterable);

        assertTrue(actual.isEmpty());
    }

    @Test
    public void testFindFirstMostExpensiveProductsShouldReturnCorrectItems() {
        addProductsToStock(20);

        List<Product> expected = Arrays.stream(products)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(10)
                .collect(Collectors.toList());

        Iterable<Product> iterable = stock.findFirstMostExpensiveProducts(10);

        assertNotNull(iterable);

        List<Product> actual = getListFromIterable(iterable);

        assertListsOfProductsAreEqual(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsShouldFailWithCountLargerThanProductsStored() {
        addProductsToStock(20);
        stock.findFirstMostExpensiveProducts(21);
    }

    @Test
    public void testFindAllByQuantityShouldReturnOnlyProductsWithTheSameQuantity() {
        addProductsToStock(12);

        List<Product> expected = new ArrayList<>();

        for (int i = 6; i < 12; i++) {
            products[i].setQuantity(73);
            expected.add(products[i]);
        }

        Iterable<Product> iterable = stock.findAllByQuantity(73);

        assertNotNull(iterable);

        List<Product> actual = getListFromIterable(iterable);

        assertListsOfProductsAreEqual(expected, actual);
    }

    @Test
    public void testFindAllByQuantityShouldReturnEmptyCollectionWhenNoneMatchesTheQuantityParameter() {
        addProductsToStock(12);

        Iterable<Product> iterable = stock.findAllByQuantity(73);

        assertNotNull(iterable);

        List<Product> actual = getListFromIterable(iterable);

        assertTrue(actual.isEmpty());
    }

    @Test
    public void testIteratorShouldReturnAllProductsInStock() {
        addProductsToStock(15);

        List<Product> expected = Arrays.asList(this.products);

        Iterator<Product> iterator = stock.iterator();

        List<Product> actual = new ArrayList<>();

        while (iterator.hasNext()) {
            actual.add(iterator.next());
        }

        assertListsOfProductsAreEqual(expected, actual);
    }

    @Test
    public void testIteratorShouldReturnEmptyIterator() {
        Iterator<Product> iterator = stock.iterator();
        assertFalse(iterator.hasNext());
    }

    private void addProductsToStock(int count) {
        products = new Product[count];
        for (int i = 0; i < count; i++) {
            products[i] = new Product("" + i, i + 10, i);
            stock.add(products[i]);
        }
    }

    private <T> List<T> getListFromIterable(Iterable<T> iterable) {
        List<T> list = new ArrayList<>();

        iterable.forEach(list::add);

        return list;
    }

    private void assertProductsAreEqual(Product expected, Product actual) {
        assertEquals(expected.getLabel(), actual.getLabel());
        assertEquals(expected.getPrice(), actual.getPrice(), 0.00);
        assertEquals(expected.getQuantity(), actual.getQuantity());
    }

    private void assertListsOfProductsAreEqual(List<Product> expected, List<Product> actual) {
        assertEquals(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            assertProductsAreEqual(expected.get(i), actual.get(i));
        }
    }
}