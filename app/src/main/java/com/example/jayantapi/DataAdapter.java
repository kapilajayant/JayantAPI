package com.example.jayantapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<Example> models;

    public DataAdapter(List<Example> models){
        this.models = models;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String image=models.get(position).getUrl();
        String name=models.get(position).getName();
        String age=models.get(position).getAge();
        String location=models.get(position).getLocation();

        holder.setData(image,name,age,location);

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name,tv_age,tv_location;
        private CircleImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_age = itemView.findViewById(R.id.tv_age);
            tv_location = itemView.findViewById(R.id.tv_location);
        }

            private void setData(String image,String name,String age, String location ){

                Glide.with(itemView.getContext()).load(image).placeholder(R.drawable.ic_man).into(imageView);
                tv_name.setText(name);
                tv_age.setText(age);
                tv_location.setText(location);
            }


    }
}