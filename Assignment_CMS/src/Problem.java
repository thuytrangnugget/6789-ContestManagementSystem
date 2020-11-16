
import java.io.Serializable;
import java.util.Comparator;


public class Problem implements Serializable{
        private String id;
        private String name;
        private String shortDesc;
        private String longDesc;
        private String category;
        private double weight;
        private String author;
        private String date;
        private static final long serialVersionUID = 1L;
        
        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getShortDesc() {
                return shortDesc;
        }

        public void setShortDesc(String shortDesc) {
                this.shortDesc = shortDesc;
        }

        public String getLongDesc() {
                return longDesc;
        }

        public void setLongDesc(String longDesc) {
                this.longDesc = longDesc;
        }

        public String getCategory() {
                return category;
        }

        public void setCategory(String category) {
                this.category = category;
        }

        public double getWeight() {
                return weight;
        }

        public void setWeight(double weight) {
                this.weight = weight;
        }

        public String getAuthor() {
                return author;
        }

        public void setAuthor(String author) {
                this.author = author;
        }

        public String getDate() {
                return date;
        }

        public void setDate(String date) {
                this.date = date;
        }

        @Override
        public String toString() {
                return "Problem{" + "id=" + id + ", name=" + name + ", shortDesc=" + shortDesc + ", longDesc=" + longDesc + ", category=" + category + ", weight=" + weight + ", author=" + author + ", date=" + date + '}';
        }
        
        public static Comparator<Problem> sortComparator = new Comparator<Problem>() {          
                @Override
                public int compare(Problem o1, Problem o2) {
                        return o1.getCategory().compareTo(o2.getCategory());
                }
        };
               
}
