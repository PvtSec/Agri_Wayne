package agri.wayne;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.tabs.TabLayout;
import agri.wayne.Adapters.CropFragAdapter;
import agri.wayne.CropFragments.BananaFragment;
import agri.wayne.CropFragments.CoffeeFragment;
import agri.wayne.CropFragments.GingerFragment;
import agri.wayne.CropFragments.PepperFragment;
import agri.wayne.CropFragments.RiceFragment;
import agri.wayne.CropFragments.VegetableFragment;
import agri.wayne.ServerHandler.ServerCommunication;

public class Advisory extends AppCompatActivity
{
    CropFragAdapter adapter;
    public static String day, condition;
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advisory);
        setConditionTitle(getIntent().getStringExtra("condition"));
        day = getIntent().getStringExtra("day");
        condition = getIntent().getStringExtra("condition");

        TabLayout tabs = findViewById(R.id.crop_tabs);
        date = findViewById(R.id.dateNtime);
        date.setText(ServerCommunication.date);
        tabs.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager pager = findViewById(R.id.crop_pager);
        adapter = new CropFragAdapter(getSupportFragmentManager());

        add_crop(getIntent().getStringArrayExtra("crops"));
        if (getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE)
        {
            setListener();
        }

        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);

    }

    private void setConditionTitle(String condition)
    {
        TextView title = findViewById(R.id.Advisory_title);
        ImageView image = findViewById(R.id.Advisory_image);

        switch (condition)
        {
            case "Good":
                title.setText(getText(R.string.good_title));
                image.setImageDrawable(getDrawable(R.drawable.ic_good));
                break;
            case "Normal":
                title.setText(getText(R.string.normal_title));
                image.setImageDrawable(getDrawable(R.drawable.ic_normal));
                break;
            case "Bad":
                title.setText(getText(R.string.bad_title));
                image.setImageDrawable(getDrawable(R.drawable.ic_bad));
                break;

            default:
                break;
        }
    }
    public void add_crop(String crops[])
    {
        for(int position=0; position<crops.length; position++)
        {
            String crop = crops[position];
            switch (crop)
            {
                case "Banana":
                    adapter.addFragment(new BananaFragment(),"Banana",position);
                    break;
                case "Coffee":
                    adapter.addFragment(new CoffeeFragment(),"Coffee",position);
                    break;
                case "Ginger":
                    adapter.addFragment(new GingerFragment(),"Ginger",position);
                    break;
                case "Rice":
                    adapter.addFragment(new RiceFragment(),"Rice",position);
                    break;
                case "Pepper":
                    adapter.addFragment(new PepperFragment(),"Pepper",position);
                    break;
                case "Vegetables":
                    adapter.addFragment(new VegetableFragment(),"Vegetables",position);
                    break;

                default:
                    return;

            }
        }

    }
    private void setListener()
    {
        findViewById(R.id.back_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Advisory.super.onBackPressed();
            }
        });

    }
}
