package unisoft.com.demotwo.view;

import java.util.ArrayList;

import unisoft.com.demotwo.MainContract;
import unisoft.com.demotwo.model.Notice;

/**
 * Created by user on 05-Mar-19.
 */

public class MainPresenterImplementation implements MainContract.presenter, MainContract.GetNoticeIntractor.OnfinishedListener {


    private MainContract.mainView mainView;
    private MainContract.GetNoticeIntractor getNoticeIntractor;

    public MainPresenterImplementation(MainContract.mainView mainView, MainContract.GetNoticeIntractor getNoticeIntractor) {
        this.mainView = mainView;
        this.getNoticeIntractor = getNoticeIntractor;
    }

    @Override
    public void onDestroy() {

        mainView = null;

    }

    @Override
    public void onRefreshButtonClick() {

        if (mainView != null) {
            mainView.showProgress();
        }
        getNoticeIntractor.getNoticeArrayList(this);
    }

    @Override
    public void requestDataFromServer() {
        getNoticeIntractor.getNoticeArrayList(this);

    }

    @Override
    public void onFinished(ArrayList<Notice> noticeArrayList) {
        if(mainView != null){
            mainView.setDataToRecyclerView(noticeArrayList);
            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable throwable) {

        if(mainView != null){
            mainView.onResponseFailure(throwable);
            mainView.hideProgress();
        }
    }
}
