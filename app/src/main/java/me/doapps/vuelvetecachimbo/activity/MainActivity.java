package me.doapps.vuelvetecachimbo.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.shamanland.fab.FloatingActionButton;

import me.doapps.vuelvetecachimbo.fragment.DrawerFragment;
import me.doapps.vuelvetecachimbo.R;


public class MainActivity extends ActionBarActivity implements DrawerFragment.DrawerFragmentListener, View.OnClickListener {

    public static String TAG = MainActivity.class.getSimpleName();

    private Toolbar toolbar;
    private DrawerFragment drawerFragment;

    private Button btnEnd;
    private FloatingActionButton fabShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (DrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);

        // display the first navigation drawer view on app launch
        displayView(0);

        btnEnd = (Button) findViewById(R.id.btnEnd);
        btnEnd.setOnClickListener(this);

        fabShare = (FloatingActionButton) findViewById(R.id.fabShare);
        fabShare.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            ChallengeDialog dialog = new ChallengeDialog(MainActivity.this);
            dialog.show();

            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            /*case 0:
                fragment = new PreferenceFragment();
                title = getString(R.string.title_preference);
                break;
            case 1:
                fragment = new ChallengeFragment();
                title = getString(R.string.title_challenge);
                break;
            case 4:
                fragment = new MessagesFragment();
                break;*/
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fabShare:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String sAux = "\nTe invito a descargar esta aplicación:\n\n";
                sAux = sAux + "https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName()+"&hl=es\n\n";
                intent.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(intent, "Compartir"));
                break;
            case R.id.btnEnd:
                startActivity(new Intent(MainActivity.this, ResultActivity.class));
                break;

        }


    }
}
