
import java.io.Serializable;
import java.util.Collections;
import java.util.Random;

public class Organizer extends Participant implements Serializable {
        private static final long serialVersionUID = 1L;
        private String id;
        //Chỉ những organizer có chuyên môn mới được tạo problem mới
        private boolean isCertifed;
        
        public Organizer() {
        }

        public Organizer(String name, String email, String phone, String pw) {
            super(name, email, phone, pw);
            this.id = setRandomIdOrganizer() ;
        }
        
        private String setRandomIdOrganizer() {
            String res = "A";
            Random rand = new Random();
            res += 100000 + rand.nextInt(900000);
            return res;
        }

        @Override
        public void run() {
                while (true) {
                        System.out.println("What do you want to do next?");
                        System.out.println("1. Change information");
                        System.out.println("2. Print contest");
                        System.out.println("3. Display scoreboard");
                        System.out.println("4. Add problem");
                        System.out.println("5. Change problem");
                        System.out.println("6. Display problems");
                        System.out.println("7. Sort problems");
                        System.out.println("8. Generate contest");
                        System.out.println("9. Save, load, export QBs.dat");
                        System.out.println("0. Log out");
                        System.out.print("Your choice: ");
                        int choice = sc.nextInt();
                        if (choice == 1) {
                                f2();
                        } else if (choice == 2) {
                                super.f3();
                        } else if (choice == 3) {
                                super.f4();
                        } else if (choice == 0) {
                                listOrganizers.get(super.getIndex()).setStatus(0);
                                System.out.println("Thanks for using our CMS.");
                                break;
                        } else if (choice == 4) {
                                Problem temp = new Problem();
                                System.out.println("Enter Problem's name: ");
                                temp.setName(sc.nextLine());
                                System.out.println("Enter Problem's shortDesc");
                                temp.setShortDesc(sc.nextLine());
                                System.out.println("Enter Problem's longDesc");
                                temp.setLongDesc(sc.nextLine());
                                System.out.println("Enter Problem's category");
                                temp.setCategory(sc.nextLine());
                                System.out.println("Enter Problem's weight");
                                temp.setWeight(sc.nextDouble());
                                temp.setAuthor(listOrganizers.get(super.getIndex()).getName());
                        } else if (choice == 5) {
                                System.out.println("Enter Problem's ID you want to change");
                                String temp = sc.nextLine();
                                int index = 0;
                                for (Problem i : listProblems) {
                                        if (i.getId().compareTo(temp) == 0) {
                                                break;
                                        }
                                        index++;
                                }
                                System.out.print("Enter new name (type no if you don't want to change");
                                temp = sc.nextLine();
                                if (temp.toLowerCase().compareTo("no") != 0) {
                                        listProblems.get(super.getIndex()).setName(temp);
                                }
                                System.out.print("Enter new short description (type no if you don't want to change");
                                temp = sc.nextLine();
                                if (temp.toLowerCase().compareTo("no") != 0) {
                                        listProblems.get(super.getIndex()).setShortDesc(temp);
                                }
                                System.out.print("Enter new long description (type no if you don't want to change");
                                temp = sc.nextLine();
                                if (temp.toLowerCase().compareTo("no") != 0) {
                                        listProblems.get(super.getIndex()).setLongDesc(temp);
                                }
                                System.out.print("Enter new category (type no if you don't want to change");
                                temp = sc.nextLine();
                                if (temp.toLowerCase().compareTo("no") != 0) {
                                        listProblems.get(super.getIndex()).setCategory(temp);
                                }
                                System.out.print("Enter new weight (type no if you don't want to change");
                                temp = sc.nextLine();
                                if (temp.toLowerCase().compareTo("no") != 0) {
                                        listProblems.get(super.getIndex()).setWeight(Double.parseDouble(temp));
                                }
                        } else if (choice == 6) {
                                System.out.println(listProblems);
                        } else if (choice == 7) {
                                Collections.sort(listProblems, Problem.sortComparator);
                        } else {
                                break;
                        }
                }
        }

        public void f2() {
                String temp;
                System.out.print("Enter new name (type no if you don't want to change");
                temp = sc.nextLine();
                if (temp.toLowerCase().compareTo("no") != 0) {
                        listOrganizers.get(super.getIndex()).setName(temp);
                }
                System.out.print("Enter new email (type no if you don't want to change");
                temp = sc.nextLine();
                if (temp.toLowerCase().compareTo("no") != 0) {
                        listOrganizers.get(super.getIndex()).setEmail(temp);
                }
                System.out.print("Enter new phone number (type no if you don't want to change");
                temp = sc.nextLine();
                if (temp.toLowerCase().compareTo("no") != 0) {
                        listOrganizers.get(super.getIndex()).setPhone(temp);
                }
                System.out.print("Enter new password (type no if you don't want to change");
                temp = sc.nextLine();
                if (temp.toLowerCase().compareTo("no") != 0) {
                        listOrganizers.get(super.getIndex()).setPw(temp);
                }
        }

}
