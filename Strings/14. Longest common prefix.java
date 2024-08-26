//Input: strs = ["flower","flow","flight"]
//Output: "fl"
class Solution {
    public String longestCommonPrefix(String[] strs){
        if(strs.length == 0){
        return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
        //starts from 0 and sees 1,2...
        while(strs[i].indexOf(prefix) != 0){
            prefix = prefix.substring(0, prefix.length() - 1);
            }
            }
            return prefix;
    }
}