package com.huangsipu.introduction.view.base;


import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.method.DigitsKeyListener;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huangsipu.introduction.R;
import com.huangsipu.introduction.helper.utils.ImageLoadUtils;


/**
 * 万能的RecyclerView的ViewHolder
 *
 * @author 南尘
 * @date 16-7-30
 */
public class BaseRecyclerHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> views;
    private Context context;

    public BaseRecyclerHolder(Context context, View itemView) {
        super(itemView);
        this.context = context;
        //指定一个初始为8
        views = new SparseArray<>(8);
    }

    /**
     * 取得一个RecyclerHolder对象
     *
     * @param context  上下文
     * @param itemView 子项
     * @return 返回一个RecyclerHolder对象
     */
    public static BaseRecyclerHolder getRecyclerHolder(Context context, View itemView) {
        return new BaseRecyclerHolder(context, itemView);
    }

    public SparseArray<View> getViews() {
        return this.views;
    }

    public Context getContext() {
        return context;
    }

    /**
     * 通过view的id获取对应的控件，如果没有则加入views中
     *
     * @param viewId 控件的id
     * @return 返回一个控件
     */
    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }


    /**
     * @param mCxt
     * @param w
     * @param h
     * @param viewId
     * @param drawableId
     */
    public void setImageResourcePercent(Context mCxt, double w, double h, int viewId, int drawableId) {
        ImageView view = (ImageView) this.getView(viewId);
        view.setLayoutParams(setLayoutParams(mCxt, w, h));
        view.setImageResource(drawableId);
    }

    /**
     * @param mCxt
     * @param w
     * @param h
     * @param viewId
     * @param drawableId
     */
    public void setPlaceholderResourcePercent(Context mCxt, double w, double h, int viewId, int drawableId, int type) {
        ImageView view = this.getView(viewId);
        if (type == 0) {
            view.setLayoutParams(setLayoutParams(mCxt, w, h));
        } else {
            view.setLayoutParams(setRelativeLayoutParams(mCxt, w, h));
        }
        view.setImageResource(drawableId);
    }

    /**
     * @param mCxt
     * @param w
     * @param h
     * @param viewId
     * @param drawableId
     */
    public void setResourcePercent(Context mCxt, double w, double h, int viewId, int drawableId) {
        ImageView view = this.getView(viewId);
        view.setLayoutParams(setRelativeLayoutParams(mCxt, w, h));
        view.setImageResource(drawableId);
    }


    /**
     * 设置view的背景
     *
     * @param viewId
     * @param resId
     */
    public void setViewBackgroundResource(int viewId, int resId) {
        View view = this.getView(viewId);
        view.setBackgroundResource(resId);
    }

    /**
     * 设置view的背景
     *
     * @param viewId
     * @param resId
     */
    public void setViewBackgroundResourcePercent(Context mCxt, double w, double h, int viewId, int resId) {
        View view = this.getView(viewId);
        view.setLayoutParams(setLayoutParams(mCxt, w, h));
        view.setBackgroundResource(resId);
    }

    /**
     * 设置字符串
     */
    public BaseRecyclerHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setVisibility(View.VISIBLE);
        tv.setText(text);
        return this;
    }

    public BaseRecyclerHolder setText(int viewId, String text, String color) {
        TextView tv = getView(viewId);
        tv.setVisibility(View.VISIBLE);
        tv.setTextColor(Color.parseColor(color));
        tv.setText(text);
        return this;
    }

    /**
     * 设置富文本字符串
     */
    public BaseRecyclerHolder setText(int viewId, SpannableString text) {
        TextView tv = getView(viewId);
        tv.setVisibility(View.VISIBLE);
        tv.setText(text);
        return this;
    }


    /**
     * 设置字符串
     * 设置textview的高度
     */
    public BaseRecyclerHolder setText(int viewId, String text, int h) {
        TextView tv = getView(viewId);
        tv.setVisibility(View.VISIBLE);
        tv.setText(text);
        tv.setHeight(h);
        return this;
    }


    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param text
     * @param base
     * @return
     */
    public void setTextByPercent(Context mCxt, double base, int viewId, String text) {

        WindowManager wm = (WindowManager) mCxt.getSystemService(Context.WINDOW_SERVICE);
        assert wm != null;
        int width = wm.getDefaultDisplay().getWidth();
        TextView view = getView(viewId);
        view.setText(text);
        float textSize;
        if (width == 1366) {
            textSize = (float) (base * 30 * 0.7);
            view.setPadding(3, 3, 3, 3);
        } else {
            textSize = (float) (base * 30);
        }
        view.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
    }

    public void setTextByPercent(Context mCxt, double base, int viewId, String text, String color) {

        WindowManager wm = (WindowManager) mCxt.getSystemService(Context.WINDOW_SERVICE);
        assert wm != null;
        int width = wm.getDefaultDisplay().getWidth();
        TextView view = getView(viewId);
        view.setText(text);
        view.setTextColor(Color.parseColor(color));
        float textSize;
        if (width == 1366) {
            textSize = (float) (base * 30 * 0.7);
            view.setPadding(3, 3, 3, 3);
        } else {
            textSize = (float) (base * 30);
        }
        view.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
    }

    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param text
     * @param base
     * @return
     */
    public EditText setEditTextByPercent(Context mCxt, double base, int viewId, int resId,
                                         String text, boolean isEdit, int limit, String digits) {

        WindowManager wm = (WindowManager) mCxt.getSystemService(Context.WINDOW_SERVICE);
        assert wm != null;
        int width = wm.getDefaultDisplay().getWidth();
        EditText view = getView(viewId);
        view.setText(text);
        view.setMaxLines(1);
        if (limit > 0) {
            view.setFilters(new InputFilter[]{new InputFilter.LengthFilter(limit) {
            }});
        }
        if (digits != null && digits.length() > 0) {
            view.setKeyListener(DigitsKeyListener.getInstance(digits));
        }
        if (isEdit) {
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
        }
        if (resId > 0) {
            view.setBackgroundResource(resId);
        }
        float textSize;
        if (width == 1366) {
            textSize = (float) (base * 30 * 0.7);
            view.setPadding(3, 3, 3, 3);
        } else {
            textSize = (float) (base * 30);
        }
        view.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        return view;
    }


    /**
     * 设置图片
     */
    public BaseRecyclerHolder setImageResource(int viewId, int drawableId) {
        ImageView iv = getView(viewId);
        if (iv.getVisibility() == View.GONE) {
            iv.setVisibility(View.VISIBLE);
        }
        ImageLoadUtils.with(context, drawableId, iv);
        return this;
    }

    /**
     * 设置图片
     */
    public BaseRecyclerHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView iv = getView(viewId);
        if (iv.getVisibility() == View.GONE) {
            iv.setVisibility(View.VISIBLE);
        }
        iv.setImageBitmap(bitmap);
        return this;
    }

    /**
     * 设置图片
     */
    public void showImageByUrl(int viewId, String url) {
        final ImageView iv = getView(viewId);
        iv.setVisibility(View.VISIBLE);
        ImageLoadUtils.with(context, url, R.drawable.ic_head_default, iv);
    }

    /**
     * 设置图片
     */
    public void showImageById(int viewId, int ivResourseId) {
        final ImageView iv = getView(viewId);
        iv.setVisibility(View.VISIBLE);
        ImageLoadUtils.with(context, ivResourseId, iv);
    }

    /**
     * 设置图片
     */
    public void showImageByUrlPercent(Context mCxt, double w, double h, int viewId, String url, int type) {
        final ImageView view = getView(viewId);
        if (type == 0) {
            view.setLayoutParams(setLayoutParams(mCxt, w, h));
        } else {
            view.setLayoutParams(setRelativeLayoutParams(mCxt, w, h));
        }
        ImageLoadUtils.with(context, url, R.drawable.ic_head_default, view);
    }

    /**
     * 为ImageView设置网络图片
     */
    public void showRoundImageUrl(int viewId, String url) {
        ImageView view = getView(viewId);
        ImageLoadUtils.withCorner(context, url, R.drawable.ic_head_default, view);
    }

    /**
     * 为ImageView设置网络图片
     */
    public void showRoundImageUrlPercent(Context mCxt, double w, double h, int viewId, String url) {
        ImageView view = getView(viewId);
        view.setLayoutParams(setLayoutParams(mCxt, w, h));
        setMargins(view, 20, 10, 10, 10);
        ImageLoadUtils.withCorner(context, url, R.drawable.ic_head_default, view);
    }


    private static LinearLayout.LayoutParams setLayoutParams(Context mContext, double w, double h) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        int displayWidth = displayMetrics.widthPixels;
        int displayHeight = displayMetrics.heightPixels;
        LinearLayout.LayoutParams layoutParams;
        if (isScreenLANDSCAPE(mContext)) {
            layoutParams = new LinearLayout.LayoutParams((int) ((double) displayHeight * w), (int) ((double) displayHeight * h));
        } else {
            layoutParams = new LinearLayout.LayoutParams((int) ((double) displayWidth * w), (int) ((double) displayWidth * h));
        }

        return layoutParams;
    }

    private static RelativeLayout.LayoutParams setRelativeLayoutParams(Context mContext, double w, double h) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        int displayWidth = displayMetrics.widthPixels;
        int displayHeight = displayMetrics.heightPixels;
        RelativeLayout.LayoutParams layoutParams;
        if (isScreenLANDSCAPE(mContext)) {
            layoutParams = new RelativeLayout.LayoutParams((int) ((double) displayHeight * w), (int) ((double) displayHeight * h));
        } else {
            layoutParams = new RelativeLayout.LayoutParams((int) ((double) displayWidth * w), (int) ((double) displayWidth * h));
        }

        return layoutParams;
    }

    /**
     * 设置margin
     *
     * @param v
     * @param l
     * @param t
     * @param r
     * @param b
     */
    public static void setMargins(View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }

    public static boolean isScreenLANDSCAPE(Context mCxt) {
        Configuration mConfiguration = mCxt.getResources().getConfiguration();
        int ori = mConfiguration.orientation;
        if (ori == 2) {
            return true;
        } else {
            return ori == 1 ? false : false;
        }
    }
}
