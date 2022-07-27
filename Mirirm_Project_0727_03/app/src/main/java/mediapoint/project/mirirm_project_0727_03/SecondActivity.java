package mediapoint.project.mirirm_project_0727_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button btnPrev = findViewById(R.id.btn_prov);
        btnPrev.setOnClickListener(btnPrevLisetener);
    }
    View.OnClickListener btnPrevLisetener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };
}