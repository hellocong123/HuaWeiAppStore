package com.cong.huaweiappstore.http;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author Cong
 * @date 2018/2/5
 * @description
 */

public interface ApiService {

    @GET("recommend")
    Observable<Recommend> getRecommendData();
}
