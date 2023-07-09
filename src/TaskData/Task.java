package TaskData;

public class Task {
    private String name;
    private String description;
    private Priority priority;
    private boolean isDone;


    public Task(String givenName, String givenDescription, Priority givenPriority) {
        this.name = givenName;
        this.description = givenDescription;
        this.priority = givenPriority;
        this.isDone = false;
    }

    public boolean getIsDone() { return isDone; }
    public void setIsDone(boolean given) { isDone = given; }
}
