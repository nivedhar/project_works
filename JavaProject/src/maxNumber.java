import java.util.Scanner;

public class maxNumber
{
	public static void main(String[] args)
	{
		getMax();
	}
	
	static void getMax()
	{
		int firstN, secondN, thirdN, max;
		char option;
		
		Scanner	readInput	=	new	Scanner(System.in);
		System.out.printf("Type	3 integers seperated by a space to find the max of them: ");
		
		firstN				=	readInput.nextInt();
		secondN				=	readInput.nextInt();
		thirdN				=	readInput.nextInt();
		
		max = (firstN > secondN) ? (firstN > thirdN) ? firstN : thirdN : (secondN > thirdN) ? secondN : thirdN; 
		
		System.out.println("The max is " + max);
		System.out.println("Do you want to continue? If yes press y else n.");
		
		option				=	readInput.next().charAt(0);
		
		if(option == 'y')
			getMax();
		else
			System.out.println("Thanks for using my max program");
	}
}
