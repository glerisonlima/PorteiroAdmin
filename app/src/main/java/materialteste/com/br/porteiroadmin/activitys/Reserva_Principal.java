package materialteste.com.br.porteiroadmin.activitys;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import materialteste.com.br.porteiroadmin.R;
import materialteste.com.br.porteiroadmin.adapter.AdapterNotificacao;
import materialteste.com.br.porteiroadmin.adapter.AdapterReserva;
import materialteste.com.br.porteiroadmin.dao.notificacaoDAO;
import materialteste.com.br.porteiroadmin.dao.reservaDAO;

public class Reserva_Principal extends ActionBarActivity {

    private TextView txvNovaReserva;
    private ListView listViewRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_reserva__principal);

        txvNovaReserva = (TextView)findViewById(R.id.txvNovaReserva);
        listViewRes = (ListView)findViewById(R.id.listViewRes);

        reservaDAO dao = new reservaDAO(getBaseContext());
        listViewRes.setAdapter(new AdapterReserva(getBaseContext(),dao.getAll()));

        txvNovaReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ReservaNova.class));
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reserva__principal, menu);
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
