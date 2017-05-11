import java.util.Scanner;
import java.util.InputMismatchException;

public class OOPCalculator
{
	public int menuChoice;
	public float firstFloat;
	public float secondFloat;
	public int menuFlag;
	
	void showOperations()
	{
		System.out.println("Welcome to Nivedha's Handy Calculator");
		System.out.println("1. Addition");
		System.out.println("2. Subtraction");
		System.out.println("3. Multiplication");
		System.out.println("4. Division");
		System.out.println("5. Exit");
		
		System.out.printf("What would you like to do?");
	}
	
	int askCalcChoice()
	{
		if(menuFlag == 0)
			showOperations();
		
		int maxOptionNo			=	5;
		
		Scanner	inputText		=	new	Scanner(System.in);
		
		try
		{
			menuChoice			=	inputText.nextInt();
			
			if(menuChoice < 1 || menuChoice > maxOptionNo)
			{
				System.out.println("You have not entered the option between 1 - 5. Try again: ");
				menuFlag	=	1;
				askCalcChoice();
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("You have entered an invalid value. Please Re-enter: ");
			menuFlag	=	1;
			askCalcChoice();
		}
		
		menuFlag	=	0;
		return menuChoice;
	}
	
	void askTwoValues()
	{
		if(menuFlag == 0)
		{
			int key				=	menuChoice - 1;
			String textArray[]	=	{"add", "subtract", "multiply", "divide"};
			System.out.printf("Please enter two floats to %s, separated by a space: ", textArray[key]);
		}
		
		Scanner	inputText		=	new	Scanner(System.in);
		
		try
		{
			firstFloat			=	inputText.nextFloat();
			secondFloat			=	inputText.nextFloat();
		}
		catch(InputMismatchException e)
		{
			System.out.println("You have entered an invalid floats. Please Re-enter: ");
			menuFlag	=	1;
			askTwoValues();
		}
	}
	
	void displayResults()
	{
		switch(menuChoice)
		{
            case 1:  System.out.printf("Result of adding %5.2f and %5.2f is %5.2f", firstFloat, secondFloat, firstFloat + secondFloat);
                     break;
            case 2:  System.out.printf("Result of subtracting %5.2f and %5.2f is %5.2f", firstFloat, secondFloat, firstFloat - secondFloat);
                     break;
            case 3:  System.out.printf("Result of Multiplying %5.2f and %5.2f is %5.2f", firstFloat, secondFloat, firstFloat * secondFloat);
                     break;
            case 4:  if(secondFloat == 0)
		             {
		            	System.out.println("You can’t divide by zero please re-enter both floats: ");
		            	menuFlag	=	1;
		            	askTwoValues();
		             }
            		 else
            			 System.out.printf("Result of dividing %5.2f by %5.2f is %5.2f", firstFloat, secondFloat, firstFloat / secondFloat);
                     break;
        }
		
		System.out.printf("\nPress enter key to continue .....");
		
		Scanner	inputText			=	new	Scanner(System.in);
		inputText.nextLine(); //see for enter press and repeat the process
		menuFlag	=	0;
		askCalcChoice();
	}
	
	void displayBye()
	{
		System.out.printf("\nThank you for using Nivedha's Handy Calculator");
	}
}
