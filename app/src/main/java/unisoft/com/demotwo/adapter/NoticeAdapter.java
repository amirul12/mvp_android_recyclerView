package unisoft.com.demotwo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import unisoft.com.demotwo.R;
import unisoft.com.demotwo.model.Notice;
import unisoft.com.demotwo.view.RecyclerItemClickListener;

/**
 * Created by user on 05-Mar-19.
 */

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder> {

    View rootView;
    private ArrayList<Notice> arrayList = new ArrayList<>();
    private RecyclerItemClickListener itemClickListener;


    public NoticeAdapter(ArrayList<Notice> arrayList, RecyclerItemClickListener itemClickListener) {
        this.arrayList = arrayList;
        this.itemClickListener = itemClickListener;
    }

    @Override
    public NoticeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_notice_row, parent, false);

        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(NoticeAdapter.ViewHolder holder, int position) {

        final Notice notice = arrayList.get(position);

        holder.id.setText(notice.getId());
        holder.title.setText(notice.getTitle());
        holder.brief.setText(notice.getBrief());
        holder.fileUrl.setText(notice.getFilesource());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(notice);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView id;
        private TextView title;
        private TextView brief;
        private TextView fileUrl;

        public ViewHolder(View itemView) {
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.tvId);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            brief = (TextView) itemView.findViewById(R.id.tvBrief);
            fileUrl = (TextView) itemView.findViewById(R.id.tvFileUrl);
        }
    }
}
