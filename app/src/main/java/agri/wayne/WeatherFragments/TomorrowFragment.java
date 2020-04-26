package agri.wayne.WeatherFragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import agri.wayne.Advisory;
import agri.wayne.R;
import agri.wayne.ServerHandler.ServerCommunication;

public class TomorrowFragment extends Fragment
{
    private LinearLayout good, normal, bad;
    TextView statement, temp, rain, good_crops, normal_crops, bad_crops;
    String[] good_crop_array, normal_crop_array, bad_crop_array;

    public TomorrowFragment() {}

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_tomorrow, container, false);
        good = view.findViewById(R.id.good_layout);
        normal = view.findViewById(R.id.normal_layout);
        bad = view.findViewById(R.id.bad_layout);
        ImageView statusImg =view.findViewById(R.id.status);

        int imageId = Integer.parseInt(ServerCommunication.imageTomorrow);
        switch (imageId)
        {
            case 1:
                statusImg.setImageResource(R.drawable.ic_sunny);
                break;
            case 2:
                statusImg.setImageResource(R.drawable.ic_cloudy);
                break;
            case 3:
                statusImg.setImageResource(R.drawable.ic_rainy);
                break;
            default:
                break;
        }
        Animation slide_up = AnimationUtils.loadAnimation(getContext(), R.anim.slide);
        statusImg.startAnimation(slide_up);

        statement = view.findViewById(R.id.w_statement);
        temp = view.findViewById(R.id.temp_value);
        rain = view.findViewById(R.id.rain_value);
        good_crops = view.findViewById(R.id.good_crops);
        normal_crops = view.findViewById(R.id.normal_crops);
        bad_crops = view.findViewById(R.id.bad_crops);

        statement.setText(ServerCommunication.stat_tomorrow);
        temp.setText(ServerCommunication.temp_tomorrow+"°C");
        rain.setText(ServerCommunication.rain_tomorrow+"mm");
        good_crops.setText(ServerCommunication.conditions.get(ServerCommunication.good_tomorrow));
        normal_crops.setText(ServerCommunication.conditions.get(ServerCommunication.normal_tomorrow));
        bad_crops.setText(ServerCommunication.conditions.get(ServerCommunication.bad_tomorrow));

        setCrops();
        setListeners();
        return view;
    }


    private void setCrops()
    {
        try
        {
            JSONObject today = ServerCommunication.tomorrow_obj;
            Iterator<String> good_keys = today.getJSONObject("Good").keys();
            Iterator<String> normal_keys = today.getJSONObject("Normal").keys();
            Iterator<String> bad_keys = today.getJSONObject("Bad").keys();

            List<String> good_list = new ArrayList<String>();
            List<String> normal_list = new ArrayList<String>();
            List<String> bad_list = new ArrayList<String>();

            while (good_keys.hasNext())
            {
                String key = good_keys.next();
                good_list.add(key);
            }
            while (normal_keys.hasNext())
            {
                String key = normal_keys.next();
                normal_list.add(key);
            }
            while (bad_keys.hasNext())
            {
                String key = bad_keys.next();
                bad_list.add(key);
            }
            good_crop_array = good_list.toArray(new String[good_list.size()]);
            normal_crop_array = normal_list.toArray(new String[normal_list.size()]);
            bad_crop_array = bad_list.toArray(new String[bad_list.size()]);
        }
        catch (Exception e)
        {
            Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    private void setListeners()
    {
        final ImageView img = getActivity().findViewById(R.id.cloud_image);


        good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_good_advisory = new Intent(getActivity(), Advisory.class);
                start_good_advisory.putExtra("condition", "Good");
                start_good_advisory.putExtra("crops",good_crop_array);
                start_good_advisory.putExtra("day","Tomorrow");

                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), img, "slide_up_cloud");
                startActivity(start_good_advisory, activityOptionsCompat.toBundle());
            }
        });


        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_normal_advisory = new Intent(getActivity(), Advisory.class);
                start_normal_advisory.putExtra("condition", "Normal");
                start_normal_advisory.putExtra("crops",normal_crop_array);
                start_normal_advisory.putExtra("day","Tomorrow");

                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), img, "slide_up_cloud");
                startActivity(start_normal_advisory, activityOptionsCompat.toBundle());

            }
        });


        bad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_bad_advisory = new Intent(getActivity(), Advisory.class);
                start_bad_advisory.putExtra("condition", "Bad");
                start_bad_advisory.putExtra("crops",bad_crop_array);
                start_bad_advisory.putExtra("day","Tomorrow");

                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), img, "slide_up_cloud");
                startActivity(start_bad_advisory, activityOptionsCompat.toBundle());
            }
        });
    }
}