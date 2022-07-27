package mediapoint.project.mirirm_project_0727_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    EditText editTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnStrart = findViewById(R.id.btn_start);
        btnStrart.setOnClickListener(btnStrartListener);
        rg = findViewById(R.id.rg);
        editTitle = findViewById(R.id.edit_title);
        Button btnStrar = findViewById(R.id.btn_start);
        btnStrar.setOnClickListener(BtnStrartListener);
    }
    View.OnClickListener btnStrartListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            startActivity(intent);
        }
    };
    View.OnClickListener BtnStrartListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Class c = null;
            switch(rg.getCheckedRadioButtonId()){
                case R.id.rg_second:
                    c = SecondActivity.class;
                    break;
                case R.id.rg_third:
                    c = ThirdActivty.class;
                    break;
            }
            Intent intent = new Intent(getApplicationContext(),c);
            intent.putExtra("title", editTitle.getText().toString());
            startActivity(intent);
        }
    };
}