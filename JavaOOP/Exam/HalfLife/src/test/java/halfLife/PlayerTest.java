package halfLife;

import org.junit.Before;
import org.junit.Test;


import java.util.List;

import static org.junit.Assert.*;

public class PlayerTest {
    private Player player;
    private Gun gun;

    @Before
    public void setUp() {
        Player player = new Player("Name", 100);
        Gun gun = new Gun("Gun", 100);
        this.player = player;
        this.gun = gun;

    }

    @Test
    public void testCtor() {
        Player testPlayer = new Player("Name", 100);
        assertEquals(player.getHealth(), testPlayer.getHealth());
        assertEquals(player.getUsername(), testPlayer.getUsername());

    }

    @Test(expected = NullPointerException.class)
    public void testCtorShouldThrowWhenUsernameNull() {
        Player testPlayer = new Player(null, 100);

    }

    @Test(expected = NullPointerException.class)
    public void testCtorShouldThrowWhenUsernameEmpty() {
        Player testPlayer = new Player("", 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowWhenHealthBelowZero() {
        Player testPlayer = new Player("name", -1);
    }

    @Test
    public void addGunShouldAddCorrectGun() {
        Gun testGun = new Gun("Gun", 100);
        player.addGun(testGun);
        Gun newGun = player.getGun("Gun");
        assertEquals(testGun.getName(), (newGun.getName()));
        assertEquals(testGun.getBullets(), (newGun.getBullets()));

    }

    @Test(expected = NullPointerException.class)
    public void addGunShouldThrow() {
        player.addGun(null);

    }

    @Test
    public void tesRemoveGun() {
        player.addGun(gun);
        assertTrue(player.removeGun(gun));
        assertFalse(player.removeGun(gun));

    }

    @Test
    public void testGetGun(){
        player.addGun(gun);
        Gun actual = player.getGun("Gun");
        assertEquals(gun.getName(), actual.getName());
        assertEquals(gun.getBullets(), (actual.getBullets()));
        assertNull(player.getGun("null"));

    }

    @Test
    public void getGunShouldReturnCorrectCollection() {
        Gun gun1 = new Gun("Makarov", 12);
        player.addGun(gun1);
        assertNotNull(player.getGuns());
    }
    @Test(expected = UnsupportedOperationException.class)
    public void getGunShouldReturnUnmodifiableCollection() {
        Gun gun1 = new Gun("Makarov", 12);
        player.addGun(gun1);
        List<Gun> guns = player.getGuns();
        guns.add(gun);
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageShouldThrowWhenPlayerDead(){
        player.takeDamage(100);
        player.takeDamage(0);

    }
    @Test
    public void testTakeDamageShouldSetCorrectHealth(){
        player.takeDamage(50);
        assertEquals(50, player.getHealth());
        player.takeDamage(100);
        assertEquals(0, player.getHealth());

    }
}