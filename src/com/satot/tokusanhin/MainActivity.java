package com.satot.tokusanhin;

//import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//import android.widget.EditText;

public class MainActivity extends Activity {
    public final static String EXTRA_MESSAGE = "com.satot.Tokusanhin.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // activity_main を描画
        setContentView(R.layout.activity_main);
        // quiz番号
        TextView quizNo = (TextView) findViewById(R.id.QuizNo);
        quizNo.setText(2);
        // 選択肢をセット
        Button answer1 = (Button) findViewById(R.id.Button01);
        Button answer2 = (Button) findViewById(R.id.Button02);
        Button answer3 = (Button) findViewById(R.id.Button03);
        Button answer4 = (Button) findViewById(R.id.Button04);
        answer1.setText("Green Tea");
        answer2.setText("Piano");
        answer3.setText("Eel");
        answer4.setText("Mikan");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    /** Called when the user clicks the Send button */
	public void sendMessage(View view) {
        Log.d("DEBUG","id="+view.getId());
        // 答えリスト作成
        List<Integer> list = new ArrayList<Integer>();
        list.add(R.id.Button01);
        list.add(R.id.Button02);
        list.add(R.id.Button03);
        list.add(R.id.Button04);
        Collections.shuffle(list);
        int id = view.getId();
        int correctId = list.get(0);
        // 答え合わせ
        String message = "";
        if(correctId == id){
        	message = "correct!";
        } else {
        	message = "wrong";
        }
        // Intentに格納して結果表示画面へ
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}