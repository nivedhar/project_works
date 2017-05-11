import java.util.InputMismatchException;
import java.util.Scanner;

public class menu
{
	public static void main(String[] args)
	{
		int result	=	0;
		
		System.out.println("Welcome to my MENU program. The menus are,");
		System.out.println("1. Title");
		System.out.println("2. Rank");
		System.out.println("3. Date");
		System.out.println("4. Star");
		System.out.println("5. Likes");
		
		while(result == 0)
			result	=	getUserChoice();
		
		System.out.printf("You have entered the valid choice of %d", result);
		System.out.printf("\nThank you for your choice");
	}
	
	static int getUserChoice()
	{
		int menuItem		=	0;
		int maxItemNo		=	5;
		
		Scanner inputText	=	new Scanner(System.in);
		
		System.out.println("Enter your choice between 1 and 5: ");
		
		try
		{
			menuItem		=	inputText.nextInt();
			
			if(menuItem > maxItemNo)
			{
				System.out.println("You have not entered the numbers between 1 - 5. Try again");
				menuItem	=	0;
			}
			
			return menuItem;
		}
		catch(InputMismatchException e)
		{
			System.out.println("You have entered an invalid choice. Try again. Msg : " + e.getMessage());
			return menuItem;
		}
	}
}
