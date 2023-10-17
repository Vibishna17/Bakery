package com.example.lab_05;




import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ImageAdapter extends PagerAdapter {
    private Context mContext;
    private int[] mImageIds = {R.drawable.img1, R.drawable.img3, R.drawable.img2,R.drawable.img8,R.drawable.img4,R.drawable.img6,R.drawable.img9,R.drawable.img5,R.drawable.img7};
    private ViewPager mViewPager;
    private Handler mHandler;
    private Runnable mRunnable;
    private int mCurrentPage = 0;

    public ImageAdapter(Context context, ViewPager viewPager) {
        mContext = context;
        mViewPager = viewPager;
        mHandler = new Handler();
        mRunnable = new Runnable() {
            public void run() {
                if (mCurrentPage >= getCount()) {
                    mCurrentPage = 0;
                } else {
                    mCurrentPage++;
                }
                mViewPager.setCurrentItem(mCurrentPage, true);
                mHandler.postDelayed(this, 1400); // Auto-scroll after 3 seconds (adjust as needed)
            }
        };
        mHandler.postDelayed(mRunnable, 1400); // Start auto-scroll immediately (adjust as needed)
    }

    @Override
    public int getCount() {
        return mImageIds.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mImageIds[position]);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView) object);
    }
}
