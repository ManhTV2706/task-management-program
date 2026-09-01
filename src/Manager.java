
import java.util.ArrayList;

public class Manager {
    ArrayList<Task> tasklist = new ArrayList<>();
    
    public int addTask() throws Exception{
        System.out.println("----------------------Add Task--------------------------");
        String requirementName = Validation.getString("Requirement Name: ","[a-zA-Z\\s]+", "Name must contain letters only!");
        int taskTypeID = Validation.getInt("Task Type: ", 1, 4);
        String date = Validation.getDate("Date: ");
        double planFrom = Validation.getDouble("From: ", 8.0, 17.0);
        double planto;
        
        while (true){
            planto = Validation.getDouble("To: ", 8.5, 17.5);
            if(planto > planFrom){
                break;
            }
            System.out.println("Plan To must be greater than Plan From!");
        }
        
        String assignee = Validation.getString("Assignee: ","[a-zA-Z\\s]+", "Name must contain letters only!");
        String reviewer = Validation.getString("Reviewer: ","[a-zA-Z\\s]+", "Name must contain letters only!");
        
        boolean isExist = checkDuplicate(date, assignee, planFrom, planto);
        if(isExist){
            System.out.println("Duplicate!!");
            return -1;
        }
         int id = tasklist.isEmpty() ? 1 : tasklist.get(tasklist.size() - 1).getId() + 1;
        
        Task newTask = new Task(id, taskTypeID, requirementName, date, planFrom, planto, assignee, reviewer);
        
        tasklist.add(newTask);
        System.out.println("");
        System.out.println("Add succesfull");
        System.out.println("");
        return id;   
    }
    
    public void deleteTask() throws Exception{
        System.out.println("--------------------Del Task------------------------");
        if(tasklist.isEmpty()){
            System.out.println("task list is Empty!!");
            System.out.println("");
            return;
        }
        
        int delId = Validation.getInt("ID: ", 1, Integer.MAX_VALUE);
        int index = -1;
        
        for(int i = 0; i < tasklist.size(); i++){
            if(tasklist.get(i).getId() == delId){
                index = i;
                break;
            }
        }
        
        if(index != -1){
            tasklist.remove(index);
            System.out.println("");
            System.out.println("Delete succesfull");
            System.out.println("");
        } else{
            System.out.println("Not exits");
        }
    }
    
    public void getDataTask(){
        if(tasklist.isEmpty()){
            System.out.println("task list is Empty!!!");
            System.out.println("");
            return;
        }
        
        System.out.println("---------------------------------------Task------------------------------------");
        System.out.printf("%-5s%-15s%-15s%-15s%-15.1s%-15s%-15s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        
        for (Task task : tasklist) {
            System.out.println(task);
        }
    }

    private boolean checkDuplicate(String date, String assignee, double planFrom, double planto) {
        boolean isExist = false;
        
        for (Task task : tasklist) {
            if(task.getAssignee().equalsIgnoreCase(assignee) && task.getDate().equalsIgnoreCase(date)){
                if(planto <= task.getPlanFrom() || planFrom >= task.getPlanTo()){
                    isExist = false;
                } else{
                    isExist = true;
                    break;
                }
            }
        }
        return isExist;
    }
}
