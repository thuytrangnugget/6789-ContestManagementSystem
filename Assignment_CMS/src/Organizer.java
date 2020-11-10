
import java.util.ArrayList;
import java.util.Scanner;

public class Organizer {
        private ArrayList<Contestant> listContestants;
        private ArrayList<Problem> listProblems;
        
        public void f1() {
                Scanner sc = new Scanner(System.in);
                String enteredName;
                String enteredPw;
                System.out.print("Enter username: ");
                enteredName = sc.nextLine();
                System.out.print("Enter password: ");
                enteredPw = sc.nextLine();
                for (Contestant i: listContestants) {
                        if (enteredName.compareTo(i.getName()) == 0 && enteredPw.compareTo(i.getId()) == 0) {
                                i.setStatus(1);
                                System.out.println("Login for " + i.getName() + " successfully.");
                        } else {
                                System.out.println("Wrong username or password.");
                        }                                
                }
                System.out.println(i);
        }
        
        public void f2() {
                Scanner sc = new Scanner(System.in);              
                System.out.println("Enter contestant's ID you want to change profile: ");
                String enteredId = sc.nextLine();
                System.out.println("Enter new name (No if you don't want to change name): ");
                String enteredName = sc.nextLine();
                if (enteredName.toLowerCase().compareTo("no") != 0) 
                System.out.println("Enter new email (No if you don't want to change email): ");
                String enteredEmail = sc.nextLine();
                System.out.println("Enter new phone number (No if you don't want to change phone number): ");
                String enteredPhone = sc.nextLine();
                
        }
}
