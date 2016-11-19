package cl.telematica.android.certamen3.Interactors;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cl.telematica.android.certamen3.HttpServerConnection;
import cl.telematica.android.certamen3.Interfaces.MainInteractor;
import cl.telematica.android.certamen3.Interfaces.OnMainFinishListener;
import cl.telematica.android.certamen3.Models.Feed;

public class MainInteractorImpl implements MainInteractor {
    @Override
    public void get_information(final OnMainFinishListener listener) {

        AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {

            @Override
            protected void onPreExecute(){
            }

            @Override
            protected String doInBackground(Void... params) {
                String resultado = new HttpServerConnection().connectToServer("http://www.mocky.io/v2/582eea8b2600007b0c65f068", 15000);

                return resultado;
            }

            @Override
            protected void onPostExecute(String result) {
                listener.succesful_conn();
                if(result != null){
                    listener.get_succesful(getFeeds(result));

                }
            }
            @Override
            protected void onCancelled(){

            }
        };

        task.execute();
    }

    public List<Feed> getFeeds(String result) {
        List<Feed> feeds = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject responseData = jsonObject.getJSONObject("responseData");
            JSONObject feedObj = responseData.getJSONObject("feed");

            JSONArray entries = feedObj.getJSONArray("entries");
            int size = entries.length();
            for(int i = 0; i < size; i++){
                JSONObject entryObj = entries.getJSONObject(i);
                Feed feed = new Feed();

                feed.setTitle(entryObj.optString("title"));
                feed.setLink(entryObj.optString("link"));
                feed.setAuthor(entryObj.optString("author"));
                feed.setPublishedDate(entryObj.optString("publishedDate"));
                feed.setContent(entryObj.optString("content"));
                feed.setImage(entryObj.optString("image"));

                feeds.add(feed);
            }

            return feeds;
        } catch (JSONException e) {
            e.printStackTrace();
            return feeds;
        }
    }

}


