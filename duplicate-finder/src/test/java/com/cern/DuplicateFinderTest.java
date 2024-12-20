package com.cern;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.cern.DuplicateFinder.findDuplicates;
import static org.junit.jupiter.api.Assertions.*;

public class DuplicateFinderTest {

    @Test
    public void GivenStringList_WhenFindDuplicates_ThenReturnDuplicatesSuccessfully() {
        //Given
        List<String> list = Arrays.asList("b", "a", "c", "c", "e", "a", "c", "d", "c", "d");

        //When
        List<String> duplicates = findDuplicates(list);

        //Then
        assertEquals(Arrays.asList("a", "c", "d"), duplicates);
    }

    @Test
    public void GivenStringEmptyList_WhenFindDuplicates_ThenReturnEmptyList() {
        //Given
        List<String> list = new ArrayList<>();

        //When
        List<String> duplicates = findDuplicates(list);

        //Then
        assertTrue(duplicates.isEmpty());
    }

    @Test
    public void GivenStringNoDuplicateList_WhenFindDuplicates_ThenReturnEmptyList() {
        //Given
        List<String> list = Arrays.asList("b", "a", "c", "e", "d");

        //When
        List<String> duplicates = findDuplicates(list);

        //Then
        assertTrue(duplicates.isEmpty());
    }

    @Test
    public void GivenIntegerList_WhenFindDuplicates_ThenReturnDuplicatesSuccessfully() {
        //Given
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 4, 4, 3, 6, 5);

        //When
        List<Integer> duplicates = findDuplicates(list);

        //Then
        assertEquals(Arrays.asList(3, 5, 4), duplicates);
    }

    public record Person (String name, String address) {}

    @Test
    public void GivenObjectList_WhenFindDuplicates_ThenReturnDuplicatesSuccessfully() {
        //Given
        List<Person> list = new ArrayList<>();

        list.add(new Person("name 1", "address 1"));
        list.add(new Person("name 2", "address 2"));
        list.add(new Person("name 1", "address 2"));
        list.add(new Person("name 3", "address 3"));
        list.add(new Person("name 1", "address 1"));

        //When
        List<Person> duplicates = findDuplicates(list);

        //Then
        assertEquals(List.of(new Person("name 1", "address 1")), duplicates);
    }
}