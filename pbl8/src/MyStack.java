import java.util.EmptyStackException;

public class MyStack<E> {
    MyLinkedList<E> list  = new MyLinkedList<>();

    public E push(E e){
        list.add(e);
        return e;
    }

    public E pop(){
        if(list.size == 0){
            throw new EmptyStackException();
        }
        E e = list.get(list.size-1);

        list.delete(list.size-1);


        return e;
    }

    public E peek(){
        if(list.size==0){
            throw new EmptyStackException();
        }

        return list.get(list.size-1);
    }
}
