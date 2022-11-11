package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
public class JsonPojo {
    private Integer userId;
    private String title;
    private Boolean complated;

    public JsonPojo(Integer userId, String title, Boolean complated) {
        this.userId = userId;
        this.title = title;
        this.complated = complated;
    }

    public JsonPojo() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getComplated() {
        return complated;
    }

    public void setComplated(Boolean complated) {
        this.complated = complated;
    }

    @Override
    public String toString() {
        return "JsonPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", complated=" + complated +
                '}';
    }
}
