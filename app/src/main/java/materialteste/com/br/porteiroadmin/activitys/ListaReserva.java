package materialteste.com.br.porteiroadmin.activitys;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import materialteste.com.br.porteiroadmin.R;
import materialteste.com.br.porteiroadmin.adapter.AdapterNotificacao;
import materialteste.com.br.porteiroadmin.adapter.AdapterReserva;
import materialteste.com.br.porteiroadmin.dao.notificacaoDAO;
import materialteste.com.br.porteiroadmin.dao.reservaDAO;

public class ListaReserva extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onResume(){
        super.onResume();
        reservaDAO dao = new reservaDAO(getBaseContext());
        setListAdapter(new AdapterReserva(getBaseContext(), dao.getAll()));
    }



}
