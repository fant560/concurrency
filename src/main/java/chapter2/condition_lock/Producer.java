package chapter2.condition_lock;

public class Producer implements Runnable {

    private FileMock mock;
    private Buffer buffer;

    public Producer(FileMock fileMock, Buffer buffer){
        this.mock = fileMock;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.setPendingLines(true);
        while (mock.hasMoreLines()){
            String line = mock.getLine();
            buffer.insert(line);
        }
        buffer.setPendingLines(false);
    }
}
