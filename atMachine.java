import java.util.Scanner;
public class atMachine {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("WELCOME USER!");

		int accountName = 12345;
		int password = 67890;
		double balance = 10000;
		int account = 3;
        int pass = 3;
		double fee = 0;

		while (account > 0 || pass > 0) {
			System.out.print("Enter Your Account Number: ");
			int accountNumber = scan.nextInt();
            
			if (accountNumber == accountName) {
				System.out.print("Enter Your Password: ");
				int accountPassword = scan.nextInt();

				if (accountPassword == password) {
					System.out.println("Account Login!");
					System.out.println("Enter Account Type");
					System.out.println("1 - Savings");
					System.out.println("2 - Checking");
					char type = scan.next().charAt(0);
					
					if (type == '1') {
						System.out.println("Savings Selected");
						System.out.print("Enter Withdrawal: ");
						double withdraw = scan.nextDouble();
                        double remainingBalance = balance - withdraw - fee;

                        if (withdraw > balance) {
                            System.out.println("Insufficient Funds.");
                            return;
                        } else if (withdraw % 100 != 0) {
                            System.out.println("ATM only dispenses bills in multiples of 100.");
                            return;
                        } else if (balance - withdraw - fee < 100) {
                            System.out.println("Minimum Balance Rule Violated: You must maintain at least 100 in your account.");
                            return;
                        } else {
                            System.out.println("");
                            System.out.println("-----Transaction Summary------");
                            System.out.println("Account Number:       " + accountNumber);
                            System.out.println("Account Type:         " + type);
                            System.out.println("Starting Balance:     " + balance);
                            System.out.println("Withdrawal Amount:    " + withdraw);
                            System.out.println("Service Fee:          " + fee);
                            System.out.println("Remaining Balance:    " + remainingBalance);
                            System.out.println("----Transaction Successful.----");
                            return;
                        }

					} else if (type == '2') {
						System.out.println("Checking Selected");
						System.out.print("Enter Withdrawal: ");
						double withdraw = scan.nextDouble();
                        fee += 10;
                        double remainingBalance = balance - withdraw - fee;

                        if (withdraw > balance) {
                            System.out.println("Insufficient Funds.");
                            return;
                        } else if (withdraw % 100 != 0) {
                            System.out.println("ATM only dispenses bills in multiples of 100.");
                            return;
                        } else if (balance - withdraw - fee < 100) {
                            System.out.println("Minimum Balance Rule Violated: You must maintain at least 100 in your account.");
                            return;
                        } else {
                            System.out.println("");
                            System.out.println("-----Transaction Summary------");
                            System.out.println("Account Number:       " + accountNumber);
                            System.out.println("Account Type:         " + type);
                            System.out.println("Starting Balance:     " + balance);
                            System.out.println("Withdrawal Amount:    " + withdraw);
                            System.out.println("Service Fee:          " + fee);
                            System.out.println("Remaining Balance:    " + remainingBalance);
                            System.out.println("----Transaction Successful.----");
                            return;
                        }

					} else {
						System.out.println("Invalid Input");
                        return;
					}

				} else {
					pass--;
                    System.out.println("");
					System.out.println("Invalid Password, Enter Again! " + pass + " Left");
				}
			} else {
				account--;
                System.out.println("");
				System.out.println("Invalid Account Name, Enter Again! " + account + " Left");
			} if (account == 0 || pass == 0) {
				System.out.println("ACCOUNT/USER BLOCKED");
                return;
            }
		} 
	} 
}
