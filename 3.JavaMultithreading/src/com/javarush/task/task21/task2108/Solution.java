package com.javarush.task.task21.task2108;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
Клонирование растений
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = (Tree) tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Plant)) return false;

            Plant plant = (Plant) o;

            return name != null ? name.equals(plant.name) : plant.name == null;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "Plant{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static class Tree extends Plant implements Cloneable {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        public boolean equals(Object o) {
            if (!super.equals(o)) return false;

            if (this == o) return true;
            if (!(o instanceof Tree)) return false;

            Tree tree = (Tree) o;
            // Probably incorrect - comparing Object[] arrays with Arrays.equals
            return Arrays.equals(branches, tree.branches);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(branches);
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            String[] dublicateBrances = Arrays.stream(branches)
                    .map(branch -> String.valueOf(branch))
                    .collect(Collectors.toList())
                    .toArray(new String[branches.length]);

            return new Tree(String.valueOf(getName()), dublicateBrances);
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "name='" + getName() + '\'' +
                    ", branches=" + Arrays.toString(branches) +
                    '}';
        }
    }
}
