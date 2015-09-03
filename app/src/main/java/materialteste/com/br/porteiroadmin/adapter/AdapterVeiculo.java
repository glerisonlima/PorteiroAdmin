package materialteste.com.br.porteiroadmin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import materialteste.com.br.porteiroadmin.R;
import materialteste.com.br.porteiroadmin.vo.veiculoVO;

/**
 * Created by glerison on 14/05/2015.
 */
public class AdapterVeiculo extends BaseAdapter {

    private Context ctx;
    private List<veiculoVO> lista;

    public AdapterVeiculo(Context ctx, List<veiculoVO> lista){
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
        veiculoVO vo = (veiculoVO)getItem(position);

        LayoutInflater layout = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layout.inflate(R.layout.lay_lista__veiculos, null);

        TextView txvPlaca = (TextView)v.findViewById(R.id.txvPlacaVeiLis);
        txvPlaca.setText("Placa: "+vo.getPlaca());
        TextView txvModelo = (TextView)v.findViewById(R.id.txvModeloVeiLis);
        txvModelo.setText("Modelo: "+vo.getModelo());
        TextView txvCor = (TextView)v.findViewById(R.id.txvCorVeiLis);
        txvCor.setText("Cor: "+vo.getCor());

        return v;
    }
}
