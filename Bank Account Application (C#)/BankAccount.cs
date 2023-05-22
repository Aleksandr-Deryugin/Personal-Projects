using System;
					
public class Program
{
	public static void Main()
	{
		string shouldcontinue = "Yes";
		string userchoice = "Yes";
		
		//Greeting User + Asking if the User wants to use the program
		Console.WriteLine("Hello! Welcome to your checking and savings account program!");
		Console.WriteLine("Do you want to begin? Yes or No");
		userchoice = Console.ReadLine();
		
		if(userchoice == "Yes")
		{
			BankAccount Checking = new BankAccount("Checking", 0);
			BankAccount Saving = new BankAccount("Saving", 0);
			
			
			//Getting + Setting Checking Balance
			Console.WriteLine("\nOkay, to start off, how much is currently in your Checking Account?");
			decimal CheckingBalance = Decimal.Parse(Console.ReadLine());
			
			
			Console.WriteLine("\nOkay,now how much is currently in your Saving Account?");
			decimal SavingBalance = Decimal.Parse(Console.ReadLine());
			
			while(shouldcontinue == "Yes")
			{	
			Checking.setBalance(CheckingBalance);
			Saving.setBalance(SavingBalance);
				//Transfering Money From Checking To Savings
				Console.WriteLine("\nOkay now how much do you want to save?");
				decimal TransferAmount = Decimal.Parse(Console.ReadLine());
				
				//Stating New Checking + Saving Balance
				//decimal SavingBalance = Saving.getBalance();
				Transfer.SaveMoney(ref CheckingBalance, ref SavingBalance, TransferAmount);
				
				//Ask User If Need Another Transaction
				Console.WriteLine("\nDo you want to make another transaction? Yes or No");
				shouldcontinue = Console.ReadLine();
			}
			Console.WriteLine("Okay, have a nice day!");
			
		}
		else
		{
			Console.WriteLine("Okay, have a nice day!");
		}
	
	}
	class BankAccount
	{
		private string accounttype;
		private decimal balance;
		
		public BankAccount(string _accounttype, decimal _balance)
		{
			this.accounttype = _accounttype;
			this.balance = _balance;
		}
		
		//Getter + Setter for AccountType
		public string getAccoutType(){return this.accounttype;}
		public void setAccountType(string account){this.accounttype = account;}
		
		//Getter + Setter for balance
		public decimal getBalance()
		{return this.balance;}
		public void setBalance(decimal _balance){this.balance = _balance;}
	}
	
	class Transfer 
	{	
		public static void SaveMoney(ref decimal Checking, ref decimal Saving, decimal transferAmount) 
		{
			if(transferAmount <= Checking)
			{
				Checking = Checking - transferAmount;
				Console.WriteLine("\nOkay, your updated Checking balance is: $" + Checking + ".");
					
				Saving = Saving + transferAmount;
				Console.WriteLine("Here is your update Saving balance is: $" + Saving + ".");
			} 
			else
			{
				Console.WriteLine("Sorry, your transfer request has been denied.");
				Console.WriteLine("You tried to transfer more money into you Saving than you had in your Checking, resulting in Checking balance becoming negative.");
			}
		}
	}
}
