package chapter2.synchronize;

public class ParkingStats {

    private long numberCars;
    private long numberMotorcycles;
    private ParkingCash cash;
    private final Object controlCars;
    private final Object controlMotorcycles;

    public ParkingStats(ParkingCash cash){
        numberCars = 0;
        numberMotorcycles = 0;
        controlCars = new Object();
        controlMotorcycles = new Object();
        this.cash = cash;
    }

    public void carComeIn(){
        synchronized (controlCars) {
            numberCars++;
        }
    }

    public void carGoOut(){
        synchronized (controlCars) {
            numberCars--;
        }
        cash.vehiclePay();
    }

    public void motoComeIn(){
        synchronized (controlMotorcycles) {
            numberMotorcycles++;
        }
    }

    public void motoGoOut(){
        synchronized (controlMotorcycles) {
            numberMotorcycles--;
        }
        cash.vehiclePay();
    }

    public long getNumberCars() {
        return numberCars;
    }

    public long getNumberMotorcycles() {
        return numberMotorcycles;
    }
}
