
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
        private ArrayList<CategoryProblem> listProblems = new ArrayList<CategoryProblem>();
        private ArrayList<Contest> listContests = new ArrayList<Contest>();

        Scanner sc = new Scanner(System.in);

        private boolean validateName(String s) {
                for (int i = 0; i < s.length(); i++) {
                        if (!Character.isLetter(s.charAt(i)) && s.charAt(i) != ' ') {
                                return false;
                        }
                }
                return true;
        }

        private boolean validateEmail(String s) {
                if (!s.contains("@") || s.contains(" ") || !Character.isLetter(s.charAt(0)) || !Character.isLetter(s.charAt(s.length()-1))) {
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

        private boolean validatePhoneNumber(String s) {
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

        private boolean validateDouble(String s) {
                for (int i = 0; i < s.length(); i++) {
                        if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ',' && s.charAt(i) != '.') {
                                return false;
                        }
                }
                return true;
        }

        private String getTime() {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                return sdf.format(timestamp);
        }

        private String getRandomIdContestant() {
                String res = "HE";
                Random rand = new Random();
                res += 100000 + rand.nextInt(900000);
                return res;
        }

        private String getRandomIdProblem() {
                Random rand = new Random();
                return "Q" + (100000 + rand.nextInt(900000));
        }

        private String getRandomIdContest() {
                Random rand = new Random();
                return "T" + (100000 + rand.nextInt(900000));
        }

        private void initialFileContestant() {
                String filename = "contestant.dat";
                try {
                        File f = new File(filename);
                        FileOutputStream fos = new FileOutputStream(f);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        Contestant temp = new Contestant();
                        temp.setEmail("LongNVHA140412@fpt.edu.vn");
                        temp.setId(getRandomIdContestant());
                        temp.setName("Nguyen Van Long");
                        temp.setPw("HA140412");
                        temp.setPhone("0123456789");
                        oos.writeObject(temp);
                        temp = new Contestant();
                        temp.setEmail("BaoDGHE130033@fpt.edu.vn");
                        temp.setId(getRandomIdContestant());
                        temp.setName("Dieu Gia Bao");
                        temp.setPw("HE130033");
                        temp.setPhone("0123456789");
                        oos.writeObject(temp);
                        temp = new Contestant();
                        temp.setEmail("AnhNLVHE140139@fpt.edu.vn");
                        temp.setId(getRandomIdContestant());
                        temp.setName("Nguyen Le Vu Anh");
                        temp.setPw("HE140139");
                        temp.setPhone("0123456789");
                        oos.writeObject(temp);
                        temp = new Contestant();
                        temp.setEmail("LongTNHE140627@fpt.edu.vn");
                        temp.setId(getRandomIdContestant());
                        temp.setName("Trinh Ngoc Long");
                        temp.setPw("HE140627");
                        temp.setPhone("0123456789");
                        oos.writeObject(temp);
                        temp = new Contestant();
                        temp.setEmail("AnVTTHE140688@fpt.edu.vn");
                        temp.setId(getRandomIdContestant());
                        temp.setName("Vu Tran Thai An");
                        temp.setPw("HE140688");
                        temp.setPhone("0123456789");
                        oos.writeObject(temp);
                        temp = new Contestant();
                        temp.setEmail("ManhTDHE140824@fpt.edu.vn");
                        temp.setId(getRandomIdContestant());
                        temp.setName("Tran Duy Manh");
                        temp.setPw("HE140824");
                        temp.setPhone("0123456789");
                        oos.writeObject(temp);
                        temp = new Contestant();
                        temp.setEmail("HoaHVHE140875@fpt.edu.vn");
                        temp.setId(getRandomIdContestant());
                        temp.setName("Hoang Van Hoa");
                        temp.setPw("HE140875");
                        temp.setPhone("0123456789");
                        oos.writeObject(temp);
                        temp = new Contestant();
                        temp.setEmail("HuyHMHE140954@fpt.edu.vn");
                        temp.setId(getRandomIdContestant());
                        temp.setName("Hoang Minh Huy");
                        temp.setPw("HE140954");
                        temp.setPhone("0123456789");
                        oos.writeObject(temp);
                        temp = new Contestant();
                        temp.setEmail("AnhTTHE141110@fpt.edu.vn");
                        temp.setId(getRandomIdContestant());
                        temp.setName("Tran Tuan Anh");
                        temp.setPw("HE141110");
                        temp.setPhone("0123456789");
                        oos.writeObject(temp);
                        temp = new Contestant();
                        temp.setEmail("DuyPNHE141250@fpt.edu.vn");
                        temp.setId(getRandomIdContestant());
                        temp.setName("Phung Nam Duy");
                        temp.setPw("HE141250");
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

        private void initialFileProblem() {
                String filename = "QBs.dat";
                try {
                        File f = new File(filename);
                        FileOutputStream fos = new FileOutputStream(f);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        Problem temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("Q1");
                        temp.setShortDesc("Calculus");
                        temp.setFullDesc("Q1");
                        temp.setCategory("Calculus");
                        temp.setWeight(1);
                        temp.setAuthor("Nguyen Hoang Minh");
                        temp.setDateCreated(getTime());
                        oos.writeObject(temp);
                        temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("Q2");
                        temp.setShortDesc("Geometric");
                        temp.setFullDesc("Q2");
                        temp.setCategory("Geometric");
                        temp.setWeight(2);
                        temp.setAuthor("Phan Anh");
                        temp.setDateCreated(getTime());
                        oos.writeObject(temp);
                        temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("Q3");
                        temp.setShortDesc("Greedy");
                        temp.setFullDesc("Q3");
                        temp.setCategory("Greedy");
                        temp.setWeight(3);
                        temp.setAuthor("Nguyen Khanh Quan");
                        temp.setDateCreated(getTime());
                        oos.writeObject(temp);
                        temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("Q4");
                        temp.setShortDesc("DP");
                        temp.setFullDesc("Q4");
                        temp.setCategory("DP");
                        temp.setWeight(4);
                        temp.setAuthor("Duong Thuy Trang");
                        temp.setDateCreated(getTime());
                        oos.writeObject(temp);
                        temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("Q5");
                        temp.setShortDesc("Graph");
                        temp.setFullDesc("Q5");
                        temp.setCategory("Graph");
                        temp.setWeight(5);
                        temp.setAuthor("Le Tuan Hung");
                        temp.setDateCreated(getTime());
                        oos.writeObject(temp);
                        temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("Q6");
                        temp.setShortDesc("Calculus");
                        temp.setFullDesc("Q6");
                        temp.setCategory("Calculus");
                        temp.setWeight(6);
                        temp.setAuthor("Nguyen Hoang Minh");
                        temp.setDateCreated(getTime());
                        oos.writeObject(temp);
                        temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("Q7");
                        temp.setShortDesc("Geometric");
                        temp.setFullDesc("Q7");
                        temp.setCategory("Geometric");
                        temp.setWeight(7);
                        temp.setAuthor("Phan Anh");
                        temp.setDateCreated(getTime());
                        oos.writeObject(temp);
                        temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("Q8");
                        temp.setShortDesc("Greedy");
                        temp.setFullDesc("Q8");
                        temp.setCategory("Greedy");
                        temp.setWeight(8);
                        temp.setAuthor("Nguyen Khanh Quan");
                        temp.setDateCreated(getTime());
                        oos.writeObject(temp);
                        temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("Q9");
                        temp.setShortDesc("DP");
                        temp.setFullDesc("Q9");
                        temp.setCategory("DP");
                        temp.setWeight(9);
                        temp.setAuthor("Duong Thuy Trang");
                        temp.setDateCreated(getTime());
                        oos.writeObject(temp);
                        temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("Q10");
                        temp.setShortDesc("Graph");
                        temp.setFullDesc("Q10");
                        temp.setCategory("Graph");
                        temp.setWeight(10);
                        temp.setAuthor("Le Tuan Hung");
                        temp.setDateCreated(getTime());
                        oos.writeObject(temp);
                        temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("Q11");
                        temp.setShortDesc("Calculus");
                        temp.setFullDesc("Q11");
                        temp.setCategory("Calculus");
                        temp.setWeight(11);
                        temp.setAuthor("Nguyen Hoang Minh");
                        temp.setDateCreated(getTime());
                        oos.writeObject(temp);
                        temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("Q12");
                        temp.setShortDesc("Geometric");
                        temp.setFullDesc("Q12");
                        temp.setCategory("Geometric");
                        temp.setWeight(12);
                        temp.setAuthor("Phan Anh");
                        temp.setDateCreated(getTime());
                        oos.writeObject(temp);
                        temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("Q13");
                        temp.setShortDesc("Greedy");
                        temp.setFullDesc("Q13");
                        temp.setCategory("Greedy");
                        temp.setWeight(13);
                        temp.setAuthor("Nguyen Khanh Quan");
                        temp.setDateCreated(getTime());
                        oos.writeObject(temp);
                        temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("Q14");
                        temp.setShortDesc("DP");
                        temp.setFullDesc("Q14");
                        temp.setCategory("DP");
                        temp.setWeight(14);
                        temp.setAuthor("Duong Thuy Trang");
                        temp.setDateCreated(getTime());
                        oos.writeObject(temp);
                        temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("Q15");
                        temp.setShortDesc("Graph");
                        temp.setFullDesc("Q15");
                        temp.setCategory("Graph");
                        temp.setWeight(15);
                        temp.setAuthor("Le Tuan Hung");
                        temp.setDateCreated(getTime());
                        oos.writeObject(temp);
                        temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("Q16");
                        temp.setShortDesc("Calculus");
                        temp.setFullDesc("Q16");
                        temp.setCategory("Calculus");
                        temp.setWeight(16);
                        temp.setAuthor("Nguyen Hoang Minh");
                        temp.setDateCreated(getTime());
                        oos.writeObject(temp);
                        temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("Q17");
                        temp.setShortDesc("Geometric");
                        temp.setFullDesc("Q17");
                        temp.setCategory("Geometric");
                        temp.setWeight(17);
                        temp.setAuthor("Phan Anh");
                        temp.setDateCreated(getTime());
                        oos.writeObject(temp);
                        temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("Q18");
                        temp.setShortDesc("Greedy");
                        temp.setFullDesc("Q18");
                        temp.setCategory("Greedy");
                        temp.setWeight(18);
                        temp.setAuthor("Nguyen Khanh Quan");
                        temp.setDateCreated(getTime());
                        oos.writeObject(temp);
                        temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("Q19");
                        temp.setShortDesc("DP");
                        temp.setFullDesc("Q19");
                        temp.setCategory("DP");
                        temp.setWeight(19);
                        temp.setAuthor("Duong Thuy Trang");
                        temp.setDateCreated(getTime());
                        oos.writeObject(temp);
                        temp = new Problem();
                        temp.setId(getRandomIdProblem());
                        temp.setName("Q20");
                        temp.setShortDesc("Graph");
                        temp.setFullDesc("Q20");
                        temp.setCategory("Graph");
                        temp.setWeight(20);
                        temp.setAuthor("Le Tuan Hung");
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

        private void initialFile() {
                initialFileProblem();
                initialFileContestant();
        }

        private void readFileContestant() {
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

        private void readFileProblem() {
                String filename = "QBs.dat";
                try {
                        File f = new File(filename);
                        FileInputStream fis = new FileInputStream(f);
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        Problem pX = new Problem();
                        while (true) {
                                try {
                                        pX = (Problem) ois.readObject();
                                        boolean flag = false;
                                        for (CategoryProblem i: listProblems) {
                                                if (i.getCategory().compareToIgnoreCase(pX.getCategory()) == 0) {
                                                        i.add(pX);
                                                        flag = true;
                                                        break;
                                                }
                                        }
                                        if (!flag) {
                                                CategoryProblem temp = new CategoryProblem();
                                                temp.setCategory(pX.getCategory().toLowerCase());
                                                temp.add(pX);
                                                listProblems.add(temp);
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
        }

        private void readFileContest() {
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

        private void readFile() {
                readFileContestant();
                readFileProblem();
                readFileContest();
        }

        public void run() {
                readFile();

                boolean status = true;
                while (status) {
                        System.out.println("");
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
                        System.out.println("11. Display Category");
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
                                        updateProblemtoFile();
                                        break;
                                case "10":
                                        displayContestant();
                                        break;
                                case "11":
                                        displayCategory();
                                        break;
                                case "0":
                                        status = false;
                                        break;
                                default:
                                        System.out.println("Please enter 0-10 only.");
                                        break;
                        }
                        if (!status) {
                                break;
                        }
                }
                
                System.out.println("Thank you.");
        }

        private void loginSystem() {
                System.out.println("Please login");
                System.out.print("Enter id: ");
                String id = sc.nextLine();
                System.out.print("Enter pw: ");
                String pw = sc.nextLine();

                boolean flag = false;
                for (Contestant o : listContestants) {
                        if (id.compareTo(o.getId()) == 0 && pw.compareTo(o.getPw()) == 0) {
                                System.out.println("Login successfully as " + o.getName());
                                flag = true;
                                break;
                        }
                }
                if (!flag) {
                        System.out.println("Login failed.");
                }
        }

        private void changeInfo() {
                System.out.print("Enter Contestant's ID to change info: ");
                String id = sc.nextLine();

                boolean flag = false;
                for (Contestant o : listContestants) {
                        if (id.compareTo(o.getId()) == 0) {
                                flag = true;
                                while (true) {
                                        System.out.println("Your current name: " + o.getName());
                                        System.out.print("Type your new name, or press Enter if you don't want to change: ");
                                        String name = sc.nextLine();
                                        if (name.compareTo("") == 0) break;
                                        if (!validateName(name))      System.out.println("Wrong format of name, please reinput");
                                        else {
                                                o.setName(name);
                                                break;
                                        }
                                }
                                while (true) {        
                                        System.out.println("Your current email: " + o.getEmail());
                                        System.out.print("Type your new email, or press Enter if you don't want to change: ");
                                        String email = sc.nextLine();
                                        if (email.compareTo("") == 0) break;
                                        if (!validateEmail(email))      System.out.println("Wrong format of email, please reinput");
                                        else {
                                                o.setEmail(email);
                                                break;
                                        }
                                }
                                while (true) {
                                        System.out.println("Your current phone number: " + o.getPhone());
                                        System.out.print("Type your new phone number, or press Enter if you don't want to change: ");
                                        String phone = sc.nextLine();
                                        if (phone.compareTo("") == 0) break;
                                        if (!validatePhoneNumber(phone)) System.out.println("Wrong format of phone number, please reinput");
                                        else {
                                                o.setPhone(phone);
                                                break;
                                        }
                                }
                                System.out.println("Your current password: " + o.getPw());
                                System.out.print("Type your new password, or press Enter if you don't want to change: ");
                                String pw = sc.nextLine();
                                if (pw.compareTo("") != 0) {
                                        o.setPw(pw);
                                }
                                break;
                        }
                }

                if (!flag) {
                        System.out.println("Can't find Contestant with id " + id);
                } else System.out.println("Change infomation of " + id + " successfully");
        }

        private void addProblem() {
                System.out.println("Please add information");                
                System.out.print("Problem's name: ");
                String name = sc.nextLine();
                System.out.print("Problem's short description: ");
                String shortDesc = sc.nextLine();
                System.out.print("Problem's long description: ");
                String longDesc = sc.nextLine();
                System.out.print("Problem's category: ");
                String category = sc.nextLine();
                String weight;
                while (true) {
                        System.out.print("Problem's weight: ");
                        weight = sc.nextLine();
                        if (!validateDouble(weight)) {
                                System.out.println("Wrong format of Double, please reinput");
                        } else {
                                break;
                        }
                }
                String author;
                while (true) {
                        System.out.print("Problem's author: ");
                        author = sc.nextLine();
                        if (!validateName(author)) {
                                System.out.println("Wrong format of name, please reinput");
                        } else {
                                break;
                        }
                }
                
                String id = getRandomIdProblem();
                System.out.print("Your problem's ID will be " + id + ". Press Enter to add problem, or type no to cancel.");
                if (sc.nextLine().compareTo("") == 0) {
                        Problem temp = new Problem(name, category, Double.parseDouble(weight), shortDesc, longDesc, author);
                        temp.setId(id);
                        temp.setDateCreated(getTime());
                        boolean flag = false;
                        for (CategoryProblem i : listProblems) {
                                if (i.getCategory().compareToIgnoreCase(temp.getCategory()) == 0) {
                                        i.add(temp);
                                        flag = true;
                                        break;
                                }
                        }
                        if (!flag) {
                                CategoryProblem tem = new CategoryProblem();
                                tem.setCategory(temp.getCategory().toLowerCase());
                                tem.add(temp);
                                listProblems.add(tem);
                        }                       
                        System.out.println("Added successfully with Problem's ID: " + temp.getId());
                } else {
                        System.out.println("Added fail.");
                }
        }

        private void changeProblem() {
                System.out.print("Enter Problem's ID to change info: ");
                String id = sc.nextLine();
                boolean flag = false;
                for (CategoryProblem x: listProblems) {
                        for (int y = 0; y < x.size(); y++) {
                                Problem o = x.get(y);
                                if (id.compareTo(o.getId()) == 0) {
                                        flag = true;
                                        System.out.println("Current name: " + o.getName());
                                        System.out.print("Type new name, or press Enter if you don't want to change: ");
                                        String name = sc.nextLine();
                                        if (name.compareTo("") != 0) {
                                                o.setName(name);
                                        }
                                        System.out.println("Current short description: " + o.getShortDesc());
                                        System.out.print("Type new short description, or press Enter if you don't want to change: ");
                                        String shortDesc = sc.nextLine();
                                        if (shortDesc.compareTo("") != 0) {
                                                o.setShortDesc(shortDesc);
                                        }
                                        System.out.println("Current full description: " + o.getFullDesc());
                                        System.out.print("Type new full description, or press Enter if you don't want to change: ");
                                        String longDesc = sc.nextLine();
                                        if (longDesc.compareTo("") != 0) {
                                                o.setFullDesc(longDesc);
                                        }
                                        System.out.println("Current category: " + o.getCategory());
                                        System.out.print("Type new category, or press Enter if you dont want to change: ");
                                        String cat = sc.nextLine();
                                        if (cat.compareTo("") != 0) {
                                                o.setCategory(cat);
                                        }
                                        while (true) {
                                                System.out.println("Current weight: " + o.getWeight());
                                                System.out.print("Type new weight, or press Enter if you dont want to change: ");
                                                String weight = sc.nextLine();
                                                if (weight.compareTo("") == 0) {
                                                        break;
                                                }
                                                if (!validateDouble(weight)) {
                                                        System.out.println("Wrong format of Double, please reinput");
                                                } else {
                                                        o.setWeight(Double.parseDouble(weight));
                                                        break;
                                                }
                                        }
                                        while (true) {
                                                System.out.println("Current author: " + o.getAuthor());
                                                System.out.print("Type new author, or press Enter if you dont want to change: ");
                                                String author = sc.nextLine();
                                                if (author.compareTo("") == 0) {
                                                        break;
                                                }
                                                if (!validateName(author)) {
                                                        System.out.println("Wrong format of name, please reinput");
                                                } else {
                                                        o.setAuthor(author);
                                                        break;
                                                }
                                        }
                                        o.setDateCreated(getTime());
                                        if (o.getCategory().compareToIgnoreCase(x.getCategory()) != 0) {
                                                boolean check = false;
                                                for (CategoryProblem t1: listProblems) {
                                                        if (o.getCategory().compareToIgnoreCase(t1.getCategory()) == 0) {
                                                                t1.add(o);
                                                                check = true;
                                                                break;
                                                        }
                                                }
                                                if (!check) {
                                                        CategoryProblem t2 = new CategoryProblem();
                                                        t2.setCategory(o.getCategory().toLowerCase());
                                                        t2.add(o);
                                                        listProblems.add(t2);
                                                }
                                        }
                                        break;
                                }
                        }
                        if (flag) break;
                }

                if (!flag) {
                        System.out.println("Can't find Problem with id " + id);
                } else System.out.println("Change problem " + id + " successfully.");
        }

        private void displayProblem() {
                while (true) {                    
                        System.out.println("Press Enter to display all Problem, or choose 1 category to display: ");
                        ArrayList<String> listCategory = new ArrayList<String>();
                        
                        for (int i = 0; i < listProblems.size(); i++) {
                                listCategory.add(listProblems.get(i).getCategory().toLowerCase());
                                System.out.print((i+1) + ". " + listCategory.get(i).toUpperCase() + " ");
                        }
                        
                        String category = sc.nextLine();
                        
                        boolean flag = false;
                        
                        if (category.compareTo("") == 0) {
                                flag = true;
                                for (CategoryProblem i: listProblems) {
                                        i.display();
                                }
                        }
                        
                        if (!flag && validateDouble(category) && (Integer.parseInt(category) <= listCategory.size()) && (category != "0")) {
                                category = listCategory.get(Integer.parseInt(category)-1);
                                flag = true;
                        }
                        if (!flag) {
                                for (int i = 0; i < listCategory.size(); i++) {
                                        if (category.compareToIgnoreCase(listCategory.get(i)) == 0) {
                                                flag = true;
                                                break;
                                        }
                                }
                        }
                        
                        if (flag) {
                                for (CategoryProblem x: listProblems) {
                                        if (x.getCategory().compareToIgnoreCase(category) == 0) {
                                                System.out.println("There are " + x.size() + " " + x.getCategory() + " problems.");
                                                x.display();
                                                break;
                                        }                                        
                                }
                        }
                        else {
                                System.out.println("Wrong category.");
                        }

                        System.out.print("Press Enter to stop displaying Problem, or anything to continue.");
                        category = sc.nextLine();
                        if (category.compareTo("") == 0) break;
                }
        }

        public void displayCategory() {
                ArrayList<String> listCategory = new ArrayList<String>();
                        
                        for (int i = 0; i < listProblems.size(); i++) {
                                listCategory.add(listProblems.get(i).getCategory().toLowerCase());
                                System.out.println((i+1) + ". " + listCategory.get(i).toUpperCase() + ": " + listProblems.get(i).size() + " problems.");
                        }
        }
        
        private void displayContestant() {                
                for (Contestant o : listContestants) {
                        System.out.println(o);
                }
                System.out.println("There are " + listContestants.size() + " contestants.");
        }

        private void sortProblem() {
                Collections.sort(listProblems, CategoryProblem.sortByCategory);
                for (CategoryProblem o: listProblems) {
                        Collections.sort(o.getListProblem(), Problem.sortByWeight);
                }
                System.out.println("Sorted Problems by Category successfully.");
        }

        private void generateContest() {
                Contest test = new Contest();
                Random r = new Random();

                for (CategoryProblem o: listProblems) {
                        test.addProblem(o.get(r.nextInt(o.size())));
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

        private void writeContestToFile(Contest test) {
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
                        oos.writeObject(test); //chua chac no da append test vao
                        oos.flush();
                        oos.close();
                        fos.close();
                } catch (Exception e) {
                        e.printStackTrace();
                        e.getMessage();
                }
        }

        private void printContestById() {
                System.out.print("Enter Contest's ID to display: ");
                String id = sc.nextLine();
                for (Contest o: listContests) {
                        if (o.getId().compareToIgnoreCase(id) == 0) {
                                o.display();
                                break;
                        }
                }
        }

        private void updateProblemtoFile() {
                String filename = "QBs.dat";
                try {
                        File f = new File(filename);
                        FileOutputStream fos = new FileOutputStream(f);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        for (CategoryProblem x: listProblems) {
                                for (int y = 0; y < x.size(); y++) {
                                        oos.writeObject(x.get(y));
                                }
                        }                        
                        oos.flush();
                        oos.close();
                        fos.close();
                } catch (Exception e) {
                        e.printStackTrace();
                        e.getMessage();
                }
                System.out.println("Successfully export all problems to file QBs.dat");
        }
        
}
