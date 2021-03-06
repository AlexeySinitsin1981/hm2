package ru.sinitsin.stc.hw2;

public class MyMap {
    private static final int SIZE = 16;

    private Entry[] table= new Entry[SIZE];

    int count = 0;


     Object get(Object k) {
        int column = k.hashCode() % SIZE;
        Entry e = table[column];

        while (e != null) {
            if (e.key.equals(k)) {
                return e.getValue();
            }
            e = e.next;
        }
        return null;
    }

     boolean remove(Object k) {
        int column = k.hashCode() % SIZE;
        Entry e = table[column];
        if (table[column] == null) {
            return false;
        } else {
            Entry previous = null;
            Entry current = table[column];

            while (current != null) {
                if (current.key.equals(k)) {
                    if (previous == null) {
                        table[column] = table[column].next;
                        count--;
                        return true;

                    } else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }
    }

     void add(Object k, Object v) {
        if (k == null)
            throw new NullPointerException("Null нельзя хранить");
        int column = k.hashCode() % SIZE;
        Entry e = table[column];

        if (e != null) {
            if (e.key.equals(k)) {
                e.value = v;
            } else {

                while (e.next != null) {
                    e = e.next;
                }
                e.next = new Entry(k, v);
            }
        } else {
            Entry entryNewBucket = new Entry(k, v);
            table[column] = entryNewBucket;
        }
        count++;
    }


     void update(Object k, Object v) {
        int column = k.hashCode() % SIZE;
        Entry e = table[column];

        if (e != null) {
            if (e.key.equals(k)) {
                e.value = v;
            } else {

                while (e.next != null) {
                    e = e.next;
                }
                e.next = new Entry(k, v);
            }
        } else {
            Entry entryNewBucket = new Entry(k, v);
            table[column] = entryNewBucket;
        }
    }


    private boolean checking(Object k) {
        int column = k.hashCode() % SIZE;
        Entry e = table[column];
        if (e != null) {
            return e.key.equals(k);
        }
        return false;
    }

    private int getCount() {
        return count;
    }

    public static void main (String[]args){
            MyMap myHashMap = new MyMap();

            myHashMap.add("Audi", "Germany");
            myHashMap.add("Land-Rover", "England");
            myHashMap.add("Lada", "Russia");
            myHashMap.add("Fiat", "Italy");
            myHashMap.add("Ford", "USA");

            System.out.println("" + myHashMap.get("Lada"));
            myHashMap.remove("Lada");
            System.out.println("" + myHashMap.get("Lada"));


            System.out.println(myHashMap.getCount());
            myHashMap.update("Land-Rover", "Cyprus");
            System.out.println("" + myHashMap.get("Land-Rover"));
            System.out.println(myHashMap.checking("Ford"));


    }
}


