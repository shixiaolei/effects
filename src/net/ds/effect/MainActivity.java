
package net.ds.effect;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final int MAX_SCREEN_SIZE = 3;
    private static final int ROW_COUNT = 4;
    private static final int COLUMN_COUNT = 4;
    
    private EffectSlideView mSlideView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSlideView = (EffectSlideView) findViewById(R.id.slide_view);
        initIcons();
    }
    
    private void initIcons() {
        for (int i = 0; i < MAX_SCREEN_SIZE; i++) {
            CellLayout cellLayout = new CellLayout(this);
            cellLayout.setDimension(COLUMN_COUNT, ROW_COUNT);

            for (int j = 0; j < COLUMN_COUNT; j++) {
                for (int k = 0; k < ROW_COUNT; k++) {
                    TextView textView = new TextView(this);
                    Drawable drawable = this.getResources().getDrawable(getIconResId(k));
                    drawable = new BitmapDrawable(this.getResources(), ((BitmapDrawable) drawable).getBitmap());
                    drawable.setBounds(0, 0, this.getResources().getDimensionPixelSize(R.dimen.app_icon_size), this.getResources().getDimensionPixelSize(R.dimen.app_icon_size));
                    textView.setCompoundDrawables(null, drawable, null, null);
                    cellLayout.addView(textView);
                }
            }
            mSlideView.addView(cellLayout);
        }
    }
    
    private int getIconResId(int j) {
        if (j == 0) {
            return R.drawable.app_0;
        } else if (j == 1) {
            return R.drawable.app_1;
        } else if (j == 2) {
            return R.drawable.app_2;
        } else {
            return R.drawable.app_3;
        }
    }
}
