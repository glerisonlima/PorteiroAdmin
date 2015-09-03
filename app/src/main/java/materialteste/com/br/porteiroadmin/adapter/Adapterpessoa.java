package materialteste.com.br.porteiroadmin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import materialteste.com.br.porteiroadmin.R;
import materialteste.com.br.porteiroadmin.vo.pessoaVO;

/**
 * Created by glerison on 14/05/2015.
 */
public class Adapterpessoa extends BaseAdapter {

    private Context ctx;
    private List<pessoaVO> lista;

    public Adapterpessoa(Context ctx, List<pessoaVO> lista){
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
        pessoaVO vo = (pessoaVO)getItem(position);

        LayoutInflater layout = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layout.inflate(R.layout.lay_listar_pessoas, null);

        TextView txvNome = (TextView)v.findViewById(R.id.txvNomePesLista);
        txvNome.setText("Nome: "+vo.getNome());
        TextView txvBloco = (TextView)v.findViewById(R.id.txvBlocoPesLista);
        txvBloco.setText("Bloco: "+vo.getBloco_ap());

        return v;
    }
}
