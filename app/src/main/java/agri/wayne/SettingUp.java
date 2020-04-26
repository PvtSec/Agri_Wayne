package agri.wayne;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.util.Objects;
import agri.wayne.ServerHandler.ServerCommunication;

public class SettingUp extends AppCompatActivity
{
    ProgressBar splash_spin;
    Button notify;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splash_spin = findViewById(R.id.splash_progress);
        ConnectivityStatus();
    }

    private void ConnectivityStatus()
    {
        ConnectivityManager net = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert net != null;
        if (Objects.requireNonNull(net.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)).getState() == NetworkInfo.State.CONNECTED ||
                Objects.requireNonNull(net.getNetworkInfo(ConnectivityManager.TYPE_WIFI)).getState() == NetworkInfo.State.CONNECTED) {
            ServerCommunication.getData(this);
            launchNext(2300);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Check your Internet Connectivity", Toast.LENGTH_SHORT).show();
        }
    }
    private void launchNext(int ms)
    {
        new CountDownTimer(ms, 100)
        {
            public void onFinish()
            {
                startActivity(new Intent(SettingUp.this, Dashboard.class));
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();
            }
            public void onTick(long timeLeft)
            {
                if(timeLeft <200)
                {
                    splash_spin.animate().alpha(0.0f);
                }
            }
        }.start();
    }
}
