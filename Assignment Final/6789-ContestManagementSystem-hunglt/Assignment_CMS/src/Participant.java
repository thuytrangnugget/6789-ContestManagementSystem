
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Participant {

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
        private static final long serialVersionUID = 1L;

        public Participant() {
        }

        public Participant(String name, String email, String phone, String pw) {
                try {
                        this.name = name;
                        this.email = email;
                        this.phone = phone;
                        this.pw = pw;
                } catch (NullPointerException e) {
                        System.out.println("fields cannot be null");
                }
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
        
        public void run() {
            System.out.println("Please log in as contestant or organizer");    
        }
        
        public void displayContestant() {                
                for (Contestant i : listContestants) {
                        System.out.println(i);
                }
                System.out.println("There are " + listContestants.size() + " contestants.");
        }
        
        public boolean validateName(String s) {
                if (s.length() > 20) return false;
                for (int i = 0; i < s.length(); i++) {
                        if (!Character.isLetter(s.charAt(i)) && s.charAt(i) != ' ') {
                                return false;
                        }
                }
                return true;
        }
        
        public boolean validateEmail(String s) {
                if (!s.contains("@") || s.contains(" ") || !Character.isLetter(s.charAt(0)) || !Character.isLetter(s.charAt(s.length()-1)) || s.length() >28) {
                        return false;
                }
                for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) == '@') {
                                s = s.substring(i + 1);
                        }
                }
                if (!s.contains(".")) {
                        return false;
                }
                return true;
        }

        public boolean validatePhoneNumber(String s) {
                if (s.charAt(0) != '0' || s.length() > 11) {
                        return false;
                }
                for (int i = 0; i < s.length(); i++) {
                        if (!Character.isDigit(s.charAt(i))) {
                                return false;
                        }
                }
                return true;
        }

        public boolean validateDouble(String s) {
                for (int i = 0; i < s.length(); i++) {
                        if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ',' && s.charAt(i) != '.') {
                                return false;
                        }
                }
                return true;
        }
        
        public void initialData() {
                String filename = "contestant.txt";
                try {
                        File f = new File(filename);
                        FileOutputStream fos = new FileOutputStream(f);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        Contestant temp = new Contestant();
                        temp.setEmail("longnvha140412@fpt.edu.vn");
                        temp.setId("HA140412");
                        temp.setName("Nguyen Van Long");
                        temp.setPw("HA140412");
                        temp.setPhone("0123456789");
                        oos.writeObject(temp);
                        oos.flush();
                        oos.close();
                        fos.close();
                } catch (Exception e) {
                        e.printStackTrace();
                        e.getMessage();
                }
                filename = "organizer.txt";
                try {
                        File f = new File(filename);
                        FileOutputStream fos = new FileOutputStream(f);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        Organizer temp = new Organizer();
                        temp.setEmail("minhnhha150125@fpt.edu.vn");
                        temp.setId("HA150125");
                        temp.setName("Nguyen Hoang Minh");
                        temp.setPw("HA150125");
                        temp.setPhone("0123456789");
                        oos.writeObject(temp);
                        oos.flush();
                        oos.close();
                        fos.close();
                } catch (Exception e) {
                        e.printStackTrace();
                        e.getMessage();
                }
                filename = "QBs.txt";
                try {
                        File f = new File(filename);
                        FileOutputStream fos = new FileOutputStream(f);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        Problem temp = new Problem();
                        temp.setId("Q1");
                        temp.setName("Calculus");
                        temp.setShortDesc("Q1");
                        temp.setLongDesc("Q1");
                        temp.setCategory("Calculus");
                        temp.setWeight(1);
                        temp.setAuthor("Nguyen Hoang Minh");
                        temp.setDate("12/11/2020");
                        oos.writeObject(temp);
                        oos.flush();
                        oos.close();
                        fos.close();
                } catch (Exception e) {
                        e.printStackTrace();
                        e.getMessage();
                }
        }

        public void loadFiles() {
                initialData();
                String filename = "contestant.txt";
                try {
                        File f = new File(filename);
                        FileInputStream fis = new FileInputStream(f);
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        while (true) {
                                try {
                                        Contestant pX = new Contestant();
                                        pX = (Contestant) ois.readObject();
                                        listContestants.add(pX);
                                        System.out.println("after added, size of listContestants = " + listContestants.size());
                                        for (Contestant i : listContestants) {
                                                System.out.println(i);
                                        }
                                } catch (EOFException e) {
                                        break;
                                }
                        }
                        fis.close();
                        ois.close();
                } catch (Exception e) {
                        e.printStackTrace();
                        e.getMessage();
                }
                
                filename = "organizer.txt";
                try {
                        File f = new File(filename);
                        FileInputStream fis = new FileInputStream(f);
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        while (true) {
                                try {
                                        Organizer pX = new Organizer();
                                        pX = (Organizer) ois.readObject();
                                        listOrganizers.add(pX);
                                } catch (EOFException e) {
                                        break;
                                }
                        }
                        fis.close();
                        ois.close();
                } catch (Exception e) {
                        e.printStackTrace();
                        e.getMessage();
                }
                
                filename = "QBs.txt";
                try {
                        File f = new File(filename);
                        FileInputStream fis = new FileInputStream(f);
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        while (true) {
                                try {
                                        Problem pX = new Problem();
                                        pX = (Problem) ois.readObject();
                                        listProblems.add(pX);
                                } catch (EOFException e) {
                                        break;
                                }
                        }
                        System.out.println("outside trycatch, size of listProblems = " + listProblems.size());
                        for (Problem i : listProblems) {
                                System.out.println(i);
                        }
                        fis.close();
                        ois.close();
                } catch (Exception e) {
                        e.printStackTrace();
                        e.getMessage();
                }

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
                String enteredId = new String();
                enteredId = sc.nextLine();
                System.out.print("Enter your password: ");
                String enteredPw = new String();
                enteredPw = sc.nextLine();
                for (Contestant i : listContestants) {
                        if (enteredId.compareTo(i.getId()) == 0 && enteredPw.compareTo(i.getPw()) == 0) {
                                i.setStatus(1);
                                System.out.println("Welcome Contestant " + i.getName() + ".");
                                return 1;
                        }
                }
                for (Organizer i : listOrganizers) {
                        if (enteredId.compareTo(i.getId()) == 0 && enteredPw.compareTo(i.getPw()) == 0) {
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
