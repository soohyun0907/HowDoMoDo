package com.ssafy.howdomodo.data.datasource.remote.retrofit

import com.google.gson.JsonObject
import com.ssafy.howdomodo.data.datasource.model.GetTheatersResponse
import com.ssafy.howdomodo.data.datasource.model.LoginResponse
import com.ssafy.howdomodo.data.datasource.model.SignUpResponse
import retrofit2.Call
import retrofit2.http.*


interface NetworkService {
    @POST("/users/login")
    fun login(
        @Body loginRequestBody: JsonObject
    ): Call<LoginResponse>

    @POST("/users/join")
    fun signUp(
        @Body signUpRequestBody: JsonObject
    ): Call<SignUpResponse>

    // 회원 정보 조회
    @GET("/users/{userCode}")
    fun userInfo(
        @Path("userCode") userCode: Int
    ): Call<LoginResponse>

    // 회원 정보 수정
    @PUT("/users")
    fun userUpdate(
        @Body signUpRequestBody: JsonObject
    ): Call<SignUpResponse>

    // 회원 탈퇴
    @DELETE("/users/{userCode}")
    fun userDelete(
        @Path("userCode") userCode: Int
    ): Call<SignUpResponse>

    //시도, 구군별 영화관 리스트 조회
    @GET("/theaters/{siName}/{guName}")
    fun getTheaters(
        @Path("siName") siName:String,
        @Path("guName") guName:String
    ): Call<GetTheatersResponse>


}