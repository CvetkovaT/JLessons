package ru.mikheev.kirill.jlessons.march12.hw;

public interface CustomList {

    void add(String elem);

    void add(int index, String elem);

    void showList();

    String get(int index);

    int size();

    boolean isEmpty();

    String remove(String elem);

    void clear();

    boolean contains(String elem);
}
