package lib.kalu.adapter.manager;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * description: fix-bug-IndexOutOfBoundsException: Inconsistency detected. Invalid view holder adapter的解决方案
 * created by kalu on 2017/3/24 15:05
 */
public final class CrashLinearLayoutManager extends LinearLayoutManager {
    private static final String TAG = CrashLinearLayoutManager.class.getSimpleName();

    public CrashLinearLayoutManager(Context context) {
        super(context);
    }

    public CrashLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public CrashLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e) {
            // Log.e(TAG, e.getMessage(), e);
        }
    }

    /**********************************************************************************************/

    private boolean isScrollEnabled = true;

    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }

    @Override
    public boolean canScrollVertically() {
        //Similarly you can customize "canScrollHorizontally()" for managing horizontal scroll
        return isScrollEnabled && super.canScrollVertically();
    }

    /**********************************************************************************************/
}
