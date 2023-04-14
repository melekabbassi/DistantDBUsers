package com.example.distantdbusers;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiHandler {
    @GET("~/public_html/list.php")
    Call<List<User>> getUsers();

    @FormUrlEncoded
    @POST("~/public_html/insert.php")
    Call<User> insertUser(
        @Field("name") String name,
        @Field("username") String username,
        @Field("password") String password,
        @Field("email") String email
    );

    @FormUrlEncoded
    @POST("~/public_html/update.php")
    Call<User> updateUser(
        @Field("id") int id,
        @Field("name") String name,
        @Field("username") String username,
        @Field("password") String password,
        @Field("email") String email
    );

    @FormUrlEncoded
    @POST("~/public_html/delete.php")
    Call<User> deleteUser(
        @Field("id") int id
    );

    @FormUrlEncoded
    @POST("~/public_html/search.php")
    Call<List<User>> searchUser(
        @Field("name") String name
    );
}
