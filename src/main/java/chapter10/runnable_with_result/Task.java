package chapter10.runnable_with_result;

import java.util.List;
import java.util.concurrent.FutureTask;

public class Task extends FutureTask<List<String>> {

    private FileSearch fileSearch;

    public Task(Runnable runnable, List<String> result) {
        super(runnable, result);
        this.fileSearch = (FileSearch) runnable;
    }


    @Override
    protected void set(List<String> v){
        v = fileSearch.getResults();
        super.set(v);
    }
}
