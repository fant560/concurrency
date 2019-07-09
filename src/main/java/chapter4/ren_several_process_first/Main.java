package chapter4.ren_several_process_first;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        String username = "test";
        String password = "test";

        UserValidator ldapValidator = new UserValidator("LDAP");
        UserValidator databaseValidator = new UserValidator("DataBase");
        ValidatorTask ldapTask = new ValidatorTask(ldapValidator, username, password);
        ValidatorTask databaseTask = new ValidatorTask(databaseValidator, username, password);
        List<ValidatorTask> taskList = new ArrayList<>();
        taskList.add(ldapTask);
        taskList.add(databaseTask);
        ExecutorService executor = Executors.newCachedThreadPool();
        String result;

        try {
            result = executor.invokeAny(taskList);
            System.out.printf("Main: Result: %s\n", result);
        } catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.println("Main: End of the execution");
    }

}
