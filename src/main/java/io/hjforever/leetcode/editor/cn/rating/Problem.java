package io.hjforever.leetcode.editor.cn.rating;

public class Problem {

    private double Rating;
    private Integer ID;
    private String Title;
    private String TitleSlug;
    private String ContestSlug;
    private String ProblemIndex;
    private String ContestID;

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        Rating = rating;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTitleSlug() {
        return TitleSlug;
    }

    public void setTitleSlug(String titleSlug) {
        TitleSlug = titleSlug;
    }

    public String getContestSlug() {
        return ContestSlug;
    }

    public void setContestSlug(String contestSlug) {
        ContestSlug = contestSlug;
    }

    public String getProblemIndex() {
        return ProblemIndex;
    }

    public void setProblemIndex(String problemIndex) {
        ProblemIndex = problemIndex;
    }

    public String getContestID() {
        return ContestID;
    }

    public void setContestID(String contestID) {
        ContestID = contestID;
    }
}
