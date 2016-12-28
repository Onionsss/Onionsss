package com.example.zhangqi.onion.api;


import com.jinhuhang.youmi.bean.BankBean;
import com.jinhuhang.youmi.bean.BorrowDetailBean;
import com.jinhuhang.youmi.bean.BorrowList;
import com.jinhuhang.youmi.bean.City;
import com.jinhuhang.youmi.bean.CompareIdcard;
import com.jinhuhang.youmi.bean.CouponBean;
import com.jinhuhang.youmi.bean.HttpWrapper;
import com.jinhuhang.youmi.bean.IdCardFront;
import com.jinhuhang.youmi.bean.InfoBean;
import com.jinhuhang.youmi.bean.LoginBean;
import com.jinhuhang.youmi.bean.MessageBean;
import com.jinhuhang.youmi.bean.MoneyRecordBean;
import com.jinhuhang.youmi.bean.NamePhoneBean;
import com.jinhuhang.youmi.bean.PactBean;
import com.jinhuhang.youmi.bean.ProduceBean;
import com.jinhuhang.youmi.bean.QuestionBean;
import com.jinhuhang.youmi.bean.RepayDetail;
import com.jinhuhang.youmi.bean.RepayParams;
import com.jinhuhang.youmi.bean.User;
import com.jinhuhang.youmi.bean.Version;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

/**
 * Created by zhangqi on 2016/9/12.
 */
public interface Api {

    /**
     * 登录
     * @param phone
     * @param pwd
     * @return
     */
    @FormUrlEncoded
    @POST("user/userLogin.action")
    Observable<HttpWrapper<LoginBean>> login(@Field("phone") String phone, @Field("password") String pwd, @Field("tokenKey") String tokenKey);

    /**
     * 注册获取验证码
     * @param phone
     * @return
     */
    @FormUrlEncoded
    @POST("user/getCode.action")
    Observable<HttpWrapper<String>> getCode(@Field("phone") String phone, @Field("tokenKey") String tokenKey, @Field("event") String event);

    /**
     * 注册
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("user/userRegister.action")
    Observable<HttpWrapper<String>> regist(@Field("phone") String phone, @Field("password") String pwd);

    /**
     * 忘记密码
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("user/updatePassword.action")
    Observable<HttpWrapper<String>> updatePassword(@Field("phone") String phone, @Field("password") String pwd);

    /**
     * 判断手机号是否被注册
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("user/getPersonByPhone.action")
    Observable<HttpWrapper<String>> phoneIsExist(@Field("phone") String phone);

    /**
     * 判断版本更新
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("loan/getVersion.action")
    Observable<HttpWrapper<Version>> getVersion(@Field("name") String name, @Field("channel") String channel);

    /**
     * 身份证正面
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("loan/insertCardInfoz.action")
    Observable<HttpWrapper<String>> commitIdcard(@FieldMap Map<String, String> map, @Field("token") String token);


    /**
     * 身份证反面
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("loan/insertCardInfof.action")
    Observable<HttpWrapper<String>> commitIdcardb(@FieldMap Map<String, String> map, @Field("token") String token);

    /**
     * 节点认证
     * @param userId
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("loan/createBpmNode.action")
    Observable<HttpWrapper<String>> commitNode(@Field("per_id") String userId, @Field("node_id") String node_id);

    /**
     * 节点认证
     * @param userId
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("user/perAccountLog.action")
    Observable<HttpWrapper<List<MoneyRecordBean>>> perAccountLog(@Field("per_id") String userId, @Field("nowPage") int currentPage, @Field("pageSize") int size);

 /**
     * 优惠券列表
     * @param userId
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("user/getMyCoupon.action")
    Observable<HttpWrapper<List<CouponBean>>> getMyCoupon(@Field("per_id") String userId, @Field("couponStatus") String couponStatus, @Field("nowPage") int currentPage, @Field("pageSize") int size);

    /**
     * 判断是否完成认证
     * @param userId
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("loan/checkBpm.action")
    Observable<HttpWrapper<String>> checkNode(@Field("per_id") String userId);

    /**
     * 查看用户是否能使用列表中的优惠券
     * @param userId
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("loan/useCoupon.action")
    Observable<HttpWrapper<String>> useCoupon(@Field("per_id") String userId);

    /**
     * 创建认证
     * @param userId
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("loan/insertPerBpm.action")
    Observable<HttpWrapper<String>> createNode(@Field("per_id") String userId, @Field("token") String token);

    /**
     * 个人信息
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("loan/insertPrivateInfo.action")
    Observable<HttpWrapper<String>> commitPersonInfo(@FieldMap Map<String, String> map, @Field("token") String token);

    /**
     * 银行卡
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("loan/insertBankInfo.action")
    Observable<HttpWrapper<String>> commitBankInfo(@FieldMap Map<String, String> map, @Field("tokenKey") String tokenKey, @Field("token") String token);
    /**
     * 正面
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("loan/ocrFront.action")
    Observable<HttpWrapper<IdCardFront>> commitFrontPhoto(@Field("per_id") String per_id, @Field("photo") String photo, @Field("token") String token);

    /**
     * 正面
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("loan/ocrBack.action")
    Observable<HttpWrapper<IdCardFront>> commitBackPhoto(@Field("per_id") String per_id, @Field("photo") String photo, @Field("token") String token);
    /**
     * 正面
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("loan/compareAll.action")
    Observable<HttpWrapper<String>> compareAll(@Field("per_id") String per_id, @Field("photos") String photo, @Field("token") String token);
    /**
     * 拿到自己的姓名和身份证号
     * @param userId
     * @return
     */
    @FormUrlEncoded
    @POST("loan/getIDNumber.action")
    Observable<HttpWrapper<InfoBean>> getNameAndIdcard(@Field("per_id") String userId);

