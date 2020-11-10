
public class Contestant {
        private String id;
        private int rank;
        private String name;
        private String email;
        private String phone;
        private String pw;
        private int status;

        public Contestant() {
        }

        public Contestant(String name, String email, String phone, String pw) {
                this.name = name;
                this.email = email;
                this.phone = phone;
                this.pw = pw;
        }

        public String getId() {
                return id;
        }

        public int getRank() {
                return rank;
        }

        public String getName() {
                return name;
        }

        public String getEmail() {
                return email;
        }

        public String getPhone() {
                return phone;
        }

        public String getPw() {
                return pw;
        }

        public int getStatus() {
                return status;
        }

        public void setId(String id) {
                this.id = id;
        }

        public void setRank(int rank) {
                this.rank = rank;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public void setPw(String pw) {
                this.pw = pw;
        }

        public void setStatus(int status) {
                this.status = status;
        }

        @Override
        public String toString() {
                return "Contestant{" + "id=" + id + ", rank=" + rank + ", name=" + name + ", email=" + email + ", phone=" + phone + ", pw=" + pw + ", status=" + status + '}';
        }
        
}
