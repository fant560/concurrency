package chapter6.collecting_stream_elements;

public class Counter {

    String value;
    int counter;

    Counter(){
        this.counter = 0;
    }

    public void increment(){
        this.counter++;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
