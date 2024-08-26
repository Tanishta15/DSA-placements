//valid numbers: "2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789" 
//not valid numbers: "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"
class Solution {
    public boolean isNumber(String s) {
    boolean numberSeen = false;
    boolean eSeen = false;
    boolean dotCheck = false;

    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if (Character.isDigit(ch)) {
            numberSeen = true;
        } else if (ch == '+' || ch == '-') {
            if (i > 0 && (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')){
                return false;
            }
        } else if (ch == '.') {
            if (dotCheck || eSeen) {
                return false;
            }
            dotCheck = true;
        } else if (ch == 'e' || ch == 'E') {
            if (eSeen || !numberSeen) {
                return false;
            }
            eSeen = true;
            numberSeen = false;
        } else {
            return false; 
        }
    }
    return numberSeen;
    }
}