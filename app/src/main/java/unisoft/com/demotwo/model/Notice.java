package unisoft.com.demotwo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 05-Mar-19.
 */

public class Notice {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("brief")
    @Expose
    private String brief;
    @SerializedName("filesource")
    @Expose
    private String filesource;

    public Notice(String id, String title, String brief, String filesource) {
        this.id = id;
        this.title = title;
        this.brief = brief;
        this.filesource = filesource;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getFilesource() {
        return filesource;
    }

    public void setFilesource(String filesource) {
        this.filesource = filesource;
    }
}