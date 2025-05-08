

// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

import java.util.Arrays;

public class DynamicArray<T> implements IndexAccess<T>{
    
    private T[] array;
    private int size;

    public DynamicArray(int size, T[] initialArray) {
        this.size = size;
        this.array = initialArray; 
    }

    public T get(int i) {
        return array[i];
    }

    public T get(int i, int offset) {
        int newIndex = i + offset;
        return array[newIndex];
    }

    public void set(int i, T val) {
        array[i] = val;
    }
    
    // What instance variables do you need?

    // Write a constructor to make a new DynamicArray Object from an array

    // Now implement the methods from IndexAccess?

}
