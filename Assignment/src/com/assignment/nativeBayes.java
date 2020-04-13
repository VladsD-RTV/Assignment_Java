package com.assignment;

public class nativeBayes
{
	private String Temp  		= "";
	private String Aches 		= "";
	private String Cough 		= "";
	private String SoreThroat	= "";
	private String RTDZ1		= "";
	
	float processYCountResult;
	float processNCountResult;
	float resultTempY;
	float resultTempN;
	float resultAchesY;
	float resultAchesN;
	float resultCoughY;
	float resultCoughN;
	float resultSoreThroatY;
	float resultSoreThroatN;
	float resultRTDZY;
	float resultRTDZN;
	
	public void nativeBayesConfig(String temp,String aches,String cough,String soreThroat,String RTDZ)
	{
		this.Temp = temp;
		this.Aches = aches;
		this.Cough = cough;
		this.SoreThroat = soreThroat;
		this.RTDZ1 = RTDZ;
		
		try
		{
			setTemp(Temp);
			setAches(Aches);
			setCough(Cough);
			setSoreThroat(SoreThroat);
			setRTDZ1(RTDZ1);
		}//end try
		catch(NullPointerException e)
		{
			System.out.println("There are no values here");
		}//end catch
		
		//getting input for the admin to see if all results show up correctly.
		System.out.println("The temp is:"+Temp+" there is aches:"+Aches+" there is a cough:"+Cough+" there is a sore throat:"+SoreThroat+" they have travelled into a danger zone:"+RTDZ1);
		
		
		float resultYes = resultTempY * resultAchesY * resultCoughY * resultSoreThroatY * resultRTDZY * processYCountResult;
		float resultNo 	= resultTempN * resultAchesN * resultCoughN * resultSoreThroatN * resultRTDZN * processNCountResult;
		
		float resultTotal = resultYes + resultNo;
		
		float resultForYes = resultYes / resultTotal;
		float resultForNo = resultNo / resultTotal; 
		
		if(resultForYes > resultForNo)
		{
			System.out.println("You have covid-19 at a percentage as:"+resultForYes+"/1");
		}//end if
		else
		{
			System.out.println("You don't have covid-19 at a percentage as:"+resultForNo+"/1");
		}//end else
		
		
	}//end nativeBayesConfig()
	
	public void nativeBayesCalcTemp(int hotCovidYes,int hotCovidNo,int coolCovidYes,int coolCovidNo,int normalCovidYes,int normalCovidNo,int covidcountY,int covidcountN)
	{
		float fhotCovidYes 		= hotCovidYes;
		float fhotCovidNo 		= hotCovidNo;
		float fcoolCovidYes 	= coolCovidYes;
		float fcoolCovidNo		= coolCovidNo;
		float fnormalCovidYes 	= normalCovidYes;
		float fnormalCovidNo 	= normalCovidNo;
		
		try
		{
			if(getTemp().equals("hot"))
			{
				resultTempY = fhotCovidYes / covidcountY;
				resultTempN = fhotCovidNo / covidcountN;
			}//end if
			if(getTemp().equals("cool"))
			{
				System.out.println("It works");
				resultTempY = fcoolCovidYes / covidcountY;
				resultTempN = fcoolCovidNo / covidcountN;
			}//end if
			if(getTemp().equals("normal"))
			{
				resultTempY = fnormalCovidYes / covidcountY;
				resultTempN = fnormalCovidNo / covidcountN;
			}//end if
		}//end try
		catch(NullPointerException e)
		{
			System.out.println("Wrong");
		}
		
	}//end nativeBayesCalcTemp()
	
	public void nativeBayesCalcAches(int achesYCovidYes, int achesYCovidNo,int achesNCovidYes, int achesNCovidNo, int covidcountY,int covidcountN)
	{
		float fachesYCovidYes 	=achesYCovidYes;
		float fachesYCovidNo	=achesYCovidNo;
		float fachesNCovidYes	=achesNCovidYes;
		float fachesNCovidNo	=achesNCovidNo;
		
		try
		{
			if(getAches().equals("yes"))
			{
				resultAchesY = fachesYCovidYes / covidcountY;
				resultAchesN = fachesYCovidNo / covidcountN;
			}//end if
			if(getAches().equals("no"))
			{
				resultAchesY = fachesNCovidYes / covidcountY;
				resultAchesN = fachesNCovidNo / covidcountN;
			}//end if
		}//end try
		catch(NullPointerException e)
		{
			System.out.println("Wrong");
		}
	}//end nativeBayesCalcAches
	
