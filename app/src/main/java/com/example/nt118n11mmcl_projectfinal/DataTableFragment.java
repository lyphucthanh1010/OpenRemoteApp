package com.example.nt118n11mmcl_projectfinal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

public class DataTableFragment extends Fragment {
    private Context context;
    private ListView lvContact;
    private List<DataGraph> dataGraphs;
    private DataGraphAdapter dataGraphAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_sql, container, false);
        this.context = getContext();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String pathdb = getActivity().getDatabasePath("dataManager").getPath();
        GraphDatabaseHelper db = new GraphDatabaseHelper(context);
        this.dataGraphs = db.getAllContacts();
        this.lvContact = (ListView) view.findViewById(R.id.lvContact);
        this.dataGraphAdapter = new DataGraphAdapter(this.dataGraphs);
        this.lvContact.setAdapter(dataGraphAdapter);
        this.lvContact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (db.deleteContact(dataGraphs.get(position).getIddtb())) {
                    Toast.makeText(context, "Đã xóa " + dataGraphs.get(position).getName(), Toast.LENGTH_SHORT).show();

                    Log.d("Delete Database", "Đã xóa: " + dataGraphs.get(position).getIddtb() + "|" + dataGraphs.get(position).getName());
                } else {
                    Toast.makeText(context, "Xóa thất bại!", Toast.LENGTH_SHORT).show();
                    Log.d("Delete Database", "Xóa thất bại");
                }
                dataGraphs.remove(position); // Xóa trên giao diện
                dataGraphAdapter.updateData(); // Cập nhật nó ở trên giao diện
                return false;
            }
        });
        ImageView img2 = view.findViewById(R.id.backpic);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finishAndRemoveTask();
            }
        });
    }
}
