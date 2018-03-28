package com.javarush.task.task30.task3008;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author sergeytoropov
 * @since 28.03.18
 */
public class Server {
    private static class Handle extends Thread {
        private Socket socket;

        public Handle(Socket socket) {
            this.socket = socket;
        }
    }

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Введите имя порта: ");
        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
            ConsoleHelper.writeMessage("Сервер запущен.");
            while (true) {
                new Handle(serverSocket.accept()).start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("Фатальная ошибка. Сервер остановлен.");
        }
    }
}
