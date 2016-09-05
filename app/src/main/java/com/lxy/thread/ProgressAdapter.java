package com.lxy.thread;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by C on 16/9/5.
 */
public class ProgressAdapter extends BaseQuickAdapter<ProgressBean> {


    public ProgressAdapter(int layoutResId, List<ProgressBean> list) {
        super(layoutResId, list);
    }

    @Override
    protected void convert(BaseViewHolder holder, ProgressBean bean) {
        holder.setProgress(R.id.progress_bar, bean.progress);

    }
}
