package richard.ztesoft.com.sharetest.shareservice;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import richard.ztesoft.com.sharetest.R;

public class MyShareServiceSingleImageActivity extends AppCompatActivity {

    @Bind(R.id.image_view)
    ImageView image_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_share_service_single_image);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        handleSendImage(intent);
    }

    /**
     * 处理分享的单张照片
     *
     * @param intent
     */
    private void handleSendImage(Intent intent) {
        Uri imageUri = intent.getParcelableExtra(Intent.EXTRA_STREAM);
        if (imageUri == null)
            return;
        String imagePath = Environment.getExternalStorageDirectory() + File.separator + "Ctrip/cache/1045904611";
        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
        //Drawable drawable = Drawable.createFromPath(imagePath);
        image_view.setImageBitmap(bitmap);
    }
}
