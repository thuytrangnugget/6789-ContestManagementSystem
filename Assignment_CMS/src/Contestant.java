
public class Contestant extends Participant {
        private int rank;
        private double mark;
        private double[] log = new double[5];

        public Contestant() {
        }

        public Contestant(int rank, String id, String name, String email, String phone, String pw) {
                super(id, name, email, phone, pw);
                this.rank = rank;
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
                        
                }
        }

        @Override
        public String toString() {
                return "Contestant{" + "rank=" + rank + '}';
        }
        
}
