package com.superman.app.playandroid.apiservice

import com.superman.app.playandroid.base.BaseResponse
import com.superman.app.playandroid.home.ProjectTab
import io.reactivex.Observable
import retrofit2.http.GET

/**
 *
 * @author superman
 * @date 2019-10-23
 */
interface ApiService {


    @GET("project/tree/json")
    fun getProjectTabs(): Observable<BaseResponse<List<ProjectTab>>>

}