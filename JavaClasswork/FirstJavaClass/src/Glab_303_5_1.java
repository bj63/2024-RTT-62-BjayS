public class Glab_303_5_1 {
}
import java.util.Scanner;

public class IncomeTaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter filing status (Single, Married Joint, Married Separate, Head of Household): ");
        String status = scanner.nextLine();

        System.out.println("Enter taxable income: ");
        double income = scanner.nextDouble();

        double tax = 0;

        switch (status.toLowerCase()) {
            case "single":
                tax = calculateSingleTax(income);
                break;
            case "married joint":
                tax = calculateMarriedJointTax(income);
                break;
            case "married separate":
                tax = calculateMarriedSeparateTax(income);
                break;
            case "head of household":
                tax = calculateHeadOfHouseholdTax(income);
                break;
            default:
                System.out.println("Invalid filing status");
                return;
        }

        System.out.println("Tax: $" + tax);
    }

    public static double calculateSingleTax(double income) {
        // Calculate tax for single filers
        // Insert tax calculation logic here
    }

    public static double calculateMarriedJointTax(double income) {
        // Calculate tax for married joint filers
        // Insert tax calculation logic here
    }

    public static double calculateMarriedSeparateTax(double income) {
        // Calculate tax for married separate filers
        // Insert tax calculation logic here
    }

    public static double calculateHeadOfHouseholdTax(double income) {
        // Calculate tax for head of household filers
        // Insert tax calculation logic here
    }
}
import java.util.Scanner;

public class IncomeTaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter filing status (Single, Married Joint, Married Separate, Head of Household): ");
        String status = scanner.nextLine();

        System.out.println("Enter taxable income: ");
        double income = scanner.nextDouble();

        double tax = 0;

        switch (status.toLowerCase()) {
            case "single":
                tax = calculateSingleTax(income);
                break;
            case "married joint":
                tax = calculateMarriedJointTax(income);
                break;
            case "married separate":
                tax = calculateMarriedSeparateTax(income);
                break;
            case "head of household":
                tax = calculateHeadOfHouseholdTax(income);
                break;
            default:
                System.out.println("Invalid filing status");
                return;
        }

        System.out.println("Tax: $" + tax);
    }

    public static double calculateSingleTax(double income) {
        if (income <= 8350) {
            return income * 0.10;
        } else if (income <= 33950) {
            return 8350 * 0.10 + (income - 8350) * 0.15;
        } else if (income <= 82250) {
            return 8350 * 0.10 + (33950 - 8350) * 0.15 + (income - 33950) * 0.25;
        } else if (income <= 171550) {
            return 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (income - 82250) * 0.28;
        } else if (income <= 372950) {
            return 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (income - 171550) * 0.33;
        } else {
            return 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (372950 - 171550) * 0.33 + (income - 372950) * 0.35;
        }
    }

    public static double calculateMarriedJointTax(double income) {
        // Similar logic as single tax calculation, but with different income thresholds
        // Implement calculation logic here
    }

    public static double calculateMarriedSeparateTax(double income) {
        // Similar logic as single tax calculation, but with different income thresholds
        // Implement calculation logic here
    }

    public static double calculateHeadOfHouseholdTax(double income) {
        // Similar logic as single tax calculation, but with different income thresholds
        // Implement calculation logic here
    }
}
import java.util.Scanner;

public class IncomeTaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter filing status (Single, Married Joint, Married Separate, Head of Household): ");
        String status = scanner.nextLine();

        System.out.println("Enter taxable income: ");
        double income = scanner.nextDouble();

        double tax = 0;

        switch (status.toLowerCase()) {
            case "single":
                tax = calculateSingleTax(income);
                break;
            case "married joint":
                tax = calculateMarriedJointTax(income);
                break;
            case "married separate":
                tax = calculateMarriedSeparateTax(income);
                break;
            case "head of household":
                tax = calculateHeadOfHouseholdTax(income);
                break;
            default:
                System.out.println("Invalid filing status");
                return;
        }

        System.out.println("Tax: $" + tax);
    }

    public static double calculateSingleTax(double income) {
        if (income <= 8350) {
            return income * 0.10;
        } else if (income <= 33950) {
            return 8350 * 0.10 + (income - 8350) * 0.15;
        } else if (income <= 82250) {
            return 8350 * 0.10 + (33950 - 8350) * 0.15 + (income - 33950) * 0.25;
        } else if (income <= 171550) {
            return 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (income - 82250) * 0.28;
        } else if (income <= 372950) {
            return 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (income - 171550) * 0.33;
        } else {
            return 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (372950 - 171550) * 0.33 + (income - 372950) * 0.35;
        }
    }

    public static double calculateMarriedJointTax(double income) {
        if (income <= 16700) {
            return income * 0.10;
        } else if (income <= 67900) {
            return 16700 * 0.10 + (income - 16700) * 0.15;
        } else if (income <= 137050) {
            return 16700 * 0.10 + (67900 - 16700) * 0.15 + (income - 67900) * 0.25;
        } else if (income <= 208850) {
            return 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (income - 137050) * 0.28;
        } else if (income <= 372950) {
            return 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (208850 - 137050) * 0.28 + (income - 208850) * 0.33;
        } else {
            return 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (208850 - 137050) * 0.28 + (372950 - 208850) * 0.33 + (income - 372950) * 0.35;
        }
    }

    public static double calculateMarriedSeparateTax(double income) {
        if (income <= 8350) {
            return income * 0.10;
        } else if (income <= 33950) {
            return 8350 * 0.10 + (income - 8350) * 0.15;
        } else if (income <= 68525) {
            return 8350 * 0.10 + (33950 - 8350) * 0.15 + (income - 33950) * 0.25;
        } else if (income <= 104425) {
            return 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (income - 68525) * 0.28;
        } else if (income <= 186475) {
            return 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 + (income - 104425) * 0.33;
        } else {
            return 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 + (186475 - 104425) * 0.33 + (income - 186475) * 0.35;
        }
    }

    public static double calculateHeadOfHouseholdTax(double income) {
        if (income <= 11950) {
            return income * 0.10;
        } else if (income <= 45500) {
            return 11950 * 0.10 + (income - 11950) * 0.15;
        } else if (income <= 117450) {
            return 11950 * 0.10 + (45500 - 11950) * 0.15 + (income - 45500) * 0.25;
        } else if (income <= 190200) {
            return 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (income - 117450) * 0.28;
        } else if (income <= 372950) {
            return 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 + (income - 190200) * 0.33;
        } else {
            return 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 + (372950 - 190200) * 0.33 + (income - 372950) * 0.35;
        }
    }
}
