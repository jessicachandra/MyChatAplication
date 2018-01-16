package com.example.jessicachandra.mychatapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jessica Chandra on 09/01/2018.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserHolder> {

    List<User> users;
    private LayoutInflater inflater;
    private Context context;

    SharedPreferences mylocaldata;

    public UserListAdapter(Context context ,List<User> users){
        this.context = context;
        inflater= LayoutInflater.from(context);
        this.users = users;

        mylocaldata =context.getSharedPreferences("mylocaldata", Context.MODE_PRIVATE);

    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =inflater.inflate (R.layout.user_card,parent ,false);
        UserHolder holder = new UserHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        User current = users.get (position);
        holder.setData (current,position);
        holder.setListeners();
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder {

        View itemView;
        TextView tvNama, tvEmail, tvNomor;
        CardView thisuser;

        int position;
        User current;

        public  UserHolder (View itemView){
            super(itemView);
            this.itemView = itemView;

            thisuser= (CardView) itemView.findViewById(R.id.cvItemUser);
            thisuser= (CardView) itemView.findViewById(R.id.tvNama);
            thisuser= (CardView) itemView.findViewById(R.id.tvEmail);
            thisuser= (CardView) itemView.findViewById(R.id.tvNomor);
        }
        public void setData(User current, int position) {
            tvNama.setText(current.getNama());
            tvEmail.setText(current.getEmail());
            tvNomor.setText(current.getTelpon());
            String uid = mylocaldata.getString("uid","");
            this.position = position;
            this.current= current;
        }

        public void setListeners() {
            thisuser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,ProfilActivity.class);
                    intent.putExtra("user",current);
                    context.startActivity(intent);
                }
            });
        }
    }
}
