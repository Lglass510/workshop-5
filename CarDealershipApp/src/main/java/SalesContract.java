

public class SalesContract extends Contract {

    //Constants
    private static final double SALES_TAX = 0.05;
    private static final double RECORDING_FEE = 100.00;
    private static final double PROCESSING_FEE_UNDER_10K = 295.00;
    private static final double PROCESSING_FEE_OVER_10K = 495.00;
    private static final double INTEREST_UNDER_10K = 0.0425;
    private static final double INTEREST_OVER_10K = 0.0525;
    private static final int TERM_UNDER_10k = 24;
    private static final int TERM_OVER_10k = 48;

    //Fields
    boolean isFinanced;

    @Override
    public double getTotalPrice(){
        double price = getVehicle().getPrice();
        double processingFee = price < 10000 ? PROCESSING_FEE_UNDER_10K : PROCESSING_FEE_OVER_10K;
        double tax = price * SALES_TAX;
        return price + tax + RECORDING_FEE + processingFee;
    }
    @Override
    public double getMonthlyPayment() {
        if (!isFinanced) {
            return 0.0;
        }
        double price = getVehicle().getPrice();
        double interestRate;
        int months;
        if (price < 10000) {
            interestRate = INTEREST_UNDER_10K;
            months = TERM_UNDER_10k;
        } else {
            interestRate = INTEREST_OVER_10K;
            months = TERM_OVER_10k;
        }
        return (price * (1 + interestRate)) / months;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }
}
