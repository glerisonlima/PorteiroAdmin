package materialteste.com.br.porteiroadmin.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import materialteste.com.br.porteiroadmin.vo.notificacaoVO;
import materialteste.com.br.porteiroadmin.vo.pessoaVO;
import materialteste.com.br.porteiroadmin.vo.reservaVO;

/**
 * Created by glerison on 23/05/2015.
 */
public class reservaDAO {

    private static String table_name = "reservas";
    private static Context ctx;
    private static String[] columns = {"id","local","data","id_pessoa","periodo"};

    public reservaDAO(Context ctx) {
        this.ctx=ctx;
    }

    public boolean insert(reservaVO vo){
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();
        ContentValues ctv = new ContentValues();
        ctv.put("local", vo.getLocal());
        ctv.put("data", vo.getData().toString());
        ctv.put("id_pessoa", vo.getId_pessoa());
        ctv.put("periodo", vo.getPeriodo());

        return (db.insert(table_name, null, ctv) > 0 );

    }

    public boolean delete(reservaVO vo){
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();
        return (db.delete(table_name, "id=?", new String[] {vo.getId().toString()}) > 0);
    }

    public boolean update(reservaVO vo){
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();

        ContentValues ctv = new ContentValues();
        ctv.put("local", vo.getLocal());
        ctv.put("data", Date.parse(vo.getData().toString()));
        ctv.put("id_pessoa", vo.getId_pessoa());
        ctv.put("periodo", vo.getPeriodo());



        return (db.update(table_name, ctv, "id=?", new String[] {vo.getId().toString()}) > 0);
    }

    public reservaVO getById(Integer ID){
        SQLiteDatabase db = new BD(ctx).getWritableDatabase();

        Cursor rs = db.query(table_name, columns, "id=?", new String[] {ID.toString()}, null, null, null);

        reservaVO vo = null;
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        if(rs.moveToFirst()){
            vo = new reservaVO();
            try {
                Date data = f.parse(rs.getString(rs.getColumnIndex("data")));

            vo.setId(Integer.parseInt(rs.getString(rs.getColumnIndex("id"))));
            vo.setData(data);
            vo.setId_pessoa(Integer.parseInt(rs.getString(rs.getColumnIndex("id_pessoa"))));
            vo.setLocal((rs.getString(rs.getColumnIndex("local"))));
            vo.setPeriodo(Integer.parseInt(rs.getString(rs.getColumnIndex("periodo"))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return vo;
    }

    public List<reservaVO> getAll(){
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");    
        ArrayList<reservaVO> lista = new ArrayList<reservaVO>();
        try {
            SQLiteDatabase db = new BD(ctx).getWritableDatabase();
            String data_atual = f.format(new Date().getTime());
            Cursor rs = db.rawQuery("select * from reservas where data >='"+data_atual+"'", null);
            if(rs != null && rs.getCount() != 0){
                rs.moveToFirst();

                do{
                    reservaVO vo = new reservaVO();
                    try {
                        Date data = f.parse(rs.getString(rs.getColumnIndex("data")));

                        vo.setId(Integer.parseInt(rs.getString(rs.getColumnIndex("id"))));
                        vo.setData(data);
                        vo.setId_pessoa(Integer.parseInt(rs.getString(rs.getColumnIndex("id_pessoa"))));
                        vo.setLocal((rs.getString(rs.getColumnIndex("local"))));
                        vo.setPeriodo(Integer.parseInt(rs.getString(rs.getColumnIndex("periodo"))));
                        lista.add(vo);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
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
}
