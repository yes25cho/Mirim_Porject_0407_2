package mediapoint.project.mirim_project_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] bmiList= {"저","정상", "과", "비만","고도비만"};
        setContentView(R.layout.activity_result);
        Button btnPrev = findViewById(R.id.btn_prev);
        btnPrev.setOnClickListener(btnPrevListener);

        Intent intent= getIntent();
        String name = intent.getStringExtra("name");
        String weightStr = intent.getStringExtra("weight");
        String heightStr = intent.getStringExtra("height");
        float weight = Float.parseFloat(weightStr);
        float height = Float.parseFloat(heightStr)/100;
        float BMI = weight/(height*height);

        TextView textBmi = findViewById(R.id.text_BMI);
        ImageView imgBmi = findViewById(R.id.img_BMI);
        int i = ((BMI>=35.0)?4:(BMI>=30.0)?3:(BMI>=25.0)?2:(BMI>=18.5)?1:0);
        textBmi.setText(name+"님의 BMI지수는\n"+BMI+"로 "+bmiList[i]+"체중입니다.");
        switch (i){
            case 0:
                imgBmi.setImageResource(R.drawable.bmi1);
                break;
            case 1:
                imgBmi.setImageResource(R.drawable.bmi2);
                break;
            case 2:
                imgBmi.setImageResource(R.drawable.bmi3);
                break;
            case 3:
                imgBmi.setImageResource(R.drawable.bmi4);
                break;
            case 4:
                imgBmi.setImageResource(R.drawable.bmi5);
                break;
        }
    }
    View.OnClickListener btnPrevListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };

}