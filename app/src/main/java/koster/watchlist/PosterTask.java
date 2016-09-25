package koster.watchlist;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PosterTask extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

    public PosterTask(ImageView imageView)
    {
        this.imageView = imageView;
    }


    protected Bitmap doInBackground(String... urls) {
        String imageurl = urls[0];

        try {
            URL url = new URL(imageurl);
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            return bmp;
        }
        catch(Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }
    }

    protected void onPostExecute(Bitmap result)
    {
        imageView.setImageBitmap(result);
    }
}
