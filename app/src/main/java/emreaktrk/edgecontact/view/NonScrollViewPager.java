package emreaktrk.edgecontact.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NonScrollViewPager extends ViewPager {

  public NonScrollViewPager(Context context) {
    super(context);
  }

  public NonScrollViewPager(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @SuppressLint("ClickableViewAccessibility")
  @Override
  public boolean onTouchEvent(MotionEvent ev) {
    return false;
  }
}
