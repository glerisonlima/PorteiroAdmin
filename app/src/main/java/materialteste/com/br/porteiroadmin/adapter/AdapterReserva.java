package materialteste.com.br.porteiroadmin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import materialteste.com.br.porteiroadmin.R;
import materialteste.com.br.porteiroadmin.dao.pessoaDAO;
import materialteste.com.br.porteiroadmin.vo.notificacaoVO;
import materialteste.com.br.porteiroadmin.vo.pessoaVO;
import materialteste.com.br.porteiroadmin.vo.reservaVO;

/**
 * Created by glerison on 25/05/2015.
 */
public class AdapterReserva extends BaseAdapter {
    private Context ctx;
    private List<reservaVO> lista;

    public AdapterReserva(Context ctx, List<reservaVO> lista){
        this.ctx=ctx;
        this.lista=lista;
    }
    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        reservaVO vo = (reservaVO)getItem(position);

        LayoutInflater layout = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layout.inflate(R.layout.lay_lista_reserva, null);
        /*
        pessoaDAO daopes = new pessoaDAO(ctx);
        daopes.getById(vo.getId_pessoa());
        pessoaVO vopes = new pessoaVO();
        */
        TextView txtNomeLisRes = (TextView)v.findViewById(R.id.txvNomeLisRes);
        txtNomeLisRes.setText("Nome: "+vo.getId_pessoa());
        TextView txtLocalLisRes = (TextView)v.findViewById(R.id.txvLocalLisRes);
        txtLocalLisRes.setText("Local: "+vo.getLocal());
        TextView txtDataLisRes = (TextView)v.findViewById(R.id.txvDataLisRes);
        txtDataLisRes.setText("Data: "+vo.getData());

        return v;

    }
}
