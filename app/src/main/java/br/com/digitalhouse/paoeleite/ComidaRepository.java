package br.com.digitalhouse.paoeleite;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ComidaRepository {

    private ComidaDao mComidaDao;

    private LiveData<List<Comida>> mAllComida;

    ComidaRepository(Application application) {
        ComidaRoomDatabase db = ComidaRoomDatabase.getDatabase(application);
        mComidaDao = db.comidaDao();
        mAllComida = mComidaDao.getAlphabetizedComida();
    }
    LiveData<List<Comida>> getmAllComida() {
        return mAllComida;
    }

    void insert(Comida comida) {
        ComidaRoomDatabase.databaseWriteExecutor.execute(() -> {
            mComidaDao.insert(comida);
        });
    }

}
