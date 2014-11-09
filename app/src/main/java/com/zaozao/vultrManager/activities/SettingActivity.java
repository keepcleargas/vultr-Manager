package com.zaozao.vultrManager.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.zaozao.vultrManager.R;
import com.zaozao.vultrManager.events.ApiKeyChanged;
import com.zaozao.vultrManager.utils.ApiKeyStore;
import com.zaozao.vultrManager.utils.BusProvider;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by chenqisheng on 14/11/9.
 */
public class SettingActivity extends BaseActivity {
    @InjectView(R.id.back)
    LinearLayout back;
    @InjectView(R.id.api_key)
    EditText apiKey;
    @InjectView(R.id.save)
    Button save;
    private boolean hasKey;

    ApiKeyStore apiKeyStore = ApiKeyStore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.inject(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        if (apiKeyStore.getApiKey(this) != "") {
            apiKey.setText(apiKeyStore.getApiKey(this));
            hasKey = true;
            save.setText(getString(R.string.clear));
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hasKey) {
                    apiKeyStore.setApiKey(SettingActivity.this, "");
                    apiKey.setText("");
                    save.setText(getString(R.string.save));

                    BusProvider.getBus().post(new ApiKeyChanged(true));
                } else {
                    apiKeyStore.setApiKey(SettingActivity.this, apiKey.getText().toString().trim());
                    save.setText(getString(R.string.clear));

                    BusProvider.getBus().post(new ApiKeyChanged(true));
                }
            }
        });
    }
}
