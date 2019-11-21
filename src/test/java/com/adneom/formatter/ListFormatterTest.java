package com.adneom.formatter;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertThat;

/**
 * The List formatter test.
 */
public class ListFormatterTest {

    /**
     * The basic list for tests
     */
    public static final String LISTE = "[1,2,3,4,5]";
    /**
     * The List formatter.
     */
    public ListFormatter listFormatter;

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        listFormatter = new ListFormatter();
    }

    /**
     * Partition five element list into two element lists test.
     */
    @Test
    public void partitionFiveElementListIntoTwoElementListsTest() {

        final Collection<List<Integer>> partition = listFormatter.partition(LISTE, "2");
        final List<Integer> integers1 = new ArrayList<>();
        integers1.add(1);
        integers1.add(2);
        final List<Integer> integers2 = new ArrayList<>();
        integers2.add(3);
        integers2.add(4);
        final List<Integer> integers3 = new ArrayList<>();
        integers3.add(5);
        assertThat("the two collections should be the same", partition, CoreMatchers.hasItems(integers1, integers2, integers3));
    }

    /**
     * Partition five element list into three element lists test.
     */
    @Test
    public void partitionFiveElementListIntoThreeElementListsTest() {
        final Collection<List<Integer>> partition = listFormatter.partition(LISTE, "3");
        final List<Integer> integers1 = new ArrayList<>();
        integers1.add(1);
        integers1.add(2);
        integers1.add(3);
        final List<Integer> integers2 = new ArrayList<>();
        integers2.add(4);
        integers2.add(5);
        assertThat("the two collections should be the same", partition, CoreMatchers.hasItems(integers1, integers2));
    }

    /**
     * Partition five element list into one element lists test.
     */
    @Test
    public void partitionFiveElementListIntoOneElementListsTest() {
        final Collection<List<Integer>> partition = listFormatter.partition(LISTE, "1");
        final List<Integer> integers1 = new ArrayList<>();
        integers1.add(1);
        final List<Integer> integers2 = new ArrayList<>();
        integers2.add(2);
        final List<Integer> integers3 = new ArrayList<>();
        integers3.add(3);
        final List<Integer> integers4 = new ArrayList<>();
        integers4.add(4);
        final List<Integer> integers5 = new ArrayList<>();
        integers5.add(5);
        assertThat("the two collections should be the same", partition, CoreMatchers.hasItems(integers1, integers2, integers3, integers4, integers5));
    }

    /**
     * Partition invalid size parameters test.
     */
    @Test(expected = NumberFormatException.class)
    public void partitionInvalidSizeParametersTest() {
        listFormatter.partition(LISTE, "toto");
    }

    /**
     * Partition invalid list parameters test.
     */
    @Test(expected = NumberFormatException.class)
    public void partitionInvalidListParametersTest() {
        listFormatter.partition("wrong list", "2");
    }

    /**
     * Partition invalid empty list parameters test.
     */
    @Test(expected = NumberFormatException.class)
    public void partitionInvalidEmptyListParametersTest() {
        listFormatter.partition("", "2");
    }

}