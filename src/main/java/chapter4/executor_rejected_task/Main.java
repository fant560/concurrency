package chapter4.executor_rejected_task;

public class Main {

    public static void main(String[] args) {
        Server server = new Server();
        System.out.println("Main: Starting.\n");
        for (int i = 0; i < 100; i++){
            Task task = new Task("Task " + i);
            server.executeTask(task);
        }
        System.out.println("Main: Shutting down the Executor");
        server.endServer();

        System.out.println("Main: Sending another Task.");
        Task task = new Task("Rejected Task");
        server.executeTask(task);


    }

}
