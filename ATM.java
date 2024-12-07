import java.util.Scanner;

public class ATM {
    private double balance;
    private int pin;

    
    public ATM(double initialBalance, int initialPin) {
        this.balance = initialBalance;
        this.pin = initialPin;
    }

   
    public boolean validatePin(int enteredPin) {
        return this.pin == enteredPin;
    }

    
    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Transaction failed.");
        } else if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a valid amount.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful! Please collect your cash.");
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a valid amount.");
        } else {
            balance += amount;
            System.out.println("Deposit successful!");
        }
    }

    public void changePin(int newPin) {
        this.pin = newPin;
        System.out.println("PIN changed successfully.");
    }

    public static void main(String[] args) {
        ATM myAtm = new ATM(1000.0, 1234); // Initial balance = $1000, PIN = 1234
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");
        System.out.print("Please enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (!myAtm.validatePin(enteredPin)) {
            System.out.println("Invalid PIN. Exiting.");
            scanner.close();
            return;
        }

        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    myAtm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    myAtm.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    myAtm.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter new PIN: ");
                    int newPin = scanner.nextInt();
                    myAtm.changePin(newPin);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
