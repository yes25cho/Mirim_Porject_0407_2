package mediapoint.project.mirim_project_0728_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {
    RatingBar ratingSmall, ratingMedium, ratingBasic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ratingSmall = findViewById(R.id.rating_small);
        ratingMedium = findViewById(R.id.rating_medium);
        ratingBasic = findViewById(R.id.rating_basic);
        Button btnInc = findViewById(R.id.btn_inc);
        Button btnDec = findViewById(R.id.btn_dec);

        btnInc.setOnClickListener(btnListener);
        btnDec.setOnClickListener(btnListener);
    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_inc:
                    ratingSmall.setRating(ratingSmall.getRating()+ratingSmall.getStepSize());
                    ratingMedium.setRating(ratingMedium.getRating()+ratingMedium.getStepSize());
                    ratingBasic.setRating(ratingBasic.getRating()+ratingBasic.getStepSize());
                    break;
                case R.id.btn_dec:
                    ratingSmall.setRating(ratingSmall.getRating()-ratingSmall.getStepSize());
                    ratingMedium.setRating(ratingMedium.getRating()-ratingMedium.getStepSize());
                    ratingBasic.setRating(ratingBasic.getRating()-ratingBasic.getStepSize());
                    break;
            }
        }
    };

}