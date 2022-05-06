package dz.esisba.a2cpi_project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import java.util.ArrayList;

import dz.esisba.a2cpi_project.R;
import dz.esisba.a2cpi_project.interfaces.PostsOnItemClickListner;
import dz.esisba.a2cpi_project.models.PostModel;
import dz.esisba.a2cpi_project.navigation_fragments.ProfileFragment;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.myviewholder> {

    private ArrayList<PostModel> PostsHolder;
    private Context context;
    private PostsOnItemClickListner mListner;

    public PostAdapter(ArrayList<PostModel> postsHolder ,PostsOnItemClickListner mlistner) {
        PostsHolder = postsHolder;
        mListner = mlistner;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_post,parent,false);
        return new myviewholder(view , mListner);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        Glide.with(context).load(PostsHolder.get(position).getPublisherPic()).into(holder.img);
        holder.Question.setText(PostsHolder.get(position).getQuestion());
        holder.Name.setText(PostsHolder.get(position).getAskedBy());
        holder.Username.setText("@"+PostsHolder.get(position).getUsername());
        holder.Details.setText(PostsHolder.get(position).getBody());
        holder.Likes.setText(Integer.toString(PostsHolder.get(position).getLikesCount()));
        holder.Answers.setText(Integer.toString(PostsHolder.get(position).getAnswersCount()));
        holder.Date.setText(PostsHolder.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return PostsHolder.size();
    }

    public static class myviewholder extends RecyclerView.ViewHolder {

        ImageView likeBtn;
        ImageView img;
        TextView Question,Details,Name,Username,Likes,Answers,Date;

        public myviewholder (@NonNull View itemView , PostsOnItemClickListner listner){
            super(itemView);
            img = itemView.findViewById(R.id.img);
            Question = itemView.findViewById(R.id.question);
            Name = itemView.findViewById(R.id.name);
            Username = itemView.findViewById(R.id.usernamep);
            Details = itemView.findViewById(R.id.details);
            Likes = itemView.findViewById(R.id.likes);
            Answers = itemView.findViewById(R.id.answers);
            Date = itemView.findViewById(R.id.postDate);
            likeBtn = itemView.findViewById(R.id.questionLikeBtn);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listner != null){
                        int position = getAbsoluteAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listner.onItemClick(position);
                        }
                    }
                }
            });
            itemView.findViewById(R.id.questionShareBtn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listner != null){
                        int position = getAbsoluteAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listner.onShareClick(position);
                        }
                    }
                }
            });
            itemView.findViewById(R.id.answerBtn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listner != null){
                        int position = getAbsoluteAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listner.onAnswerClick(position);
                        }
                    }
                }
            });
            itemView.findViewById(R.id.questionMenuBtn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listner != null){
                        int position = getAbsoluteAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listner.onMenuClick(position,view);
                        }
                    }
                }
            });
        }
    }
}
