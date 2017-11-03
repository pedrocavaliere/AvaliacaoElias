package com.example.pedrokuchpil.avaliacaoelias;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aiko.oliveira on 27/10/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.RecyclerHolder>{
    private ArrayList<User> list;
    Context c;
    String user, userName, userEmail, userAdress, userImage;

    class RecyclerHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView profileName = (TextView) itemView.findViewById(R.id.nome_recyclerUser);
        TextView profileEmail = (TextView) itemView.findViewById(R.id.email_recyclerUser);
        TextView profileAdress = (TextView) itemView.findViewById(R.id.adress_recyclerUser);
        TextView profilePhone = (TextView) itemView.findViewById(R.id.phone_recyclerUser);
        RecyclerHolder(View itemView){
            super(itemView);

            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
        }
    }

    public UserAdapter(ArrayList<User> users, Context c) {
        list = users;
        this.c = c;
    }

    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_user, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerHolder holder, int position) {
        holder.profileName.setText(list.get(position).getUserName());
        holder.profileAdress.setText(list.get(position).getUserAdress());
        holder.profileEmail.setText(list.get(position).getUserEmail());
        holder.profilePhone.setText(list.get(position).getUserPhone());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
