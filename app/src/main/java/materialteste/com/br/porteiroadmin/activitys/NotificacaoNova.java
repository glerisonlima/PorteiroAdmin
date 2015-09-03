package materialteste.com.br.porteiroadmin.activitys;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import materialteste.com.br.porteiroadmin.R;
import materialteste.com.br.porteiroadmin.dao.notificacaoDAO;
import materialteste.com.br.porteiroadmin.dao.pessoaDAO;
import materialteste.com.br.porteiroadmin.vo.notificacaoVO;
import materialteste.com.br.porteiroadmin.vo.pessoaVO;

public class NotificacaoNova extends ActionBarActivity {

    private EditText txvNotificacao;
    private Button btnCadNot;
    private Spinner spPesNotificacao;
    private Date data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_notificacao_nova);

        txvNotificacao = (EditText)findViewById(R.id.txvNotificacao);
        btnCadNot = (Button)findViewById(R.id.btnCadNot);
        spPesNotificacao = (Spinner)findViewById(R.id.spPesNotificacao);


        notificacaoDAO daoPessoa = new notificacaoDAO(getBaseContext());
        List<pessoaVO> listaNomes = daoPessoa.getNomeTodos();
        List<String> dados = new ArrayList<String>();
        for (pessoaVO dado : listaNomes){
            dados.add(dado.getNome());
        }
        spPesNotificacao.setAdapter( new ArrayAdapter<String>(this, R.layout.spinner_item, dados));

        btnCadNot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoaDAO dao = new pessoaDAO(getBaseContext());
                String itemSelecionado = spPesNotificacao.getSelectedItem().toString();
                int idItem = dao.getidentificador(itemSelecionado);

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                notificacaoVO vo = new notificacaoVO();
                vo.setData(formato.format(new Date().getTime()));
                vo.setDescricao(txvNotificacao.getText().toString());
                vo.setId_pessoa(idItem);

                notificacaoDAO daoNot = new notificacaoDAO(getBaseContext());
                if(daoNot.insert(vo)) {
                    Toast.makeText(getBaseContext(), "Sucesso !" , Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notificacao_nova, menu);
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
