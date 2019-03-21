/*
 * Copyright 2017 the original author or authors.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        https://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package io.sk8s.sidecar;

import io.sk8s.sidecar.grpc.function.StringFunctionGrpc;

/**
 * @author David Turanski
 **/
public class GrpcAsyncDispatcher implements Dispatcher {

	private final StringFunctionGrpc.StringFunctionStub stub;

	public GrpcAsyncDispatcher(StringFunctionGrpc.StringFunctionStub stub) {
		this.stub = stub;
	}

	@Override
	public String dispatch(String input) throws Exception {
		return null;
	}
}
