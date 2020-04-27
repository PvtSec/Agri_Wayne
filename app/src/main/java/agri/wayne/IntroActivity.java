package agri.wayne;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenPager;
    agri.wayne.IntroViewPagerAdapter introViewPagerAdapter ;
    TabLayout tabIndicator;
    LinearLayout btnNext;
    int position = 0 ;
    Button btn_en_start, btn_ml_start;
    Animation btnAnim ;
    TextView tvSkip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (restorePrefData())
        {
            Intent mainActivity = new Intent(getApplicationContext(),SettingUp.class );
            startActivity(mainActivity);
            finish();
        }
        setContentView(R.layout.activity_intro);
        btnNext = findViewById(R.id.btn_next);
        btn_en_start = findViewById(R.id.btn_get_started_en);
        btn_ml_start = findViewById(R.id.btn_get_started_ml);
        tabIndicator = findViewById(R.id.tab_indicator);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);
        tvSkip = findViewById(R.id.tv_skip);
        final List<agri.wayne.ScreenItem> mList = new ArrayList<>();
        mList.add(new agri.wayne.ScreenItem("Welcome","We are glad to see you here on Agri Wayne. Swipe right and read through to get a brief idea of how this application help farmers to get most out of their crops.",R.drawable.crop_yield));
        mList.add(new agri.wayne.ScreenItem("Realtime monitoring","Realtime Weather Condition at your fingertip. Relevant data that could help keep your crops stable under weather changes",R.drawable.analytics));
        mList.add(new agri.wayne.ScreenItem("Weather Prediction","Know about upcoming weather, which will help to take necessary precautions to problems caused by temperature varuations or heavy rainfall.",R.drawable.farming));
        mList.add(new agri.wayne.ScreenItem("Crop Suggestion","Confused which crop would be suitable under the current Weather? Here we provide suggestion of crops which can be efficiently grown in your area.",R.drawable.paddy));
        mList.add(new agri.wayne.ScreenItem("Crop Advisory","New to agriculture? Don't worry we provide the perfect crop advisory to maintain your crop through organic farming.",R.drawable.watering));
        mList.add(new agri.wayne.ScreenItem("Get Started","No more waiting, let's get started. Select your comfortable language for the app content. You can change language in-app options",R.drawable.get_started));

        screenPager =findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new agri.wayne.IntroViewPagerAdapter(this,mList);
        screenPager.setAdapter(introViewPagerAdapter);
        tabIndicator.setupWithViewPager(screenPager);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                position = screenPager.getCurrentItem();
                if (position < mList.size())
                {
                    position++;
                    screenPager.setCurrentItem(position);
                }

                if (position == mList.size()-1)
                {
                    loaddLastScreen();
                }
            }
        });

        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {

                if (tab.getPosition() == mList.size()-1)
                {
                    loaddLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });


        btn_en_start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent mainActivity = new Intent(getApplicationContext(),SettingUp.class);
                startActivity(mainActivity);
                savePrefsData();
                finish();
            }
        });

        btn_ml_start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Intent mainActivity = new Intent(getApplicationContext(),MainActivity.class);
                //startActivity(mainActivity);
                //savePrefsData();
                //finish();
                Toast.makeText(getApplicationContext(),"Malayalam Language will be addedd soon",Toast.LENGTH_LONG).show();
            }
        });

        tvSkip.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                screenPager.setCurrentItem(mList.size());
            }
        });
    }

    private boolean restorePrefData()
    {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpnendBefore = pref.getBoolean("isIntroOpnend",false);
        return  isIntroActivityOpnendBefore;
    }

    private void savePrefsData()
    {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpnend",true);
        editor.commit();
    }

    private void loaddLastScreen()
    {
        btnNext.setVisibility(View.INVISIBLE);
        btn_en_start.setVisibility(View.VISIBLE);
        btn_ml_start.setVisibility(View.VISIBLE);
        tvSkip.setVisibility(View.INVISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
        btn_en_start.setAnimation(btnAnim);
        btn_ml_start.setAnimation(btnAnim);
    }
}
