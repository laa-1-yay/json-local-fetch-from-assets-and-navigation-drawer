package in.co.jsonnnnnnnnnandnavgationdrawer.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Puja on 8/4/14.
 */
public class ContactUs extends Fragment {

    Context context;
    public ContactUs(Context c)
    {
        context=c;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.contact_us,container,false);
        Button b;
        b=(Button)rootview.findViewById(R.id.button1);
        b.setOnClickListener(new buttonClickListener());
        return rootview;
    }
    public class buttonClickListener implements Button.OnClickListener{

        @Override
        public void onClick(View view) {
            String url ="https://www.facebook.com/TimesofIndia";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    }
}
