package computers;

import org.junit.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ComputerManagerTests {
    private List<Computer> testComputers;
    private Computer computer;
    private ComputerManager computerManager;

    @Before
    public void SetUp() {
        this.computer = new Computer("Test", "One", 1.0);
        this.testComputers = new ArrayList<>();
        this.testComputers.add(computer);
        this.computerManager = new ComputerManager();

    }

    @Test
    public void testCtorShouldReturnCorrectCollection() {
        computerManager.addComputer(computer);
        List<Computer> computers = computerManager.getComputers();
        Computer computer = computers.get(0);
        Assert.assertEquals(this.testComputers.get(0), computer);
    }


    @Test
    public void testGetCountShouldReturnOne() {
        computerManager.addComputer(computer);
        Assert.assertEquals(1, computerManager.getCount());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetComputersShouldReturnUnmodifiableCollection() {
        computerManager.getComputers().add(computer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerShouldThrowWhenNullComputerAdded() {
        computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerShouldThrowWhenSameComputerAdded() {
        computerManager.addComputer(computer);
        computerManager.addComputer(computer);

    }

    @Test
    public void testRemoveComputerShouldReturnComputer() {
        computerManager.addComputer(computer);
        Computer actualComputer = computerManager.removeComputer("Test", "One");
        Assert.assertNotNull(actualComputer);
        Assert.assertEquals(computer.getManufacturer(), actualComputer.getManufacturer());
        Assert.assertEquals(computer.getModel(), actualComputer.getModel());
        Assert.assertEquals(computer.getPrice(), actualComputer.getPrice(), 0.00);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerShouldThrowWhenNNull() {
        computerManager.getComputer(null,null);


    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerShouldThrowWhenNNullManufacturer() {

        computerManager.getComputer(null,"one");


    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerShouldThrowWhenNNullModel() {

        computerManager.getComputer("Test",null);


    }
    @Test
    public void testGetComputerShouldReturnComputer() {
        computerManager.addComputer(computer);
        Computer actualComputer = computerManager.getComputer("Test", "One");
        Assert.assertEquals(computer.getManufacturer(), actualComputer.getManufacturer());
        Assert.assertEquals(computer.getModel(), actualComputer.getModel());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputersByManufacturerShouldThrow() {
        computerManager.addComputer(computer);
        computerManager.getComputersByManufacturer(null);

    }@Test(expected = IllegalArgumentException.class)
    public void testGetComputerShouldReturn() {
        computerManager.addComputer(computer);
        computerManager.getComputer("One","No");

    }

    @Test
    public void testGetComputersByManufacturerShouldReturnCollection() {
        computerManager.addComputer(computer);
        List<Computer> test = computerManager.getComputersByManufacturer("Test");
        Assert.assertNotNull(test);

    }
}