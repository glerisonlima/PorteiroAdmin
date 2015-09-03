package materialteste.com.br.porteiroadmin.activitys;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import materialteste.com.br.porteiroadmin.R;
import materialteste.com.br.porteiroadmin.adapter.Adapterpessoa;
import materialteste.com.br.porteiroadmin.adapter.Adapterportaria;
import materialteste.com.br.porteiroadmin.dao.pessoaDAO;
import materialteste.com.br.porteiroadmin.dao.portariaDAO;

public class ListarPessoas extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume(){
        super.onResume();
        pessoaDAO dao = new pessoaDAO(getBaseContext());
        setListAdapter(new Adapterpessoa(getBaseContext(),dao.getAll()));
    }



}
