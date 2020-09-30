package org.daxue.service.common;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AliPayServiceImpl implements AliPayService{

    private static final String FORMAT = "json";
    private static final String CHARSET = "UTF-8";
    private static final String SIGN_TYPE = "RSA2";


    private static final String URL = "https://openapi.alipay.com/gateway.do";
    private static final String
            ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnCXTveCpJOkP0RQ0+yYIB51hvtH1KH4QEBd0RMXfwtUEf4wEo15fr2GltoHGGxQenUP8jiV6fHIzLqa42+ehJLqc4eiIwU1xLGDdJiTi3zJqb8BaXdirDpE1zkvolsbeu9O63DDn98opzQBwQyF3NTT4xK9sBCv0qsCbwoM1VykFlskfAnt+imaM3ssl5L3SzFdSjmWeRyFsgbsTK9Bq5x471nhRGjv4SQh7pWdxCVe4fL+T/GtQPdSzgCnG9KGlKTSufE+SM8BFiNfRQT3TALWY6OU+HFPrkC5/vmaEyYMnpcPzImnnj37zBUdnnM/mj0a1SSxy6hGps9xx3hl+ZwIDAQAB";
    private static final String
            APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC80p7S2u1Cy/Z26UyvcTa8ZN2MrTCSHOJzD+eFlSnGczW5yLJHpDlTp2uwoKvzl+BURFQpGXV0OdwbfY06ecQ4G/+F8Cf0EKNvmQlV/M++Mjfi1Yj4EPal5bXJrnpDRkwN7X90k5bi2AzAdrGT2rJPX7YA9/fbNxQibiNM2yaRkmF8Tun5n+IfFyRb3NiJegaOKEyW5KQcwzox8amXfl6dJOKV//WpJd1otmq0D7SA9bFH6no386T6esKIke68AKirPNpPwJS+fczm+Gn2cWKkBJmwKwiif33UMK+eVpX2V71fUJk9OxMv6ggpjptF45CD1WlZvihc3kM4m+6aOpcLAgMBAAECggEALJMP+TjDT8R0b0fN2ZDBWiH5hw8Paz60WnNDtW4sCXQDF9N/+peTDON18aFMVlnhFCN5NqaS6pgKFNdDsq0yHAjH/mdeFyiiXGLlKE5hAEY8mSjNh7oBb9JVYsH0jNMYeyU4tF1u/igAgqLCcuPqugAfKAVhlndfIm2bmbYWWcCq8QNCnWyBtN36hx8YEdtRj6nMYL1Ls36jLdVGWi0/kLbIPZr+wAnn4zW6XdCLDTrbiLan2Fi+12deFjycPS6vg/eFgq4+4b8VgEqM8e5keqBDzNuwBXP+avCOREhs+k4/FFJ+BnMIGVwKBFpvThWmnDIbMKHLVwrBwxEGgPHkWQKBgQD5R0+pCJ055PKX2MR4bfL76EwL0QHTbl+5JJ9buwvMWLBUQz1sReu3Q70oOcplW/EqHl/Fw3p+BEPdehqURB+5huWI3rQXYcxL/nLGt++CwkTQIBK9jW12puxMXZNMRn9ebnPw4Per46PEJfl/ImIbJRohKXqXrzcMSo6O/QTzBwKBgQDB6gCZo5ng+joBAH7MeahPlVclxppZIchQeoIbCZx00HAbBEoq0gg6R8MTMZB33ui/05wR8iv0+HYc8Ux41erAZvWEVkvSmKTfv/9SMEVwEqZp4rTY57Kz0E5Ye8ZcfSQmcJAa5nrtLIjte5dMvtV9WSju42LsHsi1iNqQguBm3QKBgQCja1CZ6//G+IThb0Y9/TaSVpOkG30q8uzmH1ApftIZQPs4Amy+EoiZOFtFh71b/Y54ojj/GUuwWXN0Opw6Hv79TaYkuHsv6PlZyJHOHL9z5Y/fMWeXxKPCaWP4HFB4bK8LZTW08IbttOqjqJGL+yp9yTD8FIk976wS7r3Ol6kq+QKBgARq5UqavIWwjaO6NClKWDg/6bVVmeyP5XVX5SDijirnGLa02U+yazeQrPQB/A2PCXRdSL/r6W5yPpaYNKrIDMoHTm6OXLnWemMSh6mCqgJMmnftDzulw59vDmnboAA5ZZpulAnY2FIQ4qmuWBsKeeiaIGGY0ocYiHACRyBlquENAoGBAJg54FKDIkJPLGmm+0SOdrh9xkpTVvNflo86zpumts2UPIBwDuxT67ysZNVrjMBvr24ua6xQvIPRCMaPC38lmOTCuJs19htLSLrk9CJ+/4vfXtp3bh1Ke0S6DqlZ9X3YTLTThbeYbpos+bGmHzsXmst+lEThScr1AVGEObw7StA2";
    private static final String APP_ID = "2021001197684310";

    @Override
    public void aliPayRequest() throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(
            URL,
            APP_ID,
            APP_PRIVATE_KEY,
            FORMAT,
            CHARSET,
            ALIPAY_PUBLIC_KEY,
            SIGN_TYPE
        );

        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest(); //创建API对应的request类
        request.setBizContent("");
        AlipayTradePrecreateResponse response = alipayClient.execute(request);
        Object o = parseResponse(response);
        System.out.print(response.getBody());
    }

    public Object parseResponse(AlipayTradePrecreateResponse response) {
        log.info("AliPayServiceImpl parseResponse: {}", response);

        return null;
    }

}
