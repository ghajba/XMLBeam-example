package hu.japy.dev.xmlbeam;

import org.xmlbeam.annotation.XBOverride;
import org.xmlbeam.annotation.XBRead;

/**
 * A simple projection for a todo list.
 *
 * @author GHajba
 *
 */
public interface TodoProjection extends MixingOverridingToString {
    @XBRead("/note/from")
    String getFrom();

    @XBRead("/note/to")
    String getTo();

    @XBRead("/note/heading")
    String getHeading();

    @XBRead("/note/body")
    String getBody();

    @XBOverride("toString")
    default String toCustomString() {
        return "I am a ToDo in with a default toString method: " + this.getBody();
    }
}
