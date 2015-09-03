package materialteste.com.br.porteiroadmin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import materialteste.com.br.porteiroadmin.R;
import materialteste.com.br.porteiroadmin.vo.notificacaoVO;

/**
 * Created by glerison on 18/05/2015.
 */
public class AdapterNotificacao extends BaseAdapter {

    private Context ctx;
    private List<notificacaoVO> lista;

    public AdapterNotificacao(Context ctx, List<notificacaoVO> lista){
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
        notificacaoVO vo = (notificacaoVO)getItem(position);

        LayoutInflater layout = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layout.inflate(R.layout.lay_lista_notificacoes, null);

        TextView txvDataNot = (TextView)v.findViewById(R.id.txvDataNot);
        txvDataNot.setText("Data: "+vo.getData());
        TextView txvNotDescricao = (TextView)v.findViewById(R.id.txvNotDescricao);
        txvNotDescricao.setText(vo.getDescricao());
        return v;
    }
}
