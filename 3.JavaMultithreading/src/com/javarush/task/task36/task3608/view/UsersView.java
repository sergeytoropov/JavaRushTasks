package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/**
 * @author sergeytoropov
 * @since 07.03.18
 */
public class UsersView implements View {
    private Controller controller;

    @Override
    public void refresh(ModelData modelData) {
        StringBuilder sb = new StringBuilder();
        sb.append("All users:").append("\n");
        modelData.getUsers().stream().forEach(user -> {
            sb.append("\t").append(user).append("\n");
        });
        sb.append("===================================================");
        System.out.println(sb.toString());
    }

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
