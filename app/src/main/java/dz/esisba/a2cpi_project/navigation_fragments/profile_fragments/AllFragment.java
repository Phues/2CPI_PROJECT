package dz.esisba.a2cpi_project.navigation_fragments.profile_fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import dz.esisba.a2cpi_project.R;
import dz.esisba.a2cpi_project.adapter.AllPostsProfileAdapter;
import dz.esisba.a2cpi_project.adapter.AnswersAdapter;
import dz.esisba.a2cpi_project.interfaces.PostsOnItemClickListner;
import dz.esisba.a2cpi_project.models.PostModel;


public class AllFragment extends Fragment implements PostsOnItemClickListner {

    View parentHolder;
    RecyclerView recyclerView;
    ArrayList<PostModel> AllPostsDataHolder;
    AllPostsProfileAdapter adapter;

    private FirebaseAuth auth;
    private FirebaseUser user;
    private FirebaseFirestore fstore;
    private CollectionReference postRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentHolder = inflater.inflate(R.layout.fragment_all, container, false);

        auth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        user = auth.getCurrentUser();
        postRef = fstore.collection("Posts");


        /*PostModel Post1 = new PostModel(R.drawable.exemple, "Adel Mokadem" , "@addy1001" , "What's your Question1" , "details here","1000","500","11:11 AM • 29 APR 22");
        AllPostsDataHolder.add(Post1);
        PostModel Post2 = new PostModel(R.drawable.exemple, "Adel Mokadem" , "@addy1001" , "What's your Question2" , "details here","1000",null,"11:08 AM • 29 APR 22");
        AllPostsDataHolder.add(Post2);
        PostModel Post3 = new PostModel(R.drawable.exemple, "Adel Mokadem" , "@addy1001" , "What's your Question3" , "details here","1000","500","10:45 AM • 29 APR 22");
        AllPostsDataHolder.add(Post3);
        PostModel Post4 = new PostModel(R.drawable.exemple, "Adel Mokadem" , "@addy1001" , "What's your Question4" , "details here","1000",null,"10:30 AM • 29 APR 22");
        AllPostsDataHolder.add(Post4);
        PostModel Post5 = new PostModel(R.drawable.exemple, "Adel Mokadem" , "@addy1001" , "What's your Question5" , "details here","1000",null,"08:25 AM • 29 APR 22");
        AllPostsDataHolder.add(Post5);

       recyclerView.setAdapter(new AllPostsProfileAdapter(AllPostsDataHolder,this));*/

        //FetchAllPosts();

        return parentHolder;
    }

    /*public void FetchAllPosts(){
        AllPostsDataHolder = new ArrayList<>();

        postRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        PostModel post = document.toObject(PostModel.class);
                        if(user.getUid().equals(post.getPublisher())){
                            AllPostsDataHolder.add(post);
                            buildRecyclerView();
                        }
                        DocumentReference DocRef = postRef.document(post.getPostid());
                        DocRef.collection("Answers").whereEqualTo("publisher",user.getUid()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task1) {
                                if (task1.isSuccessful()) {
                                    for (QueryDocumentSnapshot document1 : task1.getResult()) {
                                        PostModel answer = document1.toObject(PostModel.class);
                                        answer.setAnswersCount(-1);
                                        AllPostsDataHolder.add(answer);
                                    }
                                } else {
                                    Toast.makeText(getContext(), "Network error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    }
                } else {
                    Toast.makeText(getActivity(), "Network error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void buildRecyclerView() {
        AllPostsDataHolder = new ArrayList<>();
        recyclerView = parentHolder.findViewById(R.id.recviewAll);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AllPostsProfileAdapter(AllPostsDataHolder,this);
        recyclerView.setAdapter(adapter);

    }*/

    @Override
    public void onAnswerClick(int position) {

    }

    @Override
    public void onShareClick(int position) {

    }


    @Override
    public void onLikeClick(int position, LottieAnimationView lottieAnimationView, TextView likesTxt, boolean isAnswer) {

    }


    @Override
    public void onItemClick(int position) {

    }
}