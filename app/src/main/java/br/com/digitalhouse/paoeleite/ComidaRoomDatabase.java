package br.com.digitalhouse.paoeleite;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Comida.class}, version = 1, exportSchema = false)
public abstract class ComidaRoomDatabase extends RoomDatabase {

    public abstract ComidaDao comidaDao();

    private static volatile ComidaRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ComidaRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ComidaRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ComidaRoomDatabase.class, "comida_database")
                            .build();
                }
            }
        }
        return INSTANCE;

    }


}
