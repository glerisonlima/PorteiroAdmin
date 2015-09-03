package materialteste.com.br.porteiroadmin.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import materialteste.com.br.porteiroadmin.vo.pessoaVO;
import materialteste.com.br.porteiroadmin.vo.veiculoVO;

/**
 * Created by glerison on 14/05/2015.
 */
public class veiculoDAO {

    private static String table_name = "veiculo";
    private static Context ctx;
    private static String[] columns = {"_id","id_proprietario","tipo","marca","modelo","cor","placa"};

    public veiculoDAO(Context ctx) {
        this.ctx=ctx;
    }


    public boolean insert(veiculoVO vo){
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();
        ContentValues ctv = new ContentValues();
        ctv.put("id_proprietario", vo.getId_proprietario());
        ctv.put("cor", vo.getCor());
        ctv.put("marca", vo.getMarca());
        ctv.put("modelo", vo.getModelo());
        ctv.put("placa", vo.getPlaca());
        ctv.put("tipo", vo.getTipo());

        return (db.insert(table_name, null, ctv) > 0 );

    }

    public boolean delete(veiculoVO vo){
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();
        return (db.delete(table_name, "_id=?", new String[] {vo.get_id().toString()}) > 0);
    }

    public boolean update(veiculoVO vo){
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();

        ContentValues ctv = new ContentValues();
        ctv.put("id_proprietario", vo.getId_proprietario());
        ctv.put("cor", vo.getCor());
        ctv.put("marca", vo.getMarca());
        ctv.put("modelo", vo.getModelo());
        ctv.put("veiculo", vo.getPlaca());
        ctv.put("tipo", vo.getTipo());

        return (db.update(table_name, ctv, "_id=?", new String[] {vo.get_id().toString()}) > 0);
    }

    public veiculoVO getById(Integer ID){
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();

        Cursor rs = db.query(table_name, columns, "_id=?", new String[] {ID.toString()}, null, null, null);

        veiculoVO vo = null;

        if(rs.moveToFirst()){
            vo = new veiculoVO();
            vo.set_id(rs.getInt(rs.getColumnIndex("_id")));
            vo.setId_proprietario(rs.getInt(rs.getColumnIndex("id_proprietario")));
            vo.setCor(rs.getString(rs.getColumnIndex("cor")));
            vo.setMarca(rs.getString(rs.getColumnIndex("marca")));
            vo.setModelo(rs.getString(rs.getColumnIndex("modelo")));
            vo.setTipo(rs.getString(rs.getColumnIndex("tipo")));
            vo.setPlaca(rs.getString(rs.getColumnIndex("placa")));

        }
        return vo;
    }

    public List<veiculoVO> getAll(){

        ArrayList<veiculoVO> lista = new ArrayList<veiculoVO>();
        try {
            SQLiteDatabase db = new BD(ctx).getWritableDatabase();

            Cursor rs = db.rawQuery("select * from veiculo", null);
            if(rs != null && rs.getCount() != 0){
                rs.moveToFirst();

                do{
                    veiculoVO vo = new veiculoVO();

                    vo.set_id(rs.getInt(rs.getColumnIndex("_id")));
                    vo.setId_proprietario(rs.getInt(rs.getColumnIndex("id_proprietario")));
                    vo.setCor(rs.getString(rs.getColumnIndex("cor")));
                    vo.setMarca(rs.getString(rs.getColumnIndex("marca")));
                    vo.setModelo(rs.getString(rs.getColumnIndex("modelo")));
                    vo.setTipo(rs.getString(rs.getColumnIndex("tipo")));
                    vo.setPlaca(rs.getString(rs.getColumnIndex("placa")));

                    lista.add(vo);
                }while (rs.moveToNext());
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    public int getidentificador(String nome){
        int retorno = 0;
        try {
            SQLiteDatabase db = new BD(ctx).getWritableDatabase();

            Cursor rs = db.rawQuery("select _id from pessoa where nome ="+nome, null);
            if(rs != null && rs.getCount() != 0){
                rs.moveToFirst();

                do{
                    retorno = (rs.getInt(rs.getColumnIndex("_id")));
                }while (rs.moveToNext());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return retorno;
    }

}
