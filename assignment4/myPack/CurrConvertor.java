package myPack;

import java.util.*;

public class CurrConvertor
{
	private float cur = 0;
	public float convert( String curr, int ch ) throws NumberFormatException
	{
		cur = Float.parseFloat(curr);
		if(ch == 1)
		{
			return cur*71.51f;
		}
		else if( ch == 2 )
		{
			return cur/71.51f;
		}
		else if( ch == 3 )
		{
			return cur*79.77f;
		}
		else if( ch == 4 )
		{
			return cur/79.77f;
		}
		else if( ch == 5 )
		{
			return cur*0.68f;
		}
		else if( ch == 6 )
		{
			return cur/0.68f;
		}
		return 0;
	}
}