	public void nativeBayesCalcCough(int coughYCovidYes, int coughYCovidNo,int coughNCovidYes, int coughNCovidNo, int covidcountY,int covidcountN)
	{
		float fcoughYCovidYes 	=coughYCovidYes;
		float fcoughYCovidNo 	=coughYCovidNo;
		float fcoughNCovidYes 	=coughNCovidYes;
		float fcoughNCovidNo 	=coughNCovidNo;
		
		try
		{	
			if(getCough().equals("yes"))
			{
				resultCoughY = fcoughYCovidYes / covidcountY;
				resultCoughN = fcoughYCovidNo / covidcountN;
			}//end if
			if(getCough().equals("no"))
			{
				resultCoughY = fcoughNCovidYes / covidcountY;
				resultCoughN = fcoughNCovidNo / covidcountN;
			}//end if
		}
		catch(NullPointerException e)
		{
			System.out.println("Wrong");
		}
	}//end nativeBayesCalcCough
	
	public void nativeBayesCalcSThroat(int sThroatYCovidYes, int sThroatYCovidNo,int sThroatNCovidYes, int sThroatNCovidNo, int covidcountY,int covidcountN)
	{
		float fsThroatYCovidYes 	=sThroatYCovidYes;
		float fsThroatYCovidNo 		=sThroatYCovidNo;
		float fsThroatNCovidYes 	=sThroatNCovidYes;
		float fsThroatNCovidNo 		=sThroatNCovidNo;
		
		try
		{	
			if(getSoreThroat().equals("yes"))
			{
				resultSoreThroatY = fsThroatYCovidYes / covidcountY;
				resultSoreThroatN = fsThroatYCovidNo / covidcountN;
			}//end if
			if(getSoreThroat().equals("no"))
			{
				resultSoreThroatY = fsThroatNCovidYes / covidcountY;
				resultSoreThroatN = fsThroatNCovidNo / covidcountN;
			}//end if
		}
		catch(NullPointerException e)
		{
			System.out.println("Wrong");
		}
	}//end nativeBayesCalcSThroat
	
	public void nativeBayesCalcRTDZ(int RTDZYCovidYes, int RTDZYCovidNo,int RTDZNCovidYes, int RTDZNCovidNo, int covidcountY,int covidcountN)
	{
		float fRTDZYCovidYes 	=RTDZYCovidYes;
		float fRTDZYCovidNo 	=RTDZYCovidNo;
		float fRTDZNCovidYes 	=RTDZNCovidYes;
		float fRTDZNCovidNo 	=RTDZNCovidNo;
		
		try
		{
			if(getRTDZ1().equals("yes"))
			{
				resultSoreThroatY = fRTDZYCovidYes / covidcountY;
				resultSoreThroatN = fRTDZYCovidNo / covidcountN;
			}//end if
			if(getRTDZ1().equals("no"))
			{
				resultRTDZY = fRTDZNCovidYes / covidcountY;
				resultRTDZN = fRTDZNCovidNo / covidcountN;
			}//end if
		}
		catch(NullPointerException e)
		{
			System.out.println("Wrong");
		}
	}//end nativeBayesCalcSThroat
	
	public void nativeBayesCalcProcess(int Process, int covidcountY, int covidcountN)
	{
		float fProcess 		= Process;
		float fcovidcountY 	= covidcountY;
		float fcovidcountN	= covidcountN;
		
		processYCountResult = fcovidcountY / fProcess;
		processNCountResult = fcovidcountN / fProcess;
		
		System.out.println(processYCountResult);
	}
	
	//getters and setters
		public String getTemp() 
		{
			return Temp;
		}
		public void setTemp(String temp) 
		{
			Temp = temp;
		}
		public String getAches() 
		{
			return Aches;
		}
		public void setAches(String aches) 
		{
			Aches = aches;
		}
		public String getCough() 
		{
			return Cough;
		}

		public void setCough(String cough) 
		{
			Cough = cough;
		}
		public String getSoreThroat() 
		{
			return SoreThroat;
		}
		public void setSoreThroat(String soreThroat) 
		{
			SoreThroat = soreThroat;
		}
		public String getRTDZ1() 
		{
			return RTDZ1;
		}
		public void setRTDZ1(String rTDZ1) 
		{
			RTDZ1 = rTDZ1;
		}
	
}//end nativeBayes class
