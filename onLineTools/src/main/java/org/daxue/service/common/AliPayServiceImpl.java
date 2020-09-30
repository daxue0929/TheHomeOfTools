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

//    private static final String URL = "https://openapi.alipay.com/gateway.do";
//    private static final String APP_ID = "2021001196666298";
//    private static final String
//        APP_PRIVATE_KEY =
//        "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQDooOWJTQVgzU31gEKndy2CZhC3IoGcBnIRfZtbCWN5KtxgAWLKCwavojPbIdjbQPr8C/kOGSKbzOj/dU3kNZhyMlf7Uu0kNo4X0LqP+uuyOoXmZ2rODC6cMQo8cEe7S0bJkIx/Vox+p1m4eQJ2AvFwI25DdHj0aYTvJ/cRU6fvXVUC7zMT6a8/0fpXv7oPTW/2tdKrJkB/c7UKrLm1DamFkTS4nKwnfD+6VRbkPhyHXxL8vvDhHwBQWexUV5ESQawKZkhqOzYjxt65CZ1fstarKy0jLoh6otmZvIbKhjs33/a1EuvINNH+XG/3k3Dobjes+B4WWjP0Suz4j3M6XzDHAgMBAAECggEBAKuFxvj/o1GGz06O7ZaQ1ytomjaN6MbkMcMXvC7Zs1Cp+6eGHhMfIiTqEhYm1MCFHwoswcxVWCFMaxfApFf59Jdu61RSBqxG1WpV6tkyiAr3/7as1iFq9gsQVZ3Oo/VDQcRpIk7Zv+m69vp/rwLYlLC8TxbJkE2WZ//2lcNezVo9LQQ9a0ySNsO18cQWdnm6a03QcU6+VV409yIOj5s7LzajzJVEesrA54pTsFMm49JcFhEk22bqqj2gjQIgyWGKVZN9V+Pl4PHp7iHbm8c8Uld/pzrUWc7uL2F4uFFyWVl1MmoNYjiWeGJIzedAS1agOp6o92nZa6rnTwd2xXyBmQECgYEA91QJktPrlArxCZrf2igrZZc0U/dNwJJaliUo45lIyckC8MR9N6WmONkkuT4akeAwJ2SknbYfzyZ8kkgF96J534Snpsf0FqRj/B4otvlYfopVmpSRpffA7CYXukRmY2g0JqDTaYyaHjZ+IPf4Mu9RbMHmlKvvXaSYiefVkfNcVMECgYEA8Mjq3NXpgxCd56WH/eiXJejmcZmfnzu3MyOo5BMWScHGI91QxvoItDo/udjqw+pkPuEqRLIRrNrZYrjpT0FUtt2xmiLgsObmiP0XJAemJbckr5YgmF39HTqjkimcW69XUwNDsUm5fOb1zEp+tzPzumfVcC7rLx8vX3VwLsGTP4cCgYEAwBn24aNWjAM/mp0/l3ux0VNzInCoZJWIZKxyKO2LGqfVb9q+A3XXOLp4CqWRD5LY9A/4yEKITGZxRVFJyUDadmDbsvAFx3xh6JYoO45KTOb3fHw+8HER2JnxvgyYlkd+ki5CZu39WtAqgUL49d7qGJY2mW0+GzbX/+0g9h7WrUECgYEAxNUZ2WksuK2ux5yzrMakOKNJLnhM2lhwjGeMOtW3lJfJJ6xVyjK/RsWPLpe6YmmLhTN/4CRI+qr0phVO9DEN1WcpNj1ovHQk5LswXY27Ln2mibsJ7kR3E5vJ90P4w6J0mjHC9ny0Gvya1mPXbmATz7/t5QUV0LGHglt4V2B6xKUCgYEAi0KCvYscUsiBNmSZBUb/acRPazGHvTSZ2TI6T1zXUuL5ztBQ/Ic7Cl+fACC8TbNnu+9wbwIzoNOoi0mXwq0TQY5l3j7/uP8Vdb5BH4cUSzAucfZeIVOyEwJoRXgZOTvfpswGhhuoO1VBIPe1NZY5IvE/rpf6S8ozEzQjt2mfNOU=";
    private static final String FORMAT = "json";
    private static final String CHARSET = "UTF-8";
