package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void countCitiesTest() {
        list = MockCityList();
        int listsize = list.countCities();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listsize + 1);
    }

    @Test
    void testHasCity() {
        CustomList cityList = MockCityList();
        City city = new City("Winnipeg", "Manitoba");
        assertEquals(false, cityList.hasCity(city));

        cityList.addCity(city);
        assertEquals(true, cityList.hasCity(city));
    }

    @Test
    void testDelete() {
        CustomList cityList = MockCityList();
        City city = new City("Winnipeg", "Manitoba");
        cityList.addCity(city);
        assertEquals(1,cityList.countCities());
        cityList.delete(city);
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testDeleteException() {
        CustomList cityList = MockCityList();
        City city = new City("Winnipeg", "Manitoba");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

}
