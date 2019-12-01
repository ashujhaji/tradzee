package com.pixerapps.tradzee.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.pixerapps.tradzee.R;
import com.pixerapps.tradzee.model.Order;

@Database(entities = {Order.class}, version = 1, exportSchema = false)
public abstract class TradzeeDb extends RoomDatabase {
    private static TradzeeDb instance;

    public abstract TradzeeRoomDao tradzeeRoomDao();

    public static TradzeeDb getAppDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context,
                    TradzeeDb.class,
                    context.getString(R.string.app_name))
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
