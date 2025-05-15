

public abstract class Contract {
    String customerName;
    String customerEmail;
    Vehicle vehicle;
    String date;


    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
