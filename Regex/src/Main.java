
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author trinh
 */
public class Main {

    public static String getAccount() {
        Scanner sc = new Scanner(System.in);
        String account = "";
        while (true) {
            System.out.print("input account: ");
            account = sc.nextLine();
            Pattern p = Pattern.compile("^[0-9]{10}$");
            if (p.matcher(account).find()) {
                break;
            } else {
                System.err.println("invalid account, please input again");
            }

        }
        return account;
    }
    public static String getPass() {
        Scanner sc = new Scanner(System.in);
        String password = "";
        while (true) {
            System.out.print("input password: ");
            password = sc.nextLine();
            Pattern p = Pattern.compile("^[0-9A-Za-z]{8,31}$");
            Pattern pDigit = Pattern.compile("^[0-9a-zA-Z]*[0-9]+[0-9a-zA-Z]*");
            Pattern pAnpha = Pattern.compile("^[0-9a-zA-Z]*[a-zA-Z]+[0-9a-zA-Z]*");
            if (p.matcher(password).find() && pDigit.matcher(password).find() 
                    && pAnpha.matcher(password).find()) {
                break;
            } else {
                System.err.println("invalid account, please input again");
            }
        }
        return password;
    }

    public static void main(String[] args) {
        String acc = getAccount();
        System.out.println("account: " + acc);
        String pass = getPass();
        System.out.println("password: " + pass);
    }
}
