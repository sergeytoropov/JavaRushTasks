package com.javarush.task.task36.task3608.model;

/**
 * @author sergeytoropov
 * @since 07.03.18
 */
public interface Model {
    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();
    void loadUserById(long userId);
    void deleteUserById(long id);
    void changeUserData(String name, long id, int level);
}
