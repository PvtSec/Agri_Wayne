package agri.wayne.CropFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.Iterator;

import agri.wayne.Advisory;
import agri.wayne.R;
import agri.wayne.ServerHandler.ServerCommunication;

public class GingerFragment extends Fragment {
    TextView watering, fertilizer, pesticide;
    JSONObject data_obj;

    public GingerFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_ginger, container, false);
        watering = view.findViewById(R.id.water_crops);
        fertilizer = view.findViewById(R.id.fertilizer_crops);
        pesticide = view.findViewById(R.id.pesticide_crops);
        String x = Advisory.day;
        String y = Advisory.condition;

        try
        {
            switch (x)
            {
                case "Today":
                    data_obj = ServerCommunication.today_obj.getJSONObject(y).getJSONObject("Ginger");
                    break;
                case "Tomorrow":
                    data_obj = ServerCommunication.tomorrow_obj.getJSONObject(y).getJSONObject("Ginger");
                    break;
                case "Next Week":
                    data_obj = ServerCommunication.nweek_obj.getJSONObject(y).getJSONObject("Ginger");
                    break;
                default:
                    break;
            }
            JSONObject water = data_obj.getJSONObject("Watering");
            JSONObject ferti = data_obj.getJSONObject("Fertilizer");
            JSONObject pesti = data_obj.getJSONObject("Pesticides");
            String final_adv_water = water.getString("1")+"\n"+water.getString("2")+"\n"+water.getString("3");
            String final_adv_ferti = ferti.getString("1")+"\n"+ferti.getString("2")+"\n"+ferti.getString("3");
            String final_adv_pesti = pesti.getString("1")+"\n"+pesti.getString("2")+"\n"+pesti.getString("3");
            watering.setText(final_adv_water);
            fertilizer.setText(final_adv_ferti);
            pesticide.setText(final_adv_pesti);
        }
        catch (Exception e){Toast.makeText(getContext(),e.toString(),Toast.LENGTH_SHORT).show();}
        return view;
    }
}
