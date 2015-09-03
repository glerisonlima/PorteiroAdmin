package materialteste.com.br.porteiroadmin.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import materialteste.com.br.porteiroadmin.vo.portariaVO;


/**
 * Created by glerison on 06/05/2015.
 */
public class portariaDAO {

    private static String table_name = "portaria";
    private static Context ctx;
    private static String[] columns = {"id","nome","tipo","observacao","data","hora","acompanhantes","status"};

    public portariaDAO(Context ctx) {
        this.ctx=ctx;
    }

    public boolean insert(portariaVO vo){
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();
        ContentValues ctv = new ContentValues();
        ctv.put("nome", vo.getNome());
        ctv.put("tipo", vo.getTipo());
        ctv.put("observacao", vo.getObservacao());
        ctv.put("data", vo.getData());
        ctv.put("hora", vo.getHora());
        ctv.put("acompanhantes", vo.getAcompanhantes());
        ctv.put("status", vo.getStatus());

        return (db.insert(table_name, null, ctv) > 0 );

    }

    public boolean delete(portariaVO vo){
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();
        return (db.delete(table_name, "id=?", new String[] {vo.getId().toString()}) > 0);
    }

    public boolean update(portariaVO vo){
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();

        ContentValues ctv = new ContentValues();
        ctv.put("nome", vo.getNome());
        ctv.put("tipo", vo.getTipo());
        ctv.put("observacao", vo.getObservacao());
        ctv.put("data", vo.getData());
        ctv.put("hora", vo.getHora());
        ctv.put("acompanhates", vo.getAcompanhantes());
        ctv.put("status", vo.getStatus());

        return (db.update(table_name, ctv, "id=?", new String[] {vo.getId().toString()}) > 0);
    }

    public portariaVO getById(Integer ID){
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();

        Cursor rs = db.query(table_name, columns, "id=?", new String[] {ID.toString()}, null, null, null);

        portariaVO vo = null;

        if(rs.moveToFirst()){
            vo = new portariaVO();
            vo.setId(rs.getInt(rs.getColumnIndex("id")));
            vo.setNome(rs.getString(rs.getColumnIndex("nome")));
            vo.setObservacao(rs.getString(rs.getColumnIndex("observacao")));
            vo.setData(rs.getString(rs.getColumnIndex("data")));
            vo.setHora(rs.getString(rs.getColumnIndex("hora")));
            vo.setAcompanhantes(rs.getInt(rs.getColumnIndex("acompanhantes")));
            vo.setTipo(rs.getString(rs.getColumnIndex("tipo")));
            vo.setStatus(rs.getInt(rs.getColumnIndex("status")));
        }
        return vo;
    }

    public List<portariaVO> getAll(){

        ArrayList<portariaVO> lista = new ArrayList<portariaVO>();
        try {
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();

        Cursor rs = db.rawQuery("select * from portaria", null);
        if(rs != null && rs.getCount() != 0){
            rs.moveToFirst();

            do{
                portariaVO vo = new portariaVO();

                vo.setId(Integer.parseInt(rs.getString(rs.getColumnIndex("id"))));
                vo.setTipo(rs.getString(rs.getColumnIndex("tipo")));
                vo.setNome(rs.getString(rs.getColumnIndex("nome")));
                vo.setObservacao(rs.getString(rs.getColumnIndex("observacao")));
                vo.setData(rs.getString(rs.getColumnIndex("data")));
                vo.setHora(rs.getString(rs.getColumnIndex("hora")));
                vo.setAcompanhantes(Integer.valueOf(rs.getString(rs.getColumnIndex("acompanhantes"))));
                vo.setStatus(Integer.parseInt(rs.getString(rs.getColumnIndex("status"))));

                lista.add(vo);
            }while (rs.moveToNext());
        }


        }catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }



}
