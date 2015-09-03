package materialteste.com.br.porteiroadmin.activitys;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import materialteste.com.br.porteiroadmin.R;
import materialteste.com.br.porteiroadmin.dao.portariaDAO;
import materialteste.com.br.porteiroadmin.vo.portariaVO;

public class PortariaDeletar extends Activity {

    private int ID = 0;
    private Button btnDeletarVis;
    private Button btnEncerrarVis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_portaria_deletar);
        Intent it = getIntent();
        ID = it.getIntExtra("codigo", 1);

        final portariaDAO dao = new portariaDAO(getBaseContext());
        final portariaVO vo = dao.getById(ID);
        btnDeletarVis = (Button)findViewById(R.id.btnDeletarVis);
        btnEncerrarVis = (Button)findViewById(R.id.btnEncerrarVis);


        btnDeletarVis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder msg = new AlertDialog.Builder(PortariaDeletar.this);
                msg.setMessage("Deseja excluir esta visita ?");
                msg.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (dao.delete(vo)){
                            Toast.makeText(getBaseContext(), "Sucesso!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                });
                msg.setNegativeButton("NÂO", null);
                msg.show();
                }
        });

        btnEncerrarVis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder msg = new AlertDialog.Builder(PortariaDeletar.this);
                msg.setMessage("Deseja encerrar esta visita ?");
                msg.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (dao.delete(vo)){
                            Toast.makeText(getBaseContext(), "Sucesso!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                });
                msg.setNegativeButton("NÂO", null);
                msg.show();

            }
        });
    }



}
