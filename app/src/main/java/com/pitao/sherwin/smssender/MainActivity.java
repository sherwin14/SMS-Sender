package com.pitao.sherwin.smssender;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMessages;
    private LinearLayoutManager lm;
    private ArrayList<MessageData> messageDatas;
    private MessageData messageData;
    private MessageAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lm = new LinearLayoutManager(getBaseContext());
        messageDatas = new ArrayList<>();
        this.getMessages(messageDatas);
        messageAdapter = new MessageAdapter(messageDatas);
        recyclerViewMessages = (RecyclerView) findViewById(R.id.recycler);
        recyclerViewMessages.setHasFixedSize(true);
        recyclerViewMessages.setAdapter(messageAdapter);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewMessages.setLayoutManager(lm);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public ArrayList<MessageData> getMessages(ArrayList<MessageData> smsData){
        Uri sms = Uri.parse("content://sms/inbox");
        Cursor cursor = getContentResolver().query(
                sms,
                new String[]{"address","_id","date","body","count(_id)"}
                ,"address='+639752308495'" ,null,null);

        cursor.moveToFirst();
        //int count = cursor.getCount();
        while (cursor.moveToNext()){
            Date date = new Date(cursor.getLong(2));
            String formattedDate = new SimpleDateFormat("MM/dd/yyyy H:mm:ss aa").format(date);
            Log.d("address",cursor.getString(4));
            messageData = new MessageData(cursor.getString(0),formattedDate,cursor.getString(3),cursor.getInt(1));
            smsData.add(messageData);
        }
        return smsData;
    }
}
