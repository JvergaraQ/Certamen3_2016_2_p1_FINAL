package cl.telematica.android.certamen3.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import cl.telematica.android.certamen3.DataAdapter;
import cl.telematica.android.certamen3.Interfaces.MainPresenter;
import cl.telematica.android.certamen3.Interfaces.MainView;
import cl.telematica.android.certamen3.Models.Feed;
import cl.telematica.android.certamen3.Presenters.MainPresenterImpl;
import cl.telematica.android.certamen3.R;

public class Main extends AppCompatActivity implements MainView {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        presenter = new MainPresenterImpl(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        presenter.Obtenerdatos();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            /**
             * You should manage the action to show the favorite items saved by the user
             */
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void conn_exitosa() {
        Toast.makeText(this,"Conexion con servidor exitosa", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void get_exitoso(List<Feed> lista) {
        Toast.makeText(this,"Obtencion de datos exitosa", Toast.LENGTH_SHORT).show();
        mAdapter = new DataAdapter(this,lista);
        mRecyclerView.setAdapter(mAdapter);
    }
}
