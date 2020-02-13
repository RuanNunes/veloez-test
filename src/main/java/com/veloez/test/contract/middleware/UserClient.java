package com.veloez.test.contract.middleware;

import org.springframework.cloud.openfeign.FeignClient;

import com.veloez.test.contract.UserApi;

@FeignClient(name = "user", url = "${veloez.api.uri}")
public interface UserClient extends UserApi{

}
