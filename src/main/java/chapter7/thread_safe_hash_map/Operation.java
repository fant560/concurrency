package chapter7.thread_safe_hash_map;

import java.util.Date;

public class Operation {

    private String user;
    private String operation;
    private Date time;

    public Operation(){

    }

    public Operation(String user, String operation, Date time){
        this.user = user;
        this.operation = operation;
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
