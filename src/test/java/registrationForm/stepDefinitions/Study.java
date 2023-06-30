package registrationForm.stepDefinitions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Study {
    public static void main(String[] args) {
        //find even and odd numbers from an array of integers and turn then into hashmap using streams

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //create a method that will take an array of integers and return a map of even and odd numbers
        //key - even, value - list of even numbers
        //key - odd, value - list of odd numbers
        //output: {even=[2,4,6,8,10], odd=[1,3,5,7,9]}
        //hint: use streams

        HashMap<String, List<Integer>> map = new HashMap<>();
        List<Integer> ls=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2==0){
                ls.add(arr[i]);
                map.put("even",ls);
            }
            else{
                ls.add(arr[i]);
                map.put("odd",ls);
            }

        }
        System.out.println(map);
    }

}
