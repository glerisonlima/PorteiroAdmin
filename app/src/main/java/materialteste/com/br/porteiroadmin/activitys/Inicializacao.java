package materialteste.com.br.porteiroadmin.activitys;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Timer;
import java.util.TimerTask;

import materialteste.com.br.porteiroadmin.R;

public class Inicializacao extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_inicializacao);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent intent = new Intent();
                intent.setClass(Inicializacao.this, LoginSistema.class);
                startActivity(intent);
            }
        }, 2000);
    }



}
