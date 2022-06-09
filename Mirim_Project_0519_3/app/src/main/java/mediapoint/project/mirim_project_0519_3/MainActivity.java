package mediapoint.project.mirim_project_0519_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer timer;
    RadioGroup rg;
    TimePicker time;
    DatePicker date;
    TextView textResult;
    FrameLayout frame;
    int selectedYear, selectedMonth, selectedDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = findViewById(R.id.timer);
        rg = findViewById(R.id.rg);
        time = findViewById(R.id.time);
        date = findViewById(R.id.date);
        textResult = findViewById(R.id.text_result);
        frame = findViewById(R.id.frame);
        timer.setOnClickListener(timerListener);
        textResult.setOnLongClickListener(textListener);
        rg.setOnCheckedChangeListener(rgListener);
        date.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                selectedYear = year;
                selectedMonth = month+1;
                selectedDay = day;
            }
        });
        time.setVisibility(View.INVISIBLE);
        date.setVisibility(View.INVISIBLE);
        rg.setVisibility(View.INVISIBLE);
        frame.setVisibility(View.INVISIBLE);
    }
    RadioGroup.OnCheckedChangeListener rgListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            frame.setVisibility(View.VISIBLE);
            time.setVisibility(View.INVISIBLE);
            date.setVisibility(View.INVISIBLE);
            switch (checkedId){
                case R.id.radio_date:
                    date.setVisibility(View.VISIBLE);
                    break;
                case R.id.radio_time:
                    time.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
    View.OnClickListener timerListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            timer.setBase(SystemClock.elapsedRealtime());
            timer.start();
            rg.setVisibility(View.VISIBLE);
            timer.setTextColor(Color.RED);
        }
    };
    View.OnLongClickListener textListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            timer.stop();
            timer.setTextColor(Color.BLUE);
            textResult.setText(selectedYear+"년 "+selectedMonth+"월 "+selectedDay+"일 ");
            textResult.append(time.getCurrentHour()+"시 "
                    +time.getCurrentMinute()+"분 예약 완료됨");
            rg.setVisibility(View.INVISIBLE);
            frame.setVisibility(View.INVISIBLE);
            return true;
        }
    };

}