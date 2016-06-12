package com.i370.ui.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.i370.ui.R;

/**
 * Created by siwei.zhao on 2016/6/7.
 */
public class FileTypeFragment extends BaseFragment {

    private RecyclerView file_type_gride;
    private String[] typeNames=new String[]{"图片","音频","视频","文档","压缩包","收藏","最近打开","文件锁","共享文件"};
    private int[] typeIcos=new int[]{R.drawable.category_icon_image, R.drawable.category_icon_music, R.drawable.category_icon_video,
            R.drawable.category_icon_document, R.drawable.category_icon_compress, R.drawable.category_icon_favorite,
            R.drawable.category_icon_recent, R.drawable.ic_mai_strongbox, R.drawable.category_icon_application};
    private MyAdapter mAdapter;

    @Override
    protected int setCreateViewRes() {
        return R.layout.file_type_fragment;
    }

    @Override
    protected void initView(View baseView) {
        file_type_gride= (RecyclerView) baseView.findViewById(R.id.file_type_gride);
    }

    @Override
    protected void initData() {
        mAdapter=new MyAdapter();
        file_type_gride.setLayoutManager(new GridLayoutManager(getContext(), 3));
        file_type_gride.setItemAnimator(new DefaultItemAnimator());
        file_type_gride.setAdapter(mAdapter);
    }

    @Override
    protected void initEvent() {

    }

    private class MyAdapter extends  RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder lHolder=new MyViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.file_type_item, parent, false));
            return lHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText(typeNames[position]);
            holder.img.setImageResource(typeIcos[position]);
        }

        @Override
        public int getItemCount() {
            return typeNames.length;
        }

        protected class MyViewHolder extends RecyclerView.ViewHolder{

            ImageView img;
            TextView tv,file_count_tv;

            public MyViewHolder(View itemView) {
                super(itemView);
                img= (ImageView) itemView.findViewById(R.id.img);
                tv= (TextView) itemView.findViewById(R.id.tv);
                file_count_tv= (TextView) itemView.findViewById(R.id.file_count_tv);
            }
        }
    }
}
