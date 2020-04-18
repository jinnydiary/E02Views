package net.skhu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ArrayAdapter;

public class AlertsActivity extends AppCompatActivity {

    int selectedAnimalIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);
    }

    public void button1_clicked(View button) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.saveSuccess);
        builder.setNeutralButton(R.string.close, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void button2_clicked(View button) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.confirm);
        builder.setMessage(R.string.doYouWantToDelete);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int index) {
                // 삭제 작업 실행
                Toast.makeText(AlertsActivity.this, "삭제성공", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.no, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void button3_clicked(View button) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.selectAnimal);
        builder.setSingleChoiceItems(R.array.animals, selectedAnimalIndex, null);
        builder.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int index) {
                // 선택된 항목에 대한 작업 실행
                ListView listView = ((AlertDialog)dialog).getListView();
                selectedAnimalIndex = listView.getCheckedItemPosition();
                String msg = selectedAnimalIndex + " 번째 항목이 선택되었습니다.";
                Toast.makeText(AlertsActivity.this, msg, Toast.LENGTH_SHORT).show();

                int drawableId = 0;
                switch (selectedAnimalIndex) {
                    case 0: drawableId = R.drawable.animal_cat_large; break;
                    case 1: drawableId = R.drawable.animal_dog_large; break;
                    case 2: drawableId = R.drawable.animal_owl_large; break;
                }
                ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
                imageView1.setImageResource(drawableId);
            }
        });
        builder.setNegativeButton(R.string.cancel, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void button4_clicked(View button) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("동물 선택");
        String[] animalsArray = {"고양이", "강아지", "부엉이"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, animalsArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        builder.setSingleChoiceItems(adapter, selectedAnimalIndex, null);
        builder.setPositiveButton("확인", null);
        builder.setNegativeButton("취소", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void button5_clicked(View button) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("동물 선택");
        builder.setNeutralButton("강아지", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int index) {
                // 선택된 항목에 대한 작업 실행
                int drawableId = R.drawable.animal_dog_large;
                ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
                imageView1.setImageResource(drawableId);
            }
        });
        builder.setNegativeButton("부엉이", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int index) {
                // 선택된 항목에 대한 작업 실행
                int drawableId = R.drawable.animal_owl_large;
                ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
                imageView1.setImageResource(drawableId);
            }
        });
        builder.setPositiveButton("고양이", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int index) {
                // 선택된 항목에 대한 작업 실행
                int drawableId = R.drawable.animal_cat_large;
                ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
                imageView1.setImageResource(drawableId);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
