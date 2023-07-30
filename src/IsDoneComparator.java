import java.util.Comparator;

public class IsDoneComparator implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) {
        return Boolean.compare(t2.getIsDone(), t1.getIsDone());
    }
}
