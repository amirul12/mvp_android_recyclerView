package unisoft.com.demotwo.my_interface;

import retrofit2.Call;
import retrofit2.http.GET;
import unisoft.com.demotwo.model.Notice;
import unisoft.com.demotwo.model.NoticeList;

/**
 * Created by user on 05-Mar-19.
 */

public interface GetNoticeDataServer {

    @GET("bins/1bsqcn/")
    Call<NoticeList> getNoticeData();
}
