package mediapoint.project.mirirm_project_0726_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgV;
    EditText editT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgV = findViewById(R.id.cool);
        editT = findViewById(R.id.editT);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.item:
                imgV.setRotation(Float.parseFloat(editT.getText().toString()));
                return true;
            case R.id.item1:
                item.setChecked(true);
                imgV.setImageResource(R.drawable.cool);
                return true;
            case R.id.item2:
                item.setChecked(true);
                imgV.setImageResource(R.drawable.leechan);
                return true;
            case R.id.item3:
                item.setChecked(true);
                imgV.setImageResource(R.drawable.iu);
                return true;
        }
        return false;
    }

}