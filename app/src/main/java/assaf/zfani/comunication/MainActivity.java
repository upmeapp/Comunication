package assaf.zfani.comunication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAmazon();
            }
        });
    }
    public void getAmazon()
    {
        new Thread(){
            public void run()
            {
        try{
            URL url = new URL("https://www.amazon.com");
            InputStream inputStream = url.openStream();
            BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line=bufferedReader.readLine())!=null)
                Log.i("amazon",line);

            bufferedReader.close();


        }
        catch (Exception ex)
        {
            Log.e("amazon","exception",ex);
        }
    }
        }.start();
    }
}

