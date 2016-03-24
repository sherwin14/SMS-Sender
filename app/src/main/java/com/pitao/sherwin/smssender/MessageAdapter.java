package com.pitao.sherwin.smssender;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Sherwin on 3/23/2016.
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private List<MessageData> messageDataList;

    public MessageAdapter(List<MessageData> messageDataList) {
        this.messageDataList = messageDataList;
    }

    @Override
    public int getItemCount() {
        return messageDataList.size();
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
            final MessageData messageData = messageDataList.get(position);
        holder.mCount.setText(messageData.getCount()+ "");
        holder.mDate.setText(messageData.getDate());
        holder.mBody.setText(messageData.getBody());
        holder.mAddress.setText(messageData.getmAddress());
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).inflate(R.layout.message_list_layout,parent,false);
        return new  MessageViewHolder(itemView);
    }

    public static class MessageViewHolder extends RecyclerView.ViewHolder{
        protected TextView mAddress;
        protected TextView mBody;
        protected TextView mDate;
        protected TextView mCount;

       public MessageViewHolder(View itemView) {
           super(itemView);
            mAddress = (TextView) itemView.findViewById(R.id.txtName);
            mBody = (TextView)  itemView.findViewById(R.id.body);
            mDate = (TextView)  itemView.findViewById(R.id.txtDate);
            mCount = (TextView) itemView.findViewById(R.id.txtCount);
       }
   }
}
