import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class validatemail {
    private String emailPattern;
    private Pattern pattern;

    public validatemail() {
        // Regular expression pattern for a valid email address
        emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        pattern = Pattern.compile(emailPattern);
    }

    public boolean isValidEmail(String email) {
        // Create a Matcher object to match the input email against the pattern
        Matcher matcher = pattern.matcher(email);
        // Return true if the email matches the pattern, false otherwise
        return matcher.matches();
    }
}
