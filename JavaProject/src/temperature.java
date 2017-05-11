
public class temperature
{
	public static void main(String[] args)
	{
		int weeklyTemp[]	=	{69, 70, 71, 68, 66, 71, 70};
		int i, max = 0, min =	weeklyTemp[0];
		float total = 0, average;
		int weeklyTempCount	=	weeklyTemp.length;
		
		for(i = 0; i < weeklyTempCount; i++)
		{
			int day	=	i + 1;
			
			System.out.println("The temperature on day " + day + " was : " +  weeklyTemp[i]);
			
			if(weeklyTemp[i] > max)
				max	=	weeklyTemp[i];
			
			if(weeklyTemp[i] < min)
				min	=	weeklyTemp[i];
			
			total	+=	weeklyTemp[i];	
		}
		
		average	=	total / weeklyTempCount;
		
		System.out.println("The Maximun temperature is " + max);
		System.out.println("The minimum temperature is " + min);
		System.out.println("The average temperature of the week is " + average);
		System.out.println("Thanks for using my HW #5 solution");
	}
}
