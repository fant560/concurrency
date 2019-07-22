package chapter8.custom_stream_generator;

import java.util.Spliterator;
import java.util.function.Consumer;

public class MySpliterator implements Spliterator<Item> {

    private Item[][] items;
    private int start, end, current;

    public MySpliterator(Item[][] items, int start, int end){
        this.items = items;
        this.start = start;
        this.end = end;
        this.current = start;
    }

    @Override
    public int characteristics(){
        return ORDERED | SIZED | SUBSIZED;
    }

    @Override
    public long estimateSize(){
        return end - current;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Item> consumer){
        System.out.printf("MySpliterator.tryAdvance.start: %d, %d, %d\n",
                start, end, current);
        if (current < end){
            for (int i = 0; i < items[current].length; i++){
                consumer.accept(items[current][i]);
            }
            current++;
            System.out.println("MySpliterator.tryAdvance.end:true");
            return true;
        }
        System.out.println("MySpliterator.tryAdvance.end:false");
        return false;
    }

    @Override
    public void forEachRemaining(Consumer<? super Item> consumer){
        System.out.println("MySpliterator.forEachRemaining.start");
        boolean result;
        do {
            result = tryAdvance(consumer);
        } while(result);
        System.out.println("MySpliterator.forEachRemaining.end");
    }
    // TODO где-то зацикливается, похоже ошибка в книге
    @Override
    public Spliterator<Item> trySplit(){
        System.out.println("MySpliterator.trySplit.start");
        if (end - start <= 2){
            System.out.println("MySpliterator.trySplit.end");
            return null;
        }
        int mid = start + ((end - start) / 2);
        int newStart = mid;
        int newEnd = end;
        System.out.printf("MySpliterator.trySplit.end: %d, %d, %d, %d, %d, %d\n",
                start, mid, end, newStart, newEnd, current);
        return new MySpliterator(items, newStart, newEnd);
    }
}
