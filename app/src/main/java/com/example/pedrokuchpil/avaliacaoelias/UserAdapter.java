package com.example.pedrokuchpil.avaliacaoelias;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by aiko.oliveira on 27/10/2017.
 */

public abstract class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private ArrayList<User> list;
    Context c;
    String user, userName, userEmail, userAdress, userImage;

    public UserAdapter(ArrayList<User> users, Context c) {
        list = users;
        this.c = c;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView){
            super(itemView);
        }
    }
}
