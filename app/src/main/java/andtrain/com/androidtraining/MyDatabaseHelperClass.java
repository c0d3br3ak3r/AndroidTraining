package andtrain.com.androidtraining;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jarvis on 5/25/16.
 */
public class MyDatabaseHelperClass extends SQLiteOpenHelper {

    MyDatabaseHelperClass(Context ctx, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(ctx,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AndroidTrainingAppDatabaseAdapter.createdb);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //executed when there is a version mismatch
        db.execSQL("DROP TABLE IF EXISTS " + "TEMPLATE");
        onCreate(db);
    }
}
