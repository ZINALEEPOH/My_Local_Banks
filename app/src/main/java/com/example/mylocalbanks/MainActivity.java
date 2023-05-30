package com.example.mylocalbanks;

import static android.graphics.Color.rgb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvD, tvO, tvU;

    String wordClicked="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvD=findViewById(R.id.textView);
        tvO=findViewById(R.id.textView2);
        tvU=findViewById(R.id.textView3);

        registerForContextMenu(tvD);
        registerForContextMenu(tvO);
        registerForContextMenu(tvU);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id=item.getItemId();

        if(id==R.id.engTrans) {
            tvD.setText("DBS");
            tvO.setText("OCBC");
            tvU.setText("UOB");
            return true;
        } else if(id==R.id.chiTrans) {
            tvD.setText("星展银行");
            tvO.setText("华侨银行");
            tvU.setText("大华银行");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
        menu.add(0,2,3,"Toggle Favourite");
        if(v==tvD){
            wordClicked="dbs";
        }else if(v==tvO){
            wordClicked="ocbc";
        }else if(v==tvU){
            wordClicked="UOB";
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("dbs")||wordClicked.equalsIgnoreCase("星展银行")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent();
                intent.setData(Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
                return true;
            }else if (item.getItemId() == 1) {
                Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+String.valueOf("18001111111")));
                startActivity(intentCall);
                return true;
            }else if(item.getItemId()==2){
                tvD.setTextColor(rgb(255,0,0));
            }
        }else if(wordClicked.equalsIgnoreCase("ocbc")||wordClicked.equalsIgnoreCase("华侨银行")){
            if (item.getItemId() == 0) {
                Intent intent = new Intent();
                intent.setData(Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
                return true;
            }else if (item.getItemId() == 1) {
                Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+String.valueOf("18003633333")));
                startActivity(intentCall);
                return true;
            }else if(item.getItemId()==2){
                tvO.setTextColor(rgb(255,0,0));
            }
        }else if(wordClicked.equalsIgnoreCase("uob")||wordClicked.equalsIgnoreCase("大华银行")){
            if (item.getItemId() == 0) {
                Intent intent = new Intent();
                intent.setData(Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
                return true;
            }else if (item.getItemId() == 1) {
                Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+String.valueOf("18002222121")));
                startActivity(intentCall);
                return true;
            }else if(item.getItemId()==2){
                tvU.setTextColor(rgb(255,0,0));
            }
        }
        return super.onContextItemSelected(item);
    }
}