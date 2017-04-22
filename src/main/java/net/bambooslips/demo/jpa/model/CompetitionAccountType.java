package net.bambooslips.demo.jpa.model;

public enum CompetitionAccountType {
    COMPETITION("COMPETITION"),
    ADMIN("ADMIN"),
    EXPERT("EXPERT");

    private final String text;

    /**
     * @param text
     */
    private CompetitionAccountType(final String text) {
        this.text = text;
    }
    private CompetitionAccountType() {
        this.text = "COMPETITION";
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }


    public String toChinese() {
        if (text.equals("COMPETITION"))
            return "参赛登录";
        else if (text.equals("ADMIN"))
            return "管理员登录";
        else if (text.equals("EXPERT"))
            return "专家登录";
        else
            return "其他";
    }
}
