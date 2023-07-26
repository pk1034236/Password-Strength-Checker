import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        int passwordLength = password.length();
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasSpecialChar = password.matches(".*[^a-zA-Z0-9].*");

        int strengthScore = calculateStrengthScore(passwordLength, hasUppercase, hasLowercase, hasNumber, hasSpecialChar);
        String strengthDescription = getStrengthDescription(strengthScore);

        System.out.println("Password Strength: " + strengthDescription);

        scanner.close();
    }

    public static int calculateStrengthScore(int length, boolean hasUppercase, boolean hasLowercase, boolean hasNumber, boolean hasSpecialChar) {
        int score = 0;

        // Length criteria
        if (length >= 8) {
            score += 2;
        } else if (length >= 6) {
            score += 1;
        }

        // Uppercase letter criteria
        if (hasUppercase) {
            score += 2;
        }

        // Lowercase letter criteria
        if (hasLowercase) {
            score += 2;
        }

        // Number criteria
        if (hasNumber) {
            score += 2;
        }

        // Special character criteria
        if (hasSpecialChar) {
            score += 2;
        }

        return score;
    }

    public static String getStrengthDescription(int strengthScore) {
        if (strengthScore >= 10) {
            return "Strong";
        } else if (strengthScore >= 6) {
            return "Moderate";
        } else {
            return "Weak";
        }
    }
}

