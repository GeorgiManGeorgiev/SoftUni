package onlineShop.core.interfaces;

import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {
    private List<Computer> computers;
    private List<Peripheral> peripherals;
    private List<Component> components;


    public ControllerImpl() {
        this.computers = new ArrayList<>();
        this.peripherals = new ArrayList<>();
        this.components = new ArrayList<>();
    }

    @Override
    public String addComputer(String computerType,
                              int id,
                              String manufacturer,
                              String model,
                              double price) {
        Computer computer;
        if (computerType.equals("Laptop")) {
            computer = (Computer) new Laptop(id, manufacturer, model, price);
        } else if (computerType.equals("DesktopComputer")) {
            computer = (Computer) new DesktopComputer(id, manufacturer, model, price);
        } else {
            throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }
        for (Computer computer1 : computers) {
            if (computer1.getId() == id) {
                throw new IllegalArgumentException(String.format(EXISTING_COMPUTER_ID, id));

            }
        }

        computers.add(computer);


        return String.format(ADDED_COMPUTER, id);
    }

    @Override
    public String addComponent(int computerId,
                               int id,
                               String componentType,
                               String manufacturer,
                               String model, double price,
                               double overallPerformance,
                               int generation) {

        Component component;
        switch (componentType) {
            case "CentralProcessingUnit":
                component = (Component) new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = (Component) new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = (Component) new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = (Component) new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = (Component) new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = (Component) new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;

            default:
                throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);

        }

        for (Component component1 : components) {
            if (component1.getId() == id) {
                throw new IllegalArgumentException(String.format(EXISTING_COMPONENT_ID, id));
            }
        }


        boolean computerIdIsContained = false;
        for (Computer computer : computers) {
            if (computer.getId() == computerId) {
                computerIdIsContained = true;
                computer.addComponent(component);
                break;
            }
        }
        if (!computerIdIsContained) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPUTER_ID, computerId));
        }

        if (computerIdIsContained) {
            components.add(component);
        }
        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String addPeripheral(int computerId,
                                int id,
                                String peripheralType,
                                String manufacturer,
                                String model,
                                double price,
                                double overallPerformance, String connectionType) {

        Peripheral peripheral;
        switch (peripheralType) {
            case "Headset":
                peripheral = (Peripheral) new Headset(id, manufacturer, model, price, overallPerformance, connectionType);

                break;
            case "Keyboard":
                peripheral = (Peripheral) new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = (Peripheral) new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = (Peripheral) new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;

            default:
                throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }
        boolean computersContainId = false;
        for (Computer computer : computers) {
            if (computer.getId() == computerId) {
                computersContainId = true;
                computer.addPeripheral(peripheral);
                break;
            }

        }
        if (!computersContainId) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPUTER_ID, computerId));
        }

        for (Peripheral peripheral1 : peripherals) {
            if (peripheral1.getId() == id) {
                throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL_ID, id));
            }
        }
        peripherals.add(peripheral);

        return String.format(ADDED_PERIPHERAL, peripheral.getClass().getSimpleName(), peripheral.getId(), computerId);
    }

    @Override
    public String removeComponent(String componentType,
                                  int computerId) {
        boolean isContained = false;
        for (Computer computer : computers) {
            if (computer.getId() == computerId) {
                isContained = true;
                computer.removeComponent(componentType);

            }
        }
        boolean isRemoved=false;
        boolean isContainedInComponents = false;
        int index = 0;
        Component removed=null;
        if (isContained) {
            for (int i = 0; i <components.size() ; i++)  {
                if (components.get(i) .getClass().getSimpleName().equals(componentType)) {
                    isContainedInComponents= true;
                    index=i;
                }
            }
           removed= components.remove(index);
            isRemoved = true;

        }

        if (isRemoved){
            return String.format(REMOVED_COMPONENT,removed.getClass().getSimpleName(),removed.getId());
        }
        return null;
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        return null;
    }

    @Override
    public String buyComputer(int id) {
        return null;
    }

    @Override
    public String BuyBestComputer(double budget) {
        return null;
    }

    @Override
    public String getComputerData(int id) {
        return null;
    }
}
