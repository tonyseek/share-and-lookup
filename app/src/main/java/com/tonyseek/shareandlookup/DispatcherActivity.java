package com.tonyseek.shareandlookup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

public class DispatcherActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Intent intent = getIntent();
        final String action = intent.getAction();
        final String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                final String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);

                if (!TextUtils.isEmpty(sharedText)) {
                    Intent targetIntent = new Intent();
                    targetIntent.setAction(Constant.KINGSOFT_ACTION);
                    targetIntent.putExtra(Constant.KINGSOFT_EXTRAS_WORD, sharedText);
                    startActivity(targetIntent);
                }
            }
        }

        finish();
    }
}
