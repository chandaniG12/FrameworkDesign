package KeywordDrivenTestRunner;



import org.testng.annotations.Test;

import KeywordDriven.utils.ReusableFunction;

public class ExecuteTestRunner {
	
	@Test
	public void execute() 
	{
		ReusableFunction fun= new ReusableFunction();
		
		String[][] keywordData = fun.fetchDataFromExcel();
		
		int rownum = keywordData.length;
		int colnum= keywordData[0].length;
		
		
		String Tc_Name= keywordData[0][0];
		String Tc_StepNo= keywordData[0][1];
		String Tc_StepName= keywordData[0][2];
		String Tc_Function= keywordData[0][3];
		String Tc_Location= keywordData[0][4];
		String Tc_LocationValue= keywordData[0][5];
		String Tc_parameter = keywordData[0][6];
		String Tc_Execute = keywordData[0][7];
		
		for( int counter =1; counter< rownum; counter++)
		{
			String function= keywordData[counter][3];
			String locationBy = keywordData[counter][4];
			String locatorElement = fun.fetchpro( keywordData[counter][5]);
			String parameter = keywordData[counter][6];
			String Execute = keywordData[counter][7];
		
			System.out.println(function + "\t" + locationBy + "\t" + locatorElement + "\t " + parameter );
			
			if(Execute.equals("Y"))
			{
			switch(function)
			{
			case "LaunchApplication" :
				fun.LaunchApplication();
				break;
				
			case "fillText":
			   fun.fillText(locationBy, locatorElement, parameter);
			   break;
			   
			case "Click":
				
				fun.Click(locationBy, locatorElement);
				
				break;
			}
			
		}
		}
		
		

		
		
	}

}
