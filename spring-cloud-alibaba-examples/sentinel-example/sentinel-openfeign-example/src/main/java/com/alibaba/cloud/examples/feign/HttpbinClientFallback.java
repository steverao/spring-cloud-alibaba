/*
 * Copyright 2013-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.cloud.examples.feign;


/**
 * When the service is blown, the fallback operation is performed.
 *
 * @author raozihao
 */
public class HttpbinClientFallback implements HttpbinClient {

	@Override
	public String delay() {
		return "delay degrade by sentinel";
	}

	@Override
	public String status404() {
		return "404 degrade by sentinel";
	}

	@Override
	public String status500() {
		return "500 degrade by sentinel";
	}

	@Override
	public String get() {
		return "get degrade by sentinel";
	}

	private Throwable throwable;

	HttpbinClientFallback(Throwable throwable) {
		this.throwable = throwable;
	}
}
