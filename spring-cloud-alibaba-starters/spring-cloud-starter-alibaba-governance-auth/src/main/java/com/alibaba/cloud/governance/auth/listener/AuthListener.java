/*
 * Copyright 2022-2023 the original author or authors.
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

package com.alibaba.cloud.governance.auth.listener;

import com.alibaba.cloud.commons.governance.auth.rule.AuthRules;
import com.alibaba.cloud.commons.governance.event.AuthDataChangedEvent;
import com.alibaba.cloud.governance.auth.repository.AuthRepository;

import org.springframework.context.ApplicationListener;

/**
 * To receive the auth data when it is changed by user.
 *
 * @author musi
 * @author <a href="liuziming@buaa.edu.cn"></a>
 * @since 2.2.10-RC1
 */
public class AuthListener implements ApplicationListener<AuthDataChangedEvent> {

	private final AuthRepository authRepository;

	public AuthListener(AuthRepository authRepository) {
		this.authRepository = authRepository;
	}

	@Override
	public void onApplicationEvent(AuthDataChangedEvent event) {
		AuthRules authRules = event.getAuthRules();
		if (authRules.getAllowAuthRules() != null) {
			authRepository.setAllowAuthRule(authRules.getAllowAuthRules());
		}
		if (authRules.getDenyAuthRules() != null) {
			authRepository.setDenyAuthRules(authRules.getDenyAuthRules());
		}
		if (authRules.getJwtRules() != null) {
			authRepository.setJwtRule(authRules.getJwtRules());
		}
	}

}