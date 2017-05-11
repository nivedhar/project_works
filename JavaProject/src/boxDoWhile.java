
public class boxDoWhile
{
	public static void main(String[] args)
	{
		//Printing square logic
		int row_max	=	10, col_max	=	20, row = 1;
		
		do
		{
			int col = 1;
			
			while(col <= col_max)
			{
				if (row == 1 || row == row_max)
		        	System.out.print("-");
		        else
		        {
		        	if(col == 1 || col == col_max)
		        		System.out.print("|");
		        	else
		        		System.out.print(" ");
		        }	
				col++;
			}
			row++;
			System.out.println();
		}
		while(row <= row_max);
	}
}
