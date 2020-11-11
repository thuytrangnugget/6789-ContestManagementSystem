
import java.util.ArrayList;
import java.util.Scanner;

public class Participant {

        private String id;
        private String name;
        private String email;
        private String phone;
        private String pw;
        private int status;
        private ArrayList<Contestant> listContestants = new ArrayList<>();
        private ArrayList<Organizer> listOrganizers = new ArrayList<>();
        private ArrayList<Problem> listProblems = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

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

        public void loadFiles() {
                System.out.println("Hello");
        }

        public void run() {
                loadFiles();
                System.out.println("Welcome to Contest Management System.");
                int t = f1();
                while (t == 0) {
                        System.out.println("Wrong ID or password. Please try to log in again.");
                        t = f1();
                }
                if (t == 1) {
                        Contestant temp = new Contestant();
                        for (Contestant i : listContestants) {
                                if (i.getStatus() == 1) {
                                        temp = i;
                                }
                        }
                        temp.run();
                } else if (t == 2) {
                        Organizer temp = new Organizer();
                        for (Organizer i : listOrganizers) {
                                if (i.getStatus() == 1) {
                                        temp = i;
                                }
                        }
                        temp.run();
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

}
