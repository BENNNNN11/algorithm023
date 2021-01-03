import java.util.Deque;
import java.util.LinkedList;

public class DequeV2 {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        // getFirst() differs from peekFirst() only in that
        // it throws an exception if this deque is empty.
        String str = deque.getFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            // removeFirst() differs from pollFirst() only in that
            // it throws an exception if this deque is empty.
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }
}
