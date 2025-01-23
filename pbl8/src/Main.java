import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> integerMyLinkedList = new MyLinkedList<>();


        integerMyLinkedList.add(1);
        integerMyLinkedList.add(2);
        integerMyLinkedList.add(3);
        integerMyLinkedList.add(4);
        integerMyLinkedList.add(5);

        Iterator<Integer> it = integerMyLinkedList.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}