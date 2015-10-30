import info.tiefenauer.tutorials.spock.Radio
import info.tiefenauer.tutorials.spock.RadioStation
import info.tiefenauer.tutorials.spock.RadioUnpluggedException
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by danieltiefenauer on 30.10.2015.
 */
class RadioSpecification extends Specification {

    def radio;

    /*
    Simple spock test
     */
    def "creating a new radio"(){
        when:
            radio = new Radio();
        then:
            radio.pluggedIn;
    }

    /*
    Spock test with Setup
     */
    def "turning on the radio"() {
        setup:
            radio = new Radio();
        when:
            radio.switchOnOff();
        then:
            radio.isTurnedOn();
    }

    /*
    Another Spock test with Setup
     */
    def "turning the radio on and off again"(){
        setup:
            radio = new Radio();
        when:
            radio.switchOnOff();
            radio.switchOnOff();
        then:
            !radio.isTurnedOn();
    }

    /*
    Exception Conditions
     */
    def "turning on the radio when it's not plugged in"(){
        setup:
            radio = new Radio();
            radio.pluggedIn = false;
        when:
            radio.switchOnOff();
        then:
            thrown(RadioUnpluggedException);
            !radio.turnedOn
    }

    /*
    Unrolling a sequence of values
     */
    @Unroll("selecting station '#stationName' shows as '#displayName' in display")
    def "tuning to different stations"(){
        setup:
            radio = new Radio();
        when:
            radio.selectStation(stationName);
            radio.addPreset(Mock(RadioStation));
        then:
            radio.getDisplay() == displayName;
        where:
            stationName << ["Dani F.M.", "Radio Paradise", "A really long station name which will definitely not fit into the display"];
    /*
    Working with mocks
     */
    def "selecting mocked station"(){
        setup:
            radio = new Radio()
            def station = Mock(RadioStation)
            station.frequency >> 103.8
            station.name >> "Dani F.M."
        when:
            radio.selectStation(station)
        then:
            radio.currentFrequency == 103.8
            radio.displayFrequency == "103.80 FM"
            radio.displayName == "Dani F.M."
    }

    /*
    Working with mocks: extended example
     */
    @Unroll("Selecting station '#stationName' with frequency '#frequency'")
    def "selecting mocked stations subsequently"(){
        setup:
            radio = new Radio()
            def station = Mock(RadioStation)
            station.frequency >> frequency
            station.name >> stationName
        when:
            radio.selectStation(station)
        then:
            radio.currentFrequency == frequency
            radio.displayName == displayName
        where:
            frequency << [103.8, 99.9, 94.5]
            stationName << ["Dani F.M.", "Radio Paradise", "A really long station name which will definitely not fit into the display"]
            displayName << ["Dani F.M.", "Radio P...",     "A reall..."]
    }

}
