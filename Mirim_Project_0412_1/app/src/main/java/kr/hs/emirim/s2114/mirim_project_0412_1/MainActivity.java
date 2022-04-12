package kr.hs.emirim.s2114.mirim_project_0412_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t1 = findViewById(R.id.text1);
        TextView t2 = findViewById(R.id.text2);
        TextView t3 = findViewById(R.id.text3);
        TextView t4 = findViewById(R.id.text4);

        t1.setText("빨강색 글자 TextView");
        t1.setTextColor(Color.rgb(255,0, 0));
        t2.setTextSize(30);
        t2.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);
        t3.setText("안드로이드 기초 Bqks 강돠 방과후 학교 안드로이드 기초 Bqks 강돠 방과후 학교 안드로이드 기초 Bqks 강돠 방과후 학교 안드로이드 기초 Bqks 강돠 방과후 학교 안드로이드 기초 Bqks 강돠 방과후 학교 ");
        t3.setSingleLine(true);
    }
}