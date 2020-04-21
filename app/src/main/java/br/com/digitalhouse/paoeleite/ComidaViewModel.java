package br.com.digitalhouse.paoeleite;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ComidaViewModel extends AndroidViewModel {

        private ComidaRepository mRepository;

        private LiveData<List<Comida>> mAllComida;

        public ComidaViewModel (Application application) {
            super(application);
            mRepository = new ComidaRepository(application);
            mAllComida = mRepository.getmAllComida();
        }

        LiveData<List<Comida>> getAllWords() { return mAllComida ; }

        public void insert(Comida comida) { mRepository.insert(comida); }
    }



