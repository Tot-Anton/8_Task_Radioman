package ru.netology.domain;

public class Radio {
    private int currentPosition;
    private int currentVolume;
    private int minPosition;
    private int maxPosition = 9;
    private int minVolume = 0;
    private int maxVolume = 100;


    public Radio(int maxPosition) {
        this.maxPosition = maxPosition;
    }


    public int getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(int maxVolume) {
        this.maxVolume = maxVolume;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public void setMinVolume(int minVolume) {
        this.minVolume = minVolume;
    }

    public int getMinPosition() {
        return minPosition;
    }

    public void setMinPosition(int minPosition) {
        this.minPosition = minPosition;
    }

    public int getMaxPosition() {
        return maxPosition;
    }

    public void setMaxPosition(int maxPosition) {
        this.maxPosition = maxPosition;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        if (currentPosition < minPosition) {
            return;
        }
        if (currentPosition > maxPosition) {
            return;
        }
        this.currentPosition = currentPosition;
    }

    public void nextRadioPosition() { // выбор радиостанций вперед
        if (currentPosition < maxPosition) {
            currentPosition++;
        } else {
            currentPosition = minPosition;
        }

    }

    public void prevRadioPosition() {  // выбор радиостанций назад
        if (currentPosition > minPosition) {
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
        if (desiredRadioStation < minPosition) {
            currentPosition = minPosition;
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
        if (currentVolume > minVolume) {
            currentVolume--;
        } else {
            currentVolume = minVolume;
        }
    }

}
