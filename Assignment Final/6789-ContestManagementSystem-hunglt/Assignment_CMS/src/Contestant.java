
import java.io.Serializable;
import java.util.Random;


public class Contestant extends Participant implements Serializable {
        private String id;
        private int rank;
        private double totalMark;
        private double[] log = new double[5];
        private static final long serialVersionUID = 1L;

        
        public Contestant() {
        }

        
        public Contestant(String name, String email, String phone, String pw) {
                super(name, email, phone, pw);
                this.id = setRandomIdContestant();
                listContestants.add(this);
        }
        
        
       private String setRandomIdContestant() {
        String res = "HE";
        Random rand = new Random();
        res += 100000 + rand.nextInt(900000);
        return res;
        }

        public String getId() {
        return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public double getTotalMark() {
            return totalMark;
        }

        public void setTotalMark(double totalMark) {
            this.totalMark = totalMark;
        }

        public double[] getLog() {
            return log;
        }

        public void setLog(double[] log) {
            this.log = log;
        }

        public int getRank() {
            return rank;
        }

        @Override
        public String toString() {
                return "<Contestant> |" + " ID " + id + " | NAME " + super.getName() + " | EMAIL " + super.getEmail() + " | PHONE " + super.getPhone() + " |";
        }

        @Override
        public void run() {
                while (true) {
                        System.out.println("What do you want to do next?");
                        System.out.println("1. Change information");
                        System.out.println("2. Print contest");
                        System.out.println("3. Display scoreboard");
                        System.out.println("0. Log out");
                        System.out.print("Your choice: ");
                        int choice = sc.nextInt();
                        if (choice == 1) {
                                changeInfo();
                        } else if (choice == 2) {
                                //super.f3();
                        } else if (choice == 3) {
                                //super.f4();
                        } else if (choice == 0) {
                                listContestants.get(super.getIndex()).setStatus(0);       
                                System.out.println("Thanks for using our CMS.");
                                break;
                        } else break;
                }
        }
        
        private void changeInfo() {
        System.out.print("Changing your info: ");
        String id = getId();
        
        for (Contestant i : listContestants) {
            if (id.compareTo(i.getId()) == 0) {
                while (true) {
                    System.out.println("Your current name: " + i.getName());
                    System.out.print("Type your new name, or press Enter if you don't want to change: ");
                    String name = sc.nextLine();
                    if (name.compareTo("") == 0) {
                        break;
                    }
                    if (validateName(name)) {
                        System.out.println("Wrong format of name, please reinput");
                    } else {
                        i.setName(name);
                        break;
                    }
                }
                while (true) {
                    System.out.println("Your current email: " + i.getEmail());
                    System.out.print("Type your new email, or press Enter if you don't want to change: ");
                    String email = sc.nextLine();
                    if (email.compareTo("") == 0) {
                        break;
                    }
                    if (!validateEmail(email)) {
                        System.out.println("Wrong format of email, please reinput");
                    } else {
                        i.setEmail(email);
                        break;
                    }
                }
                while (true) {
                    System.out.println("Your current phone number: " + i.getPhone());
                    System.out.print("Type your new phone number, or press Enter if you don't want to change: ");
                    String phone = sc.nextLine();
                    if (phone.compareTo("") == 0) {
                        break;
                    }
                    if (!validatePhoneNumber(phone)) {
                        System.out.println("Wrong format of phone number, please reinput");
                    } else {
                        i.setPhone(phone);
                        break;
                    }
                }
                System.out.println("Your current password: " + i.getPw());
                System.out.print("Type your new password, or press Enter if you don't want to change: ");
                String pw = sc.nextLine();
                if (pw.compareTo("") != 0) {
                    i.setPw(pw);
                }
                break;
            }
        }

    }
        

        

}
