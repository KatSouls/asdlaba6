package zd1_2;



// IN D(rear)<-D<-D<-D<-D(front) OUT     (<-) = .next

public class MyQueue<T> {

    // Узел связанного списка
    private class Node<T> {
        T data;       // целочисленные данные
        Node next;      // указатель на следующий узел

        public Node(T data)
        {
            // устанавливаем данные в выделенном узле и возвращаем их
            this.data = data;
            this.next = null;
        }
    }



    public static boolean debug = false;
    private Node rear = null;
    private Node front = null;
    private int count = 0;


    public T popFirst()     // удалить и вернуть в начале
    {
        if (front == null)
        {
            System.out.println("\nQueue Underflow");
            System.exit(-1);
        }

        Node temp = front;

        // продвигаемся вперед к следующему узлу
        front = front.next;

        // если список станет пустым
        if (front == null) {
            rear = null;
        }

        // уменьшить количество узлов на 1
        count -= 1;

        if(debug) System.out.println("взят с удалением эл: "+temp.data);
        // вернуть удаленный элемент
        return (T) temp.data;
    }


    public void addLast(T item)     // вставка в конце
    {
        // выделяем новый узел в куче
        Node node = new Node(item);
        if(debug) System.out.println("добавлен эл. в конец очереди:" + item);
        // особый случай: queue пуста
        if (front == null)
        {
            // инициализируем и переднюю, и заднюю часть
            front = node;
            rear = node;
        }
        else {
            // обновить заднюю часть
            rear.next = node;
            rear = node;
        }

        // увеличить количество узлов на 1
        count += 1;
    }

    // Вспомогательная функция для возврата первого элемента в queue
    public T peek()
    {
        // проверяем наличие пустой queue
        if (front == null) {
            System.exit(-1);
        }

        if(debug) System.out.println("Взят эл. из конца очереди: " + front.data);
        return (T) front.data;
    }

    // Вспомогательная функция для проверки, пуста ли queue или нет
    public  boolean isEmpty() {
        return rear == null && front == null;
    }

    // Функция для возврата размера queue
    private int size() {
        return count;
    }
}
