package emreaktrk.edgecontact.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class BaseFragment extends Fragment {

    @LayoutRes protected abstract int getLayoutResId();

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View cell = inflater.inflate(getLayoutResId(), container, false);
        onViewInflated(cell);

        return cell;
    }

    protected abstract void onViewInflated(View view);
}
