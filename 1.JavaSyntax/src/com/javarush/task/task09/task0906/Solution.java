package com.javarush.task.task09.task0906;

/* 
Логирование стек трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        String className = "";
        String methodName = "";
        try {
            int value = 10 / 0;
        } catch (Throwable e) {
            if (e.getStackTrace().length > 1) {
                className = e.getStackTrace()[1].getClassName();
                methodName = e.getStackTrace()[1].getMethodName();
            }
        }
        System.out.println(className + ": " + methodName + ": " + s);
    }
}
