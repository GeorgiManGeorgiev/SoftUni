package CounterStriker.models.field;

import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;

import CounterStriker.models.players.Terrorist;

import java.util.ArrayList;
import java.util.Collection;

import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.COUNTER_TERRORIST_WINS;
import static CounterStriker.common.OutputMessages.TERRORIST_WINS;

public class FieldImpl implements Field {


    @Override
    public String start(Collection<Player> players) {
        List<Terrorist> terrorists = new ArrayList<>();
        List<CounterTerrorist> counterTerrorists = new ArrayList<>();
        for (Player player : players) {
            String playerType = player.getClass().getSimpleName();
            if (playerType.equals("Terrorist")) {
                terrorists.add((Terrorist) player);
            } else {
                counterTerrorists.add((CounterTerrorist) player);
            }
        }



        while (!terrorists.isEmpty() && !counterTerrorists.isEmpty()){

            for (Terrorist terrorist : terrorists) {
                for (CounterTerrorist counterTerrorist : counterTerrorists) {
                    counterTerrorist.takeDamage(terrorist.getGun().fire());
                }
            }

        counterTerrorists = counterTerrorists.stream()
                .filter(Player::isAlive)
                .collect(Collectors.toList());

            for (CounterTerrorist counterTerrorist : counterTerrorists) {
                for (Terrorist terrorist : terrorists) {
                    terrorist.takeDamage(counterTerrorist.getGun().fire());
                }
            }

            terrorists = terrorists.stream()
                    .filter(Player::isAlive)
                    .collect(Collectors.toList());



        }

        if (counterTerrorists.isEmpty()) {
            return TERRORIST_WINS ;
        }
        return COUNTER_TERRORIST_WINS ;


//
//        while (!terrorists.isEmpty() && !counterTerrorists.isEmpty()) {
//            for (Terrorist terrorist : terrorists) {
//                int shoots = 0;
//                if (terrorist.isAlive()) {
//                    shoots = terrorist.getGun().fire();
//                }
//                for (CounterTerrorist counterTerrorist : counterTerrorists) {
//                    counterTerrorist.takeDamage(shoots);
//                    if (!counterTerrorist.isAlive()) {
//                        counterTerrorists.remove(counterTerrorist);
//                    }
//                }
//            }
//            for (CounterTerrorist counterTerrorist : counterTerrorists) {
//                int shoots = 0;
//                if (counterTerrorist.isAlive()) {
//                    shoots = counterTerrorist.getGun().fire();
//                }
//                for (Terrorist terrorist : terrorists) {
//                    terrorist.takeDamage(shoots);
//                    if (!terrorist.isAlive()) {
//                        terrorists.remove(terrorist);
//                    }
//                }
//            }
//        }
//        if (counterTerrorists.isEmpty()) {
//            return TERRORIST_WINS ;
//        }
//        return COUNTER_TERRORIST_WINS ;
//

    }
}
