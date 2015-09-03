package materialteste.com.br.porteiroadmin.activitys;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import materialteste.com.br.porteiroadmin.R;
import materialteste.com.br.porteiroadmin.adapter.AdapterNotificacao;
import materialteste.com.br.porteiroadmin.dao.notificacaoDAO;

public class Notificacoes_Principal extends ActionBarActivity {

    private TextView txvNovaNoticacao;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_notificacoes__principal);

        txvNovaNoticacao = (TextView)findViewById(R.id.txvNovaNoticacao);
        lv = (ListView)findViewById(R.id.listViewNot);
        notificacaoDAO dao = new notificacaoDAO(getBaseContext());
        lv.setAdapter(new AdapterNotificacao(getBaseContext(),dao.getAll()));
        txvNovaNoticacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), NotificacaoNova.class));
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notificacoes__principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
