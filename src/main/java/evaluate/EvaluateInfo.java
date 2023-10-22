package evaluate;

import java.sql.Date;
public class EvaluateInfo {
    private String feedbackID;
    private String evaluatorID;
    private String evaluatedID;
    private Date feedbackTime;
    private String feedbackType;
    private String content;

    private String textbookID;
    private String userID;
    private String textbookName;
    private String author;
    private String price;

    public String getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(String feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getEvaluatorID() {
        return evaluatorID;
    }

    public void setEvaluatorID(String evaluatorID) {
        this.evaluatorID = evaluatorID;
    }

    public String getEvaluatedID() {
        return evaluatedID;
    }

    public void setEvaluatedID(String evaluatedID) {
        this.evaluatedID = evaluatedID;
    }

    public Date getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(Date feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    public String getFeedbackType() {
        return feedbackType;
    }

    public void setFeedbackType(String feedbackType) {
        this.feedbackType = feedbackType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTextbookID() {
        return textbookID;
    }

    public void setTextbookID(String textbookID) {
        this.textbookID = textbookID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getTextbookName() {
        return textbookName;
    }

    public void setTextbookName(String textbookName) {
        this.textbookName = textbookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
