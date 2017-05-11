import java.util.InputMismatchException;
import java.util.Scanner;

public class floatNumbers
{
	public static void main(String[] args)
	{
		float[] floatValues	=	new float[2];
		
		System.out.println("Welcome to my float number program.");
		
		while(floatValues[0] < 0.1 || floatValues[1] < 0.1)
			floatValues	=	getTwoFloats();
		
		System.out.printf("You have entered the valid floats of " + floatValues[0] + " and " + floatValues[1]);
		System.out.printf("\nThank you for your choice");
	}
	
	static float[] getTwoFloats()
	{
		float[] floatArray	=	new float[2];
		
		Scanner inputText	=	new Scanner(System.in);
		
		System.out.println("Enter two float values divided by a space: ");
		
		try
		{
			floatArray[0]		=	inputText.nextFloat();
			floatArray[1]		=	inputText.nextFloat();
			
			return floatArray;
		}
		catch(InputMismatchException e)
		{
			System.out.println("You have entered an invalid choice. Try again. Msg : " + e.getMessage());
			return floatArray;
		}
	}
}
