package zd1_2;



// IN/OUT D(last)<->D<->D<->D<->D(first) IN/OUT

public class MyDeque<T> {

    // Узел связанного списка
    private class Node<T> {
        T data;       // целочисленные данные
        Node next;      // указатель на следующий узел
        Node pred;      // указатель на предыдущий узел

        public Node(T data)
        {
            // устанавливаем данные в выделенном узле и возвращаем их
            this.data = data;
            this.pred = null;
            this.next = null;
        }
    }



    public static boolean debug = false;
    private Node last = null;
    private Node first = null;
    private int count = 0;

    // вставка в начале
    public void addFirst(T item)
    {
        // выделяем новый узел в куче
        Node node = new Node(item);
        if(debug) System.out.println("добавлен эл. в начало очереди:" + item);
        // особый случай: deque пуста
        if (first == null)
        {
            // инициализируем и переднюю, и заднюю часть
            first = node;
            last = node;
        }
        else {
            // обновить переднюю часть
            node.next = first; //+левая связь
            first.pred = node; //+правая связь
            first = node;
        }

        count += 1;
    }

    // удалить и вернуть в начале
    public T popFirst()
    {
        if (first == null)
        {
            System.out.println("\nQueue Underflow");
            System.exit(-1);
        }

        Node temp = first;

        // продвигаемся вперед к следующей ноде
        first = first.next;
        if(first!=null)
            first.pred = null;

        // если список станет пустым
        if (first == null) {
            last = null;
        }

        count -= 1;

        if(debug) System.out.println("взят с удалением эл. в начале очереди: "+temp.data);
        // вернуть удаленный элемент
        return (T) temp.data;
    }


    public void addLast(T item)     // вставка в конце
    {
        // выделяем новый узел в куче
        Node node = new Node(item);
        if(debug) System.out.println("добавлен эл. в конец очереди:" + item);
        // особый случай: deque пуста
        if (first == null)
        {
            // инициализируем и переднюю, и заднюю часть
            first = node;
            last = node;
        }
        else {
            // обновить заднюю часть
            last.next = node;
            node.pred = last;
            last = node;
        }

        count += 1;
    }

    // удалить и вернуть в конце
    public T popLast()
    {
        if (last == null)
        {
            System.out.println("\nQueue Underflow");
            System.exit(-1);
        }

        Node temp = last;

        // продвигаемся назад к предыдущей ноде
        last = last.pred;
        temp.pred = null;
        if(last!=null)
            last.next = null;

        // если список станет пустым
        if (last == null) {
            first = null;
        }

        count -= 1;

        if(debug) System.out.println("взят с удалением эл. в конце очереди: "+temp.data);
        // вернуть удаленный элемент
        return (T) temp.data;
    }


    public T peekFirst()
    {
        if (first == null) {
            System.exit(-1);
        }

        if(debug) System.out.println("Взят эл. из начала очереди: " + first.data);
        return (T) first.data;
    }

    public T peekLast()
    {
        if (last == null) {
            System.exit(-1);
        }

        if(debug) System.out.println("Взят эл. из конца очереди: " + first.data);
        return (T) last.data;
    }


    public  boolean isEmpty() {
        return last == null && first == null;
    }

    private int size() {
        return count;
    }
}
