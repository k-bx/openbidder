/*
 * Copyright 2012 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.openbidder.click;

import com.google.openbidder.api.click.ClickController;
import com.google.openbidder.api.testing.click.ClickTestUtil;
import com.google.openbidder.api.testing.click.TestClickRequestBuilder;
import com.google.openbidder.api.testing.click.TestClickResponseBuilder;
import com.google.openbidder.click.interceptor.SimpleClickInterceptor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for {@link SimpleClickInterceptor}.
 */
public class SimpleClickInterceptorTest {
  private ClickController controller;

  @Before
  public void setUp() {
    controller = ClickTestUtil.newClickController(new SimpleClickInterceptor());
  }

  @After
  public void tearDown() {
    if (controller != null) {
      controller.stopAsync().awaitTerminated();
    }
  }

  @Test
  public void testInterceptor() {
    controller.onRequest(
        TestClickRequestBuilder.create().build(), TestClickResponseBuilder.create().build());
  }
}
