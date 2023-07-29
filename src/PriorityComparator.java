import java.util.Comparator;

public class PriorityComparator implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) {
        return t1.getPriority().compareTo(t2.getPriority());
    }
}
