package org.daxue;

import com.yufu.idaas.sdk.constants.SDKRole;
import com.yufu.idaas.sdk.exception.YufuInitException;
import com.yufu.idaas.sdk.init.YufuAuth;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

    }

    String tenant = "tn-2a0195075a83449a8ff38e25c73942da";
    String issuer = "testIssuer";
    String userKey = "user_key"; // 存储用户名的键
    String tokenKey = "id_token_key";

    @Test
    public void test() {

        try {
            YufuAuth token = YufuAuth.builder()
                    .privateKeyPath("/Users/daxue0929/Documents/temp/private_key.pem") //上面的私钥
                    .sdkRole(SDKRole.IDP)
                    .issuer(issuer)
                    .tenant(tenant)
                    .keyFingerPrint("FingerPrint")
                    .build();

            Map<String, Object> claims = new HashMap<String, Object>() {
                {
                    put("appInstanceId", "testAppInstanceId");
                    put("customFieldsKey", "customFieldsValue");
                    put(userKey, "xuediwang@yufuid.com");
                    put("name", "xuediwang@yufuid.com");
                    put("sub", "xuediwang@yufuid.com");
                }
            };
            String result = token.generateToken(claims);
            System.out.printf(result);



        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    }
}
