package br.com.digitalhouse.paoeleite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ComidaViewModel mComidaViewModel;

    public static final int NEW_COMIDA_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final ComidaListAdapter adapter = new ComidaListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mComidaViewModel = new ViewModelProvider(this).get(ComidaViewModel.class);

        mComidaViewModel.getAllWords().observe(this, new Observer<List<Comida>>() {
            @Override
            public void onChanged(@Nullable final List<Comida> comidas) {
                adapter.setWords(comidas);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.content.Intent intent = new Intent(MainActivity.this, NewComidaActivity.class);
                startActivityForResult(intent, NEW_COMIDA_ACTIVITY_REQUEST_CODE);
            }
        });
    }
        public void onActivityResult (int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == NEW_COMIDA_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
                Comida comida = new Comida(data.getStringExtra(NewComidaActivity.EXTRA_REPLY));
                mComidaViewModel.insert(comida);
            } else {
                Toast.makeText(
                        getApplicationContext(),
                        R.string.empty_not_saved,
                        Toast.LENGTH_LONG).show();
            }


        }



    }

