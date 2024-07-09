public class Palindrome {
    private String str;
    private String originalStr;
    public Palindrome(String input){
        str = input.replaceAll("\\p{Punct}", "").replaceAll("[\\s+]", "").toLowerCase();
        originalStr = input;
    }

    public String printString(){
        return originalStr.toUpperCase();
    }

    public boolean palindromecheck(){
        char[] cArr = str.toCharArray();
        return checkPalindrome(cArr, 0, cArr.length-1);
    }
    private boolean checkPalindrome(char[] charArr, int startIndex, int endIndex){
        // base case, we went through the entire thing and it matches so true
        if(startIndex >= endIndex){
            return true;
        }

        // if they don't match return false
        if(charArr[startIndex] != charArr[endIndex]) {
            return false;
        }

        // startIndex count goes up, endIndex count goes down
        return checkPalindrome(charArr, startIndex + 1, endIndex - 1);
    }

}
