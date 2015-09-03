package materialteste.com.br.porteiroadmin.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import materialteste.com.br.porteiroadmin.vo.notificacaoVO;
import materialteste.com.br.porteiroadmin.vo.pessoaVO;


/**
 * Created by glerison on 14/05/2015.
 */
public class notificacaoDAO {

    private static String table_name = "notificacao";
    private static Context ctx;
    private static String[] columns = {"_id","id_pessoa","descricao","data_hora"};

    public notificacaoDAO(Context ctx) {
        this.ctx=ctx;
    }

    public boolean insert(notificacaoVO vo){
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();
        ContentValues ctv = new ContentValues();
        ctv.put("descricao", vo.getDescricao());
        ctv.put("data_hora", vo.getData());
        ctv.put("id_pessoa", vo.getId_pessoa());

        return (db.insert(table_name, null, ctv) > 0 );

    }

    public boolean delete(notificacaoVO vo){
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();
        return (db.delete(table_name, "_id=?", new String[] {vo.get_id().toString()}) > 0);
    }

    public boolean update(notificacaoVO vo){
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();

        ContentValues ctv = new ContentValues();
        ctv.put("descricao", vo.getDescricao());
        ctv.put("data", vo.getData());
        ctv.put("id_pessoa", vo.getId_pessoa());



        return (db.update(table_name, ctv, "_id=?", new String[] {vo.get_id().toString()}) > 0);
    }

    public notificacaoVO getById(Integer ID){
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();

        Cursor rs = db.query(table_name, columns, "_id=?", new String[] {ID.toString()}, null, null, null);

        notificacaoVO vo = null;

        if(rs.moveToFirst()){
            vo = new notificacaoVO();
            vo.set_id(Integer.parseInt(rs.getString(rs.getColumnIndex("_id"))));
            vo.setData(rs.getString(rs.getColumnIndex("data_hora")));
            vo.setDescricao(rs.getString(rs.getColumnIndex("descricao")));
            vo.setId_pessoa(Integer.parseInt(rs.getString(rs.getColumnIndex("id_pessoa"))));
        }
        return vo;
    }

    public List<notificacaoVO> getAll(){

        ArrayList<notificacaoVO> lista = new ArrayList<notificacaoVO>();
        try {
            SQLiteDatabase db = new BD(ctx).getWritableDatabase();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy 23:59");
            String data_atual = formato.format(new Date().getTime());

            Cursor rs = db.rawQuery("select * from notificacao where data_hora <'"+data_atual+"'", null);
            if(rs != null && rs.getCount() != 0){
                rs.moveToFirst();

                do{
                    notificacaoVO vo = new notificacaoVO();
                    vo.set_id(Integer.parseInt(rs.getString(rs.getColumnIndex("_id"))));
                    vo.setData(rs.getString(rs.getColumnIndex("data_hora")));
                    vo.setDescricao(rs.getString(rs.getColumnIndex("descricao")));
                    vo.setId_pessoa(Integer.parseInt(rs.getString(rs.getColumnIndex("id_pessoa"))));
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

    public List<pessoaVO> getNomeTodos(){

        ArrayList<pessoaVO> lista = new ArrayList<pessoaVO>();
        try {
            SQLiteDatabase db = new BD(ctx).getWritableDatabase();

            Cursor rs = db.rawQuery("select nome from pessoa ", null);
            if(rs != null && rs.getCount() != 0){
                rs.moveToFirst();

                do{
                    pessoaVO vo = new pessoaVO();
                    vo.setNome(rs.getString(rs.getColumnIndex("nome")));
                    lista.add(vo);
                }while (rs.moveToNext());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }
}
