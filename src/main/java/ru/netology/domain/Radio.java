package ru.netology.domain;

public class Radio {
    int currentPosition;
    int currentVolume;
    private int maxPosition = 9;
    private int maxVolume = 10;


    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void nextRadioPosition() { // выбор радиостанций вперед
        if (currentPosition < maxPosition) {
            currentPosition++;
        } else {
            currentPosition = 0;
        }

    }

    public void prevRadioPosition() {  // выбор радиостанций назад
        if (currentPosition > 0) {
            currentPosition--;
        } else {
            currentPosition = maxPosition;
        }
    }

    public void setDesiredRadioStation(int desiredRadioStation) {  //желаемая радио-станция
        if (desiredRadioStation > maxPosition) {
            currentPosition = maxPosition;
            return;
        }
        if (desiredRadioStation < 0) {
            currentPosition = 0;
            return;
        }
        this.currentPosition = desiredRadioStation;
    }


    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }

    public void increasingVolume() {    // повышение громкости
        if (currentVolume < maxVolume) {
            currentVolume++;
        } else {
            currentVolume = maxVolume;
        }

    }

    public void loweringVolume() {  // понижение громкости
        if (currentVolume > 0) {
            currentVolume--;
        } else {
            currentVolume = 0;
        }
    }

}
