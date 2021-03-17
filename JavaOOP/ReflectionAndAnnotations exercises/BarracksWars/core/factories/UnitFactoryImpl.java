package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import barracksWars.models.units.*;
import jdk.jshell.spi.ExecutionControl;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
		switch (unitType){
			case "Archer":
				return new Archer();

			case "Swordsman":
				return new Swordsman();

			case "Pikeman":
				return new Pikeman();

			case "Gunner":
				return new Gunner();

			case "Horseman":
				return new Horseman();

			default:
				throw new IllegalStateException("Illegal Unit type"+ unitType);

		}
	}
}
