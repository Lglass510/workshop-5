import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class UI {
    private final Dealership dealership;
    private final Scanner sc = new Scanner(System.in);

    public UI(Dealership dealership) {
        this.dealership = dealership;
    }
    public void start() {
        while (true) {
            showMainMenu();
            switch (sc.nextLine()) {
                case "1" -> searchByPrice();
                case "2" -> searchByMakeModel();
                case "3" -> searchByYear();
                case "4" -> searchByColor();
                case "5" -> searchByMileage();
                case "6" -> searchByType();
                case "7" -> displayVehicles(dealership.getAllVehicles());
                case "8" -> sellAVehicle();
                case "9" -> leaseAVehicle();
                case "10" ->{
                    System.out.println("Exiting.");
                    return;
                }
                default -> System.out.println("Invalid Option.");
            }
        }
    }
    private void showMainMenu() {
        System.out.println("""
                \n🚗 Hooptie Central Main Menu 🚗
                1) Search by price
                2) Search by make/model
                3) Search by year
                4) Search by color
                5) Search by mileage
                6) Search by type
                7) Show all vehicles
                8) Sell a vehicle
                9) Lease a vehicle
                10) Exit
                Select an option:
                """);
    }
    private void searchByPrice() {
        double min = promptForDouble("Minimum price:");
        double max = promptForDouble("Maximum price;");
        List<Vehicle> results = filterVehicles(v -> v.getPrice() >= min && v.getPrice() <= max);
        displayVehicles(results);
    }
    private void searchByMakeModel(){
        String make = prompt("Make:");
        String model = prompt("Model:");
        List<Vehicle> results = filterVehicles(v -> v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model));
        displayVehicles(results);
    }
    private void searchByYear(){
        int year = promptForInt("Year:");
        List<Vehicle> results = filterVehicles(v -> v.getYear() == year);
        displayVehicles(results);
    }
    private void searchByColor(){
        String color = prompt("Color:");
        List<Vehicle> results = filterVehicles(v -> v.getColor().equalsIgnoreCase(color));
        displayVehicles(results);
    }
    private void searchByType() {
        String type = prompt("Type(Sedan,Truck,SUV,Van);");
        List<Vehicle> results = filterVehicles(v -> v.getVehicleType().equalsIgnoreCase(type));
        displayVehicles(results);
    }
    private void searchByMileage() {
        double mileage = promptForDouble("Mileage:");
        List<Vehicle> results = filterVehicles(v -> v.getMiles() == mileage);
        displayVehicles(results);
    }
    private void sellAVehicle(){
        String vin = prompt("Vin:");
        List<Vehicle> results = filterVehicles(v -> v.getVin().equals(vin));
        displayVehicles(results);
    }
    private void leaseAVehicle(){
        String vin = prompt("Vin:");
        List<Vehicle> results = filterVehicles(v -> v.getVin().equals(vin));
        displayVehicles(results);
    }
    private List<Vehicle> filterVehicles(java.util.function.Predicate<Vehicle> filter) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle v : dealership.getAllVehicles()) {
            if (filter.test(v)) {
                results.add(v);
            }
        }
        return results;
    }
        private void displayVehicles(List<Vehicle> vehicles) {
            if (vehicles.isEmpty()) {
                System.out.println("No vehicles matched your search.");
            } else {
                for (Vehicle v : vehicles) {
                    System.out.println(v);
                }
            }
        }
        private String prompt(String input) {
            System.out.println(input + " ");
            return sc.nextLine();
        }
        private double promptForDouble( String input) {
        while (true) {
            try{
                return Double.parseDouble(prompt(input));
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number.");
            }
        }
        }
        private int promptForInt(String input) {
        while (true) {
            try {
                return Integer.parseInt(prompt(input));
            }catch(NumberFormatException e) {
                System.out.println("Enter valid number.");
            }
        }

        }

}
