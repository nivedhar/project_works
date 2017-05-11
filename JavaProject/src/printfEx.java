import java.util.Scanner;

public class printfEx
{
	public static void main(String[] args)
	{
		Scanner readInput	=	new Scanner(System.in);
		System.out.print("What is your Firstname?: ");
		char initial		=	readInput.next().charAt(0);
		System.out.println("Hello Mr. " + initial + ".");
		
		System.out.printf("\n5185 is fun course.\n\n");
		
		System.out.print("What is your Firstname?: ");
		String firstName	=	readInput.next();
		
		System.out.print("What is your Lastname?: ");
		String lastName		=	readInput.next();
		
		System.out.print("What is your City?: ");
		String city			=	readInput.next();
		
		System.out.print("What is your Zip code?: ");
		String zipCode		=	readInput.next();
		
		System.out.printf("First Name \tLast Name \tCity \tZip Code\n");
		System.out.printf("---------- \t--------- \t---- \t--------\n");
		System.out.printf("%-16s%-16s%-16s%-16s", firstName, lastName, city, zipCode);
	}
}
