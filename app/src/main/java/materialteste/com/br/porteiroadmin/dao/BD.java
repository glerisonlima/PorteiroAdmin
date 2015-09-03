package materialteste.com.br.porteiroadmin.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by glerison on 05/05/2015.
 */
public class BD extends SQLiteOpenHelper {

    private static String dbName = "porteiro.db";
    private static String sqlportaria = "CREATE TABLE IF NOT EXISTS[portaria] ([id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,[tipo] VARCHAR(20) NOT NULL,[nome] VARCHAR(100),[observacao] VARCHAR(100),[data] VARCHAR(20),[hora] VARCHAR(10),[acompanhantes] INTEGER, [status] INTEGER);";
    private static String sqlpessoa = "CREATE TABLE IF NOT EXISTS[pessoa] ([_id] INTEGER PRIMARY KEY AUTOINCREMENT, [nome] VARCHAR(50), [bloco_ap] VARCHAR(20), [sexo] CHAR(1), [status] CHAR(1), [veiculo] CHAR(1));";
    private static String sqlveiculo = "CREATE TABLE IF NOT EXISTS[veiculo] ([_id] INTEGER PRIMARY KEY AUTOINCREMENT, [tipo] VARCHAR(10), [marca] VARCHAR(20), [modelo] VARCHAR(20), [cor] VARCHAR(20), [placa] VARCHAR(10), [id_proprietario] INTEGER CONSTRAINT [fk_proprietario] REFERENCES [pessoaVO]([_id]));";
    private static String sqlnotificacao = "CREATE TABLE IF NOT EXISTS[notificacao] ([_id] INTEGER PRIMARY KEY AUTOINCREMENT, [id_pessoa] INTEGER CONSTRAINT [fk_pessoa] REFERENCES [pessoaVO]([_id]), [descricao] VARCHAR(50), [data_hora] DATE);";
    private static String sqlreserva = "CREATE TABLE IF NOT EXISTS[reservas] ([id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,[local] VARCHAR(20),[data] DATE,[id_pessoa] INTEGER CONSTRAINT [fk_pessoa_reserva] REFERENCES [pessoa]([_id]),[periodo] INTEGER);";
    private static int version = 1;

    public BD(Context ctx) {
        super(ctx, dbName, null, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlportaria);
        db.execSQL(sqlpessoa);
        db.execSQL(sqlnotificacao);
        db.execSQL(sqlveiculo);
        db.execSQL(sqlreserva);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
