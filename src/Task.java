public class Task {
    private String name;
    private Priority priority;
    private boolean isDone;

    public Task(String givenName, Priority givenPriority, boolean givenIsDone) {
        name = givenName;
        priority = givenPriority;
        isDone = givenIsDone;
    }


    //getters and setters:
    public String getName() { return name; }
    public Priority getPriority() { return priority; }
    public boolean getIsDone() { return isDone; }


    public void setName(String name) { this.name = name; }
    public void setPriority(Priority priority) { this.priority = priority; }
    public void setIsDone(boolean done) { isDone = done; }
}
