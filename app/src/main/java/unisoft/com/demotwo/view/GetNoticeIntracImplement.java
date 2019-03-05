package unisoft.com.demotwo.view;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import unisoft.com.demotwo.MainContract;
import unisoft.com.demotwo.model.Notice;
import unisoft.com.demotwo.model.NoticeList;
import unisoft.com.demotwo.my_interface.GetNoticeDataServer;
import unisoft.com.demotwo.networking.RetrofitInstance;

/**
 * Created by user on 05-Mar-19.
 */

public class GetNoticeIntracImplement implements MainContract.GetNoticeIntractor {

    @Override
    public void getNoticeArrayList(final OnfinishedListener onfinishedListener) {

        GetNoticeDataServer noticeDataServer = RetrofitInstance.getRetrofitInstance().create(GetNoticeDataServer.class);

        Call<NoticeList> call = noticeDataServer.getNoticeData();
        Log.wtf("URL Called", call.request().url() + "");


        call.enqueue(new Callback<NoticeList>() {
            @Override
            public void onResponse(Call<NoticeList> call, Response<NoticeList> response) {

                Log.d("log",response.toString());

                onfinishedListener.onFinished(response.body().getNoticeList());

            }

            @Override
            public void onFailure(Call<NoticeList> call, Throwable t) {

                onfinishedListener.onFailure(t);

            }
        });



    }
}
