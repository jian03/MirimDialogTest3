package kr.hs.emirim.s2019s19.mirimdialogtest3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton radioDog, radioCat, radioHamster, radioChick;
    View dialogView;
    ImageView dlgImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = findViewById(R.id.rg1);
        radioDog = findViewById(R.id.rg_dog);
        radioCat = findViewById(R.id.rg_cat);
        radioHamster = findViewById(R.id.rg_hamster);
        radioChick = findViewById(R.id.rg_chick);
        Button btnShow = findViewById(R.id.show);
        btnShow.setOnClickListener(btnShowListener);
    }

    View.OnClickListener btnShowListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialogView = View.inflate(MainActivity.this, R.layout.dialog, null);
            dlgImage = dialogView.findViewById(R.id.image);
            int selectedId = 0;
            String seletedTitle = "";
            switch (rg.getCheckedRadioButtonId()){
                case R.id.rg_dog:
                    selectedId = R.drawable.rg_dog;
                    seletedTitle = radioDog.getText().toString();
                    break;
                case R.id.rg_cat:
                    selectedId = R.drawable.rg_cat;
                    seletedTitle = radioCat.getText().toString();
                    break;
                case R.id.rg_hamster:
                    selectedId = R.drawable.rg_hamster;
                    seletedTitle = radioHamster.getText().toString();
                    break;
                case R.id.rg_chick:
                    selectedId = R.drawable.rg_chick;
                    seletedTitle = radioChick.getText().toString();
                    break;
            }
            AlertDialog. Builder  dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setTitle(seletedTitle);
            dlgImage.setImageResource(selectedId);
            dlg.setView(dialogView);
            dlg.setPositiveButton("닫기", null);
            dlg.show();
        }
    };
}