package com.javarush.task.task21.task2109;

import java.util.Random;

/*
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            A a = (A) o;

            if (i != a.i) return false;
            return j == a.j;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            Random random = new Random();
            return new A(random.nextInt() % 10, random.nextInt() % 100);
        }

        @Override
        public String toString() {
            return "A{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof B)) return false;
            if (!super.equals(o)) return false;

            B b = (B) o;

            return name != null ? name.equals(b.name) : b.name == null;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "B{" +
                    "i=" + getI() +
                    ", j=" + getJ() +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            Random random = new Random();
            return new C(random.nextInt() % 100, random.nextInt() % 1000, "C_" + getI() + "_" + getJ() + "_" + getName());
        }

        @Override
        public String toString() {
            return "C{" +
                    "i=" + getI() +
                    ", j=" + getJ() +
                    ", name='" + getName() + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
    }
}
