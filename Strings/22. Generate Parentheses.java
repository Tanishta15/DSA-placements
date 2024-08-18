import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        //result,empty string to start,count of left ( and right ),total number of pairs to generate
        return res;
        }
        public void backtrack(List<String> res, String s, int left, int right, int n){
            if(s.length() == 2*n){//since each pair of () contributes 2 char
                res.add(s);
                return;
                }
                if(left < n){//checks if more left ( can be added
                    backtrack(res, s+"(", left+1, right, n);
                    }
                    if(right < left){//ensures that a right ) is only added if there are unmatched left (
                        backtrack(res, s+")", left, right+1, n);
                        }
                        }
                    }