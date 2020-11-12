
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Participant {

    private String id;
    private String name;
    private String email;
    private String phone;
    private String pw;
    //?
    private int status;
    //?
    private Contest test = new Contest();
    public ArrayList<Contestant> listContestants = new ArrayList<>();
    public ArrayList<Organizer> listOrganizers = new ArrayList<>();
    public ArrayList<Problem> listProblems = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    //?
    private int index;

    
    public Participant() {
        id = generateID();
        name = "No name";
        email = "noemail@noreply.com";
        phone = "No phone";
        pw = "no pw";
    }
    
    //Khởi tạo participant mới không truyền vào ID
    public Participant(String name, String email, String phone, String pw) {
        try {
            this.id = generateID();
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.pw = pw;
        } catch (NullPointerException e) {
            System.out.println("fiels cannot be null");
        }
    }
    
    private String generateID() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int length = 10;
        Random ID = new Random();
 
        String generatedString = ID.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
    
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    public void updateInfo() {
        while (true) {
            System.out.println("Enter field(s) you want to update:");
            System.out.println("For example, '1' to update name");
            System.out.println("1. Name");
            System.out.println("2. Email");
            System.out.println("3. Phone");
            System.out.println("4. Password");
            System.out.println("0. Exit");
            String n = sc.nextLine();
            
            switch (n) {
                case "0":
                    break;
                case "1":
                    System.out.println("Enter new name");
                    String newName = sc.nextLine();
                    this.setName(newName);
                    break;
                case "2":
                    System.out.println("Enter new email");
                    String newEmail = sc.nextLine();
                    this.setEmail(newEmail);
                    break;
                case "3":
                    System.out.println("Enter new phone");
                    String newPhone = sc.nextLine();
                    this.setPhone(newPhone);
                    break;
                case "4":
                    System.out.println("Enter new password");
                    String newPw = sc.nextLine();
                    this.setPw(newPw);
                    break;
                default:
                    System.out.println("Enter number 1-4 only.");
            }
        } 
    }
    
    
    public void loadFiles() {
    }
    
    
    public int logIn() {
        System.out.println("Please login");
        System.out.print("Enter your ID: ");
        String enteredId = sc.nextLine();
        System.out.print("Enter your password: ");
        String enteredPw = sc.nextLine();
        for (Contestant i : listContestants) {
            if (enteredPw.compareTo(i.getId()) == 0 && enteredPw.compareTo(i.getPw()) == 0) {
                i.setStatus(1);
                System.out.println("Welcome Contestant " + i.getName() + ".");
                return 1;
            }
        }
        
        for (Organizer i : listOrganizers) {
            if (enteredPw.compareTo(i.getId()) == 0 && enteredPw.compareTo(i.getPw()) == 0) {
                i.setStatus(1);
                System.out.println("Welcome Organizer " + i.getName() + ".");
                return 2;
            }
        }
        return 0;
    }
    
    
    public void run() {
        loadFiles();
        System.out.println("Welcome to Contest Management System.");
        int t = logIn();
        while (t == 0) {
            System.out.println("Wrong ID or password. Please try to log in again.");
            t = logIn();
        }
        index = 0;
        if (t == 1) {
            for (Contestant i : listContestants) {
                if (i.getStatus() == 1) {
                    break;
                }
                index++;
            }
            listContestants.get(index).run();
        } else if (t == 2) {
            for (Organizer i : listOrganizers) {
                if (i.getStatus() == 1) {
                    break;
                }
                index++;
            }
            listOrganizers.get(index).run();
        }

    }


    void printContest() {
        System.out.println(test);
    }

    void displayContestants() {
        System.out.println(listContestants);
    }

    

}
