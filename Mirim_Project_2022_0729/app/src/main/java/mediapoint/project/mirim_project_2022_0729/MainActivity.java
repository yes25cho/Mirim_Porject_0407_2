package mediapoint.project.mirim_project_2022_0729;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SharedElementCallback;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    EditText edit1, edit2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        intent = new Intent(getApplicationContext(), SecondActivity.class);
        Button plusBtn = findViewById(R.id.btn_plus);
        plusBtn.setOnClickListener(plusBtnListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            int sum = data.getIntExtra("sum", 0);
            Toast.makeText(getApplicationContext(), "덧셈결과 : "+sum, Toast.LENGTH_LONG).show();
        }
    }

    View.OnClickListener plusBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            intent.putExtra("num1", Integer.parseInt(edit1.getText().toString()));
            intent.putExtra("num2", Integer.parseInt(edit2.getText().toString()));
            startActivityForResult(intent, 0);
        }
    };

}