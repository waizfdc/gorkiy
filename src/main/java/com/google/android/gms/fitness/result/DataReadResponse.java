package com.google.android.gms.fitness.result;

import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-fitness@@18.0.0 */
public class DataReadResponse extends Response<DataReadResult> {
    public DataSet getDataSet(DataType dataType) {
        return ((DataReadResult) getResult()).getDataSet(dataType);
    }

    public DataSet getDataSet(DataSource dataSource) {
        return ((DataReadResult) getResult()).getDataSet(dataSource);
    }

    public List<DataSet> getDataSets() {
        return ((DataReadResult) getResult()).getDataSets();
    }

    public List<Bucket> getBuckets() {
        return ((DataReadResult) getResult()).getBuckets();
    }

    public Status getStatus() {
        return ((DataReadResult) getResult()).getStatus();
    }
}
