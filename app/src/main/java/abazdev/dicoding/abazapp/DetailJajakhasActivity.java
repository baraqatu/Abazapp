package abazdev.dicoding.abazapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import abazdev.dicoding.abazapp.model.Jajakhas;

public class DetailJajakhasActivity extends AppCompatActivity {

    TextView tvName;
    TextView tvDescription;
    ImageView ivPhoto;
    TextView tvCategory;
    Jajakhas jajakhas;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_jajakhas);

        tvName = findViewById(R.id.tv_detail_name);
        tvDescription = findViewById(R.id.tv_detail_desc);
        ivPhoto = findViewById(R.id.iv_detail_photo);
        tvCategory = findViewById(R.id.tv_detail_category);


        jajakhas = getIntent().getParcelableExtra("Jajanan Khas Makassar");

        tvName.setText(jajakhas.getName());
        tvCategory.setText(jajakhas.getCategory());
        tvDescription.setText(jajakhas.getDescription());
        Glide.with(this)
                .load(Integer.valueOf(jajakhas.getPhoto()))
                .apply(new RequestOptions().override(360,240))
                .into(ivPhoto);

    }
}
