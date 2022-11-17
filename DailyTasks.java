public class DailyTasks {
    Task[] tasks;
    int size = 0;
    int MAX_SIZE = 100;

    public DailyTasks() {
        tasks = new Task[MAX_SIZE];
    }

    public static void main(String[] args) {
        DailyTasks dailyTasks = new DailyTasks();
        Task task1 = new Task("1",10,2);
        Task task2 = new Task("2",13,2);
        Task task3 = new Task("2",9,3);

        System.out.println(dailyTasks.addTask(task1));
        System.out.println(dailyTasks.addTask(task2));
        System.out.println(dailyTasks.addTask(task3));

    }

    private boolean addTask(Task task) {

        if (!this.validateTask(task)) {
            return false;
        }
        for (int i = 0; i < size; i++) {

            if(task.getStartTime() < tasks[i].getStartTime()){

                if(task.getDuration() > tasks[i].getStartTime() - task.getStartTime()){
                    return false;
                }
            } else if (task.getStartTime() < tasks[i].getStartTime() +tasks[i].getDuration()) {
                return  false;
            }
        }

        tasks[size] =task;
        size++;
        return true;
    }
    private boolean validateTask(Task task){
        if(task.getDescription().isEmpty()){
            return false;
        }
        if (task.getStartTime() <0 || task.getStartTime() > 23) {
            return false;
        }
        if (task.getDuration() <1 || task.getDuration() > 24) {
            return false;
        }
        if (task.getStartTime() + task.getDuration() > 24) {
            return  false;
        }
        return true;
    }
}

class Task {
    String description;
    int startTime;
    int duration;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Task(String description, int startTime, int duration) {
        this.description = description;
        this.startTime = startTime;
        this.duration = duration;
    }
}