public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (isPalindrome(s)) {
                System.out.println(s + " - палиндром");
            } 
            else {
                System.out.println(s + " - не является палиндромом");
            }
        }
    }

    public static String reverseString(String s) {
        String reversed = "";
        for (int l = s.length() - 1; l >= 0; l--) {
            reversed += s.charAt(l);
        }
        return reversed;
    }

    public static boolean isPalindrome(String s) {
        String reversed = reverseString(s);
        return s.equals(reversed);
    }

}


