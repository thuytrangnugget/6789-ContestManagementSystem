
import java.io.Serializable;
import java.util.ArrayList;

public class Contest implements Serializable {

        private String id;
        private ArrayList<Problem> listProblems = new ArrayList<Problem>();
        private int maxMark;
        private String date;
        private String author;

        public void addProblem(Problem temp) {
                boolean flag = true;

                for (Problem i : listProblems) {      
                        if (temp.getCategory().compareTo(i.getCategory()) == 0) {
                                flag = false;
                                break;
                        }
                }
                if (flag) {
                        listProblems.add(temp);
                }
        }

        public void display() {
                System.out.println("Contest's ID: " + id);
                System.out.println("Contest's date: " + date);
                System.out.println("Contest's author: " + author);
                System.out.println("Contest's maxMark: " + maxMark);
                System.out.println("Contest's questions: ");
                for (Problem i : listProblems) {
                        System.out.println(i);
                }
        }

        public int getSize() {
                return listProblems.size();
        }

        public Problem getProblemByIndex(int index) {
                return listProblems.get(index);
        }

        public String getCategoryofProblem(Problem t) {
                return t.getCategory();
        }

        public void removeLastProblem() {
                listProblems.remove(listProblems.size() - 1);
        }

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public int getMaxMark() {
                return maxMark;
        }

        public void setMaxMark() {
                for (Problem i : listProblems) {
                        maxMark += i.getWeight();
                }
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

}
