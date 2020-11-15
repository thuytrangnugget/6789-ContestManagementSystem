
import java.io.Serializable;


public class Contestant implements Serializable {
        private String id;
        private String name;
        private String email;
        private String phone;
        private String pw;

        public Contestant() {
        }

        public Contestant(String name, String email, String phone) {
                this.name = name;
                this.email = email;
                this.phone = phone;
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

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getPw() {
                return pw;
        }

        public void setPw(String pw) {
                this.pw = pw;
        }

        @Override
        public String toString() {
                return "Contestant{" + "id=" + id + ", name=" + name + '}';
        }
        
        
}
