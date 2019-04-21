package com.miklesam.alco7;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Rools_activity extends AppCompatActivity {



    int[] IMAGES={R.drawable.ace_chervi,R.drawable.k_chervi,R.drawable.q_chervi,R.drawable.j_chervi,
            R.drawable.ten_chervi,R.drawable.nine_chervi,R.drawable.eight_chervi,R.drawable.seven_chervi,
            R.drawable.six_chervi
          };



    String NAMES[]={"Туз","Король","Дама","Валет","Десятка","Девятка","Восьмерка","Семерка","Шестерка"};
    String Descriptions[]={"Выбери кто пьет!","Запрет","Поднять руку","Действие","Вопрос","Тема","Щит","Счет","Пьешь сам"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_rools_activity);


        ListView listView = (ListView)findViewById(R.id.list_view);
        final TextView RightText = (TextView)findViewById(R.id.right_text);
        final TextView DescrText = (TextView)findViewById(R.id.descr_text);
        final ImageView RightImage = (ImageView)findViewById(R.id.right_Ima);

        CustomAdapter customAdapter=new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RightText.setText(NAMES[position]);
                DescrText.setText(Descriptions[position]);
                RightImage.setImageResource(IMAGES[position]);
            }
        });




    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = getLayoutInflater().inflate(R.layout.customlayout,null);

            ImageView imageView=(ImageView)convertView.findViewById(R.id.image);
            TextView textView = (TextView)convertView.findViewById(R.id.Titile);

            imageView.setImageResource(IMAGES[position]);
            textView.setText(NAMES[position]);
            return convertView;
        }
    }





}

