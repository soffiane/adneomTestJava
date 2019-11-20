package com.adneom;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertThat;

public class ListFormatterTest {

    ListFormatter listFormatter;

    @Before
    public void setUp() throws Exception {
        listFormatter = new ListFormatter();
    }

    @Test
    public void partitionFiveElementListIntoTwoElementListsTest() throws InvalidPropertiesFormatException {
        int[] liste = new int[]{1,2,3,4,5};
        int taille = 2;
        Collection<List<Integer>> partition = listFormatter.partition(liste, taille);
        List<Integer> integers1 = new ArrayList<>();
        integers1.add(1);
        integers1.add(2);
        List<Integer> integers2 = new ArrayList<>();
        integers2.add(3);
        integers2.add(4);
        List<Integer> integers3 = new ArrayList<>();
        integers3.add(5);
        assertThat(partition, CoreMatchers.hasItems(integers1,integers2,integers3));
    }

    @Test
    public void partitionFiveElementListIntoThreeElementListsTest() throws InvalidPropertiesFormatException {
        int[] liste = new int[]{1,2,3,4,5};
        int taille = 3;
        Collection<List<Integer>> partition = listFormatter.partition(liste, taille);
        List<Integer> integers1 = new ArrayList<>();
        integers1.add(1);
        integers1.add(2);
        integers1.add(3);
        List<Integer> integers2 = new ArrayList<>();
        integers2.add(4);
        integers2.add(5);
        assertThat(partition, CoreMatchers.hasItems(integers1,integers2));
    }

    @Test
    public void partitionFiveElementListIntoOneElementListsTest() throws InvalidPropertiesFormatException {
        int[] liste = new int[]{1,2,3,4,5};
        int taille = 1;
        Collection<List<Integer>> partition = listFormatter.partition(liste, taille);
        List<Integer> integers1 = new ArrayList<>();
        integers1.add(1);
        List<Integer> integers2 = new ArrayList<>();
        integers2.add(2);
        List<Integer> integers3 = new ArrayList<>();
        integers3.add(3);
        List<Integer> integers4 = new ArrayList<>();
        integers4.add(4);
        List<Integer> integers5 = new ArrayList<>();
        integers5.add(5);
        assertThat(partition, CoreMatchers.hasItems(integers1,integers2,integers3,integers4,integers5));
    }

    @Test
    public void partitionHugeElementListIntoOneElementListsTest() throws InvalidPropertiesFormatException {
        IntStream liste = IntStream.range(0,Integer.MAX_VALUE);
        int taille = 1;
        Collection<List<Integer>> partition = listFormatter.partition(liste.toArray(), taille);
        for(int i=0;i<liste.count();i++){

        }
        List<Integer> integers1 = new ArrayList<>();
        integers1.add(1);
        List<Integer> integers2 = new ArrayList<>();
        integers2.add(2);
        List<Integer> integers3 = new ArrayList<>();
        integers3.add(3);
        List<Integer> integers4 = new ArrayList<>();
        integers4.add(4);
        List<Integer> integers5 = new ArrayList<>();
        integers5.add(5);
        assertThat(partition, CoreMatchers.hasItems(integers1,integers2,integers3,integers4,integers5));
    }
}