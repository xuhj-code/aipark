package com.example.park.helper.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;

/**
 * 图片加载
 *
 * @author amoslv
 * @date 2018/11/09
 */
public class ImageLoadUtils {

    public static RequestOptions getOptions(int errResId) {
        RequestOptions options = new RequestOptions()
                .error(errResId)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        return options;
    }

    public static RequestOptions getOptionsSkipMemoryCache(int errResId) {
        RequestOptions options = new RequestOptions()
                .error(errResId)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE);
        return options;
    }

    /**
     * int只加载本地图片
     */
    public static void with(Context context, int resId,
                            ImageView imageView) {
        Glide.with(context).load(resId).into(imageView);
    }

    public static void with(Context context, String resId,
                            ImageView imageView) {
        Glide.with(context).load(resId).into(imageView);
    }

    /**
     * byte[]
     */
    public static void with(Context context, byte[] bytes, ImageView iv) {
        Glide.with(context).load(bytes).into(iv);
    }

    /**
     * bitmap
     */
    public static void with(Context context, Bitmap bitmap, ImageView iv) {
        Glide.with(context).load(bitmap).into(iv);
    }

    /**
     * String url
     */
    public static void with(Context context, String imageUrl,
                            int errResId, ImageView imageView) {
        Glide.with(context).load(imageUrl).apply(getOptions(errResId)).into(imageView);
    }

    /**
     * file
     */
    public static void with(Context context, File file,
                            int errResId, ImageView imageView) {
        Glide.with(context).load(file).apply(getOptions(errResId)).into(imageView);
    }

    /**
     * int
     */
    public static void with(Context context, int resId, int errResId, ImageView imageView) {
        Glide.with(context).load(resId).apply(getOptions(errResId)).into(imageView);
    }

    public static void withSkipMemoryCache(Context context, File file,
                                           int errResId, ImageView imageView) {
        Glide.with(context).load(file).apply(getOptionsSkipMemoryCache(errResId)).into(imageView);
    }

    public static void withSkipMemoryCache(Context context, String file,
                                           int errResId, ImageView imageView) {
        Glide.with(context).load(file).apply(getOptionsSkipMemoryCache(errResId)).into(imageView);
    }

    /**
     * String url,圆形图片
     */
    public static void withCorner(Context context, String imageUrl,
                                  int resId, ImageView imageView) {
        Glide.with(context).load(imageUrl).apply(getOptions(resId).circleCrop()).into(imageView);
    }

    /**
     * int
     */
    public static void withCorner(Context context, int resId, ImageView imageView) {
        Glide.with(context).load(resId).apply(new RequestOptions().circleCrop()).into(imageView);
    }

    public static void withCorner(Context context, String resId, ImageView imageView) {
        Glide.with(context).load(resId).apply(new RequestOptions().circleCrop()).into(imageView);
    }

    /**
     * file
     */
    public static void withCorner(Context context, File file,
                                  int errResId, ImageView imageView) {
        Glide.with(context).load(file).apply(getOptions(errResId).circleCrop()).into(imageView);
    }

    /**
     * 显示圆角图片
     */
    public static void withRoundedCornersSkipMemoryCache(Context context, File file,
                                          int errResId, ImageView imageView) {
        Glide.with(context).load(file).apply(getOptionsSkipMemoryCache(errResId)
                .transforms(new RoundedCorners(DensityUtils.dip2px(context, 5))))
                .into(imageView);

    }

}
