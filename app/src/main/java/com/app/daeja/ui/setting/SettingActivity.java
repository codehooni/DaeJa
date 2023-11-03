package com.app.daeja.ui.setting;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.app.daeja.MainActivity;
import com.app.daeja.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SettingActivity extends AppCompatActivity {

    private ImageView img_back;
    private TextView tv_userName;
//    private ListView list;
    private ImageView iv_editName;
    private ImageView iv_editPicture;
    private Spinner s_language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState);
        setContentView(R.layout.activity_setting);


        img_back = (ImageView) findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
//                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
//                startActivity(intent);
            }
        });

        tv_userName = (TextView) findViewById(R.id.tv_userName);

//        list = (ListView) findViewById(R.id.list);
//
//        List<String> data = new ArrayList<>();
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
//
//        list.setAdapter(adapter);
//        data.add("이름 변경");
//        data.add("사진 변경");
//        data.add("언어");

        iv_editName = (ImageView) findViewById(R.id.iv_editName);
        iv_editPicture = (ImageView) findViewById(R.id.iv_editPicture);

        iv_editName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder(SettingActivity.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("이름 변경");
                ad.setMessage("이름을 입력하시오.");

                final EditText et = new EditText(SettingActivity.this);
                et.setHint("이름 입력");
                ad.setView(et);
                ad.setPositiveButton("변경", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String result = et.getText().toString();
                        tv_userName.setText(result);
                        dialog.dismiss();
                    }
                });
                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                ad.show();
            }
        });

        iv_editPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SettingActivity.this, "not be implemented", Toast.LENGTH_SHORT).show(); 
            }
        });


        s_language = (Spinner) findViewById(R.id.s_language);
        s_language.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter arrayAdapter = (ArrayAdapter) s_language.getAdapter();
                int spinnerPosition = arrayAdapter.getPosition(0);
                s_language.setSelection(spinnerPosition);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}