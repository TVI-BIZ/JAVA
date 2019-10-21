package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;


import javax.jws.soap.SOAPBinding;
import java.util.*;

public class FakeModel implements Model {
    private UserService userService = new UserServiceImpl();
    @Override
    public ModelData getModelData() {

        return modelData ;
    }

    @Override
    public void loadUsers()  {
        User user1 = new User("A",1,1);
        User user2 = new User("B",2,1);
        ArrayList<User> usersList2 = new ArrayList<User>();

        usersList2.add(user1);
        usersList2.add(user2);

        modelData.setUsers(usersList2);

    }

    @Override
    public void loadDeletedUsers() throws UnsupportedOperationException{
         List<User> users = userService.getAllDeletedUsers();
         throw new UnsupportedOperationException();

    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }

    private ModelData modelData = new ModelData();
}
