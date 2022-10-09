package zzz_codingChallenges.leetcode.easy;

import java.util.Stack;

public class MinStack {

    Stack<Integer> s;
    Stack<Integer> ss;

    public MinStack() {
        s = new Stack<>();
        ss = new Stack<>();
    }

    public void push(int val) {
        if(ss.isEmpty()) ss.push(val);
        else if (ss.peek() >= val) ss.push(val);

        s.push(val);
    }

    public void pop() {
        if(s.isEmpty() || ss.isEmpty()) return;

        int val = s.pop();
        if(ss.peek() == val) ss.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return ss.peek();
    }
}
