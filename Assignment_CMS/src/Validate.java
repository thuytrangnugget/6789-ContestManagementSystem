
public class Validate {
   private boolean verifyEmail(String email)
{
    email = email.trim();

    if(email == null || email.equals(""))
        return false;

    if(!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"))
        return false;

    return true;
} 
}