//    private static final String
//        ALIPAY_PUBLIC_KEY =
//        "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6KDliU0FYM1N9YBCp3ctgmYQtyKBnAZyEX2bWwljeSrcYAFiygsGr6Iz2yHY20D6/Av5Dhkim8zo/3VN5DWYcjJX+1LtJDaOF9C6j/rrsjqF5mdqzgwunDEKPHBHu0tGyZCMf1aMfqdZuHkCdgLxcCNuQ3R49GmE7yf3EVOn711VAu8zE+mvP9H6V7+6D01v9rXSqyZAf3O1Cqy5tQ2phZE0uJysJ3w/ulUW5D4ch18S/L7w4R8AUFnsVFeREkGsCmZIajs2I8beuQmdX7LWqystIy6IeqLZmbyGyoY7N9/2tRLryDTR/lxv95Nw6G43rPgeFloz9Ers+I9zOl8wxwIDAQAB";
    private static final String SIGN_TYPE = "RSA2";


    private static final String URL = "https://openapi.alipaydev.com/gateway.do";
    private static final String
        ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmH/wb1oyoMUTlunzf9eAElJwv9rgWCEUn1pBeX+YykuiXEyH8HQhQsfJ+NyS3lnNiNKFUoxsmGhalReh1tiYED2bbH0EK4kxUlWp7shEG4gMJjv4CU3z/sZ7Mz+s8RMjbUfv1++/tB44JSbWf+CBDxZxmkLU1qdHEX8RV52ataDIFSQyjRyA7W9fga9CE+RIk2ORKcADD8t3bCTB4/aO/2JpWUGrTcYCnIbf6RyWMLes3b1f1alVNLJhubJUCARXPe9j8TW0QdPk32Uh0ukn2QTNY1kzzNqqneEb6xh1UMeisqM48T/fL/XbR4dKji1B/1BOIZpZT/ffja7VJC5qHwIDAQAB";
    private static final String
        APP_PRIVATE_KEY =
        "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQDooOWJTQVgzU31gEKndy2CZhC3IoGcBnIRfZtbCWN5KtxgAWLKCwavojPbIdjbQPr8C/kOGSKbzOj/dU3kNZhyMlf7Uu0kNo4X0LqP+uuyOoXmZ2rODC6cMQo8cEe7S0bJkIx/Vox+p1m4eQJ2AvFwI25DdHj0aYTvJ/cRU6fvXVUC7zMT6a8/0fpXv7oPTW/2tdKrJkB/c7UKrLm1DamFkTS4nKwnfD+6VRbkPhyHXxL8vvDhHwBQWexUV5ESQawKZkhqOzYjxt65CZ1fstarKy0jLoh6otmZvIbKhjs33/a1EuvINNH+XG/3k3Dobjes+B4WWjP0Suz4j3M6XzDHAgMBAAECggEBAKuFxvj/o1GGz06O7ZaQ1ytomjaN6MbkMcMXvC7Zs1Cp+6eGHhMfIiTqEhYm1MCFHwoswcxVWCFMaxfApFf59Jdu61RSBqxG1WpV6tkyiAr3/7as1iFq9gsQVZ3Oo/VDQcRpIk7Zv+m69vp/rwLYlLC8TxbJkE2WZ//2lcNezVo9LQQ9a0ySNsO18cQWdnm6a03QcU6+VV409yIOj5s7LzajzJVEesrA54pTsFMm49JcFhEk22bqqj2gjQIgyWGKVZN9V+Pl4PHp7iHbm8c8Uld/pzrUWc7uL2F4uFFyWVl1MmoNYjiWeGJIzedAS1agOp6o92nZa6rnTwd2xXyBmQECgYEA91QJktPrlArxCZrf2igrZZc0U/dNwJJaliUo45lIyckC8MR9N6WmONkkuT4akeAwJ2SknbYfzyZ8kkgF96J534Snpsf0FqRj/B4otvlYfopVmpSRpffA7CYXukRmY2g0JqDTaYyaHjZ+IPf4Mu9RbMHmlKvvXaSYiefVkfNcVMECgYEA8Mjq3NXpgxCd56WH/eiXJejmcZmfnzu3MyOo5BMWScHGI91QxvoItDo/udjqw+pkPuEqRLIRrNrZYrjpT0FUtt2xmiLgsObmiP0XJAemJbckr5YgmF39HTqjkimcW69XUwNDsUm5fOb1zEp+tzPzumfVcC7rLx8vX3VwLsGTP4cCgYEAwBn24aNWjAM/mp0/l3ux0VNzInCoZJWIZKxyKO2LGqfVb9q+A3XXOLp4CqWRD5LY9A/4yEKITGZxRVFJyUDadmDbsvAFx3xh6JYoO45KTOb3fHw+8HER2JnxvgyYlkd+ki5CZu39WtAqgUL49d7qGJY2mW0+GzbX/+0g9h7WrUECgYEAxNUZ2WksuK2ux5yzrMakOKNJLnhM2lhwjGeMOtW3lJfJJ6xVyjK/RsWPLpe6YmmLhTN/4CRI+qr0phVO9DEN1WcpNj1ovHQk5LswXY27Ln2mibsJ7kR3E5vJ90P4w6J0mjHC9ny0Gvya1mPXbmATz7/t5QUV0LGHglt4V2B6xKUCgYEAi0KCvYscUsiBNmSZBUb/acRPazGHvTSZ2TI6T1zXUuL5ztBQ/Ic7Cl+fACC8TbNnu+9wbwIzoNOoi0mXwq0TQY5l3j7/uP8Vdb5BH4cUSzAucfZeIVOyEwJoRXgZOTvfpswGhhuoO1VBIPe1NZY5IvE/rpf6S8ozEzQjt2mfNOU=";
    private static final String APP_ID = "2016092800617544";

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
