package agri.wayne;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.tabs.TabLayout;
import agri.wayne.Adapters.WeatherFragAdapter;
import agri.wayne.ServerHandler.ServerCommunication;

public class Dashboard extends AppCompatActivity
{
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        TabLayout tabs = findViewById(R.id.weather_tabs);
        int orientation = getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            // In landscape
        }
        else
        {
            date = findViewById(R.id.dateNtime);
            date.setText(ServerCommunication.date);
            setListener();
        }
        tabs.setTabGravity(TabLayout.GRAVITY_FILL);



        final ViewPager pager = findViewById(R.id.weather_pager);
        final WeatherFragAdapter adapter = new WeatherFragAdapter(getSupportFragmentManager());

        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);
    }

    private void setListener()
    {
        findViewById(R.id.dash_options).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(), view);
                getMenuInflater().inflate(R.menu.dash_options_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem)
                    {
                        Toast.makeText(getApplicationContext(),menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });

                popupMenu.show();
            }
        });

    }

}
