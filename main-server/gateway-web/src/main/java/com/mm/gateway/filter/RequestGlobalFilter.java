package com.mm.gateway.filter;

import com.mm.base.constant.SecurityConstants;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author mory.lee
 */
@Component
public class RequestGlobalFilter implements GlobalFilter, Ordered {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// 清洗请求头中from 参数
		ServerHttpRequest request = exchange.getRequest().mutate()
				.headers(httpHeaders -> httpHeaders.remove(SecurityConstants.REQ_ROLE))
				.header(SecurityConstants.FROM, SecurityConstants.FROM_GATEWAY)
				.build();

		return chain.filter(exchange.mutate()
				.request(request.mutate()
						.build()).build());
	}

	@Override
	public int getOrder() {
		return -1000;
	}

}
