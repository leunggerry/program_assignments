import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// Problem:  write a function that returns true if input is power of 2 false
//         otherwise
// ex. 2 -> true
// ex. 512 -> true
// ex. 511 -> false
// ex. 65536 -> false
//
//assuming integer
public class PowerOf2 {

	public static boolean powerOf2(int n)
	{
		boolean isPowerOf2 = false;
		//storing the integer size to do a bit-AND operation
		//int intSize = Integer.parseInt(, 16);
		int intSize = 32;
		int q = Integer.parseInt("8000", 16);
		for (int i = 0; i < intSize; i++)
		{
			if ((q >> i) == n) 
			{
				return true;
			}
		}

		return isPowerOf2;
	}

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		boolean getPowerOf2 = powerOf2(n);
		System.out.println(getPowerOf2);
	}
}