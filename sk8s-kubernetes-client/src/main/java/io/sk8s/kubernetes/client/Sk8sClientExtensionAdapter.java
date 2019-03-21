
/*
 * Copyright 2017 the original author or authors.
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

package io.sk8s.kubernetes.client;

import io.fabric8.kubernetes.client.APIGroupExtensionAdapter;
import io.fabric8.kubernetes.client.Client;
import okhttp3.OkHttpClient;

public class Sk8sClientExtensionAdapter extends APIGroupExtensionAdapter<Sk8sClient> {

	@Override
	protected String getAPIGroupName() {
		return "extensions.sk8s.io";
	}

	@Override
	protected Sk8sClient newInstance(Client client) {
		return new DefaultSk8sClient(client.adapt(OkHttpClient.class), client.getConfiguration());
	}

	@Override
	public Class<Sk8sClient> getExtensionType() {
		return Sk8sClient.class;
	}
}
