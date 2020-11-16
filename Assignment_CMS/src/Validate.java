
public class Validate {

    private boolean verifyEmail(String email) {
        email = email.trim();

        if (email == null || email.equals("")) {
            return false;
        }

        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            return false;
        }

        return true;
    }

    private boolean verifyPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.trim();
        if (phoneNumber == null || phoneNumber.equals("")) {
            return false;
        }
        if (!phoneNumber.matches("+084-0-9")){
            return false;
    }
    return true;
}
}

