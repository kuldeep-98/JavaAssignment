
import java.util.Scanner;
import java.util.Arrays;

class CheckAnagram{
    public static boolean Check(String str,String anotherStr){
        char[] ch = str.toCharArray();
        char[] ch2 = anotherStr.toCharArray();
        Arrays.sort(ch);
        Arrays.sort(ch2);
        if(Arrays.equals(ch, ch2))
            return true;
        return false;
    }
}

class Anagram{
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Enter Word");
        String str = read.nextLine();
        System.out.println("Enter 2nd Word");
        String anotherStr = read.nextLine();
        if(CheckAnagram.Check(str, anotherStr))
            System.out.println("Anagram");
        else
            System.out.println("Not Anagram");
    }
}
