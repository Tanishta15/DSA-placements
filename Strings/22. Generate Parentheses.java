import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
        }
        public void backtrack(List<String> res, String s, int left, int right, int n
        ){
            if(s.length() == 2*n){
                res.add(s);
                return;
                }
                if(left < n){
                    backtrack(res, s+"(", left+1, right, n);
                    }
                    if(right < left){
                        backtrack(res, s+")", left, right+1, n);
                        }
                        }
                    }