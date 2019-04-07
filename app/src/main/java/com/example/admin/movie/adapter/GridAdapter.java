package com.example.admin.movie.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.movie.R;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    List<Endangereditem> mItems;

    public GridAdapter() {
        super();
        mItems = new ArrayList<Endangereditem>();
        Endangereditem nama = new Endangereditem();
        nama.setName("yowis ben ");
        nama.setposter(R.drawable.yowisben);
        mItems.add(nama);

        nama = new Endangereditem();
        nama.setName("negri 5 menara");
        nama.setposter(R.drawable.negri5menara);
        mItems.add(nama);

        nama = new Endangereditem();
        nama.setName("sang pemimpi");
        nama.setposter(R.drawable.sangpemimpi);
        mItems.add(nama);



    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Endangereditem nature = mItems.get(i);
        viewHolder.tvspecies.setText(nature.getName());
        viewHolder.imgThumbnail.setImageResource(nature.getposter());
    }

    @Override
    public int getItemCount() {

        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  {


        public ImageView imgThumbnail;
        public TextView tvspecies;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.poster);
            tvspecies = (TextView)itemView.findViewById(R.id.judul);

        }
    }
}


