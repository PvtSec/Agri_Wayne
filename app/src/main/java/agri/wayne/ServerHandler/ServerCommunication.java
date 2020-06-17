package agri.wayne.ServerHandler;

import android.content.Context;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class ServerCommunication extends Fragment
{
    public static int server_status;
    public static String date,
            imageToday, imageTomorrow, imageWeek,
            temp_today, temp_tomorrow, temp_week,
            rain_today, rain_tomorrow, rain_week,
            humi_today, humi_tomorrow, humi_week,
            wind_today, wind_tomorrow, wind_week,
            stat_today, stat_tomorrow, stat_week;
    public static Iterator<String>
            good_today, good_tomorrow, good_week,
            normal_today, normal_tomorrow, normal_week,
            bad_today, bad_tomorrow, bad_week;

    public static  Map<Iterator<String>,String> conditions = new HashMap<>();
    public static JSONObject today_obj, tomorrow_obj, nweek_obj;

    public static void getData(final Context context)
    {
        String url = "http://13.235.238.94:3000/weather_data";
        RequestQueue data_q = Volley.newRequestQueue(context);
        StringRequest data_req = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                server_status = 1;
                try
                {
                    JSONObject params = new JSONObject(response).getJSONObject("Weather");
                    date = params.getString("Date");
                    imageToday = params.getJSONObject("Today").getString("ImageId");
                    imageTomorrow = params.getJSONObject("Tomorrow").getString("ImageId");
                    imageWeek = params.getJSONObject("Next Week").getString("ImageId");
                    //Today variables
                    today_obj = params.getJSONObject("Today").getJSONObject("Condition");
                    stat_today = params.getJSONObject("Today").getString("Statement");
                    temp_today = params.getJSONObject("Today").getString("Temperature");
                    rain_today = params.getJSONObject("Today").getString("Rainfall");
                    humi_today = params.getJSONObject("Today").getString("Humidity");
                    wind_today = params.getJSONObject("Today").getString("Wind Speed");
                    good_today = params.getJSONObject("Today").getJSONObject("Condition").getJSONObject("Good").keys();
                    normal_today = params.getJSONObject("Today").getJSONObject("Condition").getJSONObject("Normal").keys();
                    bad_today = params.getJSONObject("Today").getJSONObject("Condition").getJSONObject("Bad").keys();

                    //Tomorrow Variables
                    tomorrow_obj = params.getJSONObject("Tomorrow").getJSONObject("Condition");
                    stat_tomorrow = params.getJSONObject("Tomorrow").getString("Statement");
                    temp_tomorrow = params.getJSONObject("Tomorrow").getString("Temperature");
                    rain_tomorrow = params.getJSONObject("Tomorrow").getString("Rainfall");
                    humi_tomorrow = params.getJSONObject("Tomorrow").getString("Humidity");
                    wind_tomorrow = params.getJSONObject("Tomorrow").getString("Wind Speed");
                    good_tomorrow = params.getJSONObject("Tomorrow").getJSONObject("Condition").getJSONObject("Good").keys();
                    normal_tomorrow = params.getJSONObject("Tomorrow").getJSONObject("Condition").getJSONObject("Normal").keys();
                    bad_tomorrow = params.getJSONObject("Tomorrow").getJSONObject("Condition").getJSONObject("Bad").keys();

                    //Week variables
                    nweek_obj = params.getJSONObject("Next Week").getJSONObject("Condition");
                    stat_week = params.getJSONObject("Next Week").getString("Statement");
                    temp_week = params.getJSONObject("Next Week").getString("Temperature");
                    rain_week = params.getJSONObject("Next Week").getString("Rainfall");
                    humi_week = params.getJSONObject("Next Week").getString("Humidity");
                    wind_week = params.getJSONObject("Next Week").getString("Wind Speed");
                    good_week = params.getJSONObject("Next Week").getJSONObject("Condition").getJSONObject("Good").keys();
                    normal_week = params.getJSONObject("Next Week").getJSONObject("Condition").getJSONObject("Normal").keys();
                    bad_week = params.getJSONObject("Next Week").getJSONObject("Condition").getJSONObject("Bad").keys();

                    conditions.put(good_today,"");
                    conditions.put(normal_today,"");
                    conditions.put(bad_today,"");
                    conditions.put(good_tomorrow,"");
                    conditions.put(normal_tomorrow,"");
                    conditions.put(bad_tomorrow,"");
                    conditions.put(good_week,"");
                    conditions.put(normal_week,"");
                    conditions.put(bad_week,"");

                    for (Map.Entry<Iterator<String>,String> entry : conditions.entrySet())
                    {
                        while (entry.getKey().hasNext())
                        {
                            String crops = entry.getKey().next();

                            if(entry.getKey().hasNext())
                                conditions.put(entry.getKey(), entry.getValue()+crops+", ");
                            else
                                conditions.put(entry.getKey(), entry.getValue()+crops+"");
                        }
                    }
                }
                catch (Exception e){e.printStackTrace();}
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                //Toast.makeText(context,error.toString(),Toast.LENGTH_SHORT).show();
                server_status = 0;
            }
        });

        data_q.add(data_req);
    }

}
