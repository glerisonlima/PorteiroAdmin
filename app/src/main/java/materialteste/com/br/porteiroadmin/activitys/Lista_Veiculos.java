package materialteste.com.br.porteiroadmin.activitys;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import materialteste.com.br.porteiroadmin.R;
import materialteste.com.br.porteiroadmin.adapter.AdapterVeiculo;
import materialteste.com.br.porteiroadmin.adapter.Adapterpessoa;
import materialteste.com.br.porteiroadmin.dao.pessoaDAO;
import materialteste.com.br.porteiroadmin.dao.veiculoDAO;

public class Lista_Veiculos extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume(){
        super.onResume();
        veiculoDAO dao = new veiculoDAO(getBaseContext());
        setListAdapter(new AdapterVeiculo(getBaseContext(),dao.getAll()));
    }


}
