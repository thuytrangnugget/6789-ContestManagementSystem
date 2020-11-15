
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Host {

        private ArrayList<Contestant> listContestants = new ArrayList<Contestant>();
        private ArrayList<Problem> listProblems = new ArrayList<Problem>();
        private ArrayList<Contest> listContests = new ArrayList<Contest>();

        Scanner sc = new Scanner(System.in);

        public boolean validateName(String s) {
                for (int i = 0; i < s.length(); i++) {
                        if (!Character.isLetter(s.charAt(i)) && s.charAt(i) != ' ') {
                                return false;
                        }
                }
                return true;
        }

        public boolean validateEmail(String s) {
                if (!s.contains("@") || s.contains(" ") || !Character.isLetter(s.charAt(0))) {
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

        public String getTime() {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                return sdf.format(timestamp);
        }

        public String getRandomIdContestant() {
                String res = "HE";
                Random rand = new Random();
                res += 100000 + rand.nextInt(900000);
                return res;
        }

        public String getRandomIdProblem() {
                Random rand = new Random();
                return "Q" + (100000 + rand.nextInt(900000));
        }

        public String getRandomIdContest() {
                Random rand = new Random();
                return "T" + (100000 + rand.nextInt(900000));
        }

        public void initialFileContestant() {
                String filename = "contestant.dat";
                try {
                        File f = new File(filename);
                        FileOutputStream fos = new FileOutputStream(f);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        Contestant temp = new Contestant();
                        temp.setEmail("longnvha140412@fpt.edu.vn");
                        temp.setId(getRandomIdContestant());
                        temp.setName("Nguyen Van Long");
                        temp.setPw("HA140412");
                        temp.setPhone("0123456789");
                        oos.writeObject(temp);
                        temp = new Contestant();
                        temp.setEmail("longnvha140412@fpt.edu.vn");
                        temp.setId(getRandomIdContestant());
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
        }

        public void initialFileProblem() {
                String filename = "QBs.dat";
                try {
                        File f = new File(filename);
                        FileOutputStream fos = new FileOutputStream(f);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        Problem temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("Calculus");
                        temp.setShortDesc("Q1");
                        temp.setFullDesc("Q1");
                        temp.setCategory("Calculus");
                        temp.setWeight(1);
                        temp.setAuthor("Nguyen Hoang Minh");
                        temp.setDateCreated(getTime());
                        oos.writeObject(temp);
                        temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("Geometric");
                        temp.setShortDesc("Q2");
                        temp.setFullDesc("Q2");
                        temp.setCategory("Geometric");
                        temp.setWeight(1);
                        temp.setAuthor("Nguyen Hoang Minh");
                        temp.setDateCreated(getTime());
                        oos.writeObject(temp);
                        temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("Greedy");
                        temp.setShortDesc("Q3");
                        temp.setFullDesc("Q3");
                        temp.setCategory("Greedy");
                        temp.setWeight(1);
                        temp.setAuthor("Nguyen Hoang Minh");
                        temp.setDateCreated(getTime());
                        oos.writeObject(temp);
                        temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("DP");
                        temp.setShortDesc("Q4");
                        temp.setFullDesc("Q4");
                        temp.setCategory("DP");
                        temp.setWeight(1);
                        temp.setAuthor("Nguyen Hoang Minh");
                        temp.setDateCreated(getTime());
                        oos.writeObject(temp);
                        temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("Graph");
                        temp.setShortDesc("Q5");
                        temp.setFullDesc("Q5");
                        temp.setCategory("Graph");
                        temp.setWeight(1);
                        temp.setAuthor("Nguyen Hoang Minh");
                        temp.setDateCreated(getTime());
                        oos.writeObject(temp);
                        oos.flush();
                        oos.close();
                        fos.close();
                } catch (Exception e) {
                        e.printStackTrace();
                        e.getMessage();
                }
        }

        public void initialFile() {
                initialFileProblem();
                initialFileContestant();
        }

        public void readFileContestant() {
                String filename = "contestant.dat";
                try {
                        File f = new File(filename);
                        FileInputStream fis = new FileInputStream(f);
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        Contestant pX = new Contestant();
                        while (true) {
                                try {
                                        pX = (Contestant) ois.readObject();
                                        listContestants.add(pX);
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

        public void readFileProblem() {
                String filename = "QBs.dat";
                try {
                        File f = new File(filename);
                        FileInputStream fis = new FileInputStream(f);
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        Problem pX = new Problem();
                        while (true) {
                                try {
                                        pX = (Problem) ois.readObject();
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

        public void readFileContest() {
                String filename = "contest.dat";
                try {
                        File f = new File(filename);
                        FileInputStream fis = new FileInputStream(f);
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        Contest pX = new Contest();
                        while (true) {
                                try {
                                        pX = (Contest) ois.readObject();
                                        listContests.add(pX);
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

        public void readFile() {
                readFileContestant();
                readFileProblem();
                readFileContest();
        }

        public void run() {
                initialFile();
                readFile();

                boolean status = true;
                while (status) {
                        System.out.println("Enter choice (0-10): ");
                        System.out.println("1. Login for Contestant");
                        System.out.println("2. Change info of Contestant");
                        System.out.println("3. Add Problem");
                        System.out.println("4. Change Problem");
                        System.out.println("5. Display Problem");
                        System.out.println("6. Sort Problem");
                        System.out.println("7. Generate Contest");
                        System.out.println("8. Print Contest by ID");
                        System.out.println("9. Save, load, export QBs.dat");
                        System.out.println("10. Display Contestant");
                        System.out.println("0. Exit");
                        System.out.print("Your choice: ");
                        String choice = sc.nextLine();
                        switch (choice) {
                                case "1":
                                        loginSystem();
                                        break;
                                case "2":
                                        changeInfo();
                                        break;
                                case "3":
                                        addProblem();
                                        break;
                                case "4":
                                        changeProblem();
                                        break;
                                case "5":
                                        displayProblem();
                                        break;
                                case "6":
                                        sortProblem();
                                        break;
                                case "7":
                                        generateContest();
                                        break;
                                case "8":
                                        printContestById();
                                        break;
                                case "9":
                                        //missing
                                        break;
                                case "10":
                                        displayContestant();
                                        break;
                                case "0":
                                        exit();
                                        status = false;
                                        break;
                                default:
                                        System.out.println("Please enter 0-10 only.");
                                        break;
                        }
                        if (!status) {
                                break;
                        }
                        System.out.println("Type YES to continue");
                        choice = sc.nextLine();
                        if (choice.compareToIgnoreCase("yes") != 0) {
                                break;
                        }
                }
        }

        public void loginSystem() {
                System.out.println("Please login");
                System.out.print("Enter id: ");
                String id = sc.nextLine();
                System.out.print("Enter pw: ");
                String pw = sc.nextLine();

                boolean flag = false;
                for (Contestant i : listContestants) {
                        if (id.compareTo(i.getId()) == 0 && pw.compareTo(i.getPw()) == 0) {
                                System.out.println("Login successfully as " + i.getName());
                                flag = true;
                                break;
                        }
                }
                if (!flag) {
                        System.out.println("Login failed.");
                }
        }

        public void changeInfo() {
                System.out.print("Enter Contestant's ID to change info: ");
                String id = sc.nextLine();

                boolean flag = false;
                for (Contestant i : listContestants) {
                        if (id.compareTo(i.getId()) == 0) {
                                flag = true;
                                while (true) {                        
                                        System.out.print("Change name, type no if you dont want to change: ");
                                        String name = sc.nextLine();
                                        if (!validateName(name))      System.out.println("Wrong format of name, please reinput");
                                        else {
                                                if (name.compareToIgnoreCase("no") != 0) i.setName(name);
                                                break;
                                        }
                                }
                                while (true) {                        
                                        System.out.print("Change email, type no if you dont want to change: ");
                                        String email = sc.nextLine();
                                        if (email.compareToIgnoreCase("no") == 0) break;
                                        if (!validateEmail(email))      System.out.println("Wrong format of email, please reinput");
                                        else {
                                                i.setEmail(email);
                                                break;
                                        }
                                }
                                while (true) {
                                        System.out.print("Change phone number, type no if you dont want to change: ");
                                        String phone = sc.nextLine();
                                        if (phone.compareToIgnoreCase("no") == 0) break;
                                        if (!validatePhoneNumber(phone)) System.out.println("Wrong format of phone number, please reinput");
                                        else {
                                                i.setPhone(phone);
                                                break;
                                        }
                                }
                                System.out.print("Change password, type no if you dont want to change: ");
                                String pw = sc.nextLine();
                                if (pw.compareToIgnoreCase("no") != 0) {
                                        i.setPw(pw);
                                }
                                break;
                        }
                }

                if (!flag) {
                        System.out.println("Can't find Contestant with id " + id);
                } else System.out.println("Change infomation of " + id + " successfully");
        }

        public void addProblem() {
                System.out.println("Please add information");

                boolean flag = true;
                System.out.print("Problem's name, type no to cancel ");
                String name = sc.nextLine();
                if (name.compareToIgnoreCase("no") == 0) {
                        flag = false;
                }
                System.out.print("Problem's short description, type no to cancel ");
                String shortDesc = sc.nextLine();
                if (shortDesc.compareToIgnoreCase("no") == 0) {
                        flag = false;
                }
                System.out.print("Problem's long description, type no to cancel ");
                String longDesc = sc.nextLine();
                if (longDesc.compareToIgnoreCase("no") == 0) {
                        flag = false;
                }
                System.out.print("Problem's category, type no to cancel ");
                String category = sc.nextLine();
                if (category.compareToIgnoreCase("no") == 0) {
                        flag = false;
                }
                String weight;
                while (true) {
                        System.out.print("Problem's weight, type no to cancel ");
                        weight = sc.nextLine();
                        if (weight.compareToIgnoreCase("no") == 0) {
                                flag = false;
                                break;
                        }
                        if (!validateDouble(weight)) {
                                System.out.println("Wrong format of Double, please reinput");
                        } else {
                                break;
                        }
                }
                String author;
                while (true) {
                        System.out.print("Problem's author, type no to cancel ");
                        author = sc.nextLine();
                        if (author.compareToIgnoreCase("no") == 0) {
                                flag = false;
                                break;
                        }
                        if (!validateName(author)) {
                                System.out.println("Wrong format of name, please reinput");
                        } else {
                                break;
                        }
                }

                if (flag) {
                        Problem temp = new Problem(name, category, Double.parseDouble(weight), shortDesc, longDesc, author);
                        temp.setId(getRandomIdProblem());
                        listProblems.add(temp);
                        System.out.println("added successfully with Problem's ID: " + temp.getId());
                } else {
                        System.out.println("added fail");
                }
        }

        public void changeProblem() {
                System.out.print("Enter Problem's ID to change info: ");
                String id = sc.nextLine();

                boolean flag = false;
                for (Problem i : listProblems) {
                        if (id.compareTo(i.getId()) == 0) {
                                flag = true;
                                System.out.print("Change name, type no if you dont want to change: ");
                                String name = sc.nextLine();
                                if (name.compareToIgnoreCase("no") != 0) {
                                        i.setName(name);
                                }
                                System.out.print("Change short description, type no if you dont want to change: ");
                                String shortDesc = sc.nextLine();
                                if (shortDesc.compareToIgnoreCase("no") != 0) {
                                        i.setShortDesc(shortDesc);
                                }
                                System.out.print("Change full description, type no if you dont want to change: ");
                                String longDesc = sc.nextLine();
                                if (longDesc.compareToIgnoreCase("no") != 0) {
                                        i.setFullDesc(longDesc);
                                }
                                System.out.print("Change category, type no if you dont want to change: ");
                                String cat = sc.nextLine();
                                if (cat.compareToIgnoreCase("no") != 0) {
                                        i.setCategory(cat);
                                }
                                while (true) {
                                        System.out.print("Change weight, type no if you dont want to change: ");
                                        String weight = sc.nextLine();
                                        if (weight.compareToIgnoreCase("no") == 0) {
                                                break;
                                        }
                                        if (!validateDouble(weight)) {
                                                System.out.println("Wrong format of Double, please reinput");
                                        } else {
                                                i.setWeight(Double.parseDouble(weight));
                                                break;
                                        }
                                }
                                while (true) {
                                        System.out.print("Change author, type no if you dont want to change: ");
                                        String author = sc.nextLine();
                                        if (!validateName(author)) {
                                                System.out.println("Wrong format of name, please reinput");
                                        } else {
                                                if (author.compareToIgnoreCase("no") != 0) {
                                                        i.setAuthor(author);
                                                }
                                                break;
                                        }
                                }
                                i.setDateCreated(getTime());
                                break;
                        }
                }

                if (flag == false) {
                        System.out.println("Can't find Problem with id " + id);
                }
        }

        public void displayProblem() {
                for (Problem i : listProblems) {
                        System.out.println(i);
                }
        }

        public void displayContestant() {
                for (Contestant i : listContestants) {
                        System.out.println(i);
                }
        }

        public void sortProblem() {
                Collections.sort(listProblems, Problem.sortByCategory);
                System.out.println("Sorted by Category");
        }

        public void generateContest() {
                Contest test = new Contest();
                Random r = new Random();

                while (test.getSize() < 5) {
                        test.addProblem(listProblems.get(r.nextInt(listProblems.size())));
                }

                test.setId(getRandomIdContest());
                while (true) {
                        System.out.print("Enter author's name: ");
                        String author = sc.nextLine();
                        if (!validateName(author)) {
                                System.out.println("Wrong format of name, please reinput");
                        } else {
                                test.setAuthor(author);
                                break;
                        }
                }
                test.setDate(getTime());
                test.setMaxMark();
                writeContestToFile(test);
                listContests.add(test);
                System.out.println("Generate test successfully with ID: " + test.getId());
        }

        public void writeContestToFile(Contest test) {
                String filename = "Contest_" + test.getId() + ".txt";
                try {
                        File f = new File(filename);
                        FileOutputStream fos = new FileOutputStream(f);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(test);
                        oos.flush();
                        oos.close();
                        fos.close();
                } catch (Exception e) {
                        e.printStackTrace();
                        e.getMessage();
                }

                filename = "contest.dat";
                try {
                        File f = new File(filename);
                        FileOutputStream fos = new FileOutputStream(f);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(test);
                        oos.flush();
                        oos.close();
                        fos.close();
                } catch (Exception e) {
                        e.printStackTrace();
                        e.getMessage();
                }
        }

        public void printContestById() {
                System.out.print("Enter Contest's ID to display: ");
                String id = sc.nextLine();
                for (Contest i : listContests) {
                        if (i.getId().compareToIgnoreCase(id) == 0) {
                                i.display();
                                break;
                        }
                }
        }

        public void exit() {
                System.out.println("Thank you.");
        }
}
