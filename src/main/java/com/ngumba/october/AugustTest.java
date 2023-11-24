package com.ngumba.october;

import java.util.ArrayList;
import java.util.List;

public class AugustTest {

    public static void main(String[] args) {
        List<String> countriesList = new ArrayList<>();

        countriesList.add("Kenya");
        countriesList.add("Uganda");
        countriesList.add("Tanzania");
        countriesList.add("Rwanda");
        countriesList.add("Burundi");
        countriesList.add("South Sudan");
        countriesList.add("Ethiopia");
        countriesList.add("Somalia");


        System.out.println("The size of the list is: " + countriesList.size());

        //countriesList.forEach(System.out::println);

        countriesList.stream().filter(country -> country.startsWith("K")).forEach(System.out::println);
        countriesList.stream().map(String::toUpperCase).forEach(System.out::println);
        countriesList.stream().filter(country -> country.startsWith("K")).map(String::toUpperCase).forEach(System.out::println);

    }
}


