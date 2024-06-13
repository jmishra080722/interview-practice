package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MapExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jay", "Ashish", "Madhu", "Atharv");
        //Create User object for all names except Ashish
        names.stream()
                .filter(name -> !Objects.equals(name, "Ashish"))
                .map(name -> new User(name))
                .forEach(System.out::println);

    }

    static class User{
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
