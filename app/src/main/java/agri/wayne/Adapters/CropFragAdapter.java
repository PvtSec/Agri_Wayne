package agri.wayne.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

import agri.wayne.Advisory;
import agri.wayne.CropFragments.BananaFragment;
import agri.wayne.CropFragments.CoffeeFragment;
import agri.wayne.CropFragments.GingerFragment;
import agri.wayne.CropFragments.RiceFragment;
import agri.wayne.WeatherFragments.TomorrowFragment;
import agri.wayne.WeatherFragments.WeekFragment;

public class CropFragAdapter extends FragmentStatePagerAdapter
{
    private final List<Fragment> CropList = new ArrayList<>();
    private final List<String> CropTitleList = new ArrayList<>();

    public CropFragAdapter(FragmentManager fragmentManager)
    {
        super(fragmentManager);
    }


    public Fragment getItem(int position)
    {
        return CropList.get(position);
    }


    @Override
    public int getCount()
    {
        return CropList.size();
    }


    @Override
    public CharSequence getPageTitle(int position)
    {
        return CropTitleList.get(position);
    }

    public void addFragment(Fragment fragment, String title, int position)
    {
        CropList.add(position, fragment);
        CropTitleList.add(position, title);
    }

    public void removeFragment(int position) {
        CropList.remove(position);
        CropTitleList.remove(position);
    }



}
