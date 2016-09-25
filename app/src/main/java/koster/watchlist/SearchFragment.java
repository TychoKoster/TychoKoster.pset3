package koster.watchlist;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;


public class SearchFragment extends Fragment {
    public TextView movie;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.search_fragment, container, false);
        final EditText emailText = (EditText) v.findViewById(R.id.emailText);
        Button button = (Button) v.findViewById(R.id.queryButton);
        movie = (TextView) v.findViewById(R.id.responseView);

        movie.setText("");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrieveFeedTask activity = new RetrieveFeedTask();
                String title = emailText.getText().toString();
                try {
                    String movi = activity.execute(title).get();
                    Bundle bundle = new Bundle();
                    bundle.putString("MovieInfo", movi);
                    android.app.FragmentManager fragmentmanager = getFragmentManager();
                    android.app.FragmentTransaction transaction = fragmentmanager.beginTransaction();
                    MovieInformation MovieInformationFragment = new MovieInformation();
                    MovieInformationFragment.setArguments(bundle);
                    transaction.replace(android.R.id.content, MovieInformationFragment);
                    transaction.commit();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
        return v;
    }
}