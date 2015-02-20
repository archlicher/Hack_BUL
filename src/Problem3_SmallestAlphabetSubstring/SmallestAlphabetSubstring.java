package Problem3_SmallestAlphabetSubstring;

public class SmallestAlphabetSubstring {
    private static final char[] ALPHABET = {'a','b','c','d','e','f','g','h',
                                            'i','j','k','l','m','n','o','p',
                                            'q','r','s','t','u','v','w','x',
                                            'y','z'};
    private static int lengthOfString = 26;

    public static String resultString(String str, int lengthToCheck){
        String result = "";
        if(isValidString(str)) {
            int maxIterations = str.length() - lengthToCheck;
            for(int i=0;i<=maxIterations;i++){
                String strToCheck = str.substring(i,i+lengthToCheck);
                result = checkForAlphabet(strToCheck,ALPHABET);
                if(!result.equals("")){
                    break;
                }
            }
            if (result.equals("") && lengthToCheck<str.length()-1){
                result=resultString(str,++lengthToCheck);
            }
        }
        if (result.equals("")) return "No alphabet here!";
        return result;
    }

    public static String formatResult(String str){
        String formatedResult = resultString(str, lengthOfString);
        if(!formatedResult.equals("No alphabet here!")) {
            return str.replace(formatedResult, "[" + formatedResult + "]");
        }
        else {
            return str;
        }
    }

    private static String checkForAlphabet(String strToCheck, char[] alphabet){
        String stringToLowerCase = strToCheck.toLowerCase();
        int countLetters =0;
        for(char ch : alphabet) {
            if (stringToLowerCase.indexOf(ch) > -1) {
                countLetters++;
                continue;
            }
        }
        if (countLetters==26){
            return strToCheck;
        }
        return "";
    }

    private static boolean isValidString(String str) {
        if(str.length()>26) {
            return true;
        }
        return false;
    }

    public static void main(String[] args){

        String stringToCheckOne = "aaaaaabcdefghijklmnopqrstuvwxyz";
        String stringToCheckTwo = "abcdefghijklmn124345678!@#$%^&*opqrstuvwxyz!*abcdefghijklmn";

        System.out.println(formatResult(stringToCheckOne)+" -> "+ resultString(stringToCheckOne,lengthOfString));
        System.out.println(formatResult(stringToCheckTwo)+" -> "+ resultString(stringToCheckTwo,lengthOfString));
    }
}
