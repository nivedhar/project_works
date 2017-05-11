import java.util.InputMismatchException;
import java.util.Scanner;

public class box
{
	public static void main(String[] args)
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
				drawVerticalLine(ht1, wd1, vChar1);
				drawHorizontalLine(wd1, hChar1);
				
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
		
		System.out.print("\n");
	}
	
	public static void drawVerticalLine(int ht1, int wd1, char vChar1)
	{
		for(int x = 1; x <= ht1-2; x++)
		{
			System.out.print(""+ vChar1);
			
			for (int y = 1; y <= wd1-2; y++)
				System.out.print(" ");
			
			System.out.print("" + vChar1 + "\n");
		}
	}
}
