package abazdev.dicoding.abazapp;


import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import abazdev.dicoding.abazapp.controller.ListJajakhasAdapter;
import abazdev.dicoding.abazapp.model.Jajakhas;
import abazdev.dicoding.abazapp.model.JajakhasData;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMain;
    private ArrayList<Jajakhas> listJajakhas = new ArrayList<>();
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMain = findViewById(R.id.rv_main);
        listJajakhas.addAll(JajakhasData.getListData());
        showRecyclerList();

    }

    private void showRecyclerList(){
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        ListJajakhasAdapter listJajakhasAdapter = new ListJajakhasAdapter(this);
        listJajakhasAdapter.setListJajakhas(listJajakhas);
        rvMain.setAdapter(listJajakhasAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_about:
                Intent abouj = new Intent(Intent.ACTION_VIEW, Uri.parse("https://baraqatu.blogspot.com/p/tentang.html"));
                startActivity(abouj);
                break;
            case R.id.action_contact:
                Toast.makeText(this, getResources().getText(R.string.contact), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}