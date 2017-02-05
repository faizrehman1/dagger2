package com.moosa.dagger2.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.moosa.dagger2.AppController;
import com.moosa.dagger2.R;
import com.moosa.dagger2.adaptor.AdapterUsers;
import com.moosa.dagger2.model.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.users_list)
    ListView usersListView;
    private Call<List<User>> getAllUserCall;
    private AdapterUsers usersAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        AppController controller = AppController.get(this);
        usersAdaptor = new AdapterUsers(this, controller.getPicasso());
        usersListView.setAdapter(usersAdaptor);

        getAllUserCall = controller.getService().getAllUsers();

        getAllUserCall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                usersAdaptor.swapData(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (getAllUserCall != null && !getAllUserCall.isCanceled()) {
            getAllUserCall.cancel();
        }
    }
}
