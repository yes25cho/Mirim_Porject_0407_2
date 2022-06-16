package mediapoint.project.mirim_project_0614_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewFlipper vFlip;
    EditText editIntervel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vFlip = findViewById(R.id.vFlip);
        Button btnStart = findViewById(R.id.btn_start);
        Button btnStop = findViewById(R.id.btn_stop);
        Button btnIntervel = findViewById(R.id.btn_intervel);
        vFlip.setFlipInterval(1000);
    }

    View.OnClickListener btnListeneer = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_start:
                    vFlip.startFlipping();
                    break;
                case R.id.btn_stop:
                    vFlip.stopFlipping();
                    break;
                case R.id.btn_intervel:
                    int Intervel = Integer.parseInt(editIntervel.getText().toString());
                    vFlip.setFlipInterval(Intervel*1000);
                    break;
            }
        }
    };
}