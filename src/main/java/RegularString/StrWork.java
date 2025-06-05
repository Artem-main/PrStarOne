package RegularString;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrWork {
    public static String TEXT = "В тексте, который вы видите на этом слайде, посчитайте количество букв ‘е’ в каждом слове";
    public static String NUMBER_PHONE = "+999-900-111-22-33";

    public static void main(String[] args) {
        summ();
    }

    public static void summ () {
        String [] words = TEXT.replaceAll("[,]", " ").split("[\\s+]");

        for (String wordNewLine : words) {
            int count = 0;
            for (int i = 0; i < wordNewLine.length(); i++) {
                if (Character.toLowerCase(wordNewLine.charAt(i)) == 'е') {
                    count++;
                }
            }
            if (count != 0) {
                System.out.print("В слове : '" + wordNewLine + "' - "
                        + count + " букв 'е' \n");
            }
        }
    }

    public static void summStr () {
        Pattern pattern = Pattern.compile("[е]");
        Matcher matcher = pattern.matcher(TEXT);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        System.out.println(count);
    }

    public static void regularStr () {
        String regex = "^((\\+\\d{1,3})[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
        boolean result = NUMBER_PHONE.matches(regex);
        System.out.println(result);
    }

    public static void removeStr () {
        String regex = "[^.]";
        String result = TEXT.replaceAll(regex,"");
        System.out.println(result.isEmpty());
    }
}
