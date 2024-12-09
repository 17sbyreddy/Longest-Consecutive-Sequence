import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        /*sort input array and then to get rid of duplicates put all the numbers in a array list and then loop through arraylist and check if two numbers are consecutive and set the count higher. reset back to 0 if chain is broken.

         */
        if(nums.length ==0){
            return 0;
        }

        // sort array
        Arrays.sort(nums);

        ArrayList <Integer> list = new ArrayList<>();

        list.add(nums[0]); // have to add first number from array in order for further duplicates in list to be detected.

        int maxCount =0;
        int answer =0;

        // put all non duplicates into array list from input list
        for(int i=1; i <nums.length; i++){ // starting at 1 not to go over array index

            if(nums[i]!= nums[i-1]){ // checking for dups
                list.add(nums[i]);
            }
        }
        // loop thru arraylist and count the longest chain possible
        for(int i=0; i < list.size(); i++){
            if(i >0 && list.get(i) == list.get(i-1) +1){ // checking if numbers increase by 1
                maxCount++;
            }
            else{ // it will hit this first becacuase of i >0
                maxCount = 1;
            }

            answer = Math.max(answer, maxCount); // keeping score of highest possible chain
        }

        return answer;

    }
}