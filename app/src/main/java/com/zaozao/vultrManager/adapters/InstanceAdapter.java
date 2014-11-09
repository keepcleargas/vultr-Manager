package com.zaozao.vultrManager.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zaozao.vultrManager.R;
import com.zaozao.vultrManager.data.Instance;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by chenqisheng on 14/11/9.
 */
public class InstanceAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private List<Instance> instanceList;

    public InstanceAdapter(Context mContext, List<Instance> instanceLit) {
        this.mContext = mContext;
        this.inflater = LayoutInflater.from(mContext);
        this.instanceList = instanceLit;
    }

    @Override
    public int getCount() {
        return instanceList.size();
    }

    @Override
    public Instance getItem(int position) {
        return instanceList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_instance, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Instance instance = getItem(position);
        if (instance.getLabel().equals("")) {
            holder.name.setText(instance.getSubId());
        } else {
            holder.name.setText(instance.getLabel());
        }
        holder.ip.setText(instance.getIp() + " " + instance.getStatus());
        return convertView;
    }

    class ViewHolder {
        @InjectView(R.id.name)
        TextView name;
        @InjectView(R.id.ip)
        TextView ip;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
