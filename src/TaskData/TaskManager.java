package TaskData;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> taskList;


    //Methods:
    public TaskManager() {
        this.taskList = new ArrayList<>();
    }

    public void addNewTask(Task newTask) {
        this.taskList.add(newTask);
    }

    public void removeFinishedTasks() {
        for (Task t : taskList) {
            if(t.getIsDone()) {
                taskList.remove(t);
            }
        }
    }

    public List<Task> getTaskList() { return taskList; }
    public void setTaskList(List<Task> taskList) { this.taskList = taskList; }
}
