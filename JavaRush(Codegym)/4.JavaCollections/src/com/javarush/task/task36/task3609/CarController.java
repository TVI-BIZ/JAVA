package com.javarush.task.task36.task3609;

public class CarController {
    private CarModel model;
    private SpeedometerView view;

    public CarController(CarModel model, SpeedometerView view) {
        this.model = model;
        this.view = view;
    }


    public String getCarBrand() {
        return model.getBrand();
    }

    public String getCarModel() {
        return model.getModel();
    }

//    public void setCarSpeed(int speed) {
//        model.setSpeed(speed);
//    }
//        public void setCarSpeed(int speed) {
//        model.setSpeedUp(speed);
//    }

    public int getCarSpeed() {
        return model.getSpeed();
    }

    public int getCarMaxSpeed() {
        return model.getMaxSpeed();
    }

    public void updateView() {
        view.printCarDetails(getCarBrand(), getCarModel(), getCarSpeed());
    }

//    public void increaseSpeed(int seconds) {
//        int getCarSpeed = getCarSpeed();
//        if (getCarSpeed < getCarMaxSpeed()) {
//            getCarSpeed += (3.5 * seconds);
//        }
//        if (getCarSpeed > getCarMaxSpeed()) {
//            getCarSpeed = getCarMaxSpeed();
//        }
//    }
//    public void decreaseSpeed(int seconds) {
//        int getCarSpeed = getCarSpeed();
//        if (getCarSpeed > 0) {
//            getCarSpeed -= (12 * seconds);
//        }
//        if (getCarSpeed < 0) {
//            getCarSpeed = 0;
//        }

    //}
    public void increaseSpeed(int seconds) {
        model.setSpeedUp(seconds);
    }
    public void decreaseSpeed(int seconds) {
        model.setSpeedDown(seconds);
    }

}