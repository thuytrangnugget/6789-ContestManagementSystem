
import java.io.Serializable;
import java.util.Comparator;


public class Problem implements Serializable {
        private String id;
        private String name;
        private String category;
        private double weight;
        private String shortDesc;
        private String fullDesc;
        private String dateCreated;
        private String author;

        public Problem() {
        }

        public Problem(String name, String category, double weight, String shortDesc, String fullDesc, String author) {
                this.name = name;
                this.category = category;
                this.weight = weight;
                this.shortDesc = shortDesc;
                this.fullDesc = fullDesc;
                this.author = author;
        }

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

        public String getShortDesc() {
                return shortDesc;
        }

        public void setShortDesc(String shortDesc) {
                this.shortDesc = shortDesc;
        }

        public String getFullDesc() {
                return fullDesc;
        }

        public void setFullDesc(String fullDesc) {
                this.fullDesc = fullDesc;
        }

        public String getDateCreated() {
                return dateCreated;
        }

        public void setDateCreated(String dateCreated) {
                this.dateCreated = dateCreated;
        }

        public String getAuthor() {
                return author;
        }

        public void setAuthor(String author) {
                this.author = author;
        }

        @Override
        public String toString() {
                return "Problem{" + "id=" + id + ", name=" + name + ", category=" + category + ", weight=" + weight + ", shortDesc=" + shortDesc + ", fullDesc=" + fullDesc + ", dateCreated=" + dateCreated + ", author=" + author + '}';
        }
        
        public static Comparator<Problem> sortByCategory = new Comparator<Problem>() {
                @Override
                public int compare(Problem o1, Problem o2) {
                        return o1.getCategory().compareToIgnoreCase(o2.getCategory());
                }                
        };
}
