package mediapoint.project.mirim_project_0728_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] imgName = {"호델 델루나","뷰티인사이드","도깨비",
            "멜로가체질","사랑의 불시착","사이코지만 괜찮아",
            "스물다섯스물하나","슬기로운 의사생활","유미의 세포들"};
    ImageView[] imgv = new ImageView[imgName.length];
    int[] voteCount = new int[imgName.length];
    int[] imgId = {R.id.imgv01, R.id.imgv02, R.id.imgv03,
            R.id.imgv04, R.id.imgv05, R.id.imgv06,
            R.id.imgv07, R.id.imgv08, R.id.imgv09};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("선호하는 연예인 투표");
        Button btnStop = findViewById(R.id.btn_stop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("imgName", imgName);
                intent.putExtra("voteCount", voteCount);
                startActivity(intent);
            }
        });

        for(int i = 0; i<voteCount.length; i++){
            voteCount[i] =0;
        }
        for(int i=0;i<imgv.length; i++){
            final int index;
            index = i;
            imgv[index] = findViewById(imgId[index]);
            imgv[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),
                            imgName[index]+", 총 "+voteCount[index]+"표",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}