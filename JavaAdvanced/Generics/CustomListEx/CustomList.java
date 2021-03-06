package C_JavaAdvanced.JavaAdv.Generics.CustomListEx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CustomList<E extends Comparable<E>> implements Iterable<E> {

    private List<E> list;
    public int size;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(E element) {
        this.size++;
        list.add(element);
    }



    public int getSize() {
        return this.size;
    }

    public E remove(int index) {
        if (isNotInRange(index)){
            return null;
        }
        this.size--;
        return this.list.remove(index);
    }

    public boolean contains(E element) {
return  this.list.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        if (isNotInRange(firstIndex) || isNotInRange(secondIndex)) {
            System.out.println("FirstIndex/SecondIndex is not a valid index!");
        } else {
            E first = this.list.get(firstIndex);
            E second = this.list.get(secondIndex);
            this.list.set(firstIndex, second);
            this.list.set(secondIndex, first);
        }

    }

    public int countGreaterThan(E element) {
        int count = 0;
        for (E e : list) {
            if (e.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public E getMax() {
        E max = this.list.get(0);
        for (E current : this.list) {
            if (current.compareTo(max) > 0) {
                max = current;
            }
        }

        return max;

    }

    public E getMin() {
        E min = this.list.get(0);
        for (E current : this.list) {
            if (current.compareTo(min) < 0) {
                min = current;
            }
        }

        return min;
    }

    public E get(int index){
       if (isNotInRange(index)){
           System.out.println("Index is not valid");
           return null;
       }
       return this.list.get(index);
    }


    private boolean isNotInRange(int index){return index<0||index>=this.list.size();}

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index =0;
            @Override
            public boolean hasNext() {
                return index<list.size();
            }

            @Override
            public E next() {
                return list.get(index++);
            }
        };
    }
}
