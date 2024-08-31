//o partition the string into as many parts as possible so that each letter appears in at most one part
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
        //s.charAt(i) - 'a' converts the character to an index between 0 and 25
        //last will store the index of the last occurrence of each char
        last[s.charAt(i) - 'a'] = i;
            }
        List<Integer> res = new ArrayList<>();//store the sizes of the partitions
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);//current and max char
            if (i == end) {
                res.add(end - start + 1);//Adds the size of the current partition to res
                start = i + 1;//Moves the start pointer to the beg of the next partition
                }
                }
                return res;
                }
                }