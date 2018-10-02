package com.dev.honda.network;

import com.dev.honda.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    //    //  (1)
//    @FormUrlEncoded
//    @POST(AppWebServicesURL.API_USER_LOGIN)
//    Call<LoginResponse> login(@Field("Email") String email,
//                              @Field("Password") String password);
//
//    @FormUrlEncoded
//    @POST(AppWebServicesURL.API_CUSTOM_LOGIN)
//    Call<LoginResponse> customlogin(@Field("Email") String email,
//                                    @Field("Password") String password, @Field("ImpersonationUserId") String userId);
//
//    //  (2)
//    @POST(AppWebServicesURL.API_UI_LIST)
//    Call<UIListResponse> UIList(@Header("userToken") String userToken);
//
//    //  (3)
//    @FormUrlEncoded
//    @POST(AppWebServicesURL.API_OFFICE_SETTINGS)
//    Call<OfficeSettingsResponseNEW> OfficeSettings(@Header("userToken") String userToken, @Field("Token") String token);
//
//    //  (4)
//    @FormUrlEncoded
//    @POST(AppWebServicesURL.API_INSPECTIONS_LIST)
//    Call<InspectionsListResponse> InspectionsList(@Header("userToken") String userToken, @Field("Token") String token);
//
//    //  (5)
//    @FormUrlEncoded
//    @POST(AppWebServicesURL.API_READ_USER_SIGNATURE)
//    Call<UserSignatureResponse> ReadUserSignature(@Header("userToken") String userToken, @Field("Token") String token);
//
//    //  (6)
//    @FormUrlEncoded
//    @POST(AppWebServicesURL.API_STATE_LEVEL_FIELDS)
//    Call<StateLevelFieldsResponse> StateLevelFields(@Header("userToken") String userToken, @Field("Token") String token);
//
//    //  (7)
//    @FormUrlEncoded
//    @POST(AppWebServicesURL.API_MASTER_AREA_AND_SETTINGS)
//    Call<MasterAreaAndItemsResponse> MasterAreaAndSettings(@Header("userToken") String userToken, @Field("OfficeId") int officeId);
//
//    //  (8)
//    @POST(AppWebServicesURL.API_APP_VERSION)
//    Call<AppVersionResponse> AppVersionCheck(@Header("userToken") String userToken, @Header("os") String os);
//
//    //  (9)
//    @FormUrlEncoded
//    @POST(AppWebServicesURL.API_CLOSED_INCPECTIONS)
//    Call<ClosedInspectionsResponse> ClosedInspections(@Header("userToken") String userToken, @Field("UserId") int userId);
//
//    //  (10)
//    @FormUrlEncoded
//    @POST(AppWebServicesURL.API_INGOING_LID_REPORT)
//    Call<InspectionReportResponse> getReportIngoingLID(@Header("userToken") String userToken, @Field("InspectionId") int inspectionId);
//
//    //  (11)
//    @FormUrlEncoded
//    @POST(AppWebServicesURL.API_OUTGOING_LID_REPORT)
//    Call<InspectionReportResponse> getReportOutgoingLID(@Header("userToken") String userToken, @Field("InspectionId") int inspectionId);
//
//    //  (12)
//    @FormUrlEncoded
//    @POST(AppWebServicesURL.API_ROUTINE_LID_REPORT)
//    Call<InspectionReportResponse> getReportRoutineLID(@Header("userToken") String userToken, @Field("InspectionId") int inspectionId);
//
//    //  (13)
//    @FormUrlEncoded
//    @POST(AppWebServicesURL.API_INGOING_REPORT)
//    Call<InspectionReportResponse> getReportIngoing(@Header("userToken") String userToken, @Field("InspectionId") int inspectionId);
//
//    //  (14)
//    @FormUrlEncoded
//    @POST(AppWebServicesURL.API_OUTGOING_REPORT)
//    Call<InspectionReportResponse> getReportOutgoing(@Header("userToken") String userToken, @Field("InspectionId") int inspectionId);
//
//    //  (15)
//    @FormUrlEncoded
//    @POST(AppWebServicesURL.API_ROUTINE_REPORT)
//    Call<InspectionReportResponse> getReportRoutine(@Header("userToken") String userToken, @Field("InspectionId") int inspectionId);
//
//    //  (16)
////    @POST(AppWebServicesURL.API_UPDATE_REPORT_STATUS)
////    Call<ServerResponse> updateReportStatus(@Header("deviceId") String deviceId, @Body InspectionStatusDoneNotSyncRequest obj);
////    @Headers("Content-Type:application/x-www-form-urlencoded")
//    @FormUrlEncoded
//    @POST(AppWebServicesURL.API_UPDATE_REPORT_STATUS)
//    Call<ServerResponse> updateReportStatus(@Field("InspectionId") int inspectionId, @Field("InspectionStatusId") int inspectionStatusId, @Header("os") String os,
//                                            @Header("osVersion") String osVersion, @Header("appVersion") String appVersion, @Header("userID") int userID,
//                                            @Header("userEmail") String userEmail, @Header("device") String device,
//                                            @Header("deviceID") String deviceID, @Header("userToken") String userToken, @Header("devicetype") String deviceType);
//
//
//    //  (17)
//    @FormUrlEncoded
//    @POST(AppWebServicesURL.API_CREATE_REPORT)
//    Call<CreateReportResponse> createReport(@Header("userToken") String userToken, @Field("InspectionId") int inspectionId, @Field("OfficeId") int officeId);
//
//    //  (18)
//    @Multipart
//    @POST(AppWebServicesURL.API_UPLOAD_FILE)
//    Call<ServerResponse> uploadFile(@Header("userToken") String userToken, @Part("os") RequestBody os, @Part("inspectionId") RequestBody inspectionId, @Part("officeId") RequestBody officeId
//            , @Part("reportId") RequestBody reportId, @Part("inspectionCompletedDate") RequestBody inspectionCompletedDate,
//                                    @Part("appVersion") RequestBody appVersion, @Part("deviceID") RequestBody deviceID, @Part("devicetype") RequestBody deviceType,
//                                    @Part MultipartBody.Part file);
//
//    //  (19)
//    @Streaming
//    @GET
//    Call<ResponseBody> downloadLIDImageWithDynamicUrlAsync(@Url String fileUrl);
//
//    //  (20)
//    @Multipart
//    @POST(AppWebServicesURL.API_UPLOAD_SIGNATURE)
//    Call<SignatureSaveDeleteResponse> uploadSignatureImage(@Part("os") RequestBody os, @Part("Token") RequestBody token, @Part("gt") RequestBody gt, @Part("guid") RequestBody guid,
//                                                           @Part MultipartBody.Part file);
//
//    //  (20)
//    @Multipart
//    @POST(AppWebServicesURL.API_UPLOAD_TENANT_SIGNATURE)
//    Call<SignatureSaveDeleteResponse> uploadTenantSignatureImage(@Part("os") RequestBody os, @Part("Token") RequestBody token, @Part("gt") RequestBody gt, @Part("guid") RequestBody guid,
//                                                                 @Part("inspectionId") RequestBody inspectionId, @Part MultipartBody.Part file);
//
//    //  (21)
//    @FormUrlEncoded
//    @POST(AppWebServicesURL.API_DELETE_SIGNATURE)
//    Call<SignatureSaveDeleteResponse> deleteSignature(@Field("Token") String token);
//
//    //  (21)
//    @FormUrlEncoded
//    @POST(AppWebServicesURL.API_DELETE_TENANT_SIGNATURE)
//    Call<SignatureSaveDeleteResponse> deleteTenantSignature(@Field("Token") String token, @Field("inspectionId") int inspectionId);
//
//    //  (22)
//    @POST(AppWebServicesURL.API_USER_DEVICE_INFORMATION)
//    Call<SignatureSaveDeleteResponse> saveUserDeviceInfo(@Header("userToken") String userToken, @Header("devicetype") String deviceType, @Body UserDeviceInformationRequest obj);
//
//
//    //  (23)
//    @GET("http://maps.googleapis.com/maps/api/geocode/json")
//    Call<UserCoordinatesResponse> getInspectionCoordinates(@Query("address") String address);
//
    @GET(AppWebServicesURL.GET_USER_DETAIL)
    Call<UserResponse> getUserDetail(@Path("username") String username);
