
import java.util.ArrayList;

public class Contest {
        private String id;
        private ArrayList<Problem> listProblems = new ArrayList<Problem>();
        private double maxMark;
        private String date;
        private String author;

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public ArrayList<Problem> getListProblems() {
                return listProblems;
        }

        public void setListProblems(ArrayList<Problem> listProblems) {
                this.listProblems = listProblems;
        }

        public double getMaxMark() {
                return maxMark;
        }

        public void setMaxMark(double maxMark) {
                this.maxMark = maxMark;
        }

        public String getDate() {
                return date;
        }

        public void setDate(String date) {
                this.date = date;
        }

        public String getAuthor() {
                return author;
        }

        public void setAuthor(String author) {
                this.author = author;
        }

        @Override
        public String toString() {
                return "Contest{" + "id=" + id + ", listProblems=" + listProblems + ", maxMark=" + maxMark + ", date=" + date + ", author=" + author + '}';
        }
        
}
