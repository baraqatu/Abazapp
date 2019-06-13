package abazdev.dicoding.abazapp.controller;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import abazdev.dicoding.abazapp.DetailJajakhasActivity;
import abazdev.dicoding.abazapp.R;
import abazdev.dicoding.abazapp.model.Jajakhas;

public class ListJajakhasAdapter extends RecyclerView.Adapter<ListJajakhasAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Jajakhas> listJajakhas;

    public ListJajakhasAdapter(Context context) {
        this.context = context;
    }

    private Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    private ArrayList<Jajakhas> getListJajakhas() {
        return listJajakhas;
    }

    public void setListJajakhas(ArrayList<Jajakhas> listJajakhas) {
        this.listJajakhas = listJajakhas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListJajakhasAdapter.ViewHolder viewHolder, final int i) {
        Jajakhas p = getListJajakhas().get(i);

        viewHolder.tvName.setText(getListJajakhas().get(i).getName());

        Glide.with(context)
                .load(Integer.valueOf(p.getPhoto()))
                .apply(new RequestOptions().override(150,220))
                .into(viewHolder.ivPhoto);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DetailJajakhasActivity.class);
                intent.putExtra("Jajanan Khas Makassar", getListJajakhas().get(i));
                Log.e("Title", getListJajakhas().get(i).getName());
                getContext().startActivity(intent);
            }
        });

        viewHolder.tvCategory.setText(getListJajakhas().get(i).getCategory());

        viewHolder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, getListJajakhas().get(i).getName() + "Berhasil Disukai", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, getListJajakhas().get(i).getName() + "Berhasil Dibagikan", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListJajakhas().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvCategory;
        ImageView ivPhoto;
        Button btnFavorite;
        Button btnShare;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvCategory = itemView.findViewById(R.id.tv_item_category);
            ivPhoto = itemView.findViewById(R.id.iv_item_photo);

            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }
    }
}