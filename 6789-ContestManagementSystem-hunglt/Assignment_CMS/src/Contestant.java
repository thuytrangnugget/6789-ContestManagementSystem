
public class Contestant extends Participant {
        private int rank;
        private double mark;
        private double[] log = new double[5];

        public Contestant() {
        }

        public Contestant(String name, String email, String phone, String pw) {
            super(name, email, phone, pw);
            this.id = generateID();
        }

        public int getRank() {
        return rank;
    }

        public void setRank(int rank) {
            this.rank = rank;
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
                                super.printContest();
                        } else if (choice == 3) {
                                super.displayScoreboard();
                        } else if (choice == 0) {
                                listContestants.get(super.getIndex()).setStatus(0);       
                                System.out.println("Thanks for using our CMS.");
                                break;
                        } else break;
                }
        }

        public void changeInfo() {
                String temp;
                System.out.print("Enter new name (type no if you don't want to change");
                temp = sc.nextLine();
                if (temp.toLowerCase().compareTo("no") != 0) {
                        listContestants.get(super.getIndex()).setName(temp);                        
                }
                System.out.print("Enter new email (type no if you don't want to change");
                temp = sc.nextLine();
                if (temp.toLowerCase().compareTo("no") != 0) {
                        listContestants.get(super.getIndex()).setEmail(temp);                        
                }
                System.out.print("Enter new phone number (type no if you don't want to change");
                temp = sc.nextLine();
                if (temp.toLowerCase().compareTo("no") != 0) {
                        listContestants.get(super.getIndex()).setPhone(temp);                        
                }
                System.out.print("Enter new password (type no if you don't want to change");
                temp = sc.nextLine();
                if (temp.toLowerCase().compareTo("no") != 0) {
                        listContestants.get(super.getIndex()).setPw(temp);                        
                }
        }

    @Override
    public String toString() {
        return "Contestant name" + super.name + "is ranked " + rank + ", mark: " + mark + ", log:" + log ;
    }

        

}
