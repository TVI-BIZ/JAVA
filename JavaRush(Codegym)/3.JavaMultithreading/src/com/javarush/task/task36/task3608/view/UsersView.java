package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

public class UsersView implements View {
    private Controller controller;
    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override

    public void refresh(ModelData modelData) {


        if(modelData.isDisplayDeletedUserList() == false){
            System.out.println("All users:");
            for(User elem: modelData.getUsers()){
                System.out.println("\t"+elem);
            }
        } else {
            System.out.println("All deleted users:");
            for(User elem: modelData.getUsers()){
                System.out.println("\t"+elem);
            }
        }



        System.out.println("===================================================");
    }



    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() {
                controller.onShowAllDeletedUsers();
    }

    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }



}
