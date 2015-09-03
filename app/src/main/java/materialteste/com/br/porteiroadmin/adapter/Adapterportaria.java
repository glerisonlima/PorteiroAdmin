package materialteste.com.br.porteiroadmin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import materialteste.com.br.porteiroadmin.R;
import materialteste.com.br.porteiroadmin.vo.portariaVO;

/**
 * Created by glerison on 12/05/2015.
 */
public class Adapterportaria extends BaseAdapter {
    private Context ctx;
    private List<portariaVO> lista;

    public Adapterportaria(Context ctx, List<portariaVO> lista){
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
    public View getView(int position, View view, ViewGroup viewGroup) {
        portariaVO vo = (portariaVO)getItem(position);

        LayoutInflater layout = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layout.inflate(R.layout.lay_portaria_lista, null);

        TextView txtData = (TextView) v.findViewById(R.id.textViewId);
        txtData.setText("Data: "+vo.getData());
        TextView txtNome = (TextView) v.findViewById(R.id.textViewNome);
        txtNome.setText("Visitante: "+vo.getNome());

        return v;
    }
}
