package kr.hs.emirim.s2114.mirirm_project_0412_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        textResult = findViewById(R.id.text_result);
        int[] btnId = {R.id.btn_plus, R.id.btn_minus, R.id.btn_Multi, R.id.btn_divide,R.id.btn_mod};
        Button[] btn = new Button[5];

        for (int i = 0; i < btn.length; i++) {
            btn[i] = findViewById(btnId[i]);
            btn[i].setOnClickListener(btnlistener);
        }
    }

    View.OnClickListener btnlistener = new View.OnClickListener() {
        public void onClick(View view) {
            String edit1Str = edit1.getText().toString();
            String edit2Str = edit2.getText().toString();
            if(edit1Str.equals("") || edit2Str.equals("")){
                Toast.makeText(getApplicationContext(),
                        "연산에 필요한 숫자가 입력되니 않습니다.",
                        Toast.LENGTH_LONG);
                return;
            }
            int num1 = Integer.parseInt(edit1Str);
            int num2 = Integer.parseInt(edit2Str);
            int result = 0;

            switch (view.getId()) {
                case R.id.btn_plus:
                    result = num1 + num2;
                    break;
                case R.id.btn_minus:
                    result = num1 - num2;
                    break;
                case R.id.btn_Multi:
                    result = num1 * num2;
                    break;
                case R.id.btn_divide:
                    result = num1 / num2;
                    break;
                case R.id.btn_mod:
                    result = num1 % num2;
                    break;
            }// Switch
            textResult.setText(R.string.text_result);
            textResult.append(" " + result);


        }
    };
}