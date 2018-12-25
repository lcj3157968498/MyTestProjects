package com.example.lcj.mytestprojects.RatingBarTest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lcj.mytestprojects.R;
import com.example.lcj.mytestprojects.RatingBarTest.adapter.TagsAdapter;
import com.example.lcj.mytestprojects.RatingBarTest.model.ResultTagsBean;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    @Bind(R.id.ratingbar)
    RatingBar ratingbar;
    @Bind(R.id.ll_holder_rec)
    LinearLayout llHolderRec;
    @Bind(R.id.bt_commit)
    Button btCommit;
    @Bind(R.id.tv_test)
    TextView tvTest;
    private List<ResultTagsBean.DataBean.TagsBean> myrecylist = new ArrayList<>();
    private TagsAdapter mTagsAdapter;
    private ResultTagsBean resultTagsBean;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        initView();
        initData();//初始化测试数据
        btCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> mSelectTags = new ArrayList<>();

                for (ResultTagsBean.DataBean.TagsBean t :
                        myrecylist) {
                    if (t.isCheck()) {
                        String name = t.getName();
                        mSelectTags.add(name);
                    }
                }
                System.out.println("222");
                //Toast.makeText(Main2Activity.this, mSelectTags.toString(), Toast.LENGTH_SHORT).show();

                // Toast.makeText(Main2Activity.this,mTagsAdapter.mToastList.toString(),Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void initView() {

        /*mTagsAdapter.setItemClickListener(new TagsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(Main2Activity.this,"被点击了"+position,Toast.LENGTH_LONG).show();
            }
        });*/
        ratingbar.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        int mLevel = (int) rating;
                        recyclerView = new RecyclerView(Main2Activity.this);

                        recyclerView.setLayoutManager(new GridLayoutManager(getParent(), 3));
                        mTagsAdapter = new TagsAdapter(myrecylist);
                        recyclerView.setAdapter(mTagsAdapter);
                        llHolderRec.removeAllViews();
                        llHolderRec.addView(recyclerView);

                        List<ResultTagsBean.DataBean.TagsBean> tagsBeans = resultTagsBean.getData().get(mLevel - 1).getTags();
                        myrecylist.clear();
                        myrecylist.addAll(tagsBeans);
                        mTagsAdapter.notifyDataSetChanged();


                    }
                }
        );
    }

    private void initData() {
        String data = getResources().getString(R.string.jsonData);
        Gson gson = new Gson();
        resultTagsBean = gson.fromJson(data, ResultTagsBean.class);

    }


}

