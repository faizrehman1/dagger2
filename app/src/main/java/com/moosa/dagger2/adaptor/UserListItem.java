package com.moosa.dagger2.adaptor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.moosa.dagger2.R;
import com.moosa.dagger2.model.User;
import com.moosa.dagger2.util.Constants;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("ViewConstructor")
public class UserListItem extends FrameLayout {

    private final Picasso picasso;
    @BindView(R.id.user_avatar)
    ImageView avatarImage;
    @BindView(R.id.user_name)
    TextView name;
    @BindView(R.id.user_company)
    TextView company;
    @BindView(R.id.user_designation)
    TextView designation;
    @BindView(R.id.user_email)
    TextView email;

    public UserListItem(Context context, Picasso picasso) {
        super(context);
        this.picasso = picasso;
        inflate(getContext(), R.layout.list_item_repo, this);
        ButterKnife.bind(this);
    }

    public void setRepo(User user) {
        name.setText(user.getName());
        company.setText(user.getCompany().getName());
        designation.setText(user.getCompany().getBs());
        email.setText(user.getEmail());
        picasso.load(Constants.IMAGE_URL)
                .memoryPolicy(MemoryPolicy.NO_CACHE,MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE,NetworkPolicy.NO_STORE)
                .into(avatarImage);
    }
}