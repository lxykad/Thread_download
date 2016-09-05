package com.lxy.thread;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class ProgressActivity extends AppCompatActivity {

    private RecyclerView mrecyclerView;
    private ProgressAdapter mAdapter;
    private LinearLayoutManager mManager;
    private ArrayList<String> mList;
    private ArrayList<ProgressBean> mProgressList = new ArrayList<>();
    private String mPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        initData();


        mrecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mManager = new LinearLayoutManager(this);
        mAdapter = new ProgressAdapter(R.layout.list_item_progress, mProgressList);
        mrecyclerView.setLayoutManager(mManager);
        mrecyclerView.setAdapter(mAdapter);

        start();
    }

    private void initData() {

        mPath = Environment.getExternalStorageDirectory().getPath();
        System.out.println("000000000000========path===="+mPath);

        File file = new File(mPath);
        if (!file.exists()) {
            file.mkdir();
            System.out.println("000000000000========mkdirs====");
        }
        mList = new ArrayList<>();
        mList.add("http://od.qingting.fm/m4a/572aaa977cb891033a8c1294_5099182_64.m4a");
        mList.add("http://od.qingting.fm/m4a/572aaa977cb891033a8c1294_5099182_64.m4a");
        mList.add("http://od.qingting.fm/m4a/572aaa977cb891033a8c1294_5099182_64.m4a");
        mList.add("http://od.qingting.fm/m4a/570f00327cb89103398358c7_5007432_64.m4a");
        mList.add("http://od.qingting.fm/m4a/570f00327cb89103398358c7_5007432_64.m4a");

        for (int i = 0; i < mList.size(); i++) {
            ProgressBean bean = new ProgressBean();
            mProgressList.add(bean);
        }
    }

    public void start() {
        for (int i = 0; i < mList.size(); i++) {


            OkHttpUtils.get()
                    .url(mList.get(i))
                    .build()
                    .execute(new FileCallBack(mPath, i + ".m4a") {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            System.out.println("000000000000========e====" + e.toString());
                        }

                        @Override
                        public void onResponse(File response, int id) {
                            System.out.println("000000000000========id====" + id);
                        }

                        @Override
                        public void inProgress(float progress, long total, int id) {
                            super.inProgress(progress, total, id);
                            System.out.println("000000000000========progress====" + progress);
                        }
                    });


        }

    }

}
