package in.co.jsonnnnnnnnnandnavgationdrawer.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Puja on 8/4/14.
 */
public class EventFragment extends Fragment {

    Context context;


    String[] days;

    public EventFragment(Context c){
        context=c;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.event_fragment,container,false);
        int i = getArguments().getInt("event_number");

        try
        {
            JSONObject object = new JSONObject(loadJSONFromAsset());
            JSONArray event_array = object.getJSONArray("eventArray");
            JSONObject event = event_array.getJSONObject(i);
            String name = event.getString("name");
            String date = event.getString("date");
            String description = event.getString("description");
            TextView t1,t2,t3;
            t1 = (TextView) rootview.findViewById(R.id.textView1);
            t2 = (TextView) rootview.findViewById(R.id.textView2);
            t3 = (TextView) rootview.findViewById(R.id.textView3);
            t1.setText(name);
            t2.setText(date);
            t3.setText(description);

        } catch (JSONException e) {
            e.printStackTrace();
        }





        return rootview;
    }
    public String loadJSONFromAsset() {
        String json = null;
        try {

            InputStream is = context.getAssets().open("events_ieee.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

}
