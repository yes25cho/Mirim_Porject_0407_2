package mediapoint.project.mirim_project_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editName, editWeight, editHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnResult = findViewById(R.id.btn_result);
        btnResult.setOnClickListener(BtnResultListener);
        editName = findViewById(R.id.edit_name);
        editWeight = findViewById(R.id.edit_weight);
        editHeight = findViewById(R.id.edit_height);
    }
    View.OnClickListener BtnResultListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("name", editName.getText().toString());
            intent.putExtra("weight", editWeight.getText().toString());
            intent.putExtra("height", editHeight.getText().toString());
            startActivity(intent);
        }
    };
}