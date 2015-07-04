package me.doapps.vuelvetecachimbo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import me.doapps.vuelvetecachimbo.R;
import me.doapps.vuelvetecachimbo.model.University;
import me.doapps.vuelvetecachimbo.util.FontUtil;

/**
 * Created by doapps on 7/4/15.
 */
public class UniversityAdapter extends BaseAdapter {
    private List<University> universities;
    private Context context;
    private LayoutInflater inflater;

    public UniversityAdapter(List<University> universities, Context context){
        this.universities = universities;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return universities.size();
    }

    @Override
    public Object getItem(int i) {
        return universities.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder = null;
        University university = universities.get(i);

        if (view == null) {
            view = inflater.inflate(R.layout.item_university, viewGroup, false);
            holder = new Holder();

            holder.name = (TextView) view.findViewById(R.id.name);
            holder.name.setTypeface(FontUtil.setPacifico(context));
            holder.logo = (ImageView) view.findViewById(R.id.logo);
            holder.logo.setImageResource(university.getImage());
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }

        holder.name.setText(university.getName());

        return view;
    }

    class Holder{
        TextView name;
        ImageView logo;
    }
}
