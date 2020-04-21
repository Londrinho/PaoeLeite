package br.com.digitalhouse.paoeleite;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ComidaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Comida comida);

    @Query("DELETE FROM tabela_comida")
    void deleteAll();

    @Query("SELECT * from tabela_comida ORDER BY comida ASC")
    LiveData<List<Comida>> getAlphabetizedComida();
}
