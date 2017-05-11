
import java.util.Scanner;

public class scanner
{	
	public static void main(String[] args)
	{
		int radius;
		double area;
		double pi;
		Scanner readInput	=	new Scanner(System.in);
		Scanner readPi 		=	new Scanner(System.in);
		
		System.out.println("Enter the radius: ");
		radius				=	readInput.nextInt();
		
		System.out.println("Enter the value of Pi: ");
		pi					=	readPi.nextDouble();
		
		area				=	pi * radius * radius;
		System.out.println("The area is: " + area);
	}
}
