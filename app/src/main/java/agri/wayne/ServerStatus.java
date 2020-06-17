package agri.wayne;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ServerStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.ServerError);
        setContentView(R.layout.activity_server_status);
    }
}