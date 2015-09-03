package materialteste.com.br.porteiroadmin.activitys;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import materialteste.com.br.porteiroadmin.R;
import materialteste.com.br.porteiroadmin.dao.portariaDAO;
import materialteste.com.br.porteiroadmin.vo.portariaVO;

public class Portaria_NovaVisita extends ActionBarActivity {

    private TextView txtNome;
    private TextView txtObservacao;
    private TextView txtData;
    private TextView txtHora;
    private Spinner spTipo;
    private Spinner spAcompanhantes;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.portaria_nova_visita);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spTipoVis, R.layout.spinner_item);
        spTipo = (Spinner) findViewById(R.id.spTipoVis);
        spTipo.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.spAcompanhantesVis, R.layout.spinner_item);
        spAcompanhantes = (Spinner) findViewById(R.id.spAcompanhantesVis);
        spAcompanhantes.setAdapter(adapter2);

        txtData = (TextView)findViewById(R.id.txtDataVis);
        txtHora = (TextView)findViewById(R.id.txtHoraVis);
        txtNome = (TextView)findViewById(R.id.txtNomeVis);
        txtObservacao = (TextView)findViewById(R.id.txtObservacaoVis);
        spAcompanhantes = (Spinner)findViewById(R.id.spAcompanhantesVis);
        spTipo = (Spinner)findViewById(R.id.spTipoVis);
        btnEnviar = (Button) findViewById(R.id.btnEnviarVis);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                portariaVO vo = new portariaVO();
                vo.setTipo(spTipo.getSelectedItem().toString());
                vo.setNome(txtNome.getText().toString());
                vo.setData(txtData.getText().toString());
                vo.setHora(txtHora.getText().toString());
                vo.setAcompanhantes(Integer.parseInt(spAcompanhantes.getSelectedItem().toString()));
                vo.setObservacao(txtObservacao.getText().toString());
                vo.setStatus(1);

                portariaDAO dao = new portariaDAO(getBaseContext());
                if(dao.insert(vo)){
                    Toast.makeText(getBaseContext(), txtNome.getText().toString() + " Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_portaria__nova_visita, menu);
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
