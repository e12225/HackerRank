import java.io.*;
import java.util.*;

public class Solution {

    static Stack<Integer> front = new Stack<Integer>();
    static Stack<Integer> end = new Stack<Integer>();
        
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int numQueries = scanner.nextInt();
        while (scanner.hasNext()) {
            int operation = scanner.nextInt();
            
            if (operation == 1) {
                // Enque
                end.push(scanner.nextInt());
            } else if (operation == 2) {
                // Deque
                refillFrontIfNecessary();
                front.pop();
            } else if (operation == 3) {
                // Print
                refillFrontIfNecessary();
                System.out.println(front.peek());
            }
        }
    }
    
    static void refillFrontIfNecessary() {
        if (front.empty()) {
            while (!end.empty()) {
                front.push(end.pop());
            }
        }
    }
    
}
