import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class file {
    static String findLongestString(char[] s)
    {
    char aChar = s[0];
    char bChar = '\0';
    int count = 1;
    int start = 0;
    int maxCount = 0;
    int maxStart = 0;
    System.out.println(s.length);
    for (int i = 0; i < s.length; i++) {
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
    for (int j = maxStart; j < (maxStart + maxCount); j++) {
        longestString += s[j];
    }
    return longestString;
    }

    public static void main(String[] args)
    {
    //Scanner in = new Scanner(System.in);
    String s = "aaabaaaa";//in.nextLine();
    char[] ch = s.toCharArray();
    String subString = findLongestString(ch);
    System.out.println(subString);
    }
}
