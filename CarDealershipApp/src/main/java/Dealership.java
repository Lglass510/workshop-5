import java.util.ArrayList;

public class Dealership {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone){
        this.inventory = new ArrayList<>();
        this.address = address;
        this.phone = phone;
        this.name = name;
    }


    public ArrayList<Vehicle> displayVehicleByPrice(double min, double max){
        return getAllVehicles();

    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return new ArrayList<>(inventory);
    }






}
