package kr.hs.emirim.s2114.mirim0324_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(btnListener);
        checkBox = findViewById(R.id.check);
        checkBox.setOnClickListener(checkListener);
    }
    View.OnClickListener checkListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast t = Toast.makeText(MainActivity.this, "",Toast.LENGTH_SHORT);
            if(checkBox.isChecked()){
                t.setText(R.string.checked_text);
            }
            else{
                t.setText(R.string.unchecked_text);
            }
            t.show();
        }
    };
     View.OnClickListener btnListener = new View.OnClickListener() {
         @Override
         public void onClick(View view) {
//             Toast t= Toast.makeText(MainActivity.this, R.string.toast_text, Toast.LENGTH_SHORT);
//             t.show();
             Toast.makeText(MainActivity.this, R.string.toast_text, Toast.LENGTH_SHORT).show();
         }
     };

}