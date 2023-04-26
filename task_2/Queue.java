//2) Реализуйте очередь с помощью LinkedList со следующими методами:
//        enqueue() - помещает элемент в конец очереди,
//        dequeue() - возвращает первый элемент из очереди и удаляет его,
//        first() - возвращает первый элемент из очереди, не удаляя.

import java.util.LinkedList;

public class Queue<T> extends LinkedList<T> {
    public void enqueue(T element) {
        addLast(element);
    }

    public T dequeue() {
        return removeFirst();
    }

    public T first() {
        return getFirst();
    }
}