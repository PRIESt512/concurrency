package ru.hacker.concurrency;

public class ArrayBubble {
    private long[] a;   //ссылка на массив
    private int elems;  //количество элементов в массиве

    private final String nameThread;

    public ArrayBubble(int max, String name) {    //конструктор класса
        a = new long[max];          //создание массива размером max
        elems = 0;                  //при создании массив содержит 0 элементов
        nameThread = name;
    }

    public void into(long value) {   //метод вставки элемента в массив
        a[elems] = value;           //вставка value в массив a
        elems++;                    //размер массива увеличивается
    }

    public int getMin() {
        return (int) a[0];//здесь минимальный элемент массива
    }

    public void printer() {          //метод вывода массива в консоль
        for (int i = 0; i < elems; i++) {    //для каждого элемента в массиве
            System.out.print(a[i] + " ");   //вывести в консоль
            System.out.println("");         //с новой строки
        }
        System.out.println("----Окончание вывода массива----");
    }

    private void toSwap(int first, int second) { //метод меняет местами пару чисел массива
        long dummy = a[first];      //во временную переменную помещаем первый элемент
        a[first] = a[second];       //на место первого ставим второй элемент
        a[second] = dummy;          //вместо второго элемента пишем первый из временной памяти
    }

    public void bubbleSorter() {     //МЕТОД ПУЗЫРЬКОВОЙ СОРТИРОВКИ
        Thread.currentThread().setName(String.format("%s - %s", Thread.currentThread().getName(), nameThread));
        System.out.println(String.format("Запустили задачу в потоке %s", Thread.currentThread().getName()));
        for (int out = elems - 1; out >= 1; out--) {  //Внешний цикл
            for (int in = 0; in < out; in++) {       //Внутренний цикл
                if (a[in] > a[in + 1])               //Если порядок элементов нарушен
                    toSwap(in, in + 1);             //вызвать метод, меняющий местами
            }
        }
    }
}

