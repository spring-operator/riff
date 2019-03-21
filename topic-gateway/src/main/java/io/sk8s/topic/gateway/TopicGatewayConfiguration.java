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

package io.sk8s.topic.gateway;

import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.instrument.messaging.MessagingSpanTextMapInjector;
import org.springframework.cloud.stream.binder.BinderFactory;
import org.springframework.cloud.stream.binding.BinderAwareChannelResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.router.AbstractMappingMessageRouter;
import org.springframework.integration.router.HeaderValueRouter;

/**
 * @author Mark Fisher
 * @author Thomas Risberg
 */
@Configuration
public class TopicGatewayConfiguration {

	@Bean
	public MessageTraceHandler messageTraceHandler(Tracer tracer, MessagingSpanTextMapInjector injector) {
		return new MessageTraceHandler(tracer, injector);
	}

	@Bean
	public MessagePublisher publisher(AbstractMappingMessageRouter mappingMessageRouter, MessageTraceHandler messageTraceHandler) {
		return new MessagePublisher(mappingMessageRouter, messageTraceHandler);
	}

	@Bean
	public AbstractMappingMessageRouter mappingMessageRouter(BinderFactory binderFactory, BinderAwareChannelResolver channelResolver) {
		AbstractMappingMessageRouter router = new HeaderValueRouter("topic");
		router.setResolutionRequired(true);
		router.setChannelResolver(new HeaderEmbeddingBinderAwareChannelResolver(binderFactory, channelResolver));
		return router;
	}
}