    /**
     * 提交手机服务密码
     * @param userId
     * @return
     */
    @FormUrlEncoded
    @POST("loan/getPhonePwd.action")
    Observable<HttpWrapper<String>> commitPhonePwd(@Field("per_id") String userId, @Field("phone_pwd") String phone_pwd, @Field("token") String token);

    /**
     * 签约页面的信息
     * @param userId
     * @return
     */
    @FormUrlEncoded
    @POST("loan/getSignInfo.action")
    Observable<HttpWrapper<PactBean>> getSignInfo(@Field("per_id") String userId);

    /**
     * 合同变为已签约
     * @param userId
     * @return
     */
    @FormUrlEncoded
    @POST("loan/signingBorrow.action")
    Observable<HttpWrapper<String>> commitPact(@Field("per_id") String userId, @Field("borr_id") String borr_id
            , @Field("name") String name, @Field("money") String money, @Field("day") String day, @Field("token") String token);

    /**
     * 增加第三方接口调用次数
     * @param userId
     * @return
     */
    @FormUrlEncoded
    @POST("loan/addCount.action")
    Observable<HttpWrapper<String>> addCount(@Field("per_id") String userId, @Field("type") String type
            , @Field("count") String count, @Field("status") String status);

    /**
     * 获取节点认证情况
     * @param userId
     * @return
     */
    @FormUrlEncoded
    @POST("loan/getNodeStatus.action")
    Observable<HttpWrapper<String>> getNodeStatus(@Field("per_id") String userId, @Field("node_id") String node_id, @Field("token") String token);

    /**
     * 合同
     * @param userId
     * @return
     */
    @FormUrlEncoded
    @POST("loan/getContract.action")
    Observable<HttpWrapper<String>> getContract(@Field("per_id") String userId, @Field("borr_id") String borr_id);

    /**
     * 修改密码
     * @param userId
     * @return
     */
    @FormUrlEncoded
    @POST("user/personUpdatePassword.action")
    Observable<HttpWrapper<String>> personUpdatePassword(@Field("per_id") String userId, @Field("oldPassword") String oldPassword
            , @Field("newPassword") String newPassword, @Field("tokenKey") String tokenKey);

