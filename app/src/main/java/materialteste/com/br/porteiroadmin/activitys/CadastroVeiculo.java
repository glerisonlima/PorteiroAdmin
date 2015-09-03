package materialteste.com.br.porteiroadmin.activitys;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import materialteste.com.br.porteiroadmin.R;
import materialteste.com.br.porteiroadmin.dao.pessoaDAO;
import materialteste.com.br.porteiroadmin.dao.veiculoDAO;
import materialteste.com.br.porteiroadmin.vo.pessoaVO;
import materialteste.com.br.porteiroadmin.vo.veiculoVO;

public class CadastroVeiculo extends ActionBarActivity {

    private Spinner spProprietario;
    private Button btnCadVei;
    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtCor;
    private EditText txtPlaca;
    private RadioGroup rgTipo;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_cadastro_veiculo);

        spProprietario = (Spinner)findViewById(R.id.spProprietario);
        btnCadVei = (Button)findViewById(R.id.btnCadVei);
        txtMarca = (EditText)findViewById(R.id.txtMarca);
        txtCor = (EditText)findViewById(R.id.txtCor);
        txtModelo = (EditText)findViewById(R.id.txtModelo);
        txtPlaca = (EditText)findViewById(R.id.txtPlaca);
        rgTipo = (RadioGroup)findViewById(R.id.rgTipo);

        pessoaDAO dao = new pessoaDAO(getBaseContext());
        List<pessoaVO> listaNomes = dao.getNome();
        List<String> dados = new ArrayList<String>();
        for (pessoaVO dado : listaNomes){
            dados.add(dado.getNome());
        }
        spProprietario.setAdapter( new ArrayAdapter<String>(this, R.layout.spinner_item, dados));

        btnCadVei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                veiculoDAO daoVei = new veiculoDAO(getBaseContext());
                veiculoVO vo = new veiculoVO();

                String nomeProp = spProprietario.getSelectedItem().toString();
                int idprop = daoVei.getidentificador(nomeProp);

                String tipo = null;
                if (rgTipo.getCheckedRadioButtonId()== R.id.rbCarro){
                    tipo = "Carro";
                }else if(rgTipo.getCheckedRadioButtonId()==R.id.rbMoto){
                    tipo = "Moto";
                }

                vo.setPlaca(txtPlaca.getText().toString());
                vo.setTipo(tipo);
                vo.setId_proprietario(idprop);
                vo.setModelo(txtModelo.getText().toString());
                vo.setMarca(txtMarca.getText().toString());
                vo.setCor(txtCor.getText().toString());

                if(daoVei.insert(vo)){
                    Toast.makeText(getBaseContext(), "Sucesso!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastro_veiculo, menu);
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
