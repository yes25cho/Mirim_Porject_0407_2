package mediapoint.project.mirirm_project_0727_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        TextView textTitle = findViewById(R.id.text_title);
        textTitle.setText(title);
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