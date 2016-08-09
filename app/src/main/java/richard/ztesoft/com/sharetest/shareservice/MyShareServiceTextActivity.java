package richard.ztesoft.com.sharetest.shareservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import richard.ztesoft.com.sharetest.R;

public class MyShareServiceTextActivity extends AppCompatActivity {

    @Bind(R.id.shared_text)
    TextView shared_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_share_service_text);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        handleSendText(intent);
    }

    /**
     * 处理分享的文本
     *
     * @param intent
     */
    private void handleSendText(Intent intent) {
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        String sharedTitle = intent.getStringExtra(Intent.EXTRA_TITLE);
        shared_text.setText(sharedText);
    }


}
