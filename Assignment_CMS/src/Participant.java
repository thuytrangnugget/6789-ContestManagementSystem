
import java.util.ArrayList;
import java.util.Scanner;

public class Participant {

        private String id;
        private String name;
        private String email;
        private String phone;
        private String pw;
        private int status;
        private Contest test = new Contest();
        public ArrayList<Contestant> listContestants = new ArrayList<>();
        public ArrayList<Organizer> listOrganizers = new ArrayList<>();
        public ArrayList<Problem> listProblems = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        private int index;
        
        public Participant() {
        }

        public Participant(String id, String name, String email, String phone, String pw) {
                this.id = id;
                this.name = name;
                this.email = email;
                this.phone = phone;
                this.pw = pw;
        }

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
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

        public void loadFiles() {
        }

        public void run() {
                loadFiles();
                System.out.println("Welcome to Contest Management System.");
                int t = f1();
                while (t == 0) {
                        System.out.println("Wrong ID or password. Please try to log in again.");
                        t = f1();
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

        public int f1() {
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

        void f3() {
                System.out.println(test);
        }

        void f4() {
                System.out.println(listContestants);
        }

        

}
