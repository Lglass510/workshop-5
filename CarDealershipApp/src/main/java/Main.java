public class Main {
    public static void main(String[] args) {
        Dealership dealership = new DealershipFileManager().getDealership();
        UI ui = new UI(dealership);
        ui.start();
    }
}
