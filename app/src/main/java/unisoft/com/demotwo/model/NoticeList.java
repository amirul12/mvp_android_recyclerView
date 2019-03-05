package unisoft.com.demotwo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 05-Mar-19.
 */

public class NoticeList {

    @SerializedName("notice_list")
    @Expose
    private ArrayList<Notice> noticeList = null;

    public ArrayList<Notice> getNoticeList() {
        return noticeList;
    }

    public void setNoticeList(ArrayList<Notice> noticeList) {
        this.noticeList = noticeList;
    }

}
