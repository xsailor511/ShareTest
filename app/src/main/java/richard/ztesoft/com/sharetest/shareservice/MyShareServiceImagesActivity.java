package richard.ztesoft.com.sharetest.shareservice;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import richard.ztesoft.com.sharetest.R;

public class MyShareServiceImagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_share_service_images);
        Intent intent = getIntent();
        handleSendMultipleImages(intent);

    }


    /**
     * 处理分享的多张照片
     *
     * @param intent
     */
    private void handleSendMultipleImages(Intent intent) {

        ArrayList<Uri> imageUris = intent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
        if (imageUris == null)
            return;
        List<String> list = new ArrayList<>();
        for (Uri uri : imageUris) {
            if (uri != null)
                list.add(getRealPathFromURI(this, uri));
        }

    }


    /**
     * 从uri获取path
     *
     * @param uri
     * @return
     */
    public static String getRealPathFromURI(Context context, Uri uri) {
        if (null == uri) return null;
        final String scheme = uri.getScheme();
        String data = null;
        if (scheme == null)
            data = uri.getPath();
        else if (ContentResolver.SCHEME_FILE.equals(scheme)) {
            data = uri.getPath();
        } else if (ContentResolver.SCHEME_CONTENT.equals(scheme)) {
            Cursor cursor = context.getContentResolver().query(uri, new String[]{MediaStore.Images.ImageColumns.DATA}, null, null, null);
            if (null != cursor) {
                if (cursor.moveToFirst()) {
                    int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                    if (index > -1) {
                        data = cursor.getString(index);
                    }
                }
                cursor.close();
            }
        }
        Log.i("xsailor","picture url = "+data);
        return data;
    }


    /**
     * 判断是否是6.0以上系统
     * @return true是6.0以上，false 6.0以下
     */
    public static boolean isMNC(){
        return Build.VERSION.SDK_INT >=23;
    }

}
