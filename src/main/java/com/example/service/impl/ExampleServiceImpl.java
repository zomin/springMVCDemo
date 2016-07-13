package com.example.service.impl;

import com.example.dao.ExampleDao;
import com.example.model.User;
import com.example.model.UserBind;
import com.example.service.ExampleService;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.internal.util.StringUtils;
import com.taobao.api.request.TradeFullinfoGetRequest;
import com.taobao.api.request.TradesSoldIncrementGetRequest;
import com.taobao.api.response.TradeFullinfoGetResponse;
import com.taobao.api.response.TradesSoldIncrementGetResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhan005 on 2016-03-18. Time:11:49 desc:
 */
@Service
public class ExampleServiceImpl implements ExampleService {
    private static final String TAG = "ExampleServiceImpl";
//    private static final Logger LOG = LogManager.getLogger(ExampleServiceImpl.class);

    @Autowired
    private ExampleDao exampleDao;

    @Override
    public User get(String mixMobile) {
        return exampleDao.get(mixMobile);
    }

    @Override
    public int save(User user) {
        return exampleDao.save(user);
    }

    @Override
    public int updateSave(User user) {
        return exampleDao.updateUser(user);
    }

    @Override
    public UserBind getBindUser(int userId) {
        return exampleDao.getBindUser(userId);
    }

    @Override
    public int saveBindUser(UserBind userBind) {
        return exampleDao.saveBindUser(userBind);
    }