    /**
     * 重新获取手机验证服务吗
     * @param userId
     * @return
     */
    @FormUrlEncoded
    @POST("loan/repeatVerifiCode.action")
    Observable<HttpWrapper<String>> getServiceCode(@Field("per_id") String userId, @Field("ID") String id, @Field("token") String token);

    /**
     * 还款
     * @param userId
     * @return
     */
    @FormUrlEncoded
    @POST("callback/repayment.action")
    Observable<HttpWrapper<RepayParams>> repayment(@Field("per_id") String userId, @Field("amount") String amount
            , @Field("conctact_id") String conctact_id, @Field("bank_id") String bank_id
            , @Field("cardNo") String cardNo, @Field("tokenKey") String tokenKey, @Field("token") String token);

  /**
     * 还款的详情
     * @param userId
     * @return
     */
    @FormUrlEncoded
    @POST("user/getRepaymentDetails.action")
    Observable<HttpWrapper<RepayDetail>> getRepaymentDetails(@Field("per_id") String userId, @Field("borr_id") String borr_id);

    /**
     * 重新获取手机验证服务吗
     * @param userId
     * @return
     */
    @FormUrlEncoded
    @POST("user/getPersonInfo.action")
    Observable<HttpWrapper<User>> getPersonInfo(@Field("per_id") String userId);

    /**
     * 提交手机服务密码
     * @param userId
     * @return
     */
    @FormUrlEncoded
    @POST("loan/getVerifiCode.action")
    Observable<HttpWrapper<String>> comitServiceYzm(@Field("per_id") String userId, @Field("VerifiCode") String yzm
            , @Field("ID") String id, @Field("QueryPwd") String QueryPwd, @Field("token") String token);

    /**
     * 选择产品 -- 获取金额
     * @param userId
     * @return
     */
    @FormUrlEncoded
    @POST("loan/getProductsMoney.action")
    Observable<HttpWrapper<List<String>>> getProduceMoney(@Field("per_id") String userId);

    /**
     * 根据Userid 拿到姓名和手机号码
     * @param userId
     * @return
     */
    @FormUrlEncoded
    @POST("loan/getNamePhone.action")
    Observable<HttpWrapper<NamePhoneBean>> getNamePhone(@Field("per_id") String userId);

 /**
     * 根据Userid 拿到常见问题
     * @param userId
     * @return
     */
    @FormUrlEncoded
    @POST("user/getQuestion.action")
    Observable<HttpWrapper<List<QuestionBean>>> getQuestion(@Field("per_id") String userId);

 /**
     * 取消申请中的订单
     * @param userId
     * @return
     */
    @FormUrlEncoded
    @POST("loan/cancelAskBorrow.action")
    Observable<HttpWrapper<String>> cancelAskBorrow(@Field("per_id") String userId, @Field("borr_id") String borr_id, @Field("token") String token);

    /**
     * 消息列表
     * @param userId
     * @return
     */
    @FormUrlEncoded
    @POST("user/getMessageByUserId.action")
    Observable<HttpWrapper<List<MessageBean>>> getMessageByUserId(@Field("per_id") String userId, @Field("nowPage") int nowPage, @Field("pageSize") int pageSize);

    /**
     * 选择产品 -- 获取天数
     * @param userId
     * @return
     */
    @FormUrlEncoded
    @POST("loan/getProductsday.action")
    Observable<HttpWrapper<List<String>>> getProduceTime(@Field("per_id") String userId, @Field("money") String money);

    /**
     * 选择产品 -- 获取结果
     * @param userId
     * @return
     */
    @FormUrlEncoded
    @POST("loan/getProductCharge.action")
    Observable<HttpWrapper<ProduceBean>> getProduceInfo(@Field("per_id") String userId, @Field("money") String money, @Field("day") String day);

