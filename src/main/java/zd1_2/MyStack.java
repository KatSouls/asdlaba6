package zd1_2;


public class MyStack<T>
{
    // Узел связанного списка
    private class Node<T>
    {
        T data;       // целочисленные данные
        Node next;      // указатель на следующий узел
    }






    public static boolean debug = false;
    private Node top;
    private int nodesCount;

    public MyStack() {
        this.top = null;
        this.nodesCount = 0;
    }


    // добавить верхн. эл.
    public void push(T x)
    {

        Node node = new Node();

        // проверяем, заполнен ли Stack
        if (node == null)
        {
            System.out.println("Heap Overflow");
            return;
        }
        if(debug) System.out.println("Вставка эл: " + x);

        node.data = x;
        node.next = top;
        top = node;

        this.nodesCount += 1;
    }

    public boolean isEmpty() {
        return top == null;
    }

    // взять верхн. эл.
    public T peek()
    {
        // проверка на пустой stack
        if (isEmpty()) {
            System.out.println("The stack is empty");
            System.exit(-1);
        }
        if(debug) System.out.println("Взят эл: " + top.data);
        return (T)top.data;
    }

    // взять с удалением верхн. эл.
    public T pop()
    {
        // проверка на опустошение stack
        if (isEmpty())
        {
            System.out.println("Stack Underflow");
            System.exit(-1);
        }

        if(debug) System.out.println("Удаление эл: " + top.data);
        T top = peek();
        this.top = (this.top).next; //перепись ссылки на предыдущую ноду

        this.nodesCount -= 1;
        return top;
    }


    public int size() {
        return this.nodesCount;
    }
}