package com.wangly.adaptertype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class RankMsgeAdapter extends BaseAdapter {
    public static final int TYPE_COUNT = 2;
    public static final int TYPE_NOMAL = 0; //没有点赞
    public static final int TYPE_SUPPORT = 1;  //点赞
    private Context mContext;
    private ArrayList<RankDeial> mRankDeials;

    public RankMsgeAdapter(Context context, ArrayList<RankDeial> data) {
        this.mContext = context;
        this.mRankDeials = data;
    }

    @Override
    public int getCount() {
        if (null != mRankDeials && mRankDeials.size() > 0) {
            return mRankDeials.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return mRankDeials.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static int getTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        if (0 == mRankDeials.get(position).getType()) { //正常 Item
            return TYPE_NOMAL;
        } else if (1 == mRankDeials.get(position).getType()) { //点赞的Item
            return TYPE_SUPPORT;
        } else {
            return 100;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NomalHolder nomalHolder = null;
        SupportHoldler supportHoldler = null;

        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case TYPE_NOMAL:
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_rank_item, null);
                    nomalHolder = new NomalHolder(convertView);
                    convertView.setTag(nomalHolder);
                    break;
                case TYPE_SUPPORT:
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_rank_support_item, null);
                    supportHoldler = new SupportHoldler(convertView);
                    convertView.setTag(supportHoldler);
                    break;
            }

        } else {
            switch (type) {
                case TYPE_NOMAL:
                    nomalHolder = (NomalHolder) convertView.getTag();
                    break;
                case TYPE_SUPPORT:
                    supportHoldler = (SupportHoldler) convertView.getTag();
                    break;
            }
        }

        //TODO: 设置相关的数据JavaBean
        switch (type) {
            case TYPE_NOMAL:
                nomalHolder.tv_time.setText("212121");
                nomalHolder.tv_level.setText("1");
                nomalHolder.tv_step.setText("11111");
                break;

            case TYPE_SUPPORT:
                    Picasso.with(mContext).load("url")
                        .placeholder(R.drawable.rectangle_shpe)
                        .error(R.drawable.rectangle_shpe)
                        .into(supportHoldler.iv_head);

                supportHoldler.tv_support.setText("");
                break;
        }

        return convertView;
    }


    //-----ViewHodler

    class NomalHolder {
        TextView tv_time;
        TextView tv_level;
        TextView tv_step;

        public NomalHolder(View view) {
            tv_time = (TextView) view.findViewById(R.id.tv_time);
            tv_level = (TextView) view.findViewById(R.id.tv_level);
            tv_step = (TextView) view.findViewById(R.id.tv_step);

        }
    }

    class SupportHoldler {
        CircleImageView iv_head;
        TextView tv_support;

        public SupportHoldler(View view) {
            iv_head = (CircleImageView) view.findViewById(R.id.iv_head);
            tv_support = (TextView) view.findViewById(R.id.tv_support);
        }
    }


}
