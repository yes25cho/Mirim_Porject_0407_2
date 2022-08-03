package mediapoint.project.mirim_project_0803_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DBHelper dbHelper;
    EditText editName, editNum, editResultName, editResultNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = findViewById(R.id.edit_name);
        editNum= findViewById(R.id.edit_num);
        editResultName = findViewById(R.id.name);
        editResultNum = findViewById(R.id.num);
        Button btnInit = findViewById(R.id.btn_reset);
        Button btnInsert = findViewById(R.id.btn_input);
        Button btnSelect = findViewById(R.id.btn_such);
        dbHelper = new DBHelper(this);
        btnInit.setOnClickListener(btnListener);
        btnInsert.setOnClickListener(btnListener);
        btnSelect.setOnClickListener(btnListener);
    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        SQLiteDatabase db;
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_reset:
                    db = dbHelper.getWritableDatabase();
                    dbHelper.onUpgrade(db, 1, 2);
                    db.close();
                    break;
                case R.id.btn_input:
                    db = dbHelper.getWritableDatabase();
                    db.execSQL("insert into idoltbl values('"
                            +editName.getText().toString()+"',"
                            +editNum.getText().toString()+");");
                    db.close();
                    Toast.makeText(getApplicationContext(),
                            "입력됨", Toast.LENGTH_SHORT).show();
                    editName.setText("");
                    editNum.setText("");
                    break;
                case R.id.btn_such:
                    db = dbHelper.getReadableDatabase();
                    Cursor c = db.rawQuery("select * from idoltbl;", null);
                    String strName = "아이돌명\r\n_________\r\n";
                    String strNum = "인원수\r\n_________\r\n";
                    while(c.moveToNext()){
                        strName += c.getString(0) +"\r\n";
                        strNum += c.getInt(1) +"\r\n";
                    }
                    editResultName.setText(strName);
                    editResultNum.setText(strNum);
                    c.close();
                    db.close();
                    break;
            }
        }
    };
    public class DBHelper extends SQLiteOpenHelper{
        //DB생성 될때 호출
        public DBHelper(Context context){
            super(context, "idolDB",null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table idolTbl(name char(30) primary key,"+"cnt integer);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("drop table if exists idolTbl");
            onCreate(db);
        }
    }
}