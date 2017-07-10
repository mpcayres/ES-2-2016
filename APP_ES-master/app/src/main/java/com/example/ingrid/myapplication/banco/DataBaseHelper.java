package com.example.ingrid.myapplication.banco;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.database.Cursor;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


/**
 * Created by ingrid on 03/11/16.
 Referencia: https://guides.codepath.com/android/Local-Databases-with-SQLiteOpenHelper
 */
public class DataBaseHelper extends SQLiteOpenHelper {
        // Database Info
        private static final String TAG = SQLiteDatabase.class.getSimpleName();
        private static DataBaseHelper mInstance = null;

        private static final String DATABASE_NAME = "gerTemp";
        private static final int DATABASE_VERSION = 3;

        // Table Names
        private static final String TABLE_USUARIO = "\"USUARIO\"";
        private static final String TABLE_PERIODICO = "\"PERIODICO\"";
        private static final String TABLE_UNICO = "\"UNICO\"";
        private static final String TABLE_RECORRENTE = "\"RECORRENTE\"";

        // User Table Columns
        private static final String KEY_USER_ID = "\"id\"";
        private static final String KEY_LOGIN = "\"login\"";
        private static final String KEY_SENHA = "\"senha\"";

        // Recorrente Table Columns
        private static final String KEY_RECORRENTE_ID = "\"id\"";
        private static final String KEY_RECORRENTE_NOME = "\"nome\"";
        private static final String KEY_RECORRENTE_ANOTACAO = "\"anotacao\"";
        private static final String KEY_RECORRENTE_HORA_FINAL = "\"horaFinal\"";
        private static final String KEY_RECORRENTE_PROGRESSAO = "\"progressao\"";
        private static final String KEY_RECORRENTE_ITENS_FEITOS = "\"itensFeitos\"";
        private static final String KEY_RECORRENTE_TOTAL_ITENS = "\"totalItens\"";
        private static final String KEY_RECORRENTE_HORAS_DIA = "\"horasPorDia\"";
        private static final String KEY_RECORRENTE_DATA_FINAL = "\"dataFinal\"";
        private static final String KEY_RECORRENTE_PRIORIDADE = "\"prioridade\"";
        private static final String KEY_RECORRENTE_USER_ID_FK = "\"usuarioID\"";
        private static final String KEY_RECORRENTE_FALTAS ="\"faltas\"";
        private static final String KEY_RECORRENTE_LOCAL = "\"local\"";

        //Unico Table Columns
        private static final String KEY_UNICO_ID = "\"id\"";
        private static final String KEY_UNICO_NOME = "\"nome\"";
        private static final String KEY_UNICO_ANOTACAO = "\"anotacao\"";
        private static final String KEY_UNICO_HORA_FINAL = "\"horaFinal\"";
        private static final String KEY_UNICO_HORA_INICIAL = "\"horaInicial\"";
        private static final String KEY_UNICO_DATA = "\"data\"";
        private static final String KEY_UNICO_LOCAL = "\"local\"";
        private static final String KEY_UNICO_PRIORIDADE ="\"prioridade\"";
        private static final String KEY_UNICO_USER_ID_FK = "\"usuarioID\"";

        //Periodico Table Columns
        private static final String KEY_PERIODICO_ID = "\"id\"";
        private static final String KEY_PERIODICO_NOME = "\"nome\"";
        private static final String KEY_PERIODICO_ANOTACAO = "\"anotacao\"";
        private static final String KEY_PERIODICO_HORA_FINAL = "\"horaFinal\"";
        private static final String KEY_PERIODICO_HORA_INICIAL = "\"horaInicial\"";
        private static final String KEY_PERIODICO_LOCAL = "\"local\"";
        private static final String KEY_PERIODICO_PRIORIDADE ="\"prioridade\"";
        private static final String KEY_PERIODICO_REPETICAO ="\"repeticao\"";
        private static final String KEY_PERIODICO_FREQUENCIA ="\"frequencia\"";
        private static final String KEY_PERIODICO_FALTAS ="\"faltas\"";
        private static final String KEY_PERIODICO_USER_ID_FK = "\"usuarioID\"";
        private static final String KEY_PERIODICO_SEGUNDA = "\"segunda\"";
        private static final String KEY_PERIODICO_TERCA = "\"terca\"";
        private static final String KEY_PERIODICO_QUARTA = "\"quarta\"";
        private static final String KEY_PERIODICO_QUINTA = "\"quinta\"";
        private static final String KEY_PERIODICO_SEXTA = "\"sexta\"";
        private static final String KEY_PERIODICO_SABADO= "\"sabado\"";
        private static final String KEY_PERIODICO_DOMINGO = "\"domingo\"";


