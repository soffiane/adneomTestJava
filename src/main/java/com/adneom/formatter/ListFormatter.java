package com.adneom.formatter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * The type List formatter.
 */
public class ListFormatter {

    /**
     * Logger.
     */
    private static Logger logger = Logger.getLogger(ListFormatter.class.getName());

    /**
     * Partition collection into collections of taille size.
     *
     * @param liste  the list to be splitted
     * @param taille the max size of splitted lists
     * @return the collection of collections
     * @throws NumberFormatException the number format exception
     */
    public Collection<List<Integer>> partition(final String liste, final String taille) throws NumberFormatException {

        final List<Integer> numberList = new ArrayList();
        //retrieving string parameters and convert them into numbers
        final Integer size = Integer.valueOf(taille);
        final String[] values = liste.replace("[", "").replace("]", "").split(",");
        for (final String s : values) {
            numberList.add(Integer.valueOf(s));
        }

        final AtomicInteger counter = new AtomicInteger();
        //splitting list into n lists of size elements
        return numberList.stream()
                .collect(Collectors.groupingBy(element -> counter.getAndIncrement() / size))
                .values();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(final String[] args) {
        final ListFormatter listFormatter = new ListFormatter();
        try {
            System.out.println(listFormatter.partition(args[0], args[1]));
        } catch (NumberFormatException e) {
            logger.log(Level.SEVERE, "invalid parameter " + e.getMessage());
        }
    }
}
