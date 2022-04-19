package kr.hs.emirim.s2114.mirim_project_0414_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CancellationSignal;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    Switch switchStart;
    ImageView imgv;
    LinearLayout linearsub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearsub = findViewById(R.id.linear_sub);
        rg = findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(rgListener);
        switchStart = findViewById(R.id.switch_start);
        imgv = findViewById(R.id.imgv);
        Button btnFinish = findViewById(R.id.btn_finish);
        btnFinish.setOnClickListener(btnListener);
    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };
    RadioGroup.OnCheckedChangeListener rgListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int selectedId) {
            switch (selectedId){
                case R.id.rd_dog:
                    imgv.setImageResource(R.drawable.dog);
                    break;
                case R.id.rd_cat:
                    imgv.setImageResource(R.drawable.cat);
                    break;
                case R.id.rd_rabbit:
                    imgv.setImageResource(R.drawable.rabbit);
                    break;
            }
        }
    };

    CompoundButton.OnCheckedChangeListener switchListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            if(isChecked){
                linearsub.setVisibility(View.VISIBLE);
            }else{
                linearsub.setVisibility(View.INVISIBLE);
            }
        }
    };
}