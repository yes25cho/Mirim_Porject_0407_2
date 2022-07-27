package mediapoint.project.mirim_project_0727_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnCheck;
    String[] itemsArr = {"아일랜드", "이탈리아", "영국"};
    boolean[] checkArr = {true,  false, true};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCheck = findViewById(R.id.btn_check);
        btnCheck.setOnClickListener(btnCheckListener);
    }

    View.OnClickListener btnCheckListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setTitle("체크목록 대화 상자");
            dlg.setIcon(R.drawable.icon);
            dlg.setMultiChoiceItems(itemsArr, checkArr, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                            checkArr[i] = b;
                            btnCheck.setText("");
                            for(i = 0; i<itemsArr.length; i++) {
                                if(checkArr[i]){
                                    btnCheck.append(itemsArr[i]);
                                }
                            }
                        }
                    });
            dlg.setNegativeButton("닫기", null);
            dlg.show();
        }
    };
}