package andtrain.com.androidtraining;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by jarvis on 5/25/16.
 */
public class AndroidTrainingAppDatabaseAdapter {
    public SQLiteDatabase db;
    public MyDatabaseHelperClass dbhelper;
    private static String db_name = "andtrainingLogin.db";
    private static int db_version = 1;
    public static String tablename = "ANDTRAINING_LOGIN";
    public static String createdb = "CREATE TABLE "+tablename+"(" +
                                    " ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                                    " USERNAME TEXT, PASSWORD TEXT);";
    //constructor
    public AndroidTrainingAppDatabaseAdapter(Context ctx) {
        dbhelper = new MyDatabaseHelperClass(ctx,db_name,null,db_version);
    }
    public AndroidTrainingAppDatabaseAdapter open() {
        db = dbhelper.getWritableDatabase();
        return this;
    }

    public SQLiteDatabase getDbInstance() {
        return db;
    }

    public void insertEntry(String username, String password) {
        ContentValues values = new ContentValues();
        values.put("USERNAME",username);
        values.put("PASSWORD",password);
        db.insert(tablename, null, values);
        System.out.println("Inserted into database successfully.");
    }

    public String getLoginCredentials(String username) {
        Cursor csr = db.query(tablename,null," USERNAME=?",new String[]{username},null,null,null);
        if(csr.getCount()<1) {
            return "NOT EXIST";
        }
        csr.moveToFirst();
        String password = csr.getString(csr.getColumnIndex("PASSWORD"));
        csr.close();

        return password;
    }

    public void close() {
        db.close();
    }

}
