
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
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

        @Override
        public String toString() {
                return "Participant{" + "id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", pw=" + pw + '}';
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
        public void initialData() {
                String filename = "contestant.dat";               
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
//                        temp.setEmail("minhnhha150125@fpt.edu.vn");
//                        temp.setId("HA150125");
//                        temp.setName("Nguyen Hoang Minh");
//                        temp.setPw("HA150125");
//                        temp.setPhone("0123456789");
//                        oos.writeObject(temp);
                        oos.flush();
                        oos.close();
                        fos.close();
                } catch (Exception e) {
                        e.printStackTrace();
                        e.getMessage();
                }
                filename = "organizer.dat";               
                try {
                        File f = new File(filename);
                        FileOutputStream fos = new FileOutputStream(f);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        Organizer temp = new Organizer();
//                        temp.setEmail("longnvha140412@fpt.edu.vn");
//                        temp.setId("HA140412");
//                        temp.setName("Nguyen Van Long");
//                        temp.setPw("HA140412");
//                        temp.setPhone("0123456789");
//                        oos.writeObject(temp);
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
                filename = "QBs.dat";
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
                String filename = "contestant.dat";
                try {
                        File f = new File(filename);
                        FileInputStream fis = new FileInputStream(f);
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        while (true) {
                                try {
                                        Contestant pX = (Contestant) ois.readObject();
                                        listContestants.add(pX);
                                        listContestants.add(pX);
                                } catch (EOFException e) {
                                        break;
                                }
                        }
                        System.out.println(listContestants.size());
                        for (Contestant i: listContestants) System.out.println(i); 
                        fis.close();
                        ois.close();
                } catch (Exception e) {
                        e.printStackTrace();
                        e.getMessage();
                }

                filename = "organizer.dat";
                try {
                        File f = new File(filename);
                        FileInputStream fis = new FileInputStream(f);
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        while (true) {
                                try {
                                        Organizer pX = (Organizer) ois.readObject();
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
                filename = "QBs.dat";
                try {
                        File f = new File(filename);
                        FileInputStream fis = new FileInputStream(f);
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        while (true) {
                                try {
                                        Problem pX = (Problem) ois.readObject();
                                        listProblems.add(pX);
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
                        System.out.println(i.getId());
                        System.out.println(i.getPw());
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
