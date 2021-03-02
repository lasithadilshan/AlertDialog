package com.dilshan.alertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dilshan.alertdialog.databinding.ActivityMainBinding;
import com.dilshan.alertdialog.databinding.SampleDialogBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.customDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.sample_dialog,null);
//
//                Button cancelBtn = view.findViewById(R.id.cancelBtn);
//                Button removeBtn = view.findViewById(R.id.deleteBtn);

                SampleDialogBinding dialogBinding = SampleDialogBinding.inflate(getLayoutInflater());
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setView(dialogBinding.getRoot())
                        .setCancelable(false)
                        .create();

                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.getWindow().setWindowAnimations(R.style.DialogAnimation);

                dialogBinding.cancelBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "Cancelled.", Toast.LENGTH_SHORT).show();
                    }
                });

                dialogBinding.deleteBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "Removed.", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.show();
            }
        });

        binding.showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Delete Message")
                        .setMessage("Are you sure you want to delete this message ?")
                        .setIcon(R.drawable.ic_remove)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Yes Clicked.", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "No Clicked.", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("May be", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Cancel Clicked.", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                dialog.show();

            }
        });
    }
}