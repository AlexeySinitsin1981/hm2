package task21;

import java.util.HashMap;

public class MyMap {
    private static final int SIZE = 16;

    private Entry table[] = new Entry[SIZE];

    int count=0;


    public Object get(Object k) {
        int column = k.hashCode() % SIZE;
        Entry e = table[column];

        while(e != null) {
            if(e.key.equals(k)) {
                return e;
            }
            e = e.next;
        }
        return null;
    }

    public Object remove(Object k) {
        int column = k.hashCode() % SIZE;
        Entry e = table[column];
        while(e!=null) {
        if(e.key.equals(k)) {
            count--;
            return table[column]=null;
        }
            table[column]=null;
        }

        return table[column];
    }

    public void add(Object k, Object v) {
        int column = k.hashCode() % SIZE;
        Entry e = table[column];

        if(e != null) {
            if(e.key.equals(k)) {
                e.value = v;
            } else {

                while(e.next != null) {
                    e = e.next;
                }
                e.next =  new Entry(k, v);
            }
        } else {
            Entry entryNewBucket = new Entry(k, v);
            table[column] = entryNewBucket;
        }
        count++;
    }


    public boolean update(Object k, Object v) {
        int column = k.hashCode() % SIZE;
        Entry e = table[column];

        while (table[column].key.equals(k)) {
                table[column] = new Entry(k, v);
                return true;
        }
        return false;
    }

    public boolean checking(Object k) {
        int column = k.hashCode() % SIZE;
        Entry e = table[column];
        while(e != null) {
            if(e.key.equals(k)) {
                return true;
            }
        }
        return false;
    }



      public int getCount() {
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


