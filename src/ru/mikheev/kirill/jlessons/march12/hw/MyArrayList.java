package ru.mikheev.kirill.jlessons.march12.hw;

public class MyArrayList implements CustomList {

    private String[] myArrayList;
    int maxSize;
    int quantityOfElements;

    public MyArrayList() {
        this.myArrayList = new String[10];
        this.maxSize = 10;
        this.quantityOfElements = 0;
    }

    public MyArrayList(String[] myArrayList) {
        this.myArrayList = myArrayList;
        this.maxSize = myArrayList.length;
        this.quantityOfElements = maxSize;
    }

    @Override
    public void add(String elem) {
        if (quantityOfElements == maxSize){
            increaseMyArrayList();
        }
        this.myArrayList[quantityOfElements] = elem;
        this.quantityOfElements++;
    }

    @Override
    public void add(int index, String elem) {
        if (index > quantityOfElements + 1)
            throw new NullPointerException("Array is ending");

        if (quantityOfElements == maxSize){
            increaseMyArrayList();
        }

        for (int i = quantityOfElements; i > index; i--) {
            this.myArrayList[i] = myArrayList[i-1];
        }
        this.myArrayList[index] = elem;
        this.quantityOfElements++;
    }

    @Override
    public void showList() {
        for (var iter : myArrayList)
            System.out.print(iter + " ");
        System.out.println();
    }

    @Override
    public String get(int index) {
        return myArrayList[index];
    }

    @Override
    public int size() {
        return quantityOfElements;
    }

    @Override
    public boolean isEmpty() {
        if (quantityOfElements == 0)
            return true;
        return false;
    }

    @Override
    public String remove(String elem) {
        boolean flag = false;
        for (int i = 0; i < quantityOfElements; i++){
            if (myArrayList[i] == elem) {
                flag = true;
            }
            if (!flag) {
                continue;
            }
            if (i == quantityOfElements - 1){
                myArrayList[i] = null;
                quantityOfElements--;
                return elem;
            }
            myArrayList[i] = myArrayList[i+1];

        }
        return null;
    }

    @Override
    public void clear() {
        myArrayList = new String[10];
    }

    @Override
    public boolean contains(String elem) {
        for (int i = 0; i < quantityOfElements; i++)
            if (myArrayList[i] == elem)
                return true;
        return false;
    }

    private void increaseMyArrayList(){
        this.maxSize = maxSize * 3 / 2 + 1;
        String[] increasedList = new String[maxSize];
        for(int i = 0; i < quantityOfElements; i++){
            increasedList[i] = myArrayList[i];
        }
        this.myArrayList = increasedList;

    }
}
