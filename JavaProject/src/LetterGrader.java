import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LetterGrader
{
	private String inputFileName;
	private String outputFileName;
	private ArrayList<String> studentName;
	private ArrayList<Double> quiz1;
	private ArrayList<Double> quiz2;
	private ArrayList<Double> quiz3;
	private ArrayList<Double> quiz4;
	private ArrayList<Double> midterm1;
	private ArrayList<Double> midterm2;
	private ArrayList<Double> finalExam;
	private ArrayList<String> grade;
	
	LetterGrader(String inputFileName, String outputFileName)
	{
		this.inputFileName	=	inputFileName;
		this.outputFileName	=	outputFileName;
		studentName 		= 	new ArrayList<String>();
		quiz1 				= 	new ArrayList<Double>();
		quiz2				= 	new ArrayList<Double>();
		quiz3 				= 	new ArrayList<Double>();
		quiz4 				= 	new ArrayList<Double>();
		midterm1 			= 	new ArrayList<Double>();
		midterm2 			= 	new ArrayList<Double>();
		finalExam 			= 	new ArrayList<Double>();
		grade 				=	new ArrayList<String>();
	}
	
	public void readScore()
	{
		File inputFile		=	new File(inputFileName);
		
		if ( ! inputFile.exists())
		{
			System.out.println("The " + inputFileName + "does not exists");
			System.exit(0);
		}
		
		try
		{
			Scanner readInput			=	new Scanner(inputFile);
			
			while (readInput.hasNextLine())
			{
				String line				=	readInput.nextLine();
				String[] studentInfo	=	line.split(","); //delimiter used
	
				studentName.add(studentInfo[0]);
				quiz1.add(Double.parseDouble(studentInfo[1]));
				quiz2.add(Double.parseDouble(studentInfo[2]));
				quiz3.add(Double.parseDouble(studentInfo[3]));
				quiz4.add(Double.parseDouble(studentInfo[4]));
				midterm1.add(Double.parseDouble(studentInfo[5]));
				midterm2.add(Double.parseDouble(studentInfo[6]));
				finalExam.add(Double.parseDouble(studentInfo[7]));
			}
			
			readInput.close();
		}
		catch(IOException e)
		{
			System.out.println("Error while reading : " + e);
		}
	}

	public void calcLetterGrade()
	{
		for (int i = 0; i < studentName.size(); i++)
		{
			double totalScore	=	quiz1.get(i) * 0.10 + quiz2.get(i) * 0.10 +
										quiz3.get(i) * 0.10	+ quiz4.get(i) * 0.10 +
										midterm1.get(i) * 0.20 + midterm2.get(i) * 0.15	+
										finalExam.get(i) * 0.25;
			if (totalScore >= 90)
				grade.add("A");
			else if (totalScore >= 80)
				grade.add("B");
			else if (totalScore >= 70)
				grade.add("C");
			else if (totalScore >= 60)
				grade.add("D");
			else
				grade.add("F");
		}		
	}

	private  void sortByNames()
	{
		for (int row = 0; row < studentName.size(); row++) 
		{
			for (int col = row + 1; col < studentName.size(); col++) 
			{
				if (studentName.get(row).compareTo(studentName.get(col)) > 0) 
				{
					String tmp = studentName.get(row);
					studentName.set(row,studentName.get(col));
					studentName.set(col,tmp);
                   
					//swap scores
					tmp = grade.get(row);
					grade.set(row,grade.get(col));
					grade.set(col,tmp);
				}
			}
		}
	}
	
	public void printGrade()
	{
		sortByNames();
		
		File outputFile			=	new File(outputFileName);
		
		try
		{ 
			PrintWriter outputWriter	=	new PrintWriter(outputFile);
			
			outputWriter.printf("Letter grade for %d students given in input_data.txt file is: ", studentName.size());
			outputWriter.println("");
			
			for (int i = 0; i < studentName.size(); i++)
			{
				outputWriter.printf("%-20s%-1s\n", studentName.get(i), grade.get(i));
			}
			
			outputWriter.close();
		}
		catch(IOException e)
		{
			System.out.println("Error while writing : " + e);
		}
	}
	
	private double[] calcListStatistic(ArrayList<Double> list)
	{
		double sum		=	0;
		double minimum 	= 	list.get(0);
		double maximum 	=	list.get(0);
		double[] ret 	= 	new double[3];
		
		for (int i = 0; i < list.size(); i++)
		{
			sum	+=	list.get(i);
			
			if(list.get(i)< minimum)
		         minimum	=	list.get(i);//min
			
			if(list.get(i) > maximum)
		         maximum	=	list.get(i);//max
		}
		
		double average		=	sum/list.size();
		
		ret[0]	=	average;
		ret[1]	= 	minimum;
		ret[2] 	=	maximum;
		
		return ret;
	}

	public void displayAverages()
	{
		double[] quiz1Stats		= 	calcListStatistic(quiz1);
		double[] quiz2Stats 	=	calcListStatistic(quiz2);
		double[] quiz3Stats 	= 	calcListStatistic(quiz3);
		double[] quiz4Stats 	= 	calcListStatistic(quiz4);
		double[] midterm1Stats 	= 	calcListStatistic(midterm1);
		double[] midterm2Stats 	= 	calcListStatistic(midterm2);
		double[] finalExamStats	= 	calcListStatistic(finalExam);

		System.out.println("Letter grade has been calculated for students listed in input file input_data.txt and written to output file output_data.txt");
		System.out.println("\nHere is the class averages:");
		System.out.println("\n\tQ1\tQ2\tQ3\tQ4\tmid|\tmid||\tfinal\n");
		
		System.out.printf("Average: %.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\n", quiz1Stats[0], quiz2Stats[0], quiz3Stats[0], quiz4Stats[0],
				midterm1Stats[0], midterm2Stats[0], finalExamStats[0]);
		
		System.out.println("Minimum: "+quiz1Stats[1]+"\t"+quiz2Stats[1]+"\t"+quiz3Stats[1]+"\t"+quiz4Stats[1]+
				"\t"+midterm1Stats[1]+"\t"+midterm2Stats[1]+"\t"+finalExamStats[1]);
		
		System.out.println("Maximum: "+quiz1Stats[2]+"\t"+quiz2Stats[2]+"\t"+quiz3Stats[2]+"\t"+quiz4Stats[2]+
				"\t"+midterm1Stats[2]+"\t"+midterm2Stats[2]+"\t"+finalExamStats[2]);
	}
	
	public void doCleanup()
	{
		Scanner input	=	new Scanner(System.in);
		
		System.out.println("\n Press ENTER to continue...");
		
		input.nextLine();
		input.close();
	}
}
