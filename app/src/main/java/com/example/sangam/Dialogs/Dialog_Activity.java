package com.example.sangam.Dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sangam.R;

public class Dialog_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dialog);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
       Button cstmbtn = findViewById(R.id.btn_custom);
       cstmbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //todo write custom dialog box here
            Dialog myDialog = new Dialog(Dialog_Activity.this);
            myDialog.setContentView(R.layout.activity_dialog_icon);
            //start referencing here
               Button btnyes = myDialog.findViewById(R.id.btn_yes);
               Button btnno = myDialog.findViewById(R.id.btn_no);

            myDialog.show();
           }
       });



      Button btnDialog = findViewById(R.id.btn_show_dialog);
      btnDialog.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              //todo; write dialog box code here
         AlertDialog.Builder dialog = new AlertDialog.Builder(Dialog_Activity.this);
         dialog.setTitle("This is my dialog name");
         dialog.setMessage("My dialog name is this ");
         dialog.setCancelable(false);

         dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 dialog.cancel();
             }
         });
         dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 Toast.makeText(Dialog_Activity.this, "No this is not my dialog ", Toast.LENGTH_SHORT).show();
             }
         });
         dialog.setNeutralButton("May be", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 Toast.makeText(Dialog_Activity.this, "50-50", Toast.LENGTH_SHORT).show();

             }
         });



         dialog.show();
          }
      });
    }
}