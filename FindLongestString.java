import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
 * Problem:  Given a string, find the longest substring that contains at most 2 distinct characters
 * ex  abababacccaacb
 * ans abababa

 * ex  aaaaaa
 * ans n/a

 * ex ababdddbbbbbb
 * ans dddbbbbbb
 */
public class FindLongestString {

    ///tried doing it in O(n) time.....couldnt rignt now
    static String findLongestString_n1(char[] s) {
        char aChar = s[0];
        char bChar = '\0';
        int count = 1;
        int start = 0;
        int maxCount = 0;
        int maxStart = 0;
        System.out.println(s.length);
        for (int i = 0; i < s.length; i++) 
        {
            //System.out.println("Index:" + i);
            if ((s[i] != aChar) && (bChar == '\0')) {
                bChar = s[i];
                System.out.println("bChar assign: " + bChar);
            }
            if (s[i] == aChar) {
                //System.out.println("*aChar: " + aChar + "bChar " + bChar);
                count++;
                continue;
            }
            else if (s[i] == bChar) {
                //System.out.println("aChar: " + aChar + "*bChar " + bChar);
                count++;
                continue;
            }
            else if ((s[i] != bChar) || (s[i] != aChar)) {
                if (count > maxCount) {
                    maxCount = count;
                    maxStart = start;
                }
                i = ++start;
            
                aChar = s[start];
                bChar = '\0';
                System.out.println(aChar +" " + i);
                count = 1;
            }
            //switch(s[i]) {
            //case aChar :
            //        count++;
            //        break;
            //case bChar :
            //        count++;
            //        break;
            //default :
            //        break;
            //}
        }
        String longestString = "";
        for (int j = maxStart; j < (maxStart + maxCount); j++) 
        {
            longestString += s[j];
        }
        return longestString;
    }

    //did it in n^2 time
    static String findLongestString_n2(char[] inputS)
    {
        char aChar;
        char bChar;
        String longestString = "";
        int start, count;
        int maxStart = 0;
        int maxCount = 0;
        for (int i = 0; i < inputS.length; i++)
        {
            aChar = inputS[i];
            bChar = '\0';
            start = i;
            count = 1;
            for (int j = (i + 1); j < inputS.length; j++) 
            {
                if (inputS[j] == aChar)
                {
                    count++;
                    continue;
                }
                else if ((inputS[j] != aChar) && (bChar == '\0'))
                {
                    bChar = inputS[j];
                    count++;
                    continue;
                }
                else if ((inputS[j] == aChar) || (inputS[j] == bChar))
                {
                    count++;
                }
                else
                {
                    break;
                }
            }
            if ((count > maxCount) && (bChar != '\0'))
            {
                maxCount = count;
                maxStart = start;
            }
        }
        for (int k = maxStart; k < (maxStart + maxCount); k++)
        {
            longestString += inputS[k];
        }
        return longestString;
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] ch = s.toCharArray();
        String subString = findLongestString_n2(ch);
        System.out.println(subString);
    }
}
