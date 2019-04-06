package com.example.student3.aadasd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btAdd, btSelectAll, btDelete;
    EditText et, et1, et2;
    DBHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btAdd = (Button)findViewById(R.id.bt_add);
        btSelectAll = (Button)findViewById(R.id.bt_selectAll);
        btDelete = (Button)findViewById(R.id.bt_delete);
        btAdd.setOnClickListener(this);
        btSelectAll.setOnClickListener(this);
        btDelete.setOnClickListener(this);
        et = (EditText)findViewById(R.id.editText);
        et1 = (EditText)findViewById(R.id.editText2);
        et2 = (EditText)findViewById(R.id.editText3);

        dbhelper = new DBHelper(this, "dbteachers", null, 2);
    }

    @Override
    public void onClick(View v) {
        ContentValues cv = new ContentValues();
        String fio = et.getText().toString();
        String grade = et1.getText().toString();
        String subject = et2.getText().toString();

        SQLiteDatabase db = dbhelper.getWritableDatabase();

        switch (v.getId()) {

            case R.id.bt_add:
                Log.e("IIIIIIIII", "Insert values...");
                cv.put("name", fio);
                cv.put("grade", grade);
                cv.put("subject", subject);
                db.insert("teachers", null, cv);
                break;
            case R.id.bt_selectAll:
                Log.e("SSSSSSSSS", "Show values...");
                Cursor c = db.query("teachers", null,null,null,null,null, "grade");
                if(c.moveToFirst())
                {
                    int id_index = c.getColumnIndex("id");
                    int name_index = c.getColumnIndex("name");
                    int grade_index = c.getColumnIndex("grade");
                    int subject_index = c.getColumnIndex("subject");
                    do{
                        Log.e("VVVVVVVVV", "\nid = " + c.getInt(id_index) + "; \nname = " + c.getString(name_index) + "; \ngrade = " + c.getString(grade_index) + "; \nsubject = " + c.getString(subject_index) + "\n");
                    }while(c.moveToNext());
                }
                break;
            case R.id.bt_delete:
                Log.e("DDDDDDDD", "Delete all values...");
                int clear = db.delete("teachers", null, null);
                break;
        }
        dbhelper.close();
    }

    /*@Override
    public void onClick(View v)
    {

    }*/
}
