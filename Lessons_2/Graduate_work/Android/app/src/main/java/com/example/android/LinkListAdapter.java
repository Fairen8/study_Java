package com.example.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class LinkListAdapter extends ArrayAdapter<Link> {

    private LayoutInflater layoutInflater;
    private static List<Link> links = new ArrayList<>();
    private int layoutListRow;


    public LinkListAdapter(@NonNull Context context, int resource, @NonNull List<Link> objects) {
        super(context, resource, objects);

        links = objects;
        layoutListRow = resource;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = layoutInflater.inflate(layoutListRow, null);

        Link link_1 = links.get(position);

        if (link_1 != null) {
            TextView link = convertView.findViewById(R.id.link);

            TextPaint paint = link.getPaint();

            Shader textShader = new LinearGradient(0, 0, 0, link.getTextSize(),
                    new int[]{
                            Color.parseColor("#F97C3C"),
                            Color.parseColor("#FDB54E"),
                            Color.parseColor("#64B678"),
                            Color.parseColor("#478AEA"),
                            Color.parseColor("#8446CC"),
                    }, null, Shader.TileMode.CLAMP);
            link.getPaint().setShader(textShader);
            if (link != null)
                link.setText(link_1.getAbbreviated_link());
        }

        return convertView;
    }

    public static Link getLink(int i) {
        return links.get(i);
    }

    public static boolean isExists(String abbreviated_link) {
        if (!links.isEmpty()) {
            for (int i = 0; i < links.size(); i++) {
                if (links.get(i).getAbbreviated_link().equals(abbreviated_link))
                    return true;
            }
        }
        return false;
    }

}
