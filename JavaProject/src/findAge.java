import java.util.Scanner;

public class findAge
{
	public static void main(String[] args)
	{
		int ageKid			=	12;
		int ageAdult		=	20;
		
		Scanner readInput	=	new Scanner(System.in);
		System.out.print("What is your age?: ");
		int age				=	readInput.nextInt();
		
		if(age <= ageKid)
			System.out.print("You are a kid");
		else if(age > ageKid && age < ageAdult)
			System.out.print("You are a teenager”");
		else
			System.out.print("You are a adult");
	}
}
