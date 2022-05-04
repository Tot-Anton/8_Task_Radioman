package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Radio {
    private int currentPosition;
    private int currentVolume;
    private int minPosition;
    private int maxPosition = 10;
    private int minVolume = 0;
    private int maxVolume = 100;

    public Radio(int maxPosition) {
        this.maxPosition = maxPosition;
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

    public void setCurrentRadioStationNumber() {
        //Номер текущей радиостанции изменяется в пределах от 0 до количества радиостанций
        // не включительно (т.е. если станций 10, то номер последней - 9).
        if (currentPosition > minPosition) {
            currentPosition = currentPosition - 1;
        } else {
            currentPosition = maxPosition - 1;
        }
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
