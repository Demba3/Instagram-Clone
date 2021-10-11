package fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.instagram_clone.Post;
import com.example.instagram_clone.PostAdapter;
import com.example.instagram_clone.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends PostsFragment {
    private final String TAG = "PROFILEFRAGMENT";

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        rvPost = view.findViewById(R.id.rvPost);
        adapter = new PostAdapter(allPost, getContext());
        layoutManager = new GridLayoutManager(getContext(),2);
        rvPost.setAdapter(adapter);
        rvPost.setLayoutManager(layoutManager);
        queryPost();
    }

    @Override
    protected void queryPost() {
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.Key_USER);
        query.setLimit(20);
        query.whereEqualTo(Post.Key_USER, ParseUser.getCurrentUser());
        query.addDescendingOrder(Post.KEY_CREATED_KEY);
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if(e != null){
                    Log.e(TAG, "problem getting post", e);
                    return;
                }
                allPost.addAll(posts);
                for(Post post : posts){
                    Log.i(TAG,  "Post " + post.getDescription() + " user " + post.getUser().getUsername());
                }
                adapter.notifyDataSetChanged();
            }
        });
    }
}