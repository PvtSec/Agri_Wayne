package agri.wayne.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import agri.wayne.WeatherFragments.TodayFragment;
import agri.wayne.WeatherFragments.TomorrowFragment;
import agri.wayne.WeatherFragments.WeekFragment;

public class WeatherFragAdapter extends FragmentStatePagerAdapter
{
    public WeatherFragAdapter(FragmentManager fragmentManager)
    {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0: return new TodayFragment();
            case 1: return new TomorrowFragment();
            case 2: return new WeekFragment();
        }
        return null;
    }


    @Override
    public int getCount()
    {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        switch (position)
        {
            case 0: return "Today";
            case 1: return "Tomorrow";
            case 2: return "Next Week";
            default: return null;
        }
    }
}
