
import java.util.ArrayList;
import java.util.Comparator;


public class CategoryProblem {
        private ArrayList<Problem> listProblem = new ArrayList<Problem>();
        private String category;
        
        public void add(Problem a) {
                listProblem.add(a);
        }

        public String getCategory() {
                return category;
        }

        public void setCategory(String category) {
                this.category = category;
        }
        
        public int size() {
                return listProblem.size();
        }
        
        public Problem get(int index) {
                return listProblem.get(index);
        }
        
        public void display() {
                for (Problem i: listProblem) {
                        System.out.println(i);
                }
        }

        public ArrayList<Problem> getListProblem() {
                return listProblem;
        }
        
        public static Comparator<CategoryProblem> sortByCategory = new Comparator<CategoryProblem>() {
                @Override
                public int compare(CategoryProblem o1, CategoryProblem o2) {
                        return o1.getCategory().compareToIgnoreCase(o2.getCategory());
                }
        };
}
