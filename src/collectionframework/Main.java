package collectionframework;

import java.util.*;

class Account{
    int id;
    String ownerName;
    double balance;

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "--------------Account Information----------------\n" +
                "-> Account ID : " + id + "\n" +
                "-> Owner Name : " + ownerName + "\n" +
                "-> Balance    : " + balance + "\n";
    }
}
public class Main {
    public static void main(String[] args) {

        int option;
        List<Account> accountList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("1. Add account");
            System.out.println("2. Edit Account");
            System.out.println("3. Remove Account");
            System.out.println("4. Show account information");
            System.out.println("5. Exit ");
            System.out.print("Choose option ( 1 - 5 ) : ");
            option  = input.nextInt();

            switch (option){
                case  1 :
                    Account acc = new Account();
                    System.out.println("Enter your account information");
                    System.out.print("Input ID : ");
                    acc.id = input.nextInt();
                    System.out.print("Input Name : ");
                    input.nextLine();
                    acc.ownerName = input.nextLine();
                    System.out.print("Input Balance : ");
                    acc.balance = input.nextDouble();

                    accountList.add(acc);
                    break;
                case 2 :
                    boolean idExist = false;
                    System.out.print("Enter the account ID to edit : ");
                    int editID = input.nextInt();
                    for (Account account : accountList) {
                        if (account.id == editID) {
                            idExist = true;
                            System.out.println("---------------Enter new account information-----------");
                            System.out.print("Input new account Name : ");
                            input.nextLine();
                            account.ownerName = input.nextLine();
                            System.out.print("Input new Balance : ");
                            account.balance = input.nextDouble();
                            System.out.println("Account with ID : " + editID + " has updated successfully.");
                        }
                    }
                    if(!idExist) {
                        System.out.println("Wrong ID, Please input ID again.");
                    }
                    break;
                case 3 :
                    boolean idfound = false;
                    System.out.print("Enter the account ID to remove : ");
                    int removeID = input.nextInt();
                    Iterator<Account> iter = accountList.iterator();
                    while (iter.hasNext()) {
                        Account a = iter.next();
                        if (a.id == removeID) {
                            idfound = true;
                            iter.remove();
                            System.out.println("Account with ID : " + removeID + " has removed successfully.");
                        }
                    }
                    if(!idfound) {
                        System.out.println("Wrong ID, Please input ID again.");
                    }
                    break;
                case 4 :
                    int showOption;
                    System.out.println("Show account information");
                    System.out.println("1. Ascending order (by ID)");
                    System.out.println("2. Descending order (by ID)");
                    System.out.println("3. Descending order (by Balance)");

                    System.out.print("Choose show option : ");
                    showOption = input.nextInt();
                    switch (showOption){
                        case 1:
                            Collections.sort(accountList, Comparator.comparingInt(a -> a.id));
                            for (Account account : accountList) {
                                System.out.println(account);
                            }
                            break;
                        case 2:
                            Collections.sort(accountList, Comparator.comparingInt(Account::getId).reversed());
                            for (Account account : accountList) {
                                System.out.println(account);
                            }
                            break;
                        case 3:
                            Collections.sort(accountList, Comparator.comparingDouble(Account::getBalance).reversed());
                            for (Account account : accountList) {
                                System.out.println(account);
                            }
                            break;
                    }
                    break;
                case 5 :
                    System.out.println("Exit the program....!");
                    break;
                default:
                    System.out.println("Wrong Option! Please choose from (1-5).");
                    break;
            }
        }while(option  !=5);

    }
}