    @Override
    public int delBindUser(UserBind userBind) {
        return exampleDao.delBindUser(userBind);
    }
    //单身fields
    public static final String TRADE_DETAIL_FILED =
            "end_time," +//交易结束时间
                    "buyer_message," +//买家留言
                    "shipping_type," +//创建交易时的物流方式
                    "buyer_cod_fee," +//买家货到付款服务费
                    "seller_cod_fee," +//卖家货到付款服务费
                    "express_agency_fee," +//快递代收款
                    "alipay_warn_msg," +//淘宝下单成功了,但由于某种错误支付宝订单没有创建时返回的信息
                    "adjust_fee," +//卖家手工调整金额
                    "status," +//交易状态。可选值: * TRADE_NO_CREATE_PAY(没有创建支付宝交易) * WAIT_BUYER_PAY(等待买家付款) * WAIT_SELLER_SEND_GOODS(等待卖家发货,即:买家已付款) * WAIT_BUYER_CONFIRM_GOODS(等待买家确认收货,即:卖家已发货) * TRADE_BUYER_SIGNED(买家已签收,货到付款专用) * TRADE_FINISHED(交易成功) * TRADE_CLOSED(付款以后用户退款成功，交易自动关闭) * TRADE_CLOSED_BY_TAOBAO(付款以前，卖家或买家主动关闭交易)
                    "buyer_memo," +//买家备注
                    "seller_memo," +    //卖家备注
                    "pay_time," +//付款时间
                    "modified," +//交易修改时间(用户对订单的任何修改都会更新此字段)
                    "buyer_obtain_point_fee," +//买家获得积分,返点的积分
                    "cod_fee," +//货到付款服务费
                    "buyer_flag," +//买家备注旗帜（与淘宝网上订单的买家备注旗帜对应，只有买家才能查看该字段）
                    "seller_flag," +//卖家备注旗帜（与淘宝网上订单的卖家备注旗帜对应，只有卖家才能查看该字段）
                    "trade_from," +//交易来源。 WAP(手机);HITAO(嗨淘);TOP(TOP平台);TAOBAO(普通淘宝);JHS(聚划算)
                    "seller_nick," +//卖家昵称
                    "buyer_nick," +//买家昵称
                    "title," +//交易标题，以店铺名作为此标题的值
                    "type," +//交易类型列表，同时查询多种交易类型可用逗号分隔。默认同时查询guarantee_trade, auto_delivery, ec, cod的4种交易类型的数据 可选值 fixed(一口价) auction(拍卖) guarantee_trade(一口价、拍卖) auto_delivery(自动发货) independent_simple_trade(旺店入门版交易) independent_shop_trade(旺店标准版交易) ec(直冲) cod(货到付款) fenxiao(分销) game_equipment(游戏装备) shopex_trade(ShopEX交易) netcn_trade(万网交易) external_trade(统一外部交易)
                    "created," +//交易创建时间
                    "iid," +//商品字符串编号
                    "price," +//商品价格
                    "pic_path," +//商品图片绝对途径
                    "num," +//商品购买数量
                    "tid," +//交易编号 (父订单的交易编号)
                    "alipay_no," +//支付宝交易号
                    "payment," +//实付金额
                    "" +
                    "," +//系统优惠金额（如打折，VIP，满就送等）
                    "snapshot_url," +//交易快照地址
                    "snapshot," +//交易快照详细信息
                    "seller_rate," +//卖家是否已评价。可选值:true(已评价),false(未评价)
                    "buyer_rate," +//买家是否已评价。可选值:true(已评价),false(未评价)
                    "trade_memo," +//交易备注
                    "point_fee," +//买家使用积分
                    "real_point_fee," +//买家实际使用积分（扣除部分退款使用的积分）
                    "total_fee," +//商品金额（商品价格乘以数量的总金额）
                    "post_fee," +//邮费
                    "buyer_alipay_no," +//买家支付宝账号
                    "receiver_name," +//收货人的姓名
                    "receiver_state," +//收货人所在省份
                    "receiver_city," +//收货人的所在城市
                    "receiver_district," +//收货人的所在地区
                    "receiver_address," +//收货人的详细地址
                    "receiver_zip," +//收货人的邮编
                    "receiver_mobile," +//收货人的手机号码
                    "receiver_phone," +//收货人的电话号码
                    "consign_time," +//卖家发货时间
                    "buyer_email," +//买家邮件地址
                    "commission_fee," +//交易佣金
                    "seller_alipay_no," +//卖家支付宝账号
                    "seller_mobile," +//卖家手机
                    "seller_phone," +//卖家电话
                    "seller_name," +//卖家姓名
                    "seller_email," +//卖家邮箱
                    "available_confirm_fee," +//交易中剩余的确认收货金额（这个金额会随着子订单确认收货而不断减少，交易成功后会变为零）
                    "has_post_fee," +//是否包含邮费。与available_confirm_fee同时使用。可选值:true(包含),false(不包含)
                    "received_payment," +//卖家实际收到的支付宝打款金额（由于子订单可以部分确认收货，这个金额会随着子订单的确认收货而不断增加，交易成功后等于买家实付款减去退款金额）
                    "cod_status," +//货到付款物流状态
                    "timeout_action_time," +//超时到期时间
                    "is_3D," +//是否是3D淘宝交易
                    "num_iid," +//商品数字编号
                    "promotion," +//交易促销详细信息
                    "invoice_name," +//发票抬头
                    "alipay_url," +//创建交易接口成功后，返回的支付url
                    "orders.total_fee," +//应付金额（商品价格 * 商品数量 + 手工调整金额 - 订单优惠金额）
                    "orders.discount_fee," +//订单优惠金额
                    "orders.adjust_fee," +//手工调整金额
                    "orders.payment," +//子订单实付金额
                    "orders.modified," +//订单修改时间
                    "orders.item_meal_id," +//套餐ID
                    "orders.status," +//订单状态（请关注此状态，如果为TRADE_CLOSED_BY_TAOBAO状态，则不要对此订单进行发货，切记啊！）。可选值:TRADE_NO_CREATE_PAY(没有创建支付宝交易)WAIT_BUYER_PAY(等待买家付款)WAIT_SELLER_SEND_GOODS(等待卖家发货,即:买家已付款)WAIT_BUYER_CONFIRM_GOODS(等待买家确认收货,即:卖家已发货)TRADE_BUYER_SIGNED(买家已签收,货到付款专用)TRADE_FINISHED(交易成功)TRADE_CLOSED(付款以后用户退款成功，交易自动关闭)TRADE_CLOSED_BY_TAOBAO(付款以前，卖家或买家主动关闭交易)
                    "orders.refund_id," +//最近退款ID
                    "orders.iid," +//商品的字符串编号(注意：iid近期即将废弃，请用num_iid参数)
                    "orders.sku_id," +//商品的最小库存单位Sku的id.可以通过taobao.item.sku.get获取详细的Sku信息
                    "orders.sku_properties_name," +//SKU的值
                    "orders.item_meal_name," +//套餐的值。如：M8原装电池:便携支架:M8专用座充:莫凡保护袋
                    "orders.num," +//购买数量
                    "orders.title," +//商品标题
                    "orders.price," +//商品价格
                    "orders.pic_path," +//商品图片的绝对路径
                    "orders.seller_nick," +//卖家昵称
                    "orders.buyer_nick," +//买家昵称
                    "orders.refund_status," +//退款状态。退款状态。可选值 WAIT_SELLER_AGREE(买家已经申请退款，等待卖家同意) WAIT_BUYER_RETURN_GOODS(卖家已经同意退款，等待买家退货) WAIT_SELLER_CONFIRM_GOODS(买家已经退货，等待卖家确认收货) SELLER_REFUSE_BUYER(卖家拒绝退款) CLOSED(退款关闭) SUCCESS(退款成功)
                    "orders.oid," +//子订单编号
                    "orders.outer_iid," +//商家外部编码(可与商家外部系统对接)
                    "orders.outer_sku_id," +//外部网店自己定义的Sku编号
                    "orders.snapshot_url," +//订单快照URL
                    "orders.snapshot," +//订单快照详细信息
                    "orders.timeout_action_time," +//订单超时到期时间
                    "orders.buyer_rate," +//买家是否已评价。可选值：true(已评价)，false(未评价)
                    "orders.seller_rate," +//卖家是否已评价。可选值：true(已评价)，false(未评价)
                    "orders.seller_type," +//卖家类型，可选值为：B（商城商家），C（普通卖家）
                    "orders.num_iid," +//商品数字ID
                    "orders.cid," +//交易商品对应的类目ID
                    "orders.is_oversold,"+//是否超卖
                    "orders.outer_sku_id"+
                    "promotion_details"; //促销详情
    @Override
    public String pullOrder(){
        try{
            TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "23383310", "59f8e5b746fcbabe2a122505a6bcf1c9");
            TradesSoldIncrementGetRequest req = new TradesSoldIncrementGetRequest();
            req.setFields("tid,type,status,payment,orders,rx_audit_status");
            req.setStartModified(StringUtils.parseDateTime("2016-07-13 00:00:00"));
            req.setEndModified(StringUtils.parseDateTime("2016-07-13 23:59:59"));
            req.setPageNo(1L);
            req.setPageSize(40L);
            req.setUseHasNext(true);
            TradesSoldIncrementGetResponse rsp = client.execute(req, "6100125b58fbf022252932a9f87d31947139c1fe20aa532371812181");
            System.out.println("Head:"+rsp.getBody());

            TradeFullinfoGetRequest fullReq = new TradeFullinfoGetRequest();
            fullReq.setFields(TRADE_DETAIL_FILED);
            fullReq.setTid(Long.valueOf("1371322440329745"));
            TradeFullinfoGetResponse response = client.execute(fullReq,"6100125b58fbf022252932a9f87d31947139c1fe20aa532371812181");
            System.out.println("Full:"+response.getBody());
            return rsp.getBody();
        }catch (Exception ex){
            ex.printStackTrace();
            return "";
        }
    }

}