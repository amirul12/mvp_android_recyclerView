package unisoft.com.demotwo.view;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

import unisoft.com.demotwo.MainContract;
import unisoft.com.demotwo.adapter.NoticeAdapter;
import unisoft.com.demotwo.R;
import unisoft.com.demotwo.model.Notice;

public class MainActivity extends AppCompatActivity implements MainContract.mainView {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private MainContract.presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initProgressBar();

        presenter = new MainPresenterImplementation(this, new GetNoticeIntracImplement());
        presenter.requestDataFromServer();

    }

    private void initProgressBar() {
        progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);

        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setGravity(Gravity.CENTER);
       relativeLayout.setBackgroundColor(Color.TRANSPARENT);
        relativeLayout.addView(progressBar);

        RelativeLayout.LayoutParams params = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
       // progressBar.setVisibility(View.INVISIBLE);


        this.addContentView(relativeLayout, params);
        progressBar.setVisibility(View.VISIBLE);
    }

    private void initView() {

        recyclerView = (RecyclerView) findViewById(R.id.recycNotice);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void showProgress() {

        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {

        progressBar.setVisibility(View.INVISIBLE);
    }


    private RecyclerItemClickListener itemClickListener = new RecyclerItemClickListener() {
        @Override
        public void onItemClick(Notice notice) {
            Toast.makeText(MainActivity.this,
                    "List title:  " + notice.getTitle(),
                    Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public void setDataToRecyclerView(ArrayList<Notice> noticeArrayList) {

        NoticeAdapter noticeAdapter = new NoticeAdapter(noticeArrayList,itemClickListener );
        recyclerView.setAdapter(noticeAdapter);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(MainActivity.this,
                "Something went wrong...Error message: " + throwable.getMessage(),
                Toast.LENGTH_LONG).show();

    }
}
