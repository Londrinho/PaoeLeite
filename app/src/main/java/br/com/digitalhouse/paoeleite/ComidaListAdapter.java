package br.com.digitalhouse.paoeleite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ComidaListAdapter extends RecyclerView.Adapter<ComidaListAdapter.ComidaViewHolder> {
    class ComidaViewHolder extends RecyclerView.ViewHolder {
        private final TextView comidaItemView;

        private ComidaViewHolder(View itemView) {
            super(itemView);
            comidaItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Comida> mComida;

    ComidaListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public ComidaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ComidaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ComidaViewHolder holder, int position) {
        if (mComida != null) {
            Comida current = mComida.get(position);
            holder.comidaItemView.setText(current.getmComida());
        } else {

            holder.comidaItemView.setText("Nao Comida");
        }
    }

    void setWords(List<Comida> words){
        mComida = words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mComida != null)
            return mComida.size();
        else return 0;
    }

}
