package com.adneom;

import java.util.Arrays;
import java.util.Collection;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * The type List formatter.
 */
public class ListFormatter {

    /**
     * Partition collection into collections of taille size.
     *
     * @param liste  the list to be splitted
     * @param taille the max size of splitted lists
     * @return the collection of collections
     */
    public Collection<List<Integer>> partition(final int[] liste, final int taille) throws InvalidPropertiesFormatException {

        if (liste == null || liste.length <= 0) {
            throw new InvalidPropertiesFormatException("The input list must not be empty");
        } else {
            List<Integer> list = Arrays.stream(liste).boxed().collect(Collectors.toList());

            final AtomicInteger counter = new AtomicInteger();

            return list.stream()
                    .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / taille))
                    .values();
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(final String[] args) {
        ListFormatter listFormatter = new ListFormatter();
        Collection<List<Integer>> partition = null;
        try {
            partition = listFormatter.partition(new int[]{1, 2, 3, 4, 5}, 2);
        } catch (InvalidPropertiesFormatException e) {
            e.printStackTrace();
        }
        System.out.println(partition);
    }
}
