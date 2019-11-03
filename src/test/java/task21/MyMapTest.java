package task21;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyMapTest {
    MyMap myMap=new MyMap();
    @Test
    public void get() {
        myMap.add("1","1");
        assertEquals(myMap.get("1"),new Entry("1","1"));
    }

    @Test
    public void remove() {
        myMap.add("1","1");
        myMap.remove("1");
        assertEquals(0, myMap.count);
    }

    @Test
    public void add() {
        myMap.add("1","1");
        assertEquals(1, myMap.count);
    }

    @Test
    public void update() {
        myMap.add("1","1");
        myMap.update( "1", "2");
        assertEquals(new Entry("1", "2"), myMap.get("1"));


    }

    @Test
    public void checking() {
        myMap.add("1","1");
        assertEquals("1", "1");
    }

    @Test
    public void getCount() {
        myMap.add("1","1");
        assertEquals(1, myMap.count);
        myMap.remove("1");
        assertEquals(0, myMap.count);
    }
}