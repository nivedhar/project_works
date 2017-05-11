import java.util.InputMismatchException;
import java.util.Scanner;

public class boxMethods
{
	public static void main()
	{
		System.out.println("\nUsing for-loop and user values:");
		
		drawBox();
	}
	
	public static void drawBox()
	{
		char answer = 'y';
		char hChar1, vChar1;
		int ht1, wd1;
		
		Scanner readInput	=	new Scanner(System.in);
		
		while (answer == 'y')
		{
			try
			{
				System.out.print("\nPlease enter height of a box: ");
				ht1 = readInput.nextInt();
				
				System.out.print("\nPlease enter width of a box:");
				wd1 = readInput.nextInt();
				
				readInput.nextLine(); //clean the buffer
				
				System.out.print("\nPlease enter the horizontal charcters to draw box: ");
				hChar1 = readInput.nextLine().charAt(0);
				
				System.out.print("\nPlease enter the vertical charcters to draw box: ");
				vChar1 = readInput.nextLine().charAt(0);
				
				drawHorizontalLine(wd1, hChar1);
				drawVerticalLine(ht1, vChar1);
				
				System.out.print("\n\n");
				System.out.print("Continue? Type 'y' for yes: ");
				answer = readInput.nextLine().charAt(0);
			}
			catch(InputMismatchException e)
			{
				System.out.println("You have entered an invalid value. Please Re-enter: ");
				readInput.nextLine();
				continue;
			}
		}
	}
	
	public static void drawHorizontalLine(int wd1, char hChar1)
	{
		for (int x = 1; x <= wd1; x++)
			System.out.print("" + hChar1);
	}
	
	public static void drawVerticalLine(int ht1, char vChar1)
	{
		for(int x = 1; x <= ht1-2; x++)
			System.out.print(""+ vChar1);
	}
}
