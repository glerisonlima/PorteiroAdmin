package materialteste.com.br.porteiroadmin.activitys;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import materialteste.com.br.porteiroadmin.R;
import materialteste.com.br.porteiroadmin.dao.notificacaoDAO;
import materialteste.com.br.porteiroadmin.dao.pessoaDAO;
import materialteste.com.br.porteiroadmin.dao.reservaDAO;
import materialteste.com.br.porteiroadmin.vo.pessoaVO;
import materialteste.com.br.porteiroadmin.vo.reservaVO;

public class ReservaNova extends ActionBarActivity {

    private DatePicker dataRes;
    private Button btnCadastrarRes;
    private Spinner spPeriodoRes;
    private Spinner spLocalRes;
    private Spinner spNomeRes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_reserva_nova);

        dataRes = (DatePicker)findViewById(R.id.dataRes);
        btnCadastrarRes=(Button)findViewById(R.id.btnCadastrarRes);
        spPeriodoRes = (Spinner)findViewById(R.id.spPeriodoRes);
        spLocalRes = (Spinner)findViewById(R.id.spLocalRes);
        spNomeRes = (Spinner)findViewById(R.id.spNomeRes);

        final int dia = dataRes.getDayOfMonth();
        final int mes = dataRes.getMonth()+1;
        final int ano = dataRes.getYear();
        //Preencher lista de Pessoas
        notificacaoDAO daoPessoa = new notificacaoDAO(getBaseContext());
        List<pessoaVO> listaNomes = daoPessoa.getNomeTodos();
        List<String> dados = new ArrayList<String>();
        for (pessoaVO dado : listaNomes){
            dados.add(dado.getNome());
        }
        spNomeRes.setAdapter( new ArrayAdapter<String>(this, R.layout.spinner_item, dados));
        //Preencher lista Locais
        ArrayAdapter adapterLocal = ArrayAdapter.createFromResource(this,R.array.spLocais, R.layout.spinner_item);
        spLocalRes.setAdapter(adapterLocal);
        //Preencher lista Periodo
        ArrayAdapter adapterPeriodo = ArrayAdapter.createFromResource(this,R.array.spPeriodo, R.layout.spinner_item);
        spPeriodoRes.setAdapter(adapterPeriodo);

        btnCadastrarRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reservaVO vo = new reservaVO();
                int periodo=0;
                String periodoSpinner = spPeriodoRes.getSelectedItem().toString();
                if(periodoSpinner.equals("Manhã")){
                    periodo=1;
                }
                else if(periodoSpinner.equals("Tarde")){
                    periodo=2;
                }
                else if(periodoSpinner.equals("Noite")){
                    periodo=3;
                }

                pessoaDAO daoPessoa = new pessoaDAO(getBaseContext());
                String itemSelecionado = spNomeRes.getSelectedItem().toString();
                int idItem = daoPessoa.getidentificador(itemSelecionado);

                vo.setPeriodo(periodo);
                vo.setLocal(spLocalRes.getSelectedItem().toString());
                vo.setData(new Date(ano,mes,dia));
                vo.setId_pessoa(idItem);

                reservaDAO dao = new reservaDAO(getBaseContext());
                if(dao.insert(vo)){
                    Toast.makeText(getBaseContext(), "Sucesso!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reserva_nova, menu);
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
