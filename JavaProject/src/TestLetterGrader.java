public class TestLetterGrader
{
	public static void main(String[] args)
	{
		LetterGrader letterGrader	=	new	LetterGrader(args[0], args[1]);																																																																		//args[1]	has	output	file	name
		letterGrader.readScore();
		letterGrader.calcLetterGrade();
		letterGrader.printGrade();
		letterGrader.displayAverages();
		letterGrader.doCleanup();
	}
}
