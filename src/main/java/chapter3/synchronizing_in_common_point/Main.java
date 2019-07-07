package chapter3.synchronizing_in_common_point;

import java.util.concurrent.CyclicBarrier;

public class Main {

    public static void main(String[] args) {
        final int rows = 10000;
        final int numbers = 1000;
        final int search = 5;
        final int participants = 5;
        final int linesParticipant = 2000;
        MatrixMock matrixMock = new MatrixMock(rows, numbers, search);
        Results results = new Results(rows);
        Grouper grouper = new Grouper(results);
        CyclicBarrier barrier = new CyclicBarrier(participants, grouper);

        Searcher[] searchers = new Searcher[participants];
        for (int i = 0; i < participants; i++){
            searchers[i] = new Searcher(i * linesParticipant, (i * linesParticipant) + linesParticipant,
                    matrixMock, results, 5, barrier);
            Thread thread = new Thread(searchers[i]);
            thread.start();
        }
        System.out.print("Main: The main thread has finished.\n");
    }

}
