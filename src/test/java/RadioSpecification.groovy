import info.tiefenauer.tutorials.spock.Radio
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

}
