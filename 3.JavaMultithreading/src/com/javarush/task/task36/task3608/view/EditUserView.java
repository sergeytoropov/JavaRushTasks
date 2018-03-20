package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/**
 * @author sergeytoropov
 * @since 19.03.18
 */
public class EditUserView implements View {
    private Controller controller;

    @Override
    public void refresh(ModelData modelData) {
        StringBuilder sb = new StringBuilder();
        sb.append("User to be edited:").append("\n");
        sb.append("\t").append(modelData.getActiveUser()).append("\n");
        sb.append("===================================================");
        System.out.println(sb.toString());
    }

    public void fireEventUserDeleted(long id) {
        controller.onUserDelete(id);
    }

    public void fireEventUserChanged(String name, long id, int level) {
        controller.onUserChange(name, id, level);
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
