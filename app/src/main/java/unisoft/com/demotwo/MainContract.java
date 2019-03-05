package unisoft.com.demotwo;

import java.util.ArrayList;

import unisoft.com.demotwo.model.Notice;

/**
 * Created by user on 05-Mar-19.
 */

public interface MainContract {

    /*Call when user intract with the view and other when view destroy*/

    interface presenter{
        void onDestroy();
        void onRefreshButtonClick();
        void requestDataFromServer();
    }

    /*showprogress() and hideprogressbar() when data getting to recyclerviw and hide from recyclerview*/


    interface  mainView{

        void showProgress();
        void hideProgress();

        void setDataToRecyclerView(ArrayList<Notice> noticeArrayList);
        void onResponseFailure(Throwable throwable);
    }

    interface GetNoticeIntractor{

        interface OnfinishedListener{
            void onFinished(ArrayList<Notice> noticeArrayList);
            void onFailure(Throwable throwable);
        }

        void getNoticeArrayList(OnfinishedListener onfinishedListener);
    }
}
