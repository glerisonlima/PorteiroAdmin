package materialteste.com.br.porteiroadmin.activitys;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import materialteste.com.br.porteiroadmin.R;

public class Cadastro_Princial extends ActionBarActivity {

    private TextView txvNovaPessoa;
    private TextView txvNovoVeiculo;
    private TextView txvListaPessoa;
    private TextView txvListaVeiculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_cadastro_principal);

       txvNovaPessoa = (TextView)findViewById(R.id.txvNova_Pessoa);
       txvNovoVeiculo = (TextView)findViewById(R.id.txvNovoVeiculo);
        txvListaPessoa = (TextView)findViewById(R.id.txvLista_Pessoa);
        txvListaVeiculo = (TextView)findViewById(R.id.txvListaVeiculo);

    txvNovoVeiculo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(getBaseContext(), CadastroVeiculo.class));
        }
    });
        txvNovaPessoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(getBaseContext(), CadastroPessoa.class));
            }
        });
        txvListaVeiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), Lista_Veiculos.class));
            }
        });
        txvListaPessoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), ListarPessoas.class));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastro__princial, menu);
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
