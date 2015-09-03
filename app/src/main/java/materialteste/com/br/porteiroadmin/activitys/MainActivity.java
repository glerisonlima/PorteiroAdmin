package materialteste.com.br.porteiroadmin.activitys;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import materialteste.com.br.porteiroadmin.R;


public class MainActivity extends ActionBarActivity {

    private TextView txvPortaria;
    private TextView txvReserva;
    private TextView txvCadastro;
    private TextView txvNotificacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    txvCadastro = (TextView)findViewById(R.id.txvCadastro);
    txvNotificacoes = (TextView)findViewById(R.id.txvNotificacoes);
    txvPortaria = (TextView)findViewById(R.id.txvPortaria);
    txvReserva = (TextView)findViewById(R.id.txvReserva);

        txvPortaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"Portaria", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Portaria_Principal.class));
            }
        });
        txvReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"Reserva", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Reserva_Principal.class));
            }
        });
        txvNotificacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"Notificações", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getBaseContext(), Notificacoes_Principal.class));

            }
        });
        txvCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"Cadastro", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Cadastro_Princial.class));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