//
//    @GET(AppWebServicesURL.COUNTRIES_STATES_URL)
//    Call<CountriesStatesResponse> getCountriesAndStates();
//
//
//    @GET(AppWebServicesURL.SIGNUP_URL)
//    Call<CountriesStatesResponse> signupRequest(@Query("firstname") String firstname, @Query("lastname") String lastname, @Query("company") String company, @Query("email") String email,
//                                                @Query("phone") String phone, @Query("country") String country, @Query("state") String state, @Query("source") String source);
//
//    //  (18)
//    @Multipart
//    @POST(AppWebServicesURL.API_UPLOAD_DIAGNOSTIC_FILE)
//    Call<ServerResponse> uploadDiagnosticFile(@Header("userToken") String userToken, @Part("os") RequestBody os, @Part("inspectionId") RequestBody inspectionId, @Part("userId") RequestBody userId,
//                                              @Part MultipartBody.Part file);
//
//    //(24)
//    @FormUrlEncoded
//    @POST(AppWebServicesURL.API_FORGET_PASSWORD)
//    Call<LoginResponse> PasswordReset(@Field("Email") String email);
//
//    @POST(AppWebServicesURL.API_THEME)
//    Call<ChristmasThemeResponse> getTheme();
//
//    //(24)
//    @FormUrlEncoded
//    @POST(AppWebServicesURL.API_REPORT_FIELD_NAME_MAPPING)
//    Call<FieldMappingResponse> getFieldMapper(@Header("userToken") String userToken, @Field("officeId") int officeId);
//
//    @FormUrlEncoded
//    @POST(AppWebServicesURL.API_SUGGESTION_LIST)
//    Call<MasterAreaAndItemsResponse> getSuggestionList(@Header("userToken") String userToken, @Field("OfficeId") int officeId);
//
//    @FormUrlEncoded
//    @POST(AppWebServicesURL.API_MOBILE_OTHER_FIELDS)
//    Call<MobileOtherFieldsResponse> getUrlAndNumber(@Header("userToken") String userToken, @Field("token") String token);
//
//    @Multipart
//    @POST(AppWebServicesURL.API_UPLOAD_PROFILE_PICTURE)
//    Call<ProfilePictureResponse> uploadProfilePicture(@Header("userToken") String userToken, @Part("os") RequestBody os, @Part("Token") RequestBody token, @Part("userId") RequestBody userId, @Part("guid") RequestBody guid, @Part MultipartBody.Part file);
//
//    @FormUrlEncoded
//    @POST(AppWebServicesURL.API_CHANGE_PASSWORD)
//    Call<ServerResponse> passwordChange(@Header("userToken") String userToken, @Field("token") String token, @Field("password") String password, @Field("mobile") String mobile, @Field("areaCode") String areaCode);
}
