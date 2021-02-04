package org.sean.proxy;

public class SomeService implements ISomeService {
    @Override
    public ResultBody doSomeService(String customer) {
        return new ResultBody("200", "success");
    }

    @Override
    public ResultBody doSomeProviderService() {
        return new ResultBody("200", "over");
    }
}
