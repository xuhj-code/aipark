package com.huangsipu.introduction.model.local.db;

import com.huangsipu.introduction.AppPark;
import com.huangsipu.introduction.BuildConfig;
import com.litesuits.orm.LiteOrm;

/**
 * @author xhj
 * @date 2019-09-02 11:28
 */
public class DbHelperImpl implements DbHelper {
    private static final String TAG = DbHelperImpl.class.getSimpleName();
    private static DbHelperImpl dbHelperImpl;
    public LiteOrm mLiteOrm;

    private DbHelperImpl() {
        mLiteOrm = LiteOrm.newCascadeInstance(AppPark.getContext(), DataBaseConstant.DB_NAME);
        mLiteOrm.setDebugged(BuildConfig.IS_DEV);
    }

    public static DbHelperImpl getInstance() {
        if (dbHelperImpl == null) {
            synchronized (DbHelperImpl.class) {
                if (dbHelperImpl == null) {
                    dbHelperImpl = new DbHelperImpl();
                }
            }
        }
        return dbHelperImpl;
    }
}
