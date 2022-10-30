package com.example.work2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_item);

        textView=findViewById(R.id.textView10);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ItemActivity.this,resultActivity.class);
                test.launch(intent);
            }
        });

    }

    public ActivityResultLauncher test= registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {

                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()==666){
                        Log.d("xr","onActivityResult 有返回值。。。");
                        textView.setText(result.getData().getStringExtra("data"));

                    };
                }
            });


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifeline","activity2 is onStart...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifeline","activity2 is onRestart...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifeline","activity2 is onStop...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifeline","activity2 is onDestroy...");
    }

    @Override
    public void finish(){
        super.finish();
        Log.d("lifeline","activity2 is finish...");
    }

    @Override
    public void finishActivity(int requestCode){
        super.finishActivity(requestCode);
        Log.d("lifeline","finishActivity2...");
    }
}