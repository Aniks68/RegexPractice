package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String string = "I am a string. Yes I am.";
        System.out.println(string);
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric = "abcDeeF12ghiiiijkl99z";
        System.out.println(alphanumeric.replaceAll("abcDee", "YYY"));

        String alphanumeric2 = "abcDeeF12ghiiiiabcDeejkl99z";
        System.out.println(alphanumeric2.replaceAll("abcDee", "YYY"));
        System.out.println(alphanumeric2.replaceAll("^abcDee", "GGG"));
        System.out.println(alphanumeric.replaceAll("[aei][Fjb]", "Q"));
        System.out.println(alphanumeric.replaceAll("[^129]", "X"));
        System.out.println(alphanumeric.replaceAll("\\D", "N"));
        System.out.println(alphanumeric.replaceAll("(?i)[a-ix-z4-9]", "O"));

        String hasWhiteSpace = " Yeah, I did that \t and I'll see 1 or 47 new lines? \n";
        System.out.println(hasWhiteSpace);
        System.out.println("=============");
        System.out.println(hasWhiteSpace.replaceAll("\\w", "A"));// w selects all alphabet and number characters.
        System.out.println(hasWhiteSpace.replaceAll("\\W", "A"));// W reverses above
        System.out.println(hasWhiteSpace.replaceAll("\\s", "A"));// s selects all whitespace
        System.out.println(hasWhiteSpace.replaceAll("\\S", "A"));// S reverses above
        System.out.println(hasWhiteSpace.replaceAll("\\b", "A"));// b surrounds each word with the replacement. Used to edit tags for html pages for example
        System.out.println(hasWhiteSpace.replaceAll("\\B", "A"));// B places the replacement in the middle of each word, space and character... so far.
        System.out.println("++++++++++++++");

        String message = "My one is you. My only treasure is Youuuuuuuu! Although I don't think watching youtube videos count there with you, but Baiyou might think otherwise.";
        System.out.println(message.replaceAll("/\\b(you+|u)\\b/gi", "your sister"));// + means one or more of the character it follows. * means zero or more.

        StringBuilder htmlText = new StringBuilder("<h1> My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p> This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String h2pattern = "p";
        Pattern pattern = Pattern.compile(h2pattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while(matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());
        }

        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());

        groupMatcher.reset();
        while(groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        String h2TextGroup = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroup);
        Matcher h2TxtMatcher = h2TextPattern.matcher(htmlText);

        while(h2TxtMatcher.find()) {
            System.out.println("Occurrence: " + h2TxtMatcher.group(2));
        }

        String tvTest = "tstvtkt";
        String tNotVRegExp = "t[^v]";
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while(tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        String pattern1 = "^([(][0-9]{3}[)][ ][0-9]{3}[-][0-9]{4})$";
        String phone1 = "1234567890";
        String phone2 = "(123) 456-7890";
        String phone3 = "123 456-7890";
        String phone4 = "(123)456-7890";

        System.out.println("phone1= " + phone1.matches(pattern1));
        System.out.println("phone2= " + phone2.matches(pattern1));
        System.out.println("phone3= " + phone3.matches(pattern1));
        System.out.println("phone4= " + phone4.matches(pattern1));
    }
}
