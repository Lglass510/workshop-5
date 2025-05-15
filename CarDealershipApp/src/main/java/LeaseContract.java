

public class LeaseContract extends Contract {

    private static final double ENDING_VALUE_PERCENTAGE = 0.5;
    private static final double LEASE_FEE_PERCENTAGE = 0.07;
    private static final int LEASE_TERM_MONTHS = 36;
    private static final double INTEREST_RATE = 0.04;

    double expectedEndValue;
    double leaseFee;


    public double getTotalPrice(){
       double price = getVehicle().getPrice();
       double leaseFee = price * LEASE_FEE_PERCENTAGE;
       return price * leaseFee;
    }
    public double getMonthlyPayment(){
        double price = getVehicle().getPrice();
        double endingValue = price * ENDING_VALUE_PERCENTAGE;
        double leaseFee = price * LEASE_FEE_PERCENTAGE;
        double capCost = price + leaseFee;
        double depreciation = capCost - endingValue;
        double totalInterest = depreciation * INTEREST_RATE;
        double totalLeaseCost = depreciation + totalInterest;
        return totalLeaseCost / LEASE_TERM_MONTHS;
    }

}
