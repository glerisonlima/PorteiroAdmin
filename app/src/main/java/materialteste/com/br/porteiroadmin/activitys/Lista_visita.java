package materialteste.com.br.porteiroadmin.activitys;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import materialteste.com.br.porteiroadmin.adapter.Adapterportaria;
import materialteste.com.br.porteiroadmin.dao.portariaDAO;
import materialteste.com.br.porteiroadmin.vo.portariaVO;


public class Lista_visita extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        portariaVO vo = (portariaVO)l.getAdapter().getItem(position);
        Toast.makeText(getBaseContext(), vo.getId().toString(), Toast.LENGTH_SHORT).show();
        startActivity(new Intent("EdicaoVisita").putExtra("codigo", vo.getId()));

    }

    @Override
    public void onResume(){
        super.onResume();
        portariaDAO dao = new portariaDAO(getBaseContext());
        setListAdapter(new Adapterportaria(getBaseContext(),dao.getAll()));
    }
}
