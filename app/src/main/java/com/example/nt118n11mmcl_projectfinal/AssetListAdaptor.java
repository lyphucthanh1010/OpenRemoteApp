package com.example.nt118n11mmcl_projectfinal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nt118n11mmcl_projectfinal.Model.UserCurrent;
import com.example.nt118n11mmcl_projectfinal.MyInterface.IClickItemListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AssetListAdaptor extends RecyclerView.Adapter<AssetListAdaptor.ViewHolder> implements Filterable {
    public List<UserCurrent> listAsset = new ArrayList<>() ;
    public List<UserCurrent> listAsset2 = new ArrayList<>();
    private IClickItemListener iClickItemListener;
    public AssetListAdaptor(List<UserCurrent> listAsset, IClickItemListener listener) {
        this.listAsset2 = listAsset;
        this.iClickItemListener=listener;
        this.listAsset = listAsset;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_2,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AssetListAdaptor.ViewHolder holder, final int position) {
        final UserCurrent userCurrent =listAsset.get(position);
        if(userCurrent ==null)
        {
            return;
        }
//        for (int i = 1; i <= listAsset.size(); i++) {
            holder.textView1.setText(userCurrent.getType());
            holder.textView2.setText(userCurrent.getName());
            holder.textView3.setText(userCurrent.getVersion());
            holder.textView4.setText(""+(position+1));
//        }
            holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    iClickItemListener.onClickItemUser(userCurrent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listAsset !=null)
        {
            return this.listAsset.size();
        }
        return 0;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String strSearch = constraint.toString();
                if (strSearch.isEmpty()) {
                    listAsset = listAsset2;
                }else {
                   List<UserCurrent> list = new ArrayList<>();
                   for (UserCurrent userCurrent : listAsset2)
                   {
                       if (userCurrent.getName().toLowerCase().contains(strSearch.toLowerCase()))
                       {
                           list.add(userCurrent);
                       }
                   }
                   listAsset = list;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = listAsset;
                return filterResults;
            }
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults results) {
                listAsset = (List<UserCurrent>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public RelativeLayout relativeLayout;
        public TextView textView1, textView2, textView3, textView4;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.relativeLayout = (RelativeLayout) itemView.findViewById(R.id.rtlFood);
            this.textView1 = (TextView) itemView.findViewById(R.id.tvtype);
            this.textView2 = (TextView) itemView.findViewById(R.id.tvname);
            this.textView3 = (TextView) itemView.findViewById(R.id.tvversion);
            this.textView4 = (TextView) itemView.findViewById(R.id.tvnumber2);
        }

    }

}
