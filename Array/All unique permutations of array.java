import java.util.ArrayList;

class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        permute(arr, 0, n - 1, ans);
        return ans;
        }
        static void permute(ArrayList<Integer> arr, int l, int r, ArrayList<ArrayList<Integer>>
        ans) {
            if (l == r) {
                ans.add(new ArrayList<>(arr));
                } else {
                    for (int i = l; i <= r; i++) {
                        swap(arr, l, i);
                        permute(arr, l + 1, r, ans);
                        swap(arr, l, i);
                        }
                        }
                        }
                        static void swap(ArrayList<Integer> arr, int i, int j) {
                            int temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                            }
    }