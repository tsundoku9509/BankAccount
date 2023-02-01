import java.util.List;
import java.util.Scanner;

import controller.BankHelp;
import model.Bank;

/**
 * @author ajlj - Austin Mays ajmays@dmacc.edu
 * CIS175 - Spring 2023
 * Jan 31, 2023
 */
public class RunBank {
	static Scanner in = new Scanner(System.in);
	static BankHelp b = new BankHelp();
	public static void addBankAccount() {
		System.out.print("Enter your name used on the account: ");
		String name = in.nextLine();
		System.out.print("Enter the number for your account: ");
		int account = in.nextInt();
		Bank add = new Bank(name, account);
		b.input(add);
	}
	private static void deleteAccount() {
		// TODO Auto-generated method stub
		System.out.print("Enter a name to delete: ");
		String name = in.nextLine();
		System.out.print("Enter an account number to delete: ");
		int account = in.nextInt();
		Bank delete = new Bank(name, account);
		b.deleteAccount(delete);
	}
	
	public void searchForItemById(int itToEdit) {
		
	}
	private static void editBankAccount() {
		// TODO Auto-generated method stub
		System.out.println("Name or Number for Search? ");
		System.out.println("1 : Search by Name");
		System.out.println("2 : Search by Account Number");
		int searchAccount = in.nextInt();
		in.nextLine();
		List<Bank> foundAccount;
		if (searchAccount == 1) {
			System.out.print("Enter your name used on the account: ");
			String name = in.nextLine();
			foundAccount = b.searchForAccountByName(name);
			
		} else {
			System.out.print("Enter the number for your account: ");
			String name = in.nextLine();
			foundAccount = b.searchForAccountByName(name);

		}

		if (!foundAccount.isEmpty()) {
			System.out.println("Found Results.");
			for (Bank b : foundAccount) {
				System.out.println(b.getAcctNum() + " : " + b.toString());
			}
			System.out.print("Which Account to edit: ");
			int editing = in.nextInt();

			Bank edit = b.searchForAccountByNum(editing);
			System.out.println("Retrieved " + edit.getAcctNum() + " from " + edit.getAcctNum());
			System.out.println("1 : Update Name");
			System.out.println("2 : Update Account Number");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Name: ");
				String newName = in.nextLine();
				edit.setName(newName);
			} else if (update == 2) {
				System.out.print("New Item: ");
				int newAcctNum = in.nextInt();
				edit.setAcctNum(newAcctNum);
			}

			b.updateAccount(edit);

		} else {
			System.out.println("---- No results found");
			}
		}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to the First Regional Credit Union! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add a name and account number");
			System.out.println("*  2 -- Edit an account");
			System.out.println("*  3 -- Delete an account");
			System.out.println("*  4 -- View the account list");
			System.out.println("*  5 -- Exit");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addBankAccount();
			} else if (selection == 2) {
				editBankAccount();
			} else if (selection == 3) {
				deleteAccount();
			} else if (selection == 4) {
				viewTheList();
			} else {
				//lih.cleanUp();
				System.out.println("   Farwell!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		// TODO Auto-generated method stub
		List<Bank> all = b.showAllItems();
		for(Bank single: all){
			System.out.println(single.toString());
			}

	}

}


