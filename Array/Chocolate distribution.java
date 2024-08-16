import java.util.ArrayList;
import java.util.Collections;

class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        Collections.sort(a);
        long min = Long.MAX_VALUE;
        for(int i=0;i<n-m+1;i++)
        {
            long diff = a.get(i+m-1) - a.get(i);
            if(diff<min)
            {
                min = diff;
                }
                }
                return min;
    }
}