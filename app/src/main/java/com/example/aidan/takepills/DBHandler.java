/**
 * Created by Byron on 6/21/15.
 */

package com.example.aidan.takepills;


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "takePillsDB.db";
    private static final String TABLE_MEDS = "meds";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_MEDNAME = "medName";
    public static final String COLUMN_MEDDOSE = "medDose";
    public static final String COLUMN_MEDSTATUS = "medStatus";
    public static final String COLUMN_MEDDATEEND = "medDateEnd";

    public DBHandler(Context context, String name,
                     SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                TABLE_MEDS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_MEDNAME
                + " TEXT," + COLUMN_MEDDOSE + " TEXT," + COLUMN_MEDSTATUS + " TEXT," +
                COLUMN_MEDDATEEND + " TEXT" + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEDS);
        onCreate(db);
    }

    public void addMeds(takePillsDb takePillsDb) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_MEDNAME, takePillsDb.getMedName());
        values.put(COLUMN_MEDDOSE, takePillsDb.getDose());
        values.put(COLUMN_MEDSTATUS, takePillsDb.getStatus());
        values.put(COLUMN_MEDDATEEND, takePillsDb.getDateEnd());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_MEDS, null, values);
        db.close();
    }

    public takePillsDb findProduct(String medName) {
        String query = "Select * FROM " + TABLE_MEDS + " WHERE " + COLUMN_MEDNAME + " =  \"" + medName + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        takePillsDb takePillsDb = new takePillsDb();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            takePillsDb.setID(Integer.parseInt(cursor.getString(0)));
            takePillsDb.setMedName(cursor.getString(1));
            takePillsDb.setDose(cursor.getString(2));
            takePillsDb.setStatus(cursor.getString(3));
            takePillsDb.setDateEnd(cursor.getString(4));
            cursor.close();
        } else {
            takePillsDb = null;
        }
        db.close();
        return takePillsDb;
    }

    public boolean deleteProduct(String medName) {

        boolean result = false;

        String query = "Select * FROM " + TABLE_MEDS + " WHERE " + COLUMN_MEDNAME + " =  \"" + medName + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        takePillsDb product = new takePillsDb();

        if (cursor.moveToFirst()) {
            product.setID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_MEDS, COLUMN_ID + " = ?",
                    new String[] { String.valueOf(product.getID()) });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

}