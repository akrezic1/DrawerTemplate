package andro.heklaton.rsc.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import andro.heklaton.rsc.R;
import andro.heklaton.rsc.model.RecyclerItem;
import andro.heklaton.rsc.ui.adapter.RecyclerAdapter;
import andro.heklaton.rsc.ui.fragment.base.BaseRecyclerFragment;
import andro.heklaton.rsc.ui.util.RecyclerGridMarginDecoration;

/**
 * Created by Andro on 11/18/2015.
 */
public class PagerGridFragment extends BaseRecyclerFragment {

    private RecyclerAdapter adapter;
    private GridLayoutManager layoutManager;
    private List<RecyclerItem> items;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pager, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new RecyclerGridMarginDecoration(2, getResources().getDimensionPixelSize(R.dimen.recycler_list_margin), true));

        items = getItems();
        adapter = new RecyclerAdapter(getActivity(), items);
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


    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(false);
        items.add(0, new RecyclerItem("https://placeholdit.imgix.net/~text?txtsize=33&txt=720%C3%97300&w=720&h=300", "Lorem Ipsum"));
        adapter.notifyItemInserted(0);
        if (layoutManager.findFirstCompletelyVisibleItemPosition() == 0) {
            layoutManager.scrollToPosition(0);
        }
    }
}
