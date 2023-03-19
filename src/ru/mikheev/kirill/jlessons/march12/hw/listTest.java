package ru.mikheev.kirill.jlessons.march12.hw;

public class listTest {

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        System.out.println(list.size());
        list.add("8");

        list.add("20");
        list.add("h");
        list.add("szdf");
        list.add("g");
        list.add("2022");
        list.add("202");
        list.add("22");
        list.add("22");
        list.add("n");


        list.showList();
        System.out.println(list.size());



//        list.remove("h");
        list.remove("2022");
//        list.remove("8");

        list.showList();
        System.out.println(list.size());

        list.add(6, "testElem");
        list.add(10, "testElem");

        list.showList();

        System.out.println(list.size());



    }
}
