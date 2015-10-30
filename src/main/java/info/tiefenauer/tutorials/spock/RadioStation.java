package info.tiefenauer.tutorials.spock;

/**
 * Created by danieltiefenauer on 30.10.2015.
 */
public class RadioStation {

    private String _name;
    private double _frequency;

    public RadioStation(String name, String frequency) {
        setName(name);
        setFrequency(Double.valueOf(frequency));
    }
    public RadioStation(){

    }

    public double getFrequency() {
        return _frequency;
    }

    public void setFrequency(double frequency) {
        _frequency = frequency;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }
}
