//Input: a = "11", b = "1", Output: "100"
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1,
        carry = 0;
        while(i >= 0 || j >= 0 || carry > 0){
            int sum = carry;//sum initialized with carry because carry may contain 1 from the prev addition if there was an overflow.
            if(i >= 0){
                sum += a.charAt(i--) - '0';//char at i of a is converted to an integer (by subtracting '0')
            }
            if(j >= 0){
                sum += b.charAt(j--) - '0';
                }
                sb.append(sum % 2);//appends the LSB of the sum to the StringBuilder sb
                //carry for the next iteration. If sum is 2 or 3, carry will be 1 (binary carry-over). If sum is 0 or 1, carry will be 0
                carry = sum / 2;
                }
                return sb.reverse().toString();
                }
            }