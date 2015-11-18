package andro.template.drawertemplate.ui.fragment.base;

import android.support.v4.app.Fragment;
import android.view.View;

public abstract class BaseFragment extends Fragment {

    protected View findViewById(int resId) {
        if (getView() != null) {
            return getView().findViewById(resId);
        } else {
            return null;
        }
    }

}
