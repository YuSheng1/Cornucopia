package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016081900289451";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCnHNVhJEqlSRkDHihcWsKsbc2+ipJ6ClC5JEXZ3vVua2giScMbl2mr1feBKfabqOQB1xJIwxI6VKUIk8pgGV7eeKkuondk+3XK3udMSBFOXDS/Cb+yByR2YPqr1kQ8poCu+Ra7LY0b5m50nz9rEch8vBVBv1b2NMRqLchbYMitqX+seBmrDNtWZeAstEYTRru/GA0udy6O80PD1vPr+3dDMqi90B4yCfdqTdebTyiHSTKCXHg5c4rHJUvDZP/quXOxoSejF5xJq71Gx+oPhzf1rapSZoFlXosL4TPF++jajyK+O+lD0L0KU+YXpdR/B0Pby3is6sHnzNNNAxKVyvrTAgMBAAECggEBAJ05YHw7o8ssIc8wIXL6pSuLR0Zco4EUkWwO93UK8siHXvrbgShFZVMZRPqN24oJ9TLSAU7Z0R12I6sVORL+66XNygapLkGg3+sVmnHHYBjkYW/XITbCx4hkp5LiTWLumCWHDt7d9WPpgcRRS15V5dWNM0afWZbcgGsRVe66+TOAvtOhPtWwHh6mLOsj9Ai653dSAd8GIP/zR21S5sOPF2/IO+bSPt+JcLaa5cq/t6cNa5M7HcWROqVgV+NFmuasZmgtu3V0Kv4R2XEFM4tCOAhqiGC8thrYIwD3V5L9+pcQS2nmvjOD3Tg3w39+T+N4xQtEtoHyHJAollUcQBfzhlECgYEA1Ps7ZQScn/VwTAqQt2GMU249Du05GFHQFwh+oBlE+9zQe1LtJYtKDKb7Y1mAffF47RRYmpUyH99tWdbvqHz8esleERFfPo83RstsZRwL0RNJBEbDCP2c7CfWYdTljZp2ovwRGxJDbAZMzw/1LnCwe/XaVMhQKZ16rN8pq1trAJkCgYEAyN3WEL9FWz27zqTxqvcznLUTTd3lijZtRHP9WwIQwqAw+qX0YZ+6QctTCKNR8Uz/cB7l/SsGcH7FlkKlGpgnA8qDazAKbhoxiWgYJQdSFd/nYitrtQ7AckH+Uhq3P0iA8yNXTPLyG7nme3zQpDBGC/OJQuvayOhWEUOeQC/q/ksCgYEAi5nlU5CTTTHmmqEuPFU/Uoxmjzsk+nDd0csqnKwTkHcrXDp94OcM8YAeNP+8flDh75wve5uhkEy183Yz/p92KtGEy/E0GeBr3gaGlTut7ywR5zCutFzwF8cA+X0/vfJqIujQGYt+D/eNLwgJsJgCxi3fH0VxbeWgPGHGgWBZobkCgYBALG+ZxiIYdm6sJJJ5NqUsqcVTGVOehqj+N7h3/P7xz1AWpDKhhfBx2M3ccqFZYGoznguIiNhz1Gy4Bu7MwlOkqGy4MA8FAiVVawZbvi0BhBleidTNcbsWRfNEs/hbpYRdKatYkD29kfUK+uOFsU6PvuzZjpTFn0TwGxRSGX0QZQKBgQCGH+EkUGsAVayQnmPYIQLA1d1zdc2403cJOnUiZ0MsvA0TWZ0KrvWuh7aLWzj/1MEck3y4Ah4loPriJn2NkEYzAiKRNoEpfxNuqB6V7Uv1+X+WTR/40375hZGEGTFfHYin5fBNH37stz1+5gI9SJv8v47CGQI8HTeS3Lk2SoN6og==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnhO9txIdTD9vglXukVLXxFzzk9XfJRGxn4JbzxZdpS3Sr6/ahKXFZoD3jmt+RTBiAbSjAVXOsc/jStlwBT7Zl2k7h0WvM/qMyJY/QZV+pcTii7CuEYtQG8PAaDWe6TSSpXvVvcOOAwqO2Ohv76f2jTAMcgbinQRo9KLSfE5kjti/+buXNGxL7MCJhZsNpl16f2RWfI/SwFF4U3CtyPk91io4HIOcRNMt4oZTs8VAdu8GUpsTb2bm91fb4N/l5iAD53YcyKxlkITb3sx/AC9OCpv1IO/wE7abX3nQfcQ5tBSK5Ge8zVUax8EYgdvnbVhGYYWh9omdk0DdnzstVVSBjwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "/Cornucopia/AG_UserPlay/AlipayTradePagePaySuccessful";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "/Cornucopia/AG_UserPlay/AlipayTradePagePaySuccessful";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

