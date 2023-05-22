import java.util.*;

class Main {
  public static void main(String[] args) {
//Constructors
    
    Scanner input = new Scanner(System.in);

//Greeting User + Asking how much do they currently have in both accounts
    System.out.println("Hello User and welcome to your checking and savings account program!");
    System.out.println("To start, would you like to begin?\n>>Yes\n>>No");
    String userChoice = input.nextLine().toLowerCase();
    
    
if(userChoice.equals("yes")){
  BankAccount Checking = new BankAccount("Checking", 0);
  BankAccount Savings = new BankAccount("Savings",0);
  
  
  System.out.println("To start, how much do you have in your checking account?");
  int checkingBalance = Integer.parseInt(input.nextLine());
  
  System.out.println("How much do you have in your savings account?");
  int savingsBalance = Integer.parseInt(input.nextLine());
  
  if(savingsBalance >= 0 && checkingBalance >= 0){  
  Checking.setBalance(checkingBalance);
  Savings.setBalance(savingsBalance);
  
  System.out.println("How much would you like to transfer from you Checking to your Savings?");
  int transferAmount = Integer.parseInt(input.nextLine());
  while(true){
    
    
    
    if(transferAmount >= 0){
      Checking.transferMoney(Savings, transferAmount);
      System.out.println("Your new Checking balance is: $"+Checking.getBalance());
      System.out.println("Your new Savings balance is: $"+Savings.getBalance());
      
      System.out.println("Would you like to continue?\n>>Yes\n>>No");
      String shouldContinue = input.nextLine().toLowerCase();

      if(shouldContinue.equals("yes")||shouldContinue.equals("no")){
        if(shouldContinue.equals("yes")){System.out.println("Okay, how much would you like to transfer?");transferAmount = Integer.parseInt(input.nextLine());}
        if(shouldContinue.equals("no")){System.out.println("Okay, have a nice day!"); break;}
      }else{System.out.println("Sorry, the decision you have entered is not understood, please try again.");}
    }else{System.out.println("Sorry, the program does not allow negative values. Have a nice day!");break;}
  }
  }else{System.out.println("Sorry, the program does not allow negative values. Have a nice day!");}
/**/}else{System.out.println("Okay, have a nice day!");}
  }
}
class BankAccount{
  protected String accountType;
  protected int accountBalance = 0;
//Setting up Constructor
  public BankAccount(String AccountType, int AccountBalance){
    accountType = AccountType;
    accountBalance = AccountBalance;
  }
//Getter + Setter for Balance
  public int getBalance(){return this.accountBalance;}
  public void setBalance(int AccountBalance){accountBalance = AccountBalance;}
  
//Getter + Setter for AccountType
  public String getAccountType(){return this.accountType;}
  public void setAccountType(String AccountType){accountType = AccountType;}

//Transfering from Checking to Savings
  public void transferMoney( BankAccount bank, int amount){
    if(amount <= accountBalance){
      this.accountBalance -= amount;
      bank.accountBalance += amount;
    }else{System.out.println("Sorry, your transaction was denied as you do not have enough to transfer.");}
  }
}
