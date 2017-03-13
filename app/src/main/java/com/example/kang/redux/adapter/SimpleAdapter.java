package com.example.kang.redux.adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.kang.redux.R;
import com.example.kang.redux.models.TodoContent;

import java.util.List;

/**
 * Created by kang on 17-3-13.
 */
public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder> implements View.OnClickListener {
    private List<TodoContent> data;
    private OnItemClick listener;

    public SimpleAdapter(@NonNull List<TodoContent> data) {
        this.data = data;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_todo, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        TodoContent todoContent = data.get(position);

        if (todoContent.completed) {
            holder.content.setBackgroundColor(Color.GREEN);
        } else {
            holder.content.setBackgroundColor(Color.RED);
        }

        holder.content.setText(todoContent.content);

        holder.toggle.setTag(new ClickInfo(ClickInfo.Type.TOGGLE,position));
        holder.delete.setTag(new ClickInfo(ClickInfo.Type.DELETE,position));
        holder.toggle.setOnClickListener(this);
        holder.delete.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View v) {

        if (listener == null) {
            return;
        }
        ClickInfo info = (ClickInfo) v.getTag();
        switch (info.type){
            case TOGGLE:
                listener.onItemToggle(info.position);
                break;
            case DELETE:
                listener.onItemDelete(info.position);
                break;
        }

    }

    public void setListener(OnItemClick listener) {
        this.listener = listener;
    }

    public void reloadData(List<TodoContent> content) {
        data.clear();
        data.addAll(content);
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        public View toggle;
        public View delete;
        public TextView content;

        public SimpleViewHolder(View itemView) {
            super(itemView);
            toggle = itemView.findViewById(R.id.toggle);
            delete = itemView.findViewById(R.id.delete);
            content = (TextView) itemView.findViewById(R.id.content);
        }
    }

    public interface OnItemClick {
        void onItemToggle(int position);
        void onItemDelete(int position);
    }

    private static class ClickInfo{
        Type type;
        int position;

        public ClickInfo(Type type, int position) {
            this.type = type;
            this.position = position;
        }

        enum Type {
            DELETE,
            TOGGLE
        }
    }
}
