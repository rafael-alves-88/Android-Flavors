package rafael.alves.flavorsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnToast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text;

                if (BuildConfig.IS_BETA) {
                    text = "BETA";
                } else {
                    text = "PROD";
                }

                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
