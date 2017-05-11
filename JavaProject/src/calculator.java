import java.util.Scanner;
import java.util.InputMismatchException;

public class calculator
{
	public static void main(String[] args)
	{
		showOperations(); //Displays calculator operations to perform
	}
	
	static void showOperations()
	{
		System.out.println("Welcome to Nivedha's Handy Calculator");
		System.out.println("1. Addition");
		System.out.println("2. Subtraction");
		System.out.println("3. Multiplication");
		System.out.println("4. Division");
		System.out.println("5. Exit");
		
		System.out.printf("What would you like to do?");
		
		getOption(); //gets user option to perform that particular operation
	}
	
	static void getOption()
	{
		int option				=	0;
		int maxOptionNo			=	5;
		
		Scanner	inputText		=	new	Scanner(System.in);
		
		try
		{
			option				=	inputText.nextInt();
			
			if(option < 1 || option >= maxOptionNo)
			{
				if(option == 5)
					System.out.printf("\nThank you for using Nivedha's Handy Calculator");
				else
				{
					System.out.println("You have not entered the option between 1 - 5. Try again: ");
					getOption();
				}
			}
			else
			{
				int key				=	option - 1;
				String textArray[]	=	{"add", "subtract", "multiply", "divide"};
				
				System.out.printf("Please enter two floats to %s, separated by a space: ", textArray[key]);
				getData(option); //gets 2 values to perform the selected operation
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("You have entered an invalid value. Please Re-enter: ");
			getOption();
		}
	}
	
	static void getData(int option)
	{
		float firstN;
		float secondN;
		
		Scanner	inputText			=	new	Scanner(System.in);
		
		try
		{
			firstN					=	inputText.nextFloat();
			secondN					=	inputText.nextFloat();
			
			calcOperation(option, firstN, secondN); //performs the operation and shows the result
		}
		catch(InputMismatchException e)
		{
			System.out.println("You have entered an invalid floats. Please Re-enter: ");
			getData(option);
		}
	}
	
	static void calcOperation(int option, float firstN, float secondN)
	{
		switch(option)
		{
            case 1:  System.out.printf("Result of adding %5.2f and %5.2f is %5.2f", firstN, secondN, firstN + secondN);
                     break;
            case 2:  System.out.printf("Result of subtracting %5.2f and %5.2f is %5.2f", firstN, secondN, firstN - secondN);
                     break;
            case 3:  System.out.printf("Result of Multiplying %5.2f and %5.2f is %5.2f", firstN, secondN, firstN * secondN);
                     break;
            case 4:  if(secondN == 0)
		             {
		            	System.out.println("You can’t divide by zero please re-enter both floats: ");
		    			getData(option);
		             }
            		 else
            			 System.out.printf("Result of dividing %5.2f by %5.2f is %5.2f", firstN, secondN, firstN / secondN);
                     break;
        }
		
		System.out.printf("\nPress enter key to continue .....");
		
		Scanner	inputText			=	new	Scanner(System.in);
		inputText.nextLine(); //see for enter press and repeat the process
		showOperations();
	}
}
