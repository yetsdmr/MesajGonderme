package com.example.mesajgonderme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class adapter  extends BaseAdapter {

    List<model> list;
    Context context;
    Activity activity;

    public adapter(List<model> list, Context context, Activity activity) {
        this.list = list;
        this.context = context;
        this.activity = activity;
    }

    public adapter(List<model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.mesaj_layout,viewGroup,false);
        final EditText editText = view.findViewById(R.id.mesajIcerik);
        Button button = view.findViewById(R.id.buton);
        TextView tel = view.findViewById(R.id.tel);
        TextView isim = view.findViewById(R.id.isim);
        tel.setText(list.get(i).getTel());
        isim.setText(list.get(i).getIsim());
        final String telNo = list.get(i).getTel();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mIcerık= editText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+telNo));
                intent.putExtra("sms_body",mIcerık);
                activity.startActivity(intent);
            }
        });
        return view;
    }
}
