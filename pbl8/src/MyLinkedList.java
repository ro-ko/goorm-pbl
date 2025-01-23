import java.util.Iterator;

public class MyLinkedList<E>{

    int size = 0;
    Node<E> first;
    Node<E> last;

    public Iterator<E> iterator(){
        MyLinkedList<E> list = this;
        return new Iterator<E>() {
            int cur = -1;

            @Override
            public boolean hasNext() {
                return cur != list.size - 1;
            }

            @Override
            public E next() {
                cur++;
                E e;
                e = list.get(cur);
                return e;
            }

            @Override
            public void remove(){
                if(-1 < cur && cur < list.size()){
                    list.delete(cur);
                    cur--;
                    return;
                }
            }
        };
    }


    private static class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E item, Node<E> next, Node<E> prev){
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

    }

    public MyLinkedList() {
    }

    public int size(){
        return size;
    }

    public void add(E e){
        Node<E> l = last;
        Node<E> newNode = new Node<>(e, null, l);
        last = newNode;

        if (l == null){
            first = newNode;
        }else{
            l.next = newNode;
        }
        size++;
    }

    public E get(int i){
        rangeCheck(i);

        return node(i).item;
    }

    private void rangeCheck(int i) {
        if (i<0 || i >= size){
            throw new IndexOutOfBoundsException();
        }
    }

    private Node<E> node(int i){
        Node<E> x;

        if(i < (size/2)){
            x = first;
            for(int k=0 ; k<i ; k++){
                x = x.next;
            }
        }else{
            x = last;
            for (int k=size-1 ; k>i; k--){
                x = x.prev;
            }
        }
        return x;
    }

    public E delete(int i){
        rangeCheck(i);
        return unLink(node(i));
    }

    private E unLink(Node<E> x){
        E item = x.item;
        Node<E> next = x.next;
        Node<E> prev = x.prev;

        if(prev == null){
            first = next;
        }else{
            prev.next = next;
            x.prev = null;
        }

        if(next == null){
            last = prev;
        }else{
            next.prev = prev;
            x.next = null;
        }
        x.item = null;
        size--;
        return item;
    }
}
