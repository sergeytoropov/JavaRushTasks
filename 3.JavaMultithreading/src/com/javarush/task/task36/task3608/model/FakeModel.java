package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sergeytoropov
 * @since 07.03.18
 */
public class FakeModel implements Model {
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> list = new ArrayList<>();
        list.add(new User("Ivanov A", 1l, 1));
        list.add(new User("Petrov B", 2l, 2));
        list.add(new User("Petrov C", 3l, 1));
        list.add(new User("Sidorov D", 4l, 2));
        list.add(new User("E", 5l, 1));
        modelData.setUsers(list);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }
}
