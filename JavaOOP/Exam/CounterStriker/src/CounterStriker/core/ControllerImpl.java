package CounterStriker.core;

import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import java.util.*;
import java.util.stream.Collectors;


import static CounterStriker.common.ExceptionMessages.*;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_GUN;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_PLAYER;

public class ControllerImpl implements Controller {

    private GunRepository guns;
    private PlayerRepository players;
    private Field field;

    public ControllerImpl() {
        this.guns = new GunRepository();
        this.players = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {

        if (!type.equals("Pistol") && !type.equals("Rifle")) {
            throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }

        Gun gun;
        if (type.equals("Pistol")) {
            gun = new Pistol(name, bulletsCount);

        } else {
            gun = new Rifle(name, bulletsCount);
        }
        guns.add(gun);
        return String.format(SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type,
                            String username,
                            int health,
                            int armor,
                            String gunName) {
        if (!type.equals("Terrorist") && !type.equals("CounterTerrorist")) {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }


        Player player;
        Gun gun;
        if (type.equals("Terrorist")) {
            gun = guns.findByName(gunName);
            if (gun == null) {
                throw new NullPointerException(GUN_CANNOT_BE_FOUND);
            }
            player = new Terrorist(username, health, armor, gun);

        } else {
            gun = guns.findByName(gunName);
            player = new CounterTerrorist(username, health, armor, gun);
        }
        players.add(player);
        return String.format(SUCCESSFULLY_ADDED_PLAYER, player.getUsername());

    }

    @Override
    public String startGame() {
        Collection<Player> playersModels = this.players.getModels();
        Collection<Player> alivePlayers = new LinkedList<>();
        for (Player playersModel : playersModels) {
            if (playersModel.isAlive()) {
                alivePlayers.add(playersModel);
            }
        }
        return field.start(alivePlayers);
    }

    @Override
    public String report() {
        List<Player> terrorists = new LinkedList<>();
        List<Player> counterTerrorists = new LinkedList<>();

        this.players.getModels().forEach(p -> {
            if (p.getClass().getSimpleName().equals("Terrorist")) {
                terrorists.add(p);
            } else {
                counterTerrorists.add(p);
            }
        });

        List<Player> collectT = terrorists.stream().sorted((p1, p2) -> {
            if (p1.getHealth() - p2.getHealth() == 0) {
                return p1.getUsername().compareTo(p2.getUsername());
            }
            return p2.getHealth() - p1.getHealth();
        }).collect(Collectors.toList());

        List<Player> collectC = counterTerrorists.stream().sorted((p1, p2) -> {
            if (p1.getHealth() - p2.getHealth() == 0) {
                return p1.getUsername().compareTo(p2.getUsername());
            }
            return p2.getHealth() - p1.getHealth();
        }).collect(Collectors.toList());

        List<Player> result = new LinkedList<>();
        result.addAll(collectC);
        result.addAll(collectT);

        StringBuilder sb = new StringBuilder();
        for (Player player : result) {
            sb.append(player.toString())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
