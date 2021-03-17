package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;


    protected PlayerImpl(String username, int health, int armor, Gun gun) {
        this.setUsername(username);
        this.setHealth(health);
        this.setArmor(armor);
        this.setGun(gun);
        this.isAlive=true;
    }


    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    public void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    public void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    public void setAlive(boolean alive) {

       this.isAlive = this.health > 0;

    }

    public void setGun(Gun gun) {

        if (gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public void takeDamage(int points) {

        int armorLeft = getArmor() - points;
        if (armorLeft <= 0) {
            setArmor(0);
            int healthLeft = getHealth() - points;
            if (healthLeft > 0) {
                setHealth(healthLeft);
            } else {
                setHealth(0);
                this.isAlive = false;
            }
        } else {
            setArmor(armorLeft);
        }

    }

    @Override
    public String toString() {
        StringBuilder sb  = new StringBuilder();
        sb.append(this.getClass().getSimpleName())
                .append(": ")
                .append(this.getUsername())
                .append(System.lineSeparator())
                .append("--Health: ")
                .append(this.getHealth())
                .append(System.lineSeparator())
                .append("--Armor: ")
                .append(this.getArmor())
                .append(System.lineSeparator())
                .append("--Gun: ")
                .append(this.getGun().getName());
        return sb.toString().trim();
    }
}
