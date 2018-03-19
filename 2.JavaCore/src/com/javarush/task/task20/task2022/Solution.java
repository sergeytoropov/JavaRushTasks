package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) {
        try {
            Solution solution = new Solution("2.JavaCore/src/com/javarush/task/task20/task2022/task2022.txt");
            solution.writeObject("My name is Sergey.");

            FileOutputStream fos = new FileOutputStream("2.JavaCore/src/com/javarush/task/task20/task2022/task2022.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(solution);
            oos.close();
            fos.close();

            FileInputStream fis = new FileInputStream("2.JavaCore/src/com/javarush/task/task20/task2022/task2022.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object object = ois.readObject();
            ois.close();
            fis.close();

            Solution recoverySolution = (Solution) object;
            recoverySolution.writeObject("My favorite project is java.");

            recoverySolution.close();
            solution.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (IOException ioe) {
            System.out.println(ioe);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
