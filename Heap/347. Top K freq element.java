import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Create a frequency map
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
        //used to fetch the current frequency of num from the map. 
        //If num is not already in the map, it returns 0. Then, 1 is added to update frequency of num
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        //PriorityQueue (max heap) to store elements based on their frequencies in descending order
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        // Add all entries to the max heap,will automatically sort them based on their frequency
        maxHeap.addAll(countMap.entrySet());
        
        // Extract the top k frequent elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            //poll() removes and returns the element at the top of the heap
            result[i] = maxHeap.poll().getKey();
        }
        return result;
            }
        }