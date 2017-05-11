
public class boxFor
{
	public static void main(String[] args)
	{
		//Printing square logic
		int row_max	=	10, col_max	=	20, row, col;
		
		for (row = 1; row <= row_max; row++ )
		{
		    for (col = 1; col <= col_max ; col++)
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
		    }
		    
		    System.out.println();
		}
	}
}
