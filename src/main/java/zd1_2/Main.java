package zd1_2;
//в 19* jre <тип> можно не писать, он возьмётся из 1-ого эл.

import java.util.Random;

public class Main {


    public static void main(String[] args) {
        //Random rnd = new Random(74);
        MyStack.debug = true;
        MyQueue.debug = false;


        //СТОПКА НА СТОЛЕ
        System.out.println("Стопка на столе:");
        int n = 10;
        MyStack stopka = new MyStack<>();

        for (int i=0;i<n;i++){
            stopka.push(new Tarelka(true));
        }
        MyStack.debug = false;
        System.out.println();




        //ПОСУДОМОЙКА
        System.out.println("Перенос из стопки в очереди посудомойки:");
        MyQueue qu1 = new MyQueue();
        MyQueue qu2 = new MyQueue();

        boolean swch = true;
        while (!stopka.isEmpty()) { //пока стопка не пустая, добавлять тарелки в 2 очереди
            //переключатель между очередями
            if (swch) {
                System.out.println("Добавлено в 1 очередь: "+stopka.peek());
                qu1.addLast(stopka.pop());
                swch = false;

            }else {
                System.out.println("Добавлено в 2 очередь: "+stopka.peek());
                qu2.addLast(stopka.pop());
                swch = true;
            }
        }
        System.out.println();




        //ПОЛКА
        System.out.println("Перенос из посудомойки в полку:");
        MyDeque deq = new MyDeque<>();

        swch = true;
        Tarelka tar;
        while (!qu1.isEmpty() || !qu2.isEmpty()) { //пока стопка не пустая, добавлять тарелки в 2 очереди
            //переключатель между очередями
            if (swch && !qu1.isEmpty()) {
                tar = (Tarelka) qu1.peek();
                tar.setWaste(false); //тарелка отмылась
                System.out.println("Добавлено из 1 очереди: "+qu1.peek()+" в полку с начала");
                deq.addFirst(qu1.popFirst());
                swch = false;

            }else if(!qu2.isEmpty()){
                tar = (Tarelka) qu2.peek();
                tar.setWaste(false); //тарелка отмылась
                System.out.println("Добавлено из 2 очереди: "+qu2.peek()+" в полку с конца");
                deq.addLast(qu2.popFirst());
                swch = true;
            }
        }
        System.out.println();



        //ПОСУДА НА ПОЛКЕ
        System.out.println("Посуда на полке: (|oooooo|)");
        while (!deq.isEmpty()){
            System.out.println(deq.popLast());
        }
    }

}
