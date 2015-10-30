package info.tiefenauer.tutorials.spock;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danieltiefenauer on 30.10.2015.
 */
public class Radio {

    private boolean pluggedIn;
    private boolean turnedOn;
    private String currentStation;
    private double currentFrequency;
    private List<RadioStation> presets = new ArrayList<>();

    public Radio() {
        pluggedIn = true;
    }

    public void switchOnOff() throws RadioUnpluggedException {
        if (!pluggedIn)
            throw new RadioUnpluggedException();
        turnedOn = !turnedOn;
    }

    public boolean isTurnedOn() {
        return turnedOn;
    }

    public void selectStation(RadioStation station){
        currentStation = station.getName();
        tuneTo(station.getFrequency());
    }

    public String getDisplayName() {
        if (currentStation == null)
            return "";
        if (currentStation.length() > 10)
            return currentStation.substring(0,7) + "...";
        return currentStation;
    }

    public String getDisplayFrequency(){
        return new DecimalFormat("#.00").format(currentFrequency) + " FM";
    }

    public void tuneTo(double frequency){
        currentFrequency = frequency;
    }

    public double getCurrentFrequency() {
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
