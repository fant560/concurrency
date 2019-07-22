package chapter8.custom_atomic_object;

public class Sensor2 implements Runnable {

    private final ParkingCounter counter;
    public Sensor2(ParkingCounter counter){
        this.counter = counter;
    }

    @Override
    public void run(){
        counter.carIn();
        counter.carOut();
        counter.carOut();
        counter.carIn();
        counter.carIn();
        counter.carIn();
        counter.carIn();
        counter.carIn();
        counter.carIn();
    }


}
