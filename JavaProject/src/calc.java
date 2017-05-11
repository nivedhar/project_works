import java.util.Scanner;

public class calc
{
	public static void main(String[] args)
	{
		calcOperation();
	}
	
	static void calcOperation()
	{
		double firstN;
		double secondN;
		char operator;
		char option;
		
		Scanner	readInput	=	new	Scanner(System.in);
		System.out.printf("Type	a number, operator,	number -- separated	by a space:	");
		firstN				=	readInput.nextDouble();
		operator			=	readInput.next().charAt(0);
		secondN				=	readInput.nextDouble();
		
		if (operator ==	'+')
			System.out.printf("%f + %f = %f", firstN, secondN, firstN + secondN);
		else if (operator == '-')
			System.out.printf("%f - %f = %f", firstN, secondN, firstN - secondN);
		else if (operator == '*')
			System.out.printf("%f * %f = %f", firstN, secondN, firstN * secondN);
		else if (operator == '/')
			System.out.printf("%f / %f = %f", firstN, secondN, firstN / secondN);
		else if (operator == '%')
			System.out.printf("%f %% %f = %f", firstN, secondN, firstN % secondN);
		else
			System.out.printf("Unknown	operator");
		
		System.out.printf("\n\n");
		System.out.println("Do you want to continue? If yes press y else n.");
		
		option				=	readInput.next().charAt(0);
		
		if(option == 'y')
			calcOperation();
	}
}
