package com.example.demo.observer;

import java.util.HashMap;
import java.util.Stack;

public class Stacks {

    private HashMap<Character,Character> hashMap=new HashMap<>();


    public Stacks(){
        this.hashMap.put(')','(');
        this.hashMap.put('}','{');
        this.hashMap.put(']','[');
    }



    public boolean isValid(String s) {

        Stack<Character> stack=new Stack();

        for(int i=0; i<s.length(); i++){

            char key=s.charAt(i);

            if (hashMap.containsKey(key)) {
                Character topElement=stack.isEmpty() ? '#':stack.pop();

                if (topElement !=hashMap.get(key)) {
                    return  false;
                }

            }else {
                stack.push(key);
            }
        }

        return  stack.isEmpty();
    }
}
