public class Main {

    public static boolean isPalindrome(String str) {
        System.out.println();
        str = str.toLowerCase();
        String reversed = new StringBuilder(str).reverse().toString();

        return str.equals(reversed);
    }

    public static int countVowels(String str) {
        System.out.println();
        str = str.toLowerCase();
        int count = 0;

        for (char c : str.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }

        return count;
    }

    public static String reverseString(String str) {
        System.out.println();

        return new StringBuilder(str).reverse().toString();
    }

    public static boolean isEmpty(String str) {
        System.out.println();

        return str.trim().isEmpty();
    }

    public static int countLetters(String str) {
        System.out.println();
        int count = 0;

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                count++;
            }
        }

        return count;
    }

    public static String repeatString(String str, int times) {
       System.out.println();

        return str.repeat(times);
    }

    public static String duplicateCharacters(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            result.append(c).append(c);
        }
        return result.toString();
    }








    public static void main(String[] args) {
        System.out.println(isPalindrome("Dedoded"));
        System.out.println(countVowels("Antiuova"));
        System.out.println(reverseString("Ogr"));
        System.out.println(isEmpty(" "));
        System.out.println(countLetters("azov"));
        System.out.println(repeatString("mal ", 2));
        System.out.println(duplicateCharacters("double"));
    }
}



//git remote add origin https://github.com/JegorZavod148/Demo.git
//git push -u origin main