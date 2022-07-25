package mediapoint.project.mirim_project_0725_02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.fonts.FontVariationAxis;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editUrl;
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUrl = findViewById(R.id.edit_url);
        Button btnGo = findViewById(R.id.btn_go);
        Button btnPrev = findViewById(R.id.btn_prev);
        web = findViewById(R.id.web);

        web.setWebViewClient(new WebClient());
        WebSettings webSet = web.getSettings();
        webSet.setBuiltInZoomControls(true);
        webSet.setJavaScriptEnabled(true);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web.loadUrl(editUrl.getText().toString());
            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web.goBack();
            }
        });

    }
    class WebClient extends WebViewClient {
        public boolean shouldOverrideUrLoading(WebView view, String url){
            return super.shouldOverrideUrlLoading(web, url);
        }
    }
}