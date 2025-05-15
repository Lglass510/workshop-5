import java.io.*;

public class DealershipFileManager {


    public Dealership getDealership() {
        Dealership dealership = new Dealership("Hooptie Central", "1 2 3 Scam Lane", "555-bad-deal4U");


    try(
    BufferedReader br = new BufferedReader(new FileReader("inventory.csv")))

    {
        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split("\\|");

            if (data.length == 8) {
                String vin = data[0];
                int year = Integer.parseInt(data[1]);
                String make = data[2];
                String model = data[3];
                String type = data[4];
                String color = data[5];
                double mileage = Double.parseDouble(data[6]);
                double price = Double.parseDouble(data[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, mileage, price);
                dealership.addVehicle(vehicle);


            }
        }


    } catch(IOException e) {
        System.out.println("Error reading inventory file.");
    }

    return dealership;


}

}
