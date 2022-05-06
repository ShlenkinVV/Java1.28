package com.company;

import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.lang.Math;


public class Main {
    public static void main(String[] args) {

    String str= new String("Hello");                //Первое задание
    Printable printable = (s)->System.out.println(s);
    printable.print(str);


    Predicate<String> notNull = s -> s==null;                      //Второе задание
    System.out.println("Строка не NULL?: " + notNull.test(str));

    String str1 = new String("");
    Predicate<String> isEmpty = s -> s.isEmpty();          //Третье задание
    System.out.println("Строка пустая?: "+ isEmpty.test(str1));

    String str3 = new String("Hello world");
    System.out.println("Строка не пустая и не NULL?: " + !notNull.and(isEmpty).test(str));        //Четвёртое задание


    Predicate<String> starts = s -> s.startsWith("N") || s.startsWith("J"); //Пятое задание
    Predicate<String> ends = s -> s.endsWith("A");
    String str4 = new String("JAVA");
    System.out.println("Строка начинатеся с J или N и заканчивается на А?: "+starts.and(ends).test(str4));

    Consumer<HeavyBox> loadBox = b -> System.out.println("Отгрузили ящик с весом " + b.getWeight());    //Шестое задание
    Consumer<HeavyBox> sendBox = b -> System.out.println("Отправили ящик с весом " + b.getWeight());
    HeavyBox heavyBox = new HeavyBox(120);
    loadBox.andThen(sendBox).accept(heavyBox);

    Function<Integer, String> function = i -> {             //седьмое задание
        if (i>0)
            return "Положительное число";
        else if (i<0)
            return "Отрицательное число";
        else
            return "Ноль";
    };

    System.out.println(function.apply(5));
    System.out.println((function.apply(-10)));


    Supplier supplier = ()->Math.random()*10;          //восьмое задание
    System.out.println(supplier.get());


   Printable printable1 = System.out::println;          //девятое задание
   printable1.print("Hello");


    }

    public interface Printable {
        public void print(String s);
    }

    public static class HeavyBox {
        private int weight;

        public  HeavyBox(int weight){
            this.weight=weight;
        }

        public int getWeight(){
            return weight;
        }

    }

}