    public static synchronized DataBaseHelper getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DataBaseHelper(context);
        }
        return mInstance;
    }

    private DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_USUARIO = "CREATE TABLE IF NOT EXISTS " + TABLE_USUARIO +
                "(" +
                KEY_USER_ID + " INTEGER PRIMARY KEY, " +
                KEY_SENHA + " TEXT , " +
                KEY_LOGIN + " TEXT " +
                ");";
        db.execSQL(CREATE_TABLE_USUARIO);

        String CREATE_TABLE_RECORRENTE = "CREATE TABLE IF NOT EXISTS " + TABLE_RECORRENTE +
                "(" +
                KEY_RECORRENTE_ID + " INTEGER PRIMARY KEY, " +
                KEY_RECORRENTE_NOME + " TEXT , " +
                KEY_RECORRENTE_ANOTACAO + " TEXT , " +
                KEY_RECORRENTE_HORA_FINAL + "  TIME , " +
                KEY_RECORRENTE_PROGRESSAO + "FLOAT , " +
                KEY_RECORRENTE_ITENS_FEITOS + " INTEGER , " +
                KEY_RECORRENTE_TOTAL_ITENS + " INTEGER , " +
                KEY_RECORRENTE_HORAS_DIA + " INTEGER , " +
                KEY_RECORRENTE_DATA_FINAL + " DATE , " +
                KEY_RECORRENTE_PRIORIDADE + " INTEGER , " +
                KEY_RECORRENTE_USER_ID_FK + " INTEGER REFERENCES " + TABLE_USUARIO + "," +
                KEY_RECORRENTE_FALTAS + " INTEGER , " +
                KEY_RECORRENTE_LOCAL + " TEXT " +
                ");";
        db.execSQL(CREATE_TABLE_RECORRENTE);

        String CREATE_TABLE_UNICO = "CREATE TABLE IF NOT EXISTS " + TABLE_UNICO +
                "(" +
                KEY_UNICO_ID + " INTEGER PRIMARY KEY, " +
                KEY_UNICO_NOME + " TEXT , " +
                KEY_UNICO_ANOTACAO + " TEXT , " +
                KEY_UNICO_HORA_FINAL + " TIMESTAMP , " +
                KEY_UNICO_HORA_INICIAL + " TIMESTAMP , " +
                KEY_UNICO_DATA  + " DATE , " +
                KEY_UNICO_LOCAL + " TEXT , " +
                KEY_UNICO_PRIORIDADE + " INTEGER , " +
                KEY_UNICO_USER_ID_FK  + " INTEGER  REFERENCES " + TABLE_USUARIO +
                ");";
        db.execSQL(CREATE_TABLE_UNICO);

        String CREATE_TABLE_PERIODICO = "CREATE TABLE IF NOT EXISTS " + TABLE_PERIODICO +
                "(" +
                KEY_PERIODICO_ID + " INTEGER PRIMARY KEY, " +
                KEY_PERIODICO_NOME + " TEXT , " +
                KEY_PERIODICO_ANOTACAO + " TEXT , " +
                KEY_PERIODICO_HORA_FINAL  + " TIMESTAMP , " +
                KEY_PERIODICO_HORA_INICIAL + " TIMESTAMP , " +
                KEY_PERIODICO_REPETICAO  + " INTEGER , " +
                KEY_PERIODICO_LOCAL + " TEXT , " +
                KEY_PERIODICO_PRIORIDADE + " INTEGER , " +
                KEY_PERIODICO_FREQUENCIA + " TEXT , " +
                KEY_PERIODICO_FALTAS + " INTEGER , " +
                KEY_PERIODICO_SEGUNDA + " INTEGER , " +
                KEY_PERIODICO_TERCA + " INTEGER , " +
                KEY_PERIODICO_QUARTA + " INTEGER , " +
                KEY_PERIODICO_QUINTA + " INTEGER , " +
                KEY_PERIODICO_SEXTA + " INTEGER , " +
                KEY_PERIODICO_SABADO + " INTEGER , " +
                KEY_PERIODICO_DOMINGO + " INTEGER , " +
                KEY_PERIODICO_USER_ID_FK  + " INTEGER  REFERENCES " + TABLE_USUARIO +
                ");";
        db.execSQL(CREATE_TABLE_PERIODICO);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_UNICO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERIODICO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECORRENTE);
        onCreate(db);
    }

    // Inserir atividade recorrente
    public void addUsuario(Usuario usuario) {
        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {
            // The user might already exist in the database (i.e. the same user created multiple posts).
            long userId = addOrUpdateUser(usuario);

            ContentValues values = new ContentValues(); //valores que não são PK
            values.put(KEY_USER_ID, userId);
            values.put(KEY_LOGIN, usuario.getLogin());
            values.put(KEY_SENHA , usuario.getSenha());

            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            db.insertOrThrow(TABLE_USUARIO, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add post to database");
        } finally {
            db.endTransaction();
        }
    }

    //Inserir evento na tabela Recorrente
    public void addRecorrente(Recorrente recorrente) {
        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {
            // The user might already exist in the database (i.e. the same user created multiple posts).
            long userId = addOrUpdateUser(recorrente.getUserID()); //////WTF

            ContentValues values = new ContentValues(); //valores que não são PK
            values.put(KEY_RECORRENTE_NOME, recorrente.getNome());
            values.put(KEY_RECORRENTE_ANOTACAO, recorrente.getAnotacao());
            values.put(KEY_RECORRENTE_ID, userId);
            SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
            values.put(KEY_RECORRENTE_HORA_FINAL, formatTime.format(recorrente.getHoraFinal()));
            values.put(KEY_RECORRENTE_PROGRESSAO, recorrente.getProgressao());
            values.put(KEY_RECORRENTE_ITENS_FEITOS, recorrente.getItensFeitos());
            values.put(KEY_RECORRENTE_TOTAL_ITENS, recorrente.getTotalItens());
            values.put(KEY_RECORRENTE_HORAS_DIA, recorrente.getHorasDia());
            SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            values.put(KEY_RECORRENTE_DATA_FINAL, formatDate.format(recorrente.getDataFinal()));
            values.put(KEY_RECORRENTE_PRIORIDADE, recorrente.getPrioridade());
            values.put(KEY_RECORRENTE_FALTAS, recorrente.getFaltas());
            values.put(KEY_RECORRENTE_LOCAL, recorrente.getLocal());
            //!!!!! tem que pegar da classe criada values.put(KEY_RECORRENTE_USER_ID_FK, recorrente.get);
            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            db.insertOrThrow(TABLE_RECORRENTE, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add in database");
        } finally {
            db.endTransaction();
        }
    }

    //Inserir evento na tabela Unico
    public void addUnico(Unico unico) {
        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {
            // The user might already exist in the database (i.e. the same user created multiple posts).
            long userId = addOrUpdateUser(unico.getUserID());

            ContentValues values = new ContentValues(); //valores que não são PK
            values.put(KEY_UNICO_ID, userId);
            values.put(KEY_UNICO_NOME, unico.getNome());
            values.put(KEY_UNICO_ANOTACAO, unico.getAnotacao());
            SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
            values.put(KEY_UNICO_HORA_FINAL, formatTime.format(unico.getHoraFinal()));
            values.put(KEY_UNICO_HORA_INICIAL, formatTime.format(unico.getHoraInicial()));
            SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            values.put(KEY_UNICO_DATA, formatDate.format(unico.getData()));
            values.put(KEY_UNICO_LOCAL, unico.getLocal());
            values.put(KEY_UNICO_PRIORIDADE, unico.getPrioridade());
            //!!!!values.put(KEY_RECORRENTE_USER_ID_FK, userId);

            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            db.insertOrThrow(TABLE_UNICO, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add in database");
        } finally {
            db.endTransaction();
        }
    }

    //Inserir evento na tabela Periodico
    public void addPeriodico(Periodico periodico) {
        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {
            // The user might already exist in the database (i.e. the same user created multiple posts).
            long userId = addOrUpdateUser(periodico.getUserID());

            ContentValues values = new ContentValues(); //valores que não são PK
            values.put(KEY_PERIODICO_NOME, periodico.getNome());
            values.put(KEY_PERIODICO_ANOTACAO, periodico.getAnotacao());
            values.put(KEY_PERIODICO_ID, userId);
            SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
            values.put(KEY_PERIODICO_HORA_FINAL, formatTime.format(periodico.getHoraFinal()));
            values.put(KEY_PERIODICO_HORA_INICIAL, formatTime.format(periodico.getHoraInicial()));
            values.put(KEY_PERIODICO_LOCAL, periodico.getLocal());
            values.put(KEY_PERIODICO_PRIORIDADE, periodico.getPrioridade());
            values.put(KEY_PERIODICO_REPETICAO, periodico.getRepeticao());
            values.put(KEY_PERIODICO_FREQUENCIA, periodico.getFrequencia());
            values.put(KEY_PERIODICO_FALTAS, periodico.getFaltas());
            values.put(KEY_PERIODICO_SEGUNDA, periodico.getSegunda());
            values.put(KEY_PERIODICO_TERCA, periodico.getTerca());
            values.put(KEY_PERIODICO_QUARTA, periodico.getQuarta());
            values.put(KEY_PERIODICO_QUINTA, periodico.getQuinta());
            values.put(KEY_PERIODICO_SEXTA, periodico.getSexta());
            values.put(KEY_PERIODICO_SABADO, periodico.getSabado());
            values.put(KEY_PERIODICO_DOMINGO, periodico.getDomingo());

            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            db.insertOrThrow(TABLE_PERIODICO, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add in database");
        } finally {
            db.endTransaction();
        }
    }

    private long addOrUpdateUser(Usuario user) {
        // The database connection is cached so it's not expensive to call getWriteableDatabase() multiple times.
        SQLiteDatabase db = getWritableDatabase();
        long userId = -1;

        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_LOGIN, user.getLogin());
            values.put(KEY_SENHA, user.getSenha());

            // First try to update the user in case the user already exists in the database
            // This assumes userNames are unique
            int rows = db.update(TABLE_USUARIO, values, KEY_LOGIN + "= ?", new String[]{user.getLogin()});

            // Check if update succeeded
            if (rows == 1) {
                // Get the primary key of the user we just updated
                String usersSelectQuery = String.format("SELECT %s FROM %s WHERE %s = ?",
                        KEY_USER_ID, TABLE_USUARIO, KEY_LOGIN);
                Cursor cursor = db.rawQuery(usersSelectQuery, new String[]{String.valueOf(user.getLogin())});
                try {
                    if (cursor.moveToFirst()) {
                        userId = cursor.getInt(0);
                        db.setTransactionSuccessful();
                    }
                } finally {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
            } else {
                // user with this userName did not already exist, so insert new user
                userId = db.insertOrThrow(TABLE_USUARIO, null, values);
                db.setTransactionSuccessful();
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add or update user");
        } finally {
            db.endTransaction();
        }
        return userId;
    }

    // Pega todos os compromissiso recorrentes
    public List<Recorrente> getAllRecorrente() {
        List<Recorrente> recorrentes = new ArrayList<>();

        // SELECT * FROM POSTS
        // LEFT OUTER JOIN USERS
        // ON POSTS.KEY_POST_USER_ID_FK = USERS.KEY_USER_ID
        String RECORRENTE_SELECT_QUERY =
                String.format("SELECT * FROM %s LEFT OUTER JOIN %s ON %s.%s = %s.%s",
                        TABLE_RECORRENTE,
                        TABLE_USUARIO,
                        TABLE_RECORRENTE, KEY_RECORRENTE_USER_ID_FK,
                        TABLE_USUARIO, KEY_USER_ID);

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(RECORRENTE_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    Usuario newUser = new Usuario();
                    newUser.setLogin(cursor.getString(cursor.getColumnIndex(KEY_LOGIN)));
                    newUser.setSenha(cursor.getString(cursor.getColumnIndex(KEY_SENHA)));

                    Recorrente newRecorrente = new Recorrente();
                    newRecorrente.setNome(cursor.getString(cursor.getColumnIndex(KEY_RECORRENTE_NOME)));
                    newRecorrente.setAnotacao(cursor.getString(cursor.getColumnIndex(KEY_RECORRENTE_ANOTACAO)));
                    newRecorrente.setLocal(cursor.getString(cursor.getColumnIndex(KEY_RECORRENTE_LOCAL)));

                    SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
                    Date HoraFinal = null;
                    try {
                        if (cursor.getString(cursor.getColumnIndex(KEY_RECORRENTE_HORA_FINAL))!=null)
                            HoraFinal= formatTime.parse(cursor.getString(cursor.getColumnIndex(KEY_RECORRENTE_HORA_FINAL)));
                    } catch (ParseException e){
                        HoraFinal = null;
                    }
                    newRecorrente.setHoraFinal((java.sql.Time)HoraFinal);

                    newRecorrente.setProgressao(cursor.getFloat(cursor.getColumnIndex(KEY_RECORRENTE_PROGRESSAO)));
                    newRecorrente.setTotalItens(cursor.getInt (cursor.getColumnIndex(KEY_RECORRENTE_TOTAL_ITENS)));
                    newRecorrente.setItensFeitos (cursor.getInt (cursor.getColumnIndex(KEY_RECORRENTE_ITENS_FEITOS)));
                    newRecorrente.setHorasDia(cursor.getInt (cursor.getColumnIndex(KEY_RECORRENTE_HORAS_DIA)));
                    newRecorrente.setPrioridade(cursor.getInt (cursor.getColumnIndex(KEY_RECORRENTE_PRIORIDADE)));
                    newRecorrente.setFaltas(cursor.getInt (cursor.getColumnIndex(KEY_RECORRENTE_FALTAS)));

                    SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    Date dataTeste;
                    try {
                        dataTeste = formatData.parse(cursor.getString(cursor.getColumnIndex(KEY_RECORRENTE_DATA_FINAL)));
                    } catch (ParseException e){
                        dataTeste = null;
                    }
                    newRecorrente.setDataFinal(dataTeste);
                    newRecorrente.setUserID(newUser);
                    recorrentes.add(newRecorrente);
                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return recorrentes;
    }
    // Pega todos os compromissos unicos
    public List<Unico> getAllUnico() {
        List<Unico> unicos = new ArrayList<>();

        // SELECT * FROM POSTS
        // LEFT OUTER JOIN USERS
        // ON POSTS.KEY_POST_USER_ID_FK = USERS.KEY_USER_ID
        String UNICOS_SELECT_QUERY =
                String.format("SELECT * FROM %s LEFT OUTER JOIN %s ON %s.%s = %s.%s",
                        TABLE_UNICO,
                        TABLE_USUARIO,
                        TABLE_UNICO, KEY_UNICO_USER_ID_FK,
                        TABLE_USUARIO, KEY_USER_ID);

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(UNICOS_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    Usuario newUser = new Usuario();
                    newUser.setLogin(cursor.getString(cursor.getColumnIndex(KEY_LOGIN)));
                    newUser.setSenha (cursor.getString(cursor.getColumnIndex(KEY_SENHA)));

                    Unico newUnico = new Unico();
                    newUnico.setNome(cursor.getString(cursor.getColumnIndex(KEY_UNICO_NOME)));
                    newUnico.setAnotacao (cursor.getString(cursor.getColumnIndex(KEY_UNICO_ANOTACAO)));
                    newUnico.setLocal(cursor.getString(cursor.getColumnIndex(KEY_UNICO_LOCAL)));

                    SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
                    Date HoraFinal = null;
                    try {
                        if (cursor.getString(cursor.getColumnIndex(KEY_UNICO_HORA_FINAL))!=null)
                            HoraFinal= formatTime.parse(cursor.getString(cursor.getColumnIndex(KEY_UNICO_HORA_FINAL)));
                    } catch (ParseException e){
                        HoraFinal = null;
                    }
                    newUnico.setHoraFinal((java.sql.Time)HoraFinal);

                    Date HoraInicial = null;
                    try {
                        if (cursor.getString(cursor.getColumnIndex(KEY_UNICO_HORA_INICIAL))!=null)
                            HoraInicial = formatTime.parse(cursor.getString(cursor.getColumnIndex(KEY_UNICO_HORA_INICIAL)));
                    } catch (ParseException e){
                        HoraInicial = null;
                    }
                    newUnico.setHoraInicial ((java.sql.Time)HoraInicial);

                    newUnico.setPrioridade(cursor.getInt (cursor.getColumnIndex(KEY_UNICO_PRIORIDADE)));

                    SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    Date dataTeste = null;
                    try {
                        if (cursor.getString(cursor.getColumnIndex(KEY_UNICO_DATA))!=null)
                            dataTeste = formatData.parse(cursor.getString(cursor.getColumnIndex(KEY_UNICO_DATA)));
                    } catch (ParseException e){
                        dataTeste = null;
                    }
                    newUnico.setData(dataTeste);
                    newUnico.setUserID(newUser);
                    unicos.add(newUnico);
                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return unicos;
    }


    // Pega todos os compromissiso periodicos
    public List<Periodico> getAllPeriodico() {
        List<Periodico> periodicos = new ArrayList<>();

        // SELECT * FROM POSTS
        // LEFT OUTER JOIN USERS
        // ON POSTS.KEY_POST_USER_ID_FK = USERS.KEY_USER_ID
        String PERIODICOS_SELECT_QUERY =
                String.format("SELECT * FROM %s LEFT OUTER JOIN %s ON %s.%s = %s.%s",
                        TABLE_PERIODICO,
                        TABLE_USUARIO,
                        TABLE_PERIODICO, KEY_PERIODICO_USER_ID_FK,
                        TABLE_USUARIO, KEY_USER_ID);

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(PERIODICOS_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    Usuario newUser = new Usuario();
                    newUser.setLogin(cursor.getString(cursor.getColumnIndex(KEY_LOGIN)));
                    newUser.setSenha(cursor.getString(cursor.getColumnIndex(KEY_SENHA)));

                    Periodico newPeriodico = new Periodico();
                    newPeriodico.setNome(cursor.getString(cursor.getColumnIndex(KEY_PERIODICO_NOME)));
                    newPeriodico.setAnotacao(cursor.getString(cursor.getColumnIndex(KEY_PERIODICO_ANOTACAO)));
                    newPeriodico.setLocal(cursor.getString(cursor.getColumnIndex(KEY_PERIODICO_LOCAL)));

                    SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
                    Date HoraFinal = null;
                    try {
                        if (cursor.getString(cursor.getColumnIndex(KEY_PERIODICO_HORA_FINAL))!=null)
                            HoraFinal= formatTime.parse(cursor.getString(cursor.getColumnIndex(KEY_PERIODICO_HORA_FINAL)));
                    } catch (ParseException e){
                        HoraFinal = null;
                    }
                    newPeriodico.setHoraFinal((java.sql.Time)HoraFinal);

                    Date HoraInicial = null;
                    try {
                        if (cursor.getString(cursor.getColumnIndex(KEY_PERIODICO_HORA_INICIAL))!=null)
                            HoraInicial = formatTime.parse(cursor.getString(cursor.getColumnIndex(KEY_PERIODICO_HORA_INICIAL)));
                    } catch (ParseException e){
                        HoraInicial = null;
                    }
                    newPeriodico.setHoraInicial ((java.sql.Time)HoraInicial);

                    newPeriodico.setPrioridade(cursor.getInt (cursor.getColumnIndex(KEY_PERIODICO_PRIORIDADE)));
                    newPeriodico.setRepeticao(cursor.getInt (cursor.getColumnIndex(KEY_PERIODICO_REPETICAO)));
                    newPeriodico.setFrequencia(cursor.getString (cursor.getColumnIndex(KEY_PERIODICO_FREQUENCIA)));
                    newPeriodico.setFaltas(cursor.getInt (cursor.getColumnIndex(KEY_PERIODICO_FALTAS)));
                    newPeriodico.setSegunda(cursor.getInt(cursor.getColumnIndex(KEY_PERIODICO_SEGUNDA)));
                    newPeriodico.setTerca(cursor.getInt(cursor.getColumnIndex(KEY_PERIODICO_TERCA)));
                    newPeriodico.setQuarta(cursor.getInt(cursor.getColumnIndex(KEY_PERIODICO_QUARTA)));
                    newPeriodico.setQuinta(cursor.getInt(cursor.getColumnIndex(KEY_PERIODICO_QUINTA)));
                    newPeriodico.setSexta(cursor.getInt(cursor.getColumnIndex(KEY_PERIODICO_SEXTA)));
                    newPeriodico.setSabado(cursor.getInt(cursor.getColumnIndex(KEY_PERIODICO_SABADO)));
                    newPeriodico.setDomingo(cursor.getInt(cursor.getColumnIndex(KEY_PERIODICO_DOMINGO)));
                    newPeriodico.setUserID(newUser);
                    periodicos.add(newPeriodico);

                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return periodicos;
    }
/*

    // Update the user's profile picture url
    public int updateUserProfilePicture(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USER_PROFILE_PICTURE_URL, user.profilePictureUrl);

        // Updating profile picture url for user with that userName
        return db.update(TABLE_USERS, values, KEY_USER_NAME + " = ?",
                new String[] { String.valueOf(user.userName) });
    }

    // Delete all posts and users in the database
    public void deleteAllPostsAndUsers() {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            // Order of deletions is important when foreign key relationships exist.
            db.delete(TABLE_POSTS, null, null);
            db.delete(TABLE_USERS, null, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to delete all posts and users");
        } finally {
            db.endTransaction();
        }
    }
}
*/
}