package com.example.demo.test;

import java.lang.reflect.Array;
import java.util.*;

public class SortExample {

    public static void main(String[] args) {

        int [] array={2,10,12,16,11,21,20,8};
        //int result = majorityElement(array);
        //System.out.println(result);
        //checkSorts(array);
       // quickSort(array,0,array.length-1);
        //System.out.println(array);
        checkSorts(array);

//        List<String> stringList = new LinkedList<>();
//        stringList.add("a");
//        stringList.add("b");
//        stringList.add("c");
//        Iterator<String> stringIterator=stringList.listIterator();
//        while (stringIterator.hasNext()) {
//            String s=stringIterator.next();
//            if (s.equals("a")) {
//                stringIterator.remove();
//            }
//        }
//        System.out.println(stringList.size());

    }



    public static void checkSorts(int [] array){

        for (int i=0; i<array.length; i++) {
            int min=i;
            for (int j=i+1; j<array.length;j++) {
                if (array[j] < array[min]) {
                    min=j;
                }
            }

            if (min != i) {
                int tmp=array[i];
                array[i]=array[min];
                array[min]=tmp;
            }
        }
        System.out.println(array);


    }

    public static int[] insertSort(int[] array) {

        int[] newArray = Arrays.copyOf(array, array.length);
        for (int i = 1; i < array.length; i++) {
            // 记录要插入的数据
            int tmp = array[i];
            int j = i;
            // 从排好序的序列最右边开始比较，查找比其小的数
            while (j > 0 && tmp < newArray[j - 1]) {
                newArray[j] = newArray[j - 1];
                j--;
            }
            // 如果存在比其小的数，则插入
            if (j != i) {
                newArray[j] = tmp;
            }
        }

        return newArray;
    }


    /**
     * 快速排序
     * @param array
     * @param left
     * @param right
     */
    public static void quickSort(int[] array, int left, int right) {

        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int base = array[left];
        while (i < j) {
            while (base <= array[j] && i < j) {
                j--;
            }

            while (base >= array[i] && i < j) {
                i++;
            }

            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        array[left] = array[i];
        array[i] = base;

        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);


    }

    /**
     * 数组是否包含多个元素
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i],nums[i]);
        }
        return false;

    }


    /**
     * 求最大子序和
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int res = nums[0];
        for(int num : nums){
            sum = sum > 0 ? sum+num : num;
            if(res < sum){
                res = sum;
            }
        }
        return res;


    }




    public static  int [] sort(int [] array) {

        int length=array.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (array[i] > array[j]) {
                    int temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
        return array;
    }

    public static int majorityElement(int[] nums) {
        int condition = nums.length/2;
        int element = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (Integer num : nums) {
            if (map.containsKey(num)) {
                int result = map.get(num)+1;
                map.put(num,result);
            }else {

                map.put(num,1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > condition) {
                element=entry.getKey();
            }
        }

        return element;

    }

    /**
     * 选择排序
     * @param array
     */
    public static  void checkSort(int [] array) {

        // 经过N-1轮比较
        for (int j=0; j<array.length-1; j++ ) {
            int min=j;
            for (int i=j+1; i<array.length; i++) {
                // 寻找最小值
                if (array[i] < array[min]) {
                    min=i;
                }
            }

            // 将最小值与当前值的位置进行互换，若min=j,则最小值等于当前值
            if (min != j) {
                int temp=array[j];
                array[j]=array[min];
                array[min]=temp;
            }
        }
        System.out.println(array);
    }
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet=new HashSet<>();
        while (nodeSet != null) {
            if (nodeSet.contains(head)) {
                return true;
            }else {
                nodeSet.add(head);
            }
            head=head.next;
        }

        return false;

    }


//
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> nodesSeen = new HashSet<>();
//        while (head != null) {
//            if (nodesSeen.contains(head)) {
//                return true;
//            } else {
//                nodesSeen.add(head);
//            }
//            head = head.next;
//        }
//        return false;
//    }


}
