package com.moosa.dagger2.adaptor;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.moosa.dagger2.model.User;
import com.moosa.dagger2.ui.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

public class AdapterRepos extends BaseAdapter {

  private final List<User> userList = new ArrayList<>(0);
  private final Context context;
  private final Picasso picasso;

  @Inject
  public AdapterRepos(MainActivity context, Picasso picasso) {
    this.context = context;
    this.picasso = picasso;
  }

  @Override
  public int getCount() {
    return userList.size();
  }

  @Override
  public User getItem(int position) {
    return userList.get(position);
  }

  @Override
  public boolean hasStableIds() {
    return true;
  }

  @Override
  public long getItemId(int position) {
    return userList.get(position).getId();
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    User userListItem;
    if(convertView == null) {
      userListItem = new RepoListItem(context, picasso);
    } else {
      userListItem = RepoListItem.class.cast(convertView);
    }

    userListItem.setRepo(userList.get(position));

    return userListItem;
  }

  public void swapData(Collection<User> githubRepos) {
    userList.clear();
    if(githubRepos != null) {
      userList.addAll(githubRepos);
    }
    notifyDataSetChanged();
  }

}