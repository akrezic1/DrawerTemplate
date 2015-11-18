package andro.template.drawertemplate.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import andro.template.drawertemplate.R;
import andro.template.drawertemplate.model.RecyclerItem;
import andro.template.drawertemplate.ui.adapter.RecyclerAdapter;
import andro.template.drawertemplate.ui.fragment.base.BaseFragment;
import andro.template.drawertemplate.ui.util.RecyclerGridMarginDecoration;

/**
 * Created by Andro on 11/18/2015.
 */
public class PagerGridFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pager, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.addItemDecoration(new RecyclerGridMarginDecoration(2, getResources().getDimensionPixelSize(R.dimen.recycler_grid_margin), true));

        RecyclerAdapter adapter = new RecyclerAdapter(getActivity(), getItems());
        recyclerView.setAdapter(adapter);
    }

    private List<RecyclerItem> getItems() {
        List<RecyclerItem> items = new ArrayList<>();
        items.add(new RecyclerItem("https://placeholdit.imgix.net/~text?txtsize=33&txt=720%C3%97300&w=720&h=300", "Lorem Ipsum"));
        items.add(new RecyclerItem("https://placeholdit.imgix.net/~text?txtsize=33&txt=720%C3%97300&w=720&h=300", "Lorem Ipsum"));
        items.add(new RecyclerItem("https://placeholdit.imgix.net/~text?txtsize=33&txt=720%C3%97300&w=720&h=300", "Lorem Ipsum"));
        items.add(new RecyclerItem("https://placeholdit.imgix.net/~text?txtsize=33&txt=720%C3%97300&w=720&h=300", "Lorem Ipsum"));
        items.add(new RecyclerItem("https://placeholdit.imgix.net/~text?txtsize=33&txt=720%C3%97300&w=720&h=300", "Lorem Ipsum"));
        items.add(new RecyclerItem("https://placeholdit.imgix.net/~text?txtsize=33&txt=720%C3%97300&w=720&h=300", "Lorem Ipsum"));
        items.add(new RecyclerItem("https://placeholdit.imgix.net/~text?txtsize=33&txt=720%C3%97300&w=720&h=300", "Lorem Ipsum"));
        items.add(new RecyclerItem("https://placeholdit.imgix.net/~text?txtsize=33&txt=720%C3%97300&w=720&h=300", "Lorem Ipsum"));
        items.add(new RecyclerItem("https://placeholdit.imgix.net/~text?txtsize=33&txt=720%C3%97300&w=720&h=300", "Lorem Ipsum"));
        items.add(new RecyclerItem("https://placeholdit.imgix.net/~text?txtsize=33&txt=720%C3%97300&w=720&h=300", "Lorem Ipsum"));
        return items;
    }

}
