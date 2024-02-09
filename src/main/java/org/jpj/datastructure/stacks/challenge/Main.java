package org.jpj.datastructure.stacks.challenge;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string) {
        String pattern = "\\p{Punct}";
        // Create a Pattern object
        Pattern p = Pattern.compile(pattern);
        // Create a Matcher object for the input string
        Matcher m = p.matcher(string.toLowerCase().replaceAll("\\s", ""));
        // Remove punctuations and store the result in a new string
        String formattedString = m.replaceAll("");
        LinkedStack stack = new LinkedStack();
        char[] characters = formattedString.toCharArray();
        for(char ch: characters) {
            stack.push(ch);
        }
        Iterator<Character> listIterator = stack.iterator();
        StringBuilder builder = new StringBuilder();
        while(listIterator.hasNext()) {
            builder.append(listIterator.next());
        }
        return builder.toString().equals(formattedString);
    }
}
