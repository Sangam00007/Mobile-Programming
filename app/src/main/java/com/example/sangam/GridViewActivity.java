package com.example.sangam;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grid_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        GridView grid = findViewById(R.id.grid_view);
        HamroCustomAdapter adapter = new HamroCustomAdapter(GridViewActivity.this);
        grid.setAdapter(adapter);
    }


    public class HamroCustomAdapter extends BaseAdapter {
  
        private final Context myContext;
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

        HamroCustomAdapter(Context context) {
             myContext = context;
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return images[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(int i, View view, ViewGroup parent) {
            view = LayoutInflater.from(myContext).inflate(R.layout.row_grid_item, parent, false);
            ImageView img = view.findViewById(R.id.grid_img);
            TextView tvname = view.findViewById(R.id.grid_name);
            TextView tvnickname = view.findViewById(R.id.grid_nick);

            //now put data
            img.setImageResource(images[i]);
            tvname.setText(name[i]);
            tvnickname.setText(nickName[i]);

            return view;
        }

    }
}
    
