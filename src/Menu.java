
public class Menu {
    
    public void display(){
        Manager manager = new Manager();

    
        while(true){
            
            System.out.println("========= Task program =========\n"
                    + "1.	Add Task\n"
                    + "2.	Delete task\n"
                    + "3.	Display Task\n"
                    + "4.	exit\n"
                    + "");
        
            int choice = Validation.getInt("Enter choice: ", 1, 4);
            
            switch (choice){
                case 1:
                    try {
                        manager.addTask();
                    } catch (Exception e) {
                        System.out.println("ADD FAILD!!");
                    }
                    break;
                    
                case 2:
                    try {
                        manager.deleteTask();
                    } catch (Exception e) {
                        System.out.println("Delete Faild!!");
                    }
                    break;
                    
                case 3: 
                    manager.getDataTask();
                    break;
                
                case 4:
                    System.out.println("BYE BYE");
                    return;
            }
        }
    }
}
