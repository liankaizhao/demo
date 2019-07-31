package com.example.demo.exercise;

import java.util.*;

class MinStack {

    private Stack<Integer> stack=new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {

        stack.push(x);
    }

    public void pop() {


        stack.pop();
    }

    public int top() {

        return stack.peek();
    }

    public int getMin() {

        int min;
        ListIterator<Integer> integers = stack.listIterator();
        List<Integer> list = new ArrayList<>();
        HashMap map=new HashMap(12, (float) 0.5);
        while (integers.hasNext()) {

            list.add(integers.next());
        }


        if (list.size() > 0) {
            for (int i = 0; i<list.size(); i++ ) {
                for (int j = i+1; j < list.size(); j++) {
                    if (list.get(j) > list.get(i)) {
                         int tmp=list.get(j);

                    }
                }
            }
        }
        return 0;

    }
}