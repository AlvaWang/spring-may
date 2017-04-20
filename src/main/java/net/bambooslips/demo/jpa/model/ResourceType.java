package net.bambooslips.demo.jpa.model;

/**
 * Created by Eureka on 2016/5/16.
 */
public enum ResourceType {
    PICTURE("PICTURE"),
    AVATAR("AVATAR");

    private final String text;

    /**
     * @param text
     */
    private ResourceType(final String text) {
        this.text = text;
    }


    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
