package org.jpj.datastructure.stacks.challenge;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedStack {

    private LinkedList<Character> stack;
    public LinkedStack() {
        stack = new LinkedList<>();
    }

    public void push(Character ch) {
        stack.push(ch);
    }

    public Character pop() {
        return stack.pop();
    }

    public Iterator<Character> iterator() {
        return stack.iterator();
    }
}
