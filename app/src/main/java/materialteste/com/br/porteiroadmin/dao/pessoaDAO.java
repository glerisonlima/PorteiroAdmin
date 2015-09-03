package materialteste.com.br.porteiroadmin.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

import materialteste.com.br.porteiroadmin.vo.pessoaVO;


/**
 * Created by glerison on 13/05/2015.
 */
public class pessoaDAO {

    private static String table_name = "pessoa";
    private static Context ctx;
    private static String[] columns = {"_id","nome","bloco_ap","sexo","status","veiculo"};

    public pessoaDAO(Context ctx) {
        this.ctx=ctx;
    }

    public boolean insert(pessoaVO vo){
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();
        ContentValues ctv = new ContentValues();
        ctv.put("nome", vo.getNome());
        ctv.put("bloco_ap", vo.getBloco_ap());
        ctv.put("sexo", vo.getSexo());
        ctv.put("status", vo.getStatus());
        ctv.put("veiculo", vo.getVeiculo());

        return (db.insert(table_name, null, ctv) > 0 );

    }

    public boolean delete(pessoaVO vo){
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();
        return (db.delete(table_name, "_id=?", new String[] {vo.get_id().toString()}) > 0);
    }

    public boolean update(pessoaVO vo){
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();

        ContentValues ctv = new ContentValues();
        ctv.put("nome", vo.getNome());
        ctv.put("bloco_ap", vo.getBloco_ap());
        ctv.put("sexo", vo.getSexo());
        ctv.put("status", vo.getStatus());
        ctv.put("veiculo", vo.getVeiculo());

        return (db.update(table_name, ctv, "_id=?", new String[] {vo.get_id().toString()}) > 0);
    }

    public pessoaVO getById(Integer ID){
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();

        Cursor rs = db.query(table_name, columns, "_id=?", new String[] {ID.toString()}, null, null, null);

        pessoaVO vo = null;

        if(rs.moveToFirst()){
            vo = new pessoaVO();
            vo.set_id(rs.getInt(rs.getColumnIndex("_id")));
            vo.setNome(rs.getString(rs.getColumnIndex("nome")));
            vo.setBloco_ap(rs.getString(rs.getColumnIndex("bloco_ap")));
            vo.setSexo(rs.getString(rs.getColumnIndex("sexo")));
            vo.setStatus(rs.getString(rs.getColumnIndex("status")));
            vo.setVeiculo(rs.getString(rs.getColumnIndex("veiculo")));

        }
        return vo;
    }

    public List<pessoaVO> getAll(){

        ArrayList<pessoaVO> lista = new ArrayList<pessoaVO>();
        try {
            SQLiteDatabase db = new BD(ctx).getWritableDatabase();

            Cursor rs = db.rawQuery("select * from pessoa", null);
            if(rs != null && rs.getCount() != 0){
                rs.moveToFirst();

                do{
                    pessoaVO vo = new pessoaVO();

                    vo.set_id(rs.getInt(rs.getColumnIndex("_id")));
                    vo.setNome(rs.getString(rs.getColumnIndex("nome")));
                    vo.setBloco_ap(rs.getString(rs.getColumnIndex("bloco_ap")));
                    vo.setSexo(rs.getString(rs.getColumnIndex("sexo")));
                    vo.setStatus(rs.getString(rs.getColumnIndex("status")));
                    vo.setVeiculo(rs.getString(rs.getColumnIndex("veiculo")));

                    lista.add(vo);
                }while (rs.moveToNext());
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    public List<pessoaVO> getNome(){

        ArrayList<pessoaVO> lista = new ArrayList<pessoaVO>();
        try {
            SQLiteDatabase db = new BD(ctx).getWritableDatabase();

            Cursor rs = db.rawQuery("select nome from pessoa where veiculo = 'S'", null);
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

    public int getidentificador(String nome){
        int retorno = 0;
        try {
            SQLiteDatabase db = new BD(ctx).getWritableDatabase();

            Cursor rs = db.rawQuery("select _id from pessoa where nome ='"+nome+"'", null);
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
