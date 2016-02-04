package hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class Palindrome {

    Stack<Character> stack = new Stack();
    Deque<Character> queue = new ArrayDeque<>();
    void pushCharacter(char ch){//: Pushes a character onto a stack.
        stack.push(ch);
    }
    void enqueueCharacter(char ch){//: Enqueues a character in a queue.
        queue.add(ch);
    }
    char popCharacter(){//: Pops and returns the top character.
        return stack.pop();
    }
    char dequeueCharacter(){//: Dequeues and returns the first character.
        return queue.getFirst();
    }

}