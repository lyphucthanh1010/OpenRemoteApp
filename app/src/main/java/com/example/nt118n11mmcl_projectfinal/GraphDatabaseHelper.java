package com.example.nt118n11mmcl_projectfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class GraphDatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "dataManager";

    // Contacts table name
    private static final String TABLE_CONTACTS = "contacts";
    private static final String KEY_ID = "iddtb";
    private static final String KEY_ASSETID = "id";
        private static final String KEY_NAME = "name";
    private static final String KEY_TEMPERATURE = "temper";
    private static final String KEY_TEMTIMESTAMP = "tempertime";
    private static final String KEY_HUMIDITY = "humid";
    private static final String KEY_HUMITIME = "humitime";
    private static final String KEY_WINDSPEED = "windspeed";
    private static final String KEY_WINDSTIME = "windstime";
    private static final String KEY_WINDDIREC = "windDirection";
    private static final String KEY_WINDTIMESTAMP ="winddirectime";
    private static final String KEY_PRESSURE = "pressure";
    private static final String KEY_SEALEVEL = "sea_level";
    private static final String KEY_GRNDLEVEL = "grnd_level";
    private static final String KEY_TEMPMIN = "temp_min";
    private static final String KEY_TEMPMAX = "temp_max";
    private static final String KEY_TIME2 = "timestamp2";

    public GraphDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_ASSETID + " TEXT,"
                + KEY_NAME + " TEXT,"
                + KEY_TEMPERATURE + " DOUBLE," + KEY_TEMTIMESTAMP + " LONG,"
                + KEY_HUMIDITY + " INTEGER," + KEY_HUMITIME + " LONG,"
                + KEY_WINDSPEED + " DOUBLE," + KEY_WINDSTIME + " LONG,"
                + KEY_TEMPMAX + " DOUBLE," + KEY_TEMPMIN + " DOUBLE,"
                + KEY_SEALEVEL +" LONG,"+ KEY_GRNDLEVEL +" LONG,"
                + KEY_TIME2 + " LONG,"
                + KEY_WINDDIREC +" INTEGER," + KEY_WINDTIMESTAMP + " LONG,"
                + KEY_PRESSURE + " LONG"+ ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }

    public void addContact(DataGraph dtgraph) {
        SQLiteDatabase db = this.getWritableDatabase(); // Cho phép ghi đọc vào CSDL
        String nullColumnHack = null; // Allow null value

        ContentValues values = new ContentValues();
        if (dtgraph.getIddtb() != -1) { // -1 hình như để add dữ liệu vào hết rồi mới đóng kết nối
            values.put(KEY_NAME, dtgraph.getName()); // put là để đặt giá trị cho mỗi cột
            values.put(KEY_ASSETID, dtgraph.getId());
            values.put(KEY_TEMPERATURE, dtgraph.getTemper());
            values.put(KEY_TEMTIMESTAMP, dtgraph.getTimetemper());
            values.put(KEY_HUMIDITY, dtgraph.getHumid());
            values.put(KEY_HUMITIME, dtgraph.getTimehumid());
            values.put(KEY_WINDSPEED, dtgraph.getWindspeed());
            values.put(KEY_WINDSTIME, dtgraph.getTimewindspeed());
            values.put(KEY_TEMPMAX, dtgraph.getTemp_max());
            values.put(KEY_TEMPMIN, dtgraph.getTemp_max());
            values.put(KEY_SEALEVEL, dtgraph.getSea_level());
            values.put(KEY_GRNDLEVEL, dtgraph.getGrnd_level());
            values.put(KEY_TIME2, dtgraph.getTime2());
            values.put(KEY_WINDDIREC, dtgraph.getWinddirection());
            values.put(KEY_WINDTIMESTAMP, dtgraph.getWindditime());
            values.put(KEY_PRESSURE, dtgraph.getPressure());// put là để đặt giá trị cho mỗi cột
            db.insert(TABLE_CONTACTS, nullColumnHack, values);
        }
        db.close(); // Nhớ đóng kết nối nha bro
    }
    public Cursor GetData(String sql){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql, null);
    }
    public DataGraph getDataGraph(int iddtb) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] fields = {KEY_ID, KEY_ASSETID, KEY_NAME, KEY_TEMPERATURE, KEY_TEMTIMESTAMP, KEY_HUMIDITY, KEY_HUMITIME, KEY_WINDSPEED, KEY_WINDSTIME, KEY_TEMPMAX, KEY_TEMPMIN, KEY_SEALEVEL, KEY_GRNDLEVEL, KEY_TIME2, KEY_WINDDIREC, KEY_WINDTIMESTAMP, KEY_PRESSURE}; // Đưa các thuộc tính vào một mảng String
        String criterials = KEY_ID + "=?";
        String[] parameters = {String.valueOf(iddtb)};
        String groupby = null; // Giá trị null
        String having = null; // Giá trị null
        String orderby = null; // Giá trị null

        Cursor cursor = db.query(TABLE_CONTACTS, fields, criterials, parameters, groupby, having, orderby);

        if (cursor != null) { // Nếu có dữ liệu trong Database
            cursor.moveToFirst(); // Di chuyển con trỏ đến hàng đầu tiên trong kết quả truy vấn.

            return new DataGraph( // Đưa dữ liệu vào đối tượng contact
                    cursor.getInt(0), // Cột 1
                    cursor.getString(1), // Cột 2
                    cursor.getString(2),
                    cursor.getDouble(3),
                    cursor.getLong(4),
                    cursor.getInt(5),
                    cursor.getLong(6),
                    cursor.getDouble(7),
                    cursor.getLong(8),
                    cursor.getDouble(9),
                    cursor.getDouble(10),
                    cursor.getLong(11),
                    cursor.getLong(12),
                    cursor.getLong(13),
                    cursor.getLong(14),
                    cursor.getLong(15),
                    cursor.getLong(16));
        }
        return null;
    }

    public List<DataGraph> getAllContacts() {
        SQLiteDatabase db = this.getReadableDatabase(); // Cho phép đọc vào CSDL
        List<DataGraph> dtgraphs = new ArrayList<>();

        String[] criterial = null;
        String selectQuery = "SELECT * FROM " + TABLE_CONTACTS;

        Cursor cursor = db.rawQuery(selectQuery, criterial);
        if (cursor.moveToFirst()) {
            do {
                DataGraph dataGraph = new DataGraph();
                dataGraph.setIddtb(cursor.getInt(0));
                dataGraph.setId(cursor.getString(1));
                dataGraph.setName(cursor.getString(2));
                dataGraph.setTemper(cursor.getDouble(3));
                dataGraph.setTimetemper(cursor.getLong(4));
                dataGraph.setHumid(cursor.getInt(5));
                dataGraph.setTimehumid(cursor.getLong(6));
                dataGraph.setWindspeed(cursor.getDouble(7));
                dataGraph.setTimewindspeed(cursor.getLong(8));
                dataGraph.setTemp_max(cursor.getDouble(9));
                dataGraph.setTemp_min(cursor.getDouble(10));
                dataGraph.setSea_level(cursor.getLong(11));
                dataGraph.setGrnd_level(cursor.getLong(12));
                dataGraph.setTime2(cursor.getLong(13));
                dataGraph.setWinddirection(cursor.getLong(14));
                dataGraph.setWindditime(cursor.getLong(15));
                dataGraph.setPressure(cursor.getLong(16));
                dtgraphs.add(dataGraph);
            } while (cursor.moveToNext());
        }
        return dtgraphs;
    }

    public int updateDataGraph(DataGraph dataGraph) {
        SQLiteDatabase db = this.getWritableDatabase(); // Cho phép ghi đọc vào CSDL
        ContentValues values = new ContentValues();
        values.put(KEY_ASSETID, dataGraph.getId());
        values.put(KEY_NAME, dataGraph.getName());
        values.put(KEY_TEMPERATURE, dataGraph.getTemper());
        values.put(KEY_TEMTIMESTAMP, dataGraph.getTimetemper());
        values.put(KEY_HUMIDITY, dataGraph.getHumid());
        values.put(KEY_HUMITIME, dataGraph.getTimehumid());
        values.put(KEY_WINDSPEED, dataGraph.getWindspeed());
        values.put(KEY_WINDSTIME, dataGraph.getTimewindspeed());
        values.put(KEY_TEMPMAX, dataGraph.getTemp_max());
        values.put(KEY_TEMPMIN, dataGraph.getTemp_min());
        values.put(KEY_SEALEVEL, dataGraph.getSea_level());
        values.put(KEY_GRNDLEVEL, dataGraph.getGrnd_level());
        values.put(KEY_TIME2, dataGraph.getTime2());
        values.put(KEY_WINDDIREC, dataGraph.getWinddirection());
        values.put(KEY_WINDTIMESTAMP, dataGraph.getWindditime());
        values.put(KEY_PRESSURE, dataGraph.getPressure());

        String whereClause = KEY_ID + "=?";
        String[] whereArgs = {String.valueOf(dataGraph.getIddtb())};

        return db.update(TABLE_CONTACTS, values, whereClause, whereArgs);
    }

    public boolean deleteContact(int ID) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_CONTACTS, KEY_ID + "=" + ID, null) > 0;
    }
    public boolean deleterow()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        return sqLiteDatabase.delete(TABLE_CONTACTS,"1",null)>0;
    }
}
