package com.example.listatareas_menukr;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button buttonMenu;
    EditText editar;
    ListView lista;
    ArrayList<String> Tareas;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.List);
        editar = findViewById(R.id.Edit);
        buttonMenu = findViewById(R.id.Boton);
        registerForContextMenu(buttonMenu);

        Tareas = new ArrayList<>();

        final ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Tareas);
        lista.setAdapter(adapter);


    }


    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
    }

    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
            if (id== R.id.Agregar) {
                añadir();
                limpiar();
            }
            else if (id == R.id.Edit){
                editar();
            }
            else if (id == R.id.Eliminar) {
                eliminar();
            }
            return super.onContextItemSelected(item);
    }

    private void añadir() {
        String tar = editar.getText().toString().trim();
        Tareas.add(tar);

        /*if (!tar.isEmpty()) {
            int selectedTaskPosition = lista.getCheckedItemPosition();

            if (selectedTaskPosition != AdapterView.INVALID_POSITION) {
                Tareas.set(selectedTaskPosition, tar);
            } else {
                Tareas.add(tar);
            }
            adapter.notifyDataSetChanged();
            editar.setText("");
        }*/

    }

    private void limpiar() {
        editar.setText("");
    }

    private void editar() {

    }

    private void eliminar() {
    }

}