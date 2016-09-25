package koster.watchlist;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.widget.Toolbar;
import android.util.StringBuilderPrinter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;


public class MovieInformation extends Fragment {
    private TextView title;
    private TextView year;
    private TextView description;
    private TextView director;
    private TextView actors;
    private ImageView poster;

    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.movie_info, container, false);
        Bundle bundle = this.getArguments();
        String movieInfo = bundle.getString("MovieInfo");
        title = (TextView) v.findViewById(R.id.movie_title);
        year = (TextView) v.findViewById(R.id.year);
        description = (TextView) v.findViewById(R.id.description);
        director = (TextView) v.findViewById(R.id.director);
        actors = (TextView) v.findViewById(R.id.Actors);
        poster = (ImageView) v.findViewById(R.id.poster);


        try {
            JSONObject movie = new JSONObject(movieInfo);
            String movietitle = movie.get("Title").toString();
            String yearnumber = movie.get("Released").toString();
            String plot = movie.get("Plot").toString();
            String actor = movie.get("Actors").toString();
            String direct = movie.get("Director").toString();
            String imageurl = movie.get("Poster").toString();
            new PosterTask(poster).execute(imageurl);
            title.setText(movietitle);
            year.setText(yearnumber);
            actors.setText(actor);
            description.setText(plot);
            director.setText(direct);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return v;
    }

}
