package dorkbox.systemTray.jna.linux;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import dorkbox.util.Keep;

@Keep
public
class GtkStyle extends Structure {
    /*
     * There are several 'directives' to change the attributes of a widget.
     *  fg - Sets the foreground color of a widget.
     *  bg - Sets the background color of a widget.
     *  text - Sets the foreground color for widgets that have editable text.
     *  base - Sets the background color for widgets that have editable text.
     *  bg_pixmap - Sets the background of a widget to a tiled pixmap.
     *  font_name - Sets the font to be used with the given widget.
     *  xthickness - Sets the left and right border width. This is not what you might think; it sets the borders of children(?)
     *  ythickness - similar to above but for the top and bottom.
     *
     * There are several states a widget can be in, and you can set different colors, pixmaps and fonts for each state. These states are:
     *  NORMAL - The normal state of a widget. Ie the mouse is not over it, and it is not being pressed, etc.
     *  PRELIGHT - When the mouse is over top of the widget, colors defined using this state will be in effect.
     *  ACTIVE - When the widget is pressed or clicked it will be active, and the attributes assigned by this tag will be in effect.
     *  INSENSITIVE - This is the state when a widget is 'greyed out'. It is not active, and cannot be clicked on.
     *  SELECTED - When an object is selected, it takes these attributes.
     */

    public static
    class ByReference extends GtkStyle implements Structure.ByReference {}

    public
    class ByValue extends GtkStyle implements Structure.ByValue {}

    // only list public fields

    /** fg: foreground for drawing GtkLabel */
    public GdkColor fg[] = new GdkColor[5];

    /** bg: the usual background color, gray by default */
    public GdkColor bg[] = new GdkColor[5];
    public GdkColor light[] = new GdkColor[5];
    public GdkColor dark[] = new GdkColor[5];
    public GdkColor mid[] = new GdkColor[5];

    /**
     * text: text for entries and text widgets (although in GTK 1.2 sometimes fg gets used, this is more or less a bug and fixed in GTK 2.0).
     */
    public GdkColor text[] = new GdkColor[5];

    /** base: background when using text, colored white in the default theme. */
    public GdkColor base[] = new GdkColor[5];
    public GdkColor text_aa[] = new GdkColor[5]; /* Halfway between text/base */
    public GdkColor black;
    public GdkColor white;
    public Pointer /*PangoFontDescription*/ font_desc;
    public int xthickness;
    public int ythickness;
    public Pointer /*cairo_pattern_t*/  background[] = new Pointer[5];

    @Override
    protected
    List<String> getFieldOrder() {
        return Arrays.asList("fg",
                             "bg",
                             "light",
                             "dark",
                             "mid",
                             "text",
                             "base",
                             "text_aa",
                             "black",
                             "white",
                             "font_desc",
                             "xthickness",
                             "ythickness",
                             "background");
    }
}