    /**
     * 获取银行列表
     * @param
     * @return
     */
    @POST("loan/getBankList.action")
    Observable<HttpWrapper<List<BankBean>>> getBankList();

    /**
     * 首页进去 判断节点
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("loan/getBorrStatus.action")
    Observable<HttpWrapper<String>> getNodeState(@Field("per_id") String per_id);

    /**
     * 首页进去 判断节点
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("loan/borrowProduct.action")
    Observable<HttpWrapper<String>> createProduct(@Field("per_id") String per_id, @Field("product_id") String product_id
            , @Field("plan_repay") String plan_repay, @Field("borr_amount") String borr_amount, @Field("coupon_id") String coupon_id, @Field("token") String token);


    @POST("loan/getCity.action")
    Observable<City> getCity();

    /**
     * 提交本地手机通讯录
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("loan/getPhoneList.action")
    Observable<HttpWrapper<String>> commitContact(@Field("per_id") String per_id, @Field("phone_list") String contact);

    @FormUrlEncoded
    @POST("loan/getPhoneInfo.action")
    Observable<HttpWrapper<String>> getUserPhone(@Field("per_id") String per_id);

    @FormUrlEncoded
    @POST("user/canOfOrder.action")
    Observable<HttpWrapper<String>> canOfOrder(@Field("orderId") String orderId, @Field("token") String token, @Field("info") String info);

    @FormUrlEncoded
    @POST("loan/getRolling.action")
    Observable<HttpWrapper<List<String>>> getRolling(@Field("per_id") String per_id);

    @FormUrlEncoded
    @POST("loan/bpmFinish.action")
    Observable<HttpWrapper<String>> NodeOk(@Field("per_id") String per_id, @Field("token") String token);

    @FormUrlEncoded
    @POST("loan/getCardz.action")
    Observable<HttpWrapper<String>> getIdcardImage(@Field("per_id") String per_id);

    @FormUrlEncoded
    @POST("user/userFeedBack.action")
    Observable<HttpWrapper<String>> userFeedBack(@Field("per_id") String per_id, @Field("content") String content);

    @FormUrlEncoded
    @POST("user/updateMessageStatus.action")
    Observable<HttpWrapper<String>> updateMessageStatus(@Field("per_id") String per_id, @Field("messageId") String messageId);

    @FormUrlEncoded
    @POST("user/getProdModeByBorrId.action")
    Observable<HttpWrapper<BorrowDetailBean>> getProdModeByBorrId(@Field("borrId") String borrId);


    @FormUrlEncoded
    @POST("user/getMyBorrowList.action")
    Observable<HttpWrapper<List<BorrowList>>> getMyBorrowList(@Field("per_id") String per_id, @Field("nowPage") int currentPage, @Field("pageSize") int size);


    //    https://v1-auth-api.visioncloudapi.com/ocr/idcard
    @Multipart
    @POST("identity/liveness_idnumber_verification")
    Observable<CompareIdcard> compareIdcard(@Part("api_id") String api_id,
                                            @Part("api_secret") String api_secret,
                                            @Part("file\"; filename=\"image.png\"") RequestBody imgs,
                                            @Part("name") String name,
                                            @Part("id_number") String idcard);
    @Multipart
    @POST("identity/selfie_idnumber_verification")
    Observable<CompareIdcard> compareIdcardTo(@Part("api_id") String api_id,
                                              @Part("api_secret") String api_secret,
                                              @Part("file\"; filename=\"image.png\"") RequestBody imgs,
                                              @Part("name") String name,
                                              @Part("id_number") String idcard);
    @Multipart
    @POST("ocr/idcard")
    Observable<IdCardFront> commitPhoto(@Part("api_id") String api_id,
                                        @Part("api_secret") String api_secret,
                                        @Part("file\"; filename=\"image.jpg\"") RequestBody imgs,
                                        @Part("side") String side);

    @FormUrlEncoded
    @POST("getBorrStatus")
    Observable<HttpWrapper<String>> getUserBorrowInfo(@Field("per_id") String userId);
}

