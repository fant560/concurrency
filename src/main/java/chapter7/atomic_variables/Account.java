package chapter7.atomic_variables;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class Account {

    private final AtomicLong balance;
    private final LongAdder operations;
    private final DoubleAccumulator comission;

    public Account(){
        balance = new AtomicLong();
        operations = new LongAdder();
        comission = new DoubleAccumulator((x, y) -> x + y * 0.2, 0);
    }

    public AtomicLong getBalance() {
        return balance;
    }

    public LongAdder getOperations() {
        return operations;
    }

    public DoubleAccumulator getComission() {
        return comission;
    }

    public void setBalance(long balance){
        this.balance.set(balance);
        operations.reset();
        comission.reset();
    }

    public void addAmount(long amount){
        this.balance.getAndAdd(amount);
        this.operations.increment();
        this.comission.accumulate(amount);
    }

    public void substractAmount(long amount){
        this.balance.getAndAdd(-amount);
        this.operations.increment();
        this.comission.accumulate(amount);
    }
}
