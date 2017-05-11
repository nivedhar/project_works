import java.util.InputMismatchException;
import java.util.Scanner;

public class temprature
{
	private static Scanner readInput	=	new Scanner(System.in);
	private static int[] weeklyTemp		=	new int[7];
	public static int max;
	public static int min;
	public static double average;
	
	public static void main(String[] args)
	{
		getTemperatures();
		printTemperatures();
		max		=	getMax();
		min		=	getMin();
		average	=	getAverage();
		printStatistics();
	}
	
	public static void getTemperatures()
	{
		do
		{
			for (int i = 0; i < weeklyTemp.length; i++)
			{
				try
				{
			    	System.out.println("Enter the temperature for day " + (i+1) + " : ");
			    	weeklyTemp[i]	=	readInput.nextInt();
				}
				catch(InputMismatchException e)
				{
					System.out.println("You have entered an invalid value. Please Re-enter: ");
					readInput.nextLine();
					i	=	i - 1;
					continue;
				}
			}
		    break;
		}
		while(true);
	}
	
	public static void printTemperatures()
	{
		for (int i = 0; i < weeklyTemp.length; i++)
		{
			System.out.printf("\nThe temperature on day %d " + "was %d", i + 1, weeklyTemp[i]);
		}
		
		System.out.printf("\n\n");
	}
	
	public static int getMax()
	{
		int max	=	0;
		
		for (int i = 0; i < weeklyTemp.length; i++)
		{
			if (i == 0)
				max = weeklyTemp[i];
			else if (weeklyTemp[i] > max)
				max = weeklyTemp[i];
		}
		
		return max;
	}
	
	public static int getMin()
	{
		int min	=	0;
		
		for (int i = 0; i < weeklyTemp.length; i++)
		{
			if (i == 0)
				min = weeklyTemp[i];
			else if(weeklyTemp[i] < min)
				min = weeklyTemp[i];
		}
		
		return min;
	}
	
	public static double getAverage()
	{
		float total = 0, average;
		
		for (int i = 0; i < weeklyTemp.length; i++)
			total += weeklyTemp[i];
		
		average = total / weeklyTemp.length;
		
		return average;
	}
	
	public static void printStatistics()
	{
		System.out.printf("The Minimum temperature is: %d\n", min);
		System.out.printf("The Maximum temperature is: %d\n", max);
		System.out.println("The average temperage for the week is:" + average);
	}
}
