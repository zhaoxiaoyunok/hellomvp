/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lyyj.hellomvp;

import android.support.annotation.NonNull;


import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Concrete implementation to load tasks from the data sources into a cache.
 * <p>
 * For simplicity, this implements a dumb synchronisation between locally persisted data and data
 * obtained from the server, by using the remote data source only if the local database doesn't
 * exist or is empty.
 */
public class Repository implements DataSource {

    private static Repository INSTANCE = null;






    // Prevent direct instantiation.
    private Repository(  ) {


    }

    /**
     * Returns the single instance of this class, creating it if necessary.
     *


     * @return the {@link Repository} instance
     */
    public static Repository getInstance(  ) {
        if (INSTANCE == null) {
            INSTANCE = new Repository( );
        }
        return INSTANCE;
    }

    /**

     * next time it's called.
     */
    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public void saveData(@NonNull String s) {
        checkNotNull(s);
        SPUtil.putString("hellotext",s);


    }

    /**
     * Gets tasks from local data source (sqlite) unless the table is new or empty. In that case it
     * uses the network data source. This is done to simplify the sample.
     * <p>
     * Note:  is fired if both data sources fail to
     * get the data.
     */
    @Override
    public void getData( @NonNull  GetDataCallback callback ) {
        ;
        callback.onDataLoaded(SPUtil.getString("hellotext",""));

    }


}
