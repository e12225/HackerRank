//Question :- https://www.hackerrank.com/challenges/queue-using-two-stacks/problem

package com.company;


import java.util.*;

class Queue<T> {

    Stack<T> stack = new Stack<>();
    Stack<T> reverseStack = new Stack<>();

    void enqueueElement(T element) {
        stack.push(element);
    }

    T dequeueElement() {
        return reverseStack.pop();
    }

    T peekElement() {
        return reverseStack.peek();
    }
}

public class Solution {

    public static void main(String[] args) {

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

//        1 x: Enqueue element  into the end of the queue.
//        2: Dequeue the element at the front of the queue.
//        3: Print the element at the front of the queue.

        Scanner scanner = new Scanner(System.in);
        int numberOfQueries = scanner.nextInt();
        scanner.nextLine(); // this is to skip the new line and proceed to the query inputs

        Queue<Integer> queue = new Queue<>();

        for (int i=1; i<= numberOfQueries; i++) {

            int queryType = scanner.nextInt();
            if (queryType == 1) {
                int newElement = scanner.nextInt();
                queue.enqueueElement(newElement);
            } else if (queryType == 2) {
                reverseQueue(queue.stack, queue.reverseStack);
                queue.dequeueElement();
            } else if (queryType == 3) {
                reverseQueue(queue.stack, queue.reverseStack);
                System.out.println(queue.peekElement());
            }
        }

        scanner.close();
    }

    static void reverseQueue(Stack originalStack, Stack reversedStack){

        if (reversedStack.empty()) {
            while(!originalStack.empty()){
                reversedStack.push(originalStack.pop());
            }
        }
    }
}

