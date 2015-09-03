package materialteste.com.br.porteiroadmin.activitys;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import materialteste.com.br.porteiroadmin.R;

public class LoginSistema extends ActionBarActivity {

    private EditText txtlogin;
    private EditText txtsenha;
    private Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_login_sistema);

        txtlogin = (EditText)findViewById(R.id.txtLogin);
        txtsenha = (EditText)findViewById(R.id.txtSenha);
        btnlogin = (Button)findViewById(R.id.btnLogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((txtlogin.getText().toString().equals("admin")) && (txtsenha.getText().toString().equals("1234"))){
                    startActivity(new Intent(getBaseContext(), MainActivity.class));
                    finish();
                }else{
                    Toast.makeText(getBaseContext(),"Login ou Senha invalido", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_sistema, menu);
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
