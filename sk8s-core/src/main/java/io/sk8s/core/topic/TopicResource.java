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

package io.sk8s.core.topic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.sk8s.core.resource.Resource;
import io.sk8s.core.topic.TopicResource.TopicSpec;

/**
 * @author Mark Fisher
 */
// todo: add these to the model (can be empty)
@JsonIgnoreProperties({ "status", "message" })
public class TopicResource extends Resource<TopicSpec> {

	public class TopicSpec {

		private String name;

		private int partitions;
	
		private boolean exposeRead;

		private boolean exposeWrite;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getPartitions() {
			return partitions;
		}

		public void setPartitions(int partitions) {
			this.partitions = partitions;
		}

		public boolean isExposeRead() {
			return exposeRead;
		}

		public void setExposeRead(boolean exposeRead) {
			this.exposeRead = exposeRead;
		}

		public boolean isExposeWrite() {
			return exposeWrite;
		}

		public void setExposeWrite(boolean exposeWrite) {
			this.exposeWrite = exposeWrite;
		}
	}
}
