package contact;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author trinh
 */
public class Validation {

    Scanner sc = new Scanner(System.in);

    public void menu() {
        System.out.println("1. Add a contact");
        System.out.println("2. Display all contacts");
        System.out.println("3. Delete a contact");
        System.out.println("4. Exit");
    }

    public int getChoice() {
        int choice = 0;
        while (true) {
            try {
                System.out.print("input your choice: ");
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= 4) {
                    break;
                }
            } catch (Exception e) {
                System.err.println("invalid choice, please input again");
            }
        }
        return choice;
    }

    public int getIdToDelete() {
        int id = 0;
        while (true) {
            try {
                System.out.print("input id: ");
                id = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("invalid id, please input again");
            }
        }
        return id;
    }

    public int getIdToAdd(ArrayList<Contact> list) {
        if (list.isEmpty()) {
            return 1;
        } else {
            int lastIndex = list.size() - 1;
            int lastId = list.get(lastIndex).getId();
            int newId = lastId + 1;
            return newId;
        }
    }

    public String getString(String mess1, String mess2) {
        while (true) {
            System.out.print(mess1);
            String name = sc.nextLine();
            Pattern p = Pattern.compile("^[a-zA-Z ]+$");
            if (p.matcher(name).find()) {
                return name;
            } else {
                System.err.println(mess2);
            }
        }
    }

    public String getPhone() {
        String phone = "";
        while (true) {
            System.out.print("input phone: ");
            phone = sc.nextLine();
            //^[0-9]{10}$
            //^[0-9]{3}-[0-9]{3}-[0-9]{4}$
            //[0-9]{3}.[0-9]{3}.[0-9]{4}
            //[0-9]{3} [0-9]{3} [0-9]{4}
            //[0-9]{3}-[0-9]{3}-[0-9]{4} (x|ext)[0-9]{4}
            //^\\([0-9]{3}\\)-[0-9]{3}-[0-9]{4}$
            Pattern p = Pattern.compile("^[0-9]{10}$");
            Pattern p1 = Pattern.compile("^[0-9]{3}-[0-9]{3}-[0-9]{4}$");
            Pattern p2 = Pattern.compile("^[0-9]{3}.[0-9]{3}.[0-9]{4}$");
            Pattern p3 = Pattern.compile("^[0-9]{3} [0-9]{3} [0-9]{4}$");
            Pattern p4 = Pattern.compile("^[0-9]{3}-[0-9]{3}-[0-9]{4} (x|ext)[0-9]{4}$");
            Pattern p5 = Pattern.compile("^\\([0-9]{3}\\)-[0-9]{3}-[0-9]{4}$");
            if (p.matcher(phone).find() || p1.matcher(phone).find() || p2.matcher(phone).find()
                    || p3.matcher(phone).find() || p4.matcher(phone).find() || p5.matcher(phone).find()) {
                break;
            } else {
                System.err.println("invalid phone, please input again: ");
            }
        }
        return phone;
    }

}
