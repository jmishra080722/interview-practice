package org.example.uber.section2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,2,2};
        int k = 2;

        /*int[] res = topKFrequentEle2(nums, k);
        for(int n: res){
            System.out.println(n);
        }*/
        List<Map.Entry<Integer, Long>> entries = topKFrequentEle(nums, k);
        for(Map.Entry<Integer, Long> n: entries){
            System.out.println(n.getKey());
        }
    }

    /*private static int[] topKFrequentEle2(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int n: nums){
            freqMap.put(n, freqMap.getOrDefault(n,0)+1);
        }
        System.out.println(freqMap);

        List<Integer>[] bucket = new List[nums.length + 1];
        for(int key: freqMap.keySet()){
            int frequency = freqMap.get(key);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] result = new int[k];
        int counter = 0;
        for(int pos =  bucket.length-1; pos > 0 && counter< k; pos--){
            if(bucket[pos] != null){
                for(Integer in: bucket[pos]){
                    if(counter < k){
                        result[counter++] = in;
                    }
                }
            }
        }
        return result;
    }*/

    private static List<Map.Entry<Integer, Long>> topKFrequentEle(int[] nums, int k) {
        List<Map.Entry<Integer, Long>> collect = Arrays.stream(nums)
                .mapToObj(n -> Integer.valueOf(n))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(k)
                .collect(Collectors.toList());
        System.out.println(collect);
        return collect;
    }
}
