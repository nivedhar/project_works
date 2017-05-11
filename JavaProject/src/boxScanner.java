import java.util.Scanner;

public class boxScanner
{
	public static void main(String[] args)
	{
		getInput();
	}
	
	static void getInput()
	{
		char userVerticalSign, userHoriSign, option;
		int height, width;
		
		Scanner inputText	=	new Scanner(System.in);
		
		System.out.println("Please specify the required height of the box: ");
		height				=	inputText.nextInt();
		
		System.out.println("Please specify the required width of the box: ");
		width				=	inputText.nextInt();
		
		System.out.println("Please specify the symbol of vertical line of the box: ");
		userVerticalSign	=	inputText.next().charAt(0);
		
		System.out.println("Please specify the symbol of horizontal line of the box: ");
		userHoriSign		=	inputText.next().charAt(0);
		
		drawBox(height, width, userVerticalSign, userHoriSign);
		
		System.out.println("Do you want to continue? If yes press y else n.");
		option				=	inputText.next().charAt(0);
		
		if(option == 'y')
			getInput();
	}

	private static void drawBox(int height, int width, char userVerticalSign, char userHoriSign)
	{
		int row, col;
		
		//Printing square logic
		for (row = 1; row <= height; row++ )
		{
		    for (col = 1; col <= width ; col++)
		    {
		        if (row == 1 || row == height)
		        	System.out.print(userHoriSign);
		        else
		        {
		        	if(col == 1 || col == width)
		        		System.out.print(userVerticalSign);
		        	else
		        		System.out.print(" ");
		        }
		    }
		    
		    System.out.println();
		}
	}
}
