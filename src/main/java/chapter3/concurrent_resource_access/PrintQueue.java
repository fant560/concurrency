package chapter3.concurrent_resource_access;

import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

    private final Semaphore semaphore;

    // Дополнительные методы семафора
    // acquireUninterruptibly() - игнорирует InterruptedException вызывающего потока
    // tryAcquire() - может ли поток получить лок на семафоре
    // tryAcquire(long timeout, TimeUnit unit) - ждет указанное количество времени
    // все методы могут принимать int указывающий на количество разрешений на операцию
    private final boolean[] freePrinters;
    private final Lock lockPrinters;

    public PrintQueue(){
        // только три потока получают доступ к ресурсам, остальные ждут
        semaphore = new Semaphore(3);
        // есть констуктор с булевым параметром, отвечающий за справедливое поведение(поток, ждущий дольше всех получает лок)
        // по умолчанию отключен
        freePrinters = new boolean[3];
        for (int i = 0; i < 3; i++){
            freePrinters[i] = true;
        }
        lockPrinters = new ReentrantLock();
    }

    public void printJob(Object document){
        try {
            // начало критической секции
            semaphore.acquire();
            int assignedPrinter = getPrinter();
            long duration = (long)(Math.random() * 10);
            System.out.printf("%s - %s: PrintQueue: Printing a Job in Printer %d during %s seconds\n",
                    new Date(), Thread.currentThread().getName(), assignedPrinter, duration);
            TimeUnit.SECONDS.sleep(duration);
            freePrinters[assignedPrinter] = true;
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            // конец критической секции, не забыть убрать лок
            semaphore.release();
        }

    }

    private int getPrinter(){
        int ret = -1;
        try {
            lockPrinters.lock();
            for (int i = 0; i < freePrinters.length; i++){
                if (freePrinters[i]){
                    ret = i;
                    freePrinters[i] = false;
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            lockPrinters.unlock();
        }
        return ret;
    }


}
