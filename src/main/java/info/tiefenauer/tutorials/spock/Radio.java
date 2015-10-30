package info.tiefenauer.tutorials.spock;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danieltiefenauer on 30.10.2015.
 */
public class Radio {

    private String stationName;
    private boolean turnedOn;
    private String currentStation;
    private String currentFrequency;
    private List<RadioStation> presets = new ArrayList<>();
    private boolean pluggedIn;

    public Radio() {
        pluggedIn = true;
    }

    public void switchOnOff(){
        turnedOn = !turnedOn;
    }

    public boolean isTurnedOn() {
        return turnedOn;
    }

    public void selectStation(String stationName) {
        currentStation = stationName;
    }

    public String getDisplay() {
        return getShortName(currentStation);
    }

    private String getShortName(String currentStation) {
        if (currentStation == null)
            return "";
        if (currentStation.length() > 10)
            return currentStation.substring(0,7) + "...";
        return currentStation;
    }

    public void tuneTo(double frequency) {
        currentFrequency = new DecimalFormat("#.00").format(frequency) + " FM";
    }

    public String getCurrentFrequency() {
        return currentFrequency;
    }

    public void addPreset(RadioStation station) {
        presets.add(station);
    }

    public boolean isPluggedIn() {
        return pluggedIn;
    }

    public void setPluggedIn(boolean pluggedIn) {
        this.pluggedIn = pluggedIn;
    }
}
