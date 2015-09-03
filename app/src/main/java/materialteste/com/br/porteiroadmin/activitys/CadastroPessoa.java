package materialteste.com.br.porteiroadmin.activitys;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import materialteste.com.br.porteiroadmin.R;
import materialteste.com.br.porteiroadmin.dao.pessoaDAO;
import materialteste.com.br.porteiroadmin.vo.pessoaVO;

public class CadastroPessoa extends ActionBarActivity {

    private EditText txtNomePes;
    private EditText txtBloco_ap;
    private RadioGroup rgSexo;
    private RadioGroup rgStatus;
    private RadioGroup rgVeiculo;
    private Button btnCadPes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_cadastro__pessoa);

        txtBloco_ap = (EditText)findViewById(R.id.txtBloco_ap);
        txtNomePes = (EditText)findViewById(R.id.txtNomePes);
        rgSexo = (RadioGroup)findViewById(R.id.rgSexo);
        rgStatus = (RadioGroup)findViewById(R.id.rgstatus);
        rgVeiculo = (RadioGroup)findViewById(R.id.rgVeiculo);
        btnCadPes = (Button)findViewById(R.id.btnCadPes);

        btnCadPes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String status=null;
                if (rgStatus.getCheckedRadioButtonId()== R.id.rbFuncionario){
                    status = "F";
                }else if(rgStatus.getCheckedRadioButtonId()==R.id.rbMorador){
                    status = "M";
                }
                String sexo=null;
                if(rgSexo.getCheckedRadioButtonId()==R.id.rbMasculino){
                    sexo = "M";
                }else if(rgSexo.getCheckedRadioButtonId()==R.id.rbFeminino){
                    sexo = "F";
                }
                String veiculo=null;
                if(rgVeiculo.getCheckedRadioButtonId()==R.id.rbSim){
                    veiculo = "S";
                }else if(rgVeiculo.getCheckedRadioButtonId()==R.id.rbNao){
                    veiculo = "N";
                }
                pessoaVO vo = new pessoaVO();
                vo.setNome(txtNomePes.getText().toString());
                vo.setBloco_ap(txtBloco_ap.getText().toString());
                vo.setVeiculo(veiculo);
                vo.setStatus(status);
                vo.setSexo(sexo);

                pessoaDAO dao = new pessoaDAO(getBaseContext());
                if(dao.insert(vo)){
                    Toast.makeText(getBaseContext(), vo.getNome()+" Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                    finish();
                }


            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastro_pessoa, menu);
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
