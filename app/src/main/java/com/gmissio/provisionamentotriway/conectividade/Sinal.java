package com.gmissio.provisionamentotriway.conectividade;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

//import do interpretador de Python
//import com.google.common.base.Predicate;
//import org.python.util.PythonInterpreter;

import androidx.appcompat.app.AppCompatActivity;

import com.gmissio.provisionamentotriway.R;



public class Sinal extends AppCompatActivity {


    private Context mContext;
    private Activity mActivity;
    public String statusButton = "VERIFICAÇÃO DE SINAL";
    private LinearLayout mRootLayout;
    private WebView mWebView;
    private Button nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provisionamento8245w5);

        nextButton = findViewById(R.id.buttonnext_8245w5);
        nextButton.setText(statusButton);
        mContext = getApplicationContext();
        mActivity = com.gmissio.provisionamentotriway.conectividade.Sinal.this;

        mRootLayout = findViewById(R.id.root_layout_8245w5);
        mWebView = findViewById(R.id.web_view_8245w5);

        String url = "http://192.168.18.1/html/bbsp/wan/wan.asp";//192.16.0.1

        mWebView.loadUrl(url);
        mWebView.getSettings().setJavaScriptEnabled(true);

        final String js = "javascript:" +
                "document.getElementById('txt_Username').value='Epadmin';" +
                "document.getElementById('txt_Password').value='adminEp';" +
                "document.getElementById('loginbutton').click();" +
                "";


        mWebView.setWebViewClient(new WebViewClient(){
            /*
                void onPageFinished (WebView view, String url)
                    Notify the host application that a page has finished loading. This method is
                    called only for main frame. When onPageFinished() is called, the rendering
                    picture may not be updated yet. To get the notification for the new Picture,
                    use onNewPicture(WebView, Picture).

                Parameters
                    view WebView : The WebView that is initiating the callback.
                    url String : The url of the page.
            */
            public void onPageFinished(WebView view, String url){
                if(Build.VERSION.SDK_INT >= 19){
                    view.evaluateJavascript(js, new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String s) {
                        }
                    });
                }

            }
        });

        nextButton.setEnabled(false);
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        //nextButton.setEnabled(true);
                        verificarSinal();
                    }
                },
                3000);

    }//fim onCreate
    public void nextButton(View view){
        verificarSinal();
    }

    public void verificarSinal(){
        /**/
        mContext = getApplicationContext();
        mActivity = com.gmissio.provisionamentotriway.conectividade.Sinal.this;

        mRootLayout = findViewById(R.id.root_layout_8245w5);
        mWebView = findViewById(R.id.web_view_8245w5);

        String url = "http://192.168.18.1/html/amp/opticinfo/opticinfo.asp";//192.16.0.1

        mWebView.loadUrl(url);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebChromeClient(new WebChromeClient());

        final String js = "javascript: " + "";

        mWebView.setWebViewClient(new WebViewClient(){

            public void onPageFinished(WebView view, String url){
                if(Build.VERSION.SDK_INT >= 19){
                    view.evaluateJavascript(js, new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String s) {
                        }
                    });
                }

            }
        });

    }

}
