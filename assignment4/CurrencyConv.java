
import java.util.*;

import myPack.CurrConvertor;
import java.text.DecimalFormat;

class CurrencyConv
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int ch;
		String curr;
		float cur = 0;
		DecimalFormat f = new DecimalFormat("##.00");
		do
		{
		
		System.out.println(" Choose ");
		System.out.println(" 1) Dollar to INR");
		System.out.println(" 2) INR to Dollar");
		System.out.println(" 3) EURO to INR");
		System.out.println(" 4) INR to EURO");
		System.out.println(" 5) Yen to INR");
		System.out.println(" 6) INR to Yen");
		ch = in.nextInt();
		CurrConvertor c = new CurrConvertor();
		System.out.println(" Enter Currency Value: ");
		curr = in.next();

		try
		{
		cur = c.convert(curr, ch);
		System.out.println();
		System.out.println(" The New Currency Value: "+ f.format(cur));
		}
		catch(NumberFormatException e)
		{
			System.out.println();
			System.out.println(" Entered Format Wrong! ");
			System.out.println(e);
		}
		
		System.out.println();
		System.out.println(" Do you want to Enter Again? (1. Yes/ 2.No ) ");
		ch = in.nextInt();
		}
		while(ch == 1);
		
		}
}
