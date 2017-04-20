package net.bambooslips.demo.jpa.model;

public enum PostType {
    MAIN("MAIN"),
    NATIONAL("NATIONAL"),
    VIDEO("VIDEO"),
    PROJECT("PROJECT"),
    OTHER("OTHER"),
    REPORT("REPORT");

    private final String text;

    /**
     * @param text
     */
    private PostType(final String text) {
        this.text = text;
    }
    private PostType() {
        this.text = "MAIN";
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }


    public String toChinese() {
        if (text.equals("MAIN"))
            return "军转民分区";
        else if (text.equals("NATIONAL"))
            return "全国大赛";
        else if (text.equals("VIDEO"))
            return "视频";
        else if (text.equals("PROJECT"))
            return "项目";
        else if (text.equals("REPORT"))
            return "报告";
        else
            return "其他";
    }
}
