package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private p02_ExtendedDatabase.Database database;
    private static final Person[] EXPECTED = {
            new Person(1, "First"),
            new Person(2, "Second"),
            new Person(3, "Third"),
            new Person(4, "Fourth")
    };

    @Before
    public void setUp() throws OperationNotSupportedException {
        Person p1 = new Person(1, "First");
        Person p2 = new Person(2, "Second");
        Person p3 = new Person(3, "Third");
        Person p4 = new Person(4, "Fourth");
        database = new p02_ExtendedDatabase.Database(p1, p2, p3, p4);
    }

    @Test
    public void testDatabaseConstructorShouldCreateObjectWithValidState() {
        Person[] elements = database.getElements();
        assertEquals(EXPECTED.length, elements.length);
        for (int i = 0; i < EXPECTED.length; i++) {
            assertEquals(EXPECTED[i], elements[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseShouldThrowWhenCalledWithMoreThanSixteenElements() throws OperationNotSupportedException {
        Person[] numbers = new Person[17];
        new p02_ExtendedDatabase.Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseShouldThrowWhenCalledWithZeroElements() throws OperationNotSupportedException {
        Person[] numbers = new Person[0];
        new p02_ExtendedDatabase.Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowWhenParameterIsNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddShouldAddFirstFreeIndex() throws OperationNotSupportedException {
        Person fifth = new Person(5, "Fifth");
        database.add(fifth);
        Person[] elements = database.getElements();

        assertEquals(5, elements.length);
        assertEquals(fifth, elements[4]);
    }

    @Test
    public void testRemoveShouldRemoveLastElement() throws OperationNotSupportedException {
        database.remove();
        Person[] actual = database.getElements();
        Person[] expected = {
                new Person(1, "First"),
                new Person(2, "Second"),
                new Person(3, "Third")
        };
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowWithEmptyDatabase() throws OperationNotSupportedException {
        for (int i = 0; i < 4; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testGetElementsShouldReturnCorrectArray() {
        Person[] actual = database.getElements();
        assertEquals(EXPECTED.length, actual.length);
        for (int i = 0; i < EXPECTED.length; i++) {
            assertEquals(EXPECTED[i], actual[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDuplicatePersonShouldThrow() throws OperationNotSupportedException {
        this.database.add(new Person(1, "First"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testPersonWithNegativeShouldThrow() throws OperationNotSupportedException {
        this.database.add(new Person(-1, "MinusOne"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldTrowWithParameter() throws OperationNotSupportedException {
        this.database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldTrowWhenNoSuchUserIsPresent() throws OperationNotSupportedException {
        this.database.findByUsername("Not_Present");
    }


    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldTrowWhenMoreThanOnePeopleHaveSameUsername() throws OperationNotSupportedException {
        Person p1 = new Person(1, "First");
        Person p2 = new Person(2, "Second");
        Person p3 = new Person(3, "Fourth");
        Person p4 = new Person(4, "Fourth");
        database = new p02_ExtendedDatabase.Database(p1, p2, p3, p4);
        database.findByUsername("Fourth");
    }

    @Test
    public void testFindByUsernameShouldReturnCorrectPerson() throws OperationNotSupportedException {
        Person person = this.database.findByUsername("Fourth");
        assertEquals(new Person(4, "Fourth"), person);
        assertEquals(4, person.getId());
        assertNotEquals(3, person.getId());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdShouldThrowWithIdNotPresent () throws OperationNotSupportedException {
        this.database.findById(100);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdShouldThrowWithMultiplePeopleWithSameId () throws OperationNotSupportedException {
        Person p1 = new Person(1, "First");
        Person p2 = new Person(2, "Second");
        Person p3 = new Person(3, "Fourth");
        Person p4 = new Person(3, "Fourth");
        database = new p02_ExtendedDatabase.Database(p1, p2, p3, p4);
        database.findById(3);

    }

    @Test
    public void testFindByIdShouldReturnCorrectPerson() throws OperationNotSupportedException {
        Person byId = this.database.findById(1);
        assertEquals(1,byId.getId());
        assertEquals("First",byId.getUsername());

    }
}

