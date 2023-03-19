package ru.mikheev.kirill.jlessons.march12.hw;

public class MyLinkedList implements CustomList {

    private MyLinkedListNode firstElem, lastElem;

    @Override
    public void add(String elem) {
        addToEnd(elem);
    }

    public void addToEnd(String elem){
        if (firstElem == null){
            this.firstElem = new MyLinkedListNode(elem);
            this.lastElem = new MyLinkedListNode(elem);
            return;
        }
        if (firstElem.next == null){
            this.lastElem = new MyLinkedListNode(elem);
            lastElem.prev = firstElem;
            firstElem.next = lastElem;
            return;
        }
        MyLinkedListNode tmp = lastElem;
        this.lastElem = new MyLinkedListNode(elem);
        lastElem.prev = tmp;
        tmp.next = lastElem;
    }

    public void addToStart(String elem){
        if (firstElem == null){
            firstElem = new MyLinkedListNode(elem);
            lastElem = new MyLinkedListNode(elem);
            return;
        }
        if (firstElem.next == null){
            firstElem = new MyLinkedListNode(elem);
            firstElem.next = lastElem;
            lastElem.prev = firstElem;
            return;
        }
        MyLinkedListNode tmp = firstElem;
        firstElem = new MyLinkedListNode(elem);
        firstElem.next = tmp;
        tmp.prev = firstElem;
    }

    @Override
    public void add(int index, String elem) {
        if (this.size() < index) {
            throw new NullPointerException("previosly element not found");
        }
        if (this.size() == index) {
            this.add(elem);
            return;
        }

        if (index == 0){
            MyLinkedListNode tmp = firstElem;
            firstElem = new MyLinkedListNode(elem);
            firstElem.next = tmp;
            return;
        }

        MyLinkedListNode tmp = goToSomeElem(index);
        MyLinkedListNode myNode = new MyLinkedListNode(elem);
        myNode.prev = tmp.prev;
        myNode.next = tmp;
        tmp.prev.next = myNode;
        tmp.prev = myNode;
    }

    @Override
    public void showList() {
        if (firstElem == null){
            System.out.print("list is empty");
        }
        MyLinkedListNode tmp = firstElem;
        while (tmp != null){
            System.out.print(tmp.value + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    @Override
    public String get(int index) {
        MyLinkedListNode tmp = new MyLinkedListNode();
        tmp = goToSomeElem(index);
        return tmp.value;
    }

    @Override
    public int size() {
        int enumerator = 0;
        MyLinkedListNode thisNode = firstElem;
        while (thisNode != null){
            thisNode = thisNode.next;
            enumerator++;
        }
        return enumerator;
    }

    @Override
    public boolean isEmpty() {
        if (firstElem == null)
            return true;
        return false;
    }

    @Override
    public String remove(String elem) {
        MyLinkedListNode tmp = new MyLinkedListNode();
        tmp = findSomeElem(elem);
        if (tmp.next != null) {
            tmp.next.prev = tmp.prev;
        } else {
            this.lastElem = tmp.prev;
        }
        if (tmp.prev != null) {
            tmp.prev.next = tmp.next;
        } else {
            this.firstElem = tmp.next;
        }
        return tmp.value;
    }

    @Override
    public void clear() {
        while (firstElem.next != null){
            firstElem = firstElem.next;
            firstElem.prev = null;
        }
        firstElem = null;
        lastElem = null;

    }

    @Override
    public boolean contains(String elem) {
        if (findSomeElem(elem) != null)
            return true;
        return false;
    }


    private class MyLinkedListNode {
        String value;
        MyLinkedListNode next;
        MyLinkedListNode prev;

        public MyLinkedListNode() {
        }

        public MyLinkedListNode(String value) {
            this.value = value;
        }
    }

    private MyLinkedListNode goToSomeElem(int index){
        MyLinkedListNode findElem = firstElem;
        while (index >0){
            if (findElem.next == null){
                throw new NullPointerException("element is not found");
            }
            findElem = findElem.next;
            index--;
        }
        return findElem;
    }

    private MyLinkedListNode findSomeElem(String elem){
        MyLinkedListNode findElem = firstElem;
        while (findElem != null){
            if(findElem.value == elem)
                return findElem;
            findElem = findElem.next;
        }
        return null;
    }

}
