package com.example.applicationtest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.security.auth.PrivateCredentialPermission;


public class Fragment2 extends Fragment {

    private RecyclerView recyclerView;
    private Context context;
    private FloatingActionButton fab;
    private Adapter myadapter;
    private List<String> list = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.tab02, container, false);

        recyclerView = view.findViewById(R.id.recyclerView1);
        listdata();
        Viewinit();
        return view;



    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onStart() {
        super.onStart();
        fab=getActivity().findViewById(R.id.fab);
        ConstraintLayout constraintlayout_none=getActivity().findViewById(R.id.constraintlayout_none);
        EditText text_add=getActivity().findViewById(R.id.text_add);
        Button button_cl=getActivity().findViewById(R.id.button_cl);
        Button button_ok=getActivity().findViewById(R.id.button_ok);
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);   ;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                constraintlayout_none.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.INVISIBLE);
                imm.showSoftInput(text_add, 0);
                text_add.setText("");
                button_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String s=text_add.getText().toString();
                        constraintlayout_none.setVisibility(View.GONE);
                        list.add(s);
                        Log.d("add","+1");
                        imm.hideSoftInputFromWindow(text_add.getWindowToken(), 0);
                        myadapter.notifyDataSetChanged();
                        recyclerView.scrollToPosition(myadapter.getItemCount() - 1);
                        Toast.makeText(context, "添加成功", Toast.LENGTH_SHORT).show();
                        recyclerView.setVisibility(View.VISIBLE);
                    }
                });
                button_cl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        constraintlayout_none.setVisibility(View.GONE);
                        Toast.makeText(context, "取消添加", Toast.LENGTH_SHORT).show();
                        recyclerView.setVisibility(View.VISIBLE);
                        imm.hideSoftInputFromWindow(text_add.getWindowToken(), 0);
                    }
                });
            }
        });


    }

    private void Viewinit() {
        context = this.getActivity();
        //fullview=getView();
        myadapter = new Adapter(context);
        //设置LayoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(myadapter);
        myadapter.list(list);

    }

    private void listdata() {
        list.add("妈妈，我登上荒坂塔的顶端了，你看到了吗？");
        list.add("愿你的勇气，我的剑，各自的使命与太阳同在！");
        list.add("你还是装上了义体金刚啊。");
        list.add("他才20岁，他想活命有什么罪！！！");
        list.add("我分不清，我真的分不清啊。");
        list.add("这就是我最后的波纹了，JOJO！");
        list.add("以我残躯化烈火。");
        list.add("我没有梦想，但我能守护他人的梦想。");
        list.add("我只做樱一个人的正义的伙伴。");
        list.add("灰烬大人，你还能听见我的声音吗？");
        list.add("赫尔墨斯之鸟乃吾之名，噬己翼以炼己心。");
        list.add("我们都是小怪兽，都会被正义的奥特曼杀死。");
        list.add("我可是铁华团团长奥尔加伊兹卡，保护团员是我的使命！");
        list.add("你才是真正的大人物，杰克。");
        list.add("无名小卒，还是名扬天下？");
        list.add("夜之城没有活着的传奇。");

    }


}