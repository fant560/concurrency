package chapter7.thread_safe_hash_map;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {

    public static void main(String[] args) {
        ConcurrentHashMap<String, ConcurrentLinkedDeque<Operation>> userHash =
                new ConcurrentHashMap<>();
        HashFiller hashFiller = new HashFiller(userHash);
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++){
            threads[i] = new Thread(hashFiller);
            threads[i].start();
        }
        for (int i = 0; i < 10; i++){
            try {
                threads[i].join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.printf("Size: %d\n", userHash.size());
        userHash.forEach(10, (user, list) -> {
            System.out.printf("%s: %s: %d\n", Thread.currentThread().getName(), user, list.size());
        });
        userHash.forEachEntry(10, entry -> {
            System.out.printf("%s: %s: %d\n", Thread.currentThread().getName(), entry.getKey(), entry.getValue().size());
        });
        // 327 страница
    }

}
