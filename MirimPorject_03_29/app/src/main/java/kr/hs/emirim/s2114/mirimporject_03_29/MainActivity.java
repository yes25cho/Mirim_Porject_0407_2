package kr.hs.emirim.s2114.mirimporject_03_29;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.HttpCookie;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        btn1.setOnClickListener(btnListener);
        btn2.setOnClickListener(btnListener);
        btn3.setOnClickListener(btnListener);
        btn4.setOnClickListener(btnListener);
    }


    View.OnClickListener btnListener = new View.OnClickListener() {
        public void onClick(View v){
            Intent intent = null;
            switch (v.getId()){
 //             이벤트가 발생된 View(widget) 객체를 참조할 수 있는 값이 v에 저장
 //             v.getId(): 이벤트가 발생된 View(widget)객체의 id 값을 변환
                case R.id.btn1:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
                    startActivity(intent);
                    break;
                case R.id.btn2:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/010-3333-777"));
                    startActivity(intent);
                    break;
                case R.id.btn3:
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
                    startActivity(intent);
                    break;
                case R.id.btn4:
                    finish();
                    break;
            }
        }
    };
}