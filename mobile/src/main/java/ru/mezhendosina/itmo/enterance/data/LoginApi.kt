package ru.mezhendosina.itmo.enterance.data

import okhttp3.ResponseBody
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import javax.net.ssl.HostnameVerifier

interface LoginApi {

    @GET("/auth/realms/itmo/protocol/openid-connect/auth")
    fun getAuthCode(
        @Query("protocol") protocol: String,
        @Query("response_type") responseType: String,
        @Query("client_id") clientId: String,
        @Query("redirect_uri") redirectUri: String,
        @Query("scope") scope: String,
        @Query("state") state: String,
        @Query("code_challenge_method") codeChallengeMethod: String,
        @Query("code_challenge") codeChallenge: String
    )

    @FormUrlEncoded
    @POST("/auth/realms/itmo/protocol/openid-connect/token")
    fun getToken(
        @Field("grant_type") grantType: String,
        @Field("client_id") clientId: Int,
        @Field("code") code: String? = null,
        @Field("code_verifier") codeVerifier: String? = null,
        @Field("redirect_uri") redirectUri: String? = null,
        @Field("refresh_token") refreshToken: String? = null
    )
}