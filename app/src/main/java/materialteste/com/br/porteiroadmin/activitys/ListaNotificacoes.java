package materialteste.com.br.porteiroadmin.activitys;

import android.app.ListActivity;
import android.os.Bundle;
import materialteste.com.br.porteiroadmin.adapter.AdapterNotificacao;
import materialteste.com.br.porteiroadmin.dao.notificacaoDAO;


public class ListaNotificacoes extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.lay_lista_notificacoes);
    }

    @Override
    public void onResume(){
        super.onResume();
        notificacaoDAO dao = new notificacaoDAO(getBaseContext());
        setListAdapter(new AdapterNotificacao(getBaseContext(), dao.getAll()));
    }



}
