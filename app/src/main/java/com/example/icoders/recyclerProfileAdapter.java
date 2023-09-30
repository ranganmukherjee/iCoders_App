package com.example.icoders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerProfileAdapter extends RecyclerView.Adapter<recyclerProfileAdapter.ViewHolder> {

    Context context;
    ArrayList<profileModel> arrProfile;
    recyclerProfileAdapter(Context context, ArrayList<profileModel> arrProfile)
    {
        this.context=context;
        this.arrProfile=arrProfile;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v=LayoutInflater.from(context).inflate(R.layout.profileholder, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img.setImageResource(arrProfile.get(position).getImg());
        holder.name.setText(arrProfile.get(position).getName());
        holder.desig.setText(arrProfile.get(position).getDesig());
    }

    @Override
    public int getItemCount() {
        return arrProfile.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView name, desig;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.img);
            name=itemView.findViewById(R.id.name);
            desig=itemView.findViewById(R.id.desig);
        }
    }

}
