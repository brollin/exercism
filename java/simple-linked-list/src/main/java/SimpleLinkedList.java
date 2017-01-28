import java.util.NoSuchElementException;
import java.lang.reflect.Array;

public class SimpleLinkedList {
    
    private int size = 0;
    private Element firstElement;

    public SimpleLinkedList() {
        
    }
    
    public SimpleLinkedList(Object[] objects) {
        for (Object obj : objects) {
            push(obj);
        }
    }

    public void push(Object obj) {
        size++;
        Element el = new Element(obj);
        
        el.setNext(firstElement);
        firstElement = el;
    }

    public int size() {
        return size;
    }

    public Object pop() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        else if (size == 1) {
            Object data = firstElement.getData();
            firstElement = null;
            size--;
            return data;
        }
        else {

            Object data = firstElement.getData();
            firstElement = firstElement.getNext();
            size--;
            return data;
        }
    }

    public void reverse() {
        Element prev = null;
        Element curr = firstElement;
        Element next = null;

        while (curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }

        firstElement = prev;
    }

    public Object[] asArray(Class class_) {
        Object[] array = (Object[]) Array.newInstance(class_, size());
        Element curr = firstElement;
        int index = 0;
        while (curr != null) {
            Array.set(array, index, curr.getData());
            index++;
            curr = curr.getNext();
        }

        return array;
    }

    public class Element {
        private Object data;
        private Element next = null;

        public Element() {
        }
        
        public Element(Object obj) {
            data = obj;
        }
        
        public Object getData() {
            return data;
        }

        public void setNext(Element obj) {
            next = obj;
        }
        
        public Element getNext() {
            return next;
        }

        public boolean hasNext() {
            return next != null;
        }
    }
}
