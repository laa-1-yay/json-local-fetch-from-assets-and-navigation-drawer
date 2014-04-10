package in.co.jsonnnnnnnnnandnavgationdrawer.app;


import android.app.FragmentManager;
import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

    String[] events;
    DrawerLayout drawerLayout;
    ListView drawerList;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        events = getResources().getStringArray(R.array.events);
        drawerList = (ListView)findViewById(R.id.listView);
        drawerLayout = (DrawerLayout)findViewById(R.id.container);
        drawerList.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,events));
        drawerList.setOnItemClickListener(new DrawerItemClickListener());


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public class DrawerItemClickListener implements ListView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Fragment fragment;
            if(i<4)
            {
                fragment = new EventFragment(context);
                Bundle args = new Bundle();
                args.putInt("event_number",i);
                fragment.setArguments(args);
            }
            else{
                fragment=new ContactUs(context);
            }
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content,fragment).commit();

            drawerLayout.closeDrawer(drawerList);

        }
    }


}