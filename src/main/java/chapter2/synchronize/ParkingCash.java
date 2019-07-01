package chapter2.synchronize;

public class ParkingCash {

    private static final int cost = 2;
    private long cash;

    public ParkingCash(){
        cash = 0;
    }

    public synchronized void vehiclePay(){
        cash += cost;
    }

    public void close(){
        System.out.println("Closing account");
        long totalAmount;
        synchronized (this) {
            totalAmount = cash;
            cash = 0;
        }
        System.out.printf("The total amount is : %d", totalAmount);
    }

}
