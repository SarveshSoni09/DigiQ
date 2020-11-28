package com.example.digiq;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class QueuePage extends AppCompatActivity {

    TextView tvQueueWelcome, tvName, tvAppNum, tvTicketNum, tvWaitTimeText, tvWaitTime;
    Button btnLeaveQueue, btnEditDets;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.queue_page);

        tvQueueWelcome = findViewById(R.id.tvQueueWelcome);
        tvName = findViewById(R.id.tvName);
        tvAppNum = findViewById(R.id.tvAppNum);
        tvTicketNum = findViewById(R.id.tvTicketNum);
        tvWaitTimeText = findViewById(R.id.tvWaitTimeText);
        tvWaitTime = findViewById(R.id.tvWaitTime);
        btnLeaveQueue = findViewById(R.id.btnLeaveQueue);

        String name = getIntent().getStringExtra("Name");
        String app_no = getIntent().getStringExtra("ApplicationNumber");

        tvName.setText(getString(R.string.name_show) + name);
        tvAppNum.setText(getString(R.string.app_num) + app_no);

        btnLeaveQueue.setOnClickListener(v -> {
            final AlertDialog.Builder builder = new AlertDialog.Builder(QueuePage.this,R.style.CustomAlertDialog);
            ViewGroup viewGroup = findViewById(android.R.id.content);
            View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.confirm_exit, viewGroup, false);
            Button btnCancel=dialogView.findViewById(R.id.btnCancel);
            Button btnLeaveQueue = dialogView.findViewById(R.id.btnLeaveQueue);
            builder.setView(dialogView);
            final AlertDialog alertDialog = builder.create();
            btnCancel.setOnClickListener(v1 -> alertDialog.dismiss());
            btnLeaveQueue.setOnClickListener(v1 -> {
                Intent intent = new Intent(QueuePage.this, MainActivity.class);
                startActivity(intent);
            });
            alertDialog.show();
        });
    }
}
