package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.*;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private  LocalReceiver localReceiver;
    IntentFilter intentFilter;
    private  LocalBroadcastManager localBroadcastManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcastManager =LocalBroadcastManager.getInstance(this);
        Button button= findViewById(R.id.buttonasd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction("com.example.myapplication.MY_BROADCAST");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
        intentFilter =new IntentFilter();
        intentFilter.addAction("com.example.myapplication.MY_BROADCAST");
        localReceiver =new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);

    }
     @Override
     public void onDestroy(){
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
     }

    class LocalReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"asdf",Toast.LENGTH_SHORT).show();
        }
    }


}