package com.example.projekti.Adapters;





import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projekti.Helpers.Helpers.Upload;
import com.example.projekti.R;
import com.squareup.picasso.Picasso;

import java.util.List;



public class FotoAdapter extends RecyclerView.Adapter<FotoAdapter.ImageViewHolder> {
    private Context mContext;
    private List<Upload> mUploads;

    public FotoAdapter(Context context, List<Upload> uploads)
    {
        mContext=context;
        mUploads=uploads;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from(mContext).inflate(R.layout.item1, viewGroup,false);
        return  new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        Upload uploadCur=mUploads.get(i);
        imageViewHolder.img_description.setText(uploadCur.getImgName());
        Picasso.get()
                .load(uploadCur.getImgUrl())
                .placeholder(R.drawable.imagepreview)
                .fit()
                .centerCrop()
                .into(imageViewHolder.image_view);

    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        public TextView img_description;
        public ImageView image_view;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            img_description=itemView.findViewById(R.id.img_description);
            image_view=itemView.findViewById(R.id.image_view);
        }
    }
}
