package br.com.digitalhouse.paoeleite;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tabela_comida")
public class Comida {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "comida")
    public String mComida;

    public Comida(@NonNull String comida) {this.mComida = comida;}

    @NonNull
    public String getmComida() {
        return mComida;
    }

    public void setmComida(String mComida) {
        this.mComida = mComida;
    }
}
