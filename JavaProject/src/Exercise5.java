import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Exercise5
{
	public static void main(String[] args) throws IOException
	{
		processCLArguments(args);
		processInputOutputFiles(args);
	}
	
	public static void processCLArguments(String[] args)
	{
		if(args.length < 2)
			System.out.println("Usage: java Exercise5 inputFile outputFile");
		else
		{
			System.out.println("Input will be read from " + args[0]);
			System.out.println("Output will be written into " + args[1]);
		}
	}
	
	public static void processInputOutputFiles(String[] args) throws IOException
	{
		try
		{
			File fileName						=	new File(args[0]);
			FileReader fileReader				=	new FileReader(fileName);
			BufferedReader inStream				=	new BufferedReader(fileReader);
			PrintWriter outputStream			=	new PrintWriter(new FileOutputStream(args[1]));
			StreamTokenizer inStreamTokenizer	=	new StreamTokenizer(inStream);
			inStreamTokenizer.eolIsSignificant(true);

			int nextToken 	=	inStreamTokenizer.nextToken();
			int count		=	1;
			
			System.out.print("STUDENT #: " + count + " ");
			outputStream.print("STUDENT #: " + count + " is: ");
			
			while(nextToken != StreamTokenizer.TT_EOF)
			{	
				if(nextToken == StreamTokenizer.TT_EOL)
				{
					count++;
					System.out.print("\nSTUDENT #: " + count + " ");
					outputStream.print("\nSTUDENT #: " + count + " is: ");
				}
				
				if(nextToken != StreamTokenizer.TT_EOL && nextToken == StreamTokenizer.TT_WORD)
				{
					System.out.print(" " + inStreamTokenizer.sval);
					outputStream.print("\"" + inStreamTokenizer.sval + "\" whose raw scores are: ");
				}
				
				if(nextToken != StreamTokenizer.TT_EOL && nextToken == StreamTokenizer.TT_NUMBER)
				{
					System.out.print(" " + inStreamTokenizer.nval);
					outputStream.print(" " + inStreamTokenizer.nval + ":");
				}
				
				nextToken	=	inStreamTokenizer.nextToken();
			}
			
			inStream.close();
			outputStream.close();
			System.out.print("\nOutput file written");
		}
		catch(FileNotFoundException err)
		{
			System.out.println(err.getMessage());
		}
		catch(IOException err)
		{
			System.out.println(err.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
