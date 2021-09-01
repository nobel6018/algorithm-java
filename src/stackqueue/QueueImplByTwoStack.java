// Stack 2개로 큐 만들기
/*
 * [아이디어]
 * 스택 두 개를 하나는 enqueue 전용, 다른 하나는 dequeue 전용으로 두는 것입니다
 * enqueue 되는 값은 1번 스택에 push 합니다
 * dequeue를 할 때는 2번 스택이 비어있는 지 체크하여
 *    (1) 비어있지 않았다면 그대로 2번 스택에 pop 합니다
 *    (2) 비어있다면 1번 스택의 모든 요소를 pop하여 2번 스택에 차례로 push 합니다
 *        이렇게 하면 1번 스택에 있던 요소들이 역순으로 2번 스택ㄹ에 들어갑니다.
 *        그 후에 pop 하면 됩니다
 *
 * refer: https://chickenpaella.tistory.com/16
 * */
package stackqueue;

import java.util.Stack;

class Queue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(Integer num) {
        stack1.push(num);
    }

    public int dequeue() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }

        while (stack1.size() > 0) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }
}

public class QueueImplByTwoStack {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        while (queue.size() > 0) {
            System.out.println(queue.dequeue());
        }
    }

}
