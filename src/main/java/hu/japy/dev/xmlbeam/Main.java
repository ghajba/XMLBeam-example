package hu.japy.dev.xmlbeam;

import java.io.IOException;

import org.xmlbeam.XBProjector;

/**
 * This is the main class, holding most of the logic.
 *
 * @author GHajba
 *
 */
public class Main {

    public static void main(String[] args) {
        try {
            final MixingOverridingToString mixin = new MixingOverridingToString() {
                private TodoProjection me;

                @Override
                public String toString() {
                    return "I am a ToDo in with a mixin toString method: " + this.me.getBody();
                };
            };
            final XBProjector xbProjector = new XBProjector();
            TodoProjection todo = xbProjector.io().url("http://www.w3schools.com/xml/note.xml").read(TodoProjection.class);
            System.out.println("The body of the projection: " + todo.getBody());
            System.out.println(todo);
            xbProjector.mixins().addProjectionMixin(TodoProjection.class, mixin);
            todo = xbProjector.io().url("http://www.w3schools.com/xml/note.xml").read(TodoProjection.class);
            System.out.println(todo);
        } catch (final IOException e) {
            e.printStackTrace();
        }

    }

}
