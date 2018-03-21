package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {

        IntFunction<Person> createPerson = pos -> {
            String name = args[pos];
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date birthDay;
            try {
                birthDay = sdf.parse(args[pos + 2]);
            } catch (ParseException pe) {
                throw new IllegalArgumentException(pe);
            }
            String sex = args[pos + 1];
            if ("м".equals(sex)) {
                return Person.createMale(name, birthDay);
            } else if ("ж".equals(sex)) {
                return Person.createFemale(name, birthDay);
            } else {
                throw new IllegalArgumentException();
            }
        };

        switch (args[0]) {
            case "-c":
                IntStream
                        .iterate(1, index -> index + 3)
                        .limit((args.length - 1) / 3)
                        .mapToObj(createPerson)
                        .forEach(person -> {
                            synchronized (allPeople) {
                                allPeople.add(person);
                                System.out.println(allPeople.size() - 1);
                            }
                        });
                break;

            case "-u":
                IntStream
                        .iterate(1, index -> index + 4)
                        .limit((args.length - 1) / 4)
                        .forEach(index -> {
                            int id = Integer.valueOf(args[index]);
                            Person newPerson = createPerson.apply(index + 1);
                            synchronized (allPeople) {
                                Person updatePerson = allPeople.get(id);
                                updatePerson.setName(newPerson.getName());
                                updatePerson.setSex(newPerson.getSex());
                                updatePerson.setBirthDay(newPerson.getBirthDay());
                            }
                        });
                break;

            case "-d":
                IntStream
                        .range(1, args.length)
                        .mapToObj(index -> Integer.valueOf(args[index]))
                        .forEach(id -> {
                            synchronized (allPeople) {
                                Person updatePerson = allPeople.get(id);
                                updatePerson.setName(null);
                                updatePerson.setSex(null);
                                updatePerson.setBirthDay(null);
                            }
                        });
                break;

            case "-i":
                IntStream
                        .range(1, args.length)
                        .mapToObj(index -> Integer.valueOf(args[index]))
                        .forEach(id -> {
                            synchronized (allPeople) {
                                System.out.println(allPeople.get(id));
                            }
                        });
                break;
        }
    }
}
