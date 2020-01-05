package com.example.myhtmlcontent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private TextView textView;

    private  String string = "<h1>Heading 1</h1>\n" +
            "<h2>Heading 1</h2>\n" +
            "<h3>Heading 1</h3>\n" +
            "<p><u><b><i>This is paragraph with bold italic underline</i><b></u></p>\n" +
            "Programming order list\n" +
            "<ol>\n" +
            "<li>C programming</li>\n" +
            "<li>C++ Programming</li>\n" +
            "<li>Java Programming</li>\n" +
            "</ol>\n" +
            "(a+b)<sup>2</sup> = a<sup>2</sup> + b<sup>2</sup> +2ab";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webViewId);
        webView.loadDataWithBaseURL(null, string, "text/html", "utf-8", null);

        textView = (TextView) findViewById(R.id.textViewId);
        textView.setText(Html.fromHtml(string));
    }
}
