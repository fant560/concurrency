package chapter2.stamped_lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class Writer implements Runnable {

    private final Position position;
    // методы read, write, optimistic read
    // write экскюзивный доступ к локу, остальные треды не могут получить доступ
    // read другие потоки могут получать доступ к данным
    // optimistic read нужно использовать метод validate чтобы посмотреть можно ли использовать данные
    // у потока нет лока блок кода. Остальные потоки в этот момент могут взять лок на запись
    // локи возвращают лонг, если 0 то взять лок не получилось
    private final StampedLock lock;

    public Writer(Position position, StampedLock lock){
        this.position = position;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            long stamp = lock.writeLock();

            try {
                System.out.printf("Writer: Lock acquired %d\n", stamp);
                position.setX(position.getX() + 1);
                position.setY(position.getY() + 1);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                lock.unlockWrite(stamp);
                System.out.printf("Writer: Lock released %d\n", stamp);
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }



}
