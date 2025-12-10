package com.example.sangam;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MyCustomListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_custom_list);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView myList = findViewById(R.id.main);
        HamroCustomAdapter adapter = new HamroCustomAdapter(this); // pass context
        myList.setAdapter(adapter);
    }

    // Inner adapter class
    private class HamroCustomAdapter extends BaseAdapter {

        String[] name = {"Abhash", "Anjali", "Bimal", "Dipen", "Joyesh",
                "Mallika", "Manisa", "Manjit", "Nabaraj", "Nayan",
                "Nirjala", "Pratiksha", "Rashmi", "Ritika", "Sangam",
                "Sebak", "Srijana", "Sudip", "Sushil", "Swostika"
        };
        String[] nickName = {"Hallankari", "Hasmati", "Silent", "Chasmis", "Joker",
                "Motax", "Small", "Galatey", "LoverBoi", "Mote",
                "Gayab", "Danger", "Dancer", "Don", "Chattu",
                "Neta", "Boxer", "Lamo Kapal Boy", "Commando", "Presenter"
        };
        int[] images = {R.drawable.ktm,
                R.drawable.circle_bg,
                R.drawable.ktm, R.drawable.ktm, R.drawable.ktm,
                R.drawable.ktm, R.drawable.ktm, R.drawable.ktm, R.drawable.ktm,
                R.drawable.ktm, R.drawable.ktm, R.drawable.ktm, R.drawable.ktm,
                R.drawable.ktm, R.drawable.ktm, R.drawable.ktm,
                R.drawable.ktm, R.drawable.ktm, R.drawable.ktm, R.drawable.ktm,
        };

        Context context;
        LayoutInflater inflater;

        HamroCustomAdapter(Context c) {
            this.context = c;
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return images[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup parent) {
            if (view == null) {
                view = inflater.inflate(R.layout.my_custom_row, parent, false);
            }

            ImageView myImage = view.findViewById(R.id.img);
            TextView myName = view.findViewById(R.id.tv_name);
            TextView myNickName = view.findViewById(R.id.tv_nick);

            // Set data
            myName.setText(name[i]);
            myNickName.setText(nickName[i]);
            myImage.setImageResource(images[i]);

            return view;
        }
    }
}
